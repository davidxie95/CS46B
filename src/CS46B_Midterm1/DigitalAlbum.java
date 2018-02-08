package CS46B_Midterm1;

import java.util.Comparator;

/**
 * 
 * DigitalAlbum.
 * 
 * This class is a child class of Album. It represents an album that is
 * delivered as a digital download.
 * 
 * You must inherit Album, implement the constructor, implement the Comparable
 * interface, and override toString.
 * 
 * For this class you must also implement the getTrackCountComparator method,
 * which returns an instance of a Comparator that compares albums based on the
 * number of tracks.
 *
 */
public class DigitalAlbum extends Album implements Comparable<DigitalAlbum> {

	private String link;

	public String getLink() {
		return this.link;
	}

	/**
	 * Constructor.
	 * 
	 * Initialize the super class instance. set the link attribute.
	 * 
	 * @param artist
	 *            the album artist
	 * @param title
	 *            the album title
	 * @param price
	 *            the price of the CD
	 * @param tracks
	 *            the number of tracks
	 * @param link
	 *            the download link
	 */
	public DigitalAlbum(String artist, String title, double price, int tracks,
			String link) {
		super(artist, title, price, tracks);

		this.link = link;
	}

	/**
	 * Comparable.
	 * 
	 * You must implement the Comparable interface on objects of type
	 * DigitalAlbum. Compare objects based on the artist, then on the title,
	 * then on link. Compare each attribute alphabetically.
	 * 
	 */
	// YOUR CODE HERE
	@Override
	public int compareTo(DigitalAlbum o) {
		if (super.getArtist() != o.getArtist())
			return super.getArtist().compareTo(o.getArtist());
		else if (super.getTitle() != o.getTitle())
			return super.getTitle().compareTo(o.getTitle());
		else
			return link.compareTo(o.getLink());
	}

	/**
	 * toString.
	 * 
	 * Return a String representation of this instance.
	 * 
	 * Example: DigitalAlbum[artist=ARTIST, title=TITLE, link=LINK]
	 */
	public String toString() {
		return "DigitalAlbum[artist=" + super.getArtist() + ", title="
				+ super.getTitle() + ", link=" + link + "]";
	}

	/**
	 * getTrackCountComparator.
	 * 
	 * You must create an inner class that implements Comparator on
	 * DigitalAlbum, then return an instance of that class.
	 * 
	 * You must compare albums based on the number of tracks. The album with
	 * more tracks should come first.
	 * 
	 * @return
	 */
	public Comparator<DigitalAlbum> getTrackCountComparator() {

		return new TrackCountComparator();
	}

	class TrackCountComparator implements Comparator<DigitalAlbum> {
		@Override
		public int compare(DigitalAlbum o1, DigitalAlbum o2) {

			if (o1.getTrackCount() < o2.getTrackCount())
				return o1.compareTo(o2);

			return o2.compareTo(o1);

		}

	}
}
