package com.sherlock.gb.kotlin.lesson2nesterenko.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.sherlock.gb.kotlin.lesson2nesterenko.R
import com.sherlock.gb.kotlin.lesson2nesterenko.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    //lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //binding = FragmentMainBinding.inflate(inflater,container,false)
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //val observer = Observer<Any>{renderData(it)}
        val observer = object:Observer<Any>{
            override fun onChanged(data: Any) {
                renderData(data)
            }
        }
        viewModel.getData().observe(viewLifecycleOwner,observer)
        viewModel.getWeather()
    }

    private fun renderData(data:Any){
        Toast.makeText(requireContext(),"WORK",Toast.LENGTH_SHORT).show()
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