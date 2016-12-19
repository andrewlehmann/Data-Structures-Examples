#include <iostream>
using namespace std;

struct Node {
	int   data;
	Node* next;
};

class LinkedQueue {

private:
	Node* queueFront; //pointer to the front of the queue
	Node* queueBack;  //pointer to the rear of the queue

public:
LinkedQueue::LinkedQueue() {
	queueFront = NULL; //set front to null
	queueBack = NULL;  //set rear to null
} 

void LinkedQueue::enqueue(int newEntry) {
	Node* newNode = new Node();   //create the newNode
	newNode->data = newEntry;     //store newEntry in the data
	newNode->next = NULL;         //initialize the next field to NULL

	if (queueFront == NULL) {    //if the queue is empty
		queueFront = newNode;
		queueBack  = newNode;
	}
	else {                       //add newNode at the end
		queueBack->next = newNode;
		queueBack = queueBack->next;
	}
}

int LinkedQueue::front() {
	int front = 0;

	if (!isEmpty())
		front = queueFront->data;

	return front;
}

int LinkedQueue::dequeue() {
	int front = 0;

	Node* currentNode; // only needed because we want to memory delete that node

		if (!isEmpty())
		{
			currentNode = queueFront;      //make currentNode point to the queueFront
			queueFront = queueFront->next; //advance queueFront 
			front = currentNode->data;

			delete currentNode;            //delete the first node

			if (queueFront == NULL)       //if after deletion the queue is empty
				queueBack = NULL;            //set queueRear to NULL
		}

	return front;
}

bool LinkedQueue::isEmpty() {
	return(queueFront == NULL);
}

bool LinkedQueue::isFull() {
	return false;
}  

void LinkedQueue::clear() {
	Node* tempNode;

	while (queueFront != NULL) {
		tempNode = queueFront;          //set tempNode to point to the queueFront	
		queueFront = queueFront->next;  //advance queueFront to the next node 
									
		delete tempNode;               //deallocate memory occupied by temp
	}

	queueBack = NULL;                 //set queueBack to NULL
} 

LinkedQueue::~LinkedQueue() {
	clear();
} 
};  // end LinkedQueue

int main() {
	LinkedQueue queue;

	queue.enqueue(5);
	queue.enqueue(7);
	queue.enqueue(8);

	cout << "The front of the queue contains: " << queue.front() << endl;

	return 0;
}