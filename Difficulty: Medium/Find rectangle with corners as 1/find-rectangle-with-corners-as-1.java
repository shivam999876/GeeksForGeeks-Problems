public class Solution { 
	static boolean ValidCorner(int matrix[][]) 
	{ 
	    int m = matrix.length;
	    int n = matrix[0].length;
	    
	    for(int i=0; i<m; i++)
	    {
	        for(int j=0; j<n; j++)
	        {
	            if(matrix[i][j]==1)
	            {
	                int r = i;
	                int c = j;
	                
	                for(int k=j+1; k<n; k++)
	                {
	                    if(matrix[r][k]==1)
	                    {
	                        for(int p=r+1; p<m; p++){
	                            if(matrix[p][c]==1 && matrix[p][k]==1){
	                                return true;
	                            }
	                        }
	                    }
	                }
	            }
	            
	        }
	    }
	    return false;
	}
}