package com.example.hp.toolbarclase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //estamos cargando el menu
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    // funcion que nos permite dar funcionalidad a los items (opciones) que tenemos en nuestro toolbar
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var msg = ""
        when (item?.itemId){
            R.id.borrar -> msg="Borrar"
            R.id.editar -> msg="Editar"
            R.id.notificar -> msg="Notificar"
            R.id.action_search -> {
                msg="Buscar"
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)
            }
        }
        Toast.makeText(this, msg+"",Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }
}
