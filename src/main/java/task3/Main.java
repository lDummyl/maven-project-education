package task3;

/*

 Создать косольное приложение: великий и могущественный оракул,
 который отвечает на вопрос исходя из ряда правил
 Если вопрос сликом длинный, говорит будь лаконичней
 слишком короткий будь красноречивее
 проверяет на наличие вопроса что, где, когда, и тд...
 если их больше одного, ты задаешь слишком много вопросов
 если ни одного, то не еслышу вопроса в твоих речах
 на каждый из этих вопросов, если он один дается заготовленный мудрый ответ
 оракул может рандомно нахамить или стукнуть палкой
 может устать и сделать перерыв на 10 сек до минуты,
 сообщая тебе сколько еще ждать в ответ на вопросы.

 создать отчет о вопросах ответах виде Josn фаила используя
 Jackson Object mapper и положить его в ресурсы

*/


import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //GreatOracle greatOracle = new GreatOracle();

        String s = "???Как???, почему?? ,,,432432 зачем, пройти в библиотеку";
        String ss = s.toLowerCase();
        Pattern question = Pattern.compile("(как|когда|зачем|почему)");
        Matcher matcher = question.matcher(ss);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }


        // TODO: 7/20/20 keep it OOP
        class QuestionExtractor {
            final Set<String> questions;

            public QuestionExtractor(Set<String> questions) {
                this.questions = questions;
            }

            public Set<String> parse(String rawLine) {
                Set<String> questionsResult = new HashSet<>();
                for (String question : questions) {
                    parse(rawLine, questionsResult, "(" + question + ")");
                }
                return questionsResult;
            }

            public Set<String> parseSinglePattern(String rawLine) {
                Set<String> questionsResult = new HashSet<>();
                String rawPattern = questions.stream().collect(Collectors.joining("|", "(", ")"));
                parse(rawLine, questionsResult, rawPattern);
                return questionsResult;
            }

            private void parse(String rawLine, Set<String> questionsResult, String rawPattern) {
                Pattern pattern = Pattern.compile(rawPattern);
                Matcher matcher = pattern.matcher(rawLine.toLowerCase());
                while (matcher.find()) {
                    questionsResult.add(matcher.group());
                }
            }
        }

        QuestionExtractor questionExtractor = new QuestionExtractor(TextConstants.questionAnswer.keySet());
        Set<String> parse1 = questionExtractor.parse(s);
        Set<String> parse2 = questionExtractor.parseSinglePattern(s);
        System.out.println("parse1 = " + parse1);
        System.out.println("parse2 = " + parse2);

    }

    /*
    Код, в целом работает, но есть несколько нерешенных неточностей, которые запарывают логику.
    Например, если у вопросительного слова ("как", "когда" и т.д.) стоит знак препинания,
    то слово не определяется и оракулу кажется, что вопрос не задан.
    todo переделай обработку сообщений, у строки есть метод contains, чтбы сосчитать количество изучай Pattern, Matcher

    Поток, который отвечает за ответы на вопросы завершается, если ввести 0. После этого завершаются
    остальные потоки, после чего формируется json.
    todo с чего ты взял что тут нужна многопоточность вообще?


    Помимо этого не совсем понимаю, что значит "положить json в ресурсы". Это папка resources,
    которая лежит в target?
    todo ресурсы перекладываются в таргет, но лежат изначально в src

    И еще один очень важный момент, и я так и не понял как его реализовать. Когда оракул спит,
    идет обратный отсчет, но другие потоки все равно работают. То есть пока он спит, он может и
    нахамить, и палкой ударить, и на вопрос ответить. Как сделать так, чтобы другие потоки в этот
    момент ничего не делали?
    todo у тебя есть часы, которые идут параллельно всегда, LocalDateTime, Duration изучай, используй

    Ну и с тестами есть вопрос. У меня большинство методов void и результатом их работы является
    System.out.println. И как их тестировать неясно. Думаю, что можно сделать так, чтобы эти
    методы возвращали String и тогда их можно сравнить assertEquals.
    todo да, у тебя всегда железно должны быть независимы в программе, ввод, обработка и вывод,
     если вывод\ввод размазан по всему коду, будут проблемы.
     */

    // TODO: 7/15/20 по прежнему не пахнет ООП нет объектов нет состояния, фунцкия кишеччник кота лежит отдельно
    //  от дто кота и вызывается где-то внутри метода покормиКота(котб, еда) в итоге длина кишечника у всех котов одинаковая
    //  аппендицитом болеют все сразу. Что нужно обязательно в задании указать что оракулов плеяда, на разные вопросы
    //  могут давать разные ответы, вероятность получить палкой от одного больше чем от другого, и всем хватает разного количества сна в день?
    //  где инкапсуляция, где объекты, где интерфейсы зачем делались все предыдущие задания?

}
