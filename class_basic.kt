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

//コンストラクタ
//class Rational constructor(n:Int, d:Int)
class Rational(val numerator:Int, val denominator:Int){
    //val numerator:Int = n
    //val denominator:Int = d

    //セカンダリコンストラクタは複数作ることが出来る
    //denominatorに自動で1を設定するセカンダリコンストラクタ
    constructor(numerator:Int):this(numerator,1)

    //イニシャライザ
    init{
        //要求に反した場合、例外をスローする標準ライブラリの関数
        require(denominator != 0)
    }
}

//エクステンション(拡張関数や拡張プロパティ)
//拡張関数ver
fun String.countWords():Int =
    this.split("""\s+""".toRegex()).size //空白文字で分割して作ったリストの要素数を返す
//拡張プロパティver
val String.wordsCount:Int
    get() = split("""\s+""".toRegex()).size



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

    //コンストラクタ
    val half = Rational(1,2)
    println(half.numerator)
    println(half.denominator)

    println("${half.numerator}/${half.denominator}")
    val five = Rational(5)
    println("${five.numerator}/${five.denominator}")
    Rational(1,1)
    //Rational(1,0) //IllegalArgumentExceptionが投げられる

    //エクステンション
    println("I like Kotlin".countWords())
    println("I don't use Java".wordsCount)
}