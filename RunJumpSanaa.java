package arrays;
import java.util.Scanner;
public class RunJumpSanaa {

	public static void main(String[] args) {
		String[] name = {"Sanaa", "Yusra", "Sweta", "Amar", "Tilak", "Amna", "Parwana", "Jessica", "Anna", "Tracy", "Bryan"};
		int[] longjump = new int [11];
		int[] run = new int[11];
		int distance, dash;
		
		Scanner input = new Scanner (System.in);
		for (int i = 0; i < longjump.length; i++){
			System.out.print("Enter your name: ");
			name[i] = input.next();
			distance = longdistance(name, longjump);
			dash = time(name, run);
			System.out.print("Your distance for the long jump is: "+distance+" cm."+"\n");
			System.out.print("Your time for the 100m dash is: "+dash+"."+"\n");
			System.out.println();
		}
		fastest(name, run);
		longestDistance(name, longjump);
	}
	public static int longdistance (String[] name, int[] longjump){
		int distance = 0;
		for (int i = 0; i < longjump.length; i++){
			distance = (int)(Math.random()*401 + 300);
		}
		return distance;
	}
	public static int time (String[] name, int[] run){
		int time = 0;
		for (int i = 0; i < run.length; i++){
			time = (int)(Math.random()*22 + 14);
		}
		return time;
	}
	public static void fastest (String [] name, int [] run){
		int maxT = run[0];
		for (int i = 0; i < run.length; i++){
			if (run[i] > maxT){
				maxT = run[i];
			}
		}
		for (int i = 0; i < run.length; i++){
			if (run[i] == maxT){
				System.out.println(name[i]+".");
			}
		}
		
	}
	public static void longestDistance (String [] name, int [] longjump){
		int maxD = longjump[0];
		for (int i = 0; i < longjump.length; i++){
			if (longjump[i] > maxD){
				maxD = longjump[i];
			}
		}
	}
}
