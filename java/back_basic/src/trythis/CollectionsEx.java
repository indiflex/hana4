package trythis;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CollectionsEx {
	public static final String[] MOVIES = {"Transformer", "Star Wars", "Matrix", "Terminator", "Avatar"};

	public static void main(String[] args) {
		List<String> list = new LinkedList<>(Arrays.asList(MOVIES));
		System.out.println(list);
		Queue<String> queue = new PriorityQueue<>(5);
		queue.offer("ABC");
		queue.poll();

		Collections.sort(list);
		System.out.println(list);

		Collections.reverse(list);
		System.out.println(list);

		System.out.println(Collections.min(list));
		System.out.println(Collections.max(list));

		int avatarIdx = Collections.binarySearch(list, "Avatar", new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				System.out.println("o1 = " + o1 + ", o2 = " + o2);
				return o2.compareTo(o1);
			}
		});
		System.out.println("avatarIdx = " + avatarIdx);
	}
}
