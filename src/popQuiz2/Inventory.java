package popQuiz2;

/**
 * Inventory
 * 
 * This class holds the inventory of a record store implemented as a linear
 * probing hash table.
 * 
 * A linear probing hash table does not use linked lists to resolve collisions.
 * 
 * A linear probing hash table attempts to add the new item at the position
 * indicated by the hashCode method. If that slot is filled, then it looks at
 * the next slot in the array until it finds a free slot. Then it adds the new
 * item in that free slot.
 * 
 * Example: 1. data[,,,,,,,,,,] 2. add(x) 3. data[,,,,x,,,,,] 4. add(y) 5. If x
 * and y collide, then y is added in the next free slot 6. data[,,,,x,y,,,] 7.
 * add(z) 8. If z does not collide, then it is added at the position indicated
 * by its hash code 9. data[,z,,,x,y,,,]
 *
 */
public class Inventory {
	private Album[] albums;
	private static int INITIAL_SIZE = 23;
	private int count;

	// do not add more instance variables

	public Inventory() {
		this.albums = new Album[INITIAL_SIZE];
		this.count = 0;
	}

	/**
	 * addAlbum
	 * 
	 * Add an album to the inventory.
	 * 
	 * You must use linear probing to get any credit.
	 * 
	 * Remember, linear probing adds the item at the first free slot AFTER the
	 * hashCode.
	 * 
	 * If there is no free slot before the end of the array, then you should
	 * loop back to the beginning.
	 * 
	 * Don't worry about rehashing or resizing the array.
	 * 
	 * DO NOT ALLOW DUPLICATE ALBUMS!
	 * 
	 * @param a
	 *            the album to add
	 */
	public void addAlbum(Album a) {

		while (a != null && albums[count] != a) {
			count++;
			albums[count] = a;

		}

	}

	/**
	 * contains
	 * 
	 * Return true if an Album is in inventory or false otherwise.
	 * 
	 * You must use linear probing to get any credit.
	 * 
	 * Remember, linear probing adds the item at the first free slot AFTER the
	 * hashCode.
	 * 
	 * If there is no free slot before the end of the array, then you should
	 * loop back to the beginning.
	 * 
	 * 
	 * @param a
	 *            the album to search for
	 * @return true if the album is in the hash table or false otherwise
	 */
	public boolean contains(Album a) {
		
		//try to re do it
		boolean found = false;
		for (int i = count; i < count; i--)
			if (albums[i].equals(a)) {
				found = true;
				break;
			}

		return found;
	}

	public int size() {
		return count;
	}

	public float getLoadFactor() {
		float result = 0;

		
		return result;
	}
	
}
