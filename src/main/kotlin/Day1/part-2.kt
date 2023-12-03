package Day1

import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("src/main/kotlin/Day1/input.txt").inputStream()
    val listeLigne = mutableListOf<String>()

    val mapChiffres = mutableMapOf(
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine"
    )

    inputStream.bufferedReader().useLines { lignes -> lignes.forEach { listeLigne.add(it) } }

    var total: Int = 0;
    listeLigne.forEach{ligne: String ->
        val ligneChar: CharArray = ligne.toCharArray()
        val listeChiffres = mutableListOf<Int>()

        var i = 0
        ligneChar.forEach { c: Char ->
            if(c.isDigit()){
                listeChiffres.add(c.digitToInt())
            }else{
                run testerCHiffres@{
                    mapChiffres.forEach { chiffre ->
                        if(chiffre.value.length + i <= ligne.length){
                            val testChiffre: String = ligne.substring(i,i+ chiffre.value.length)
                            if(testChiffre == chiffre.value){
                                listeChiffres.add(chiffre.key)
                                return@testerCHiffres
                            }
                        }
                    }
                }
            }
            i++
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