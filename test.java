import java.util.*;
class test
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		int a=rand.nextInt(50)+1;
		int x;
		do
		{
			System.out.print("Guess my number:-");
			x=sc.nextInt();
			if(x==a)
			{
				System.out.println("You Found my number!!");
				break;
			}
			else if(x>a)
			{
				System.out.println("Your Number is Greater than my number.\nTry again!!\n\n");
			}
			else
			{
				System.out.println("Your Number is less than my number.\nTry again!!\n\n");
			}
		}
		while(true);
	}
}