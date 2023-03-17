<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored ="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function regexNamaDosen(str_nama){
	return Boolean (str_nama.match(/^[A-Za-z]+$/));
}
function validateUpdateData() {
	  var nama = document.getElementById("nama_dosen").value;
	  
	  if(regexNamaDosen(nama)== true) {			  
	  		if (nama.length < 3){
		  		alert('Nama Dosen harus lebih dari 3 huruf');
		  		return false;
	  		}		  		
	  		else
	  			return true;	  
	  	}
	  	else {
			alert('Nama Dosen tidak boleh menggunakan angka');  		
	  		return false;
	  	}
	}
</script>
</head>
<body>

	<form action="updateDataDosenController" onsubmit ="return validateUpdateData()">
		Kode Dosen<input type="text" name="kode_dosen" value="${dosen.getKode_dosen()}"  readonly> <br>
		Nama Dosen <input type="text" name="nama_dosen" value="${dosen.getNama_dosen()}" id="nama_dosen"> <br>
		<input type="submit">
	</form>
</body>
</html>