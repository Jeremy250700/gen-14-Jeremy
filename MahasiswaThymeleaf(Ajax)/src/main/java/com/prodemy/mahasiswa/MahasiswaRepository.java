/**
 * 
 */
package com.prodemy.mahasiswa;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Jeremy
 *
 */
public interface MahasiswaRepository extends CrudRepository<Mahasiswa, String> {
	@Query(value = "SELECT m FROM mahasiswa m WHERE m.nim LIKE '%' || :keyword || '%'"
			+" OR m.nama LIKE '%' || :keyword || '%'"
			//+" OR m.umur ='%' || :keyword || '%'"
			+" OR m.kota LIKE '%' || :keyword || '%'"
			+" OR m.umur LIKE '%' || :keyword || '%'")
	public List<Mahasiswa> search(@Param("keyword") String keyword);
}
