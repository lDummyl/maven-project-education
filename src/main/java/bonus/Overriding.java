package bonus;


/*Данный пример иллюстрирует как переопределение методов влияет на поведение предка. Задача сводится к тому чтобы вернуть возможность изменять
 * параметер. Для этого есть 2 способа, в одном идет замена использования сеттера на более привычный путь инициализации в конструкторе,
 * другой предполагает изменение самого метода родителя так чтобы это привело к не возможности потомка вмешаться в процесс инициализации*/


public class Overriding {


	public static void main(String[] args) {
		TwoHumpsCamel twoHumpsCamel = new TwoHumpsCamel(10);
		Camel camel = new TwoHumpsCamel(10);
		System.out.println(twoHumpsCamel.humpsQty);
		System.out.println(camel.humpsQty);

	}

}

class Camel {
	int humpsQty = 1;

	public Camel(int humpsQty) {
		// TODO: 1/22/20 способ первый this.humpsQty = humpsQty;
	}

	public /*второй способ сделать метод final*/ void setHumpsQty(int humpsQty) {
		this.humpsQty = humpsQty;
	}

}

class TwoHumpsCamel extends Camel {

	public TwoHumpsCamel(int humpsQty) {
		super(humpsQty);
	}

	public void setHumpsQty(int humpsQty) {
		System.out.println("Ooops!");
	}
}