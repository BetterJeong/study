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
	printf("2171110 ������\n");
	
	while (1) {
		char sorting_method = 'a';
		char sequence = 'i';
		char num_input[10000] = "a";
		int index = 0;
		int* data = (int*)malloc(sizeof(int) * MAX);

		printf("===============\n");
		printf("���� ����: s\n");
		printf("���� ����: i\n");
		printf("���� ����: b\n");
		printf("�պ� ����: m\n");
		printf("���� ����: h\n");
		printf("�� ����: q\n");
		printf("��� ����: r\n");
		printf("�� ����: l\n");
		printf("���α׷� ����: x\n");
		printf("===============\n");
		printf("���ϴ� ������ �����ϼ���: ");
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
			printf("��������: i\n");
			printf("��������: d\n");
			printf("===============\n");
			printf("������ �����ϼ���: ");
			scanf("%c", &sequence);
			getchar();

			for (index = 0; index < MAX; index++) {
				printf("���� �Է� (�ִ� 50��): ");
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
			printf("���α׷��� �����մϴ�.\n");
			break;
		default:
			printf("�߸��� ���ĺ��� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.\n");
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
