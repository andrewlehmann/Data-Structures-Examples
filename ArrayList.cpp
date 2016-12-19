// ArrayList array based List C++ VH
#include <iostream>
using namespace std;

class ArrayList {
private:

	int* list;                    //array to hold the list elements
	int  length;                  //to store the length of the list
	const int MAX_SIZE = 50;      //to store the maximum size of the list

public:
	ArrayList::ArrayList(int maxSize) {
		list   = new int[maxSize];
		length = 0;
	}

	bool ArrayList::isFull() {
		return length == MAX_SIZE;
	}

	// add at the end
	bool ArrayList::add(int newEntry) {   //end add at the end
		bool isSuccessful = true;

		if (!isFull()) {                 //the list is not full
			list[length] = newEntry;     //insert the newEntry at the end
			length++;
		}
		else
			isSuccessful = false;

		return isSuccessful;
	}

	// newPosition is one based. i.e., is the 1st to length position
	bool ArrayList::add(int newPosition, int newEntry) {  // add at newPosition
		bool isSuccessful = true;

		if (!isFull() && (newPosition >= 1) && (newPosition <= length + 1)) {
			// make room
			for (int i = length; i >= newPosition; i--)
				list[i] = list[i - 1];       //move the elements down

			list[newPosition - 1] = newEntry;    //insert newEntry at specified position
			length++;
		}
		else
			isSuccessful = false;

		return isSuccessful;
	}

	bool ArrayList::isEmpty() {
		return length == 0;
	}

	// givenPosition is one based. i.e., is the 1st to length position
	int ArrayList::remove(int givenPosition) {   // remove
		int result = 0; // return value

		if ((givenPosition >= 1) && (givenPosition <= length)) {
			result = list[givenPosition - 1];   // get entry to be removed

			// move subsequent entries toward entry to be removed, unless it is last in list							
			if (givenPosition < length) {
				for (int i = givenPosition; i < length - 1; i++) 
					list[i] = list[i + 1];
			}

			length--;
		}

		return result; // return reference to removed entry, or null	
	}

	// givenPosition is one based. i.e., is the 1st to length position
	bool ArrayList::replace(int givenPosition, int newEntry) {  // replace
		bool isSuccessful = true;

		if ((givenPosition >= 1) && (givenPosition <= length)) // test catches empty list
			list[givenPosition - 1] = newEntry;
		else
			isSuccessful = false;

		return isSuccessful;
	}

	int ArrayList::getLength() {
		return length;
	}

	// givenPosition is one based. i.e., is the 1st to length position
	int ArrayList::getEntry(int givenPosition) {   // getEntry
		int result = 0; // result to return

		if ((givenPosition >= 1) && (givenPosition <= length))
			result = list[givenPosition - 1];

		return result;
	}

	bool ArrayList::contains(int anEntry) {     // contains
		bool found = false;

		for (int index = 0; !found && (index < length); index++) {
			if (anEntry == list[index])
				found = true;
		}

		return found;
	}

	void ArrayList::display() {                // display
		for (int index = 0; index < length; index++)
			cout << list[index] << endl;
	}

	ArrayList::~ArrayList() {
		delete[] list;
	}
}; // end ArrayList Class

int main() {

	ArrayList list(50);

	list.add(16);  // winner
	list.add(4);   // second place
	list.add(33);  // third place
	list.add(27);  // fourth place

	list.display();

	return 0;
}  // end main