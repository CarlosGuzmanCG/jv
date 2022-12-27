package com.rcg.Date;

import java.util.Calendar;

public class convertDate {
    // dd/mm/yyyyy
    // 01/02/03

    public static void main(String[] args) {
        String strDate = "24/12/2022";
        int date, month, year;

        String tmp = strDate.substring(0, 2);
        date = Integer.parseInt(tmp);
        tmp = strDate.substring(3, 5);
        month = Integer.parseInt(tmp);
        tmp = strDate.substring(6);
        year = Integer.parseInt(tmp);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, date);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        java.util.Date result = cal.getTime();
        System.out.println(result);

    }
}
