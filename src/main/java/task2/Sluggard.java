package task2;

public class Sluggard implements WantAJob {

	private final String name;

	public Sluggard(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public Boolean passInterview() {
		return true;
	}

	@Override
	public String toString() {
		return "Sluggard{" +
				"name='" + name + '\'' +
				'}';
	}
}
