package com.zgc.precomputedtexttaste

import android.content.Intent
import android.os.Bundle
import android.support.v4.text.PrecomputedTextCompat
import android.support.v4.widget.TextViewCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.zgc.precomputedtexttaste.second.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.id_tv_summary) as TextView

        val params: PrecomputedTextCompat.Params = TextViewCompat.getTextMetricsParams(textView);
        val ref = WeakReference(textView)
        val executor = Executors.newSingleThreadScheduledExecutor()
        executor.execute {
            val text = PrecomputedTextCompat.create("Hello precomputed text!", params)
            val view = ref.get()
            view?.post {
                val get = ref.get()
                get?.text = text
            }
        }

        val stringArray = resources.getStringArray(R.array.mock_data).toList()
        val mockAdapter = MockAdapter()
        mockAdapter.setDataList(stringArray)
        id_recycler_view.adapter = mockAdapter
        id_recycler_view.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        id_recycler_view.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.id_change) {
            startActivity(Intent(this, SecondActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
