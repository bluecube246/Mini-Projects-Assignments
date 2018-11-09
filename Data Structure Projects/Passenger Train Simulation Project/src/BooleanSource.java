
public class BooleanSource {
	private double probability;

	public BooleanSource(double p) {
		if (p < 0.0 || p > 1.0)
			throw new IllegalArgumentException();
		probability = p;
	}

	public boolean occurs() {
		return (Math.random() < probability);
	}
}
