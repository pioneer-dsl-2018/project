package myConstructions

object example_1 {
  def main(args: Array[String]): Unit = {
    StdDraw.setPenRadius(0.005)
    StdDraw.setPenColor(StdDraw.BLACK)
    StdDraw.line(0.5, 0.5, 0.7, 0.5)
    StdDraw.setPenRadius(0.01)
    StdDraw.setPenColor(StdDraw.RED)
    StdDraw.point(0.5,0.5)
    StdDraw.point(0.7,0.5)
    StdDraw.setPenRadius(0.005)
    StdDraw.setPenColor(StdDraw.GRAY)
    StdDraw.arc(0.5,0.5,0.2,0,70)
    StdDraw.arc(0.7,0.5,0.2,110,180)
    StdDraw.setPenRadius(0.01)
    StdDraw.setPenColor(StdDraw.RED)
    StdDraw.point(0.6,0.5 + 0.1*math.sqrt(3))
    StdDraw.setPenRadius(0.005)
    StdDraw.setPenColor(StdDraw.BLACK)
    StdDraw.line(0.6, 0.5 + 0.1*math.sqrt(3), 0.7, 0.5)
    StdDraw.line(0.5, 0.5, 0.6, 0.5 + 0.1*math.sqrt(3))
  }
}
