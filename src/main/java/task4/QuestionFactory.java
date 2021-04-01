package task4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class QuestionFactory {
    // TODO: 01.04.2021 стоит соблюдать конвенции именования с маленькой буквы
    List<String> Who = Arrays.asList("котеночка обидел", "работает врачом", "ходит в гости по утрам");
    List<String> What = Arrays.asList("будет если посмотреть на солнце без очков", "делать при простуде", "подарить на праздник");
    List<String> When = Arrays.asList("пойдет дождь", "ты придешь в гости", "наступают сумерки");
    List<String> How = Arrays.asList("дела", "распознать ложь", "поймать удачу");
    List<String> WhatFor = Arrays.asList("коту усы", "дарят цветы", "нужен инстаграм");
    List<String> Why = Arrays.asList("небо голубое", "нужно ходить на работу", "люди не летают");
    List<String> Where = Arrays.asList("я", "отдохнуть летом", "самые высокие горы");
    List<String> WhereTo = Arrays.asList("уходит детство", "пойти на выходных", "летит самолет");
    List<String> FromWhere = Arrays.asList("будете", "эти помидоры", "столько негатива");
    List<String> Which = Arrays.asList("сегодня погода", "ягода самая вкусная", "звезда светит днем");
    List<String> WhichOne = Arrays.asList("твой любимый цвет", "сегодня день", "зверь самый красивый");
    List<String> HowMany = Arrays.asList("времени", "вешать в граммах", "осталось дней до лета");

    HashMap<String, List> questionMap = new HashMap<>();
//    TODO Map<String, List<String>> questionMap = new HashMap<>();

    {
        questionMap.put("Кто", Who);
        questionMap.put("Что", What);
        questionMap.put("Когда", When);
        questionMap.put("Как", How);
        questionMap.put("Зачем", WhatFor);
        questionMap.put("Почему", Why);
        questionMap.put("Где", Where);
        questionMap.put("Куда", WhereTo);
        questionMap.put("Откуда", FromWhere);
        questionMap.put("Какая", Which);
        questionMap.put("Какой", WhichOne);
        questionMap.put("Сколько", HowMany);
    }

    public String getQuestion() {
        Random random = new Random();
        List<String> s = new ArrayList<>(questionMap.keySet());
        String key = s.get(random.nextInt(s.size()));
        List list = questionMap.get(key);
        // TODO: 01.04.2021 тогда этот cast не потребуется
        String value = (String) list.get(random.nextInt(list.size()));
        return key + " " + value;
    }

    public QuestionFactory() throws IOException {
    }
}
