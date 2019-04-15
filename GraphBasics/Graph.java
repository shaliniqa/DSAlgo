package GraphBasics;

import java.util.HashMap;
import java.util.Set;


public class Graph {

	private class Vertex{
		HashMap<String, Integer> nbrs=new HashMap<>();
	}

	HashMap <String, Vertex> vtces;

	public Graph(){
		vtces=new HashMap<>();
	}

	public int numVertex()
	{
		return this.vtces.size();
	}

	public boolean containsVertex(String vname)
	{
		return this.vtces.containsKey(vname);
	}

	public void addVertex(String vname)
	{
		Vertex vtx=new Vertex();
		vtces.put(vname, vtx);
	}

	public int numOfEdges()
	{
		Set<String> vtcesKey=vtces.keySet();
		int twiceNumOfEdges=0;
		for(String eachVtces: vtcesKey)
		{
			Vertex currVtx=vtces.get(eachVtces);
			twiceNumOfEdges+=currVtx.nbrs.size();
		}
		return twiceNumOfEdges/2;
	}

	public void addEdge(String vname1, String vname2, int cost)
	{
		Vertex vertex1=vtces.get(vname1);
		Vertex vertex2=vtces.get(vname2);
		
		vertex1.nbrs.put(vname2,cost);
		vertex2.nbrs.put(vname1,cost);
	}

	public void removeEdge(String vname1, String vname2)
	{
		
	}
}

