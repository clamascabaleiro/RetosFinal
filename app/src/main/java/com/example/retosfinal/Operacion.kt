package com.example.retosfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import kotlinx.android.synthetic.main.activity_operacion.*

class Operacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operacion)

        val operacion = txtOperacion.text
        btnSalir.setOnClickListener {
            val intent = Intent()
            intent.putExtra("comprobarOperacion", operacion.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()

        }
    }
}
