// LinkedList linked based List C++ VH
#include <iostream> 
using namespace std;

struct Node {
	int        data;
	Node*      next;
};

class LinkedList {                             // LinkedList Class
private:

	Node* firstNode;       //pointer to the firstNode node of the list                    
	Node* lastNode;        //pointer to the lastNode node of the list
	int   length;		   //variable to store the number of elements in the list	

public:
	LinkedList::LinkedList() {                          // default constructor
		firstNode = NULL;
		lastNode  = NULL;
		length    = 0;
	}

	bool LinkedList::add(int newEntry) {                // adds at the end - insertLast

		Node* newNode = new Node;     //create the new node
		newNode->data = newEntry;
		newNode->next = NULL;

		if (firstNode == NULL) {	     //if list empty, newNode is both the firstNode and lastNode node
			firstNode = newNode;
			lastNode  = newNode;
		}
		else {			                 //list not empty, insert newNode after lastNode
			lastNode->next = newNode;    //insert newNode after lastNode
			lastNode       = newNode;    //make lastNode point to the actual lastNode node
		}

		length++;

		return true;
	}

	bool LinkedList::isEmpty() {                         // is empty
		return firstNode == NULL;
	}

	int LinkedList::getLength() {                        // get length
		return length;
	}

	bool LinkedList::contains(int anEntry) {             // contains
		bool  found = false;
		Node* currentNode = firstNode;            //currentNode points to firstNode in the list			

		while (currentNode != NULL && !found) {	  //search list
			if (anEntry == currentNode->data)     //item is found
				found = true;
			else
				currentNode = currentNode->next; //currentNode points to next node					 
		}

		return found;
	}

	void LinkedList::display() {                           // display
		Node* currentNode = firstNode;              //currentNode traverses list from firstNode

		while (currentNode != NULL) { 	            //travers list
			cout << currentNode->data << endl;
			currentNode = currentNode->next;       //currentNode points to next node							
		}
	}

	void LinkedList::insertFirst(int newEntry) {          // insertFirst
		Node* newNode = new Node;     //pointer to the newNode node
        newNode->data = newEntry;

		newNode->next = firstNode;    //insert newNode before firstNode
		firstNode     = newNode;      //make firstNode point to the actual first node

		length++;

		if (lastNode == NULL)         //if the list was empty, newNode is also the lastNode
			lastNode = newNode;
	}

	void LinkedList::deleteNode(int deleteEntry) {         // delete node
		Node* currentNode;        //pointer to traverse the list
		Node* trailCurrent;       //pointer just before current
		bool  found;

		if (!isEmpty()) {               // if list not empty

			if (firstNode->data == deleteEntry) {  // delete the first node
				currentNode = firstNode;
				firstNode = firstNode->next;
				length--;

				if (firstNode == NULL)           //list has only one node
					lastNode = NULL;

				delete currentNode;
			}
			else { //search the list for the node with the given data
				found = false;

				trailCurrent = firstNode;        //set trailCurrent to point to firstNode
				currentNode  = firstNode->next;  //set currentNode to point to second node 

				while (currentNode != NULL && !found) {
					if (currentNode->data != deleteEntry) {
						trailCurrent = currentNode;
						currentNode  = currentNode->next;
					}
					else
						found = true;
				}

				if (found) {                    // if found, delete the node
					trailCurrent->next = currentNode->next;
					length--;

					if (lastNode == currentNode)    //node to be deleted was the lastNode node
						lastNode = trailCurrent;    //update the value of lastNode

					delete currentNode;             //delete the node from the list
				}
				else
					cout << "Item to be deleted is not in the list." << endl;
			}
		} //end if list not empty
	}

	void LinkedList::destroyList() {                  // destroyList
		Node* tempNode;                  //pointer to deallocate the memory occupied by the node

		while (firstNode != NULL) {       //while there are nodes in the list
			tempNode = firstNode;        //set tempNode to the current node
			firstNode = firstNode->next;  //advance firstNode to the next node
			delete tempNode;              //deallocate memory occupied by tempNode
		}

		lastNode = NULL;	            //initialize lastNode to NULL; firstNode has already been set to NULL

		length = 0;
	}

	LinkedList::~LinkedList() {                    // destructor
		destroyList();
	}
};   // end LinkedList Class

int main() {

	LinkedList list;

	list.add(16);
	list.add(4);
	list.add(33);
	list.add(27);

	list.display();

	return 0;
} // end main