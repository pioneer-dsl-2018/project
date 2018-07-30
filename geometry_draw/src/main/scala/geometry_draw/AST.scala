package geometry_draw

sealed abstract class Action

case class Point(x_coordinate: Double, y_coordinate: Double)
case class Rotation(start_degree: Double, end_degree: Double, direction: Direction)

case class Direction(direction: String){
  override def toString: String = direction.toString
}

case class DrawWithRuler(start_point: Point, end_point: Point) extends Action
case class DrawWithCompass(center: Point, radius: Double, rotation_property: Rotation) extends Action
case class MarkThePoint(point: Point) extends Action
case class SetPointProperty(point: Point, color: String, thickness: Double) extends Action
case class Arc(center:Point, radius: Double, rotation_property: Rotation) extends Action
