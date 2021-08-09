public class EntryPoint {

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static int getLastDayOfMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        else if (month == 2)
            return isLeapYear(year) ? 29 : 28;
        else
            return -1;
    }

    public static boolean isValidDate(int day, int month, int year) {
        int lastDayOfMonth = getLastDayOfMonth(month, year);

        if (lastDayOfMonth == -1)
            return false;

        return day >= 1 && day <= lastDayOfMonth;
    }

    public static int[] computeNextDate(int day, int month, int year) {
        if (!isValidDate(day, month, year))
            return null;

        int lastDayOfMonth = getLastDayOfMonth(month, year);

        if (lastDayOfMonth == -1)
            return null;

        if (day == lastDayOfMonth) {
            day = 1;

            if (month == 12) {
                month = 1;
                year++;
            } else {
                month++;
            }
        } else {
            day++;
        }

        return new int[]{day, month, year};
    }

    public static int[] computePrevDate(int day, int month, int year) {
        if (!isValidDate(day, month, year))
            return null;

        if (day == 1) {
            if (month == 1) {
                month = 12;
                year--;
                day = getLastDayOfMonth(month, year);
            } else {
                month--;
                day = getLastDayOfMonth(month, year);
            }
        } else {
            day--;
        }

        return new int[]{day, month, year};
    }

    public static String arrayDateToString(int[] arrayDate) {
        if (arrayDate == null) return null;

        return String.format("%d/%d/%d", arrayDate[0], arrayDate[1], arrayDate[2]);
    }

    public static void main(String[] args) {

        // Test
        System.out.println("isLeapYear: 1920 - " + isLeapYear(1920));
        System.out.println("isLeapYear: 2020 - " + isLeapYear(2020));
        System.out.println("isLeapYear: 1990 - " + isLeapYear(1990));
        System.out.println("isLeapYear: 2023 - " + isLeapYear(2023));
        System.out.println("isLeapYear: 2024 - " + isLeapYear(2024));

        System.out.println("=============");

        System.out.println("getLastDayOfMonth:  2/2024 - " + getLastDayOfMonth(2, 2024));
        System.out.println("getLastDayOfMonth:  2/2023 - " + getLastDayOfMonth(2, 2023));
        System.out.println("getLastDayOfMonth: 12/1990 - " + getLastDayOfMonth(12, 1990));
        System.out.println("getLastDayOfMonth:  3/1999 - " + getLastDayOfMonth(3, 1999));
        System.out.println("getLastDayOfMonth:  4/1999 - " + getLastDayOfMonth(4, 1999));
        System.out.println("getLastDayOfMonth:  2/1800 - " + getLastDayOfMonth(2, 1800));

        System.out.println("=============");

        System.out.println("isValidDate: 29/2/2024 - " + isValidDate(29, 2, 2024));
        System.out.println("isValidDate: 28/2/2024 - " + isValidDate(28, 2, 2024));
        System.out.println("isValidDate: 3/12/1990 - " + isValidDate(3, 12, 1990));
        System.out.println("isValidDate: 31/12/1999 - " + isValidDate(31, 12, 1999));
        System.out.println("isValidDate: 28/2/1999 - " + isValidDate(28, 2, 1999));
        System.out.println("isValidDate: 28/2/1999 - " + isValidDate(28, 2, 1999));
        System.out.println("isValidDate: 3/19/1999 - " + isValidDate(3, 19, 1999));
        System.out.println("isValidDate: 35/3/1999 - " + isValidDate(35, 3, 1999));
        System.out.println("isValidDate: 35/13/1999 - " + isValidDate(35, 13, 1999));

        System.out.println("=============");

        System.out.println("computeNextDate: 29/2/2024 - " + arrayDateToString(computeNextDate(29, 2, 2024)));
        System.out.println("computeNextDate: 28/2/2024 - " + arrayDateToString(computeNextDate(28, 2, 2024)));
        System.out.println("computeNextDate: 3/12/1990 - " + arrayDateToString(computeNextDate(3, 12, 1990)));
        System.out.println("computeNextDate: 31/12/1999 - " + arrayDateToString(computeNextDate(31, 12, 1999)));
        System.out.println("computeNextDate: 28/2/1999 - " + arrayDateToString(computeNextDate(28, 2, 1999)));
        System.out.println("computeNextDate: 28/2/1999 - " + arrayDateToString(computeNextDate(28, 2, 1999)));
        System.out.println("computeNextDate: 3/19/1999 - " + arrayDateToString(computeNextDate(3, 19, 1999)));
        System.out.println("computeNextDate: 35/3/1999 - " + arrayDateToString(computeNextDate(35, 3, 1999)));
        System.out.println("computeNextDate: 35/13/1999 - " + arrayDateToString(computeNextDate(35, 13, 1999)));

        System.out.println("=============");

        System.out.println("computePrevDate: 1/3/2024 - " + arrayDateToString(computePrevDate(1, 3, 2024)));
        System.out.println("computePrevDate: 3/3/2024 - " + arrayDateToString(computePrevDate(3, 3, 2024)));
        System.out.println("computePrevDate: 4/1/2028 - " + arrayDateToString(computePrevDate(4, 1, 2028)));
        System.out.println("computePrevDate: 1/1/1999 - " + arrayDateToString(computePrevDate(1, 1, 1999)));
        System.out.println("computePrevDate: 1/8/1999 - " + arrayDateToString(computePrevDate(1, 8, 1999)));
        System.out.println("computePrevDate: 28/2/1999 - " + arrayDateToString(computePrevDate(28, 2, 1999)));
        System.out.println("computePrevDate: 3/19/1999 - " + arrayDateToString(computePrevDate(3, 19, 1999)));
        System.out.println("computePrevDate: 35/3/1999 - " + arrayDateToString(computePrevDate(35, 3, 1999)));
        System.out.println("computePrevDate: 35/13/1999 - " + arrayDateToString(computePrevDate(35, 13, 1999)));
    }
}
