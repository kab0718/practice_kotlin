interface Bucket{
    //インタフェースはデータを持てないため実装を記述しない
    fun fill()
    fun drainAway()
    fun pourTo(that: Bucket)

    //容量と入っている水の量というデータにアクセスするためのメソッド
    fun getCapacity():Int
    fun getQuantity():Int
    fun setQuantity(quantity:Int)
}

//プロパティ
interface Bucket2{
    fun fill()
    fun drainAway()
    fun pourTo(that: Bucket2)

    //変数ではなくプロパティ
    val capacity:Int
    var quantity:Int
}

fun createBucket(capacity:Int):Bucket = object:Bucket{
    var _quantity:Int = 0

    //インタフェースが提供するメソッドを上書きするときに必ずoverrideを使う
    override fun fill(){
        setQuantity(getCapacity())
    }

    override fun drainAway(){
        setQuantity(0)
    }

    override fun pourTo(that:Bucket){
        val thatVacuity = that.getCapacity() - that.getQuantity()
        if(getCapacity() <= thatVacuity){
            that.setQuantity(that.getQuantity() + getQuantity())
            drainAway()
        }
        else{
            that.fill()
            setQuantity(getQuantity() - thatVacuity)
        }
    }

    override fun getCapacity():Int = capacity

    override fun getQuantity():Int = _quantity

    override fun setQuantity(quantity:Int){
        _quantity = quantity
    }
}

fun createBucket2(_capacity:Int):Bucket2 = object:Bucket2{

    override val capacity = _capacity

    override var quantity:Int = 0

    override fun fill(){
        quantity = capacity
    }

    override fun drainAway(){
        quantity = 0
    }

    override fun pourTo(that:Bucket2){
        val thatVacuity = that.capacity - that.quantity
        if(capacity <= thatVacuity){
            that.quantity += quantity
            drainAway()
        }
        else{
            that.fill()
            quantity -= thatVacuity
        }
    }
}

fun main(args:Array<String>){
    //オブジェクトの生成
    val bucket = object{
        //容量
        val capacity:Int = 5

        //入っている量
        var quantity:Int = 0

        //バケツを水で満たす
        fun fill(){
            quantity = capacity
        }

        //排水する
        fun drainAway(){
            quantity = 0
        }

        //現在の水の量を出力
        fun printQuantity(){
            println(quantity)
        }
    }
    bucket.printQuantity()
    bucket.fill()
    bucket.printQuantity()
    bucket.drainAway()
    bucket.printQuantity()

    //インタフェース
    //容量12のバケツ
    val bucket2 = createBucket(12)
    //容量7のバケツ
    val bucket3 = createBucket(7)

    //バケツ2を満たす
    bucket2.fill()

    //バケツ2からバケツ3へ可能な限りそそぐ
    bucket2.pourTo(bucket3)

    println(bucket2.getQuantity())
    println(bucket3.getQuantity())

    //プロパティ
    //容量8のバケツ
    val bucket4 = createBucket2(8)
    //容量3のバケツ
    val bucket5 = createBucket2(3)

    //バケツ4を満たす
    bucket4.fill()

    //バケツ4からバケツ5へ可能な限りそそぐ
    bucket4.pourTo(bucket5)

    println(bucket4.quantity)
    println(bucket5.quantity)

}