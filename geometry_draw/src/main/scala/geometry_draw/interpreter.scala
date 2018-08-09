package geometry_draw


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


  def evaluate(action: Action): Unit = action match {
    case Num(i) => i.toDouble

    case DrawWithRuler(point_a, point_b) ⇒ DrawWithRuler_do(point_a,point_b)

    case DrawWithCompass(center, radius, rotation_property) ⇒ DrawWithCompass_do(center, radius, rotation_property)

    case MarkThePoint(point_a) ⇒
      StdDraw.setPenRadius(0.01)
      StdDraw.setPenColor(StdDraw.RED)
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate)

    case SetPointProperty(point_a, color, thickness) =>
      StdDraw.setPenRadius(thickness)
      StdDraw.setPenColor(StdDraw.BLACK)
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate)

  }








}



