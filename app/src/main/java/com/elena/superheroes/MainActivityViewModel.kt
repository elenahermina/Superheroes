package com.elena.superheroes

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivityViewModel: ViewModel() {


    private fun getAvengerList() : List<Avenger>{
        val personaje1 = Avenger("Captain America", R.mipmap.america, tipoBueno = false)
        val personaje2 = Avenger("Gamora",  R.mipmap.gamora, tipoBueno = true)
        val personaje3 = Avenger("Marvel",  R.mipmap.marvel, tipoBueno = false)
        val personaje4 = Avenger("Hulk", R.mipmap.hulk, tipoBueno = false)
        val personaje5 = Avenger("Ironman",  R.mipmap.ironman,tipoBueno = true)
        val personaje6 = Avenger("La Viuda Negra",  R.mipmap.laviudanegra,tipoBueno = false)
        val personaje7 = Avenger("Gamora",  R.mipmap.panther,tipoBueno = true)
        val personaje8= Avenger("Gamora",  R.mipmap.spiderman,tipoBueno = true)
        val personaje9 = Avenger("Gamora",  R.mipmap.strange, tipoBueno = true)
        val personaje10 = Avenger("Gamora",  R.mipmap.thor, tipoBueno = false)

        return listOf(personaje1,personaje2,personaje3,personaje4,personaje5,personaje6, personaje7, personaje8, personaje9, personaje10)
    }
    fun buenos() : List<Avenger> {
        return getAvengerList().filter { it.tipoBueno }
    }
    fun malos() : List<Avenger> {
        return getAvengerList().subList(0,4)
    }


}