package geometry_draw

import scala.util.parsing.combinator._

/*
Grammar Design

Action ::= Draw | Mark | Set | Move
  Draw   ::= ruler | compass
    ruler  ::= 'draw' 'line' 'with' 'Ruler' 'from' pointName 'to' pointName
    compass ::= 'draw' 'arc' 'with' 'Compass' direction 'from' pointname 'with' 'radius' number 'from' number 'to' number
  point  ::= Mark | Move | Set
    Mark  ::= 'mark' 'point' pointname 'as' Name
    Move  ::= 'move' 'point' NAME command number
    Set   ::= 'set' 'point' NAME character 'to' (number/string)
  line
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
       draw

  lazy val draw: PackratParser[Action] =
     ruler | compass

  lazy val ruler: PackratParser[Action] =
    "draw" ~ "line" ~ "with" ~ "Ruler" ~ "from" ~ point_position ~ "to" ~ point_position ^^
      {case "draw" ~ "line" ~ "with" ~ "Ruler" ~ "from" ~ l ~ "to" ~ r ⇒ DrawWithRuler(l, r)}

  lazy val compass: PackratParser[Action] =
    "draw" ~ "arc" ~ "with" ~ "Compass" ~ direction ~ "from" ~ point_position ~ "with" ~ "radius" ~ number ~ "from" ~ number ~ "to" ~ number ^^
      {case "draw" ~ "arc" ~ "with" ~ "Compass" ~ a ~ "from" ~ b ~ "with" ~ "radius" ~ c ~ "from" ~ d ~ "to" ~ e ⇒ DrawWithCompass(b, c, Rotation(d,e,Direction(a)))}

  lazy val point: PackratParser[Action] =
     mark | move | set

  lazy val line: PackratParser[Action] =
    mark | move | set

  lazy val mark: PackratParser[Action] =
    "mark" ~ "point" ~ point_position ~ "as" ~ String ^^ {case "mark" ~ "point" ~ a ~ "as" ~ b => MarkThePoint(a, b)} |
      "mark" ~ "line" ~ line_position ~ "as" ~ String ^^ {case "mark" ~ "line" ~ a ~ "as" ~ b => MarkTheLine(a, b)}

  lazy val move: PackratParser[Action] =
    "move" ~ "point" ~ point_position ~ command ~ decimalNumber ^^ {case "move" ~ "point" ~ a ~ b ~ c => MoveThePoint(a, b, c.toDouble)} |
      "move" ~ "line" ~ line_position ~ command ~ decimalNumber ^^ {case "move" ~ "line" ~ a ~ b ~ c => MoveTheLine(a, b, c.toDouble)}

  lazy val set: PackratParser[Action] =
    "set" ~ "point" ~ point_position ~ character ~ "to" ~ String ^^ {case "set" ~ "point" ~ a ~ b ~ "to" ~ c => SetThePoint(a, b, c)} |
      "set" ~ "line" ~ line_position ~ character ~ "to" ~ String ^^ {case "set" ~ "line" ~ a ~ b ~ "to" ~ c => SetTheLine(a, b, c)}


  lazy val direction: Parser[String] = "clockwise" | "counter-clockwise"
  lazy val point_position: PackratParser[Point] = "(" ~ decimalNumber ~ "," ~ decimalNumber ~ ")" ^^ {case "(" ~ x ~ "," ~ y ~ ")" ⇒ Point(x.toDouble, y.toDouble)}
  lazy val line_position: PackratParser[Line] = "(" ~ point_position ~ "," ~ point_position ~ ")" ^^ {case "(" ~ x ~ "," ~ y ~ ")" ⇒ Line(x, y)}
  lazy val character: Parser[String] = "color" | "thickness"
  lazy val command: Parser[String] = "up" | "down" | "left" | "right"


}
