package task1;


public class Main {

	public static void main(String[] args) {
		zoopark();

	}

	public static void zoopark() {
		Cat cat = new Cat();
		cat.name = "Мурзик";
		Cottonball cottonball = new Cottonball();
		cottonball.color = "белый";
		cat.play (cottonball);

		Dog dog = new Dog();
		dog.name = "Шарик";
		Stick stick = new Stick();
		stick.color = "черный";
		Stick stick1 = dog.run(stick);

		Fish fish = new Fish();
		fish.name = "Акула";
		Sea sea = new Sea();
		sea.color = "голубое";
		fish.swim (sea);


	}
}

