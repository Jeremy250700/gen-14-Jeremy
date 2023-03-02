/**
 * 
 */
package prodemy;

import java.io.Serializable;

/**
 * @author Jeremy
 *
 */
public class barang implements Serializable {
	private String nama;
	private int harga;
	private int stok;
	
	public barang () {
		
	}
	public barang (String nama, int harga,int stok) {
		this.nama = nama;
		this.harga = harga;
		this.stok = stok;
	}
	public String getNama() {
		return this.nama;
	}
	public int getHarga() {
		return harga;
	}
	public int getStok() {
		return stok;
	}
	
	public String printBarang() {
		return ("Nama Barang:" + nama + "\nHarga: " + "Rp "+harga+ "\nStok: " + stok);
	}

}