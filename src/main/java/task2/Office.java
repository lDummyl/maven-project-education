package task2;

public class Office {

	Secretary secretary = new Secretary("Olga");
	Secretary secretary2 = new Secretary ("Elena");
	Secretary secretary3 = new Secretary("Oleg");
	Secretary secretary4 = new Secretary ("Sergey");
	Secretary secretary5 = new Secretary("Vlad");
	Secretary secretary6 = new Secretary ("Marina");
	Secretary secretary7 = new Secretary("Anastasya");
	Secretary secretary8 = new Secretary ("Denis");
	Secretary secretary9 = new Secretary("Ekaterina");
	Secretary secretary10 = new Secretary ("Mark");

	Director director = new Director("Stanislav Petrovich");

	Hr hr = new Hr("Elena Vladimirovna");

	public boolean check ()
	{
		if (Secretary.secretaryCount >= 10)
		{
			return true;
		}
		else {
			return false;
		}
	}



	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат

	void invitePeople(Object human){
		check();

	}

	public static class Secretary
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

	public class Director
	{
		private String name;
		public Director(String name) {
			this.name = name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}
	public class Hr
	{
		private String name;
		public Hr(String name) {
			this.name = name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}



}
