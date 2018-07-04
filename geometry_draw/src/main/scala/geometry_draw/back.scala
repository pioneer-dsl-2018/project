package geometry_draw

class Action(action_name: String) {
  DrawWithRuler(Point_a, Point_b) = {
    StdDraw.setPenRadius(0.005)
    StdDraw.setPenColor(StdDraw.BLACK)
    StdDraw.line(Point_a.x_coordinate, Point_a.y_coordinate, Point_b.x_coordinate, Point_b.y_coordinate)
  }

  DrawWithCompass(center, radius, rotation_property) = {
    StdDraw.setPenRadius(0.005)
    StdDraw.setPenColor(StdDraw.GRAY)
    StdDraw.arc(center.x_coordinate,center.y_coordinate,radius,Rotation.start_degree,Rotation.end_degree)
  }

}