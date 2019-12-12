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
const val REQUEST_CAMARA = 3


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

        btnCamara.setOnClickListener{
            val intent3 = Intent(
                this,
                Camara::class.java
            )
            startActivityForResult(intent3, REQUEST_CAMARA)
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

        if (requestCode == REQUEST_CAMARA) {
            if (resultCode == Activity.RESULT_OK) {
                //Dependiendo de si se ha recogido rojo o otro color saldra el resultado correcto o no. Si el valor que llega es un true es correcto
                if (intent?.getBooleanExtra("resp", false)!!.equals(true)) {
                    btnCamara.setBackgroundColor(Color.GREEN)
                    toast("Bien hecho!")
                } else {
                    btnCamara.setBackgroundColor(Color.RED)
                    toast("Has fallado...")
                }
                btnCamara.setEnabled(false)
            }
        }
    }


}
