/**
 * 
 */
package bangun_datar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Jeremy
 *
 */
public class Utama {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Luas dan Keliling Segitiga
		Segitiga segitiga = new Segitiga(2,2,3);
		
		//Luas dan Keliling Lingkaran
		Lingkaran lingkaran = new Lingkaran(3);

		//Luas dan Keliling Persegi
		Persegi persegi = new Persegi(4);
		
		//Luas dan Keliling Belah Ketupat
		BelahKetupat belahketupat = new BelahKetupat(6,7,8);
		
		System.out.println("------List Luas------");
		
		//BangunDatar[] listbangundatar ={segitiga,lingkaran,persegi,belahketupat};
		//for (int i = 0; i < listbangundatar.length; i++)
		//{
			//System.out.println(listbangundatar[i].getLuas());
		//}
		
		ArrayList<BangunDatar> listbd = new ArrayList<BangunDatar>();
		listbd.add(segitiga);
		listbd.add(persegi);
		listbd.add(lingkaran);
		listbd.add(belahketupat);
		
		for(BangunDatar bd:listbd) {
			System.out.println(bd.getLuas());
		}
	}
}


