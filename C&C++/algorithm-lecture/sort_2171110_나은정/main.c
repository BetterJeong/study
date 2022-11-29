#include <stdio.h>
#include <stdlib.h>
#define MAX 50
#define SWAP(x, y, t) ( (t) = (x), (x) = (y), (y)=(t))

void selection_sort_ascending(int data[], int n);
void selection_sort_descending(int data[], int n);
void insertion_sort_ascending(int data[], int n);
void insertion_sort_descending(int data[], int n);
void bubble_sort_ascending(int data[], int n);
void bubble_sort_descending(int data[], int n);
void merge_sort_ascending(int data[], int l, int r, int n);
void merge_sort_descending(int data[], int l, int r, int n);
void heap_sort_ascending(int data[], int n);
void heap_sort_descending(int data[], int n);
void quick_sort_ascending(int data[], int left, int right);
void quick_sort_descending(int data[], int left, int right);
void radix_sort_ascending(int data[], int n);
void radix_sort_descending(int data[], int n);
void shell_sort_ascending(int data[], int n);
void shell_sort_descending(int data[], int n);

int main() {
	printf("2171110 나은정\n");
	
	while (1) {
		char sorting_method = 'a';
		char sequence = 'i';
		char num_input[10000] = "a";
		int index = 0;
		int* data = (int*)malloc(sizeof(int) * MAX);

		printf("===============\n");
		printf("선택 정렬: s\n");
		printf("삽입 정렬: i\n");
		printf("버블 정렬: b\n");
		printf("합병 정렬: m\n");
		printf("히프 정렬: h\n");
		printf("퀵 정렬: q\n");
		printf("기수 정렬: r\n");
		printf("쉘 정렬: l\n");
		printf("프로그램 종료: x\n");
		printf("===============\n");
		printf("원하는 정렬을 선택하세요: ");
		scanf("%c", &sorting_method);
		getchar();
		
		switch (sorting_method) {
		case 's':
		case 'i':
		case 'b':
		case 'm':
		case 'h':
		case 'q':
		case 'r':
		case 'l':
			printf("===============\n");
			printf("오름차순: i\n");
			printf("내림차순: d\n");
			printf("===============\n");
			printf("차순을 선택하세요: ");
			scanf("%c", &sequence);
			getchar();

			for (index = 0; index < MAX; index++) {
				printf("숫자 입력 (최대 50개): ");
				scanf("%s", &num_input);
				getchar();
				if (strcmp(num_input, "=") == 0) {
					break;
				}
				else {
					data[index] = atoi(num_input);
				}
			}

			break;
		case 'x':
			printf("프로그램을 종료합니다.\n");
			break;
		default:
			printf("잘못된 알파벳을 입력하였습니다. 다시 입력해주세요.\n");
			break;
		}

		int n = index;

		switch (sorting_method) {
		case 's':
			switch (sequence) {
			case 'i':
				selection_sort_ascending(data, n);
				break;
			case 'd':
				selection_sort_descending(data, n);
				break;
			}
			break;
		case 'i':
			switch (sequence) {
			case 'i':
				insertion_sort_ascending(data, n);
				break;
			case 'd':
				insertion_sort_descending(data, n);
				break;
			}
			break;
		case 'b':
			switch (sequence) {
			case 'i':
				bubble_sort_ascending(data, n);
				break;
			case 'd':
				bubble_sort_descending(data, n);
				break;
			}
			break;
		case 'm':
			switch (sequence) {
			case 'i':
				merge_sort_ascending(data, 0, n, n-1);
				break;
			case 'd':
				merge_sort_descending(data, 0, n, n-1);
				break;
			}
			break;
		case 'h':
			switch (sequence) {
			case 'i':
				heap_sort_ascending(data, n);
				break;
			case 'd':
				heap_sort_descending(data, n);
				break;
			}
			break;
		case 'q':
			switch (sequence) {
			case 'i':
				quick_sort_ascending(data, 0, n-1);
				break;
			case 'd':
				quick_sort_descending(data, 0, n-1);
				break;
			}
			break;
		case 'r':
			switch (sequence) {
			case 'i':
				radix_sort_ascending(data, n);
				break;
			case 'd':
				radix_sort_ascending(data, n);
				break;
			}
			break;
		case 'l':
			switch (sequence) {
			case 'i':
				shell_sort_ascending(data, n);
				break;
			case 'd':
				shell_sort_descending(data, n);
				break;
			}
			break;
		}

		for (int i = 0; i < index; i++) {
			printf("%d ", data[i]);
		}
		printf("\n");
	}

	return 0;
}

void selection_sort_ascending(int data[], int n) {
	int i, j, min, temp;
	for (i = 0; i < n - 1; i++) {
		min = i;
		for (j = i + 1; j < n; j++) {
			if (data[j] < data[min]) min = j;
		}
		SWAP(data[i], data[min], temp);
	}
}

void selection_sort_descending(int data[], int n) {
	int i, j, max, temp;
	for (i = 0; i < n - 1; i++) {
		max = i;
		for (j = i + 1; j < n; j++) {
			if (data[j] > data[max]) max = j;
		}
		SWAP(data[i], data[max], temp);
	}
}

void insertion_sort_ascending(int data[], int n) {
	int i, j, key;
	for (i = 1; i < n; i++) {
		key = data[i];
		for (j = i - 1; j >= 0 && data[j] > key; j--) {
			data[j + 1] = data[j];
		}
		data[j + 1] = key;
	}
}

void insertion_sort_descending(int data[], int n) {
	int i, j, key;
	for (i = 1; i < n; i++) {
		key = data[i];
		for (j = i - 1; j >= 0 && data[j] < key; j--) {
			data[j + 1] = data[j];
		}
		data[j + 1] = key;
	}
}

void bubble_sort_ascending(int data[], int n) {
	int i, j, temp;
	for (i = n - 1; i > 0; i--) {
		for (j = 0; j < i; j++) {
			if (data[j] > data[j + 1]) {
				SWAP(data[j], data[j + 1], temp);
			}
		}
	}
}

void bubble_sort_descending(int data[], int n) {
	int i, j, temp;
	for (i = n - 1; i > 0; i--) {
		for (j = 0; j < i; j++) {
			if (data[j] < data[j + 1]) {
				SWAP(data[j], data[j + 1], temp);
			}
		}
	}
}

void merge_a(int data[], int left, int mid, int right, int n) {
	int i, j, k, l;
	i = left; j = mid + 1; k = left;
	int* sorted = (int*)malloc(sizeof(int) * (n+1));

	while (i <= mid && j <= right) {
		if (data[i] <= data[j]) {
			sorted[k++] = data[i++];
		}
		else {
			sorted[k++] = data[j++];
		}
	}

	if (i > mid) {
		for (l = j; l <= right; l++) {
			sorted[k++] = data[l];
		}
	}
	else {
		for (l = i; l <= mid; l++) {
			sorted[k++] = data[l];
		}
	}
	
	for (l = left; l <= right; l++) {
		data[l] = sorted[l];
	}
}

void merge_d(int data[], int left, int mid, int right, int n) {
	int i, j, k, l;
	i = left; j = mid + 1; k = left;
	int* sorted = (int*)malloc(sizeof(int) * (n + 1));

	while (i <= mid && j <= right) {
		if (data[i] >= data[j]) {
			sorted[k++] = data[i++];
		}
		else {
			sorted[k++] = data[j++];
		}
	}

	if (i > mid) {
		for (l = j; l <= right; l++) {
			sorted[k++] = data[l];
		}
	}
	else {
		for (l = i; l <= mid; l++) {
			sorted[k++] = data[l];
		}
	}

	for (l = left; l <= right; l++) {
		data[l] = sorted[l];
	}
}

void merge_sort_ascending(int data[], int left, int right, int n) {
	int mid;
	if (left < right) {
		mid = (left + right) / 2;
		merge_sort_ascending(data, left, mid, n);
		merge_sort_ascending(data, mid + 1, right, n);
		merge_a(data, left, mid, right, n);
	}
}

void merge_sort_descending(int data[], int left, int right, int n) {
	int mid;
	if (left < right) {
		mid = (left + right) / 2;
		merge_sort_ascending(data, left, mid, n);
		merge_sort_ascending(data, mid + 1, right, n);
		merge_d(data, left, mid, right, n);
	}
}

void heapify(int* data, int size) {
	for (int i = 1; i < size; ++i) {
		int child = i;
		do {
			int root = (child - 1) / 2;
			if (data[root] < data[child]) {
				int temp = data[root];
				data[root] = data[child];
				data[child] = temp;
			}
			child = root;
		} while (child != 0);
	}
}

void heap(int* data, int* n) {
	int temp = data[0];
	data[0] = data[*n - 1];
	data[*n - 1] = temp;
	--(*n);
}

void heap_sort_ascending(int data[], int n) {
	for (int i = 0; i < n; i++) {
		heapify(data, n);
		heap(data, &n);
	}
}

void heap_sort_descending(int data[], int n) {
	for (int i = 0; i < n; i++) {
		heapify(data, n);
		heap(data, &n);
	}
}

int partition_a(int data[], int left, int right) {
	int pivot, temp;
	int low, high;

	low = left;
	high = right + 1;
	pivot = data[left];
	do {
		do {
			low++;
		} while (data[low] < pivot);
		do {
			high--;
		} while (data[high] > pivot);
		if (low < high) SWAP(data[low], data[high], temp);
	} while (low < high);

	SWAP(data[left], data[high], temp);
	return high;
}

int partition_d(int data[], int left, int right) {
	int pivot, temp;
	int low, high;

	low = left;
	high = right + 1;
	pivot = data[left];
	do {
		do {
			low++;
		} while (data[low] > pivot);
		do {
			high--;
		} while (data[high] < pivot);
		if (low < high) SWAP(data[high], data[low], temp);
	} while (low < high);

	SWAP(data[high], data[left], temp);
	return high;
}

void quick_sort_ascending(int data[], int left, int right) {
	if (left < right) {
		int q = partition_a(data, left, right);
		quick_sort_ascending(data, left, q - 1);
		quick_sort_ascending(data, q + 1, right);
	}
}

void quick_sort_descending(int data[], int left, int right) {
	if (left < right) {
		int q = partition_d(data, left, right);
		quick_sort_ascending(data, left, q - 1);
		quick_sort_ascending(data, q + 1, right);
	}
}

void radix_sort_ascending(int data[], int n) {

}

void radix_sort_descending(int data[], int n) {

}

void shell_sort_ascending(int data[], int n) {

}

void shell_sort_descending(int data[], int n) {

}