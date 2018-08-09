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
       draw

  lazy val draw: PackratParser[Action] =
     ruler | compass

  lazy val ruler: PackratParser[Action] =
    "draw" ~ "line" ~ "with" ~ "Ruler" ~ "from" ~ point ~ "to" ~ point ^^
      {case "draw" ~ "line" ~ "with" ~ "Ruler" ~ "from" ~ l ~ "to" ~ r ⇒ DrawWithRuler(l, r)}

  lazy val compass: PackratParser[Action] =
    "draw" ~ "arc" ~ "with" ~ "Compass" ~ direction ~ "from" ~ point ~ "with" ~ "radius" ~ number ~ "from" ~ number ~ "to" ~ number ^^
      {case "draw" ~ "arc" ~ "with" ~ "Compass" ~ a ~ "from" ~ b ~ "with" ~ "radius" ~ c ~ "from" ~ d ~ "to" ~ e ⇒ DrawWithCompass(b, c, Rotation(d,e,Direction(a)))}

//  lazy val mark: PackratParser[Action] =
//     point | line
//  lazy val point: PackratParser[Action] =
//   ("mark point"~point~"as"~NAME ^^ {case "mark point"~a~"as"~b => MarkThePoint(a, b)})
//  lazy val point: PackratParser[Action] =
//    ("mark line"~line~"as"~NAME ^^ {case "mark point"~a~"as"~b => MarkThePoint(a, b)})

//  lazy val move: PackratParser[Action] =
//    ( point | line )

//  lazy val set: PackratParser[Action] =
//    ( point | line )

  lazy val direction: Parser[String] = "clockwise" | "counter-clockwise"
  lazy val point: PackratParser[Point] = "(" ~ decimalNumber ~ "," ~ decimalNumber ~ ")" ^^ {case "(" ~ x ~ "," ~ y ~")" ⇒ Point(x.toDouble, y.toDouble)}
//  lazy val number: Parser[Double] = decimalNumber ^^ {case a => Num(a)}
//  lazy val NAME: PackratParser[name]=
  lazy val character: Parser[String] = "color" | "thickness"
  lazy val command: Parser[String] = "upward" | "downward" | "leftward" | "rightward"

  def number: Parser[Double] = number

}

