/**
 * This class represents a delivery object that has a source destination and instructions. 
 * @author Hyuk Joon Kwon
 * ID: 109822712
 * Recitation: 14
 * CSE 214
 *
 */
public class Delivery {
	private String source;
	private String dest;
	private String instruction;
	
	
	/**
	 * This constructor sets the source dest instruction to the parameters given
	 * @param source
	 * The source of the Delivery
	 * @param dest
	 * The destination of the Delivery
	 * @param instruction
	 * Additional instuctions of the delivery
	 */
	public Delivery(String source, String dest, String instruction) {
		this.source = source;
		this.dest = dest;
		this.instruction = instruction;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getinstruction() {
		return instruction;
	}
	public void setinstruction(String instruction) {
		this.instruction = instruction;
	}
	
	
}
