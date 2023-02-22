/**
 * 
 */
package bangun_datar;

/**
 * @author Jeremy
 *
 */
public class Lingkaran extends BangunDatar{
	private int jari_jari;
	public Lingkaran() {
		
	}
	public Lingkaran(int jari_jari) {
		this.jari_jari = jari_jari;
	}
	
	public String getLuas() {
		this.luas = 3.14 * jari_jari * jari_jari;	
		String new_luas_lingkaran = Double.toString(luas);
		return ("Luas Lingkaran: "+new_luas_lingkaran);
	}
	
	public String getKeliling() {
		this.keliling = 3.14 * (jari_jari * 2);
		String new_keliling_lingkaran = Double.toString(keliling);
		return ("Keliling Lingkaran: "+new_keliling_lingkaran);
	}
}
