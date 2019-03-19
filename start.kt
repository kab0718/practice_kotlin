fun main(args:Array<String>){

    val name = "Miku"
    println("Hello,"+name+"!")
    println("Hello,${name}!")
    println("Hello,$name!")
    println("""
    Hello,
    $name!""") //Helloの前の改行や$nameの前の空白も表示される

    println("""
    |It's
    |sunnuy
    |today""".trimMargin()) //trimMarginによって目印として置いた|を文字列に含まないようにしている

    val ints = arrayOfNulls<Int>(5)
    println("配列のサイズは${ints.size}です")
    println("要素0は${ints[0]}です")
    ints[0] = 417
    println("代入した結果、要素0は${ints[0]}になりました")

    val strs = arrayOf("red","green","blue") //要素の型から推測できるため型引数は省略できる
    println(strs[0])

    val inst: List<Int> = listOf<Int>(1,2,3)
    println("リストの中身は${inst}です")
    println("リストのサイズは${inst.size}です")
    println("リストの要素[1]は${inst[1]}です")

    val chars:MutableList<Char> = mutableListOf('a','b')
    println("以下はmutablelistで変更可能となったリストです")
    println("中身は${chars}です")
    chars[0] = 'c'
    println("中身が${chars}に変わりました")
    chars += 'Z'
    println("中身が${chars}に変わりました")
    chars -= 'b'
    println("中身が${chars}に変わりました")
    println("要素${chars.removeAt(0)}を削除")
    println("中身が${chars}になりました")

    val chset:MutableSet<Char> = mutableSetOf('s','c','s','q')
    println("セットの中身は${chset}です")
    chset -= 'c'
    println("セットの中身が${chset}に変わりました")

    val numberMap:MutableMap<String,Int> = mutableMapOf("one" to 1, "two" to 2)
    println("マップの中身は${numberMap}です")
    println("キーが[one]の時の値は${numberMap["one"]}です")
    println("キーが[three]の時の値は${numberMap["three"]}です")
    numberMap += "three" to 3
    println("キーと値が追加されました。\nキーが[three]の時の値は${numberMap["three"]}です")

    println((1..10).toList())
    println((1000 downTo 0 step 200).toList())

    val score = 74
    if(score >= 60){
        println("赤点ではありません")
    }
    else{
        println("赤点です")
    }

    val message = if(score>=60) "赤点回避" else "赤点" //評価後、値となる
    println(message)

    val grade = if(score>=80){
        "優"
    }else if(score >= 70){
        "良"
    }else if(score >= 60){
        "可"
    }else{
        "不可"
    }
    println("あなたの現代文の成績は${score}点なので${grade}です")

    //else if文は下記の様に書くこともできる
    /*
    when{
       score >= 90 -> "優"
       score >= 70 -> "良"
       score >= 60 -> "可"
       else -> "不可"
    }
    */

    var count = 3
    while(count > 0){
        println("${count}回目のhello")
        count--
    }

/*
    do{
        println("hello")
        val next = Math.random() < 0.5 //乱数で生成した値が0.5以下であればtrue。以上であればfalse
        println(next)
    }while(next)
*/
    val names = listOf("しーな","みく","あんな")
    for(nam in names){
        println(nam)
    }

    for(i in 1..10 step 3){
        println(i)
    }

/* 謎のwarnigが出てくるからコメントアウト
    var mIndex = -1
    for(index in names.indices){
        //"みく"が見つかったらループから抜ける
        if(names[index] == "みく"){
            mIndex = index
            break
        }
        println(names[index])
    }
*/

    loop@ for(x in 1..10){
        for(y in 1..10){
            println("xの値:${x},yの値${y}")
            if(y==5) break@loop //y=5になったとき@loopがついてある一つ目のfor文から抜ける
        }
    }

}