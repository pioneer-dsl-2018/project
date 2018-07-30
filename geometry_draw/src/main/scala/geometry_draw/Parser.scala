package geometry_draw

import scala.util.parsing.combinator._

/*
Grammar Design

Draw with Ruler from Point_1 to Point_2
Draw with Compass clockwise from Point_3 with radius 5 from 0 to 80
Mark Point_1 as Apple
Change Point_1 color to black

*/

object Parser extends JavaTokenParsers with PackratParsers{
  def apply(s: String): ParseResult[Expr] = parseAll(action, s)

  lazy val action: PackratParser[Expr] =
    (   "Draw with Ruler from"~expr~"to"~fact ^^ {case "Draw with Ruler from"~a~"to"~b ⇒ DrawWithRuler(a, b)}
      | fact )


}
