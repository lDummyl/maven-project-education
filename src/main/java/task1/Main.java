package task1;


public class Main {

	public static void main(String[] args) {
		zoopark();

	}

	public static void zoopark() {
		Cat cat = new Cat();
		cat.name = "Murzik";
		Cottonball cottonball = new Cottonball();
		cottonball.color = "white";
		cat.play (cottonball);

		Dog dog = new Dog();
		dog.name = "Sharik";
		Stick stick = new Stick();
		stick.color = "black";
		Stick stick1 = dog.run(stick);

		Fish fish = new Fish();
		fish.name = "Shark";
		Sea sea = new Sea();
		sea.color = "blue";
		fish.swim (sea);

		Lion lion = new Lion();
		lion.name = "Mufasso";
		Gazzele gazzele = new Gazzele();
		gazzele.sick = "sick";
		lion.overtake (gazzele);

		Giraffe giraffe = new Giraffe();
		giraffe.name = "Melman";
		Bananas bananas = new Bananas();
		bananas.fresh = "fresh";
		Bananas bananas1 = giraffe.eat (bananas);

		Elepfant elepfant = new Elepfant();
		elepfant.name = "Hathi";
		Water water = new Water();
		water.fromRiver = "from the river";
		elepfant.drink (water);

		Turtle turtle = new Turtle();
		turtle.name = "Leo";
		Ninja ninja = new Ninja();
		ninja.art = " uses the art of the ";
		turtle.use (ninja);



	}
}

