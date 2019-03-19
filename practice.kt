fun main(args:Array<String>){
    var name = "しーな" //可変変数 var
    val sail = "みく" //不可変変数 val

    println(name)
    println(sail)

    //変数の型宣言
    val number:Int = 1
    val namae:String
    namae = "杏奈"
    println("${namae}が${number}番目に可愛い")

    //読み取り専用(不可変)の集合体:List
    val num:List<Int>
    num = listOf(4,1,7,3,9)
    var nun:List<Int>
    nun = listOf(3,2)

    val birds = listOf("スズメ","ツバメ","カラス")
    println("${birds[1]}が${num[4]}匹")
    println(nun)
    nun = listOf(1,4,8,6) //varで宣言すると新しい集合体に置き換えることが出来る
    println(nun)

    //変更可能な集合体:MutableList
    val numbers:MutableList<Int>
    numbers = mutableListOf(1,0,2,4,8)
    println(numbers.toString())

    numbers.add(9) //valで宣言しても集合体そのものは変わらず中身を変えているだけなので問題なし
    numbers[1] = 5
    println(numbers.toString())

    //配列
    val astrs = arrayOf("アオ","クロ","シロ")
    println(astrs[1] + "色")
    astrs[1]="ミドリ" //要素数は変えれないが要素の値は変更可能
    println(astrs[1] + "色")

    //map:キーと値のペア
    val mmap = mapOf(
        15 to "みく",
        2 to "しーな",
        3 to "れいな",
        4 to "ゆりこ"
    )
    println(mmap[15])
    println(mmap[2])

    name = "みく"
    when(name){
        "しーな"->println("夏川椎菜さん")
        "みく"->println("伊藤美来さん")
        else->println("だれ？")
    }

    for(ast in astrs){ //astrsから取り出した要素をastとしている
        println("${ast}色")
    }

    val signs = listOf("伊藤美来さん","夏川椎菜さん","上田麗奈さん")
    for(i in signs.indices){ //何番目の要素かを示すインデックスをiに入れている
        println("${signs[i]}は${i+1}番目に好きです")
    }
    val act = mapOf(
        "伊藤美来さん" to "七尾百合子",
        "夏川椎菜さん" to "望月杏奈",
        "上田麗奈さん" to "高坂海美",
        "雨宮天さん" to "北沢志保"
    )
    for((key,value) in act){ //mapはキーと値があるためキーをkeyに、値をvalueに入れている
        println("${key}は${value}役です")
    }
    
}