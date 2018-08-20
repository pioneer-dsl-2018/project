package geometry_draw

sealed abstract class Action

case class Point(x_coordinate: Double, y_coordinate: Double, color: Option[String]= None) extends Action
case class Line(start_point: Point, end_point: Point, color: Option[String]= None) extends Action
case class Rotation(start_degree: Double, end_degree: Double, direction: Direction)

case class Direction(direction: String){
  override def toString: String = direction.toString
}

case class DrawWithRuler(start_point: Point, end_point: Point) extends Action
case class DrawWithCompass(center: Point, radius: Double, rotation_property: Rotation) extends Action

case class MarkThePoint(point: Point, name: String) extends Action
case class MarkTheLine(line: Line, name: String) extends Action

case class SetThePoint(point: Point, character: String, value: String) extends Action
case class SetTheLine(line: Line, character: String, value: String) extends Action

case class MoveThePoint(point: Point, command: String, value: Double) extends Action
case class MoveTheLine(line: Line, command: String, value: Double) extends Action

case class Arc(center:Point, radius: Double, rotation_property: Rotation) extends Action
case class Num(n: String) extends Action