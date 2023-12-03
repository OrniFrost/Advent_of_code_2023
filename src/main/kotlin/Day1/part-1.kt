package Day1

import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("src/main/kotlin/Day1/input.txt").inputStream()
    val listeLigne = mutableListOf<String>()

    inputStream.bufferedReader().useLines { lignes -> lignes.forEach { listeLigne.add(it) } }

    var total: Int = 0;
    listeLigne.forEach{ligne: String ->
        val ligneChar: CharArray = ligne.toCharArray()
        val listeChiffres = mutableListOf<Int>()

        ligneChar.forEach { c: Char ->
            if(c.isDigit()){
                listeChiffres.add(c.digitToInt())
            }
        }

        if(listeChiffres.size == 1)
            total += listeChiffres.first() * 10 + listeChiffres.first()
        else{
            val dizaine: Int = listeChiffres.first() * 10
            val unite: Int = listeChiffres.last()
            total += dizaine + unite
        }
    }

    println(total)
}