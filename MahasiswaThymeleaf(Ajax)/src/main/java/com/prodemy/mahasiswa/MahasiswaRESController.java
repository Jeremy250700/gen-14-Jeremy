/**
 * 
 */
package com.prodemy.mahasiswa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeremy
 *
 */
@RestController
@CrossOrigin(origins ="*")
public class MahasiswaRESController {
	@Autowired
	private MahasiswaService service;
	
	@GetMapping("/home")
	public ResponseEntity<List<Mahasiswa>> getListMahasiswa(){
		return new ResponseEntity<List<Mahasiswa>>(service.listAll(),HttpStatus.OK);
	}
	
	@GetMapping("/home/edit/{nim}")
	public ResponseEntity<Mahasiswa> getMahasiswa(@PathVariable String nim){
		return new ResponseEntity<Mahasiswa>(service.get(nim),HttpStatus.OK);
	}
	@PostMapping("/home/save")
	public ResponseEntity<Void> saveOrUpdateMahasiswa(@RequestBody Mahasiswa mahasiswa){
		service.save(mahasiswa);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@DeleteMapping("/home/delete/{nim}")
	public ResponseEntity<Void> deleteMahasiswa(@PathVariable String nim){
		service.delete(nim);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
