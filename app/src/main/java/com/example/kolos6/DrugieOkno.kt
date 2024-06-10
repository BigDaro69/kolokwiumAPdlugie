package com.example.kolos6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DrugieOkno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_drugie_okno)

        val p1 = intent.getStringExtra("a")
        val p2 = intent.getStringExtra("b")
        val p3 = intent.getStringExtra("c")

        val t1 = findViewById<TextView>(R.id.wynik1)
        t1.text = p1

        val t2 = findViewById<TextView>(R.id.wynik2)
        t2.text = p2

        val t3 = findViewById<TextView>(R.id.wynik3)
        t3.text = p3

        val wroc = findViewById<Button>(R.id.wroc2)
        wroc.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}