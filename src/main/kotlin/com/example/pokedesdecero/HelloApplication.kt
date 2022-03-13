package com.example.pokedesdecero


import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

var pokemonArray = ArrayList<Pokemon>()
var epokemonArray = ArrayList<PokemonEnemigo>()
val listaestados = listOf("Quemado","Envenenado","Congelado")
//No he puesto la imagen de los pokemon del revés ya que no he podido automatizar el proceso de descarga del revés
class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val pokemon00 = Pokemon("Blastoise", 97, 193, "./images/blastoise.gif", 'm',9, listaestados.random())
        val pokemon01 = Pokemon("Charizard", 77, 300, "./images/charizard.gif", 'f',90, listaestados.random())
        val pokemon02 = Pokemon("Darkrai", 81, 279, "./images/darkrai.gif", 'f',99, listaestados.random())
        val pokemon03 = Pokemon("Giratina", 78, 392, "./images/giratina.gif", 'f',99, listaestados.random())
        val pokemon04 = Pokemon("Dialga", 75, 303, "./images/dialga.gif", 'm',99, listaestados.random())
        val pokemon05 = Pokemon("Garchomp", 83, 352, "./images/garchomp.gif", 'm',99, listaestados.random())

        pokemonArray.add(pokemon00)
        pokemonArray.add(pokemon01)
        pokemonArray.add(pokemon02)
        pokemonArray.add(pokemon03)
        pokemonArray.add(pokemon04)
        pokemonArray.add(pokemon05)

        val pokemon10 = PokemonEnemigo("Dialga", 73, 185, "./images/dialga.gif", 'm', listaestados.random())
        val pokemon11 = PokemonEnemigo("Palkia", 62, 217, "./images/palkia.gif", 'h', listaestados.random())
        val pokemon12 = PokemonEnemigo("Piplup", 68, 276, "./images/piplup.gif", 'm', listaestados.random())
        val pokemon13 = PokemonEnemigo("Pikachu", 79, 293, "./images/pikachu.gif", 'h', listaestados.random())

        epokemonArray.add(pokemon10)
        epokemonArray.add(pokemon11)
        epokemonArray.add(pokemon12)
        epokemonArray.add(pokemon13)

        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 600.0, 400.0)
        stage.title = "Pokemon"
        stage.scene = scene
        stage.isResizable = false

        stage.show()


    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}