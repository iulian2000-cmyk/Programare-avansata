public class Main {
	static int getTheSumOfDigits(int number) 
	{
	   int sumDigits=0;
	   while(number!=0) 
	   {
		   sumDigits=sumDigits+number%10;
		   number=number/10;
	   }
	   return sumDigits;
	}
	static int numberOfDigits(int n) 
	{
		int count = 0;
		while(n!=0) 
		{
			n=n/10;
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
	   System.out.println("Hello World");
	   String [] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
	   int n = (int) (Math.random() * 1_000_000);
	   n = n*3;
	   n=n+Integer.parseInt("10101",2);
	   n=n+Integer.parseInt("FF",16);
	   n = n*6;
	   System.out.println("The number is : " + n );
	   System.out.println("The sum of digits of " + getTheSumOfDigits(n));
	   int SumDigits = getTheSumOfDigits(n);
	   int result = 0;
	   while(numberOfDigits(SumDigits)!=1) 
	   {  
		  result = result + getTheSumOfDigits(SumDigits); 
		  SumDigits = getTheSumOfDigits(SumDigits);
	   }
	   System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
 	}
}
