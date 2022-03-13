package com.example.pokedesdecero

import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.chart.BarChart
import javafx.scene.chart.PieChart
import javafx.scene.chart.XYChart
import javafx.scene.chart.XYChart.Series
import javafx.scene.control.Label


class Estadisticas {

    @FXML
    private lateinit var chart: PieChart

    @FXML
    private lateinit var bar: BarChart<String,Int>

    @FXML
    private lateinit var dano:Label

    fun actualizarpie() {

        var pieChartData = FXCollections.observableArrayList(
            PieChart.Data("Daño realizado", Danos.danohecho.toDouble()),
            PieChart.Data("Daño recibido", Danos.danorecibido.toDouble())
        )

        chart.isLegendVisible=false
        //Quito la leyenda ya que el gráfico queda pequeño
        chart.data = pieChartData
        chart.data[0].node.style= ("-fx-pie-color: #DAF7A6")
        chart.data[1].node.style= ("-fx-pie-color: #C70039")
        dano.text = "Daño realizado= ${Danos.danohecho} \n Daño recibido ${Danos.danorecibido}"
    }
    var posiciones=0

    fun actualizarbar(Pokemon :Pokemon) {

        var serie = Series<String, Int>()
        serie.name = Pokemon.nombre
        serie.data.add(XYChart.Data(Pokemon.nombre,Pokemon.seleccionado))
        if (bar.data.isEmpty()){
        bar.data.add(serie)
            posiciones++
        Pokemon.id=posiciones-1}
        else{
            if (bar.data.size<Pokemon.id){
                bar.data.add(serie)
                Pokemon.id=bar.data.size-1
            }else
            bar.data[Pokemon.id]=serie
            }
        }


    }




    object Danos {
        var danorecibido = 0
        var danohecho = 0
    }

