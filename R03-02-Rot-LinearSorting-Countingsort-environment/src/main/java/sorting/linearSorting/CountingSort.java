package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		int maior = 0;
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i].compareTo(maior) > 0) {
				maior = array[i];
			}
		}
		int[] aux = new int[maior + 1];
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			aux[array[i]]++;
		}
		
		for (int i = 1; i < aux.length; i++) {
			aux[i] += aux[i - 1];
		}
		
		int[] decoy = new int[rightIndex - leftIndex + 1];
		for (int i = leftIndex; i <= rightIndex; i++) {
			 decoy[aux[array[i]] - 1] = array[i];
			 aux[array[i]]--;
		}
		
		for (int i = 0; i < decoy.length; i++) {
			array[i + leftIndex] = decoy[i];
		}
	}

}
