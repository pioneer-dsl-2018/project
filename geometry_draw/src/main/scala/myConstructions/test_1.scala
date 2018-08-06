package myConstructions
import geometry_draw._

//object test_1 {
//  def main(args: Array[String]): Unit = {
//    DrawWithRuler(Point(0.5, 0.5), Point(0.7, 0.5))
//
//  }
//}

object test_1 extends EvalLoop with App {
  override def prompt = "> "

  loop { line ⇒
    Parser(line) match {
      case Parser.Success(t, _) ⇒ println(evaluate(t))
      case e: Parser.NoSuccess  ⇒ println(e)
    }
  }
}
