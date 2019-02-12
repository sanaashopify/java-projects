package methods;
/* Sanaa Syed
 * Renovation
 * 04/30/2018
 * This program outputs the length of a baseboard for a room, the painting cost of a wall, 
 * painting cost of a room with a door and the number of tiles needed for a rectangular bathroom floor. 
 */
import java.util.Scanner;
public class SanaaRenovation {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		double width, length, baseboard;
		double width2, height;
		double cost, cost2, finalcost, finalcost2;
		double width3, height2, widthD, heightD;
		double bwidth, blength, twidth, tlength;
		double numtiles;
		
		System.out.print("Enter the length of the room: ");
		length = input.nextDouble();
		System.out.print("Enter the width of the room: ");
		width = input.nextDouble();
		baseboard = baseboard (width, length);
		
		System.out.println(baseboard+" is the length of the baseboard needed for all walls of a rectangular room.");
		System.out.println("");
		
		
		System.out.print("Enter the width of a rectangular wall in feet: ");
		width2 = input.nextDouble();
		System.out.print("Enter the height of the wall in feet: ");
		height = input.nextDouble();
		System.out.print("Enter the cost per square foot: ");
		cost = input.nextDouble();
		finalcost = paintingCost(width2, height, cost);
		
		System.out.println("$"+finalcost+" is the cost of painting the rectangular wall.");
		System.out.println("");
		
		
		System.out.print("Enter the width of a rectangular wall in feet: ");
		width3 = input.nextDouble();
		System.out.print("Enter the height of the wall in feet: ");
		height2 = input.nextDouble();
		System.out.print("Enter the cost per square foot: ");
		cost2 = input.nextDouble();
		System.out.print("Enter the width of the door: ");
		widthD = input.nextDouble();
		System.out.print("Enter the height of the door: ");
		heightD = input.nextDouble();
		finalcost2 = paintingCost(width3, height2, cost2, widthD, heightD);
		
		System.out.println("$"+finalcost2+" is the cost of painting the rectangular wall with the door.");
		System.out.println("");
		
		
		System.out.print("Enter the the width of the rectangular bathroom floor: ");
		bwidth = input.nextDouble();
		System.out.print("Enter the length of the rectangular bathroom floor: ");
		blength = input.nextDouble();
		System.out.print("Enter the width of one bathroom tile: ");
		twidth = input.nextDouble();
		System.out.print("Enter the length of one bathroom tile: ");
		tlength = input.nextDouble();
		numtiles = numTiles(bwidth, blength, twidth, tlength);
		System.out.println("The number of tiles needed for a rectangular bathroom floor is: "+numtiles+"."+"");
		System.out.println("");
		
	}
	/*Calculates and returns the length of the baseboard needed for all walls of the rectangular room
	 * pre: two integer parameters, width and length
	 * post: returns length of baseboard
	 */
	public static double baseboard(double width, double length){
		double baseboard = (width*2)+(length*2);
		return baseboard;
	}
	/*Calculates and returns the painting cost of painting a rectangular wall
	 * pre: two integer parameters, height and width, one double parameter, cost
	 * post: returns cost of painting the rectangular wall
	 */
	public static double paintingCost (double width, double height, double cost){
		cost = (width * height)*cost;
		return cost;
	}
	/*Calculates and returns the painting cost of painting a rectangular wall with a door
	 * pre: four integer parameters, height and width of the wall, height and width or the door, one double parameter, cost
	 * post: returns cost of painting the rectangular wall
	 */
	public static double paintingCost (double width, double height, double cost, double widthD, double heightD){
		cost = ((width * height)-(widthD*heightD))*cost;
		return cost;
	}
	/*Calculates returns the number of tiles needed for a rectangular bathroom floor
	 * pre: four integer parameters, width and length of the bathroom, length and width of the tiles
	 * post: returns cost of painting the rectangular wall
	 */
	public static double numTiles (double lengthb, double widthb, double lengtht, double widtht){
		double tiles, area;
		area = lengthb * widthb;
		tiles = Math.round(area/(widtht*lengtht));
		return tiles;
	}
}
