import java.util.*

fun main(arg : Array<String>){
    val technology = arg[0]
    val screenName = arg[1]

    when(technology){
        "flutter" -> Flutter(screenName)
    }
}

class Flutter(private val screenName : String) : Technology {

    override
    fun screenNameGetter():String{
        return  screenName.lowercase(Locale.getDefault()).replace(" ","_") + "_screen"
    }

    override
    fun controllerNameGetter():String{
        return screenName.lowercase(Locale.getDefault()).replace(" ","_") + "_controller"
    }

    override
    fun modelNameGetter():String{
        return screenName.lowercase(Locale.getDefault()).replace(" ","_") + "_model"
    }

}

interface Technology {
    fun screenNameGetter() : String
    fun controllerNameGetter() : String
    fun modelNameGetter() : String
}
