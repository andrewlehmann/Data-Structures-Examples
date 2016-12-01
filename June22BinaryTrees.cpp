Binary Trees

A complete binary tree is full on it's next-to-last level.
	-leaves on last level filled from left to right
	number of nodes is equal to 2^(number of levels)
	
	
	Binary Tree interface
		public void setTree (T rootdata);
		public void setTree(T rootdata, BinaryTreeInterface < T > leftTree, BinaryTreeInterface < T > rightTree);
		