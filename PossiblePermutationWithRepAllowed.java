class PossiblePermutationWithRepAllowed
{
	public static void main (String[] args) throws java.lang.Exception
	{
		char s[]={'a','b','c','d'};
		int k=3;
		char out[]=new char[s.length];
		possiblePermutWithRepitionAllowed(s,k,out,0);
		
	}
    public static void possiblePermutWithRepitionAllowed(char s[], int k, char out[],int index)
    {
        //base case 
        if(index==k)
        {
            System.out.println(out);
            return;
        }
        //recursive case:
        for(int i=0;i<s.length;i++)
        {
            out[index]=s[i];
            possiblePermutWithRepitionAllowed(s,k,out,index+1);
        }
            
    }
}
