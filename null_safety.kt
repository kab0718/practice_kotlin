fun main(args:Array<String>){
    //nullとなりえるか否かを明確に区別する
    val s:String? = null //型の後ろに?を置くことでnullを代入できる
    //nullの可能性がある参照に対して(中身に関係なく)メソッドやプロパティのアクセスは出来ない
    println(s)

    //スマートキャスト
    //スマートキャストを使うことでnullとなり得る型のメソッドやプロパティにアクセスできるようになる
    val a:String? = null
    val b:String? = "hello"

    if(a != null){
        println(a.toUpperCase())
    }
    if(b != null){
        println(b.toUpperCase())
    }
}