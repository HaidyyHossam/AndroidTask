package com.example.task

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import com.example.task.domain.categories

class MainAdapter(
        private val context: Context,
        private val categories: ArrayList<categories>?,
) : BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var button: Button
    override fun getCount(): Int {
        return categories!!.size
    }
    override fun getItem(position: Int): Any? {
        return null
    }
    override fun getItemId(position: Int): Long {
        return 0
    }
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View? {
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.customlayout, null)
        }
        button = convertView?.findViewById(R.id.catBtn)!!
        button.setText(categories!![position].name)
        return convertView
    }
}