//fun succ(i:Int): Int = i+1
fun succ(i:Int) = i+1
fun square(i:Int) = i*i
fun hello(str:String) = "Hello ${str}!"
fun max(a:Int,b:Int) = if(a>=b) a else b

fun sum(ints: Array<Int>):Int{ //引数として配列を受け取り配列の各要素の総和を返す関数
    var sum = 0
    for(i in ints){
        sum += i
    }
    return sum
}

fun sub(minuend:Int,subtrahend:Int):Int = minuend - subtrahend //引数に名前を付けている

fun hello2(str:String = "World") = "Hello ${str}!" //引数にデフォルト値を設定

fun sum2(vararg ints:Int):Int{ //varargをつけることで可変長引数となる
    var sum = 0
    for(i in ints){
        sum += i
    }
    return sum
}

fun main(args:Array<String>){
    val result = succ(31)
    val ints = intArrayOf(3,2,10)

    println(result)
    println(square(2))
    println(hello("Akane"))
    println(max(10,1))
    println(sum(arrayOf(1,4,7,9)))
    println(sub(5,3))
    println(sub(minuend = 12,subtrahend = 5))
    println(hello2())
    println(hello2("Shiho"))
    println(sum2(4,1,8))
    println(sum2(*ints)) //可変長引数として配列を渡すために*を使っている
}