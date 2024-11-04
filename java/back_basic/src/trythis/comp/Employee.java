package trythis.comp;

public class Employee {
	private final int id;
	private final String name;
	private int salary;

	public Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAnnualSalary() {
		return this.salary * 12;
	}

	public int raiseSalary(int percent) {
		return this.salary * percent / 100;
	}

	@Override
	public String toString() {
		return "Employee[id=%d, name=%s,\nsalary=%,d]의 연봉은 %,d 월급 인상분은 %,d".formatted(getId(), getName(),
			getSalary(),
			getAnnualSalary(), raiseSalary(id * 10));
	}

}
