package GraphBasics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


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

	public boolean hasEdge(String vname1, String vname2)
	{
		Vertex vtx1=vtces.get(vname1);
		Vertex vtx2=vtces.get(vname2);

		if(vtx1.nbrs.containsKey(vname2) && vtx2.nbrs.containsKey(vname1))
		{
			return true;
		}
		return false;

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
		Vertex vertex1=vtces.get(vname1);
		Vertex vertex2=vtces.get(vname2);

		vertex1.nbrs.remove(vname2);
		vertex2.nbrs.remove(vname1);
	}

	public void removeVertex(String vname)
	{
		if(!containsVertex(vname))
		{
			System.out.println("Vertex Not Present");
			return;
		}

		Vertex vtx=vtces.get(vname);
		Set<String> vtxKey= vtx.nbrs.keySet();

		for(String key: vtxKey)
		{
			Vertex curr=vtces.get(key);
			curr.nbrs.remove(vname);
		}
		vtces.remove(vname);
	}
	public boolean hasPath(String vname1, String vname2)
	{
		HashSet<String> processed=new HashSet<String>();
		processed.add("");
		return this.drive_hasPath(vname1,vname2,processed);
	}

	public boolean drive_hasPath(String vname1, String vname2,HashSet<String> processed)
	{
		processed.add(vname1);

		if(hasEdge(vname1,vname2))
		{
			return true;
		}
		Vertex vtx1=vtces.get(vname1);
		Set<String> vtx1Key=vtx1.nbrs.keySet();

		for(String key:vtx1Key)
		{
			if(!processed.contains(vname1) && drive_hasPath(key, vname2,processed))
			{
				//processed.add(key);
				return true;

			}
		}
		return false;
	}

	public void display()
	{
		Set<String> vertex=vtces.keySet();
		for(String vtx:vertex)
		{
			Vertex curr=vtces.get(vtx);
			System.out.println(vtx+"---->"+curr.nbrs);
		}
	}

	public boolean BFS(String src, String dst)
	{
		class Pair{
			String vname;
			String psf;

			Pair(String vname,String psf)
			{
				this.vname=vname;
				this.psf=psf;
			}
		}

		HashSet<String> processed=new HashSet<String>();

		//Vertex vtx=vtces.get(src);
		Pair sp=new Pair(src, src);

		LinkedList<Pair> queue=new LinkedList<Pair>();
		queue.addLast(sp);


		while(!queue.isEmpty())
		{
			Pair curr=queue.removeFirst();
			Vertex currVtx=vtces.get(curr.vname);
			if(processed.contains(curr.vname))
			{
				continue;
			}
			processed.add(curr.vname);
			if(hasEdge(curr.vname,dst))
			{
				System.out.println(curr.psf+dst);
				return true;
			}			
			Set<String> keys=currVtx.nbrs.keySet();

			for(String key:keys)
			{
				if(!processed.contains(key))
				{
					queue.addLast(new Pair(key, curr.psf+key));
				}
			}
		}
		return false;
	}
	public void DFSUtil(Stack<String> stack, Set<String> proccessed)
	{
		String vtx=stack.pop();
		//if(!proccessed.contains(vtx))
		//{
			//LinkedList<String> stack=new LinkedList<String>();
			
			proccessed.add(vtx);
			System.out.println(vtx+" ");

			Vertex currVtx=vtces.get(vtx);
			for(String nbr: currVtx.nbrs.keySet())
			{
				if(!proccessed.contains(nbr))
				{
					stack.push(nbr);
					DFSUtil(stack,proccessed);
				}
			}
		//}
	}

	public void DFS()
	{
		Set<String> proccessed=new HashSet<String>();
		Stack<String> stack=new Stack<>();
		for(String crtVtx: vtces.keySet())
		{
			if(!proccessed.contains(crtVtx))
			{
				stack.push(crtVtx);
				DFSUtil(stack, proccessed);
			}

		}

	}
	
	public void DFTUtil(Stack<Pair<String, String>>stack, Set<String> processed)
	{
		Pair<String, String> crtPair=stack.pop();
		System.out.println(crtPair.first()+"------>"+crtPair.second());
		String curr= crtPair.first();
		//System.out.println(currVtx);
		Vertex currVtx=vtces.get(curr);
		
		
		for(String nbr: currVtx.nbrs.keySet() )
		{
			if(!processed.contains(nbr))
			{
				processed.add(nbr);
				stack.push(new Pair<String, String>(nbr, crtPair.second()+nbr));
				DFTUtil(stack,processed);
			}
		}
	}
	
	public void DFT()
	{
		Stack<Pair<String, String>> stack=new Stack<>();
		HashSet<String> processed=new HashSet<String>();
		for(String vtx: vtces.keySet())
		{
			if(!processed.contains(vtx))
			{
				processed.add(vtx);
				stack.push(new Pair<String,String>(vtx,vtx));
				DFTUtil(stack, processed);
			}
		}
	} 

	public void BFT()
	{
		class Pair{
			String vname;
			String psf;

			Pair(String vname,String psf)
			{
				this.vname=vname;
				this.psf=psf;
			}
		}

		HashSet<String> processed=new HashSet<String>();
		LinkedList<Pair> queue=new LinkedList<Pair>();
		Pair sp;
		for(String current: vtces.keySet())
		{
			if(!processed.contains(current))
			{
				sp=new Pair(current, current);
				queue.addLast(sp);

				//Vertex vtx=vtces.get(src);	
				while(!queue.isEmpty())
				{
					Pair curr=queue.removeFirst();
					Vertex currVtx=vtces.get(curr.vname);
					if(processed.contains(curr.vname))
					{
						continue;
					}
					processed.add(curr.vname);
					System.out.println(curr.psf);

					Set<String> keys=currVtx.nbrs.keySet();

					for(String key:keys)
					{
						if(!processed.contains(key))
						{
							queue.addLast(new Pair(key, curr.psf+key));
						}
					}
				}
			}
		}
	}

	public boolean isConnected()
	{
		class Pair{
			String vname;
			String psf;

			Pair(String vname,String psf)
			{
				this.vname=vname;
				this.psf=psf;
			}
		}

		HashSet<String> processed=new HashSet<String>();
		LinkedList<Pair> queue=new LinkedList<Pair>();
		Pair sp;
		int flag=0;
		for(String current: vtces.keySet())
		{
			if(!processed.contains(current))
			{
				sp=new Pair(current, current);
				queue.addLast(sp);

				flag++;

				//Vertex vtx=vtces.get(src);	
				while(!queue.isEmpty())
				{
					Pair curr=queue.removeFirst();
					Vertex currVtx=vtces.get(curr.vname);
					if(processed.contains(curr.vname))
					{
						continue;
					}
					processed.add(curr.vname);
					System.out.println(curr.psf);

					Set<String> keys=currVtx.nbrs.keySet();

					for(String key:keys)
					{
						if(!processed.contains(key))
						{
							queue.addLast(new Pair(key, curr.psf+key));
						}
					}
				}

			}
		}
		if(flag>1)
		{
			return true;
		}
		return false;
	}

	public boolean isCyclic()
	{
		class Pair{
			String vname;
			String psf;

			Pair(String vname,String psf)
			{
				this.vname=vname;
				this.psf=psf;
			}
		}

		HashSet<String> processed=new HashSet<String>();
		LinkedList<Pair> queue=new LinkedList<Pair>();
		Pair sp;
		for(String current: vtces.keySet())
		{
			if(!processed.contains(current))
			{
				sp=new Pair(current, current);
				queue.addLast(sp);


				//Vertex vtx=vtces.get(src);	
				while(!queue.isEmpty())
				{
					Pair curr=queue.removeFirst();
					Vertex currVtx=vtces.get(curr.vname);
					if(processed.contains(curr.vname))
					{
						return true;
					}
					processed.add(curr.vname);
					System.out.println(curr.psf);

					Set<String> keys=currVtx.nbrs.keySet();

					for(String key:keys)
					{
						if(!processed.contains(key))
						{
							queue.addLast(new Pair(key, curr.psf+key));
						}
					}
				}
			}
		}
		return false;
	}


	public boolean isTree()
	{
		return(this.isCyclic() && this.isConnected());
	}


	public ArrayList<ArrayList<String>> ConnectedComponents()
	{
		class Pair{
			String vname;
			String psf;

			Pair(String vname,String psf)
			{
				this.vname=vname;
				this.psf=psf;
			}
		}
		ArrayList<ArrayList<String>> ans=new ArrayList<ArrayList<String>>();

		HashSet<String> processed=new HashSet<String>();
		LinkedList<Pair> queue=new LinkedList<Pair>();
		Pair sp;
		for(String current: vtces.keySet())
		{
			ArrayList<String> subAns;
			if(!processed.contains(current))
			{
				sp=new Pair(current, current);
				queue.addLast(sp);
				subAns=new ArrayList<String>();


				//Vertex vtx=vtces.get(src);	
				while(!queue.isEmpty())
				{
					Pair curr=queue.removeFirst();

					Vertex currVtx=vtces.get(curr.vname);
					if(processed.contains(curr.vname))
					{
						continue;
					}
					subAns.add(curr.vname);
					processed.add(curr.vname);
					System.out.println(curr.psf);

					Set<String> keys=currVtx.nbrs.keySet();

					for(String key:keys)
					{
						if(!processed.contains(key))
						{
							queue.addLast(new Pair(key, curr.psf+key));
						}
					}
				}
				ans.add(subAns);
			}

		}
		return ans;
	}
}

