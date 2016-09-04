import java.io.File

import akka.actor.{Props, ActorSystem, Actor}
import com.typesafe.config.{ConfigFactory, Config}

case class Message(id: Int, msg: String){}

class HelloActor extends Actor {
  override def receive: Actor.Receive = {
    case "hello" => println("world")
    case _ => println("uh?")
  }
}
val conf = ConfigFactory.parseFile(new File("./application.conf"))
val system = ActorSystem("HelloSystem",conf)
println(system.settings)
// default Actor constructor
val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
helloActor ! "Hello"
