package longest_common_subsequence;

public class LongestSubsequence {
	
	public static  int LesLength(char []x,char[]y,int[][]b){
		int m = x.length - 1;
		int n = y.length - 1;
		int [][]c = new int[m+1][n+1];
		for(int i = 0;i <= m;i++) c[i][0] = 0;
		for(int j = 0;j <= n;j++) c[0][j] = 0;
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(x[i]==y[j]){
					c[i][j]=c[i-1][j-1]+1;
					b[i][j]=1;
				}else if(c[i-1][j]>=c[i][j-1]){
					c[i][j]=c[i-1][j];
					b[i][j]=2;
				}else{
					c[i][j]=c[i][j-1];
					b[i][j]=3;
				}
			}
		}
		return c[m][n];
	}
	
	public static  void les(int i,int j,char[]x,int [][]b){
		if(i==0||j==0){
			return;
		}
		if(b[i][j]==1){
			les(i-1,j-1,x,b);
			System.out.println(x[i]);
		}else if(b[i][j]==2){
			les(i-1,j,x,b);
		}else{
			les(i,j-1,x,b);
		}
		
	}
	public static void main(String[] args) {
		char x[]={' ','A','B','C','B','D','A','B'};
		char y[]={' ','B','D','C','A','B','A'};
		int[][] b;
		b=new int[8][7];
		LesLength(x,y,b);
		les(x.length-1,y.length-1,x,b);
	}

}
