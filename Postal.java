/***************************************************************************************
compilation:  javac -cp .:stdlib.jar Postal.java
execution:  java -cp .:stdlib.jar Postal [zip code]

Takes a zip code, finds the checksum (the sum of the digits in the zip code modulo 10), 
puts the checksum at the end of the zip code, and draws the barcode representing all digits.  
The bar code also includes a tall bar and the beginning an end.
****************************************************************************************/

public class Postal {

   /* Read a zip code from the command line, converts it into an array of digits, 
   converts each digit into an array of 1s and 0s, and draws the barcode */
   public static void main(String args[]) {
      int[] a = new int[args[0].length()];
      for(int i = 0; i < args[0].length(); i++) {
         a[i] = Integer.parseInt(args[0].substring(i, i+1));
      }
      int N = 5 * a.length + 7; // 5 bars per digit, 5 bars for the checksum, 
                                // 2 tall bars for the front and back
      int[] b = new int[N];
      b[0] = b[N-1] = 1;  // tall bars in the front and back
      for(int j = 0; j < a.length; j++) {
         for(int i = 0; i < 5; i++) {  // five bars representing each digit
            b[1 + 5 * j + i] = binaryCode(a[j])[i];  // put code for individual digits into overall code
         }
      }
      for(int i = 0; i < 5; i++) {
         b[N - 6 + i] = binaryCode(checksum(a))[i];  //put code for the checksum digit into overall code
      }
      barcode(b);  //draw the code
   }
   
   /* convert an array of 0s and 1s into a drawing of a barcode,
   where 0s are short bars and 1s are tall bars */
   public static void barcode(int[] code) {
      int width = code.length;
      StdDraw.setXscale(0, width);
      StdDraw.setYscale(0, width / 4);
      StdDraw.setPenRadius(.05);
      double position = .5;
      for (int i = 0; i < code.length; i++) {
         if (code[i] == 0) {
            StdDraw.filledRectangle(position, .25, .25, .25);
         }
         if (code[i] == 1) {
            StdDraw.filledRectangle(position, .5, .25, .5);
         }
         position += 1;
      }
   }
   
   /* Individual digits are represented in post office codes by five bars that can be short
   or tall.  This function takes a digit and returns an array of five 0s and 1s representing 
   the short and tall bars. */
   public static int[] binaryCode(int d) {
      int[][] bin = {
         {1, 1, 0, 0, 0},  // 0
         {0, 0, 0, 1, 1},  // 1
         {0, 0, 1, 0, 1},  // 2
         {0, 0, 1, 1, 0},  // 3
         {0, 1, 0, 0, 1},  // 4
         {0, 1, 0, 1, 0},  // 5
         {0, 1, 1, 0, 0},  // 6
         {1, 0, 0, 0, 1},  // 7
         {1, 0, 0, 1, 0},  // 8
         {1, 0, 1, 0, 0},  // 9
         {}                // not a digit, skip this
      };
      if (d >= 0 && d <=9) return bin[d];
      else return bin[10];
   }
   
   /* Compute the checksum digit, which goes after the zip code, and which is the sum 
   of the digits in the zip code modulo 10 */
   public static int checksum(int[] a) {
      int sum = 0;
      for (int i = 0; i < a.length; i++) {
         sum += a[i];
      }
      return sum % 10;
   }
   
}