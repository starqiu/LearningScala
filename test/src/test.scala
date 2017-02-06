/**
  * Created by starqiu on 16-11-13.
  */
class test {

}
object hbaseTest extends App{
  val line1 = "k1\ta1\tb1"
  val line2 = "k1\ta2\tb1"
  val line3 = "k2\ta2\tb2"
  val lines = Array(line1, line2, line3)

  val lineg = lines.groupBy(line=>line.split("\t")(0))
  val schemasWithId = Array("c1\t1","c2\t1","c3\t1")
  val l = lineg.mapValues(lines => {
    lines.flatMap(line => schemasWithId zip line.split("\t") filterNot(_._1.equals("c1\t1"))).distinct
  })

  val g = l.mapValues(_.groupBy(_._1).mapValues(vs =>vs.map(_._2).mkString("\t")))

  l.foreach(sv=> {
    print(s"${sv._1}\n")
    sv._2.foreach(v => print("\t"+v._1 + "," + v._2 + "\n"))
  })
}