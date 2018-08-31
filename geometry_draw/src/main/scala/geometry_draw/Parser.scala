package geometry_draw

import scala.util.parsing.combinator._

/*
Grammar Design

Action ::= draw | move | set | mark | read | remove
  Draw   ::= ruler | compass
    ruler  ::= 'draw' 'line' 'with' 'ruler' 'from' point_position 'to' point_position
    compass ::= 'draw' 'arc' 'with' 'compass' direction 'from' point_position 'with' 'radius' number 'from' number 'to' number
  Move   ::= point | line | (arc)
    point ::= 'move' 'point' point_position command number
    line  ::= 'move' 'line' line_position command number
  Set   ::=  point | line | (arc)
    point ::= 'set' 'point' point_position character 'to' identify_name
    line  ::= 'set' 'line' line_position character 'to'  identify_name
  Mark  ::=  point | line | (arc)
    point ::= "mark" ~ "point" ~ point_position ~ "as" ~ identify_name
    line  ::= "mark" ~ "point" ~ point_position ~ "as" ~ identify_name
  Remove ::=  point | line | (arc)
    point ::= "remove" ~ "point" ~ point_position
    line  ::= "remove" ~ "line" ~ line_position


identify_name ::= <string-identifier>
direction ::= 'clockwise' | 'counter-clockwise'
character ::= 'color' | 'thickness'
command   ::= 'up' | 'down' | 'left' | 'right'
point_position ::=  <identify point>
line_position  ::=  <identify line>

*/

object Parser extends JavaTokenParsers with PackratParsers{

  // parsing interface
  def apply(s: String): ParseResult[Action] = parseAll(action, s)

  // expressions
  lazy val action: PackratParser[Action] =
       draw | move | set | mark | remove | read

  lazy val draw: PackratParser[Action] =
     ruler | compass

  lazy val ruler: PackratParser[Action] =
    "draw" ~ "line" ~ "with" ~ "ruler" ~ "from" ~ point_position ~ "to" ~ point_position ^^
      {case "draw" ~ "line" ~ "with" ~ "ruler" ~ "from" ~ l ~ "to" ~ r ⇒ DrawWithRuler(l, r)}

  lazy val compass: PackratParser[Action] =
    "draw" ~ "arc" ~ "with" ~ "compass" ~ direction ~ "from" ~ point_position ~ "with" ~ "radius" ~ decimalNumber ~ "from" ~ decimalNumber ~ "to" ~ decimalNumber ^^
      {case "draw" ~ "arc" ~ "with" ~ "compass" ~ a ~ "from" ~ b ~ "with" ~ "radius" ~ c ~ "from" ~ d ~ "to" ~ e ⇒ DrawWithCompass(b, c.toDouble, Rotation(d.toDouble,e.toDouble,Direction(a)))}

  lazy val move: PackratParser[Action] =
    "move" ~ "point" ~ point_position ~ command ~ decimalNumber ^^ {case "move" ~ "point" ~ a ~ b ~ c => MoveThePoint(a, b, c.toDouble)} |
      "move" ~ "line" ~ line_position ~ command ~ decimalNumber ^^ {case "move" ~ "line" ~ a ~ b ~ c => MoveTheLine(a, b, c.toDouble)}

  lazy val set: PackratParser[Action] =
    "set" ~ "point" ~ point_position ~ character ~ "to" ~ identify_name ^^ {case "set" ~ "point" ~ a ~ b ~ "to" ~ c => SetThePoint(a, b, c)} |
      "set" ~ "line" ~ line_position ~ character ~ "to" ~ identify_name ^^ {case "set" ~ "line" ~ a ~ b ~ "to" ~ c => SetTheLine(a, b, c)}

  lazy val mark: PackratParser[Action] =
    "mark" ~ "point" ~ point_position ~ "as" ~ identify_name ^^ {case "mark" ~ "point" ~ a ~ "as" ~ b => MarkThePoint(a, b)} |
      "mark" ~ "line" ~ line_position ~ "as" ~ identify_name ^^ {case "mark" ~ "line" ~ a ~ "as" ~ b => MarkTheLine(a, b)}

  lazy val remove: PackratParser[Action] =
    "remove" ~ "point" ~ point_position ^^ {case "remove" ~ "point" ~ a => RemoveThePoint(a)} |
      "remove" ~ "line" ~ line_position ^^ {case "remove" ~ "line" ~ a => RemoveTheLine(a)}

  lazy val read: PackratParser[Action] =
    "read" ~ identify_name ^^ {case "read" ~ a => CheckThePoint(a)}


  lazy val identify_name: Parser[String] =  """([^'"\x00-\x1F\x7F\\]|\\[\\'"bfnrt]|\\u[a-fA-F0-9]{4})*""".r  /*Cite: https://github.com/camunda/feel-scala/blob/master/feel-engine/src/main/scala/org/camunda/feel/parser/FeelParser.scala*/
  lazy val direction: Parser[String] = "clockwise" | "counter-clockwise"
  lazy val point_position: PackratParser[Point] = "(" ~ decimalNumber ~ "," ~ decimalNumber ~ ")" ^^ {case "(" ~ x ~ "," ~ y ~ ")" ⇒ Point(x.toDouble, y.toDouble)}
  lazy val line_position: PackratParser[Line] = "(" ~ point_position ~ "," ~ point_position ~ ")" ^^ {case "(" ~ x ~ "," ~ y ~ ")" ⇒ Line(x, y)}
  lazy val character: Parser[String] = "color" | "thickness"
  lazy val command: Parser[String] = "up" | "down" | "left" | "right"
                                      
}
