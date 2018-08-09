package myConstructions

import geometry_draw._
import scala.tools.nsc.EvalLoop
import geometry_draw.back.evaluate


object test_1 extends EvalLoop with App {
  override def prompt = "> "

  loop { line ⇒
    Parser(line) match {
      case Parser.Success(action, _) ⇒ evaluate(action)
      case e: Parser.NoSuccess  ⇒ println(e)
    }
  }
}

//object test_1 {
//  def main(args: Array[String]): Unit = {
//    evaluate(DrawWithRuler(Point(0.5, 0.5), Point(0.7, 0.5)))
//  }
//}
