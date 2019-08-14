package task2;

import java.util.List;
import java.util.Random;

public class Director {
    //private WantAJob secretary; // решение не плохое, но как-то секретарь должен еще что-то помимо прохождения интервью уметь. Я бы всеже вынес его в Офис отсюда совсем. И при назначании проводил финальную проверку через instanceof
    private final Office office;
    private Random random = new Random();

    private final int enoughCandidatesToDecide = 3; // теперь это не magic number, и не стоит выбирать из одного кандидата
    private final int accountantsOnStaff = 2;

    public Director(Office office) {
        this.office = office;
    }

    // TODO: 8/14/19 привыкай избавлться от кода в коммитах, он сохраняется в контроле версий так что не потеряется
    public Object makeDecision(List<Object> candidates, int maxCount) {
            //Random random = new Random(); // при каждом вызове этого метода будет создаваться новый Рандом это нехорошо (будет не очень рандомно :), лучше создать его однажды в поле и потом вызывать.
            //int lastIndex = candidates.size() - 1; // не путай так человека, который будет читать если вычитаешь из size 1 то переменную назови lastIndex
                                                   // согласен, с названиями переменных у меня не всегда все ясно и просто
            //int index = random.nextInt(lastIndex);
            //WantAJob candidate = candidates.get(index);
            //if (candidate instanceof Secretary) // не знал что это работает в обратную сторону
            //    office.setSecretary((Secretary) candidate); // исправил // а вот тут тебя ждет ClassCastException

        // возможно, я немного тут намудрил
        // Да, правильно, намудрил. Это все потому что ты слишком активно нагружаешь директора, на нем все держится и в нем все происходит, подкинь больше работы HR и в офис. Метод который что-то возвращет лучше void. Сделай так чтобы HR отсортировал по спискам кандидатов.
        //List<Accountant> accountants = office.getAccountants();
        //choseSomeCandidates(accountants, candidates, accountantsOnStaff, Accountant.class);

        return null; // с этим методом не получилось, разбил на два метода
    }

    public Object choseCandidate(List<Object> candidates) {
        if (candidates.size() >= enoughCandidatesToDecide) {
            int lastIndex = candidates.size() - 1;
            return candidates.get(random.nextInt(lastIndex));
        }
        return null;
    }

    public Boolean checkDuplicates(Object checking, List<? extends Object> list) {
        for (Object object : list) {
            if (checking.equals(object))
                return true;
        }
        return false;
    }

    // установи в idea плагин sonar и используй его периодически, он будет говорить что не так, в частности с этим методом. С его точки зрения это critical issue
    private void choseSomeCandidates(List<Object> list, List<Object> candidates, int maxCount) {
        int countWorks = list.size();

        if (countWorks < maxCount) {
            int chose = maxCount - countWorks;
            for (int i = 0; i < chose; i++) {
                Object candidate = choseCandidate(candidates);
                if (candidate == null) {
                    i--;
                    continue;  // понял // это ругательное слово в java
                }

                if (countWorks > 0) {
                    boolean noMatches = true;
                    for (Object works : list) {
                        if (candidate.equals(works)) {
                            noMatches = false;
                            i--;
                            break; // это тоже хоть и более мягкое
                        }
                    }

                    if (noMatches) {
                        //list.add(objectClass.cast(candidate)); // тут у меня ступор пока что
                        countWorks = list.size();
                    }
                } else {
                    //list.add(objectClass.cast(candidate));
                    countWorks = list.size();
                }
            }
        }
    }

    private Coffee makeSomeCoffee(String sort) {
        Secretary secretary = office.getSecretary();
        if (secretary != null)
            return secretary.getCoffee(sort);
        return null;
    }

    public int getAccountantsOnStaff() {
        return accountantsOnStaff;
    }
}
