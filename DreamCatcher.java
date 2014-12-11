/***************************************************************************************
compilation:  javac -cp .:stdlib.jar DreamCatcher.java
execution:  java -cp .:stdlib.jar DreamCatcher [N] [p]

Takes N and p as command line arguments, plots N equally spaced points on the circumference
of a circle, and then, with probability p for each pair of points, draws a gray line
connecting them.
****************************************************************************************/

public class DreamCatcher {
   public static void main(String[] args) {
      int N = Integer.parseInt(args[0]);
      double p = Double.parseDouble(args[1]);
      double[] x = new double[N]; // coordinates of points in two arrays
      double[] y = new double[N];
      StdDraw.setXscale(-1.2, 1.2); // see coordinates on the unit circle
      StdDraw.setYscale(-1.2, 1.2);
      StdDraw.setPenRadius(.02);
      for (int i = 0; i < N; i++) {
         x[i] = Math.cos(2 * i * Math.PI / N);
         y[i] = Math.sin(2 * i * Math.PI / N);
         StdDraw.point(x[i], y[i]);
      }
      StdDraw.setPenColor(StdDraw.GRAY);
      StdDraw.setPenRadius(.002);
      for (int i = 0; i < N - 1; i++) {
         for (int j = i + 1; j < N; j++) {  // look at each pair of points
            if (Math.random() < p) {
               StdDraw.line(x[i], y[i], x[j], y[j]);
            }
         }
      }
   }
}