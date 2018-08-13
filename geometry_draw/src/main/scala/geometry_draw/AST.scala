package geometry_draw

sealed abstract class Action

case class Point(x_coordinate: Double, y_coordinate: Double) extends Action
case class Line(start_point: Point, end_point: Point) extends Action
case class Rotation(start_degree: Double, end_degree: Double, direction: Direction)
case class Command(command: String){
  override def toString: String = command.toString
}

case class Direction(direction: String){
  override def toString: String = direction.toString
}

case class DrawWithRuler(start_point: Point, end_point: Point) extends Action
case class DrawWithCompass(center: Point, radius: Double, rotation_property: Rotation) extends Action

case class MarkThePoint(point: Point) extends Action
case class MarkTheLine(line: Line) extends Action

case class SetThePoint(point: Point, color: String, thickness: Double) extends Action
case class SetTheLine(point: Point, color: String, thickness: Double) extends Action

case class MoveThePoint(point: Point, command: Command, value: Double) extends Action
case class MoveTheLine(line: Line, command: Command, value: Double) extends Action


case class Arc(center:Point, radius: Double, rotation_property: Rotation) extends Action
case class Num(n: String) extends Action