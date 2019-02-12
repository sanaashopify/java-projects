package methods;
import java.util.Scanner;
public class SumBetween {
	public static void main(String[] args) {
		int n1, n2, n3, n4;
		int sum1 = 0, sum2 = 0, sum3 = 0;
		Scanner input = new Scanner (System.in);
		System.out.print("Enter 4 numbers: ");
		n1 = input.nextInt();
		n2 = input.nextInt();
		n3 = input.nextInt();
		n4 = input.nextInt();
		input.close();
		
		sum1 = sumOfNumbersBetween(n1, n2);
		sum2 = sumOfNumbersBetween(n2, n3);
		sum3 = sumOfNumbersBetween(n3, n4);
		if (sum1 >= sum2 && sum1 >= sum3){
			System.out.print("The biggest sum is: "+sum1);
		}else if (sum2 >= sum1 && sum2 >= sum3){
			System.out.print("The biggest sum is: "+sum2);
		}else{
			System.out.print("The biggest sum is: "+sum3);
		}
	}
	/*calculate the sum of numbers between num1 and num2
	 * pre: two integer parameters, start and end numbers
	 * post: return int sum between num1 and num2
	 */
	public static int sumOfNumbersBetween (int num1, int num2){
		int sum = 0;
		int stotal = 0;
		if (num1 < num2){
			for (int i = num1; i <= num2; i++){
				sum = sum + i;
			}
		} else {
			for (int j = num2; j <= num1; j++){
				sum = sum + j;
			}
		}
		System.out.println("Sum: "+sum);
		return sum;
	}

}
