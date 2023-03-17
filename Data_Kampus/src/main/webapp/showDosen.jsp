<%@page import="com.prodemy.model.Dosen"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function validateDeleteData(){	
	var result = confirm("Apakah Data ingin dihapus?");
		if (result) {
    		return true;
		}
		else{
			return false;
		}
}
function regexNamaDosen(str_nama){
	return Boolean (str_nama.match(/^[A-Za-z]+$/));
}
function regexKodeDosen(str_kode){
	return Boolean (str_kode.match(/[D][S][N][0-9]{1,2}[1-9]{1}/));
}

function validateAddData() {
	  var kode = document.getElementById("kode_dosen").value;
	  var nama = document.getElementById("nama_dosen").value;
	  
	  if(kode!="" && nama!=""){
		  if(regexKodeDosen(kode)==false){
			  alert('Kode Dosen harus diwalai dengan DSN dan ditambahkan 3 digit angka, seperti DSN001');
			  return false;
		  }
		  else{			  
		  	if(regexNamaDosen(nama)== true) {			  
		  		if (nama.length < 3){
			  		alert('Nama Dosen harus lebih dari 3 huruf');
			  		return false;
		  		}		  		
		  		else
		  			return true;	  
		  	}
		  	else {
				alert('Nama Dosen Salah');  		
		  		return false;
		  	}
		  }
	  }
	}
</script>

</head>
<body class="text-center">
	<table class="table table-dark table-striped">
		<tr style="text-align: center;">
			<th>Kode Dosen</th>
			<th>Nama Dosen</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${dosens}" var="d">
			<tr style="text-align: center;">
				<td><c:out value="${d.getKode_dosen()}" /></td>
				<td><c:out value="${d.getNama_dosen()}" /></td>
				<td> <a href='updateDataDosen?kode_dosen=${d.getKode_dosen()}'><button type="button" class="btn btn-warning">Update</button></a>
				</td>
				<td><a href='deleteDataDosen?kode_dosen=${d.getKode_dosen()}'onclick="return validateDeleteData()"><button type="button" class="btn btn-danger">Delete</button></a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<div class="card text-bg-secondary mb-3" style="max-width: 50%; margin: auto; padding:10px; margin-top:5%;">
  <div class="card-header"><h1>Add Data Dosen</h1></div>
  <div class="card-body">
    <form action="addDosen" name="addDataDosen" onsubmit="return validateAddData()">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Kode Dosen</label>
    <input type="text" name="kode_dosen" id="kode_dosen" required>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Nama Dosen</label>
    <input type="text" name="nama_dosen" id="nama_dosen" required>
  </div>
  <input type="submit" value="Submit">
</form>
  </div>
</div>
	<a href="index.jsp"><button type="button" class="btn btn-primary" style="margin-bottom: 20px;">Back</button></a>
</body>
</html>