package com.dio.pimpmyfood

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dio.pimpmyfood.ReceitaDetail.Companion.EXTRA_RECEITA

class ListaActivity : AppCompatActivity(), ClickReceita {
    private val rvlist: RecyclerView by lazy{
        findViewById<RecyclerView>(R.id.rv_list)
    }
    private val adapter = ReceitaAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listareceitas)

        bindView()
        updateList()
    }

    private fun bindView(){
        rvlist.adapter = adapter
        rvlist.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList(){
        adapter.updateList(
                arrayListOf(
                        Receita(
                                1,
                                "Torta com talos de acelga e champignons",
                                "Talos de acelga\nChampignons\nQueijo muçarela\n2 lâminas de massa folhada\n1 ovo batido\nAzeite e temperos a gosto",
                                "Cozinhe os talos com água e um pouco de sal. Deixe-os esfriar e escorra-as bem. Lave bem os champignons e corte-os em lâminas finas. Refogue-os em um pouco de azeite. Misture os champignons com os talos de acelga cortadas e tempere com sal e pimenta a gosto. Unte com azeite uma forma para torta e abra uma lâmina de massa folhada. Coloque sobre ela o preparado de acelga e champignons. Corte o queijo em pedaços e coloque-os por cima, antes de tampar a torta com a segunda lâmina de massa. Pincele com ovo batido a massa e cozinhe a torta por 30 minutos no forno até que esteja dourada.",
                                "GreenMe",
                                R.drawable.tortataloacelga
                        ),
                        Receita(
                                2,
                                "Croquetes com folhas de beterraba",
                                "Folhas de beterraba\n1 ovo\n1 colher de queijo ralado\n1 colher de chá de amido de milho\nSal e pimenta a gosto\nFarinha de rosca",
                                "Lave as folhas da betarraba e ferva-as em água. Depois, coloque-as no coador para escorrer a água. Tire toda a umidade apertando-as bem com as mãos e usando um pano de prato limpo. Quando estiverem bem secas, triture as folhas e coloque-as em um recipiente com o ovo, o sal e a pimenta. Misture bem e coloque o queijo ralado e a amido de milho. Coloque um pouco da mistura na mão e faça pequenas bolinhas. Passe-as na farinha de rosca. Frite-as ou coloque-as no forno até que fiquem bem crocantes e douradas.",
                                "GreenMe",
                                R.drawable.croquetebeterraba
                        ),
                        Receita(
                                3,
                                "Carne de casca de banana",
                                "Casca de 3 bananas cozidas no sal\n1/2 cebola picada\n2 dentes de alho picados\nAzeite\n1 pimentão vermelho\n1 pimentão amarelo\nSalsinha picada a gosto\nCebolinha picada a gosto\n3 folhas de louro",
                                "Refogue o alho, a cebola e o louro na panela com um pouco de sal e azeite. Pique as cascas da banana cozidas em cubinhos e coloque na panela com o refogado. Acrescente os pimentões, o óregano e 3 gotinhas de fumaça líquida. Deixe cozinhar por cerca de 15 minutos. Ao final, adicione a salsinha e a cebolinha. Se quiser, coloque molho de tomate. Não esqueça de retirar os louros. Sirva.",
                                "Dayse Paparoto",
                                R.drawable.carnecascabanana
                        )
                )
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun showToast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.mnPesquisar -> {
                showToast("Menu Pesquisar em implementação")
                true
            }
            R.id.mnAdicionar -> {
                showToast("Menu Adicionar em implementação")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun clickCardReceita(receita: Receita) {
        val intent = Intent(this, ReceitaDetail::class.java)
        intent.putExtra(EXTRA_RECEITA, receita)
        startActivity(intent)
    }

}