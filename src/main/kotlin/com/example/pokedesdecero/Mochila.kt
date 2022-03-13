package com.example.pokedesdecero

import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType

class Mochila {
    var controladorPokemon = CombatePokemon()
    var pokemon : Pokemon?=null


    fun traerPokemonAMochila(elegirLuchador: Pokemon){
        this.pokemon= elegirLuchador
    }
    fun controladorPokemon(controlador: CombatePokemon){
        this.controladorPokemon=controlador
    }
    private fun alerta(objeto :String){

        val alert = Alert(Alert.AlertType.ERROR)
        alert.title = "Error"
        alert.headerText = "El objeto $objeto no hace efecto "
        val buttonTypeOne = ButtonType("Vale")


        alert.buttonTypes.setAll(buttonTypeOne)

        val result = alert.showAndWait()
        if (result.get() == buttonTypeOne)
                alert.close()


    }
    private fun alertacurado(objeto :String){

        val alert = Alert(Alert.AlertType.CONFIRMATION)
        alert.title = "Aplicado"
        alert.headerText = "El objeto $objeto ha surgido efecto "
        val buttonTypeOne = ButtonType("Vale")


        alert.buttonTypes.setAll(buttonTypeOne)

        val result = alert.showAndWait()
        if (result.get() == buttonTypeOne)
            alert.close()


    }
    fun actualizarestado(){
        controladorPokemon.cargarPokemon(pokemon!!)
        controladorPokemon.llamaahello()
    }



    @FXML
    fun quitarveneno(){
    if (pokemon!!.estado=="Envenenado"){
        pokemon!!.estado=""
        actualizarestado()
        alertacurado("antidoto")
    }



        else{alerta("antidoto")


        }
    }
    @FXML
    fun quitarquemado(){
        if (pokemon!!.estado=="Quemado"){
            pokemon!!.estado=""
            actualizarestado()
            alertacurado("antiquemaduras")

        }


        else{alerta("antiquemaduras")


        }
    }
    @FXML
    fun quitarcongelado(){
        if (pokemon!!.estado=="Congelado"){
            pokemon!!.estado=""
            actualizarestado()
            alertacurado("descongelador")

        }


        else{alerta("descongelador")


        }
    }
}