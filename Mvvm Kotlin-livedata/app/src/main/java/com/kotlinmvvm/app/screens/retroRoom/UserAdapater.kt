package com.kotlinmvvm.app.screens.retroRoom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinmvvm.app.R
import com.kotlinmvvm.app.models.users.DataItem
import kotlinx.android.synthetic.main.adp_person_item.view.*

import javax.inject.Inject

class UserAdapater @Inject
constructor(
    private val context: Context, private var categoryList: List<DataItem>,
    private val listener: View.OnClickListener?
) : RecyclerView.Adapter<UserAdapater.CategoryViewHolder>() {
    private var layoutInflater: LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): CategoryViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        val view = layoutInflater!!.inflate(R.layout.adp_person_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindForecast(categoryList.get(position))
    }

    override fun getItemCount(): Int {
        return categoryList!!.size
    }

    fun getCategoryList(): List<DataItem>? {
        return categoryList
    }

    fun setCategoryList(categories: List<DataItem>) {
        this.categoryList = categories
        notifyDataSetChanged()
    }


    inner class CategoryViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bindForecast(data: DataItem) {
            itemView.name.text = data.first_name + " " + data.last_name
            itemView.email.text = data.email
        }
    }


}
