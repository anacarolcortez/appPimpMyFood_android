package com.dio.pimpmyfood

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReceitaDetail : AppCompatActivity() {
    private var receita: Receita? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalhe_receita)

        getLista()
        bindView()
    }

    private fun getLista(){
        receita = intent.getParcelableExtra(EXTRA_RECEITA)
    }

    private fun bindView(){
        findViewById<TextView>(R.id.titleDetail).text = receita?.titulo
        findViewById<TextView>(R.id.ingredientsDetail).text = receita?.ingredientes
        findViewById<TextView>(R.id.preaprationDetail).text = receita?.preparo
        findViewById<TextView>(R.id.authorDetail).text = receita?.autor
        receita?.foto?.let { findViewById<ImageView>(R.id.photoDetail).setImageResource(it) }
    }

    companion object {
        const val EXTRA_RECEITA: String = "EXTRA_RECEITA"
    }
}