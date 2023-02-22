/**
 * 
 */

/**
 * @author Jeremy
 *
 */
public class nomer2 {
	public static void xstar(int x) {
		for (int i =0;i<x;i++) {
			for(int j=0;j<x;j++) {
				if(i==j||i+j==x-1) {					
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
