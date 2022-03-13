package com.example.pokedesdecero

import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.URL
import java.net.URLConnection


object descargaimagen {
    fun descargar(Pokemon:String){
        var archivo= File("./images/$Pokemon.gif")
        if (!archivo.exists()){
        try {
            // Url con la foto
            val url = URL(
                "https://www.pokexperto.net/3ds/sprites/pokedex/animados/$Pokemon.gif"
            )

            // establecemos conexion
            val urlCon: URLConnection = url.openConnection()

            // Sacamos por pantalla el tipo de fichero
            System.out.println(urlCon.getContentType())

            // Se obtiene el inputStream de la foto web y se abre el fichero
            // local.
            val `is`: InputStream = urlCon.getInputStream()
            val fos = FileOutputStream("./images/$Pokemon.gif")

            // Lectura de la foto de la web y escritura en fichero local
            val array = ByteArray(1000) // buffer temporal de lectura.
            var leido = `is`.read(array)
            while (leido > 0) {
                fos.write(array, 0, leido)
                leido = `is`.read(array)
            }

            // cierre de conexion y fichero.
            `is`.close()
            fos.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }}

}