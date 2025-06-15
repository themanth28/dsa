package ProblemSolving;

public class DaysDifference {
    public static void main(String[] args) {
        int d1 = 5, d2 = 31;
        int m1 = 1, m2 = 5;
        int y1 = 2025, y2 = 2026;

        System.out.println(differenceDays(d1, d2, m1, m2, y1, y2));
    }

    private static int differenceDays(int d1, int d2, int m1, int m2, int y1, int y2) {
        int yearDifference = y2 - y1;
        if(m1>2) y1++;
        else if (m2 < 2) {
            y2++;
        }
        int count = 0;
        int days = 0;
        if(yearDifference > 0){
            System.out.println(yearDiff(m1,12) - d1);
            System.out.println(yearDiff(1,m2));
            days += yearDiff(m1,12) + yearDiff(1,m2) - d1 ;
        }
        for (int i=y1; i<=y2; i++){
            if(checkYear(i)){
                count++;
            }
        }
//        return days + ((y2 - y1) * 365 + count);
        return days;
    }

    private static int yearDiff(int m1, int m2){
        int days=0;
        for (int i = m1; i <= m2; i++) {
            if (i == 2) {
                days += 28;
            } else {
                if (i % 2 == 1) {
                    days += 31;
                } else {
                    days += 30;
                }
            }
        }
        return days+1;
    }

    private static boolean checkYear(int year){
        return ((year%4 == 0 && year % 100 !=0) || year % 400 == 0);
    }
}
