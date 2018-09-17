function validate() {
		
		var fname = document.getElementById("first_name").value;
		var lname = document.getElementById("last_name").value;
		
//		var gend = document.getElementByID("gender");
		var eMail = document.getElementByID("email").value;
		var zip = document.getElementByID("address");
//		var uname = document.getElementByID("username").value;
//		var pWord = document.getElementByID("passcode").value;
//		
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
//		var phoneformat = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/;
//		var passformat = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
		
		boolean form = false;
		if (fname.length <= 2) {
			alert("please enter a longer first name!");
			document.getElementById("first_name").focus(); 
			return false;
		} else if (lname.length <= 2) {
			alert("please enter a longer last name!");
			document.getElementById("last_name").focus(); 
			return false;
		} else if (!eMail.value.match(mailformat)) {
			alert("please enter a valid email address!");
			document.getElementById("em").focus();
			return false;
		} else if (!zip.length < 5) {
			alert("please enter a valid zip code!");
			document.getElementById("address").focus();
			return false;	
			
		}
		
		document.getElementByType("submit").addEventListener("click", validate) {
			alert("You must fill these out!");
			}
	
	