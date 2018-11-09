/**
 * This class is used in storing the data for individual network nodes
 * 
 * Recitation: 14 Stony Brook ID: 109822712 Course: CSE 214 Homework: 5
 * 
 * @author Hyuk Joon Kwon
 */
public class NetworkNode {
	private String name;
	private boolean isNintendo = false;
	private boolean isBroken = false;
	final int maxChildren = 9;
	public int index; 
	public int count;
	private NetworkNode parent;
	private NetworkNode[] children = new NetworkNode[maxChildren];
	
	/**
	 * When removing an array due to the cut method. This method moves shifts everything one block to prevent holes
	 * @param cut
	 */
	public void arrayClean(int cut) {
		//System.out.print(count);
		//System.out.print(cut);
		for(int i = cut; i < count-1; i++) {
			//System.out.print(i);
			children[i] = children[i+1];
			children[i].setIndex(i);
		}
		children[count-1] = null;
		count--;
//		System.out.print(count);
//		for(int i = 0; i < count; i++) {
//			System.out.println(children[i].getName() + " " + children[i].getIndex());
//		}
	}
	
	/**
	 * This method is used to get the current number of children in the children array
	 * @return
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * This method is used to add one everytime a child array increases
	 */
	public void addCount() {
		count++;
	}
	
	/**
	 * This method is used to subtract everytime a child array decreases
	 */
	public void subCount() {
		count--;
	}
	
	/**
	 * This method is used to get the current index of the networknode. 
	 * @return
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * This method is used to set the index of the current node. 
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
//	public NetworkNode() {
//		parent = new NetworkNode();
//		children = new NetworkNode[maxChildren];
//	}
	
	/**
	 * This method is used to get the name of the NetworkNode
	 * @return the string value of the name of the current node. 
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method is used to set the name of the current NetworkNode
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method is used to check if its a nintendo or not
	 * @return true if it is a nintendo false if it isn't 
	 */
	public boolean isNintendo() {
		return isNintendo;
	}
	
	/**
	 * This method is used to tell weather itf its a nintendo or not
	 * @param isNintendo true or false depending on whether its a nintendo
	 */
	public void setNintendo(boolean isNintendo) {
		this.isNintendo = isNintendo;
	}
	
	/**
	 * returns wheather the nintendo is broken or not
	 * @return true if the its a broken default is false
	 */
	public boolean isBroken() {
		return isBroken;
	}
	
	/**
	 * This sets the current status of the nintendo weather its fiexed or broken
	 * @param isBroken true of the nintendo is broken
	 */
	public void setBroken(boolean isBroken) {
		this.isBroken = isBroken;
	}
	
	/**
	 * gets the parent of the current node
	 * @return the parent of the current node
	 */
	public NetworkNode getParent() {
		return parent;
	}
	
	/**
	 * This method sets the parent of the current node
	 * @param parent
	 */
	public void setParent(NetworkNode parent) {
		this.parent = parent;
	}
	
	/**
	 * This method gets the children array of the current networkNode
	 * @return the array of NetworkNodes containing childre
	 */
	public NetworkNode[] getChildren() {
		return children;
	}
	
	/**
	 * This method sets the children array 
	 * @param children the array that is to be set to children 
	 */
	public void setChildren(NetworkNode[] children) {
		this.children = children;
	}

}
