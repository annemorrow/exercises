/**************************************************************************************
compilation:  javac -cp .:stdlib.jar MeanAndSD.java
execution:  java -cp .:stdlib.jar MeanAndSD [N]

Reads an integer N from the command line and N double values from standard input, then prints their mean, standard deviation, and a list of outliers.

$ java -cp .:stdlib.jar MeanAndSD 8
6 2.2 9 13 -9 100 -12 4 
The average is 14.15
The standard deviation is        13.4999 
The outliers are: -9.0	100.0	-12.0

$ java -cp .:stdlib.jar MeanAndSD 4
5 5 5 5
The average is 5.0
The standard deviation is         0.0000 
The outliers are: 
***************************************************************************************/

public class MeanAndSD {
   public static void main(String[] args) {
      int N = Integer.parseInt(args[0]);
      double[] data = new double[N];
      double sum = 0.0;
      for (int i = 0; i < N; i++) {
         data[i] = StdIn.readDouble();
         sum += data[i];
      }
      double average = sum / N;
      double squaresum = 0.0;
      for (int i = 0; i < N; i++) {
         squaresum += (data[i] - average) * (data[i] - average);
      }
      double stddev = Math.sqrt(squaresum) / (N - 1);
      StdOut.println("The average is " + average);
      StdOut.printf("The standard deviation is %14.4f \n", stddev);
      
      StdOut.print("The outliers are: ");
      // print values that are further than 1.5 standard deviations from the mean
      for (int i = 0; i < N; i++) {
         if (Math.abs(data[i] - average) > Math.abs(1.5 * average)) {
            StdOut.print(data[i] + "\t");
         }
      }
      StdOut.println();
   }
}