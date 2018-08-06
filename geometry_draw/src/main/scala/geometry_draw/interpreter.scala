package geometry_draw


package object back {
  def evaluate(action: Action): Unit = action match {
    case Num(i) => i.toDouble

    case DrawWithRuler(point_a, point_b) ⇒
      StdDraw.setPenRadius(0.005)
      StdDraw.setPenColor(StdDraw.BLACK)
      StdDraw.line(point_a.x_coordinate, point_a.y_coordinate, point_b.x_coordinate, point_b.y_coordinate)


    case DrawWithCompass(center, radius, rotation_property) =>
      StdDraw.setPenRadius(0.005)
      StdDraw.setPenColor(StdDraw.GRAY)
      StdDraw.arc(center.x_coordinate, center.y_coordinate, radius, rotation_property.start_degree, rotation_property.end_degree)

    case MarkThePoint(point_a) =>
      StdDraw.setPenRadius(0.01)
      StdDraw.setPenColor(StdDraw.RED)
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate)

    case SetPointProperty(point_a, color, thickness) =>
      StdDraw.setPenRadius(thickness)
      StdDraw.setPenColor(StdDraw.BLACK)
      StdDraw.point(point_a.x_coordinate, point_a.y_coordinate)


  }
}



