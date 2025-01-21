package com.example.assessmentrecyclerviewget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {
    private lateinit var user: UserData

    companion object {
        fun newInstance(user: UserData): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putParcelable("user", user)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        arguments?.let { args ->
            user = args.get("user") as UserData
        }
        // Set user data to views in the layout
        val textViewName = view.findViewById<TextView>(R.id.fragmentTextViewName)
        textViewName.text = "Name: ${user.name}"

        val textViewUsername = view.findViewById<TextView>(R.id.fragmentTextViewUsername)
        textViewUsername.text = "Username: ${user.username}"

        val textViewEmail = view.findViewById<TextView>(R.id.fragmentTextViewEmail)
        textViewEmail.text = "Email: ${user.email}"

        return view
    }
}