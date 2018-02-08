package hw06;

public class AlbumDemo2 {
	public static void main(String[] args) {
		Album b = Album.fromFile("SoundOfSilver.txt");
		System.out.println(b.getArtist());
		System.out.println(b.getName());
		b.printTrackList();
	}
}