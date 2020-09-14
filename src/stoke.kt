data class Item(val id:String,var name:String,var qty:Int,var weight:Int)

var items = mutableListOf<Item>()

fun allItems(){
    items.forEach { i->
        println("${i.id} - ${i.name} - ${i.qty} - ${i.weight}")
    }
}

fun addItem(){

    println("name : ")
    val name:String? = readLine()

    println("quantity : ")
    val qty:Int? = readLine()?.toInt()

    println("weight(g) : ")
    val weight:Int? = readLine()?.toInt()

    println("current gold rate(per gram): ")
    val rate:Int? = readLine()?.toInt()

    val id:String = System.currentTimeMillis().toString()

    if (name is String && qty is Int && weight is Int && rate is Int){
        items.add(Item(id,name,qty,weight))
        totalAmount -= (weight*rate*qty)
    }
    else{
        println("invalid data")
    }
}

fun updateItem(){
    try {
        println("id : ")
        val id:String? = readLine()

        for (i in 0 until items.size){
            if (items[i].id == id){
                println("quantity(${items[i].qty}) : ")
                val qty = readLine()?.toInt()
                if (qty != null){
                    if(items[i].qty > qty)
                        items[i].qty = qty
                    else{
                        println("current gold rate(per gram): ")
                        val rate:Int = readLine()!!.toInt()
                        val diff = qty - items[i].qty
                        totalAmount -= (diff*rate*items[i].weight)
                        items[i].qty = qty
                    }
                }
            }else{
                println("invalid item id")
            }
        }
    }catch (e:NumberFormatException){
        println("invalid numbers")
    }

}

fun removeItem(){
    println("id : ")
    val id:String? = readLine()
    for (i in 0 until items.size) {
        if (items[i].id == id) {
            items.removeAt(i)
        }
    }
}

fun purchaseGold(){
    try {
        println("current gold rate(per gram): ")
        val rate:Int? = readLine()?.toInt()
        println("purchased weight :(g) ")
        val weight:Int? = readLine()?.toInt()
        if (weight != null && rate != null){
            totalGold += weight
            totalAmount -= (weight*rate)
        }

    }catch (e:NumberFormatException){
        println("invalid data")
    }
}

fun itemHandler(){
    while (true){
        println("1) all items\n2) add item\n3) remove item\n4) update item\n5) purchase gold\n6) back")
        when(readLine()){
            "1"-> allItems()
            "2"-> addItem()
            "3" -> removeItem()
            "4" -> updateItem()
            "5" -> purchaseGold()
            "6" -> return
        }
    }
}