package com.example.tp1_fundamentos_desenvolvimento_android

import java.time.LocalDate
import java.time.Period.between
import java.util.*

val triangulo = listOf(1, 2, 3, 4, 5, 4, 3, 2, 1, 0)
val fibonacci = listOf(1, 1, 2, 3, 5, 8, 13, 21, 34)
val vazio = listOf<Int>()
val listasTeste = listOf(triangulo, fibonacci, vazio)
val nomeListasTeste = mapOf("triangulo" to triangulo, "fibonacci" to fibonacci, "vazio" to vazio)

/*------------------//Questão 2//----------------*/
fun quest2(lista:List<Int>){
    println("\nQuestão 2:")
    if(lista.isNotEmpty()){
        if (lista.first() < lista.last()){
            println("Infnet")
        } else {println("Tenfni")
        }
    }else {println("Lista vazia")
    }
}

/*------------------//Questão 3//----------------*/
fun quest3(lista:List<Int>){
    println("\nQuestão 3:")
    var maiorNumero: Int? = lista.maxOrNull()
    if (maiorNumero != null){
        println("O maior elemento da lista é $maiorNumero")
    }else{println("A lista é vazia")}
}

/*------------------//Questão 4//----------------*/
fun quest4(lista:List<Int>){
    println("\nQuestão 4:")
    if (lista.isNotEmpty())
    {
        var (listaPar, listaImpar) = lista.partition { it % 2 == 0 || it == 0 }
        println("Os elementos pares da lista são: $listaPar e os ímpares: $listaImpar")
        var somaPar = listaPar.sum()
        var produtoImpar = listaImpar.reduce { acc, i -> acc * i }
        println("A soma dos elementos pares é $somaPar")
        println("O produto dos elementos ímpares é $produtoImpar")

    }else{println("Lista vazia")}
}

/*------------------//Questão 5//----------------*/
fun quest5(lista: List<Int>){
    println("\nQuestão 5:")
    if(lista.isEmpty()){
        println("Lista vazia")
    }else{
        for(numero in lista) {
            val numero = numero
            var fatorial: Long = 1
            for (i in 1..numero) {
                fatorial *= i.toLong()
            }
            println("Fatorial de $numero = $fatorial")
        }
    }
}

/*------------------//Questão 6//----------------*/
fun quest6(lista: List<Int>){
    println("\nQuestão 6:")
    var listaResultado = mutableListOf<Int>()
    for(numero in lista){
        var resultado = 0
        if (numero < 2){
            resultado = 0
        }else{
            when{
                numero % 2 == 0 && numero / 2 != 1 -> resultado = 0
                numero % 3 == 0 && numero / 3 != 1-> resultado = 0
                numero % 5 == 0 && numero / 5 != 1-> resultado = 0
                numero % 7 == 0 && numero / 7 != 1-> resultado = 0
                else -> resultado = 1
            }
        }
        listaResultado.add(resultado)
        println("$numero")
        println("$listaResultado")
    }
}

/*------------------//Questão 7//----------------*/
fun quest7(palavra: String){
    println("\nQuestão 7:")
    var palavra = palavra.lowercase();
    val listaPalavra = palavra.toMutableList()
    var valoresPalavra = mutableListOf<Int>()
    println("\nA Hash da ${palavra.capitalize()} é:")
    val alfabeto = mutableListOf<Char>()
    var c: Char = 'a'
    while (c <= 'z') {
        alfabeto.add(c)
        ++c
    }
    for(letra in listaPalavra){
        var indexLetraPalavra = listaPalavra.indexOf(letra)
        var indexLetraAlfabeto = alfabeto.indexOf(letra)
        var valorLetra = (indexLetraAlfabeto+1)*(indexLetraPalavra+1)
        valoresPalavra.add(valorLetra)
    }
    var resultadoSomaPalavra = valoresPalavra.sum()
    print("$resultadoSomaPalavra")
}

/*------------------//Questão 8//----------------*/
fun quest8(lista : List<Int>){
    println("\nQuestão 8:")
    val lista = lista.toMutableList()
    println("\nExemplo propriedade size:")
    val tamanhoLista = lista.size
    println(tamanhoLista)
    //A propriedade size quando usado em uma coleção retorna quantos elementos existem nessa coleção em :Int

    println("\nExemplo função isEmpty():")
    val listaCheia = lista.isEmpty()
    println(listaCheia)
    //A função isEmpty() retorna true se a lista está vazia e false se houver elementos nela

    println("\nExemplo função partition:")
    var (listaSelecionados, listaResto) = lista.partition { it % 2 == 0}
    println("Lista com os elementos dentro dos requisitos (número par): $listaSelecionados")
    println("Lista com os parâmetros fora dos requisitos: $listaResto")
    //A função partition filtra os elementos de uma lista de acordo com os requisitos definido entre { }
    // criando uma lista com os elementos que atendem os requisitos e outra com os que não atendem
}

/*------------------//Questão 9//----------------*/
open class Data(var dia:Int, var mes:Int, var ano:Int) {
    fun bissexto() {
        println("\n\nQuestão 9 - Pergunta 1:")
        var leap = false
        if (ano % 4 == 0) {
            if (ano % 100 == 0) {
                // year is divisible by 400, hence the year is a leap year
                leap = ano % 400 == 0
            } else
                leap = true
        } else
            leap = false
        println(if (leap) "$ano é um ano bissexto." else "$ano não é um ano bissexto.")
    }


    fun diasMes() {
        println("\nQuestão 9 - Pergunta 2:")
        val calendario = Calendar.getInstance()

        calendario.set(ano, mes - 1, 1) //Note that the month is specified starting from 0
        val maxDay = calendario.getActualMaximum(Calendar.DAY_OF_MONTH)
        print("O mês $mes do ano $ano tem $maxDay dias!")
    }


    fun diasIntervalo(){
        println("\n\nQuestão 9 - Pergunta 3:")
        val dataInput = LocalDate.of(ano, mes, dia)
        val dataFinal = LocalDate.of(ano, 1, 1)
        var intervalo = between(dataInput, dataFinal)
        print("O intervalo entre a data e o primeiro dia do ano é de: $intervalo")
    }

}

fun main() {
    for ((nome, lista) in nomeListasTeste){
        val nome = nome.capitalize()
        println("\nTeste com lista $nome")
        quest2(lista); quest3(lista); quest4(lista)
        quest5(lista); quest6(lista)
    }
    quest7("pera"); quest7("abacaxi"); quest7("infnet")
    quest7("pneumoultramicroscopicosilicovulcaniconiótico")
    quest7("e"); quest7("cafe")

    quest8(listOf(0,1,2,3,4,5,6))

    var quest9p1 = Data(2,1,2022).bissexto()
    var quest9p2 = Data(2,1,2022).diasMes()
    var quest9p3 = Data(2,1,2022).diasIntervalo()

}


