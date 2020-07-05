<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<img id="myimg" src="">

<!-- The core Firebase JS SDK is always required and must be listed first -->
<script src="https://www.gstatic.com/firebasejs/7.15.5/firebase-app.js"></script>
<!-- TODO: Add SDKs for Firebase products that you want to use
     https://firebase.google.com/docs/web/setup#available-libraries -->
<script src="https://www.gstatic.com/firebasejs/7.15.5/firebase-analytics.js"></script>
<script src="https://www.gstatic.com/firebasejs/7.14.6/firebase-storage.js"></script>

<script>
  // Your web app's Firebase configuration
  var firebaseConfig = {
	apiKey: "AIzaSyB95XfXQZzjFz6MD3caNOx3lWmRjDILo7s",
	authDomain: "yoginaegym.firebaseapp.com",
	databaseURL: "https://yoginaegym.firebaseio.com",
	projectId: "yoginaegym",
	storageBucket: "yoginaegym.appspot.com",
	messagingSenderId: "866216632881",
	appId: "1:866216632881:web:188b0b997e265bdcbd2b10",
	measurementId: "G-R8MPMCYPGB"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);
  firebase.analytics();
	//Cloud Storage 참조
	var storage = firebase.storage();
	//var pathReference = storage.ref('Member_Profile_Image');
	var gsReference = storage.refFromURL('gs://yoginaegym.appspot.com/Member_Profile_Image/dog3_proImg');
	
	gsReference.getDownloadURL().then(function(url){
		var xhr = new XMLHttpRequest();
		xhr.responseType = 'blob';
		xhr.onload = function(event){
			var blob = xhr.response;
		};
		xhr.open('GET', url);
		xhr.send();
		
		var img = document.getElementById('myimg');
		img.src = url;
	}).catch (function(error){
		alert("이미지 다운로드 실패!");
		// A full list of error codes is available at
		// https://firebase.google.com/docs/storage/web/handle-errors
		switch (error.code) {
		  case 'storage/object-not-found':
			  alert("File doesn't exist");
		    break;
		  case 'storage/unauthorized':
			  alert("User doesn't have permission to access the object");
		    break;
		  case 'storage/canceled':
			  alert("User canceled the upload");
		    break;
		  case 'storage/unknown':
			  alert("Unknown error occurred, inspect the server response");
		    break;
		}
	});
</script>

</body>
</html>