package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuilder sb = new StringBuilder();
		int i=0;
		int j=0;
		while ((line=bf.readLine())!=null && !line.trim().equals("")){ // i=test cases
			//list1= prices of the books
			//j= the amount of the sum
			i=Integer.parseInt(line);
			String[] list=new String[i];
			line=bf.readLine();
			list=line.split(" ");
			line=bf.readLine();
			j=Integer.parseInt(line);
			line=bf.readLine();
			int[] list2= new int [i];
			for (int k = 0; k < list.length; k++) {
				list2[k]=Integer.parseInt(list[k]);   
			}
			Arrays.sort(list2);

			//list2: numbers sorted 


			int min=0;
			int max=1000001;
			int f=0;
			int y=0;
			int x=0;
			int lowl;
			int upperl;
			int midl;
			boolean find=false;
			
			for (int k2 = 0; k2 < list2.length; k2++) {
				lowl=0;	
				upperl=list2.length-1;
				
				while ((lowl<=upperl) && (find==false)) {
					midl = (int)((lowl + upperl)/2);
					
					f=list2[k2]+list2[midl];
					if (f==j){
						x=list2[k2];
						y=list2[midl];
						if (Math.abs(min-max)>Math.abs(x-y)){
							min=x;
							max=y;
						}
					}
					else if(f<j) {
						lowl=midl+1;
					}
					else {
						upperl=midl-1;
					}
				}
				find=false;
			}

			if (max!=1000001){
				sb.append("Peter should buy books whose prices are" +" " + min + " " + "and" +" " + max +"."+"\n\n" );
			}
			else {
				sb.append("Peter should buy books whose prices are" +" " + 0 + " " + "and" +" " + 0+"."+"\n\n");

			}

		}
		System.out.println(sb.substring(0,sb.length()-2));
	}  

}
