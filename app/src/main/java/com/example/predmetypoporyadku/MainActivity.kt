package com.example.predmetypoporyadku

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputItem = findViewById<EditText>(R.id.inputItem)
        val addButton = findViewById<Button>(R.id.addButton)
        val sortButton = findViewById<Button>(R.id.sortButton)
        val sortedList = findViewById<TextView>(R.id.sortedList)

        // Добавление предметов
        addButton.setOnClickListener {
            val item = inputItem.text.toString()
            if (item.isNotBlank()) {
                items.add(item)
                inputItem.text.clear()
                updateList(sortedList)
            }
        }

        // Сортировка предметов
        sortButton.setOnClickListener {
            items.sort()
            updateList(sortedList)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateList(sortedList: TextView) {
        sortedList.text = "Список: \n" + items.joinToString("\n")
    }
}
