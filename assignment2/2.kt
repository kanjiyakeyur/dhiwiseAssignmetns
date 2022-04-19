fun main(arg : Array<String>) {
    
    fun createBaverage(order : String){
       
    	when(order){
            "1" -> Tea()
            "2" -> Coffee()
            "" -> print("Want Beverage? Enter 1 for Tea/ 2 for Coffee!")
            else -> println("Sorry!!, we don’t have this in menu😔😭")
        }
	}
        
    if(arg.isNullOrEmpty())
        print("Want Beverage? Enter 1 for Tea/ 2 for Coffee!")
    else
    	arg.forEach{createBaverage(it)}
    
}




class Coffee : Beverages(){
    
    override fun getMixtureItems(): List<String> {
        return super.getMixtureItems() + arrayListOf("☕️ Coffee Bag")
    }
    
    override fun makeBeverage(){
        super.addIngredients(getMixtureItems())
        serveCustomer("Coffee")
    }
}

class Tea : Beverages(){
    override fun getMixtureItems(): List<String> {
        return super.getMixtureItems() + arrayListOf("☕️ Tea Bag","Tea masla")
    }
    
    override fun makeBeverage(){
        super.addIngredients(getMixtureItems())
        serveCustomer("Tea")
    }
}

abstract class Beverages() : BasicIncridentProcess{
    
    init{
		gettingStart()
        makeBeverage()
    }
    
    protected fun addIngredients(items : List<String>){
        items.forEach{ item->
            println("adding ${item}")
        }
    }
    
    protected abstract fun makeBeverage()
    
}

interface BasicIncridentProcess{ 
    fun gettingStart(){
        cleanPot()
        println("our Beverage 🪔is getting ready...")
    }
    
    private fun cleanPot(){
        println("Cleaning 🧽* pot")
    }
    
    fun getMixtureItems():List<String>{
        return arrayListOf("💧 hot Water","🍼 hot Milk", "🍫 Suger")
    }
    
    fun serveCustomer(order : String){
        println("${order} 😋 Ready! Enjoy 😉\n\n")
    }
}
