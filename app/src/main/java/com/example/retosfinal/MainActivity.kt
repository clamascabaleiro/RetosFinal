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
const val REQUEST_OPERACION = 2


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

        btnOperacion.setOnClickListener {
            val intent2 = Intent(
                this,
                Operacion::class.java
            )//Inicializamos el intent con la clase
            startActivityForResult(intent2, REQUEST_OPERACION)//Confirmacion del intent
        }




    }

    override fun onActivityResult(requestCode:Int,resultCode: Int, intent:Intent?){
        super.onActivityResult(requestCode, resultCode, intent)

        if (requestCode == REQUEST_NAV) {  //Reto de buscar con el navegador
            if (resultCode == Activity.RESULT_OK) {
                if ((intent?.getStringExtra("comprobar").toString()).equals("2009")) {  //Si lo que obtenemos del intent es 2009 es correcto
                    btnNavegador.setBackgroundColor(Color.GREEN) //Se pone el boton en verde para indicar que es correcto
                    toast("Buen trabajo!")
                } else {
                    btnNavegador.setBackgroundColor(Color.RED)  //Se pone el boton en rojo para indicar que fallo
                    toast("Has fallado...")
                }
                btnNavegador.setEnabled(false)
            }
        }

        if (requestCode == REQUEST_OPERACION) {  //Reto de la operacion
            if (resultCode == Activity.RESULT_OK) {
                if ((intent?.getStringExtra("comprobarOperacion").toString()).equals("36")) {  //Si lo que obtenemos del intent es 36 es correcto
                    btnOperacion.setBackgroundColor(Color.GREEN) //Se pone el boton en verde para indicar que es correcto
                    toast("Buen trabajo!")
                } else {
                    btnOperacion.setBackgroundColor(Color.RED)  //Se pone el boton en rojo para indicar que fallo
                    toast("Has fallado...")
                }
                btnOperacion.setEnabled(false)
            }
        }
    }


}
