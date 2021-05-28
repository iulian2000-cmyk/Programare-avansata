package com.company;


import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Locale;

public class Info {
    public static void getInfo(Locale locale)
    {
      System.out.println("Country : " + locale.getDisplayCountry());
      System.out.println("Currency : " + Currency.getInstance(locale).getDisplayName());
      System.out.println("Language : " + locale.getDisplayLanguage());
      System.out.print("Week days : ");
        DateFormatSymbols symbols = new DateFormatSymbols(locale);
        String[] dayNames = symbols.getWeekdays();
        for(String day:dayNames){ System.out.print(day + " ,");}
        System.out.print("\nMonths : ");
        symbols = new DateFormatSymbols(locale);
        String [] monthsName = symbols.getMonths();
        for(String month : monthsName){
            System.out.print(month + " ,");
        }
}
}
