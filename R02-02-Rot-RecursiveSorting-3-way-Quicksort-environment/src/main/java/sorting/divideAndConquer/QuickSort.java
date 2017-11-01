package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int pivotIndex = rightIndex;
		boolean ordenado = false;
		while (!ordenado) {
			ordenado = true;
			for (int i = 0; i < pivotIndex; i++) {
				if (array[i].compareTo(array[pivotIndex]) >= 0) {
					if (array[i].compareTo(array[pivotIndex]) > 0) {
						ordenado = false;
					}
					Util.swap(array, i, pivotIndex - 1);
					Util.swap(array, pivotIndex - 1, pivotIndex);
					i--;
					pivotIndex--;
				}
				else {
					ordenado = false;
				}
			}
			if (!ordenado) {
				sort(array, leftIndex, pivotIndex - 1);
				sort(array, pivotIndex + 1, rightIndex);
			}
		}
	}
}
