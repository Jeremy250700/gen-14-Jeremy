/**
 * 
 */
package bangun_datar;

/**
 * @author Jeremy
 *
 */
public class BelahKetupat extends BangunDatar{
	private int sisi;
	private int diagonal1;
	private int diagonal2;
	
	public BelahKetupat() {
		
	}
	
	public BelahKetupat(int diagonal1, int diagonal2, int sisi) {
		this.diagonal1 = diagonal1;
		this.diagonal2 = diagonal2;
		this.sisi = sisi;
	}
	
	public String getLuas() {
		this.luas = 0.5 * diagonal1 * diagonal2;
		String new_luas_belah_ketupat = Double.toString(luas);
		return ("Luas Belah Ketupat: "+new_luas_belah_ketupat);
	}
	
	public String getKeliling() {
		this.keliling = 4 * sisi;
		String new_keliling_belah_ketupat = Double.toString(keliling);
		return ("Keliling Belah Ketupat: "+new_keliling_belah_ketupat);
	}
}
