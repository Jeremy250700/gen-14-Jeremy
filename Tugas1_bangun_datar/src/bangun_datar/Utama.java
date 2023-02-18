/**
 * 
 */
package bangun_datar;

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
		System.out.println("------Menghitung Luas Segitiga------");
		Segitiga segitiga = new Segitiga();
		
		Scanner alas_segitiga = new Scanner(System.in);
		System.out.println("Enter Alas Segitiga");
		int Alas_Segitiga = alas_segitiga.nextInt();
		
		
		
		Scanner tinggi_segitiga = new Scanner(System.in);
		System.out.println("Enter Tinggi Segitiga");
		int Tinggi_Segitiga = tinggi_segitiga.nextInt();
		
		System.out.println("Alas Segitiga: "+Alas_Segitiga);
		System.out.println("Tinggi Segitiga: "+Tinggi_Segitiga);
		
		try {
			segitiga.setLuasSegitiga(Alas_Segitiga,Tinggi_Segitiga);
			
		} catch (Exception e) {
		}
		System.out.println("Luas Segitiga = "+segitiga.getLuasSegitiga()+"\n");
		System.out.println("------Menghitung Keliling Segitiga------");

		Scanner sisi_segitiga = new Scanner(System.in);
		System.out.println("Enter Sisi Segitiga");
		int Sisi_Segitiga = sisi_segitiga.nextInt();
		System.out.println("Sisi Segitiga: "+Sisi_Segitiga);
		
		try {
			segitiga.setKelilingSegitiga(Sisi_Segitiga);
			
		} catch (Exception e) {
		}
		System.out.println("Keliling Segitiga = "+segitiga.getKelilingSegitiga()+"\n");
		
		
		
		//Luas dan Keliling Lingkaran
		System.out.println("------Menghitung Luas Lingkaran------");
		Lingkaran lingkaran = new Lingkaran();
		
		Scanner jari_jari = new Scanner(System.in);
		System.out.println("Enter Jari Jari Lingkarang");
		int Jari_Jari = jari_jari.nextInt();
		System.out.println("Jari Jari Lingkaran: "+Jari_Jari);
		
		try {
			lingkaran.setLuasLingkaran(5);
			
		} catch (Exception e) {
		}
		System.out.println("Luas Lingkaran = "+lingkaran.getLuasLingkaran()+"\n");
		System.out.println("------Menghitung Keliling Lingkaran------");
		System.out.println("Jari Jari Lingkaran: "+Jari_Jari);
		try {
			lingkaran.setKelilingLingkaran();
			
		} catch (Exception e) {
		}
		System.out.println("Keliling Lingkaran = "+lingkaran.getKelilingLingkaran()+"\n");
		
		
		//Luas dan Keliling Persegi
		System.out.println("------Menghitung Luas Persegi------");
		Persegi persegi = new Persegi();
		Scanner sisi_persegi = new Scanner(System.in);
		System.out.println("Enter Sisi Persegi");
		int Sisi_Persegi = sisi_persegi.nextInt();
		System.out.println("Sisi Persegi: "+Sisi_Persegi);
		
		try {
			persegi.setLuasPersegi(Sisi_Persegi);
			
		} catch (Exception e) {
		}
		System.out.println("Luas Persegi = "+persegi.getLuasPersegi()+"\n");
		System.out.println("------Menghitung Keliling Persegi------");
		System.out.println("Sisi Persegi: "+Sisi_Persegi);
		try {
			persegi.setKelilingPersegi();
			
		} catch (Exception e) {
		}
		System.out.println("Keliling Persegi = "+persegi.getKelilingPersegi()+"\n");
		
		
		//Luas dan Keliling Belah Ketupat
		System.out.println("------Menghitung Luas Belah Ketupat------");
		BelahKetupat belahketupat = new BelahKetupat();
		Scanner diagonal_1 = new Scanner(System.in);
		System.out.println("Enter Diagonal 1 Belah Ketupat");
		int Diagonal_1 = diagonal_1.nextInt();
		
		Scanner diagonal_2 = new Scanner(System.in);
		System.out.println("Enter Diagonal 2 Belah Ketupat");
		int Diagonal_2 = diagonal_2.nextInt();
		
		System.out.println("Diagonal 1 Belah Ketupat: "+Diagonal_1);
		System.out.println("Diagonal 2 Belah Ketupat: "+Diagonal_2);
		
		try {
			belahketupat.setLuasBelahKetupat(Diagonal_1,Diagonal_2);
			
		} catch (Exception e) {
		}
		System.out.println("Luas Belah Ketupat = "+belahketupat.getLuasBelahKetupat()+"\n");
		System.out.println("------Menghitung Keliling Belah Ketupat------");
		Scanner sisi_bk = new Scanner(System.in);
		System.out.println("Enter Sisi Belah Ketupat");
		int Sisi_BK = sisi_bk.nextInt();
		System.out.println("Sisi Belah Ketupat: "+Sisi_BK);
		try {
			belahketupat.setKelilingBelahKetupat(7);
			
		} catch (Exception e) {
		}
		System.out.println("Keliling Belah Ketupat = "+belahketupat.getKelilingBelahKetupat()+"\n");
		
		System.out.println("------List Luas------");
		double[] listLuas = new double[4];
		listLuas[0] = segitiga.getLuasSegitiga();
		listLuas[1] = lingkaran.getLuasLingkaran();
		listLuas[2] = persegi.getLuasPersegi();
		listLuas[3] = belahketupat.getLuasBelahKetupat();
		
		System.out.println(Arrays.toString(listLuas));
		
	}
}


