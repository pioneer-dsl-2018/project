package myConstructions

import geometry_draw.Parser

import scala.tools.nsc.EvalLoop
import geometry_draw.back.evaluate

object main extends EvalLoop with App {
  override def prompt = "> "

  loop { line ⇒
    Parser(line) match {
      case Parser.Success(action, _) ⇒ evaluate(action)
      case e: Parser.NoSuccess  ⇒ println(e)
    }
  }
}
