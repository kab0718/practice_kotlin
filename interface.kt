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

//デリゲーション
interface Greet{
    fun sayHello(target:String)
    fun sayHello()
}

open class JapaneseGreeter:Greet{
    override fun sayHello(target:String){
        println("こんにちは、${target}さん")
    }
    override fun sayHello(){
        println("こんにちは、匿名さん")
    }
}

//デリゲーション...あるオブジェクトの仕事を別のオブジェクトに任せる
class JapaneseGreeterWithRecording:Greet{

    private val greeter:Greet = JapaneseGreeter()

    private val _targets:MutableSet<String> = mutableSetOf()

    val targets:Set<String>
        get() = _targets

    override fun sayHello(){
        greeter.sayHello()
    }

    override fun sayHello(target:String){
        _targets += target
        greeter.sayHello(target)
    }
}

//クラスデリゲーション
class GreeterWithRecording2(private val greeter:Greet):Greet by greeter{
    //by greeterは「このクラスはインタフェースGreetを実装するけどオーバーライドしてないメンバはgreeterに移譲する」という表記
    private val _targets:MutableSet<String> = mutableSetOf()

    val targets:Set<String>
        get() = _targets

    override fun sayHello(target:String){
        _targets += target
        greeter.sayHello(target)
    }
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

    val greeter:JapaneseGreeter = JapaneseGreeter()
    greeter.sayHello()
    greeter.sayHello("みく")

    val greeter2:JapaneseGreeterWithRecording = JapaneseGreeterWithRecording()
    greeter2.sayHello("伊藤")
    greeter2.sayHello("夏川")
    println(greeter2.targets)
    greeter2.sayHello()
    println(greeter2.targets)
}