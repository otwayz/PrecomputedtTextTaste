package com.zgc.precomputedtexttaste

import android.support.v4.text.PrecomputedTextCompat
import android.support.v4.widget.TextViewCompat
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_mock_list.view.*

/**
 * Created by Otway on 2018/12/5.
 */
class MockAdapter() : RecyclerView.Adapter<MockAdapter.ViewHolder>() {
    private val mDataList: MutableList<String> = mutableListOf()
    fun setDataList(dataList: List<String>) {
        mDataList.clear()
        mDataList.addAll(dataList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.item_mock_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = mDataList.size


    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        holder.bindData(mDataList[pos])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var textView: TextView = itemView.id_tv_data

        fun bindData(data: String) {
            val textFuture = PrecomputedTextCompat.getTextFuture(
                data,
                TextViewCompat.getTextMetricsParams(textView),
                /*optional custom executor*/ null
            )
            (textView as AppCompatTextView).setTextFuture(textFuture)
        }
    }
}