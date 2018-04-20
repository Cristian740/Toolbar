package com.example.hp.toolbarclase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.EditText
import android.widget.ListView
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class SearchActivity : AppCompatActivity() {
    //declaracion de variables de la clase activity_search
    lateinit var buscador:EditText
    lateinit var list:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        //casteo del texto y del listview
        list = findViewById(R.id.listview)
        buscador = findViewById(R.id.buscar_animal)
        //cargando el toolbar
        setSupportActionBar(toolbar)
        // declarando un vector con elementos
        var animalNameList = arrayOf("Gato","Perro","Oso","Oso Pardo","Condor","Cocodrilo","Gallo","Zorro")
        //declarando un vector vacio que se llenara con el filtro de resultados en el listview, tomando en cuenta la clase AnimalNames
        var arrayList = ArrayList<AnimalNames>()

        //llenando el vector vacio
        for (s in animalNameList){
            arrayList.add(AnimalNames(s))
        }
        //declarando el adaptador que nos ayuda a realizar la lista dinamica
        var adapter = ListViewAdapter(this,arrayList)
        //llenando el adaptador del contenedor listview con los resultados de adapter
        list.adapter=adapter

        //dando la funcionalidad al textview de busqueda
        buscador.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            //como los resultados lo mostramos despues que introduce el texto, utilizamos afterTextChanged para mostrar los resultados buscados
            override fun afterTextChanged(s: Editable?) {
                adapter.filter(s.toString())
            }

        })
        //habilitando el boton del toolbar para que vuelva atras, es decir al activity anterior
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    // funcion que nos permite dar funcionalidad a los items (opciones) que tenemos en nuestro toolbar
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            //buscando el item de home, para finalizar el SearchActivity y volver al MainActivity
            if (item.itemId == android.R.id.home) {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
