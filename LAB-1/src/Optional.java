import java.io.*; 
import java.util.*; 
import java.util.Queue; 
import java.util.concurrent.*;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class Optional {
	public static void printMatrices(int mat[][]) 
    { 
        for (int[] row : mat) 
            System.out.println(Arrays.toString(row));
		System.out.println("\n");
    }
    // Metoda de a testa daca un graf este sau nu conex , folosind matrice de adiacenta .
	public static boolean isConnected(int[][] adjacency_matrix, int number_of_nodes) {
        int visited[] = new int[number_of_nodes ];
        for(int row=0; row< number_of_nodes; row++)
        {
            for(int col=0; col < number_of_nodes; col++){
                if(adjacency_matrix[row][col]==1 && visited[row]==0)
                {
                    visited[row] = 1;
                }
            }
        }
        boolean connected = false;
        //System.out.println(Arrays.toString(visited));
        for (int vertex = 1; vertex < number_of_nodes; vertex++)
        {
            if (visited[vertex] == 1) 
            {
                connected = true;
            } else
            {
                connected = false;
                break;
            }
        }
        return connected;
	}
    // Metodele connectedComponents si DFSUtil sunt folosite pentru a determina componentele conexe ale grafului . 
    public static void DFSUtil(int v, boolean[] visited,int [][] matrice,int n)
    {
        visited[v] = true;
        System.out.print(v + " ");
        for(int i = 0 ;i<n;i++)
        {
            if((matrice[v][i] == 1) && (!visited[i]))
            {
                DFSUtil(i,visited,matrice,n);
            }
        }
    }
    public static void connectedComponents(int V,int [][] matrice)
    {
        boolean[] visited = new boolean[V];
        for(int i = 0;i<V;i++)
        {
            visited[i] = false;
        }
        System.out.println("\n Componente conexe : \n");
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                DFSUtil(v, visited,matrice,V);
                System.out.println();
            }
        }
    }
    // Conform a ceea ce am invatat la Algoritmica grafurilor , un arbore partial se poate obtine dintr-o parcurgere DFS/BFS a grafului . 
    public static void DFS(int x, int [][] matrice,int dimensiunea,int[] viz,ArrayList<Integer>ordine)
    {
        viz[x]=1;
        ordine.add(x);
        for(int i=0;i<dimensiunea;i++)
        {
           if (matrice[x][i]==1 && viz[i]==0){
               DFS(i,matrice,dimensiunea,viz,ordine);
           }  
        }
    }
	public static void main(String[] args) {
        // n-ul e un numar primit ca argument de la linia de comanda doar ca valoarea acestuia va fi intr-un string ci nu intr-un integer ,drept pentru care ar trebui sa folosim o conversie din string in int . 
	    try
         {
            long beginTime = System.nanoTime();
            int n = Integer.parseInt(args[0]);
            if( n%2 == 0) { 
			    System.exit(0);
            }
            int [][] matriceDeAdiacenta = new int [n][n]; 
		    // Generarea matricei de adiacenta . 
            for(int i=0;i<n;i++){
			  for(int j=0;j<n;j++){
				if(i!=j)
				{
				  matriceDeAdiacenta[i][j]=(int)Math.round(Math.random());
                }else{
					matriceDeAdiacenta[i][j]=0;
			    	}
			  } 
		    }
            // Logica e foarte simpla in urmatoarele 2 for-uri , daca avem ca a[i][j]=1 asta ar presupune ca nodul i e vecin  cu nodul j si invers => a[j][i]=1 totodata
            for(int i=0;i<n;i++){
			   for(int j=0;j<n;j++){
                if(matriceDeAdiacenta[i][j] == 1){
                    matriceDeAdiacenta[j][i] = 1;
                    }
			    }
		    }
		    System.out.println("\n Matrice de adiacenta \n");
            if(n < 30000 ){
               printMatrices(matriceDeAdiacenta);
            }
            boolean Conex = isConnected(matriceDeAdiacenta,n);
            if(!Conex){
                connectedComponents(n,matriceDeAdiacenta);     
            }else{
                int [] vizitat = new int [n];
                ArrayList<Integer> arbore = new ArrayList<Integer>();
                for(int i = 0;i<n;i++){
                    vizitat[i] = 0;
                }
                System.out.println("\n Arbore partial \n");
                DFS(0,matriceDeAdiacenta,n,vizitat,arbore);
                System.out.println(arbore);
                System.out.println("\n");    
		    
		long endTime   = System.nanoTime();
                long totalTime = endTime - beginTime;
                System.out.println("\n Time of execution:" + totalTime + "\n");
            }
        }catch (NumberFormatException x){
                System.out.printf("Argument invalid \n");
        }
    }
} 
