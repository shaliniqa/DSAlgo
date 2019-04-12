import java.util.ArrayList;

public class AllPossibleArraySumEqualToK {
	public static void main(String args[])
	{
		int arr[]= {1, 2, 3, 4, 5, 6};
		PrintAll(arr,6,10,0,"",0);
	}
	
	public static void PrintAll(int num[], int n, int k, int sum, String out,int index)
	{
		if(sum==k)
		{
			System.out.println(out);
			return;
		}
		
		//System.out.println(out);
		if(index>=n)
		{
			return;
		}
		
		if(sum>k)
		{
			return;
		}
	/*	if(sum==k)
		{
			//System.out.println(out);
			return;
		}*/
		
		PrintAll(num,n,k,sum+num[index],out+" "+num[index],index+1);
			
		PrintAll(num,n,k,sum,out,index+1);

		
	}
}
