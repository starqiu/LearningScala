import scala.collection.immutable.IndexedSeq

/**
  * Created by starqiu on 16-8-10.
  */
class CollectionsTest {
  (Map[Char,Int]() /: "misss"){
    (m,c)=>m+(c->(m.getOrElse(c,0)+1))
  }


  "misss"./:(Map[Char,Int]()){
    (m,c)=>m+(c->(m.getOrElse(c,0)+1))
  }

  (1 to 10).scanLeft(0)  (_+_)

  Stream.from(1).take(5).force

  import collection.mutable.SortedSet
  def indexes(s : String) = {
    (s zipWithIndex)./:(Map[Char,SortedSet[Int]]()){
      (m,c)=>m+(c._1->(m.getOrElse(c._1,SortedSet[Int]())+ c._2))
    }
  }

  indexes("Mississippi")

  def getMappingValues(keys:Array[String], kvmap: Map[String,Int]) = {
    keys flatMap (kvmap get _)
  }

  val keys = Array("Tom","Fred","Harry")
  val kvmap = Map("Tom"->3,"Dick"->4,"Harry"->5)
  getMappingValues(keys,kvmap)

  val lst = List(1,2,3,4,5)
  println((lst :\ List[Int]())(_ :: _))
  lst./:(List[Int]())(_ :+ _)
  println((List[Int]() /: lst)((a,b) => b :: a))
}

object CollectionsTest{

  def main(args: Array[String]) {
    val fruit:List[String] = "orange" :: "apple" :: "pear" :: Nil
    fruit map (_ + " ") foreach (print)
    print("\n")
    fruit.map(_ + "   ").foreach(print)
    print("\n")
    fruit.init.foreach(print)
    print("\n")

    val ij:IndexedSeq[(Int, Int)] = for{
      i <- 1 to 5
      j <- 6 to 10
    } yield (i,j)
    ij.foreach(print)
    print("\n")
  }
}
