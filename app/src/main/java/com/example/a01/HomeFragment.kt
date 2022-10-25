package com.example.a01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val name =view.findViewById<EditText>(R.id.Name).text.toString().trim()

            val establishmentName =view.findViewById<EditText>(R.id.EstablishmentName).text.
            toString().trim()

            val latitude = view.findViewById<EditText>(R.id.latitude).text.toString().trim()

            val longitude = view.findViewById<EditText>(R.id.longitude).text.toString().trim()

            if (name.isNotEmpty() && establishmentName.isNotEmpty() && latitude.isNotEmpty() && longitude.isNotEmpty())
            {
                val entity = Entity(name, establishmentName,latitude,longitude)
                val bundle = bundleOf("entity" to entity)
                view.findNavController().navigate(R.id.action_homeFragment_to_dataFragment,bundle)
            }else
            {
                Toast.makeText(activity,"Neplatne udaje", Toast.LENGTH_SHORT).show()
            }


        }
        return view
    }

}