package edu.akdeniz.softeng.survey.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.scheduling.annotation.Scheduled;

public class IterateHelper {

	public interface convertFunction<S, T> {
		T convert(S source);
	}

	/**
	 * To convert iterable with type S to type T
	 *
	 * @param <S>
	 *            source type of iterable
	 * @param <T>
	 *            target type will be converted
	 * @return new converted iterable
	 */
	public static <S, T> List<T> convertIterable(Iterable<S> sourceIterable, convertFunction<S, T> convertFunction) {

		List<T> targetIterable = new ArrayList<T>();

		if (sourceIterable == null) {
			return targetIterable;
		}
		for (S source : sourceIterable) {
			targetIterable.add(convertFunction.convert(source));
		}
		return targetIterable;
	}

	public static <T> void lockClearAddAll(List<T> sourceIterable, List<T> targetIterable) {
		synchronized (targetIterable) {
			clearAddAll(sourceIterable, targetIterable);
		}
	}

	private static <T> void clearAddAll(List<T> sourceIterable, List<T> targetIterable) {

		targetIterable.clear();
		if (sourceIterable == null) {
			return;
		}
		targetIterable.addAll(sourceIterable);
	}

	public static List<String> getListFrom(String str, String delim) {
		StringTokenizer tokenizer = new StringTokenizer(str, delim);
		List<String> result = new ArrayList<>();

		while (tokenizer.hasMoreElements()) {
			result.add(tokenizer.nextToken().trim());
		}
		return result;

	}

	public static List<Integer> getIntListFrom(String str, String delim) {
		StringTokenizer tokenizer = new StringTokenizer(str, delim);
		List<Integer> result = new ArrayList<>();

		while (tokenizer.hasMoreElements()) {
			try {
				result.add(Integer.parseInt(tokenizer.nextToken().trim()));
			} catch (Exception e) {
			}

		}
		return result;
	}

}
