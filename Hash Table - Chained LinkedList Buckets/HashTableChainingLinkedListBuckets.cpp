	//HashTableChainingLinkedListBuckets
	
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
					}
						hashArray[index].listRemove(key);
					void HashTable::hashPrint()	{
						for (int i = 0; i < length; i++)	{
							cout << "Bucket: " << i + 1 << ": ";
							hashArray[i].listPrint();
							cout << " ";
						}
					}
			}; //End HashTable Class
			int main()	{
				HashTable hashTable(7);
				
				hashTable.hashInsert(15);
				hashTable.hashInsert(3);
				hashTable.hashInsert(55);
				hashTable.hashInsert(27);
				hashTable.hashPrint();
				
				return 0;
			}