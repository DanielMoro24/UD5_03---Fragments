package com.example.demo004

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo004.databinding.FragmentRepositoryListBinding
import com.example.demo004.model.Repos
import com.example.demo004.network.PunkApiSevice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RepositoryListFragment : Fragment() {
    private var _binding: FragmentRepositoryListBinding? = null
    private val binding
    get() = _binding !!
    private  val adapter = RepoAdapter { repo ->
        val action =
            RepositoryListFragmentDirections.actionRepositoryListFragmentToRepositoryDetailFragment(
                repoName = repo.name.first,
                repoImagen = repo.picture.medium,
                repoTitle = repo.name.title,
                repoLast = repo.name.last,
                repoAge = repo.dob.age,
                repoDate = repo.dob.date,
                repoCountry = repo.location.country
            )
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvRepo.adapter = adapter
        binding.rvRepo.layoutManager = LinearLayoutManager(context)
        requestData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun requestData(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(PunkApiSevice::class.java)
        service.getAllRepos().enqueue(object : Callback<Repos>{
            override fun onResponse(call: Call<Repos>, response: Response<Repos>) {
                if (response.isSuccessful) {
                    Log.d("getAllRepos", "repos:${response.body()}")
                    adapter.submitList(response.body()?.results)
                }else{
                    showError()
                }
            }

            override fun onFailure(call: Call<Repos>, t: Throwable) {
                Log.d("OnFailure", "error ${t.message}", t)
            }
        })
    }
    private fun showError(){
        Toast.makeText(context, "Error en la peticion", Toast.LENGTH_SHORT).show()
    }
}