#include <stdio.h>
#include <stdlib.h>
#define MAX 50

void selection_sort_ascending(int data[]);
void selection_sort_descending(int data[]);
void insertion_sort_ascending(int data[]);
void insertion_sort_descending(int data[]);
void bubble_sort_ascending(int data[]);
void bubble_sort_descending(int data[]);
void merge_sort_ascending(int data[]);
void merge_sort_descending(int data[]);
void heap_sort_ascending(int data[]);
void heap_sort_descending(int data[]);
void quick_sort_ascending(int data[]);
void quick_sort_descending(int data[]);
void radix_sort_ascending(int data[]);
void radix_sort_descending(int data[]);
void shell_sort_ascending(int data[]);
void shell_sort_descending(int data[]);

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

		for (int i = 0; i < index; i++) {
			printf("%d ", data[i]);
		}
		printf("\n");

		switch (sorting_method) {
		case 's':
			switch (sequence) {
			case 'i':
				selection_sort_ascending(data);
				break;
			case 'd':
				selection_sort_descending(data);
				break;
			}
			break;
		case 'i':
			switch (sequence) {
			case 'i':
				insertion_sort_ascending(data);
				break;
			case 'd':
				insertion_sort_ascending(data);
				break;
			}
			break;
		case 'b':
			switch (sequence) {
			case 'i':
				bubble_sort_ascending(data);
				break;
			case 'd':
				bubble_sort_descending(data);
				break;
			}
			break;
		case 'm':
			switch (sequence) {
			case 'i':
				merge_sort_ascending(data);
				break;
			case 'd':
				merge_sort_descending(data);
				break;
			}
			break;
		case 'h':
			switch (sequence) {
			case 'i':
				heap_sort_ascending(data);
				break;
			case 'd':
				heap_sort_descending(data);
				break;
			}
			break;
		case 'q':
			switch (sequence) {
			case 'i':
				quick_sort_ascending(data);
				break;
			case 'd':
				quick_sort_descending(data);
				break;
			}
			break;
		case 'r':
			switch (sequence) {
			case 'i':
				radix_sort_ascending(data);
				break;
			case 'd':
				radix_sort_ascending(data);
				break;
			}
			break;
		case 'l':
			switch (sequence) {
			case 'i':
				shell_sort_ascending(data);
				break;
			case 'd':
				shell_sort_descending(data);
				break;
			}
			break;
		}
	}

	return 0;
}

void selection_sort_ascending(int data[]) {

}

void selection_sort_descending(int data[]) {

}

void insertion_sort_ascending(int data[]) {

}

void insertion_sort_descending(int data[]) {

}

void bubble_sort_ascending(int data[]) {

}

void bubble_sort_descending(int data[]) {

}

void merge_sort_ascending(int data[]) {

}

void merge_sort_descending(int data[]) {

}

void heap_sort_ascending(int data[]) {

}

void heap_sort_descending(int data[]) {

}

void quick_sort_ascending(int data[]) {

}

void quick_sort_descending(int data[]) {

}

void radix_sort_ascending(int data[]) {

}

void radix_sort_descending(int data[]) {

}

void shell_sort_ascending(int data[]) {

}

void shell_sort_descending(int data[]) {

}
