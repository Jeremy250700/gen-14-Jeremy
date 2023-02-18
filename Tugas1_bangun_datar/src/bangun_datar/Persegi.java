/**
 * 
 */
package bangun_datar;

/**
 * @author Jeremy
 *
 */
public class Persegi {
	private int sisi;
	private int luas_persegi;
	private int keliling_persegi;
	
	public void setLuasPersegi(int sisi) throws Exception{
		if (sisi >0) {
			this.sisi = sisi;
		}
		else {
			throw new Exception ("sisi Tidak Boleh Negatif");
		}
	this.luas_persegi = sisi * sisi;	
	}
	public double getLuasPersegi() {
		return luas_persegi;
	}
	
	public void setKelilingPersegi(){
		this.keliling_persegi = 4 * sisi;	
	}
	public int getKelilingPersegi() {
		return keliling_persegi;
	}

}
