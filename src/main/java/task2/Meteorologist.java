package task2;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.ls.LSOutput;

import javax.print.Doc;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Meteorologist {

    private static Document getPage() throws IOException { // забирает страницу. + выброс ошибок наверх
        System.out.println("Введите название города на английском: " );
        Scanner input = new Scanner(System.in);
        String inputCity = input.nextLine();

        String url = "https://yandex.ru/pogoda/" + inputCity.replaceAll(" ", "-") ;
        // String url2 = "https://yandex.ru/pogoda/region/225?via=brd";
        Document page = Jsoup.parse(new URL(url), 3000);  //до 3000 мс может ждать ответа от сервера
        //   Document page2 = Jsoup.parse(new URL(url2), 3000);

        return page;
    }

    public static void getWeather() throws Exception {
        Document page = getPage();
        //  Document page2 = getPage();
        //css query language? - почитать
        Element region = page.select("ol[class=breadcrumbs__list]").first();
        Element timeFromTable = page.select("time[class=time fact__time]").first();
        Element temperatureNow = page.select("span[class=temp__value]").get(1);
        Element temperatureYesterday = page.select("span[class=temp__value]").get(0);
        Element temperatureLike = page.select("span[class=temp__value]").get(2);

        // Element tempRegion = page2.selectFirst("a[class=link place-list__item-name i-bem link_js_inited]");
        //    System.out.println(tempRegion);
        System.out.println("Погода в " + getRegionFromString(region.text()));
        //     System.out.println(region);
        System.out.println("Время сейчас: " + getTimeFromString(timeFromTable.text()));
        System.out.println("Вчера температура была: " + getTemperatureFromString(temperatureYesterday.text()));
        System.out.println("Температура сейчас: " + getTemperatureFromString(temperatureNow.text()));
        System.out.println("Ощущается как: " + getTemperatureFromString(temperatureLike.text()));
    }

    private static Pattern patternRegion = Pattern.compile("([^a-zA-Z])\\D{2,}");
    private static Pattern patternTime = Pattern.compile("\\d{2}\\:\\d{2}");
    private static Pattern patternTemperature = Pattern.compile("\\D\\d+");

    private static String getTimeFromString(String stringTime) throws Exception {
        Matcher matcherTime = patternTime.matcher(stringTime);

        if(matcherTime.find()){
            return matcherTime.group();
        }
        throw new Exception("Can't extract time from this string");
    }

    private static String getTemperatureFromString(String stringTemp) throws Exception {
        Matcher matcherTemp = patternTemperature.matcher(stringTemp);

        if(matcherTemp.find()){
            return matcherTemp.group();
        }
        throw new Exception("Can't extract temperature from this string");
    }

    private static String getRegionFromString(String stringRegion) throws Exception {
        Matcher matcherRegion = patternRegion.matcher(stringRegion);

        if(matcherRegion.find()){
            return matcherRegion.group();
        }
        throw new Exception("Can't extract region from this string");
    }
}

