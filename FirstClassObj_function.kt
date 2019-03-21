fun square(i:Int):Int = i*i

/*
//最初にKが出現する位置を返す関数
fun firstK(str:String): Int{
    tailrec fun go(str:String, index:Int):Int =
        when{
            str.isEmpty() -> -1
            str.first() == 'K' -> index
            else -> go(str.drop(1), index + 1)
        }
    return go(str, 0)
}

//最初に大文字が出現する位置を返す関数
fun firstUpperCase(str:String): Int{
    tailrec fun go(str:String, index:Int):Int =
        when{
            str.isEmpty() -> -1
            str.first().isUpperCase() -> index
            else -> go(str.drop(1), index + 1)
        }
    return go(str, 0)
}
*/

//上記二つの関数には多くの共通部があるため共通部を再利用できるようにする
fun first(str:String, predicate:(Char) -> Boolean): Int{
    tailrec fun go(str:String, index:Int):Int =
        when{
            str.isEmpty() -> -1
            predicate(str.first()) -> index
            else -> go(str.drop(1), index + 1)
        }
    return go(str, 0)
}

fun firstK(str:String):Int{
    fun isK(c:Char):Boolean = c == 'K'
    return first(str, ::isK)
}

fun firstUpperCase(str:String):Int{
    fun isUpper(c:Char):Boolean = c.isUpperCase()
    return first(str, ::isUpper)
}

fun main(args:Array<String>){
    val functionObject = ::square //関数オブジェクトを変数に代入
    //型を明示的に指定した場合
    val functionObject2: (Int) -> Int = ::square //(Int)->intが型で,Intの引数を一つ取りIntの値を返す関数を示す

    println(functionObject(5))
    println(functionObject2(3))
}