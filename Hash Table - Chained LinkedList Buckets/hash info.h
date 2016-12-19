hashArray = new LinkedList[tableLength];

modulo hash - uses remainder from division of the key by hash table size N

mid-square hash - squares the key, takes R digits from the result's middle, then returns the remainder of the middle digits divided by hash table size N

multiplicative string hash - repeatedly multiplies the hash value and adds the ASCII value of each character in the string. It would start at a high value. For each character, the hash function multiplies the current hash value by a multiplier (often prime) and adds the character's value. Finally, the function returns the remainder of the sum divided by the hash table size N.

direct hash function - uses item's key as bucket index

A direct access table has no collisions - each key is unique/gets a unique bucket.
	1. All keys must be non-negative integers, but for some applications keys may be negative.
	
	2. The hash table's size = the largest key value plus 1, which may be very large.
	

	
	public void hashInsert(int key)	{
		int index = hash(key);
		if(hashArray[index] == -1 || hashArray[index] == 0)
			hashArray[index] = key;
		else	{
			while(hashArray[index] != -1 && hashArray[index] != 0)
				index = (index + 1) % length;
			hashArray[index] = key;
		}
	}
	public int hashRemove(int key)	{
		boolean found = false;
		int index = hash(key);
		while (hashArray[index] != -1 && !found)	{
			if (hashArray[index] == key)
				found = true;
			else
				index = (index + 1) % length;
		}
		if (found)
			hashArray[index] = 0;
		else
			index = -1;	
	}
	
	
	HashTableLinearProbing table = new HashTableLinearProbing(7);
	
	
	
	
	------------------------------------------------------------
	Class rewrite: HashTbleChainingLinkedListBuckets.cpp
	
	#include <iostream>
	using namespace std;
	
	struct Node	{
		int data; 
		Node* next;
	};
	
	class LinkedList	{
		private:
			Node* head;
			Node* tail;
			
		public:
			LinkedList::LinkedList()	{
				head = NULL;
				tail = NULL;
			}
			
			LinkedList::LinkedList(Node *headNode	{
				head = headNode;
			}
			void LinkedList::listInsert(int num)	{
				Node* newNode = new Node;
				newNode->data = num;
				newNode->next = NULL;
				
				if(head == NULL)	{
					head = newNode;
					tail = newNode;
				}
				else{
						tail->next = newNode;
						tail = newNode;
				}
			}
			
			void LinkedList::listRemove(int num)	{
					Node* temp = head;
					while(temp != NULL)	{
						if(temp->data == num)
							head->next = temp->next;
						else if(temp->next == NULL)
							return;
						else	{
							if(temp->next != NULL && temp->next->data == num)
								temp->next = temp->next->next;
						}
						temp = temp->next;
					}
					void LinkedList::listPrint()	{
						Node* temp = head;
						while(temp != NULL)	{
							if (temp->next == NULL)
								cout << temp->data;
							else
								cout << temp->data << ',';
							temp = temp->next;
						}
					}
			};	//end linkedlist class
			
			class HashTable	{
				private:
					LinkedList* hashArray;
					int length;
				public:
					HashTable::HashTable(int tableLength)	{
						if (tableLength <= 0)
							tableLength = 11;
						hashArray = new LinkedList[tableLength];
						length = tableLength;
					}
					int HashTable::hash(int key)	{
						return key % length;
					}
					void HashTable::hashInsert(int key)	{
						int index = hash(key);
						hashArray[index].listInsert(key);
					}
					void hashTable::hashRemove(int key)	{
						int index = hash(key);
						hashArray[index].listRemove(key);
					}
					void HashTable::hashPrint()	{
						for (int i = 0; i < length; i++)	{
							cout << "Bucket: " << i + 1 << ": ";
							hashArray[i].listPrint();
							cout << " ";
						}
					}
			}; //End HashTable Class
					
		