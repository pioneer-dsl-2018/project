package geometry_draw

import java.awt.Color

package object back {
  def DrawWithRuler_do(a: Point, b: Point): Unit = {
    StdDraw.setPenRadius(a.thickness)
    StdDraw.setPenColor(color_interpreter(a.color))
    StdDraw.line(a.x_coordinate, a.y_coordinate, b.x_coordinate, b.y_coordinate)
  }

  def DrawWithCompass_do(center: Point, radius: Double, rotate: Rotation): Unit = {
    StdDraw.setPenRadius(center.thickness)
    StdDraw.setPenColor(color_interpreter(center.color))
    if(rotate.direction == Direction("clockwise")){
      StdDraw.arc(center.x_coordinate, center.y_coordinate, radius, 360-rotate.end_degree, 360+rotate.start_degree)
    }
    else{
      StdDraw.arc(center.x_coordinate, center.y_coordinate, radius, rotate.start_degree, rotate.end_degree)
    }
  }

  def MarkThePoint_do(a: Point, b: String): String = {
    var temp = b
    var output: String = "(" + a.x_coordinate + "," + a.y_coordinate + ")"
    println("Successfully assign point( " + a.x_coordinate + "," + a.y_coordinate + ") to " + b)
    output
  }

  def checkthepoint_do(a: String): Point = {
    if (a.head == '(' && a.charAt(-1)==')'){
      a.replaceAll("\\s", "")
      var output: Point = Point(a.substring(a.indexOf('(')+1,a.indexOf(',')).toDouble, a.substring(a.indexOf(',')+1,a.indexOf(')')).toDouble)
      output
    }
    else{
      println("Sorry, the input is incorrect. Please try to use 'Mark' function first")
      Point(0,0)
    }
  }

  def MarkTheLine_do(a: Line, name: String): Unit = {
    var b: Line = Line(a.start_point, a.end_point, a.color, a.thickness)
    println("Successfully assign line to" + name)

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
    else if (value == "blue"){
      StdDraw.BLUE
    }
    else {
      StdDraw.BLACK
    }
  }

  def RemoveThePoint_do(point_a: Point): Unit = {
    StdDraw.setPenRadius(point_a.thickness+0.001)
    StdDraw.setPenColor(StdDraw.WHITE)
    StdDraw.point(point_a.x_coordinate, point_a.y_coordinate)
    StdDraw.setPenColor(StdDraw.BLACK)
  }

  def RemoveTheLine_do(input_line: Line): Unit = {
    StdDraw.setPenRadius(input_line.thickness+0.001)
    StdDraw.setPenColor(StdDraw.WHITE)
    StdDraw.line(input_line.start_point.x_coordinate, input_line.start_point.y_coordinate, input_line.end_point.x_coordinate, input_line.end_point.y_coordinate)
    StdDraw.setPenColor(StdDraw.BLACK)
  }

  def SetThePoint_do(point_a: Point, character: String, value: String): Unit = {
    if (character == "color"){
      RemoveThePoint_do(point_a)
      var point_a.color = value
      StdDraw.setPenRadius(point_a.thickness)
      StdDraw.setPenColor(color_interpreter(value))
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate)
    }
    else if (character == "thickness"){
      RemoveThePoint_do(point_a)
      var point_a.thickness = value.toDouble
      StdDraw.setPenRadius(value.toDouble)
      StdDraw.setPenColor(color_interpreter(point_a.color))
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate)
    }
    else{
      println("Wrong character input. The possible two input choices are: color, thickness. More features are under construction.")
    }
  }

  def SetTheLine_do(input_line: Line, character: String, value: String): Unit = {
    if (character == "color"){
      RemoveTheLine_do(input_line)
      var input_line.color = value
      StdDraw.setPenRadius(input_line.thickness)
      StdDraw.setPenColor(color_interpreter(value))
      StdDraw.line(input_line.start_point.x_coordinate, input_line.start_point.y_coordinate, input_line.end_point.x_coordinate, input_line.end_point.y_coordinate)
    }
    else if (character == "thickness"){
      RemoveTheLine_do(input_line)
      var input_line.thickness = value.toDouble
      StdDraw.setPenRadius(value.toDouble)
      StdDraw.setPenColor(color_interpreter(input_line.color))
      StdDraw.line(input_line.start_point.x_coordinate, input_line.start_point.y_coordinate, input_line.end_point.x_coordinate, input_line.end_point.y_coordinate)
    }
    else{
      println("Wrong character input. The possible two input choices are: color, thickness. More features are under construction.")
    }
  }

  def MoveThePoint_do(point_a: Point, command: String, value: Double): Unit = {
    if (command == "up"){
      // remove the original point
      RemoveThePoint_do(point_a)
      // draw the new point
      StdDraw.setPenColor(color_interpreter(point_a.color))
      StdDraw.setPenRadius(point_a.thickness)
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate + value)
    }
    else if (command == "down"){
      // remove the original point
      RemoveThePoint_do(point_a)
      // draw the new point
      StdDraw.setPenColor(color_interpreter(point_a.color))
      StdDraw.setPenRadius(point_a.thickness)
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate - value)
    }
    else if (command == "left"){
      // remove the original point
      RemoveThePoint_do(point_a)
      // draw the new point
      StdDraw.setPenColor(color_interpreter(point_a.color))
      StdDraw.setPenRadius(point_a.thickness)
      StdDraw.point(point_a.x_coordinate - value, point_a.y_coordinate)
    }
    else if (command == "right"){
      // remove the original point
      RemoveThePoint_do(point_a)
      // draw the new point
      StdDraw.setPenColor(color_interpreter(point_a.color))
      StdDraw.setPenRadius(point_a.thickness)
      StdDraw.point(point_a.x_coordinate + value, point_a.y_coordinate)
    }
    else{
      println("Wrong command input. The possible input choices are: up, down, left, right.")
    }
  }

  def MoveTheLine_do(input_line: Line, command: String, value: Double): Unit = {
    if (command == "up"){
      // remove the original line
      RemoveTheLine_do(input_line)
      // draw the new line
      StdDraw.setPenColor(color_interpreter(input_line.color))
      StdDraw.setPenRadius(input_line.thickness)
      StdDraw.line(input_line.start_point.x_coordinate, input_line.start_point.y_coordinate + value, input_line.end_point.x_coordinate, input_line.end_point.y_coordinate + value)
    }
    else if (command == "down"){
      // remove the original line
      RemoveTheLine_do(input_line)
      // draw the new line
      StdDraw.setPenColor(color_interpreter(input_line.color))
      StdDraw.setPenRadius(input_line.thickness)
      StdDraw.line(input_line.start_point.x_coordinate, input_line.start_point.y_coordinate - value, input_line.end_point.x_coordinate, input_line.end_point.y_coordinate - value)
    }
    else if (command == "left"){
      // remove the original line
      RemoveTheLine_do(input_line)
      // draw the new line
      StdDraw.setPenColor(color_interpreter(input_line.color))
      StdDraw.setPenRadius(input_line.thickness)
      StdDraw.line(input_line.start_point.x_coordinate - value, input_line.start_point.y_coordinate, input_line.end_point.x_coordinate - value, input_line.end_point.y_coordinate)
    }
    else if (command == "right"){
      // remove the original line
      RemoveTheLine_do(input_line)
      // draw the new line
      StdDraw.setPenColor(color_interpreter(input_line.color))
      StdDraw.setPenRadius(input_line.thickness)
      StdDraw.line(input_line.start_point.x_coordinate + value, input_line.start_point.y_coordinate, input_line.end_point.x_coordinate + value, input_line.end_point.y_coordinate)
    }
    else{
      println("Wrong command input. The possible input choices are: up, down, left, right.")
    }
  }


  def evaluate(action: Action): Unit = action match {

    case DrawWithRuler(point_a, point_b) ⇒ print(DrawWithRuler_do(point_a,point_b))
    case DrawWithCompass(center, radius, rotation_property) ⇒ DrawWithCompass_do(center, radius, rotation_property)

    case SetThePoint(point_a, character, value) ⇒ SetThePoint_do(point_a, character, value)
    case SetTheLine(input_line, character, value) ⇒ SetTheLine_do(input_line, character, value)

    case MoveThePoint(point_a, command, value) ⇒ MoveThePoint_do(point_a, command, value)
    case MoveTheLine(input_line, command, value) ⇒ MoveTheLine_do(input_line, command, value)

    case MarkThePoint(point_a, name) ⇒ MarkThePoint_do(point_a, name)
    case MarkTheLine(input_line, name) ⇒ MarkTheLine_do(input_line, name)

    case RemoveThePoint(point_a) ⇒ RemoveThePoint_do(point_a)
    case RemoveTheLine(input_line) ⇒ RemoveTheLine_do(input_line)

    case CheckThePoint(name) ⇒ checkthepoint_do(name)

  }

}



