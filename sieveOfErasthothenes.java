import java.util.Arrays;
import java.util.Scanner;


public class sieveOfErasthothenes {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int arr[]=new int[n];
		Arrays.fill(arr,1);
		
		for(int i=2;i<n;i+=2)
		{
			arr[i]=0;
		}
		arr[0]=0;
		arr[1]=1;
		
		for(int i=3;i<n;i+=2)
		{
			if(arr[i]==1)
			{
				for(int j=i*i; j<n; j+=2*i)
				{
					arr[j]=0;
				}
			}
		}
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]==1)
				System.out.println(i);
		}
		sc.close();
	}

}
