package HeapBasics;

public class FindKthSmallestElement {
	public static void main(String args[])
	{
		int arr[]= {2,6,7,9,3};
		FindKthSmallestElement obj=new FindKthSmallestElement();
		obj.kth_smallest(arr,5,1);
		
	}
	 public void  kth_smallest(int arr[],int n, int k)
	 {
		 Heap heap=new Heap();
		 
		 for(int i=0;i<n;i++)
		 {
			 heap.add(arr[i]);
		 }
		 for(int i=0;i<k;i++)
		 {
			 System.out.println(heap.extractMin());
			 heap.remove();
		 }
	 }
	
}
