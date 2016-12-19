public class HashTableOpenLinearProbing	{
	private int[] hashArray;
	private int length;
	private static final int DEFAULT_SIZE = 11; //must be prime
	
	public HashTableOpenLinearProbing()	{
		this(DEFAULT_SIZE);
	}
	
	public HashTableOpenLinearProbing(int tableLength)	{
		if (tableLength <= 0)
			tableLength = 11;
	
		hashArray = new int[tableLength];
		
		for (int i = 0; i < tableLength; i++)
			hashArray[i] = -1; //-1 means never used
		length = tableLength;
	}
	public int hash(int key)	{
		return key % length;
	}
	
	public void hashInsert(int key)	{
		if ((hashArray[index] == -1) || (hashArray[index] == 0))
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
		while ((hashArray[index] != -1) && !found)	{
			if (hashArray[index] == key)
				found = true;
			else
				index = (index + 1) % length;
		}
		if (found)
			hashArray[index] = 0;
		else
			index = -1;
		return index;
	}
	
	public void hashPrint()	{
		for (int index = 0; index < hashArray.length; index++)	{
			System.out.print("Bucket " + index + ": ");
			if (hashArray[index] == -1)	//why so complicated?
				System.out.print("-1 ");
			else if (hashArray[index] == 0)
				System.out.print("0 ");
			else
				System.out.print(hashArray[index] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args)	{
		HashTableOpenLinearProbing hashTable = new HashTableOpenLinearProbing(7);
		
		hashTable.hashInsert(15);
		hashTable.hashPrint();
	}
}
		
		