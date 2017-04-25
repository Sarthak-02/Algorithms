import java.util.*;
public class Knight_tour {
	static int N =8;
	static boolean isSafe(int x,int y,int[][] sol)
	{
		return (x>=0 && x<N && y>=0 && y<N && sol[x][y]==-1);
	}

	
	static void printSol(int[][] sol)
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}
	static boolean solveKT()
	{
		int sol[][] = new int[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				sol[i][j]=-1;
			}
		}
		
		int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
 
        sol[0][0]=0;
        if(!solKt(0,0,1,sol,xMove,yMove))
        {
        	System.out.println("Solution doesnt exist");
        	return false;
        }
        else
        {
        	printSol(sol);
        	
        }
        return true;
	}
	static boolean solKt(int x,int y,int movei,int[][] sol,int[] xMove,int[] yMove)
	{
		int k ;int x_next;int y_next;
		if(movei == N*N)
		{
			return true;
		}
		for(k=0;k<8;k++)
		{
			x_next = x+xMove[k];
			y_next = y+yMove[k];
			if(isSafe(x_next,y_next,sol))
			{
				sol[x_next][y_next]=movei;
				if(solKt(x_next,y_next,movei+1,sol,xMove,yMove))
				{
					return true ;
				}
				else
				{
					sol[x_next][y_next]=-1;
				}
			}
			
		}
		return false;
		
	}
	
	public static void main(String args[])
	{
		solveKT();
	}
}
