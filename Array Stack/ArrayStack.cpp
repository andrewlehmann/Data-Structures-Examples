//ArrayStack array based Stack C++ VH
#include <iostream>

using namespace std;

class ArrayStack {
private:
	int*          stack;                         // pointer to the array for the stack elements
	int           topIndex;                      // top of the stack
	const int     DEFAULT_INITIAL_CAPACITY = 50; // maximum stack size

public:
	ArrayStack::ArrayStack(int initialCapacity) {
		stack = new int[initialCapacity];  //create the array to hold the stack elements
		topIndex = -1;
	}
	
	void ArrayStack::push(int newEntry) {
	
		if (!isFull()) {
			topIndex++;                      //increment topIndex
			stack[topIndex] = newEntry;   //add newItem to the top of the stack
		}
	}

	// return -999 if stack is empty
	int ArrayStack::peek() {
		int top = -999;

		if (!isEmpty())
			top = stack[topIndex];

		return top;
	}

	int ArrayStack::pop() {
		int top = peek();

		if (!isEmpty()) {
			top             = stack[topIndex];
			stack[topIndex] = 0;
			topIndex        = topIndex - 1;        
		}
		
		return top;
	}

	bool ArrayStack::isEmpty() {
		return(topIndex < 0);
	}

	bool ArrayStack::isFull() {
		return(topIndex == DEFAULT_INITIAL_CAPACITY);
	}

	ArrayStack::~ArrayStack() {
		delete[] stack;            //deallocate the memory occupied by the array	  
	}

};   // end ArrayStack


int main() {

	ArrayStack stack(50);

	stack.push(5);
	stack.push(7);
	stack.push(8);

	cout << "The top of the stack contains: " << stack.peek() << endl;

	return 0;
}
