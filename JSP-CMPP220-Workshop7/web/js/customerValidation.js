

function validateCustomer()
     	{
     		var errmsg = false;
     		var custform = document.getElementById("editCustDetail");
     		var postalregexp = new RegExp(/^[A-Z][0-9][A-Z]\s?\d[A-Z]\d$/i);
			var emailregexp = new RegExp(/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i);
			var phonenoregexp = new RegExp(/^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/);
			
			if(custform.fname.value == "")
			{
				document.getElementById('fnameErr').innerHTML = "<br/>First name is required";
				errmsg = true;
			}
			else
			{
				document.getElementById('fnameErr').innerHTML = "";
			}
			
			if(custform.lname.value == "")
			{
				document.getElementById('lnameErr').innerHTML = "<br/>Last name is required";
				errmsg = true;
			}
			else
			{
				document.getElementById('lnameErr').innerHTML = "";
			}
			
			if(custform.address.value == "")
			{
				document.getElementById('addressErr').innerHTML = "<br/>Address is required";
				errmsg = true;
			}
			else
			{
				document.getElementById('addressErr').innerHTML = "";
			}
			
			if(custform.city.value == "")
			{
				document.getElementById('cityErr').innerHTML = "<br/>City is required";
				errmsg = true;
			}
			else
			{
				document.getElementById('cityErr').innerHTML = "";
			}
			
			if(custform.province.value == "")
			{
				document.getElementById('provinceErr').innerHTML = "<br/>Province is required";
				errmsg = true;
			}
			else
			{
				document.getElementById('provinceErr').innerHTML = "";
			}
			
			if(custform.postal.value == "")
			{
				document.getElementById('postalErr').innerHTML = "<br/>Postal is required";
				errmsg = true;
			}
			else if( custform.postal.value != "" && !postalregexp.test(custform.postal.value))
			{
				document.getElementById('postalErr').innerHTML = "<br/>Postal code is not in valid format";
				errmsg = true;
			}
			else
			{
				document.getElementById('postalErr').innerHTML = "";
			}
			
			if(custform.country.value == "")
			{
				document.getElementById('countryErr').innerHTML = "<br/>Country is required";
				errmsg = true;
			}
			else
			{
				document.getElementById('countryErr').innerHTML = "";
			}
			
			if(custform.homephone.value == "")
			{
				document.getElementById('homephoneErr').innerHTML = "<br/>Homephone is required";
				errmsg = true;
			}
			else if(custform.homephone.value != "" && !phonenoregexp.test(custform.homephone.value))
			{
				document.getElementById('homephoneErr').innerHTML = "<br/>Homephone is not in valid format";
				errmsg = true;
			}
			else
			{
				document.getElementById('homephoneErr').innerHTML = "";
			}
			
			if(custform.busphone.value != "" && !phonenoregexp.test(custform.busphone.value))
			{
				document.getElementById('busphoneErr').innerHTML = "<br/>Business Phone Number is not in valid format";
				errmsg = true;
			}
			else if(custform.busphone.value != "" && custform.busphone.value == custform.homephone.value)
			{
				document.getElementById('busphoneErr').innerHTML = "<br/>Home and Business Phone Number should be different";
				errmsg = true;
			}
			else
			{
				document.getElementById('busphoneErr').innerHTML = "";
			}
			
			if(custform.email.value == "")
			{
				document.getElementById('emailErr').innerHTML = "<br/>Email is required";
				errmsg = true;
			}
			else if(custform.email.value != "" && !emailregexp.test(custform.email.value))
			{
				document.getElementById('emailErr').innerHTML = "<br/>Email is not in valid format";
				errmsg = true;
			}
			else
			{
				document.getElementById('emailErr').innerHTML = "";
			}
			
			if(custform.agentid.value == "")
			{
				document.getElementById('agentidErr').innerHTML = "<br/>AgentId is required";
				errmsg = true;
			}
			else
			{
				document.getElementById('agentidErr').innerHTML = "";
			}			

			if(custform.password.value == "")
			{
				document.getElementById('passwordErr').innerHTML = "<br/>Password is required";
				errmsg = true;
			}
			else if(custform.password.value != "" && custform.password.value.length < 6)
			{
				document.getElementById('passwordErr').innerHTML = "<br/>Password should have atleast 6 characters";
				errmsg = true;
			}
			else
			{
				document.getElementById('passwordErr').innerHTML = "";
			}
			
			if(errmsg)
				return false;
			else
     			return true;
     	}
     	