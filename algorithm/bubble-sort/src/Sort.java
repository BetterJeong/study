import java.util.Arrays;

public class Sort {

    public void bubbleSort(int[] arr, int size) {
        // 배열 크기 - 1 만큼 반복 실행
        for (int i = 0; i < size - 1; i++) {
            // 전체 한 반복 당 전체 배열 크기-1 에 i를 뺀 만큼 반복하며 비교
            for (int j = 0; j < size - i - 1; j++) {
                // j 번째 값이 다음 값보다 클 경우 값 교환
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
                System.out.println((i+1)+"회 반복 중 "+ (j+1) + "번째 비교: " + Arrays.toString(arr));
            }
        }
    }

}
