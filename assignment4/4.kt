import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(arg : Array<String>){
    val totalNoCar = arg[0].toInt()

    val begin = System.nanoTime()

    runBlocking {
        for(i in 0 until totalNoCar) {
            val oneCarStart = System.nanoTime()// this: CoroutineScope
            launch { // launch a new coroutine and continue
                println("$i Build Body of car")
                delay(5000L)
                println("$i Painting car ")
                delay(5000L)
                println("$i Install drive train")
                delay(10000L)
                println("$i Installing batteries")
                delay(15000L)
                println("$i Install Interior of car")
                delay(15000L)
                val totalTime = System.nanoTime() - oneCarStart
                println(" $i job done in second : ${totalTime/1000_000_000}  || neno second : $totalTime " )
            }
        }
        joinAll()
    }

    val totalTimeForAll = System.nanoTime() - begin
    println("Done all in second : ${totalTimeForAll/1000_000_000} || neno second : $totalTimeForAll") // main coroutine continues while a previous one is delayed
}
/*
486 job done in second : 50  || neno second : 50059301838
487 job done in second : 50  || neno second : 50059286464
488 job done in second : 50  || neno second : 50059285777
489 job done in second : 50  || neno second : 50059285905
490 job done in second : 50  || neno second : 50059355852
491 job done in second : 50  || neno second : 50059360949
492 job done in second : 50  || neno second : 50059363952
493 job done in second : 50  || neno second : 50059366048
494 job done in second : 50  || neno second : 50059368194
495 job done in second : 50  || neno second : 50059369361
496 job done in second : 50  || neno second : 50059370861
497 job done in second : 50  || neno second : 50059372041
498 job done in second : 50  || neno second : 50059372412
499 job done in second : 50  || neno second : 50059449826
Done all in second : 50 || neno second : 50160843692*/

