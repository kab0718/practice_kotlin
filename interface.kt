interface Greeter{
    //インタフェースのメンバは基本的に抽象メンバ
    val language:String
    fun sayHello(target:String) 
}

//クラスにインタフェースを実装する形で利用する。継承と似ている
//継承と違い複数のインタフェースを実装できる
class EnglishGreeter:Greeter{
    override val language = "English"
    override fun sayHello(target:String){
        println("Hello, $target!")
    }
}

//インタフェース同士で同一シグネチャ
interface Foo{
    fun execute()
}

interface Bar{
    fun execute()
}

class FooBar:Foo, Bar{
    override fun execute(){
        println("FooBar")
    }
}
//オーバーライドすれば問題ない

//クラスとインタフェースで同一シグネチャ
interface Fee{
    fun execute()
}

open class Superclass{
    open fun execute(){
        println("superclass")
    }
}

class FeeSubclass:Superclass(), Fee{
    override fun execute(){
        println("FeeSubclass")
    }
}
//Superclassで既に実装されているためクラスFeeSubclassにオーバーライド義務はない

//実装を持った二つのインタフェース
interface Hoge{
    fun execute(){
        println("hoge")
    }
}

interface Fuga{
    fun execute(){
        println("fuga")
    }
}

class HogeFuga:Hoge,Fuga{
    //このままではどちらのexecuteを使うか曖昧なためコンパイルに失敗する
    //この場合既に提供されている実装を使いたくてもオーバーライドする必要がある
    override fun execute(){
        super<Hoge>.execute() //これでオーバーライドしたうえでインタフェースHogeの実装を利用できる
    }
}

//インタフェースの継承
interface Fuu{
    fun aaa()
    fun bbb()
}

interface Ber:Fuu{
    override fun aaa(){}
    fun ccc()
}

class Baz:Ber{
    override fun bbb(){}
    override fun ccc(){}
}

fun main(args:Array<String>){
    val english:EnglishGreeter = EnglishGreeter()
    english.sayHello(english.language)

    val foobar:FooBar = FooBar()
    foobar.execute()

    val feesub:FeeSubclass = FeeSubclass()
    feesub.execute()
    Superclass().execute()

    val hogefuga:HogeFuga = HogeFuga()
    hogefuga.execute()
}