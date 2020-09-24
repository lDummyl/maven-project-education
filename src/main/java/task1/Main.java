package task1;



public class Main {

	public static void main(String[] args) {
		zoopark();

	}

	public static void zoopark() {
		Cat cat = new Cat("Murzik"); // создаем объект cat и присваиваем объекту cat имя Murzik
		Cottonball cottonball = new Cottonball(); // создаем объект cottonball
		cottonball.color = "white"; // присваиваем объекту cottonball характеристику color
		cat.play (cottonball); // обращаемся к методу play

		Dog dog = new Dog("Sharik");
		Stick stick = new Stick();
		stick.color = "black";
		Stick stick1 = dog.run(stick);

		Fish fish = new Fish("Shark");
		Sea sea = new Sea();
		sea.color = "blue";
		fish.swim (sea);

		Lion lion = new Lion("Mufasso");
		Gazzele gazzele = new Gazzele();
		gazzele.sick = "sick";
		lion.overtake (gazzele);

		Giraffe giraffe = new Giraffe("Melman");
		Bananas bananas = new Bananas();
		bananas.fresh = "fresh";
		Bananas bananas1 = giraffe.eat (bananas);

		Elepfant elepfant = new Elepfant("Hathi");
		Water water = new Water();
		water.fromRiver = "from the river";
		elepfant.drink (water);

		Turtle turtle = new Turtle("Leo");
		Ninja ninja = new Ninja();
		ninja.art = " uses the art of the ";
		turtle.use (ninja);

		Pig pig = new Pig("Piglet"); // создаем объект pig и присваиваем объекту pig имя Piglet
		Stable stable = new Stable(); // создаем объект stable
		stable.dirty = "dirty"; // присваиваем объекту stable характеристику dirty
		pig.live (stable); // обращаемся к методу live, находящемуся в классе Pig

		Bear bear = new Bear("Teddy"); // создаем объект bear и  присваиваем объекту bear имя Teddy
		Honey honey = new Honey(); // создаем объект honey
		honey.aTree = " a tree "; // присваиваем объекту honey характеристику aTree
		bear.climb (honey); // обращаемся к методу climb

		Wolf wolf = new Wolf("Akelo");
		Leader leader = new Leader();
		leader.ofPack = " of the wolf pack";
		Leader leader1 = wolf.is(leader);

		Rabbit rabbit = new Rabbit("Snejok");
		Carrot carrot = new Carrot();
		carrot.bigLong = "big & long";
		Carrot carrot1 = rabbit.eat(carrot);

		Whale whale = new Whale("Moby Dick");
		Ocean ocean = new Ocean();
		ocean.floor = "floor";
		Ocean ocean1 = whale.live(ocean);


	}
}

