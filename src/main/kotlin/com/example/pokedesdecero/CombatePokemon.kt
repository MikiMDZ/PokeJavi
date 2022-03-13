package com.example.pokedesdecero

import com.example.pokedesdecero.HelloController
import com.example.pokedesdecero.epokemonArray
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.Label
import javafx.scene.control.ProgressBar
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import java.io.File
import kotlin.random.Random
import kotlin.system.exitProcess

class CombatePokemon {

    @FXML
    private lateinit var wallpaper: ImageView

    @FXML
    private lateinit var pokemona: ImageView

    @FXML
    private lateinit var pokemone: ImageView

    @FXML
    private lateinit var menubasic: BorderPane

    @FXML
    private lateinit var atacar: Label

    @FXML
    private lateinit var curar: Label

    @FXML
    private lateinit var pokemonap: BorderPane

    @FXML
    private lateinit var nombrepokemona: Label

    @FXML
    private lateinit var pppokemona: Label

    @FXML
    private lateinit var nivelpokemona: Label

    @FXML
    private lateinit var barrapokemona: ProgressBar

    @FXML
    private lateinit var pokemonep: BorderPane

    @FXML
    private lateinit var nombrepokemone: Label

    @FXML
    private lateinit var pppokemone: Label

    @FXML
    private lateinit var nivelpokemone: Label

    @FXML
    private lateinit var barrapokemone: ProgressBar

    @FXML
    private lateinit var ataques: BorderPane

    @FXML
    private lateinit var seguro: Label

    @FXML
    private lateinit var arriesgado: Label

    @FXML
    private lateinit var muyarriesgado: Label

    @FXML
    private lateinit var cancelar: Label

    @FXML
    private lateinit var estadoamigo: ImageView

    @FXML
    private lateinit var estadoenemigo: ImageView

    @FXML
    private lateinit var mochila: Label


    class Pokemonainterfaz(
        var nombre: Label,
        var ps: Label,
        var nivel: Label,
        var imagen: ImageView,
        var vida: ProgressBar,
        var estadoamigo: ImageView
    )

    class Pokemoneinterfaz(
        var nombre: Label,
        var ps: Label,
        var nivel: Label,
        var imagen: ImageView,
        var vida: ProgressBar,
        var estadoenemigo: ImageView
    )


    var controller1 = HelloController()

    fun enviaracontroller() {
        controller1.actpie()
    }

    var seleccionado: Pokemon = Pokemon("", 0, 0, "", ' ', 0, "")
    fun cargarPokemon(pokemon: Pokemon) {
        pokemon.bol = false
        seleccionado = pokemon

        val interfazzz =
            Pokemonainterfaz(nombrepokemona, pppokemona, nivelpokemona, pokemona, barrapokemona, estadoamigo)
        iniciarpokemon(interfazzz)

    }

    fun iniciarpokemon(interfaz: Pokemonainterfaz) {

        val seleccionado = File(seleccionado.image)
        interfaz.imagen.image = Image(seleccionado.toURI().toString())
        interfaz.nombre.text = this.seleccionado.nombre
        interfaz.ps.text = "PS"
        interfaz.nivel.text = "LVL " + this.seleccionado.nivel
        interfaz.vida.progress = this.seleccionado.vidaRestante.toDouble() / this.seleccionado.vidatot
        if (interfaz.vida.progress > 0.5) interfaz.vida.style = "-fx-accent: green"
        else if (interfaz.vida.progress > 0.25) interfaz.vida.style = "-fx-accent: #ff8929"
        else if (interfaz.vida.progress < 0.25) interfaz.vida.style = "-fx-accent:red"
        else if (interfaz.vida.progress < 0.5) interfaz.vida.style = "-fx-accent:#ff8929"
        if (this.seleccionado.estado == "Quemado")
            interfaz.estadoamigo.image = Image(File("./images/fuego.png").toURI().toString())
        else
            if (this.seleccionado.estado == "Envenenado")
                interfaz.estadoamigo.image = Image(File("./images/veneno.png").toURI().toString())
            else
                if (this.seleccionado.estado == "Congelado")
                    interfaz.estadoamigo.image = Image(File("./images/frio.png").toURI().toString())
        else interfaz.estadoamigo.image=Image(File("").toURI().toString())


    }

    val prandom = Random.nextInt(0, epokemonArray.size)
    val enemigo = epokemonArray[prandom]
    fun cargarPokemonEnemigo(interfaz: Pokemoneinterfaz) {

        val enemigo = File(enemigo.image)
        interfaz.imagen.image = Image(enemigo.toURI().toString())

        interfaz.nombre.text = this.enemigo.nombre
        interfaz.ps.text = "PS"
        interfaz.nivel.text = "Nvl " + this.enemigo.nivel
        interfaz.vida.progress = this.enemigo.vidaRestante.toDouble() / this.enemigo.vidatot
        if (interfaz.vida.progress > 0.5) interfaz.vida.style = "-fx-accent: green"
        else if (interfaz.vida.progress > 0.25) interfaz.vida.style = "-fx-accent: #ff8929"
        else if (interfaz.vida.progress < 0.25) interfaz.vida.style = "-fx-accent:red"
        else {
            if (interfaz.vida.progress < 0.5) interfaz.vida.style = "-fx-accent:#ff8929"
        }
        if (this.enemigo.estado == "Quemado")
            interfaz.estadoenemigo.image = Image(File("./images/fuego.png").toURI().toString())
        else
            if (this.enemigo.estado == "Envenenado")
                interfaz.estadoenemigo.image = Image(File("./images/veneno.png").toURI().toString())
            else
                if (this.enemigo.estado == "Congelado")
                    interfaz.estadoenemigo.image = Image(File("./images/frio.png").toURI().toString())

    }

    @FXML
    fun initialize() {
        val interfazenemiga =
            Pokemoneinterfaz(nombrepokemone, pppokemone, nivelpokemone, pokemone, barrapokemone, estadoenemigo)
        cargarPokemon(seleccionado)
        cargarPokemonEnemigo(interfazenemiga)
    }

    fun verVida(label: Label) {
        label.text = seleccionado.vidaRestante.toString()
    }

    fun resetVerVida(label: Label) {
        label.text = "PS"
    }

    fun vervidaenemigo(label: Label) {
        label.text = enemigo.vidaRestante.toString()
    }

    fun ocultarvidaenemigo(label: Label) {
        label.text = "PS"
    }

    @FXML
    fun onMouseAtaqueEntered() {
        verVida(pppokemona)
    }

    @FXML
    fun onMouseAtaqueExited() {
        resetVerVida(pppokemona)
    }

    @FXML
    fun onMouseEnemigoEntered() {
        vervidaenemigo(pppokemone)
    }

    fun onMouseEnemigoExited() {
        ocultarvidaenemigo(pppokemone)
    }

    @FXML
    fun ataqueClicked() {
        menubasic.visibleProperty().set(false)
        ataques.visibleProperty().set(true)
    }

    @FXML
    fun underlineTrue(label: Label) {
        label.underlineProperty().set(true)
    }

    @FXML
    fun underlineFalse(label: Label) {
        label.underlineProperty().set(false)
    }


    @FXML
    fun ataqueEntered() {
        underlineTrue(atacar)
    }

    @FXML
    fun ataqueExited() {
        underlineFalse(atacar)
    }

    @FXML
    fun ataqueSeguroEntered() {
        underlineTrue(seguro)

    }

    @FXML
    fun ataqueSeguroExited() {
        underlineFalse(seguro)
    }

    @FXML
    fun ataqueArriesgadoEntered() {
        underlineTrue(arriesgado)
    }

    @FXML
    fun ataqueArriesgadoExited() {
        underlineFalse(arriesgado)
    }

    @FXML
    fun ataqueMuyArriesgadoEntered() {
        underlineTrue(muyarriesgado)
    }

    @FXML
    fun ataqueMuyArriesgadoExited() {
        underlineFalse(muyarriesgado)
    }

    @FXML
    fun curarLabelEntered() {
        underlineTrue(curar)
    }

    @FXML
    fun curarLabelExited() {
        underlineFalse(curar)
    }

    @FXML
    fun cancelarAtaqueEntered() {
        underlineTrue(cancelar)
    }

    @FXML
    fun cancelarAtaqueExited() {
        underlineFalse(cancelar)
    }

    @FXML
    fun cancelarAtaqueClicked() {
        menubasic.visibleProperty().set(true)
        ataques.visibleProperty().set(false)

    }

    @FXML
    fun ataqueSeguroClicked() {
        if (enemigo.pokemonMuerteEnemigo() and seleccionado.pokemonMuerte()) {
            enemigo.recibirAtaqueEnemigo(1)
            val enemigointerfaz =
                Pokemoneinterfaz(nombrepokemone, pppokemone, nivelpokemone, pokemone, barrapokemone, estadoenemigo)
            cargarPokemonEnemigo(enemigointerfaz)
        }
        if (enemigo.pokemonMuerteEnemigo() and seleccionado.pokemonMuerte()) {
            seleccionado.recibirAtaque(1)
            controller1.seleccionadopokemon(seleccionado)
            cargarPokemon(seleccionado)
        }
        if (!enemigo.pokemonMuerteEnemigo()) {
            enemigo.vidaRestante = enemigo.vidatot
            ocultarmenus()





            alertaenemigo(enemigo)
        }
        if (!seleccionado.pokemonMuerte()) {
            ocultarmenus()
            alerta(seleccionado)
        }
        enviaracontroller()
    }

    @FXML
    fun ataqueArriesgadoClicked() {
        if (enemigo.pokemonMuerteEnemigo() and seleccionado.pokemonMuerte()) {
            enemigo.recibirAtaqueEnemigo(2)
            val enemigointerfaz =
                Pokemoneinterfaz(nombrepokemone, pppokemone, nivelpokemone, pokemone, barrapokemone, estadoenemigo)
            cargarPokemonEnemigo(enemigointerfaz)
        }
        if (enemigo.pokemonMuerteEnemigo() and seleccionado.pokemonMuerte()) {
            seleccionado.recibirAtaque(2)
            controller1.seleccionadopokemon(seleccionado)
            cargarPokemon(seleccionado)
        }
        if (!enemigo.pokemonMuerteEnemigo()) {
            enemigo.vidaRestante = enemigo.vidatot
            alertaenemigo(enemigo)
        }
        if (!seleccionado.pokemonMuerte()) {
            ocultarmenus()
            alerta(seleccionado)
        }
        enviaracontroller()
    }

    @FXML
    fun ataqueMuyArriesgadoClicked() {

        if (enemigo.pokemonMuerteEnemigo() and seleccionado.pokemonMuerte()) {
            enemigo.recibirAtaqueEnemigo(3)
            val enemigointerfaz =
                Pokemoneinterfaz(nombrepokemone, pppokemone, nivelpokemone, pokemone, barrapokemone, estadoenemigo)
            cargarPokemonEnemigo(enemigointerfaz)
        }
        if (enemigo.pokemonMuerteEnemigo() and seleccionado.pokemonMuerte()) {
            seleccionado.recibirAtaque(3)
            controller1.seleccionadopokemon(seleccionado)
            cargarPokemon(seleccionado)
        }
        if (!enemigo.pokemonMuerteEnemigo()) {
            enemigo.vidaRestante = enemigo.vidatot
            ocultarmenus()
            alertaenemigo(enemigo)
        }
        if (!seleccionado.pokemonMuerte()) {
            ocultarmenus()
            alerta(seleccionado)
        }
        enviaracontroller()
    }

    @FXML
    fun curarLabelClicked() {
        if (enemigo.pokemonMuerteEnemigo() and seleccionado.pokemonMuerte()) {
            if (enemigo.vidaRestante < enemigo.vidatot) {
                enemigo.curarEnemigo()
                val enemyInterfaz =
                    Pokemoneinterfaz(nombrepokemone, pppokemone, nivelpokemone, pokemone, barrapokemone, estadoenemigo)
                cargarPokemonEnemigo(enemyInterfaz)
            }
        }
        if (enemigo.pokemonMuerteEnemigo() and seleccionado.pokemonMuerte()) {
            if (seleccionado.vidaRestante < seleccionado.vidatot) {
                seleccionado.curar()
                controller1.seleccionadopokemon(seleccionado)
                cargarPokemon(seleccionado)
            }
        }
    }

    fun ocultarmenus() {
        ataques.visibleProperty().set(false)
        menubasic.visibleProperty().set(false)

    }

    fun mostrarmenus() {
        ataques.visibleProperty().set(true)
        menubasic.visibleProperty().set(true)

    }


    fun enviarDatosMenuSeleccion(helloController: HelloController) {
        this.controller1 = helloController
    }


    fun alerta(pokemon: Pokemon) {
        val imagen = File(pokemon.image)
        val alert = Alert(Alert.AlertType.CONFIRMATION)
        alert.title = "Tu pokemon ha muerto"
        alert.headerText = "El pokemon ${pokemon.nombre} ha muerto."
        alert.contentText = "Elige que hacer"
        val imageView = ImageView(imagen.toURI().toString())
        alert.graphic = imageView

        val buttonTypeOne = ButtonType("Continuar")
        val buttonTypeTwo = ButtonType("Salir")


        alert.buttonTypes.setAll(buttonTypeOne, buttonTypeTwo)

        val result = alert.showAndWait()
        if (result.get() == buttonTypeOne) {
            if (controller1.quedanvivos()) {
                controller1.initial()
                val stage = ataques.scene.window as Stage
                stage.close()
                controller1.stage = null
            } else {
                controller1.mostrarAlertError()
                exitProcess(100)
            }
        } else if (result.get() == buttonTypeTwo) {
            exitProcess(0)
        } else {
            exitProcess(0)
        }
    }

    fun alertaenemigo(pokemon: PokemonEnemigo) {
        val imagen = File(pokemon.image)
        val alert = Alert(Alert.AlertType.CONFIRMATION)
        alert.title = "Enemigo muerto"
        alert.headerText = "El pokemon ${pokemon.nombre} ha muerto."
        alert.contentText = "Elige que hacer"
        val imageView = ImageView(imagen.toURI().toString())
        alert.graphic = imageView

        val buttonTypeOne = ButtonType("Continuar")
        val buttonTypeTwo = ButtonType("Salir")


        alert.buttonTypes.setAll(buttonTypeOne, buttonTypeTwo)

        val result = alert.showAndWait()
        if (result.get() == buttonTypeOne) {
            if (controller1.quedanvivos()) {
                controller1.initial()
                val stage = ataques.scene.window as Stage
                stage.close()
                controller1.stage = null
            } else {
                controller1.mostrarAlertError()
                exitProcess(100)
            }
        } else if (result.get() == buttonTypeTwo) {
            exitProcess(0)
        } else {
            exitProcess(0)
        }
    }

    fun llamaahello() {
        controller1.seleccionadopokemon(seleccionado)
    }

    @FXML
    fun gotomochila() {

        val stage = Stage()
        val loader = FXMLLoader(Mochila::class.java.getResource("Mochila.fxml"))
        val scene = Scene(loader.load())
        stage.scene = scene
        stage.show()
        stage.title = "Mochila"
        //stage.isResizable = false

        var controlador = loader.getController<Mochila>()
        controlador.controladorPokemon(this)
        controlador.traerPokemonAMochila(seleccionado)
    }


}