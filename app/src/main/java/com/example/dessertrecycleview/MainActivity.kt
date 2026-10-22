package com.example.dessertrecycleview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val desserts = listOf(
            Dessert("Donuts are glazed and sprinkled with candy.", R.drawable.donut_circle, "#C1E8C5"),
            Dessert("Ice cream sandwiches have chocolate wafers and vanilla filling.", R.drawable.icecream_circle, "#BBEOF8"),
            Dessert("Froyo is premium self-serve frozen yogurt.", R.drawable.froyo_circle, "#E4BCDE")
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DessertAdapter(desserts)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}