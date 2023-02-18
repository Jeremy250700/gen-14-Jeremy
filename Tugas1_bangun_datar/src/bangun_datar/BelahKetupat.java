/**
 * 
 */
package bangun_datar;

/**
 * @author Jeremy
 *
 */
public class BelahKetupat {
	private int sisi;
	private int diagonal1;
	private int diagonal2;
	private double luas_belah_ketupat;
	private int keliling_belah_ketupat;
	
	public void setLuasBelahKetupat(int diagonal1, int diagonal2) throws Exception{
		if (diagonal1 > 0) {
			this.diagonal1 = diagonal1;
			}
		else{
				throw new Exception ("Diagonal 1 Tidak Boleh Negatif");
			}
		
		if (diagonal2 > 0) {
			this.diagonal2 = diagonal2;
			}
		else {
				throw new Exception ("Diagonal 2 Tidak Boleh Negatif");
			}
		this.luas_belah_ketupat = 0.5 * diagonal1 * diagonal2;
	}
	
	public double getLuasBelahKetupat() {
		return luas_belah_ketupat;
	}
	
	public void setKelilingBelahKetupat(int sisi) throws Exception{
		if (diagonal1 > 0) {
			this.sisi = sisi;
			}
		else{
				throw new Exception ("Sisi Tidak Boleh Negatif");
			}
		this.keliling_belah_ketupat = 4 * sisi;
	}
	
	public double getKelilingBelahKetupat() {
		return keliling_belah_ketupat;
	}
}
