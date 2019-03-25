class MyClass
//メソッド
class Greeter{
    fun greet(name:String){
        println("Hello, $name")
    }
}
//プロパティ
class Person{
    var name:String = "."
    var age:Int = 0
    //nameとageは自動的にバッキングフィールドが生成される
    //バッキングフィールドを持たないプロパティはカスタムゲッターを持つ
    val nameLength:Int
        get():Int{  //カスタムゲッターは対応するプロパティのあとに関数の様に記述する
            return this.name.length
        }
    //get() = this.name.lengthと省略することが出来る
    //カスタムゲッターとは逆に値を設定するカスタムセッターもある
    var height:Int = 0
        set(value){
            println("${value}がセットされました")
            field = value
        }
}

fun main(args:Array<String>){
    val myClass:MyClass = MyClass() //変数myClassの型はMyClass
    println(myClass)

    //メソッド
    val greeter = Greeter()
    greeter.greet("Kotlin") //greetというメソッドを呼び出している

    //プロパティ
    val hanako = Person()
    println(hanako.name)
    println(hanako.age)

    hanako.name = "ハナコ"
    hanako.age = 18
    println(hanako.name)
    println(hanako.age)
    println(hanako.nameLength)

    hanako.height = 160
    println(hanako.height)
}