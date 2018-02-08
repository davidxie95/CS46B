package CS46B_Midterm1;

/**
 * 
 * CompactDisc.
 * 
 * This class is a child class of Album. It represents an album that comes as a
 * CD.
 * 
 * You must inherit Album, implement the constructor, implement the Comparable
 * interface, and override toString.
 *
 */
public class CompactDisc extends Album implements Comparable<CompactDisc>
// YOUR CODE HERE
{
	private int inventoryNumber;

	/**
	 * Constructor.
	 * 
	 * Initialize the super class instance. set the inventoryNumber attribute.
	 * 
	 * @param artist
	 *            the album artist
	 * @param title
	 *            the album title
	 * @param price
	 *            the price of the CD
	 * @param tracks
	 *            the number of tracks
	 * @param inventoryNumber
	 *            the inventory identifier
	 */
	public CompactDisc(String artist, String title, double price, int tracks,
			int inventoryNumber) {
		super(artist, title, price, tracks);

		this.inventoryNumber = inventoryNumber;
	}

	/**
	 * Comparable.
	 * 
	 * You must implement the Comparable interface on objects of type
	 * CompactDisc. Compare objects based on the artist, then on the title.
	 * Compare each attribute alphabetically.
	 * 
	 */
	// YOUR CODE HERE

	@Override
	public int compareTo(CompactDisc o) {
		// TODO Auto-generated method stub
		if (super.getArtist() != o.getArtist())
			return super.getArtist().compareTo(o.getArtist());
		else
			return super.getTitle().compareTo(o.getTitle());

	}

	/**
	 * toString.
	 * 
	 * Return a String representation of this instance.
	 * 
	 * Example: CompactDisc[artist=ARTIST, title=TITLE,
	 * inventoryNumber=INVENTORYNUMBER]
	 */
	public String toString() {
		return "CompactDisc[artist=" + super.getArtist() + ", title="
				+ super.getTitle() + ", inventoryNumber=" + inventoryNumber
				+ "]";
	}
}
