package hw09;

//FORBIDDEN java.util

/**
 * This class encapsulates a basic music library. It uses a binary search tree
 * to store albums. It's like a TreeMap. The key into the tree is a String, the
 * name of the album. The value is the actual album itself.
 * 
 * You must implement a binary search tree in order to get any credit for this
 * homework. You may not use data structures from the jcf to complete this
 * class. You may not add additional instance variables to this class.
 */
public class MusicLibrary {
	AlbumNode root;

	/**
	 * Constructor.
	 */
	public MusicLibrary() {
		root = null;
	}

	/**
	 * addAlbum. Add an album to the tree. Use a recursive helper method. The
	 * albums in the tree should be ordered based on the name of the album, NOT
	 * the artist.
	 * 
	 * @param a
	 *            the AlbumNode to add
	 */
	public void addAlbum(AlbumNode a) {
		if (root == null)
			root = a;
		else
			addAlbumHelper(a, root);
	}

	private static void addAlbumHelper(AlbumNode a, AlbumNode tree) {
		int compare = a.getName().compareTo(tree.getName());
		if (compare < 0) {
			if (tree.left == null)
				tree.left = a;
			else
				addAlbumHelper(a, tree.left);
		}

		else {
			if (tree.right == null)
				tree.right = a;
			else
				addAlbumHelper(a, tree.right);
		}
	}

	/**
	 * getAlbum. Return an Album from the tree if it exists, or null otherwise.
	 * Use a recursive helper method.
	 * 
	 * @param albumName
	 *            the name of the album to return
	 * @return an Album or null
	 */
	public AlbumNode getAlbum(String albumName) {
		return getAlbumHelper(albumName, root);
	}

	private static AlbumNode getAlbumHelper(String albumName, AlbumNode root) {
		int compare = albumName.compareTo(root.getName());

		if (compare == 0)
			return root;
		// left side
		else if (compare < 0) {
			if (root.left == null)
				return null;
			else
				return getAlbumHelper(albumName, root.left);
		}

		// right side
		else {
			if (root.right == null)
				return null;
			else
				return getAlbumHelper(albumName, root.right);
		}
	}

	/**
	 * count. Return the size of the library. Use a recursive helper method.
	 * 
	 * @return an int
	 */
	public int count() {
		return countHelper(root);
	}

	private static int countHelper(AlbumNode tree) {
		int count = 0;
		if (tree != null) {
			count += countHelper(tree.left);
			count += countHelper(tree.right);
			count++;
		}
		return count;
	}

	/**
	 * printInOrder. Print the list of albums in the MusicLibrary in order based
	 * on name. Print each album on its own line. Use a recursive helper method.
	 * Use the toString method in the AlbumNode class to print each album.
	 */
	public void printInOrder() {
		printInOrder(root);
	}

	private static void printInOrder(AlbumNode tree) {
		if (tree != null) {
			printInOrder(tree.left);
			System.out.println(tree);
			printInOrder(tree.right);
		}
	}

	/**
	 * printInReverseOrder. Print the list of albums in the MusicLibrary in
	 * reverse order based on name. Use a recursive helper method.
	 */
	public void printInReverseOrder() {
		printInReverseOrder(root);
	}

	private static void printInReverseOrder(AlbumNode tree) {
		if (tree != null) {
			printInReverseOrder(tree.right);
			System.out.println(tree);
			printInReverseOrder(tree.left);
		}
	}
}
