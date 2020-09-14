import kotlin.system.exitProcess

fun customerPurchase(){

    var totalPurchaseAmount = 0
    println("current gold rate(per gram) : ")
    val currentGoldRate = readLine()!!.toInt()
    println("how many items purchased? ")
    val n = readLine()?.toInt()

    if(n !== null){
        for (i in 1..n){
            var isItemFound = false
            println("item id: ")
            val itemId = readLine()
            println("no of items : ")
            val noItems = readLine()!!.toInt()

            for (j in 0 until items.size){
                if (items[j].id == itemId){
                    isItemFound = true
                    if (items[j].qty > noItems){
                        items[j].qty -= noItems
                        totalPurchaseAmount += items[j].weight*noItems*currentGoldRate
                    }else{
                        println("no $noItems items left")
                    }
                }
                if (!isItemFound){
                    println("item not found")
                    exitProcess(0)
                }

            }
        }
        totalAmount += totalPurchaseAmount
        println("total amount = $totalPurchaseAmount")
    }
}
