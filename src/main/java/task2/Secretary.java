package task2;

import task1.Name;
import task1.Person;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Secretary extends OfficeWorker{

	Person person;

	String colorNail = "RED";

	private static final Map<Integer, String> baseColor = new HashMap<>();
	static {
		baseColor.put(0, "BLACK");
		baseColor.put(1, "WHITE");
		baseColor.put(2, "RED");
		baseColor.put(3, "GREEN");
		baseColor.put(4, "BLUE");
		baseColor.put(5, "YELLOW");
		baseColor.put(6, "PURPLE");
		baseColor.put(7, "BROWN");
		baseColor.put(8, "GREY");
		baseColor.put(9, "ORANGE");
	}

	public Secretary(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public String getColorNail(){
		return colorNail;
	}

	public void sendMail() {
		System.out.println("Mail has been sent");
	}

	private void changeColorNail(int colorNumber){
		if(colorNumber >= 0 && colorNumber <= 9){
			colorNail = baseColor.get(colorNumber);
		}else {
			throw new RuntimeException("Choose a color number from 0 to 9");
		}

	}

	@Override
	public String toString() {
		return "Secretary{" +
				 person +
				'}';
	}
}
