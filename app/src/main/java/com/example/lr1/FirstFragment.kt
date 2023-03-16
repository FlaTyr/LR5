package com.example.lr1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.creyc.test.PhonesData



class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private val myAdapter = PhonesAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_first, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerView)
        loadData()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = myAdapter

        return root
    }

    private fun loadData(){
        myAdapter.setupPhones(PhonesData.phonesArr)
    }
}