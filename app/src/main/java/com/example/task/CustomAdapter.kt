package com.example.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task.domain.courses
import com.example.task.domain.series

class CustomAdapter (
        private val series: ArrayList<series>?,
        private val courses: ArrayList<courses>?,
): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var imageView: ImageView
        lateinit var name: TextView

        init {
            //imageView = view.findViewById(R.id.imageCorurseAsset)!!
            name = view.findViewById(R.id.courseName)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val convertView = LayoutInflater.from(viewGroup.context).inflate(R.layout.customcourselayout, viewGroup, false)

        return  ViewHolder(convertView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = (courses!![position].title)
    }

    override fun getItemCount(): Int {
        return courses?.size!!
    }
    fun addCourses(users: ArrayList<courses>) {
        this.courses.apply {
            this!!.clear()
            addAll(users)
        }

    }
}