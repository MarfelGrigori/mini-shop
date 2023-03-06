package com.example.onlineshopsatriaadhipradana

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.onlineshopsatriaadhipradana.databinding.FragmentHomeBinding
import sm.tosk.android.common.viewmodel.getViewModelFactory

class HomeFragment : BindingFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
){

    private val viewModel: HomeViewModel by activityViewModels<HomeViewModel> { getViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}