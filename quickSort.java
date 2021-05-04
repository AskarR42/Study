import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfArray = scanner.nextInt();
        int[] array = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = scanner.nextInt();
        }

        quickSort(array, 0, sizeOfArray - 1);

        for (int elem : array) {
            System.out.print(elem + " ");
        }
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int partitionIndex = left;

        for (int i = left; i < right; i++) {
            if (array[i] <= pivot) {
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }

        swap(array, partitionIndex, right);

        return partitionIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
