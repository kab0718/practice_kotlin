//ジェネリクスの導入
class Container<T>(var value:T) //<T>が仮決めの型

//ジェネリクス関数
fun <T> box(value:T):Container<T> = Container(value)

val <T> T.string:String
    get() = toString()

fun main(args:Array<String>){
    //導入
    val intContainer:Container<Int> = Container<Int>(123)
    val i:Int = intContainer.value
    println(i*2)

    val strContainer = Container("hello") //型引数を省略した
    println(strContainer.value)

    //ジェネリクス関数
    val container:Container<Int> = box(5)
    println(container.value)
    println(container.string)
}