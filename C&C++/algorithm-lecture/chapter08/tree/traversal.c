#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

typedef struct TreeNode {
	int data;
	struct TreeNode* left, * right;
} TreeNode;

TreeNode n1 = { 1, NULL, NULL };
TreeNode n2 = { 4, &n1, NULL };
TreeNode n3 = { 16, NULL, NULL };
TreeNode n4 = { 25, NULL, NULL };
TreeNode n5 = { 20, &n3, &n4 };
TreeNode n6 = { 15, &n2, &n5};
TreeNode* root = &n6;

// ����
#define SIZE 100
int top = -1;
TreeNode* stack[SIZE];

void push(TreeNode* p) {
	if (top < SIZE - 1) {
		stack[++top] = p;
	}
}

TreeNode *pop() {
	TreeNode* p = NULL;
	if (top >= 0) {
		p = stack[top--];
	}
	return p;
}

// ���� ť
#define MAX_QUEUE_SIZE 100
typedef TreeNode* element;
typedef struct {
	element data[MAX_QUEUE_SIZE];
	int front, rear;
} QueueType;

void error(char* message) {
	fprintf(stderr, "%s\n", message);
	exit(1);
}

int is_full(QueueType* q) {
	return ((q->rear + 1) % MAX_QUEUE_SIZE == q->front);
}

int is_empty(QueueType* q) {
	return (q->front == q->rear);
}

void init_queue(QueueType* q) {
	q->front = q->rear = 0;
}

void enqueue(QueueType* q, element item) {
	if (is_full(q)) { error("ť�� ��ȭ�����Դϴ�"); }
	q->rear = (q->rear + 1) % MAX_QUEUE_SIZE;
	q->data[q->rear] = item;
}

element dequeue(QueueType* q) {
	if (is_empty(q)) {
		error("ť�� ��������Դϴ�");
	}
	q->front = (q->front + 1) % MAX_QUEUE_SIZE;
	return q->data[q->front];
}

// ���� ��ȸ
void preorder(TreeNode* root) {
	if (root != NULL) {
		printf("[%d] ", root->data);	// ���
		preorder(root->left);			// ����
		preorder(root->right);			// ������
	}
}

// ���� ��ȸ
void inorder(TreeNode* root) {
	if (root != NULL) {
		inorder(root->left);			// ����
		printf("[%d] ", root->data);	// ���
		inorder(root->right);			// ������
	}
}

// ���� ��ȸ
void postorder(TreeNode* root) {
	if (root != NULL) {
		postorder(root->left);			// ����
		postorder(root->right);			// ������
		printf("[%d] ", root->data);	// ���
	}
}

// �ݺ����� ���� ��ȸ
void inorder_iter(TreeNode* root) {
	while (1) {
		
		for (; root; root = root->left) {
			push(root);
		}

		root = pop();
	
		if (!root) {
			break;
		}

		printf("[%d] ", root->data);
		root = root->right;
	}
}

// ���� ��ȸ
void level_order(TreeNode* ptr) {
	QueueType q;
	init_queue(&q);	// ť �ʱ�ȭ

	if (ptr == NULL) return;

	enqueue(&q, ptr);

	while (!is_empty(&q)) {
		ptr = dequeue(&q);
		printf(" [%d] ", ptr->data);
		if (ptr->left) { enqueue(&q, ptr->left); }
		if (ptr->right) { enqueue(&q, ptr->right); }
	}
}

int main() {
	printf("���� ��ȸ = ");
	preorder(root);
	printf("\n");

	printf("���� ��ȸ = ");
	inorder(root);
	printf("\n");

	printf("���� ��ȸ = ");
	postorder(root);
	printf("\n");

	printf("�ݺ��� ��ȸ = ");
	inorder_iter(root);
	printf("\n");


	printf("���� ��ȸ = ");
	level_order(root);
	printf("\n");

	return 0;
}