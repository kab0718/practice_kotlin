//ジェネリクスの導入
class Container<T>(var value:T) //<T>が仮決めの型

//ジェネリクス関数
fun <T> box(value:T):Container<T> = Container(value)

val <T> T.string:String
    get() = toString()

//ジェネリック制約
interface Hoge
interface Fuga
interface Piyo:Hoge,Fuga

class Foo<T>
class Bar<T:Hoge> //上限境界として型を指定
//複数指定も可
class Baz<T> where T:Hoge, T:Fuga
//指定可能な型引数の型は上限境界の型のサブタイプでならないといけないという制約

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

    //制約
    Foo<Hoge>()
    Foo<Fuga>()
    Bar<Hoge>()
    //Bar<Fuga>() コンパイルエラーが発生する
    Baz<Piyo>()
}