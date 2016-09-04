/**
  * Created by starqiu on 16-9-2.
  */
class HigherFunction {
  "Mary has a little lamp ".split(" ").sortBy(_ length)

  def values(func: Int=>Int, low :Int, high: Int) ={
    val rg = low to high
    rg zip (rg map func)
  }

  values(x=>x*x, -5, 5)
  Array(1,3,-1,2).reduceLeft(_ max  _)
  1 to 10 reduceLeft(_ * _)

  1 to 0 foldLeft 1 (_ * _)

  def largest(func: Int=>Int, inputs: Seq[Int]) = {
    inputs map func reduceLeft (_ max _)
  }

  largest(x=>10*x - x*x, 1 to 10)

  def largestAt(func: Int=>Int, inputs: Seq[Int])= {
    val res =  inputs map func zip inputs
    res reduceLeft ((x,y)=>if (x._1>y._1) x else y) _2
  }

  largestAt(x=>10*x - x*x, 1 to 10)

  def adjustPair(func:(Int,Int)=>Int)(x:(Int,Int)):Int ={
    func(x._1,x._2)
  }

  adjustPair(_ * _)((6,7))
  (1 to 10) zip (11 to 20) map adjustPair(_ + _)

  val a = Array("ab","cde")
  val b = Array(2,3)
  a.corresponds(b)(_.length == _)

}
