package trythis.school;

import java.util.ArrayList;
import java.util.List;

public class School {
	private static String getGrade(Integer score) {
		String grade = "F";
		switch (score / 10) {
			case 10, 9 -> grade = "A";
			case 8 -> grade = "B";
			case 7 -> grade = "C";
			case 6 -> grade = "D";
		}

		return grade;
	}

	public static final int STUDENT_COUNT = 10;

	public static void main(String[] args) {
		List<Integer> scores = new ArrayList<>(STUDENT_COUNT);
		List<Integer> min = new ArrayList<>();
		// min.add(Integer.MAX_VALUE);
		min.add(100);
		List<Integer> max = new ArrayList<>();
		// max.add(Integer.MIN_VALUE);
		max.add(0);

		// QQQ
		int[] scoresToTest = {30, 50, 40, 80, 90, 99, 99, 30, -1};
		for (int s : scoresToTest) {
			scores.add(s);
			if (s < 0) {
				break;
			}

			if (s < min.get(0)) {
				min.add(s);
			}
			if (s > max.get(0)) {
				max.add(s);
			}
		}

		scores.removeAll(min);
		scores.removeAll(max);

		System.out.println("학생들의 성적" + scores);

		int sum = 0;
		int maxScore = 0;
		for (int i = 0; i < scores.size(); i++) {
			int score = scores.get(i);
			sum += score;
			if (score > maxScore) {
				maxScore = score;
			}

			System.out.printf("%d 학생의 성적은 %d이며 학점은 %s이다", (i + 1), score, getGrade(score));
		}

		System.out.printf("평균은 %.1f, 최고 점수는 %d 이다.", (sum / (double)scores.size()), maxScore);
	}
}
