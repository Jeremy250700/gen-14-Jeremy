/**
 * 
 */
package com.prodemy.mahasiswa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Jeremy
 *
 */
	@Entity(name="mahasiswa")
	@Table(name="mahasiswa")
	@Data
	public class Mahasiswa {
		@Id
		//@SequenceGenerator(name="mahasiswa_sequence", sequenceName="sq_mahasiswa", allocationSize=1)
		//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator ="mahasiswa_sequence")
		@Column(name="nim",length=20)
		private String nim;
		
		@Column(name="nama",length=50)
		private String nama;
		
		@Column(name="umur",length=3)
		private String umur;
		
		@Column(name="kota",length=20)
		private String kota;
		
		public Mahasiswa() {
			
		}
		public Mahasiswa(String nim, String nama, String umur, String kota) {
			this.nim = nim;
			this.nama = nama;
			this.umur = umur;
			this.kota = kota;
		}
		

	}

