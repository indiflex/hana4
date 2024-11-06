package trythis;

public class StringEx {
	public static void main(String[] args) {
		// StringBuffer sb = new StringBuffer("This");
		StringBuilder sb = new StringBuilder("This");
		System.out.println("sb.hashCode = " + sb.hashCode());
		sb.append(" is a pencil");
		sb.insert(7, " my");
		sb.delete(10, 12);
		sb.setLength(5);
		sb.reverse();
		System.out.println("sb = " + "0123456789".repeat(3));
		System.out.println("sb = " + sb.toString());
		System.out.printf("capa=%d, len=%d (%d)%n", sb.capacity(), sb.length(), sb.capacity() - sb.length());
	}
}
