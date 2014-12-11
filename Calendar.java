/****************************************************************************************
compilation:  javac -cp .:stdlib.jar Calendar.java
execution:  java -cp .:stdlib.jar Calendar [int month] [int year]

Takes a month and a year from the command line and prints a calendar for that month.

$ java -cp .:stdlib.jar Calendar 11 1985
November 1985
S	M	Tu	W	Th	F	S
 	 	 	 	 	1	2	
3	4	5	6	7	8	9	
10	11	12	13	14	15	16	
17	18	19	20	21	22	23	
24	25	26	27	28	29	30
****************************************************************************************/


public class Calendar {
   public static boolean LeapYear (int year) {
      boolean isLeapYear;
      isLeapYear = (year % 4 == 0);
      isLeapYear = isLeapYear && (year % 100 != 0);
      isLeapYear = isLeapYear || (year % 400 == 0);
      return isLeapYear;
   }
   
   /* A function from an earlier exercise, that gives the weekday 
   (0 for Sunday, 1 for Monday, etc) given the year, month, and day.  
   This will determine where to start the calendar. */
   public static int Day (int year, int month, int day) {
      int year0 = year - (14 - month) /12;
      int x = year0 + year0/4 - year0/100 + year0/400;
      int month0 = month + 12 * ((14 - month)/12) -2;
      int day0 = (day + x + (31 * month0)/12) % 7;
      return day0;
   }
   
   public static void main(String[] args) {
      int M = Integer.parseInt(args[0]);
      int Y = Integer.parseInt(args[1]);
      StdOut.println(month(M) + " " + Y);
      StdOut.println("S\tM\tTu\tW\tTh\tF\tS");
      //first row
      int start = Day(Y, M, 1);
      for(int i = 0; i < start; i++) {
         StdOut.print(" \t");          // leave blank spaces for weekdays before the first
      }
      for(int i = 1; i < Length(M, Y) + 1; i++) {
         StdOut.print(i + "\t");
         if ((start + i)%7 == 0) StdOut.println();
      }
      StdOut.println();
   }
   
   // Determine the number of days in the month, paying particular attention to February
   public static int Length (int month, int year) {
      int [] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      if (LeapYear(year)) days[2] = 29;
      if(month <= 12) return days[month];
      else return 0;  // Bad input
   }
   
   //Write the month as a word for the heading
   public static String month(int m) {
      String[] month = {"January", "February", "March", "April", "May", "June", "July",
                        "August", "September", "October", "November", "December"};
      return month[m - 1];
   }
}