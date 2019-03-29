open class Person(val name:String){ //kotlinでは継承させるために修飾子openが必要
    open fun introduceMyself(){
        println("I am $name")
    }
}

//継承
class Student(name:String, val id:Long):Person(name)
//オーバーライド(メンバを上書き)
class Student2(name:String, val id:Long):Person(name){
    override fun introduceMyself(){
        println("I am $name(id=$id)")

        //オーバーライド前のメンバを使うとき
        println("id無しver")
        super.introduceMyself()
    }
}
//openやoverrideを付ければプロパティやセッター・ゲッターも再定義可能

//抽象hoge(hogeのオーバーライドを強制する)
//抽象クラス
abstract class Greeter(val target:String){
    abstract fun sayHello() //抽象メンバ
}

class EnglishGreeter(target:String):Greeter(target){
    override fun sayHello(){
        println("Hello $target!")
    }
}

class JapaneseGreeter(target:String):Greeter(target){
    override fun sayHello(){
        println("こんにちは、$target!")
    }
}

//継承の記述を省略した場合自動的にクラスAnyを継承することになる
fun main(args:Array<String>){
    //継承
    val person:Person = Person("みく")
    person.introduceMyself()

    val student:Student = Student("百合子",417)
    println(student.id)
    println(student.name)
    student.introduceMyself() //スーパクラスのメンバをサブクラスも自動で持つようになる

    val student2:Student2 = Student2("七尾",712)
    student2.introduceMyself()

    //スーパクラスとサブクラス
    val person2:Person = Student2("伊藤",39) //実態はStudent2インスタンスだが見かけ上の方はPerson
    person2.introduceMyself()
    //person.id エラーが出るためコメントアウト
    //見かけ上の型はPersonであるためStudent2で追加したプロパティidにはアクセスできない

    //抽象メンバ
    EnglishGreeter("Kotlin").sayHello()
    JapaneseGreeter("java").sayHello()
}