/**
  * Created by starqiu on 16-9-2.
  */
class Temp {
  import java.io.PrintWriter

  import scala.collection.immutable.TreeMap

  val simap = Map("A"->1,"B"->2)
  simap+("C"->3)
  import sys.process._
  import io.Source
  val name = "/program/test.txt"
  def revFile(name:String):Unit = {
    val linesRev = Source.fromFile(name).getLines().toArray.reverse
    val out = new PrintWriter(name)
    for (line <- linesRev){
      out.println(line)
    }
    out.close()

  }

  revFile(name)
  Source.fromFile(name).mkString.split("\\s+").filter(_.length>2).foreach(println _)
  import math.Ordered
  import java.awt.Point
  class OrderedPoint extends Point with Ordered[Point]{
    override def compare(that: Point): Int = {
      if (x == that.x){
        y - that.y
      }else{
        x - that.x
      }
    }
  }

  1+2 -> 10
}
