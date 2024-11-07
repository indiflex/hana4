package trythis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

		List<Integer> list = new ArrayList<>(10);
		Scanner scan = new Scanner(System.in);
		List<Integer> min = new ArrayList<>();
		min.add(100);
		List<Integer> max = new ArrayList<>();
		while (true) {
			System.out.print("XXX? ");
			int ret = scan.nextInt();
			if (ret < 0) {
				break;
			}

			min.add(Math.min(ret, min.get(0)));
			list.add(ret);
		}

		// list.remove(new Integer(min));
		list.removeAll(min);

		int tot = 0;
		for (int score : list) {
			tot += score;
		}
		System.out.println("tot = " + tot);
	}
}
