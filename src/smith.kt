
data class Smith(val id:String, var name:String, var givenGold:Int,var returned:Int)

var smiths = mutableListOf<Smith>()

fun allSmith(){
    smiths.forEach { s->
        println("${s.id} - ${s.name} - ${s.givenGold} - ${s.returned}")
    }
}

fun removeSmith(){
    println("id : ")
    val id = readLine()
    if(id != null){
        for (i in 0 until smiths.size){
            if (smiths[i].id == id){
                smiths.removeAt(i)
            }
        }
    }
}
fun addSmith(){
    try {
        println("name : ")
        val name:String? = readLine()
        println("gold given(g) : ")
        val gold:Int? = readLine()?.toInt()
        val id = System.currentTimeMillis().toString()
        if (gold!=null && name != null){
            smiths.add(Smith(id,name,gold,0))
            totalGold -= gold
        }
    }catch (e:NumberFormatException){
        println("invalid data")
    }
}

fun goldToSmith(){
    try {
        println("id : ")
        val id:String? = readLine()
        println("gold to give(g) : ")
        val gold:Int? = readLine()?.toInt()

        if (gold!=null && id != null){
            for (i in 0 until smiths.size){
                if(smiths[i].id == id){
                    smiths[i].givenGold += gold
                    totalGold -= gold
                }
            }

        }
    }catch (e:NumberFormatException){
        println("invalid data")
    }
}

fun goldFromSmith(){
    println("smith id : ")
    val sId = readLine()
    println("how many items returned? ")
    val n = readLine()!!.toInt()
    for (i in 0 until n){
        println("item id: ")
        val id = readLine()
        println("quantity : ")
        val qty = readLine()?.toInt()
        for(j in 0 until items.size){
            if(items[j].id == id){
                if (qty != null) {
                    val returned = qty.times(items[j].weight)
                    items[j].qty+=qty
                    for(k in 0 until smiths.size){
                        if (smiths[k].id == sId){
                            smiths[k].returned += returned
                        }
                    }
                }
            }
        }
    }
}

fun  smithHandler(){
    while (true){
        println("1) all smiths\n2) add smith\n3) remove smith\n4) gold to smith\n5) items from smith\n6) back")
        when(readLine()){
            "1"-> allSmith()
            "2"-> addSmith()
            "3" -> removeSmith()
            "4" -> goldToSmith()
            "5" -> goldFromSmith()
            "6" -> return
        }
    }
}