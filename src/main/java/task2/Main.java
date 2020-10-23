package task2;



import task1.Person;

import java.util.Collection;

/**
 * Создать 2 офиса Apple и Google и трудоустроить в них секретарей на конкурсной основе, не модифицируя существующий код.
 * Создать 2 имплементации директора и столько же для HR с разным поведеинем, выраженным количественно. все объекты созадются в Main.
 * для создания кандидатов нужно использовать код из 1 й задачи без переноса и копирования, доработка 1 задачи преветствуется.
 */

public class Main {
    Office apple = new Office(new Director(), new HR());
    Office google = new Office(new Director(), new HR());

    public static void main(String[] args) {


    }

    public class HR implements Hr {

        @Override
        public Person addSecretaryCandidate(Object candidate) {
            return new Person();
        }
    }

    public class Director implements task2.Director {
        public Director() {
        }

        @Override
        public task2.Secretary chooseSecretary(Collection<task2.Secretary> candidates) {
            return null;
        }
    }

    public class Secretary implements task2.Secretary {

		@Override
		public void sayHelloTo(Object o) {

		}
	}

    class Candidate {

    }
}
