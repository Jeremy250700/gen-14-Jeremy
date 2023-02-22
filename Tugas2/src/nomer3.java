/**
 * 
 */

/**
 * @author Jeremy
 *
 */
public class nomer3 {
	public static void allnum(int x) {
		int angka = -1;
		for (int i =0;i<x;i++) {
			for(int j=0;j<x;j++) {
				angka ++;
				System.out.print(angka);
			}
			angka = -1;
			System.out.println();
		}
	}
}
