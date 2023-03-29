$(document).ready(function() {
			$.getJSON('http://localhost:8082/home', function(json) {
				var tr=[];
				for (var i = 0; i < json.length; i++) {
					tr.push('<tr>');
					tr.push('<td>' + json[i].nim + '</td>');
					tr.push('<td>' + json[i].nama + '</td>');
					tr.push('<td>' + json[i].umur + '</td>');
					tr.push('<td>' + json[i].kota + '</td>');
					tr.push('<td><button class=\'edit\'>Edit</button>&nbsp;&nbsp;<button class=\'delete\' nim=' + json[i].nim + '>Delete</button></td>');
					tr.push('</tr>');
				}
				$('table').append($(tr.join('')));
			});
			
			$(document).delegate('#addNew', 'click', function(event) {
				event.preventDefault();
				
				var nama = $('#nama').val();
				var nim = $('#nim').val();
				var umur = $('#umur').val();
				var kota = $('#kota').val();
				
				$.ajax({
					type: "POST",
					contentType: "application/json; charset=utf-8",
					url: "http://localhost:8082/home/save",
					data: JSON.stringify({'nama': nama,'nim': nim,'umur': umur,'kota': kota}),
					cache: false,
					success: function(result) {
						$("#msg").html( "<span style='color: green'>Company added successfully</span>" );
						window.setTimeout(function(){location.reload()},1000)
					},
					error: function(err) {
						$("#msg").html( "<span style='color: red'>Name is required</span>" );
					}
				});
			});
			
			$(document).delegate('.delete', 'click', function() { 
				if (confirm('Do you really want to delete record?')) {
					var nim = $(this).attr('nim');
					var parent = $(this).parent().parent();
					$.ajax({
						type: "DELETE",
						url: "http://localhost:8082/home/delete/"+ nim,
						cache: false,
						success: function() {
							parent.fadeOut('slow', function() {
								$(this).remove();
							});
							location.reload(true)
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
				var kota = parent.children("td:nth-child(4)");
				var buttons = parent.children("td:nth-child(5)");
				
				nama.html("<input type='text' id='txtName' value='" + nama.html() + "'/>");
				umur.html("<input type='text' id='txtName' value='" + umur.html() + "'/>");
				kota.html("<input type='text' id='txtName' value='" + kota.html() + "'/>");
				buttons.html("<button id='save'>Save</button>&nbsp;&nbsp;<button class='delete' nim='" + nim.html() + "'>Delete</button>");
			});
			
			$(document).delegate('#save', 'click', function() {
				var parent = $(this).parent().parent();
				
				var nim = parent.children("td:nth-child(1)");
				var nama = parent.children("td:nth-child(2)");
				var umur = parent.children("td:nth-child(3)");
				var kota = parent.children("td:nth-child(4)");
				var buttons = parent.children("td:nth-child(5)");
				
				$.ajax({
					type: "POST",
					contentType: "application/json; charset=utf-8",
					url: "http://localhost:8082/home/save",
					data: JSON.stringify({'nim' : nim.html(), 
					'nama' : nama.children("input[type=text]").val(),
					'umur' : umur.children("input[type=text]").val(),
					'kota' : kota.children("input[type=text]").val()}),
					cache: false,
					success: function() {
						nama.html(nama.children("input[type=text]").val());
						umur.html(umur.children("input[type=text]").val());
						kota.html(kota.children("input[type=text]").val());
						buttons.html("<button class='edit' id='" + nim.html() + "'>Edit</button>&nbsp;&nbsp;<button class='delete' id='" + nim.html() + "'>Delete</button>");
					},
					error: function() {
						$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error updating record').fadeIn().fadeOut(4000, function() {
							$(this).remove();
						});
					}
				});
			});

			
			});
