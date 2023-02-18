/**
 * 
 */
package bangun_datar;

/**
 * @author Jeremy
 *
 */
public class Segitiga {
	private int alas;
	private int tinggi;
	private int sisi;
	private double luas_segitiga;
	private int keliling_segitiga;
	
	
	public void setLuasSegitiga(int alas, int tinggi) throws Exception{
		
		if (alas > 0) {
			this.alas = alas;
			}
		else{
				throw new Exception ("Alas Tidak Boleh Negatif");
			}
		
		if ( tinggi > 0) {
			this.tinggi = tinggi;
			}
		else {
				throw new Exception ("Tinggi Tidak Boleh Negatif");
			}
		this.luas_segitiga = 0.5 * alas * tinggi;
		
	}
	
	public double getLuasSegitiga() 
	{
		return luas_segitiga;
	}
	
	public void setKelilingSegitiga(int sisi) throws Exception{
		if (sisi > 0) {
			this.sisi = sisi;
			}
		else{
				throw new Exception ("Sisi Tidak Boleh Negatif");
			}
		this.keliling_segitiga = 3*sisi;
	}
	public int getKelilingSegitiga() 
	{
		return keliling_segitiga;
	}
}
