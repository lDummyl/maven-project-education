package task2;

public class Secretary extends OfficeWorker{
	// TODO: 5/20/20 эти поля характерны только для Секретарей или можно вынести в какой-то родительский класс?

	public Secretary(String name, int skill) {

		this.name = name;
		this.skill = skill;
	}



	// TODO: 5/20/20 старайся не иметь useless методов
	// TODO: 5/20/20 а что сразу удалять мтожно же наоборот использовать
	public void sendMail() {
		System.out.println("Mail has been sent");
	}


	@Override
	public String toString() {
		return name;
	}
}
