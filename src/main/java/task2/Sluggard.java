package task2;

public class Sluggard implements WantAJob {

	private final String name;

	public Sluggard(String name) {
		this.name = name;
	}

	@Override
	public Boolean passInterview() {

		return true;
	}
}
