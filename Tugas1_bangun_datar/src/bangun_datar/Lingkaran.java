/**
 * 
 */
package bangun_datar;

/**
 * @author Jeremy
 *
 */
public class Lingkaran {
	private int jari_jari;
	private double luas_lingkaran;
	private double keliling_lingkaran;
	
	public void setLuasLingkaran(int jari_jari) throws Exception{
		if (jari_jari >0) {
			this.jari_jari = jari_jari;
		}
		else {
			throw new Exception ("Jari Jari Tidak Boleh Negatif");
		}
	this.luas_lingkaran = 3.14 * jari_jari * jari_jari;	
	}
	public double getLuasLingkaran() {
		return luas_lingkaran;
	}
	
	public void setKelilingLingkaran() throws Exception{
		this.keliling_lingkaran = 3.14 * (jari_jari * 2);	
	}
	public double getKelilingLingkaran() {
		return keliling_lingkaran;
	}
}
