package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

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
		Add add = Integer::sum;

		calc(5, n);
		calc2(5, a -> -a);
		calc3(5, 2, (a, b) -> a - b);
		calc4(5, 0, (a, b) -> System.out.println(b == 0 ? 0 : a / b));
		calc4(5, 0, (a, b) -> {
			if (b == 0) {
				return;
			}
			System.out.println(a / b);
		});
	}

	private static <T> void calc4(T a, T b, BiConsumer<T, T> bi) {
		bi.accept(a, b);
	}

	private static <T> void calc3(T a, T b, BiFunction<T, T, T> f) {
		System.out.println("calc3 = " + f.apply(a, b));
	}

	private static <T> void calc2(T x, Function<T, T> f) {
		System.out.println("f = " + f.apply(x));
	}

	private static void calc(int x, Negative neg) {
		System.out.println("neg = " + neg.neg(x));
	}

	@FunctionalInterface
	interface Add {
		int add(int a, int b);
	}

	interface Negative {
		int neg(int x);
	}
}
