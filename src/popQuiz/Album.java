package popQuiz;

import java.util.ArrayList;

public class Album implements Comparable<Track> {
	private String artist;
	private String name;

	private ArrayList<Track> tracks;

	public Album(String artist, String name) {
		this.artist = artist;
		this.name = name;

		tracks = new ArrayList<Track>();
	}

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

	public void addTrack(Track t) {
		tracks.add(t);
	}

	public Track getTrackAt(int index) {
		return tracks.get(index);
	}

	/**
	 * Use selection sort to sort the tracks by name. Return a new, sorted
	 * ArrayList of tracks.
	 * 
	 * @return an ArrayList containing the tracks sorted by name, or null if no
	 *         tracks exist
	 */
	public ArrayList<Track> getTracksSortedByName() {

		int max, i, j;
		ArrayList<Track> temp = new ArrayList<Track>();
		for (i = 0; i < tracks.size() - 1; i++) {
			max = i;
			for (j = i + 1; j < tracks.size(); j++) {
				if (tracks.get(max).getName()
						.compareTo(tracks.get(j).getName()) > 0)
					max = j;
			}
			temp.add(tracks.get(i));
			tracks.set(i, tracks.get(max));
			tracks.set(max, temp.get(i));
		}
		return tracks;
	}

	/**
	 * Use binary search to find a track in the ArrayList. You must add and use
	 * a recursive helper method to properly implement binary search.
	 * 
	 * @param name
	 *            the track name for which to search
	 * @return the Track if found or null otherwise
	 */
	public Track findTrack(String theName) {

		return search(0, tracks.size() - 1, theName, tracks);
	}

	// helper method
	private static Track search(int low, int high, String name,
			ArrayList<Track> temp) {
		if (low <= high) {
			int mid = (low + high) / 2;

			if (temp.get(mid).getName() == name)

				return temp.get(mid);

			else if (temp.get(mid).getName().compareTo(name) < 0)
				return search(mid + 1, high, name, temp);

			else
				return search(low, mid - 1, name, temp);
		}
		return null;
	}

	@Override
	public int compareTo(Track o) {
		int temp = 0;
		for (int i = 0; i < tracks.size(); i++)
			temp = i;
		return tracks.get(temp).getName().compareTo(o.getName());
	}

}
