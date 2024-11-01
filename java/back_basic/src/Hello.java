import java.util.Arrays;

public class Hello {
	private int id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public static void main(String[] args) {
		Hello hello = new Hello();
		System.out.println("num = " + hello.getId());
		System.out.println("name = " + hello.getName());
		System.out.println("Hello World");
		String s1 = "abc\t\n";
		System.out.println("s1 = " + s1 + ", " + s1.trim() + ".");
		String s2 = "def";
		System.out.println(s1 == s2);
		String s3 = "def";
		System.out.println("Literal>>" + (s3 == s2));

		String s22 = new String("def");
		String s33 = new String("def");
		System.out.println("Instance>>" + (s33 == s22));
		System.out.println("equal = " + s33.equals(s22));
		System.out.println("s33.con = " + s33.concat(s22));
		System.out.println("s33 = " + s33);
		System.out.println("s33 = " + s33.replace('d', 'A'));

		int[] nums1 = {1, 2, 3, 4, 5};
		int[] nums2 = new int[3];
		System.arraycopy(nums1, 1, nums2, 0, 3);
		System.out.println("num2=" + Arrays.toString(nums2));
	}
}
