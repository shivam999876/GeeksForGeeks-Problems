**Method 1 :**
  
//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String s) {
	// Your code here
	int num = 0;
	for(int i = 0; i < s.length(); i++){
	    if(i == 0 && s.charAt(i) == '-')
	    continue;
	    if(s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9){
	        num = num*10 + (s.charAt(i)-'0');
	    }
	    else
	    return -1;
	}
	if(s.charAt(0)=='-')
	num*=-1;
	return num;
    }
}


**Method 2:**

//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String s) {
	// Your code here
	int n = s.length();
	int sign = 1;
	int i = 0;
	if(s.charAt(0)=='-'){
	    sign = -1; i++;
	}
	int num = 0;
	for(int j = i; j < n; j++){
	    char ch = s.charAt(j);
	    if(ch >= '0' && ch <= '9')
	    num = num * 10 + ch - '0';
	    else
	    return -1;
	}
	return sign * num;
    }
}
