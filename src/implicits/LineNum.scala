package implicits

/**
  * Created by starqiu on 16-4-10.
  */
class LineNum(val num:Int){
  def + ( that : LineNum ) = new LineNum( this.num + that.num )
}

object LineNum{
  implicit def intToLineNum(num:Int) = new LineNum(num)
  implicit def lineNumToInt(lineNum:LineNum) = lineNum.num
}


object Main extends  App{
  val line1 = new LineNum(4)
  val line2 = new LineNum(5)

  import LineNum._
  val tl1 = line1 + 6
  val tl2 = 7 + line2

  println(tl1)
  println(tl2)

}