package app;

import com.company.DisplayLocales;
import com.company.Info;
import com.company.SetLocale;

import java.util.Locale;

public class LocaleExplore {
    public static void main(String [] args) throws Exception
    {
        DisplayLocales displayLocales = new DisplayLocales();
        System.out.println("For Messages.properties file");
        displayLocales.displayAll(Locale.getDefault());
        System.out.println("For Messages_ro.properties file");
        displayLocales.displayAll(Locale.forLanguageTag("ro"));

        SetLocale setLocale = new SetLocale();
        setLocale.set("A","L","C","D","E");
        displayLocales.displayAll(Locale.getDefault());

        Info informationsAboutLocale = new Info();
        informationsAboutLocale.getInfo(Locale.getDefault());
        informationsAboutLocale.getInfo(Locale.ITALY);


    }
}
