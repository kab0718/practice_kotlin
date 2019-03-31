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

fun main(args:Array<String>){
    val english:EnglishGreeter = EnglishGreeter()
    english.sayHello(english.language)
}