package task4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class QuestionFactory {
    // TODO: 01.04.2021 стоит соблюдать конвенции именования с маленькой буквы
    List<String> who = Arrays.asList("котеночка обидел", "работает врачом", "ходит в гости по утрам");
    List<String> what = Arrays.asList("будет если посмотреть на солнце без очков", "делать при простуде", "подарить на праздник");
    List<String> when = Arrays.asList("пойдет дождь", "ты придешь в гости", "наступают сумерки");
    List<String> how = Arrays.asList("дела", "распознать ложь", "поймать удачу");
    List<String> whatFor = Arrays.asList("коту усы", "дарят цветы", "нужен инстаграм");
    List<String> why = Arrays.asList("небо голубое", "нужно ходить на работу", "люди не летают");
    List<String> where = Arrays.asList("я", "отдохнуть летом", "самые высокие горы");
    List<String> whereTo = Arrays.asList("уходит детство", "пойти на выходных", "летит самолет");
    List<String> fromWhere = Arrays.asList("будете", "эти помидоры", "столько негатива");
    List<String> which = Arrays.asList("сегодня погода", "ягода самая вкусная", "звезда светит днем");
    List<String> whichOne = Arrays.asList("твой любимый цвет", "сегодня день", "зверь самый красивый");
    List<String> howMany = Arrays.asList("времени", "вешать в граммах", "осталось дней до лета");

    HashMap<String, List<String>> questionMap = new HashMap<>();
//    TODO Map<String, List<String>> questionMap = new HashMap<>();

    {
        questionMap.put("Кто", who);
        questionMap.put("Что", what);
        questionMap.put("Когда", when);
        questionMap.put("Как", how);
        questionMap.put("Зачем", whatFor);
        questionMap.put("Почему", why);
        questionMap.put("Где", where);
        questionMap.put("Куда", whereTo);
        questionMap.put("Откуда", fromWhere);
        questionMap.put("Какая", which);
        questionMap.put("Какой", whichOne);
        questionMap.put("Сколько", howMany);
    }

    public String getQuestion() {
        Random random = new Random();
        List<String> s = new ArrayList<>(questionMap.keySet());
        String key = s.get(random.nextInt(s.size()));
        List <String> list = questionMap.get(key);
        // TODO: 01.04.2021 тогда этот cast не потребуется
        String value = list.get(random.nextInt(list.size()));
        return key + " " + value;
    }

    public QuestionFactory() throws IOException {
    }
}
