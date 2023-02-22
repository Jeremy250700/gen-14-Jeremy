/**
 * 
 */
package bangun_datar;

/**
 * @author Jeremy
 *
 */
public class Persegi extends BangunDatar{
	private int sisi;
	
	public Persegi() {
		
	}
	public Persegi(int sisi) {
		this.sisi = sisi;
	}
	public String getLuas() {
		this.luas = sisi * sisi;
		String new_luas_persegi = Double.toString(luas);  
		return ("Luas Persegi: "+new_luas_persegi);
	}

	public String getKeliling() {
		this.keliling = 4 * sisi;
		String new_keliling_persegi = Double.toString(keliling);
		return ("Keliling Persegi: "+new_keliling_persegi);
	}

}
