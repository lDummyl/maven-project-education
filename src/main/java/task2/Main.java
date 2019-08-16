package task2;
import java.util.ArrayList;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

/*Доп задания

написать тесты:

1. кейс вызвать негодование начальства
2. все ок секретарь выбран из списка
3. секретарей выдано мало ни один не выбран

модифицировать программу

1. Безработица это плохо, даещь каждой секретарше по офису.
ну ладно не каждой, но пусть будет 3 офиса. Секретарь при этом
не может работать в 2 офисах одновременно

2. Не стоит ограничиваться секретарем, пусть будет еще
 и бухгалтер, начальный список при этом будет общий(рынок труда) а HR
 там сам разберется что и как

* */


public class Main {
    public static void main(String[] args) {

        ArrayList<Object> secretaries = new ArrayList<>();
       secretaries.add(new Secretary("Маша"));    //создаем секретарей
        secretaries.add(new Secretary("Алла"));
        secretaries.add(new Secretary("Анжелла"));
        secretaries.add(new Secretary("Зина"));
        secretaries.add(new Secretary("Марина"));
        secretaries.add(new Secretary("Лера"));

   /*      for(int i=0; i<6; i++)                       //создаем 6 кандидатов жилающих работать, но е совсем секретарей
        secretaries.add(new WantAWork() {
            @Override
            public boolean passInterview() {
                return true;                         //возвращаем положительный результат прохождения интерьвью у Hr
            }
        });
*/

        Office office = new Office();

   //     for (Object secretary : secretaries) {
   //         System.out.println(secretary);
   //     }

//        secretaries.forEach(i -> System.out.println(i));    //прогоняем весь список секреторей, с помощью forEach вызывая в нем метод invitePeople (использум лямбда выражение)
//        secretaries.forEach(secret -> System.out.print((secret));    //прогоняем весь список секреторей, с помощью forEach вызывая в нем метод invitePeople (использум лямбда выражение)
//        secretaries.forEach(secret -> System.out.printF((secret));    //прогоняем весь список секреторей, с помощью forEach вызывая в нем метод invitePeople (использум лямбда выражение)
//        secretaries.forEach(secret -> System.out.print4((secret));    //прогоняем весь список секреторей, с помощью forEach вызывая в нем метод invitePeople (использум лямбда выражение)


        secretaries.forEach(office::invitePeople);    //прогоняем весь список секреторей, с помощью forEach вызывая в нем метод invitePeople (использум лямбда выражение)

        System.out.println(office.secretary);         //выводим выбранного секретаря

    }
}
