import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tree {

	public int edges;
	public int vertices;
	public Vertex vertex[];
	public String bfs = "";
	Queue<Vertex> bfsq = new LinkedList<>();
	int i = 0;
	int group = 1;

	public Tree readfromFile(String file) throws IOException {
		
		group = 1;
		i = 0;
		File target = new File(file);
		FileReader reader = new FileReader(target);
		BufferedReader buffer = new BufferedReader(reader);
		Pattern p = Pattern.compile("(\\d+) (\\d+)");

		String line;

		edges = Integer.parseInt(buffer.readLine());
		vertices = Integer.parseInt(buffer.readLine());
		vertex = new Vertex[vertices];

		for (int i = 0; i < vertices; i++) {
			vertex[i] = new Vertex(i + 1, 0);
			//System.out.print(vertex[i].getIndex() + " ");
		}
		
		System.out.println("Filename: " + file);
		System.out.println();
		System.out.println("There are " + edges + " edges and " + vertices + " vertices");
		System.out.println();
		System.out.println("Adjacency list");
		System.out.println();

		while ((line = buffer.readLine()) != null) {
			System.out.println(line);
			Matcher m = p.matcher(line);
			m.find();
			int vertice1 = Integer.parseInt(m.group(1));
			int vertice2 = Integer.parseInt(m.group(2));
			// System.out.println(vertice1 + " " + vertice2);

			vertex[vertice1 - 1].addchild(vertex[vertice2 - 1]);
			vertex[vertice2 - 1].addchild(vertex[vertice1 - 1]);

			// vertex[0].print();
		}

		for (int i = 0; i < vertices; i++) {
			System.out.print("Vertice " + (i + 1) + ": ");
			for (int j = 0; j < vertex[i].getCount(); j++) {
				vertex[i].print();
				break;
			}
			System.out.println();
		}

		return null;

	}

	public void bfs() {
		System.out.print("Group " + group + ": ");
		group++;
		Vertex current;
		bfsq.add(vertex[i]);
		while(!bfsq.isEmpty()) {
			current = bfsq.remove();
			if(current.isVisited() == false) {
				System.out.print(current.getIndex() + " ");
				current.setVisited(true);
			}
			for(int j = 0; j < current.getCount(); j++) {
				if(vertex[current.getChildren()[j].getIndex()-1].isDiscovered() == false)
					bfsq.add(vertex[current.getChildren()[j].getIndex()-1]);
			}
			
			current.setDiscovered(true);
			//System.out.println(current.getIndex() + " " + current.isDiscovered());
			//print();
			//System.out.println(current.getIndex() + " process complete");
			
		}
		
		System.out.println();
		
		for(int k = 0; k < vertex.length; k++) {
			if(vertex[k].isDiscovered() == false) {
				//System.out.println("Status: " + k + " " + vertex[k].isDiscovered());
				i = k;
				bfs();
			}						
		}
				
	}
	
	public void print() {
		for(int k = 0; k < vertex.length; k++) {
				System.out.println("Status: " + k + " " + vertex[k].isDiscovered());
		}
	}

	
	
	
	
}
