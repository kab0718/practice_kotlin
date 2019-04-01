fun square(i:Int):Int = i*i

fun main(args:Array<String>){
    //nullとなりえるか否かを明確に区別する
    val s:String? = null //型の後ろに?を置くことでnullを代入できる
    //nullの可能性がある参照に対して(中身に関係なく)メソッドやプロパティのアクセスは出来ない
    println(s)

    //スマートキャスト
    //スマートキャストを使うことでnullとなり得る型のメソッドやプロパティにアクセスできるようになる
    val a:String? = null
    val b:String? = "hello"

    if(a != null){              //ここでaがnullじゃないことを確認しているためこのブロックではaをString型として扱える
        println(a.toUpperCase())
    }
    if(b != null){
        println(b.toUpperCase())
    }

    //安全呼び出し
    val c:Int? = 3
    val d:Int? = null
    val cInc:Int? = c?.inc()
    val dInc:Int? = d?.inc()
    //オブジェクトへの参照がnullの時はnullを返し、nullじゃないときメンバアクセスに成功する
    println(cInc)
    println(dInc)

    val f:Int? = 5
    val fSquare = f?.let{square(it)} //もし変数fがnullであればnullが返される。nullで無ければ拡張関数letが呼ばれる
    //letはレシーバをletの引数である関数オブジェクトの引数として渡しているため、結果的にsquare関数にfを渡している
    println(fSquare)

}