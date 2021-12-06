package com.example.simpleapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class AboutFragment : Fragment() {
    lateinit var developersRecyclerView: RecyclerView
    lateinit var openYoutube: Button



    val developersNames:List<String> = listOf("Maxim", "Artem :)")






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        openYoutube=view.findViewById(R.id.open_youtube)



        developersRecyclerView = view.findViewById(R.id.developers_recycler_view)

        developersRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        developersRecyclerView.adapter=DeveloperAdapter(developersNames)

        openYoutube.setOnClickListener {
            val link= Uri.parse("https://www.youtube.com/watch?v=JxS5E-kZc2s&ab_channel=NoCATNoLiFE2")
            val intent=Intent(Intent.ACTION_VIEW,link)
            context?.startActivity(intent)
        }



        return view
    }

}