/**
 * 
 */
package prodemy;

import prodemy.Barang;

/**
 * @author Jeremy
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void jawaban_Nomer_6(String kalimat) {
		int a = 0,i=0,u=0,e=0,o=0; //nilai huruf vokal diset ke 0 semua
		
		for (int x =0;x<kalimat.length();x++) { //loop semua char yang ada di kalimat
			if (kalimat.charAt(x)=='a') {// jika char index tersebut adalah a
				a++;// nilai a bertambah 1
			}
			else if(kalimat.charAt(x)=='i') {// jika char index tersebut adalah i
				i++;// nilai i bertambah 1
			}
			else if (kalimat.charAt(x)=='u') {// jika char index tersebut adalah u
				u++;// nilai u bertambah 1
			}
			else if (kalimat.charAt(x)=='e') {// jika char index tersebut adalah e
				e++;// nilai e bertambah 1
			}
			else if (kalimat.charAt(x)=='o') { //jika char index tersebut adalah o
				o++; //nilai o bertambah 1
			}
		}
		System.out.println("a ="+a);//print total a
		System.out.println("i ="+i);//print total i
		System.out.println("u ="+u);//print total u
		System.out.println("e ="+e);//print total e
		System.out.println("o ="+o);//print total o
	}
	
	public static void jawaban_Nomer_7(int uang) {
		
		Barang[] daftarBarang = new Barang[4]; //array daftar barang
		Barang b1 = new Barang("Oreo",6000); // barang pertama
		Barang b2 = new Barang("Tanggo",5000);// barang ke 2
		Barang b3 = new Barang("Buavita",7000);// barang ke 3
		Barang b4 = new Barang("Aqua",3000);// barang ke 4
		daftarBarang[0] = b1;
		daftarBarang[1] = b2;
		daftarBarang[2] = b3;
		daftarBarang[3] = b4;
		
		int total = 0; // variable untuk menampung total harga nya
		int max =-1; // variable untuk menampung nilai max nya
		String barang_1 = daftarBarang[0].getNama();// untuk menampung nama barang pertama
		
		if(uang <= 3000) { //jika uang kurang dari 3000
			System.out.println("Maaf uang anda tidak cukup");
		}
		else {
			for (int i =0;i<daftarBarang.length;i++) {// loop semua barang
				total = daftarBarang[i].getHarga();// total untuk menampung harga barang
				if (total <= uang && total>max) {// jika total lebih kecil sama degan uang dan total lebih besar daripada max
					max = total; // nilai max akan diganti menjadi total
					barang_1 = daftarBarang[i].getNama();//mengambil nama barang
				}
			}
			
			
			int sisa = uang-max;//menghitung sisa
			String barang_2 = daftarBarang[0].getNama();//untuk menampung nama barang pertama
			
			if (sisa >= 3000) {//jika sisa lebih berar dari 3000, kenapa 3000?? karena 3000 harga barang paling murah
				total = 0;//total diset ke 0 
				max = -1;//max diset ke -1
				for (int i =0;i<daftarBarang.length;i++) {// loop semua barang ke2
					total = daftarBarang[i].getHarga();// total untuk menampung harga barang ke 2
					if (total <= sisa && total>max) {// jika total lebih kecil sama degan sisa dan total lebih besar daripada max
						max = total;// nilai max akan diganti menjadi total
						barang_2 = daftarBarang[i].getNama();//mengambil nama barang ke 2
					}
				}
				if (barang_1==barang_2) { //jika barang pertama dan kedua sama
					System.out.println("Barang yang dibeli: 2 "+barang_1);//jumlah barang nya *2
				}else {//jika barang pertama dan kedua berbeda
					System.out.println("Barang yang dibeli: "+barang_1+" dan "+barang_2);//print barang pertama dan kedua
				}
				
			}else {//jika sisa kurang dari 3000
				System.out.println("Barang yang dibeli: "+barang_1);//print barang pertama
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jawaban_Nomer_6("aku belajar pemrogramman");
		System.out.println();
		System.out.print("1. ");
		jawaban_Nomer_7(2000); // kasus 1 : uang kurang dari 3000
		System.out.print("2. ");
		jawaban_Nomer_7(6000); // kasus 2 : uang hanya cukup membeli 1 barang
		System.out.print("3. ");
		jawaban_Nomer_7(12000); // kasus 3 : uang cukup membeli 2 barang tp barang 1 dan barang 2 beda
		System.out.print("4. ");
		jawaban_Nomer_7(14000);// kasus 4 : barang pertama dan barang ke 2 sama
		
	}

}
