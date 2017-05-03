import java.util.Scanner;

public class Driver {
	
	public static void main(String args[]){

		System.out.println("Enter the number of nodes:");
		Scanner in=new Scanner(System.in);
		int nodes=in.nextInt();
		//System.out.println("Enter the link probability:");
		double linkP=0.0;
		//System.out.println("Enter the k value:");
		//int k=in.nextInt();
		double rel;
		double change=0.05;
		while(linkP<=1){
			rel=Reliability.netkReliability(nodes,linkP);
			System.out.println("Reliability : "+rel+" for p value : "+linkP);
			linkP+=change;
		}
		linkP=1;
		rel=Reliability.netkReliability(nodes,linkP);
		System.out.println("Reliability : "+rel+" for p value : "+linkP);
		
		linkP=0.85;
		int k=0;
		
		double rel_p=Reliability.netkReliability(nodes,linkP);
		System.out.println("Reliability without k: "+rel_p+" for p value : "+linkP);
		
		System.out.println("Reliabilities with k for p value : "+linkP);
		int ran=10;
		while(k<=20){
			double[] temp=new double[ran];
			rel=0;
			for(int i=0;i<ran;i++){
				temp[i]=Reliability.altReliability(rel_p,nodes,linkP,k);
				rel+=temp[i];
			}
			rel=rel/ran;
			System.out.println("Reliability : "+rel+" for k value : "+k);
			k++;
		}

		in.close();
		
	}

}
