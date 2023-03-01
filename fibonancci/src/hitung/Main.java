/**
 * 
 */
package hitung;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeremy
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static List<Integer>hasil_nomer_1(int n){
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		for (int i=2;i<n;i++) {
				int angka_pertama=list.get(i-2);
				int angka_kedua = list.get(i-1);
				list.add(angka_pertama+angka_kedua);
		}
		return(list);
	}
	
	public static List<Integer>hasil_nomer_2(int n){
		List<Integer> list = new ArrayList<>();
		for (int i =0;i<n/2+1;i++) { //loop bagian depan
			list.add(i+1);
		}
	
		
		for (int i=n/2;i>0;i--) { //loop baigan belakang
			list.add(i);
		}
		
		return list;

		
	}
	
	public static void hasil_nomer_3(int n){
		List<Integer> list = new ArrayList<>();
		list.add(1);//data index ke 0
		list.add(1);//data index ke 1
		for (int i=2;i<=n/2;i++) {//loop fibonancci depan
				int angka_pertama=list.get(i-2);
				int angka_kedua = list.get(i-1);
				list.add(angka_pertama+angka_kedua);
		}
		for (int i=n/2;i>0;i--) {// loop fibonancci belakang
			list.add(list.get(i-1));
		}
		
		System.out.println(list);// print array list
		
		for (int i=0;i<n;i++) {//loop untuk print X
			for (int j=0;j<n;j++) {
				if (i==j||i+j==n-1) {
					System.out.print(+list.get(j)+" ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		for(int i=0;i<n;i++) {
			System.out.print(hasil_nomer_1(n).get(i)+" ");
		}
		System.out.println();
		
		int x = 9;
		for(int i=0;i<x;i++) {
			System.out.print(hasil_nomer_2(x).get(i)+" ");
		}
		System.out.println();
		
		hasil_nomer_3(9);

	}

}
