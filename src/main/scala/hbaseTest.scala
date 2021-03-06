/**
  * Created by starqiu on 16-11-13.
  */
class hbaseTest {

}

object hbaseTest extends App{
  val line1 = "k1\ta1\tb1"
  val line2 = "k1\ta2\tb1"
  val line3 = "k2\ta2\tb2"
  val lines = Array(line1, line2, line3)

  val lineg = lines.groupBy(line=>line.split("\t")(0))
  val schemasWithId = Array("c1\t1","c2\t1","c3\t1")
  val l = lineg.map(klines => {
    (klines._1, klines._2.flatMap(line => schemasWithId zip line.split("\t") filter(_._1.equals("c1"))).distinct)
  })

  l.foreach(sv=> {
    print(s"${sv._1},")
    sv._2.foreach(v => print(v._1 + "," + v._2 + "\n"))
  })
}