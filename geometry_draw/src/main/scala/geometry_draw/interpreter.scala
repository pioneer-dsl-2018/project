package geometry_draw

import java.awt.Color


package object back {
  def DrawWithRuler_do(a: Point, b: Point): Unit = {
    StdDraw.setPenRadius(0.005)
    StdDraw.setPenColor(StdDraw.BLACK)
    StdDraw.line(a.x_coordinate, a.y_coordinate, b.x_coordinate, b.y_coordinate)
  }

  def DrawWithCompass_do(center: Point, radius: Double, rotate: Rotation): Unit = {
    StdDraw.setPenRadius(0.005)
    StdDraw.setPenColor(StdDraw.GRAY)
    StdDraw.arc(center.x_coordinate, center.y_coordinate, radius, rotate.start_degree, rotate.end_degree)
  }

  def MarkThePoint_do(point_a: Point, name: String): Unit = {

  }

  def MarkTheLine_do(line_a: Line, name: String): Unit = {

  }

  def color_interpreter(value: String): Color = {
    if (value == "blue"){
      StdDraw.BLUE
    }
    else if (value == "gray"){
      StdDraw.GRAY
    }
    else if (value == "red"){
      StdDraw.RED
    }
    else if (value == "green"){
      StdDraw.GREEN
    }
    else if (value == "yellow"){
      StdDraw.YELLOW
    }
    else {
      StdDraw.BLACK
    }
  }

  def SetThePoint_do(point_a: Point, character: String, value: String): Unit = {
    if (character == "color"){
      StdDraw.setPenColor(color_interpreter((value)))
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate)
    }
    else if (character == "thickness"){
      StdDraw.setPenRadius(value.toDouble)
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate)
    }
    else{
      println("Wrong character input. The possible two input choices are: color, thickness. More features are under construction.")
    }
  }

  def SetTheLine_do(line_a: Line, character: String, value: String): Unit = {
    if (character == "color"){
      StdDraw.setPenColor(color_interpreter((value)))
      StdDraw.line(line_a.start_point.x_coordinate, line_a.start_point.y_coordinate, line_a.end_point.x_coordinate, line_a.end_point.y_coordinate)
    }
    else if (character == "thickness"){
      StdDraw.setPenRadius(value.toDouble)
      StdDraw.line(line_a.start_point.x_coordinate, line_a.start_point.y_coordinate, line_a.end_point.x_coordinate, line_a.end_point.y_coordinate)
    }
    else{
      println("Wrong character input. The possible two input choices are: color, thickness. More features are under construction.")
    }
  }

  def MoveThePoint_do(point_a: Point, command: String, value: Double): Unit = {
    if (command == "up"){
      // remove the original point
      StdDraw.setPenRadius(0.005)
      StdDraw.setPenColor(StdDraw.WHITE)
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate)
      // draw the new point
      StdDraw.setPenColor(StdDraw.BLACK)
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate + value)
    }
    if (command == "down"){
      // remove the original point
      StdDraw.setPenRadius(0.005)
      StdDraw.setPenColor(StdDraw.WHITE)
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate)
      // draw the new point
      StdDraw.setPenColor(StdDraw.BLACK)
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate - value)
    }
    if (command == "left"){
      // remove the original point
      StdDraw.setPenRadius(0.005)
      StdDraw.setPenColor(StdDraw.WHITE)
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate)
      // draw the new point
      StdDraw.setPenColor(StdDraw.BLACK)
      StdDraw.point(point_a.x_coordinate - value, point_a.y_coordinate)
    }
    if (command == "right"){
      // remove the original point
      StdDraw.setPenRadius(0.005)
      StdDraw.setPenColor(StdDraw.WHITE)
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate)
      // draw the new point
      StdDraw.setPenColor(StdDraw.BLACK)
      StdDraw.point(point_a.x_coordinate + value, point_a.y_coordinate)
    }
    else{
      println("Wrong command input. The possible input choices are: up, down, left, right.")
    }
  }

  def MoveTheLine_do(line_a: Line, command: String, value: Double): Unit = {
    if (command == "up"){
      // remove the original line
      StdDraw.setPenRadius(0.005)
      StdDraw.setPenColor(StdDraw.WHITE)
      StdDraw.line(line_a.start_point.x_coordinate, line_a.start_point.y_coordinate, line_a.end_point.x_coordinate, line_a.end_point.y_coordinate)
      // draw the new line
      StdDraw.setPenColor(StdDraw.BLACK)
      StdDraw.line(line_a.start_point.x_coordinate, line_a.start_point.y_coordinate + value, line_a.end_point.x_coordinate, line_a.end_point.y_coordinate + value)
    }
    if (command == "down"){
      // remove the original line
      StdDraw.setPenRadius(0.005)
      StdDraw.setPenColor(StdDraw.WHITE)
      StdDraw.line(line_a.start_point.x_coordinate, line_a.start_point.y_coordinate, line_a.end_point.x_coordinate, line_a.end_point.y_coordinate)
      // draw the new line
      StdDraw.setPenColor(StdDraw.BLACK)
      StdDraw.line(line_a.start_point.x_coordinate, line_a.start_point.y_coordinate - value, line_a.end_point.x_coordinate, line_a.end_point.y_coordinate - value)
    }
    if (command == "left"){
      // remove the original line
      StdDraw.setPenRadius(0.005)
      StdDraw.setPenColor(StdDraw.WHITE)
      StdDraw.line(line_a.start_point.x_coordinate, line_a.start_point.y_coordinate, line_a.end_point.x_coordinate, line_a.end_point.y_coordinate)
      // draw the new line
      StdDraw.setPenColor(StdDraw.BLACK)
      StdDraw.line(line_a.start_point.x_coordinate - value, line_a.start_point.y_coordinate, line_a.end_point.x_coordinate - value, line_a.end_point.y_coordinate)
    }
    if (command == "right"){
      // remove the original line
      StdDraw.setPenRadius(0.005)
      StdDraw.setPenColor(StdDraw.WHITE)
      StdDraw.line(line_a.start_point.x_coordinate, line_a.start_point.y_coordinate, line_a.end_point.x_coordinate, line_a.end_point.y_coordinate)
      // draw the new line
      StdDraw.setPenColor(StdDraw.BLACK)
      StdDraw.line(line_a.start_point.x_coordinate + value, line_a.start_point.y_coordinate, line_a.end_point.x_coordinate + value, line_a.end_point.y_coordinate)
    }
  }


  def evaluate(action: Action): Unit = action match {
    case Num(i) => i.toDouble

    case DrawWithRuler(point_a, point_b) ⇒ DrawWithRuler_do(point_a,point_b)
    case DrawWithCompass(center, radius, rotation_property) ⇒ DrawWithCompass_do(center, radius, rotation_property)

    case MarkThePoint(point_a, name) ⇒ MarkThePoint_do(point_a, name)
    case MarkTheLine(line_a, name) ⇒ MarkTheLine_do(line_a, name)

    case SetThePoint(point_a, character, value) ⇒ SetThePoint_do(point_a, character, value)
    case SetTheLine(line_a, character, value) ⇒ SetTheLine_do(line_a, character, value)

    case MoveThePoint(point_a, command, value) ⇒ MoveThePoint_do(point_a, command, value)
    case MoveTheLine(line_a, command, value) ⇒ MoveTheLine_do(line_a, command, value)

  }

}



