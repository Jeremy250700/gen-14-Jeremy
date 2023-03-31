/**
 * 
 */
package com.prodemy.mahasiswa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jeremy
 *
 */
@Service
public class MahasiswaService {
	@Autowired
	private MahasiswaRepository repo;

	public List<Mahasiswa> listAll() {
		return (List<Mahasiswa>) repo.findByOrderByNimAsc();
	}
	public void save(Mahasiswa mahasiswa) {
		repo.save(mahasiswa);
	}
	public Mahasiswa get(String nim) {
		Optional<Mahasiswa> result = repo.findById(nim);
		return result.get();
	}
	public void delete(String nim) {
		repo.deleteById(nim);
	}
	public List<Mahasiswa> search(String keyword){
		return repo.search(keyword);
	}
	
}
