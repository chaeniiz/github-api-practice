package com.chaeniiz.githubapipractice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), StargazerAdapter.StargazerClickListener {
    var stargazerList: ArrayList<Stargazer> = ArrayList()

    override fun getItem(position: Int) {
        val alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle(stargazerList.get(position).name)
        alertDialog.setPositiveButton("OK") { dialog, which ->
            Toast.makeText(this@MainActivity, "OK", Toast.LENGTH_SHORT).show()
        }
        alertDialog.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        var apiService: ApiService = ApiClient().getApiClient()!!.create(ApiService::class.java)

        val call: Call<ArrayList<Stargazer>> = apiService.getStargazer("googlesamples")

        call.enqueue(object : Callback<ArrayList<Stargazer>> {
            override fun onResponse(call: Call<ArrayList<Stargazer>>?, response: Response<ArrayList<Stargazer>>?) {
                stargazerList = response?.body()!!
                var temp = response.body()!!
                temp.addAll(stargazerList)

                recyclerView.adapter = StargazerAdapter(temp, this@MainActivity)
            }

            override fun onFailure(call: Call<ArrayList<Stargazer>>?, t: Throwable?) {
            }
        })

    }
}
