package ca.bcit.comp2522.lab2;

/**
 * Represents dates from the Gregorian calendar, including the name of the weekday and date constraints.
 * @author Kiet Tran
 * @author Devan Lam
 * @version 1.0
 */

public class Date
{
    private final int year;
    private final int month;
    private final int day;


    private static final int MIN_YEAR = 1800;
    private static final int EIGHTEENTH_CENTURY = 1800;
    private static final int NINETEENTH_CENTURY = 1900;
    private static final int TWENTIETH_CENTURY = 2000;
    private static final int CURRENT_YEAR = 2026;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int MIN_DAY = 1;
    private static final int MAX_DAY_MAXIMAL = 31;      // Maximal meaning the max possible amount of days in a month.
    private static final int MAX_DAY_STANDARD = 30;     // Standard meaning the not max possible amount of days in a month.
    private static final int MAX_DAY_FEB = 28;
    private static final int MAX_DAY_FEB_LEAP = 29;
    private static final int CENTURY = 100;

    private static final int HELPER_TWELVE = 12;
    private static final int HELPER_SEVEN = 7;
    private static final int HELPER_FOUR = 4;

    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    private static final String MONDAY = "Monday";
    private static final String TUESDAY = "Tuesday";
    private static final String WEDNESDAY = "Wednesday";
    private static final String THURSDAY = "Thursday";
    private static final String FRIDAY = "Friday";
    private static final String SATURDAY = "Saturday";
    private static final String SUNDAY = "Sunday";

    // These numbers are necessary for the getDayOfTheWeek() function.
    private static final int JAN_CODE = 1;
    private static final int FEB_CODE = 4;
    private static final int MAR_CODE = 4;
    private static final int APR_CODE = 0;
    private static final int MAY_CODE = 2;
    private static final int JUN_CODE = 5;
    private static final int JUL_CODE = 0;
    private static final int AUG_CODE = 3;
    private static final int SEP_CODE = 6;
    private static final int OCT_CODE = 1;
    private static final int NOV_CODE = 4;
    private static final int DEC_CODE = 6;

    // These numbers are necessary for the getDayOfTheWeek() function.
    private static final int MONDAY_CODE = 2;
    private static final int TUESDAY_CODE = 3;
    private static final int WEDNESDAY_CODE = 4;
    private static final int THURSDAY_CODE = 5;
    private static final int FRIDAY_CODE = 6;
    private static final int SATURDAY_CODE = 0;
    private static final int SUNDAY_CODE = 1;

    // These numbers are necessary for the getDayOfTheWeek() function.
    private static final int EIGHTEENTH_CENTURY_CODE = 2;
    private static final int NINETEENTH_CENTURY_CODE = 0;
    private static final int TWENTIETH_CENTURY_CODE = 6;

    // This refers to the fact that most years that are multiples of 4 are leap years
    private static final int LEAP_YEAR_DIVISOR = 4;

    /*
     * "Century Exemption" refers to the fact that every turn of the century (Ex. 1800, 1900)
     * that is also NOT a multiple of 400 is NOT a leap year.
     */
    private static final int LEAP_YEAR_CENTURY_EXEMPTION = 100;

    // "Four Century Divisor" refers to the fact that for every year that is a multiple of 400 is a leap year.
    private static final int LEAP_YEAR_FOUR_CENTURY_DIVISOR = 400;




    /**
     * This constructs the Date object. Will not create an object if the date is invalid (Does not exist in the Gregorian Calendar).
     * @param year the year
     * @param month the month
     * @param day the day
     */
    public Date(final int year, final int month, final int day)
    {
        validateYear(year);          // Year cannot be lesser than MIN_YEAR and greater than CURRENT_YEAR.
        validateMonth(month);        // Month cannot be lesser than MIN_MONTH and greater than CURRENT_MONTH.
        validateDay(day);            // Day cannot be lesser than MIN_DAY and greater than the maximum day based off the month.

        this.year = year;
        this.month = month;
        this.day = day;
    }


    private final void validateYear(final int year)
    {
        if (year < MIN_YEAR ||
                year > CURRENT_YEAR)

        {
            throw new IllegalArgumentException("Invalid year.");
        }
    }


    private final void validateMonth(final int month)
    {
        if (month < MIN_MONTH ||
                month > MAX_MONTH)

        {
            throw new IllegalArgumentException("Invalid month.");
        }
    }


    private final void validateDay(final int day)
    {
        if (day < MIN_DAY ||                                            // Checks if day is lesser than the minimum possible day
                isStandardMonth() && day > MAX_DAY_STANDARD ||              // Checks if the month is standard and if the day is greater than the possible max
                isMaximalMonth() && day > MAX_DAY_MAXIMAL ||                // Checks if the month is maximal and if the day is greater than the possible max
                this.month == FEBRUARY && day > getFebruaryMaxDay())        // Checks if the month is February and if the day is greater than the possible max

        {
            throw new IllegalArgumentException("Invalid Day");
        }
    }


    /**
     * Provides the year.
     * @return year
     */
    public final int getYear()
    {
        return this.year;
    }


    /**
     * Provides the month in its numerical value.
     * @return month as a number
     */
    public final int getMonthNumerical()
    {
        return this.month;
    }


    /**
     * Provides the month as its name
     * @return month name
     */
    public final String getMonth()
    {
        if (this.month == JANUARY)

        {
            return "January";
        }

        else

        if (this.month == FEBRUARY)

        {
            return "February";
        }

        else

        if (this.month == MARCH)

        {
            return "March";
        }

        else

        if (this.month == APRIL)

        {
            return "April";
        }

        else

        if (this.month == MAY)

        {
            return "May";
        }

        else

        if (this.month == JUNE)

        {
            return "June";
        }

        else

        if (this.month == JULY)

        {
            return "July";
        }

        else

        if (this.month == AUGUST)

        {
            return "August";
        }

        else

        if (this.month == SEPTEMBER)

        {
            return "September";
        }

        else

        if (this.month == OCTOBER)

        {
            return "October";
        }

        else

        if (this.month == NOVEMBER)

        {
            return "November";
        }

        else

        if (this.month == DECEMBER)

        {
            return "December";
        }

        else

        {
            throw new IllegalStateException("Month is invalid. Cannot return month name");
        }
    }


    /**
     * Provides the day.
     * @return day
     */
    public final int getDay()
    {
        return this.day;
    }


    public final boolean isLeapYear()
    {
        return (this.year % LEAP_YEAR_FOUR_CENTURY_DIVISOR == 0 ||
                this.year % LEAP_YEAR_DIVISOR == 0 && this.year % LEAP_YEAR_CENTURY_EXEMPTION != 0);
    }


    public final boolean isStandardMonth()
    {
        return (this.month == APRIL ||
                this.month == JUNE ||
                this.month == SEPTEMBER ||
                this.month == NOVEMBER);
    }


    public final boolean isMaximalMonth()
    {
        return !isStandardMonth() && this.month != FEBRUARY;
    }


    /**
     * Provides a string version of the full date in YYYY-MM-DD format
     * @return formatted date
     */
    public String getYYYYMMDD()
    {
        String YYYYMMDD;
        String MM;
        String DD;

        if (month < 10)

        {
            MM = "0" + month;
        }

        else

        {
            MM = "" + month;
        }

        if (day < 10)

        {
            DD = "0" + day;
        }

        else

        {
            DD = "" + day;
        }

        YYYYMMDD = year + "-" + MM + "-" + DD;

        return YYYYMMDD;
    }


    /**
     * Provides the day of the week.
     * @return day of the week
     */
    public final String getDayOfTheWeek()
    {
        // Required variables for the algorithm to work.
        final int centuryCode;
        final int yearLastTwoDigitsOnly;
        final int quotientOfTwelves;
        final int remainderOfTwelves;
        final int quotientOfFours;
        final int dayOfMonth;
        final int monthCode;
        final int sumOfTheFormers;
        final int remainderOfSevens;

        centuryCode = getCenturyCode();                             // Get the century code for the current year.

        yearLastTwoDigitsOnly = this.year - getNthCentury();        // Take the last two digits of the year.

        quotientOfTwelves = yearLastTwoDigitsOnly / HELPER_TWELVE;  // Divide the last two digits by 12 and get the quotient.

        remainderOfTwelves = yearLastTwoDigitsOnly % HELPER_TWELVE; // Get the remainder when the last two digits are divided by 12.

        quotientOfFours = remainderOfTwelves / HELPER_FOUR;         // Divide the remainder by 4 and get the quotient.

        dayOfMonth = this.day;

        monthCode = getMonthCode(); // Get the month code for the current month.

        sumOfTheFormers = centuryCode // Sum all the values.
                + quotientOfTwelves
                + remainderOfTwelves
                + quotientOfFours
                + dayOfMonth
                + monthCode;

        remainderOfSevens = sumOfTheFormers % HELPER_SEVEN;          // Calculate the remainder when the sum is divided by 7.

        // Match the remainder to the corresponding day of the week.
        if (remainderOfSevens == MONDAY_CODE)

        {
            return MONDAY;
        }

        else

        if (remainderOfSevens == TUESDAY_CODE)

        {
            return TUESDAY;
        }

        else

        if (remainderOfSevens == WEDNESDAY_CODE)

        {
            return WEDNESDAY;
        }

        else

        if (remainderOfSevens == THURSDAY_CODE)

        {
            return THURSDAY;
        }

        else

        if (remainderOfSevens == FRIDAY_CODE)

        {
            return FRIDAY;
        }

        else

        if (remainderOfSevens == SATURDAY_CODE)

        {
            return SATURDAY;
        }

        else

        if (remainderOfSevens == SUNDAY_CODE)

        {
            return SUNDAY;
        }

        else

        {
            throw new IllegalStateException("Cannot determine day of week.");
        }
    }


    public final String getFormattedDate()
    {
        StringBuilder formatter;

        formatter = new StringBuilder();

        formatter.append(getDayOfTheWeek());
        formatter.append(", ");
        formatter.append(getMonth());
        formatter.append(" ");
        formatter.append(this.day);
        formatter.append(", ");
        formatter.append(this.year);

        return formatter.toString();
    }

    /**
     * Provides the current year.
     * @return
     */
    public static int getCurrentYear()
    {
        return CURRENT_YEAR;
    }

    private final int getMonthCode()
    {
        if (this.month == JANUARY)

        {
            return JAN_CODE;
        }

        else

        if (this.month == FEBRUARY)

        {
            return FEB_CODE;
        }

        else

        if (this.month == MARCH)

        {
            return MAR_CODE;
        }

        else

        if (this.month == APRIL)

        {
            return APR_CODE;
        }

        else

        if (this.month == MAY)

        {
            return MAY_CODE;
        }

        else

        if (this.month == JUNE)

        {
            return JUN_CODE;
        }

        else

        if (this.month == JULY)

        {
            return JUL_CODE;
        }

        else

        if (this.month == AUGUST)

        {
            return AUG_CODE;
        }

        else

        if (this.month == SEPTEMBER)

        {
            return SEP_CODE;
        }

        else

        if (this.month == OCTOBER)

        {
            return OCT_CODE;
        }

        else

        if (this.month == NOVEMBER)

        {
            return NOV_CODE;
        }

        else

        if (this.month == DECEMBER)

        {
            return DEC_CODE;
        }

        else

        {
            throw new IllegalStateException("Month range is invalid. Cannot provide month code");
        }
    }


    private final int getCenturyCode()
    {
        if (this.year - EIGHTEENTH_CENTURY < CENTURY && this.year - EIGHTEENTH_CENTURY >= 0)

        {
            return EIGHTEENTH_CENTURY_CODE;
        }

        else

        if (this.year - NINETEENTH_CENTURY < CENTURY && this.year - NINETEENTH_CENTURY >= 0)

        {
            return NINETEENTH_CENTURY_CODE;
        }

        else

        if (this.year - TWENTIETH_CENTURY < CENTURY && this.year - TWENTIETH_CENTURY >= 0)

        {
            return TWENTIETH_CENTURY_CODE;
        }

        else

        {
            throw new IllegalStateException("Year range is invalid. Cannot provide century code");
        }
    }


    private final int getNthCentury()
    {
        if (this.year - EIGHTEENTH_CENTURY < CENTURY && this.year - EIGHTEENTH_CENTURY >= 0)

        {
            return EIGHTEENTH_CENTURY;
        }

        else

        if (this.year - NINETEENTH_CENTURY < CENTURY && this.year - NINETEENTH_CENTURY >= 0)

        {
            return NINETEENTH_CENTURY;
        }

        else

        if (this.year - TWENTIETH_CENTURY < CENTURY && this.year - TWENTIETH_CENTURY >= 0)

        {
            return TWENTIETH_CENTURY;
        }

        else

        {
            throw new IllegalStateException("Year range is invalid. Cannot provide century.");
        }
    }


    private final int getFebruaryMaxDay()
    {
        if (isLeapYear())
        {
            return MAX_DAY_FEB_LEAP;
        }

        else

        {
            return MAX_DAY_FEB;
        }
    }





}

