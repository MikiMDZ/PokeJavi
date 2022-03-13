package com.example.pokedesdecero

import kotlin.random.Random

object BonusA{
  var bonusrecibe=1.0
    var bonushace=1.0

}
object BonusB{
    var bonusrecibe=1.0
    var bonushace=1.0

}

data class Pokemon(
    val nombre: String,
    var nivel: Int,
    val vidatot: Int,
    val image: String,
    val genero: Char,
    var id:Int,
    var estado:String,
    var vidaRestante: Int = vidatot,
    var bol: Boolean = false,
    var seleccionado:Int=0


) {
    fun pokemonMuerte(): Boolean {
        var vivo = true
        if (vidaRestante <= 0) vivo = false

        return vivo
    }

    fun recibirAtaque(dano: Int) {
        var ataque = 0
        var ataque2 = 0
        if (this.estado == "Envenenado"){
            if (this.vidaRestante > 10) {
                vidaRestante -= 10
                BonusA.bonushace=1.0
                BonusA.bonusrecibe=1.0

            } else
                vidaRestante = 0}else

            if (this.estado == "Quemado"){
                BonusA.bonusrecibe = 1.5
                BonusA.bonushace=1.0
            }


            else if (this.estado == "Congelado"){
                BonusA.bonushace = 0.5
                BonusA.bonusrecibe=1.0
            }
            else{
                BonusA.bonushace=1.0
                BonusA.bonusrecibe=1.0}

        if (BonusB.bonushace == 0.5) {
            if (this.pokemonMuerte()) if (dano == 1) if (vidaRestante - 20 * BonusB.bonushace * BonusA.bonusrecibe < 0) vidaRestante =
                0
            else {
                vidaRestante -= (20 * BonusA.bonusrecibe * BonusB.bonushace).toInt()
                Danos.danorecibido += (20 * BonusA.bonusrecibe * BonusB.bonushace).toInt()
            }
            else if (dano == 2) ataque = Random.nextInt(10, 26)
            if (vidaRestante - ataque * BonusA.bonusrecibe * BonusB.bonushace < 0) vidaRestante = 0
            else {
                vidaRestante -= (ataque * BonusA.bonusrecibe * BonusB.bonushace).toInt()
                Danos.danorecibido += (ataque * BonusA.bonusrecibe * BonusB.bonushace).toInt()
            }
            if (dano == 3) ataque2 = Random.nextInt(0, 51)
            if (vidaRestante - ataque2 * BonusA.bonusrecibe * BonusB.bonushace < 0) vidaRestante = 0
            else {
                vidaRestante -= (ataque2 * BonusA.bonusrecibe * BonusB.bonushace).toInt()
                Danos.danorecibido += (ataque2 * BonusA.bonusrecibe * BonusB.bonushace).toInt()
            }
        } else {
            if (this.pokemonMuerte()) if (dano == 1) if (vidaRestante - 20*BonusB.bonushace * BonusA.bonusrecibe < 0) vidaRestante = 0
            else {
                vidaRestante -= (20 * BonusA.bonusrecibe).toInt()
                Danos.danorecibido += (20 * BonusA.bonusrecibe).toInt()
            }
            else if (dano == 2) ataque = Random.nextInt(10, 26)
            if (vidaRestante - ataque * BonusA.bonusrecibe < 0) vidaRestante = 0
            else {
                vidaRestante -= (ataque * BonusA.bonusrecibe).toInt()
                Danos.danorecibido += (ataque * BonusA.bonusrecibe).toInt()
            }
            if (dano == 3) ataque2 = Random.nextInt(0, 51)
            if (vidaRestante - ataque2 * BonusA.bonusrecibe < 0) vidaRestante = 0
            else {
                vidaRestante -= (ataque2 * BonusA.bonusrecibe).toInt()
                Danos.danorecibido += (ataque2 * BonusA.bonusrecibe).toInt()
            }
        }
    }

    fun curar() {
        val curar = Random.nextInt(25, 76)
        if (vidaRestante + curar > vidatot) vidaRestante = vidatot
        else vidaRestante += curar
    }

}

data class PokemonEnemigo(
    val nombre: String,
    var nivel: Int,
    val vidatot: Int,
    val image: String,
    val genero: Char,
    var estado: String,
    var vidaRestante: Int = vidatot,
    var bol: Boolean = false
) {
    fun pokemonMuerteEnemigo(): Boolean {
        var estavivo = true
        if (vidaRestante <= 0) estavivo = false

        return estavivo
    }

    fun recibirAtaqueEnemigo(i: Int) {

        if (this.estado == "Envenenado"){
            if (this.vidaRestante > 10) {
                vidaRestante -= 10
                BonusB.bonushace=1.0
                BonusB.bonusrecibe=1.0

            } else
                vidaRestante = 0}else

            if (this.estado == "Quemado"){
                BonusB.bonusrecibe = 1.5
                BonusB.bonushace=1.0
            }


            else if (this.estado == "Congelado"){
                BonusB.bonushace = 0.5
                BonusB.bonusrecibe=1.0
            }
            else{
                BonusB.bonushace=1.0
                BonusB.bonusrecibe=1.0}

        var ataque = 0
        var ataque2 = 0

        if (BonusA.bonushace == 0.5) {
            if (this.pokemonMuerteEnemigo()) if (i == 1) if (vidaRestante - 20 * BonusA.bonushace * BonusB.bonusrecibe < 0) vidaRestante =
                0
            else {
                vidaRestante -= (20 * BonusB.bonusrecibe * BonusA.bonushace).toInt()
                Danos.danorecibido += (20 * BonusB.bonusrecibe * BonusA.bonushace).toInt()
            }
            else if (i == 2) ataque = Random.nextInt(10, 26)
            if (vidaRestante - ataque * BonusB.bonusrecibe * BonusA.bonushace < 0) vidaRestante = 0
            else {
                vidaRestante -= (ataque * BonusB.bonusrecibe * BonusA.bonushace).toInt()
                Danos.danorecibido += (ataque * BonusB.bonusrecibe * BonusA.bonushace).toInt()
            }
            if (i == 3) ataque2 = Random.nextInt(0, 51)
            if (vidaRestante - ataque2 * BonusB.bonusrecibe * BonusA.bonushace < 0) vidaRestante = 0
            else {
                vidaRestante -= (ataque2 * BonusB.bonusrecibe * BonusA.bonushace).toInt()
                Danos.danorecibido += (ataque2 * BonusB.bonusrecibe * BonusA.bonushace).toInt()
            }
        }else{
            if (this.pokemonMuerteEnemigo()) if (i == 1) if (vidaRestante - 20* BonusA.bonushace * BonusB.bonusrecibe < 0) vidaRestante = 0
            else {
                vidaRestante -= (20 * BonusB.bonusrecibe).toInt()
                Danos.danorecibido += (20 * BonusB.bonusrecibe).toInt()
            }
            else if (i == 2) ataque = Random.nextInt(10, 26)
            if (vidaRestante - ataque * BonusB.bonusrecibe < 0) vidaRestante = 0
            else {
                vidaRestante -= (ataque * BonusB.bonusrecibe).toInt()
                Danos.danorecibido += (ataque * BonusB.bonusrecibe).toInt()
            }
            if (i == 3) ataque2 = Random.nextInt(0, 51)
            if (vidaRestante - ataque2 * BonusB.bonusrecibe < 0) vidaRestante = 0
            else {
                vidaRestante -= (ataque2 * BonusB.bonusrecibe).toInt()
                Danos.danorecibido += (ataque2 * BonusB.bonusrecibe).toInt()
            }

        }






    }

    fun curarEnemigo() {
        val curar = Random.nextInt(25, 76)
        if (vidaRestante + curar > vidatot) vidaRestante = vidatot
        else vidaRestante += curar
    }


}
