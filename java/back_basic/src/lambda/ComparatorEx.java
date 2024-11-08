package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import trythis.CollectionsEx;

public class ComparatorEx {
	public static void main(String[] args) {
		String[] strings = CollectionsEx.MOVIES;
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String first, String second) {
				return first.length() - second.length();
			}
		});

		System.out.println("movie = " + Arrays.toString(strings));

		Comparator<String> compa = (first, second) ->
			second.length() - first.length();

		Arrays.sort(strings, compa);

		for (String s : strings) {
			System.out.println("movie = " + s);
		}

		System.out.println("-----------------------");

		List<String> list = Arrays.asList(strings);
		System.out.println("list = " + list.getClass().getName());

		// list.stream().map(str -> str.length()).filter(len -> len > 7).collect(Collectors.toSet());
		list.stream().map(String::length).filter(len -> len > 7).forEach(System.out::println);

		Negative n = x -> -x;
		Add a = Integer::sum;

	}

	interface Add {
		int add(int a, int b);
	}

	interface Negative {
		int neg(int x);
	}
}
