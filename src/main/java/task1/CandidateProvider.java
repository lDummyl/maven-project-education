package task1;

import task2.Secretary;

import java.util.Collection;
import java.util.Random;

public class CandidateProvider {
    public<T> Collection<T> generateCandidate(int numberOfCandidate, Class<T> clazz){

        return null;
    }
    public class Worker extends Person{
        Integer experience;
        public Worker(Person person) {
            Random random = new Random();
            Integer experience = random.nextInt(this.age.getYears() - 18);
            this.birthDate = person.birthDate;
            this.name = person.name;


            class RealWorker extends Worker implements Secretary{
                public RealWorker(Person person) {
                    super(person);
                }

                @Override
                public void sayHelloTo(Object o) {
                    System.out.println("Hi, i'm secretary");
                }
            }



        }
    }
}
