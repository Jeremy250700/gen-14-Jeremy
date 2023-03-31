function regexNamaMahasiswa(str_nama){
	return Boolean (str_nama.match(/^[A-Za-z]+$/));
}
function regexNim(str_nim){
	return Boolean (str_nim.match(/[M]H][S][0-9]{1,2}[1-9]{1}/));
}

function regexUmur(str_umur){
	return Boolean(str_umur.match());
}

function sukses(){
	$("#msg").html("<span style='color: green'>Company added successfully</span>");
	$("#input-form").hide();
	setTimeout(function(){
		$("#addModal").modal('hide');
		$("#nim").val('');
		$("#nama").val('');
		$("#kota").val('');
		$("#email").val('');
		$("#umur").val('');
		$("#msg").html("");
	},1000);
	setTimeout(function(){
		$("#input-form").show();
	},1500);
	tampilkanTable();
}
$(document).ready(function(){
  $("#dataSearch").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#dataMahasiswa tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});

function tampilkanTable(){
	$("#data").empty();
	$.getJSON('http://localhost:8081/home', function(json) {
				var tr=[];
				tr.push('<table class=\'table\'>')
				tr.push('<thead class=\'table-dark\'>');
				tr.push('<tr>');
					tr.push('<td>NIM</td>');
					tr.push('<td>Nama</td>');
					tr.push('<td>Umur</td>');
					tr.push('<td>Email</td>');
					tr.push('<td>Kota</td>');
					tr.push('<td>Action</td>');
					tr.push('</tr>');
				tr.push('</thead>');
				tr.push('<tbody id="dataMahasiswa">');
				for (var i = 0; i < json.length; i++) {
					tr.push('<tr>');
					tr.push('<td>' + json[i].nim + '</td>');
					tr.push('<td>' + json[i].nama + '</td>');
					tr.push('<td>' + json[i].umur + '</td>');
					tr.push('<td>' + json[i].email + '</td>');
					tr.push('<td>' + json[i].kota + '</td>');
					tr.push('<td><button class=\'btn btn-warning edit\'><i class=\'fa-sharp fa-solid fa-pen\'></i></button>&nbsp;&nbsp;<button class=\'delete btn btn-danger\' nim=' + json[i].nim + '><i class=\'fa-sharp fa-solid fa-trash\'></i></button></td>');
					tr.push('</tr>');
				}
				tr.push('</tbody>');
				tr.push('</table>')
				$("#data").append($(tr.join('')));
			});
}

$(document).ready(function() {
//	$("#add").click(function() {
//        $("#addModal").modal('show');
//    });
//    $("#closeModal").click(function() {
//        $("#addModal").modal('hide');
//    });	
			tampilkanTable();
			$('#closeModal,#close-modal').click(function(){
				$("#msg").html("");
			})
			$(document).delegate('#addNew', 'click', function(event) {
				event.preventDefault();
				
				var nama = $('#nama').val();
				var nim = $('#nim').val();
				var umur = $('#umur').val();
				var email = $('#email').val();
				var kota = $('#kota').val();
				if(nim=="" || nama=="" || umur=="" || email=="" || kota==""){
					$('#msg').html("<div class='form-text text-danger'>Data harus diisi semua</div>");
				}
				if(nim!="" && nama!="" && umur!="" && email!="" && kota!=""){					
				$.ajax({
					type: "POST",
					contentType: "application/json; charset=utf-8",
					url: "http://localhost:8081/home/save",
					data: JSON.stringify({'nama': nama,'nim': nim,'umur': umur,'email':email,'kota': kota}),
					cache: false,
					success: sukses,
					error: function(err) {
						$("#msg").html( "<span style='color: red'>Name is required</span>" );
					}
				});
				}
			});
			
			$(document).delegate('.delete', 'click', function() { 
				if (confirm('Do you really want to delete record?')) {
					var nim = $(this).attr('nim');
					var parent = $(this).parent().parent();
					$.ajax({
						type: "DELETE",
						url: "http://localhost:8081/home/delete/"+ nim,
						cache: false,
						success: function() {
							parent.fadeOut('slow', function() {
								$(this).remove();
							});
							tampilkanTable();
						},
						error: function() {
							$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error deleting record').fadeIn().fadeOut(4000, function() {
								$(this).remove();
							});
						}
					});
				}
			});
			
			$(document).delegate('.edit', 'click', function() {
				var parent = $(this).parent().parent();
				
				var nim = parent.children("td:nth-child(1)");
				var nama = parent.children("td:nth-child(2)");
				var umur = parent.children("td:nth-child(3)");
				var email = parent.children("td:nth-child(4)");
				var kota = parent.children("td:nth-child(5)");
				var buttons = parent.children("td:nth-child(6)");
				
				nama.html("<input type='text' id='txtName' value='" + nama.html() + "'/>");
				umur.html("<input type='text' id='txtName' value='" + umur.html() + "'/>");
				email.html("<input type='text' id='txtName' value='" + email.html() + "'/>");
				kota.html("<input type='text' id='txtName' value='" + kota.html() + "'/>");
				buttons.html("<button id='save' class='btn btn-success'>Save</button>&nbsp;&nbsp;<button class='delete btn btn-danger' nim='" + nim.html() + "'><i class=\'fa-sharp fa-solid fa-trash\'></i></button>");
			});
			
			$(document).delegate('#save', 'click', function() {
				var parent = $(this).parent().parent();
				
				var nim = parent.children("td:nth-child(1)");
				var nama = parent.children("td:nth-child(2)");
				var umur = parent.children("td:nth-child(3)");
				var email = parent.children("td:nth-child(4)");
				var kota = parent.children("td:nth-child(5)");
				var buttons = parent.children("td:nth-child(6)");
				
				$.ajax({
					type: "POST",
					contentType: "application/json; charset=utf-8",
					url: "http://localhost:8081/home/save",
					data: JSON.stringify({'nim' : nim.html(), 
					'nama' : nama.children("input[type=text]").val(),
					'umur' : umur.children("input[type=text]").val(),
					'email' : email.children("input[type=text]").val(),
					'kota' : kota.children("input[type=text]").val()}),
					cache: false,
					success: function() {
						nama.html(nama.children("input[type=text]").val());
						umur.html(umur.children("input[type=text]").val());
						email.html(email.children("input[type=text]").val());
						kota.html(kota.children("input[type=text]").val());
						buttons.html("<button class='edit btn btn-warning' id='" + nim.html() + "'><i class=\'fa-sharp fa-solid fa-pen\'></i></button>&nbsp;&nbsp;<button class='delete btn btn-danger' id='" + nim.html() + "'><i class=\'fa-sharp fa-solid fa-trash\'></i></button>");
					},
					error: function() {
						$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error updating record').fadeIn().fadeOut(4000, function() {
							$(this).remove();
						});
					}
				});
			});

			
			});
