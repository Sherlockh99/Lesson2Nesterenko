package com.sherlock.gb.kotlin.lesson2nesterenko.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import com.sherlock.gb.kotlin.lesson2nesterenko.R
import com.sherlock.gb.kotlin.lesson2nesterenko.databinding.FragmentMainBinding
import com.sherlock.gb.kotlin.lesson2nesterenko.viewmodel.AppState

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding

    override fun onDestroy() {
        super.onDestroy()
        //binding = null
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
        //return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * две следующие строки взаимозаменяемы
         */
        //binding.btOne.setOnClickListener{}
        //view.findViewById<Button>(R.id.btOne).setOnClickListener{
        //}

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //val observer = Observer<Any>{renderData(it)}
        val observer = object:Observer<AppState>{
            override fun onChanged(data: AppState) {
                renderData(data)
            }
        }
        viewModel.getData().observe(viewLifecycleOwner,observer)
        viewModel.getWeather()
    }

    private fun renderData(data:AppState){
        when(data){
            is AppState.Error -> {
                binding.loadingLayout.visibility = View.GONE
                binding.message.text = "Не получилось ${data.error}"
            }
            is AppState.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Success -> {
                binding.loadingLayout.visibility = View.GONE
                binding.message.text = "Получилось!"
                Toast.makeText(requireContext(),"WORK",Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }


}