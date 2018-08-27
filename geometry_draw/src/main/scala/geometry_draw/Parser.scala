package geometry_draw

import scala.util.parsing.combinator._

/*
Grammar Design

Action ::= Draw | Mark | Set | Move
  Draw   ::= ruler | compass
    ruler  ::= 'draw' 'line' 'with' 'Ruler' 'from' pointName 'to' pointName
    compass ::= 'draw' 'arc' 'with' 'Compass' direction 'from' pointname 'with' 'radius' number 'from' number 'to' number
  Mark   ::= point | line | (arc)
    point ::= 'mark' 'point' pointname 'as' Name
    line  ::= 'mark' 'line' 'from' pointname 'to' pointname 'as' Name
  Move   ::= point | line | (arc)
    point ::= 'move' 'point' NAME command number
    line  ::= 'move' 'line' NAME command number
  Set   ::=  point | line | (arc)
    point ::= 'set' 'point' NAME character 'to' (number/string)
    line  ::= 'set' 'line' NAME character 'to'  (number/string)

direction ::= 'clockwise' | 'counter-clockwise'
pointname ::= <identifier>
number    ::= <number>
NAME      ::= <String-identifier>(?) #Ex. Mike(NAME) represents point(2,3)
character ::= 'color' | 'thickness'
command   ::= 'upward' | 'downward' | 'leftward' | 'rightward'

*/

object Parser extends JavaTokenParsers with PackratParsers{

  // parsing interface
  def apply(s: String): ParseResult[Action] = parseAll(action, s)

  // expressions
  lazy val action: PackratParser[Action] =
       draw | point | line

  lazy val draw: PackratParser[Action] =
     ruler | compass

  lazy val ruler: PackratParser[Action] =
    "draw" ~ "line" ~ "with" ~ "Ruler" ~ "from" ~ point_position ~ "to" ~ point_position ^^
      {case "draw" ~ "line" ~ "with" ~ "Ruler" ~ "from" ~ l ~ "to" ~ r ⇒ DrawWithRuler(l, r)}

  lazy val compass: PackratParser[Action] =
    "draw" ~ "arc" ~ "with" ~ "Compass" ~ direction ~ "from" ~ point_position ~ "with" ~ "radius" ~ decimalNumber ~ "from" ~ decimalNumber ~ "to" ~ decimalNumber ^^
      {case "draw" ~ "arc" ~ "with" ~ "Compass" ~ a ~ "from" ~ b ~ "with" ~ "radius" ~ c ~ "from" ~ d ~ "to" ~ e ⇒ DrawWithCompass(b, c.toDouble, Rotation(d.toDouble,e.toDouble,Direction(a)))}

  lazy val point: PackratParser[Action] =
      move | set

  lazy val line: PackratParser[Action] =
     move | set

  lazy val move: PackratParser[Action] =
    "move" ~ "point" ~ point_position ~ command ~ decimalNumber ^^ {case "move" ~ "point" ~ a ~ b ~ c => MoveThePoint(a, b, c.toDouble)} |
      "move" ~ "line" ~ line_position ~ command ~ decimalNumber ^^ {case "move" ~ "line" ~ a ~ b ~ c => MoveTheLine(a, b, c.toDouble)}

  lazy val set: PackratParser[Action] =
    "set" ~ "point" ~ point_position ~ character ~ "to" ~ stringLiteral ^^ {case "set" ~ "point" ~ a ~ b ~ "to" ~ c => SetThePoint(a, b, c)} |
      "set" ~ "line" ~ line_position ~ character ~ "to" ~ stringLiteral ^^ {case "set" ~ "line" ~ a ~ b ~ "to" ~ c => SetTheLine(a, b, c)}

  lazy val direction: Parser[String] = "clockwise" | "counter-clockwise"
  lazy val point_position: PackratParser[Point] = "(" ~ decimalNumber ~ "," ~ decimalNumber ~ ")" ^^ {case "(" ~ x ~ "," ~ y ~ ")" ⇒ Point(x.toDouble, y.toDouble)}
  lazy val line_position: PackratParser[Line] = "(" ~ point_position ~ "," ~ point_position ~ ")" ^^ {case "(" ~ x ~ "," ~ y ~ ")" ⇒ Line(x, y)}
  lazy val character: Parser[String] = "color" | "thickness"
  lazy val command: Parser[String] = "up" | "down" | "left" | "right"

}
