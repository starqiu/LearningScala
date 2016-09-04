/**
  * Created by starqiu on 16-9-4.
  */
class Match {
  def swap(pair:(Int, Int)) = pair match {
    case (x,y)=>(y,x)
  }
  swap((3,4))

  def swap(arr:Array[Int]) = arr match {
    case Array(x,y,rest @ _*)=>Array(y,x) ++ rest
  }

  swap(Array(1,2,3,4))

  def leafSum(lst: List[Any]) :Int = lst match {
    case head :: tail => head match {
      case x: Int => x + leafSum(tail)
      case l: List[Any] => leafSum(l) + leafSum(tail)
    }
    case _ => 0
  }

  leafSum(List(List(3,8),2,List(5)))
}
