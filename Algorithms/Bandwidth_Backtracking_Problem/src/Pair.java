
public class Pair {
	public int to;
	public int from;
	
	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public Pair(int to, int from) {
		this.to= to;
		this.from = from;
	}
	
	public String toString() {
		return to + " " + from;
		
	}
}
