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

//ラムダ式と高階関数の組み合わせ
fun firstWhitespace(str:String): Int =
    first(str,{it.isWhitespace()})
    //first(str){it.isWhitespace}でも可

fun getCounter(): () -> Int{
    var cnt = 0
    return { cnt++ }
}

//インライン関数
inline fun log(debug:Boolean = true, message:() -> String){
    if(debug){
        println(message())
    }
}

fun main(args:Array<String>){
    val functionObject = ::square //関数オブジェクトを変数に代入
    //型を明示的に指定した場合
    val functionObject2: (Int) -> Int = ::square //(Int)->intが型で,Intの引数を一つ取りIntの値を返す関数を示す

    //ラムダ式
    val square_lambda: (Int) -> Int = {
        i: Int -> i*i
    }
    //ラムダ式でも型推論は働く。省略の仕方が2種類ある
    val square1_lambda = {
        i: Int -> i*i
    }
    val square2_lambda: (Int) -> Int = {
        i -> i*i
    }

    //引数が1つの時に限り暗黙の変数itを利用可能
    val square3_lambda: (Int) -> Int = {
        it*it
    }

    //クロージャ
    val counter1 = getCounter()
    val counter2 = getCounter()

    println(functionObject(5))
    println(functionObject2(3))
    println(square_lambda(7))

    println(counter1())
    println(counter1())
    println(counter2())
    println(counter1())
    println(counter2())

    log(true){"このメッセージは表示される"} //ラムダ式を引数としている。
    log(false){"このメッセージは表示されない"}
}