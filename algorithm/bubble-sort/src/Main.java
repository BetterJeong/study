import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int size = 5;
        int[] arr = {5, 2, 4, 1, 3};

        sort.bubbleSort(arr, size);

        System.out.println("정렬된 배열: "+ Arrays.toString(arr));
    }
}