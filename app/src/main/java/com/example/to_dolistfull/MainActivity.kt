package com.example.to_dolistfull

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val userData : EditText = findViewById(R.id.editTextText);
        val button : Button = findViewById(R.id.button);

        // чтобы добавить в листвью нам надо добавить
        // адаптер(изнач масс) где опишем всё
        val todos : MutableList<String> = mutableListOf();
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        listView.adapter = adapter;

        listView.setOnItemClickListener { parent, view, position, id ->
            val text = listView.getItemAtPosition(position).toString()
            adapter.remove(text)

            Toast.makeText(this, "Deleted text: $text", Toast.LENGTH_LONG).show()
        }


        button.setOnClickListener{
            val text = userData.text.toString().trim()

            if (text != ""){
                adapter.insert(text, 0)
            }
        }
    }

}

