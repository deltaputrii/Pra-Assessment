package com.d3if4201.praassessment


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.d3if4201.praassessment.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment(val root: View?) : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.main = this
        binding.btnPersegiPanjang.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_mainFragment_to_persegiPanjang)
        }
        binding.btnSegitiga.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_mainFragment_to_segitiga)
        }
        setHasOptionsMenu(true)
        return binding.root
        }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item!!,
            view!!.findNavController()
        ) || super.onOptionsItemSelected(item)
    }
}
