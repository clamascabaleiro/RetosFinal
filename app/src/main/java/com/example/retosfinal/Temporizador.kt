package com.example.retosfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_temporizador.*
import android.widget.Toast
import org.jetbrains.anko.toast


class Temporizador : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temporizador)

        btnIniciar.setOnClickListener{
            val tiempoInicio = (((System.currentTimeMillis())/1000).toInt()+10) //Hay que dividirlos entre mil para que funcione porque sino cogia un numero muy exxacto y era imposible que diera correcto
            btnIniciar.setEnabled(false) //Una vez que le das al boton no puedes darle de nuevo
            intent.putExtra("tiempoInicio",tiempoInicio)
            toast("Comienza el tiempo")
        }

        btnParar.setOnClickListener{
            val tiempoFinal = ((System.currentTimeMillis())/1000).toInt()
            intent.putExtra("tiempoFinal", tiempoFinal)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}
