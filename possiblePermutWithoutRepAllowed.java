
import java.util.*;

class possiblePermutWithoutRepAllowed
{
	public static void main (String[] args) throws java.lang.Exception
	{
		char s[]={'a','b'};
		int k=1;
		possiblePermutWithRepitionAllowed(s,k-1,0);
		
	}
    public static void possiblePermutWithRepitionAllowed(char s[], int k,int index)
    {
        //base case 
        if(index==k)
        {
            System.out.println(s);
            return;
        }
        //recursive case
        for(int i=0;i<s.length;i++)
        {
            //swap(s[index],s[i]);
            char temp=s[index];
            s[index]=s[i];
            s[i]=temp;
            possiblePermutWithRepitionAllowed(s,k,index+1);
            //swap(s[index],s[i]);
            char temp2=s[index];
            s[index]=s[i];
            s[i]=temp2;
        }
    }
}
