/**
 * 
 */
package prodemy;

/**
 * @author Jeremy
 *
 */
public class Barang {
	private String nama;
	private int harga;
	
	public Barang () {
		
	}
	public Barang (String nama, int harga) {
		this.nama = nama;
		this.harga = harga;
	}
	public String getNama() {
		return this.nama;
	}
	public int getHarga() {
		return harga;
	}

}
