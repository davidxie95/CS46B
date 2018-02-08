package hw08;

public class Weapon {
	private double Damage;
	private double AttackSpeed;
	private double MissChance;

	public Weapon(double NewDamage, double NewAttackSpeed, double NewMissChance) {
		Damage = NewDamage;
		AttackSpeed = NewAttackSpeed;
		MissChance = NewMissChance;
	}

	@Override
	public int hashCode() {
		return (int) (2 * (Damage + 2) + 3 * (AttackSpeed + 2) + 4 * (MissChance + 2));
	}

	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == (obj.hashCode());
	}

}
