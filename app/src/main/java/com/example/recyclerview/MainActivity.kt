package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList= mutableListOf(
            Todo("Apple",false),
            Todo("Mango",true),
            Todo("Banana",true),
            Todo("Cherry",false),
            Todo("Appricot",false),
            Todo("Jelly",true),
            Todo("Oats",true)
        )

        val adapter=TodoAdapter(todoList)
        rvTodos.adapter=adapter
        rvTodos.layoutManager=LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val title=etTodo.text.toString()
            val todo=Todo(title,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}