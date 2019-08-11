package task2;

import sun.util.resources.cldr.ja.LocaleNames_ja;

import java.util.ArrayList;
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

    public void makeDecision(List<WantAJob> candidates) {
            //Random random = new Random(); // при каждом вызове этого метода будет создаваться новый Рандом это нехорошо (будет не очень рандомно :), лучше создать его однажды в поле и потом вызывать.
            //int lastIndex = candidates.size() - 1; // не путай так человека, который будет читать если вычитаешь из size 1 то переменную назови lastIndex
                                                   // согласен, с названиями переменных у меня не всегда все ясно и просто
            //int index = random.nextInt(lastIndex);
            //WantAJob candidate = candidates.get(index);
            //if (candidate instanceof Secretary) // не знал что это работает в обратную сторону
            //    office.setSecretary((Secretary) candidate); // исправил // а вот тут тебя ждет ClassCastException

        if (office.getSecretary() == null) {
            Secretary secretary = (Secretary) choseCandidate(candidates, Secretary.class);
            office.setSecretary(secretary);
        }

        if (office.getSecurity() == null) {
            SecurityOfficer security = (SecurityOfficer) choseCandidate(candidates, SecurityOfficer.class);
            office.setSecurity(security);
        }

        if (office.getLawyer() == null) {
            Lawyer lawyer = (Lawyer) choseCandidate(candidates, Lawyer.class);
            office.setLawyer(lawyer);
        }

        // возможно, я немного тут намудрил
        List<Accountant> accountants = office.getAccountants();
        choseSomeCandidates(accountants, candidates, accountantsOnStaff, Accountant.class);
    }

    private void choseSomeCandidates(List<? extends Object> list, List<WantAJob> candidates, int maxCount, Class<? extends Object> objectClass) {
        int countWorks = list.size();

        if (countWorks < maxCount) {
            int chose = maxCount - countWorks;
            for (int i = 0; i < chose; i++) {
                Object candidate = choseCandidate(candidates, objectClass);
                if (candidate == null) {
                    i--;
                    continue;
                }

                if (countWorks > 0) {
                    boolean noMatches = true;
                    for (Object works : list) {
                        if (candidate.equals(works)) {
                            noMatches = false;
                            i--;
                            break;
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

    private Object choseCandidate(List<WantAJob> candidates, Class<? extends Object> objectClass) {
        List<Object> pertain = new ArrayList<>();
        for (Object candidate : candidates) {
            if (objectClass.isInstance(candidate))
                pertain.add(candidate);
        }

        if (pertain.size() >= enoughCandidatesToDecide) {
            int lastIndex = pertain.size() - 1;
            return pertain.get(random.nextInt(lastIndex));
        }
        return null;
    }

    private Coffee makeSomeCoffee(String sort) {
        Secretary secretary = office.getSecretary();
        if (secretary != null)
            return secretary.getCoffee(sort);
        return null;
    }
}
