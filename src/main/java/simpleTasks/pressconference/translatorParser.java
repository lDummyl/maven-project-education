package simpleTasks.pressconference;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class translatorParser {
    private static Document translateFromRusToEng() throws IOException {

        System.out.println("Введите предложение для перевода на русском: ");
        Scanner input = new Scanner(System.in);
        String inputSentenceInRussian = input.nextLine();

        String url = "https://translate.yandex.ru/?lang=ru-en&text=" + inputSentenceInRussian.replaceAll(" ", "%20");
        Document page = (Document) Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static void main(String[] args) throws Exception {
        Document page = translateFromRusToEng();
        Element translationToEng = page.select("span[class=translation-word-translation-chunk]").first(); //запрос отсюда <span class="translation-word translation-chunk" data-align="0:6">hi</span>
        System.out.println(translationToEng.text());
//        System.out.println("Перевод на англ:  " + getEngFromString(translationToEng.text()));
    }

 /*   private static Pattern patternTextToEng = Pattern.compile("([^a-zA-Z])\\D{2,}");


    private static String getEngFromString(String stringTextToEngl) throws Exception {
        Matcher matcherTextToEng = patternTextToEng.matcher(stringTextToEngl);

        if (matcherTextToEng.find()) {
            return matcherTextToEng.group();
        }
        throw new Exception("Can't extract English text from this string");
    }*/


}
