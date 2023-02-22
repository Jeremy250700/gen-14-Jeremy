/**
 * 
 */

/**
 * @author Jeremy
 *
 */
public class nomer4 {
	public static void xnum(int x) {
		int diagonal1 = -1;
		int diagonal2= 0;
		for (int i =0;i<x;i++) {
			for(int j=0;j<x;j++) {
				if(i==j) {
					diagonal1 +=2;
					System.out.print(diagonal1);
				}				
				else if (i+j==x-1) {
					diagonal2 = Math.abs(i -j - x);
					System.out.print(diagonal2);
				}
				else {
					System.out.print(" ");
				}
				
			}

			System.out.println();
		}
	}
}
