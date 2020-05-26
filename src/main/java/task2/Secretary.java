package task2;

public class Secretary
{
	private String name;
	public static int secretaryCount = 0;
	public Secretary(String name) {
		this.name = name;
	}
	public void count ()
	{
		secretaryCount ++;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

}
