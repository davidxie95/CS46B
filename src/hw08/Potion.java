package hw08;

public class Potion {
	private double Size;
	private int Type; // 0, 1, 2, 3 ... etc. A flag value.

	public Potion(double NewSize, int NewType) {
		Size = NewSize;
		Type = NewType;
	}

	@Override
	public int hashCode() {
		return (int) (Size + 2) + Type;
	}

	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == (obj.hashCode());
	}

}
