package com.example.examensqlite

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textoMochila: TextView
    private lateinit var anadirArticulos: Button
    private lateinit var visualizarArticulos: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textoMochila = findViewById(R.id.textView)
        anadirArticulos = findViewById(R.id.button)
        visualizarArticulos = findViewById(R.id.button2)

        val dbHelper = DatabaseHelper(this)

        anadirArticulos.setOnClickListener() {

        }

        visualizarArticulos.setOnClickListener() {

        }

    }
}

//Clase DatabaseHelper
class DatabaseHelper(MainActivity: MainActivity): SQLiteOpenHelper(MainActivity, DATABASE, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE = "Articulos.db"
        private const val TABLA_ARTICULO = "articulo"
        private const val KEY_ID = "_id"
        private const val COLUMN_TIPO_ARTICULO = "tipoArticulo"
        private const val COLUMN_NOMBRE = "nombre"
        private const val COLUMN_PESO = "peso"
        private const val COLUMN_PRECIO = "precio"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLA_ARTICULO ($KEY_ID INTEGER PRIMARY KEY," +
                "$COLUMN_TIPO_ARTICULO TEXT, $COLUMN_NOMBRE TEXT, $COLUMN_PESO INTEGER, " +
                "$COLUMN_PRECIO INTEGER)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLA_ARTICULO")
        onCreate(db)
    }

    fun consulta1(db: SQLiteDatabase) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            val consulta = db.execSQL("")
        }
        db.insert(TABLA_ARTICULO, null, values)
        db.close()
    }

    fun consulta2(db: SQLiteDatabase) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            val consulta = db.execSQL("")
        }
        db.insert(TABLA_ARTICULO, null, values)
        db.close()
    }

}