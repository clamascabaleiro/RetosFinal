package com.example.retosfinal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_juego_nav.*
import org.jetbrains.anko.browse

class juego_nav : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_nav)

        btnPista.setOnClickListener {
            browse("https://es.wikipedia.org/wiki/League_of_Legends")
        }

        //Recogemos el texto que se introduce para comprobar si es correcto

        val respuesta = txtRespuesta.text
        btnComprobar.setOnClickListener {
            val intent = Intent()
            intent.putExtra("comprobar", respuesta.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }


    }
}
