import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Find {
	public int vertex[];
	public int mina[];
	int vertices;
	int edges;
	int minband = Integer.MAX_VALUE;
	public int answer[] = new int[vertices];
	public Pair pair[];
	public BufferedReader buffer;
	public Pattern p;
	public int edgecounter;
	public boolean check;
	
	public void Readfromfile(String file) throws Exception {
		File target = new File(file);
		FileReader reader = new FileReader(target);
		buffer = new BufferedReader(reader);

		String line;

		vertices = Integer.parseInt(buffer.readLine());
		edges = Integer.parseInt(buffer.readLine());
		vertex = new int[vertices];
		pair = new Pair[edges];

//		for (int i = 0; i < vertices; i++) {
//			vertex[i] = new Vertex(i + 1, 0);
//			//System.out.print(vertex[i].getIndex() + " ");
//		}
		
		System.out.println("Filename: " + file);
		System.out.println();
		System.out.println("There are " + edges + " edges and " + vertices + " vertices");
		System.out.println();
		
		setEdge(buffer);
		
		int a[] = new int[vertices];
		int k = 0;
		backtrack(a,k);
		
		//System.out.println();
		
		System.out.println("Minimum set is " + minband);
		print(mina);
	}
	
	public void backtrack(int a[], int k) throws Exception {
		if(k == vertices) //We have a solution
			processEdge(a.clone());
		else {
			int[] c = getCandidates(a , k);
			k = k + 1;
			for(int i = 0; i < c.length; i++) {
				a[k-1] = c[i];
				check = tempcheck(a.clone(),k);
				//System.out.println(check);
				if(check)
					backtrack(a.clone(),k);
			}
				
		}
			
	}
	
	public boolean tempcheck(int g[],int k) throws Exception {
		//int tempcheck = -1;
		//System.out.print("tempcheck " + k + ": ");
		//System.out.println("manual: " + g[0] + " " + g[1] + " " + g[2]);
		//print(g);
		for(int i = 0; i < pair.length; i++) { //traverse through edges
			int start = pair[i].getFrom();
			int finish = pair[i].getTo();
			int dist1 = findIndexcheck(g,start-1,k);
			int dist2 = findIndexcheck(g,finish-1,k);
			if(dist1 != -1 && dist2 != -1) {
				int diff = Math.abs(dist1-dist2);
				//System.out.print(diff + " ");
				if(diff > minband) {
					//System.out.println();
					return false;
				}
//				if(diff > tempcheck) {
//					tempcheck = diff;
//					System.out.print("New tempband");
//				}
			}
		}
		return true;
	}
	
	public int findIndexcheck(int a[], int element,int k) throws Exception {
		for(int i = 0; i < k; i++) {
			if(a[i] == element)
				return i;
		}
		//System.out.println("Not found");
		//throw new Exception();
		return -1;
	}
	
	public int[] getCandidates(int a[], int k) { //This works If there is a problem its probably k value
		int count = 0;
		int[] c = new int[vertices-k];
		boolean in_perm[] = new boolean[vertices];
		for(int j = 0; j < vertices; j++) {
			in_perm[j] = false;
		}
		for(int i = 0; i < k; i++) {
			in_perm[a[i]] = true;
		}
		for(int l = 0; l < vertices; l++) {
			if(in_perm[l] == false) {
				c[count] = l;
				count++;
			}
		}
		return c;
	}
	
	public void processEdge(int a[]) throws Exception {
		int tempband = -1;
		//print(a);
		for(int i = 0; i < pair.length; i++) {
			int start = pair[i].getFrom();
			int finish = pair[i].getTo();
			int dist1 = findIndex(a,start-1);
			int dist2 = findIndex(a,finish-1);
			int diff = Math.abs(dist1-dist2);
			//System.out.print(diff + " ");
			if(diff > minband) {
				//System.out.println();
				return;
			}
			if(diff > tempband) {
				tempband = diff;
				//System.out.print("New tempband");
			}
			//System.out.println(dist1 + " " + dist2);
			//print(a);
		}
		
		//System.out.println();
		
		if(minband > tempband) {
			//System.out.println("minband has changed");
			mina = a.clone();
			minband = tempband;
		}
		
	}
	
	public int findIndex(int a[], int element) throws Exception {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == element)
				return i;
		}
		//System.out.println("Not found");
		//throw new Exception();
		return -1;
	}
	
	public void print(int a[]) {
		for(int i = 0; i < a.length; i++) {
			System.out.print((a[i]+1) + " ");
		}
		System.out.println();
	}
	
	public void setEdge(BufferedReader buffer) throws IOException {
		edgecounter = 0;
		String read;
		while ((read = buffer.readLine()) != null) {
			//System.out.println(read);
			//String[] sep = read.split("   ");
			p = Pattern.compile("(\\d+)    (\\d+)");
			Matcher m = p.matcher(read);
			m.find();
			int vertice1 = Integer.parseInt(m.group(1));
			int vertice2 = Integer.parseInt(m.group(2));
			// System.out.println(vertice1 + " " + vertice2);
			
			pair[edgecounter] = new Pair(vertice1, vertice2);
			edgecounter++;
			// vertex[0].print();
		}
		
//		for(int i = 0; i < pair.length; i++) {
//			System.out.println(pair[i].toString());
//		}

	}
	
}
