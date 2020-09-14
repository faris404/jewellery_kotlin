data class Partner(val id:String,var name:String,var amount:Int)

var partners = mutableListOf<Partner>()

fun addPartner(){
    println("partner name : ")
    var name:String? = readLine()
    println("amount : ")
    var amount:Int? = readLine()?.toInt()
    if (amount is Int && name is String){
        totalAmount += amount
        val id = System.currentTimeMillis().toString()
        var p = Partner(id,name,amount)
        partners.add(p)
    }else{
        println("invalid name or amount")
    }

}

fun removePartner(){
    println("id : ")
    var id:String? = readLine()
    for (i in 0 until partners.size){
        if (partners[i].id == id){
            totalAmount -= partners[i].amount
            partners.removeAt(i)
        }
    }
}

fun allPartners(){
    partners.forEach { p->
        println("${p.id} - ${p.name} - ${p.amount}")
    }
}

fun partnersHandler(){
    while (true){
        println("1) all partners\n2) add partner\n3) remove partners\n4) back")
        var opt:String? = readLine()
        when(opt){
            "1"-> allPartners()
            "2"-> addPartner()
            "3" -> removePartner()
            "4" -> return
        }
    }
}