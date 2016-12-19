//LinkedStack linked based Stack C++ VH
#include <iostream>

using namespace std;

struct Node {
	int   data;
	Node* next;
};

class LinkedStack {
private:
	Node* topNode;          //pointer to the stack

public:
LinkedStack::LinkedStack() {
	topNode = NULL;
}

void LinkedStack::push(int newElement) {
	Node* newNode = new Node;      //create the node
	newNode->data = newElement;    //store newElement in the node

	newNode->next = topNode;             //insert newNode before topNode
	topNode = newNode;                   //set topNode to point to the newNode					  
}

// return -999 if stack is empty
int LinkedStack::peek() {
	int top = -999;

	if (topNode != NULL)
	    top = topNode->data;              //return the top element 

	return top;
}

int LinkedStack::pop() {
	int top = peek();
	
	Node* currentNode;                     //pointer to deallocate memory

	if (topNode != NULL) {
		currentNode = topNode;             //set temp to point to the top node
		topNode = topNode->next;           //advance stackTop to the next node
		delete currentNode;                //delete the top node
	}

	return top;
}

bool LinkedStack::isEmpty() {
	return(topNode == NULL);
}

void LinkedStack::deleteStack() {
	Node* currentNode;                     //pointer to delete the node

	while (topNode != NULL) {
		currentNode = topNode;            //set temp to point to the current node
		topNode = topNode->next;          //advance stackTop to the next node			
		delete currentNode;              //deallocate memory occupied by temp
	}
}

LinkedStack::~LinkedStack(){
	deleteStack();
}

};   // end LinkedStack

int main() {

	LinkedStack stack;

	stack.push(5);
	stack.push(7);
	stack.push(8);

	cout << "The top of the stack contains: " << stack.peek() << endl;

	return 0;
}

