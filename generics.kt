//ジェネリクスの導入
class Container<T>(var value:T) //<T>が仮決めの型

fun main(args:Array<String>){
    val intContainer:Container<Int> = Container<Int>(123)
    val i:Int = intContainer.value
    println(i*2)

    val strContainer = Container("hello") //型引数を省略した
    println(strContainer.value)
}