
public class Vertex {
	public int index;
	public int count;
	public boolean visited = false;	
	public boolean discovered = false;
	public Vertex[] children = new Vertex[100];
	
	public Vertex(int index, int count) {
		this.index = index;
		this.count = count;  
	}
	
	public void print() {
		for(int i = 0; i < count; i++) {
			System.out.print(children[i].getIndex() + " ");
		}
	}
	
	public void bfsprint() {
		for(int i = 0; i < count; i++) {
			if(children[i].isVisited() == false) {
				System.out.print(children[i].getIndex() + " ");
				children[i].setVisited(true);
			}
		}
	}
	
	public boolean isDiscovered() {
		return discovered;
	}

	public void setDiscovered(boolean discovered) {
		this.discovered = discovered;
	}

	public void addchild(Vertex vertex) {
		children[count] = vertex;
		count++;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getCount() {
		return count;
	}
	
	public void addCount() {
		count++;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Vertex[] getChildren() {
		return children;
	}

	public void setChildren(Vertex[] children) {
		this.children = children;
	}


}
