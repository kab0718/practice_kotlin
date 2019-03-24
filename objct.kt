fun main(args:Array<String>){
    //オブジェクトの生成
    val bucket = object{
        //容量
        val capacity:Int = 5

        //入っている量
        var quantity:Int = 0

        //バケツを水で満たす
        fun fill(){
            quantity = capacity
        }

        //排水する
        fun drainAway(){
            quantity = 0
        }

        //現在の水の量を出力
        fun printQuantity(){
            println(quantity)
        }
    }
    bucket.printQuantity()
    bucket.fill()
    bucket.printQuantity()
    bucket.drainAway()
    bucket.printQuantity()
}