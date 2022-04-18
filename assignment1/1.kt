fun main(args : Array<String>) {
    val argName = args[0]
    val argValue = args[1]

    val trains = arrayListOf(
        Train("Rajdhani", "Surat", "Delhi", "10:30 AM"),
        Train("garibrath", "Surat", "Delhi", "10:30 AM"),
        Train("intercity", "Surat", "morbi", "11.35 AM"),
    )
    val filterList = when(argName){
        "name" -> trains.filter { it.name == argValue }
        "source" -> trains.filter { it.source == argValue }
        "destination" -> trains.filter { it.destination == argValue }
        "DepartureTime" -> trains.filter { it.time == argValue }
        else -> arrayListOf()
    }

    filterList.forEach {
        print(it.name)
        print(it.source)
        print(it.destination)
        print(it.time)
    }
}

class Train(val name : String, val source : String, val destination: String, val time :  String)
