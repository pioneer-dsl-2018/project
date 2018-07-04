package geometry_draw

abstract class Action(action_name: String) {}

case class Point(x_coordinate: Double, y_coordinate: Double){
  def toInt: Int = x_coordinate.toInt, y_coordinate.toInt
}

case class Rotation(start_degree: Double, end_degree: Double, direction: Direction){}

case class Direction(direction: String){
  override def toString: String = direction.toString
}

case class DrawWithRuler(start_point: Point, end_point: Point){}

case class DrawWithCompass(center: Point, radius: Double, rotation_property: Rotation){}

