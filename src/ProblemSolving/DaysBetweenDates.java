package ProblemSolving;

public class DaysBetweenDates {

    // Days in each month
    static int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Main method
    public static void main(String[] args) {
        int d1 = 10, m1 = 2, y1 = 2014;
        int d2 = 10, m2 = 3, y2 = 2015;

        System.out.println("Days between: " + daysBetween(d1, m1, y1, d2, m2, y2));
    }

    // Function to find the number of days between two given dates
    static int daysBetween(int d1, int m1, int y1, int d2, int m2, int y2) {
        int n1 = getDays(d1, m1, y1); // total days from start to date1
        int n2 = getDays(d2, m2, y2); // total days from start to date2
        return Math.abs(n2 - n1);     // difference = days between
    }

    // Function to calculate total number of days from year 0 to given date
    static int getDays(int d, int m, int y) {
        int days = y * 365 + d; // count all days in previous years + current days

        // Add days for months of the current year
        for (int i = 0; i < m - 1; i++) {
            days += monthDays[i];
        }

        // Add leap year days
        days += countLeapYears(y, m);

        return days;
    }

    // Function to count how many leap years occurred before this date
    static int countLeapYears(int year, int month) {
        // If the current month is Jan or Feb, don't count the current year if it's a leap year
        if (month <= 2) year--;

        return year / 4 - year / 100 + year / 400;
    }
}
