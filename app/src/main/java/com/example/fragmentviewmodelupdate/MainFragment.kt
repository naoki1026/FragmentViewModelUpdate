package com.example.fragmentviewmodelupdate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentviewmodelupdate.databinding.FragmentMainBinding
import org.w3c.dom.Text
import java.util.Observer

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainViewModel : MainViewModel

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        val msgObserver = androidx.lifecycle.Observer<String> { newMessage ->
            binding.message.setText(newMessage, TextView.BufferType.NORMAL)
        }
        mainViewModel.message.observe(viewLifecycleOwner, msgObserver)

        val sdMsgObserver = androidx.lifecycle.Observer<String> { newMessage ->
            binding.sdMessage.setText(newMessage, TextView.BufferType.NORMAL)
        }
        mainViewModel.share_data.value!!.share_message
            .observe(viewLifecycleOwner, sdMsgObserver)

        binding.button.setOnClickListener {
            mainViewModel.count()
            mainViewModel.message.value = "<< CHANGE by 1st [${mainViewModel.count.value}] >>"
            mainViewModel.share_data.value!!.count()
            mainViewModel.share_data.value!!.share_message.value =
                "<< CHANGE by 1st [${mainViewModel.share_data.value!!.share_count.value}] >>"
        }

        return binding.root
    }
}