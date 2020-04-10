package beautifulDayExample;
/*Sample Input
20 23 6
Sample Output
2
*/
import java.util.Scanner;

public class BeautifulDayExample {
	
void beautifulDay(int start,int end,int number)
{int i=0;
int qua=0;
for(i=start;i<=end;i++)
{
int n=i,rev=0,diff;
while(n!=0)
{
	rev=rev*10;
	rev=rev+n%10;
	n=n/10;
}
	diff=rev-i;
	if(diff%number==0)
	{qua++;
		System.out.println(i+" is beautiful day");
	}
}
System.out.println("number of beautiful days="+qua);
}






public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the starting date of range");
	int s=sc.nextInt();
	System.out.println("enter the ending date o range");
	int e=sc.nextInt();
	System.out.println("enter the number to divide");
	int n=sc.nextInt();
	BeautifulDayExample obj=new BeautifulDayExample();
	obj.beautifulDay(s, e, n);
	
}
}
