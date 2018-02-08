package hw06;

import java.io.File;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * This class encapsulates an album of music. It stores the artist, and the name
 * of the album, as well as a list of tracks.
 */
public class Album {
	private String artist;
	private String name;

	private LinkedList<Track> tracks;

	/**
	 * Constructor. Complete the constructor. Initialize the LinkedList.
	 * 
	 * @param artist
	 *            the album artist
	 * @param name
	 *            the name of the album
	 */
	public Album(String artist, String name) {
		this.artist = artist;
		this.name = name;

		// YOUR CODE HERE (construct the LinkedList)
		tracks = new LinkedList<>();
	}

	// accessors and mutators
	public String getArtist() {
		return artist;
	}

	public String getName() {
		return name;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Create a new album by reading it from a file. Return it.
	 * 
	 * Each data item will be on its own line. The first line will hold the
	 * artist. The second line will hold the name of the album. Each subsequent
	 * line will hold a track name.
	 * 
	 * Example: Radiohead Kid A Everything in Its Right Place Kid A The National
	 * Anthem How to Disappear Completely Treefingers Optimistic In Limbo
	 * Idioteque Morning Bell Motion Picture Soundtrack
	 * 
	 * If an exception occurs, print "An exception has occurred. Unable to load
	 * the album in filename!" where filename is replaced with the actual
	 * filename.
	 * 
	 * @param filename
	 *            the path to the file from which to load album information
	 * @return the album created from the file
	 */
	public static Album fromFile(String filename) {

		String artist = "";
		String album = "";

		try {
			Scanner in = new Scanner(new File(filename));
			artist = in.nextLine();
			album = in.nextLine();

			Album newAlbum = new Album(artist, album);

			while (in.hasNextLine()) {

				String track = in.nextLine();
				Track newTrack = new Track(artist, track);
				newAlbum.addTrack(newTrack);
			}
			in.close();
			return newAlbum;
		}

		catch (Exception e) {
			System.out.println("An exception has occurred."
					+ " Unable to load the album in" + filename + "!");

		}
		return null;
	}

	/**
	 * addTrack. Add a track to the LinkedList.
	 * 
	 * @param t
	 *            the track to add
	 */
	public void addTrack(Track t) {
		tracks.add(t);
	}

	/**
	 * addTrackAt. Insert a track into the LinkedList at the position indicated
	 * by index.
	 * 
	 * @param index
	 *            where to insert
	 * @param t
	 *            the track to insert
	 */
	public void addTrackAt(int index, Track t) {
		tracks.set(index, t);
	}

	/**
	 * removeTrackAt. Remove a track at a specific index.
	 * 
	 * @param index
	 *            the index at which to remove
	 */
	public void removeTrackAt(int index) {
		tracks.remove(index);
	}

	/**
	 * getTrackAt. Return the track at the given index.
	 * 
	 * @param index
	 *            the index at which to return
	 * @return
	 */
	public Track getTrackAt(int index) {
		return tracks.get(index);
	}

	/**
	 * printTrackList. Print a numbered list of tracks. YOU MUST USE A
	 * ListIterator TO GET FULL CREDIT!
	 * 
	 * Example output: 1. Sweet Tune 2. Great Track 3. Probably a cool song
	 */
	public void printTrackList() {
		ListIterator<Track> iterator = tracks.listIterator();
		int i = 1;

		while (iterator.hasNext()) {

			System.out.println(i + ". " + iterator.next().getName());
			i++;
		}

	}
}
