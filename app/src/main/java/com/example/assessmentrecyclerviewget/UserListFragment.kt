package com.example.assessmentrecyclerviewget

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userData: List<UserData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_list, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        userData = emptyList() // Initialize as empty list

        fetchData()
        return view
    }

    private fun fetchData() {
        val makeCall = ApiClient.retrofitBuilder.getUsersData()
        makeCall.enqueue(object : Callback<List<UserData>> {
            override fun onResponse(
                call: Call<List<UserData>>?, response: Response<List<UserData>>?
            ) {
                val users = response?.body()
                if (users != null) {
                    userData = users
                    recyclerView.adapter =
                        UserAdapter(userData, this@UserListFragment) // Pass the fragment
                    Log.i("vinTag onSuccess: ", userData.toString())
                } else {
                    Log.i("vinTag onSuccess: ", "No data received")
                }
            }

            override fun onFailure(call: Call<List<UserData>>?, t: Throwable?) {
                Log.e("vinTag error: ", "onFailure", t) // Log the throwable
            }
        })
    }
}