package task1;


public class Main {

	public static void main(String[] args) {
		zoopark();
	}

	public static void zoopark() {
		Animal animal1 = new Animal();
		animal1.name = "Cat";
		animal1.size = "little";
		animal1.weight = "4kg";
		animal1.colour = "white";
		animal1.diet = "fish";
		animal1.unic = "sees in the dark";


		Animal animal2 = new Animal();
		animal2.name = "Dog";
		animal2.size = "medium";
		animal2.weight = "10kg";
		animal2.colour = "brown";
		animal2.diet = "meat";
		animal2.unic = "good sense of smell";

		Animal animal3 = new Animal();
		animal3.name = "Fish";
		animal3.size = "very small";
		animal3.weight = "0,1kg";
		animal3.colour = "gold";
		animal3.diet = "krill";
		animal3.unic = "lives under water";

		Animal animal4 = new Animal();
		animal4.name = "Horse";
		animal4.size = "big";
		animal4.weight = "700kg";
		animal4.colour = "black";
		animal4.diet = "oats";
		animal4.unic = "can transport a person";

		Animal animal5 = new Animal();
		animal5.name = "Elephant";
		animal5.size = "very big";
		animal5.weight = "2000kg";
		animal5.colour = "grey";
		animal5.diet = "Bananas";
		animal5.unic = "trunk";

		Animal animal6 = new Animal();
		animal6.name = "Lion";
		animal6.size = "big";
		animal6.weight = "600kg";
		animal6.colour = "beige";
		animal6.diet = "Gazelles";
		animal6.unic = "mane";

		Animal animal7 = new Animal();
		animal7.name = "Mouse";
		animal7.size = "very small";
		animal7.weight = "0,3kg";
		animal7.colour = "white";
		animal7.diet = "cheese";
		animal7.unic = "carry the infections";

		Animal animal8 = new Animal();
		animal8.name = "Turtle";
		animal8.size = "Big";
		animal8.weight = "650kg";
		animal8.colour = "khaki";
		animal8.diet = "plant food";
		animal8.unic = "carapace";

		Animal animal9 = new Animal();
		animal9.name = "Snake";
		animal9.size = "Not big, but long";
		animal9.weight = "10kg";
		animal9.colour = "multicolor";
		animal9.diet = "living creatures of medium size";
		animal9.unic = "cold-blooded";

		final Animal animal10 = new Animal();
		animal10.name = "Giraffe";
		animal10.size = "very big";
		animal10.weight = "1300kg";
		animal10.colour = "yellow";
		animal10.diet = "juicy acacia";
		animal10.unic = "long neck";



	}
}

class Animal {

	String name;
	String size;
	String weight;
	String colour;
	String diet;
	String unic;
}