class MyClass

class Greeter{
    fun greet(name:String){
        println("Hello, $name")
    }
}

fun main(args:Array<String>){
    val myClass:MyClass = MyClass() //変数myClassの型はMyClass
    println(myClass)

    val greeter = Greeter()
    greeter.greet("Kotlin") //greetというメソッドを呼び出している
}