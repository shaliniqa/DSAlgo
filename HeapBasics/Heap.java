package HeapBasics;

import java.util.*;

public class Heap {
	
	ArrayList<Integer> data=new ArrayList<Integer>();
	
	public void add(int item)
	{
		data.add(item);
		upheapify(data.size()-1);
	}
	private void upheapify(int ci)
	{
		int pi=(ci-1)/2;
		if(data.get(ci)<data.get(pi))
		{
			swap(pi, ci);	
			upheapify(pi);
		}
		
	}
	private void swap(int i, int j)
	{
		int i_data=data.get(i);
		int j_data=data.get(j);
		
		data.set(i,j_data);
		data.set(j,i_data);
	}
	
	public int remove()
	{
		//swap o and last element
		swap(0,this.data.size()-1);
		//remove the last element
		int r=this.data.get(this.data.size()-1);
		
		downheapify(0);
		return r;
	}
	private void downheapify(int pi)
	{
		int lci=2*pi+1;
		int rci=2*pi+1;
		int mini=pi;
		
		if(lci<this.data.size() && data.get(lci)<data.get(mini))
		{
			mini=lci;
		}
		if(rci<this.data.size() && data.get(rci)<data.get(mini))
		{
			mini=rci;
		}
		if(mini!=pi)
		{
			swap(mini,pi);
			downheapify(mini);
		}
	}
	public int extractMin()
	{
		return this.data.get(0);
	}
	
}
