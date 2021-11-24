package com.example.demo004

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.demo004.databinding.FragmentRepositoryDetailBinding
import com.example.demo004.extensions.imageUrl
import com.example.demo004.model.Repos
import com.example.demo004.network.PunkApiSevice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryDetailFragment : Fragment() {
    private var _binding: FragmentRepositoryDetailBinding? = null
    private val binding
        get() = _binding !!

    private val args: RepositoryDetailFragmentArgs by navArgs()

    private var repoName: String = ""
    private var repoImagen: String = ""
    private var repoLast: String = ""
    private var repoTitle: String = ""
    private var repoCountry: String = ""
    private var repoAge: String = ""
    private var repoDate: String = ""



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentRepositoryDetailBinding.inflate(inflater, container, false)
        return binding.root


    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvNombre.text = "$repoTitle $repoName $repoLast"
        binding.tvEdad.text = repoAge
        binding.tvFecha.text = repoDate
        binding.tvPais.text = repoCountry
        binding.ivRepoPicture.imageUrl(repoImagen)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            repoName = it.getString("repoName").toString()
            repoImagen = it.getString("repoImagen").toString()
            repoLast = it.getString("repoLast").toString()
            repoTitle = it.getString("repoTitle").toString()
            repoCountry = it.getString("repoCountry").toString()
            repoAge = it.get("repoAge").toString()
            repoDate = it.getString("repoDate").toString()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}