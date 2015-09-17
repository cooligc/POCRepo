<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<script src="<c:url value="/resources/core/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/core/jquery.autocomplete.min.js" />"></script>
<link href="<c:url value="/resources/core/main.css" />" rel="stylesheet">

</head>
<body>

	<form action="#" id='form'>
		<table id="user">
			<tr id="_1">
				<td> Enter name : </td>
				<td> <input type="text" name="name"/></td>
				
				<td> Enter surname : </td>
				<td> <input type="text" name="surname"/></td>
			</tr>
		</table>
		<button type="button" id="add" name="Add More" style="width:60px;height:30px" >Add</button>
		<button type="button" id="save" name="Save" style="width:60px;height:30px" >Save</button>
	</form>
	
	<script>
	$(document).ready(function() {
		var count=1;
		
		$('#add').click(function(){
			count=count+1;
			var user = $("#_1").html();
			$('#user').append('<tr id=_'+count+'>'+user+'</tr>');
		});
		
		$('#save').click(function(){
			var jsonObject = new Object();
			var users = [];
			for(var i=1;i<=count;++i){
				var idz = '_'+i;
				var user = new Object();
				var name = $('#'+idz+' input[name*=name]').val();
				var surname = $('#'+idz+' input[name*=surname]').val();
				user.name=name;
				user.surname=surname;
				users.push(user)
			}
			var userObject = new Object();
			userObject.users=users;
			jsonObject.users = users;
			
			alert(JSON.stringify(jsonObject));
			$.ajax({
				  url: '${pageContext.request.contextPath}/organization',
				  type: 'post',
				  dataType: 'json',
				  data: JSON.stringify(jsonObject), 
				 // accept:'application/json',
				  //contentType:'application/json',
				  /* 
				  contentType: 'application/json',
				  mimeType: 'application/json', */
				  beforeSend: function(xhr) {
			            xhr.setRequestHeader("Accept", "application/json");
			            xhr.setRequestHeader("Content-Type", "application/json");
			        },
				  success: function (data, status) {
					  
					alert(data);
				    console.log("Success!!");
				    console.log(data);
				    console.log(status);
				  },
				  error: function (xhr, desc, err) {
					alert(xhr.contentType);
				    console.log(xhr);
				    console.log("Desc: " + desc + "\nErr:" + err);
				  }
				});
			
		});
		
		
	});
	</script>
	
</body>
</html>