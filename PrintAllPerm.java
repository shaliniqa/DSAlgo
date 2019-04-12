
public class PrintAllPerm
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		String str="abc";
		PrintAll(str, "");
	}
	
	public static void PrintAll(String str, String ans)
	{
		//System.out.println("start");
		System.out.println(ans);
	    if(str.length()==0)
	    {
	        return;
	    }
	    for(int i=0;i<str.length();i++)
	    {
	        char cc=str.charAt(i);
	        String ros=str.substring(0,i)+str.substring(i+1);
	        PrintAll(ros, ans+cc);
	    }
	                                                                                                                                                                                                                                                                                                                                                                         
	}
}
