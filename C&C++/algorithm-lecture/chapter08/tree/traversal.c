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

// 스택
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

// 원형 큐
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
	if (is_full(q)) { error("큐가 포화상태입니다"); }
	q->rear = (q->rear + 1) % MAX_QUEUE_SIZE;
	q->data[q->rear] = item;
}

element dequeue(QueueType* q) {
	if (is_empty(q)) {
		error("큐가 공백상태입니다");
	}
	q->front = (q->front + 1) % MAX_QUEUE_SIZE;
	return q->data[q->front];
}

// 전위 순회
void preorder(TreeNode* root) {
	if (root != NULL) {
		printf("[%d] ", root->data);	// 노드
		preorder(root->left);			// 왼쪽
		preorder(root->right);			// 오른쪽
	}
}

// 중위 순회
void inorder(TreeNode* root) {
	if (root != NULL) {
		inorder(root->left);			// 왼쪽
		printf("[%d] ", root->data);	// 노드
		inorder(root->right);			// 오른쪽
	}
}

// 후위 순회
void postorder(TreeNode* root) {
	if (root != NULL) {
		postorder(root->left);			// 왼쪽
		postorder(root->right);			// 오른쪽
		printf("[%d] ", root->data);	// 노드
	}
}

// 반복적인 중위 순회
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

// 레벨 순회
void level_order(TreeNode* ptr) {
	QueueType q;
	init_queue(&q);	// 큐 초기화

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
	printf("전위 순회 = ");
	preorder(root);
	printf("\n");

	printf("중위 순회 = ");
	inorder(root);
	printf("\n");

	printf("후위 순회 = ");
	postorder(root);
	printf("\n");

	printf("반복적 순회 = ");
	inorder_iter(root);
	printf("\n");


	printf("레벨 순회 = ");
	level_order(root);
	printf("\n");

	return 0;
}