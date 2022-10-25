package com.example.a01

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class DataFragment : Fragment() {
    private var entity: Entity = Entity("","","","")
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            entity= bundle.getParcelable("entity",entity.javaClass)!!
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_data, container, false)
        val button2 = view.findViewById<Button>(R.id.button2)
        view.findViewById<TextView>(R.id.Name).text = entity.name
        view.findViewById<TextView>(R.id.EstablishmentName).text = entity.establishment

        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val geoUri = "http://maps.google.com/maps?q=loc:".plus(entity.latitude).plus( ",").plus(entity.longitude)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
            startActivity(intent)
        }

        button2.setOnClickListener {
            findNavController().navigate(R.id.action_dataFragment_to_homeFragment)
        }
        return view
    }

}
