package com.example.todolist

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val INPUT_TAG = "input_dialog"
    }

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* リストを20コ作成  */
        val listView = ListView(this)
        setContentView(listView)
        val items = Array(20, { i -> "Title-$i" })
        val arrayAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, items)
        listView.setAdapter(arrayAdapter)

        /* 値をセット */
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.inputStepCount.observe(this, Observer { items[0] = it.toString() })

        /* 入力ダイアログを呼び出し */
        myListView.setOnItemClickListener { _, view, _, _ ->
            InputDialogFragment().show(supportFragmentManager, INPUT_TAG)
        }

    }
}
