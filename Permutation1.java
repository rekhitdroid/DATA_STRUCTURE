import java.lang.*;
import java.util.*;
public class Permutation1{
			static int c=0;
			static void  RemOneChar(String str){
				String sum="",recur="";
				for(int i=0;i<str.length();i++){
					sum="";
					for(int j=i;j<str.length();j++){
						if(j==i){
						continue;
					}
					sum+=str.charAt(j);
				}
				System.out.println(sum+str.charAt(i));	
			  }
			}	
			String swap(String s ,int i,int j){
				char a[] =s.toCharArray();
				char temp= a[i];
				a[i]=a[j];
				a[j]=temp;
				return String.valueOf(a);
			}
			void permutation(String a,int l,int r){
				if(l==r){
					System.out.println("  When l==r: String="+a+" l="+l+" r="+r);
					c++;
				}else{
					for(int i=l;i<=r;i++){
						a=swap(a,l,i);
						System.out.println();
						System.out.println("  here1:"+i+" "+l+" r: "+r+" String1 :"+a);
						permutation(a,l+1,r);
					System.out.println();
						a=swap(a,l,i);
					System.out.println("  here2:"+i+" "+l+" r: "+r+ " String2:"+a);
					}
				}
				
			}
		public static void main(String [] args){
			Scanner s = new Scanner(System.in);
			Permutation1 p = new Permutation1();
			System.out.print("Enter the String :");
			String s1= s.next();
			int n = s1.length();
		//	RemOneChar(s1);
			p.permutation(s1,0,n-1);
			System.out.println("Count :"+c);
			
		}
}