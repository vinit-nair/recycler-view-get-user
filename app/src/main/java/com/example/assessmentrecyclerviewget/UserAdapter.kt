package com.example.assessmentrecyclerviewget

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val users: List<UserData>, private val fragment: Fragment) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewId: TextView = itemView.findViewById(R.id.textViewId)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewUsername: TextView = itemView.findViewById(R.id.textViewUsername)
        val textViewEmail: TextView = itemView.findViewById(R.id.textViewEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false)
        return UserViewHolder(view)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.textViewId.text = user.name
        holder.textViewName.text = "Name: ${user.name}"
        holder.textViewUsername.text = "UserName: ${user.username}"
        holder.textViewEmail.text = "Email: ${user.email}"

        holder.itemView.setOnClickListener {
            val detailFragment = DetailFragment.newInstance(user)
            val transaction = fragment.parentFragmentManager.beginTransaction()
            transaction.replace(R.id.recyclerView, detailFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    override fun getItemCount(): Int = users.size


}