/****************************************************************************************
 *  Compilation:  javac RamanujansTaxi.java
 *  Execution:    java RamanujansTaxi
 * 
 *  Takes an integer argument N from the command line and returns a list of all of the 
 *  numbers less than or equal to N that can be written two ways as the sum of two 
 *  squares, as well as giving the number of such numbers.
 *
 *  % java RamanujansTaxi 5000
 *  1^3 + 12^3 = 9^3 + 10^3 = 1729
 *  2^3 + 16^3 = 9^3 + 15^3 = 4104
 *  There are 2 such numbers less than or equal to 5000
 *
 *  % java RamanujansTaxi 20000
 *  1^3 + 12^3 = 9^3 + 10^3 = 1729
 *  2^3 + 16^3 = 9^3 + 15^3 = 4104
 *  2^3 + 24^3 = 18^3 + 20^3 = 13832
 *  There are 3 such numbers less than or equal to 20000
 ***************************************************************************************/

public class RamanujansTaxi { 
   public static void main(String[] args) {
      int N = Integer.parseInt(args[0]);               // Sets an upper bound for the sum.
      
      int count = 0;                                   // Counts numbers that can be       
                                                       // written two different ways as 
                                                       // sums of two cubes.
                                                       
      for(int i = 0; i*i*i <= N/2; i++) {              // Since we're looking for the sum 
                                                       // of two numbers, only need to go
                                                       // to N/2.
         int cubei = i * i * i;
         for(int j = i; cubei + j*j*j <= N; j++) {     // The sum is bounded by N.
            int cubej = j * j * j;
            int cubeSum1 = cubei + cubej;              // The sum of at least one pair of 
                                                       // cubes.
            for(int k = i + 1; k*k*k <= N/2; k++) {    // Avoid repeating earlier           
                                                       // cubeSum1.  If k <= i, we would 
                                                       // have already seen the resulting 
                                                       // sums, and checking for equality 
                                                       // later would only result in both 
                                                       // pairs of cubes being exactly the 
                                                       // same.
               int cubek = k * k * k;
               for(int m = k; m*m*m <= cubeSum1 - cubek; m++) {
                  int cubem = m * m * m;
                  int cubeSum2 = cubek + cubem;
                  if(cubeSum1 == cubeSum2) {
                     System.out.println(i + "^3 + " + j + "^3 = " 
                                        + k + "^3 + " + m + "^3 = " + cubeSum2);
                     count++;
                  }  //  end of if statement
               }     //  end of for m loop
            }        //  end of for k loop
         }           //  end of for j loop
      }              //  end of for i loop
      System.out.println("There are " + count + 
                         " such numbers less than or equal to " + N);
   }                 //  end of main
}