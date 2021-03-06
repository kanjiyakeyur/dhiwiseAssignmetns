fun main(arg : Array<String>) {
    
    fun createBaverage(order : String){
       
    	when(order){
            "1" -> Tea()
            "2" -> Coffee()
            "" -> print("Want Beverage? Enter 1 for Tea/ 2 for Coffee!")
            else -> println("Sorry!!, we donβt have this in menuππ­")
        }
	}
        
    if(arg.isNullOrEmpty())
        print("Want Beverage? Enter 1 for Tea/ 2 for Coffee!")
    else
    	arg.forEach{createBaverage(it)}
    
}




class Coffee : Beverages(){
    
    override fun getMixtureItems(): List<String> {
        return super.getMixtureItems() + arrayListOf("βοΈ Coffee Bag")
    }
    
    override fun makeBeverage(){
        super.addIngredients(getMixtureItems())
        serveCustomer("Coffee")
    }
}

class Tea : Beverages(){
    override fun getMixtureItems(): List<String> {
        return super.getMixtureItems() + arrayListOf("βοΈ Tea Bag","Tea masla")
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
        println("our Beverage πͺis getting ready...")
    }
    
    private fun cleanPot(){
        println("Cleaning π§½* pot")
    }
    
    fun getMixtureItems():List<String>{
        return arrayListOf("π§ hot Water","πΌ hot Milk", "π« Suger")
    }
    
    fun serveCustomer(order : String){
        println("${order} π Ready! Enjoy π\n\n")
    }
}
