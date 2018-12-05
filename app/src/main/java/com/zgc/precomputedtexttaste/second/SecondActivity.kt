package com.zgc.precomputedtexttaste.second

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.zgc.precomputedtexttaste.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Otway on 2018/12/5.
 */
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val stringArray = resources.getStringArray(R.array.mock_data).toList()
        val mockAdapter = SecondAdapter()
        mockAdapter.setDataList(stringArray)
        id_recycler_view.adapter = mockAdapter
        id_recycler_view.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        id_recycler_view.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
    }
}
