
public class Rat_maze {

	static int N = 4;
	
	static void printtrack(int[][] track)
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(track[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static boolean isSafe(int x, int y, int[][] arr)
	{
		return (x < N && y <N && arr[x][y]!=1);
	}
	static boolean solveMaze(int[][] arr)
	{
		int track[][] = new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
			{
				track[i][j]=-1;
			}
		int[] xMove = {1,0};
		int[] yMove = {0,1};
		
		if(!maze(0,0,arr,xMove,yMove,track)){
			System.out.println("No way out possible from the maze");
		}
		else {
			printtrack(track);
		}
		return true;
		
	}
	
	static boolean maze(int x, int y,int[][] arr,int[] xMove,int[] yMove,int[][] track)
	{
		int k,x_next,y_next;
		if(x==N && y==N )
		{
			return true;
		}
		if(x<N-1 && y<N-1 && arr[x][y+1]==1 && arr[x+1][y]==1)
		{
			return false;
		}
		for(k=0;k<2;k++)
		{
			x_next =  x+ xMove[k];
			y_next= y + yMove[k];
			
			if(isSafe(x_next,y_next,arr))
			{
				track[x_next][y_next] = 1;
				if(maze(x_next,y_next,arr,xMove,yMove,track))
				{
					return true;
				}
				else {
					track[x_next][y_next]=-1;
				}
			}
		}
		return false;
	}
	
	public static void main(String args[])
	{
		int[][] arr = {{1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {1, 1, 1, 1}};
		solveMaze(arr);
	}
}
