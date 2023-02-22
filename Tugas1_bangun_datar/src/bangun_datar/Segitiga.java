/**
 * 
 */
package bangun_datar;

/**
 * @author Jeremy
 *
 */
public class Segitiga extends BangunDatar{
	private int alas;
	private int tinggi;
	private int sisi;
	
	public Segitiga() {
		
	}
	public Segitiga(int alas,int tinggi,int sisi)
	{
		this.alas = alas;
		this.tinggi = tinggi;
		this.sisi = sisi;
	}
	
	public String getLuas() 
	{
		
		this.luas = 0.5 * alas * tinggi;
		String new_luas_segitiga = Double.toString(luas);  
		return ("Luas Segitiga: "+new_luas_segitiga);
	}
	
	
	public String getKeliling() 
	{
		this.keliling = 3*sisi;
		String new_keliling_segitiga = Double.toString(keliling);
		return ("Keliling Segitiga: "+new_keliling_segitiga);
	}
}
