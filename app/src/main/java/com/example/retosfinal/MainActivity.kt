package com.example.retosfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

const val REQUEST_NAV = 1


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnNavegador.setOnClickListener {
            val intent = Intent(
                this,
                juego_nav::class.java
            )//Inicializamos el intent con la clase
            startActivityForResult(intent, REQUEST_NAV)//Confirmacion del intent
        }
    }


}
