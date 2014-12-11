/***************************************************************************************
compilation:  javac -cp .:stdlib.jar Rose.java
execution:  java -cp .:stdlib.jar Rose [N]

Takes a command-line argument N and plots a rose with N petals based on the function
r = sin(Nt) in polar coordinates.
****************************************************************************************/

public class Rose {
   public static void main(String[] args) {
      int N = Integer.parseInt(args[0]);
      StdDraw.setXscale(-1.2, 1.2); // see coordinates in unit circle;
      StdDraw.setYscale(-1.2, 1.2);
      int steps = 5000;  // set higher for smoother, slower drawing
      double oldx = 0.0;
      double oldy = 0.0;
      for (int i = 1; i <= steps; i++) {
         double theta = 2 * Math.PI * i / steps;
         double r = Math.sin(N * theta);
         double x = r * Math.cos(theta);
         double y = r * Math.sin(theta);
         StdDraw.line(oldx, oldy, x, y);
         oldx = x;
         oldy = y;
      }
   }
}