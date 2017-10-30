package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int temp;
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			for (int j = i - 1; j >= 0; j--) {
				temp = j + 1;
				if (array[j].compareTo(array[temp]) >= 0) {
					Util.swap(array, temp, j);
				}
			}
		}
	}
}
