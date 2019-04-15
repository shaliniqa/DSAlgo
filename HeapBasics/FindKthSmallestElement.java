package HeapBasics;

public class FindKthSmallestElement {
	public static void main(String args[])
	{
		int arr[]= {2,6,7,9,1,4};
		FindKthSmallestElement obj=new FindKthSmallestElement();
		obj.kth_smallest(arr,6,3);
		
	}
	 public void  kth_smallest(int arr[],int n, int k)
	 {
		 Heap heap=new Heap();
		 
		 for(int i=0;i<n;i++)
		 {
			 heap.add(arr[i]);
		 }
//		 heap.display();
//		 heap.remove();
//		 heap.display();
//		 heap.remove();
//		 heap.display();
//		 heap.remove();
//		 heap.display();
		 for(int i=0;i<k;i++)
		 {
			 System.out.println(heap.remove());
		 }
	 }
	
}
