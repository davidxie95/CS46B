package hw06;

public class AlbumDemo {
	public static void main(String[] args) {
		Album a = Album.fromFile("KidA.txt");
		System.out.println(a.getArtist());
		System.out.println(a.getName());
		a.printTrackList();
	}
}
