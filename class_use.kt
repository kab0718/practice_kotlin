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
}