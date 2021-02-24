import java.text.Collator;
import java.util.*;

public class CountryList {


    public static void main(String[] args) {
        Locale[] locales = Locale.getAvailableLocales();
        List<Country> countries = new ArrayList<>();

        for(Locale locale : locales){
            try {
                String iso = locale.getISO3Country();
                String code = locale.getCountry();
                String name = locale.getDisplayCountry();
                if (!"".equals(iso) && !"".equals(code) && !"".equals(name)) {
                    countries.add(new Country(iso, code, name));
                }

            }
            catch (MissingResourceException e) {
                //do nothing
            }
        }
        Collections.sort(countries, new CountryComparator());

        for (Country a : countries){
            System.out.println(a.toString());
        }
    }



}

class Country {
    private String iso;
    private String code;
    public String name;

    Country(String iso, String code, String name) {
        this.iso = iso;
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return iso + " - " + code + " - " + name.toUpperCase();
    }
}

class CountryComparator implements Comparator<Country> {
    private Comparator comparator;
    CountryComparator() {
        comparator = Collator.getInstance();
    }

    @Override
    public int compare(Country o1, Country o2) {
        return comparator.compare(o1.name, o2.name);
    }
}


