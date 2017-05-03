import java.util.Random;

public class Reliability {

	public static int[] revEdgeCalc(int[] edges){
		for(int i=0;i<edges.length;i++){
			if(edges[i]==0){
				edges[i]=1;
			}
			else{
				edges[i]=0;
			}
		}
		return edges;
	}
	public static double altReliability(double rel,int nodes,double linkP,int k){
		int edge=(nodes*(nodes-1))/2;
		for(int i=0;i<k;i++){
			Random r=new Random();
			int low=0;
			int high=(int) Math.pow(2,edge)-1;
			int ran=r.nextInt(high-low)+low;
			
			int[] edges=edgeCalc(edge,ran);
			int[][] adjacency=adjCalc(nodes,edges);
			double temp=0;
			if(IsConnected.bfs(adjacency,0,nodes)){
				temp=relCalc(edges,linkP);
				//temp=relCalc(adjacency,linkP,nodes);
			}
			rel-=temp;
			edges=revEdgeCalc(edges);
			adjacency=adjCalc(nodes,edges);
			if(IsConnected.bfs(adjacency,0,nodes)){
				temp=relCalc(edges,linkP);
				//temp=relCalc(adjacency,linkP,nodes);
			}
			rel+=temp;
		}
		return rel;
	}
	public static double netkReliability(int nodes, double linkP){
		double netrel=0;
		int edge=(nodes*(nodes-1))/2;//undirected graph
		int bin=(int) Math.pow(2,edge);
		int i=0;
		for(int number=0;number<bin;number++){
			int[] edges=edgeCalc(edge,number);
			int[][] adjacency=adjCalc(nodes,edges);
			if(IsConnected.bfs(adjacency,0,nodes)){
				netrel+=relCalc(edges,linkP);
				//netrel+=relCalc(adjacency,linkP,nodes);
			}
		}
		
		
		//int rel=2;
		
		return netrel;
	}
	public static double relCalc(int[] edges, double linkP){
		double p=1;
		for(int i=0;i<edges.length;i++){
			if(edges[i]==1){
				p=p*linkP;
			}
			else{
				double t=1-linkP;
				p=p*t;
			}
			
		}
		return p;
		
	}
	public static int[] edgeCalc(int edge,int number){
		int[] edges=new int[edge];
		int bin=(int) Math.pow(2,edge);
		int i=0;
		//int number=101;
		//for(int number=0;number<bin;number++){
			String binaryString = Integer.toBinaryString(number);
			//System.out.println("binary "+binaryString);
			//System.out.println(binaryString.length());
			int j=binaryString.length()-1;

			for(i=edge-1;i>=0 && j>=0;i--){
				if(binaryString.charAt(j--)=='1')
					edges[i]=1;
				else
					edges[i]=0;
				//System.out.println(edges[i]+" "+i);
			}
			while(i>=0){
				edges[i]=0;
				//System.out.println(edges[i]+" "+i);
				i--;
			}
		//}
		
		return edges;
	}
	
	public static int[][] adjCalc(int nodes,int[] edges){
		int i=0;
		int[][] adjacency=new int[nodes][nodes];
		for(int p=0;p<nodes;p++){
			for(int q=0;q<nodes;q++){
				adjacency[p][q]=0;
			}
		}
		for(int p=0;p<nodes-1;p++){
			for(int q=p+1;q<nodes;q++){
				adjacency[p][q]=edges[i++];
				adjacency[q][p]=adjacency[p][q];
			}
		}
		/*for(int p=0;p<nodes;p++){
			for(int q=0;q<nodes;q++){
				System.out.print(adjacency[p][q]+" ");
			}
			System.out.println();
		}*/
		return adjacency;
	}
	
	
	
	
	public static int permutation(int n){
		int perm=1;
		
		
		return perm;
	}
}
