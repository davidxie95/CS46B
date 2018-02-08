package hw08;

//FORBIDDEN java.util.Hash

/**
 * This class contains the methods for the HashSet class. The HashSet class
 * should be implemented as an hash table with a linked list at each slot in the
 * array.
 * 
 * This file is simply a container for some static methods. You can write these
 * as the same as if they were in the class itself (using the given
 * definitions).
 * 
 * You may not add instance variables to any classes in this assignment. You may
 * not use the data structures in the jcf to complete this assignment.
 */
public class HashSet_Methods {
	/**
	 * Add an item to the hash table. Data is the hash table. NewData is the
	 * Object to add to the table.
	 * 
	 * @param NewData
	 *            the object to add to the table
	 * @param Data
	 *            the hash table
	 */
	public static void add(Object NewData, Node[] Data) {
		int hashcode = NewData.hashCode() % Data.length;
		while (Data[hashcode] != null && hashcode < Data.length)
			hashcode++;
		if (hashcode >= Data.length)
			resize(Data);
		Node n = new Node(NewData, null);
		Data[hashcode] = n;
	}

	/**
	 * Determine if the hash table in Data contains the Object SearchData.
	 * 
	 * @param SearchData
	 *            the item to be found
	 * @param Data
	 *            the haystack to search
	 * @return int index where the item is found or -1 otherwise
	 */
	public static int contains(Object SearchData, Node[] Data) {
		int hash = 0;
		hash = SearchData.hashCode() % Data.length;
		if (Data[hash] != null && Data[hash].Data.equals(SearchData))
			return hash;

		else {
			for (int i = hash; i < Data.length; i++) {
				if (Data[i] == null)
					return -1;
				else if (Data[i].Data.equals(SearchData))
					return 1;
			}
		}
		return -1;
	}

	/**
	 * If the given item is in the hash table, then remove it.
	 * 
	 * @param RemoveData
	 * @param Data
	 */
	public static void remove(Object RemoveData, Node[] Data) {
		int index = contains(RemoveData, Data);
		if (contains(RemoveData, Data) != -1) {
			Data[index] = null;
		}
	}

	/**
	 * Calculate the load on the hash table. In this case, the load is the
	 * number of items in the hash table divided by the number of slots in the
	 * array. This count includes items in linked lists.
	 * 
	 * @param Data
	 *            the array to search
	 * @return the calculated load
	 */
	public static double calculateLoad(Node[] Data) {
		int count = 0;
		double result = 0;
		for (int i = 0; i < Data.length; i++) {
			if (Data[i] != null)
				count++;
		}
		result = (double) count / (double) Data.length;
		return result;
	}

	/**
	 * Create a new hash table that is twice the size of the old one. Reallocate
	 * all elements TO NEW POSITIONS in the new hash table.
	 * 
	 * @param Data
	 *            the hash table to reallocate
	 */
	public static Node[] resize(Node[] Data) {
		Node[] hashTable = new Node[Data.length * 2];
		
		for (int i = 0; i < Data.length; i++) {
			if (Data[i] != null) {
				add(Data[i], hashTable);
			}
		}
		return hashTable;
	}
}
