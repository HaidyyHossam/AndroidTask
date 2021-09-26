package com.example.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task.data.api.APIHelper
import com.example.task.data.api.RetrofitBuilder
import com.example.task.domain.categories
import com.example.task.domain.channels
import com.example.task.domain.courses
import com.example.task.domain.series
import com.example.task.ui.base.ViewModelFactory
import com.example.task.ui.main.MainViewModel
import com.example.task.utils.Status
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    private lateinit var CustomAdapter: CustomAdapter
    private lateinit var layoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
        mainRecyclerView.layoutManager = layoutManager
        CustomAdapter = CustomAdapter(arrayListOf(), arrayListOf())
        mainRecyclerView.adapter = CustomAdapter
        runAsync()
    }
    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
                this,
                ViewModelFactory(APIHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }
    fun runAsync() = GlobalScope.async {
        var allCategories = ArrayList<categories>()
        /*viewModel.getCategories { categories ->
            for(item in categories)
                allCategories.add(item)
            adapter = MainAdapter(this@MainActivity,allCategories)
            gridView.adapter = adapter
        }*/
        var allCourses = ArrayList<courses>()
        var allSeries = ArrayList<series>()

        viewModel.getChannels { channels ->
            for(item in channels[0].latestMedia)
            {
                allCourses.add(item)
            }
            Log.e("c",allCourses.size.toString())
            for(item in channels[0].series)
            {
                allSeries.add(item)
            }
            //CustomAdapter = CustomAdapter(allSeries,allCourses)
            retrieveList(allCourses);
        }
    }
    private fun retrieveList(courses:ArrayList<courses>) {
        CustomAdapter.apply {
            addCourses(courses)
            notifyDataSetChanged()
        }
    }
}