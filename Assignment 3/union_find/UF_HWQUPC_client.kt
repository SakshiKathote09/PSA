package edu.neu.coe.info6205.union_find

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

object UF_HWQUPC_client {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        var input = 0
        println("*****please enter -1 to exit or positive integer to continue*****")
        while (input != -1) {
            val initial = 100 //number of times to test to take average
            print("Input : Number of objects/sites (n): ")
            val reader = BufferedReader(InputStreamReader(System.`in`))
            input = reader.readLine().toInt()
            if (input == -1) {
                System.exit(1)
            }
            var totalrandomconnections = 0 // total of all connection and take there average
            for (i in 0 until initial) {
                totalrandomconnections += count(input)
            }
            println((totalrandomconnections / initial).toString() + " Random Pairs (m) generated for " + input + " objects (n). ")
        }
    }

    private fun count(input: Int): Int {
        var randomPair = 0
        val uf_hwqupc = UF_HWQUPC(input, true)
        val randObj = Random()
        while (uf_hwqupc.components() > 1) {
            val p = randObj.nextInt(input)
            val q = randObj.nextInt(input)
            if (!uf_hwqupc.connected(p, q)) {
                uf_hwqupc.union(p, q)
            }
            randomPair++
        }
        return randomPair
    }
}