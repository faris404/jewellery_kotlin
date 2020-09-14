var totalAmount:Int = 0
var totalGold:Int = 0

fun details(){
    println("total amount left $totalAmount")
    println("total gold left $totalGold")
}
fun main(){
    while (true){
        println("1) partners\n2) gold stoke\n3) smith\n4) details\n5) customer\n6) quit")
        when(readLine()){
            "1"-> partnersHandler()
            "2" -> itemHandler()
            "3" -> smithHandler()
            "4" -> details()
            "5" -> customerPurchase()
            "6" -> return
        }
    }
}