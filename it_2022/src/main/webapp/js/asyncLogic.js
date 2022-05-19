function editInfo() {
	
const formData = toJSONString(document.querySelector("form.user-info"));	
 

fetch('asyncServlet', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
  },
  body: formData
})
.then((response) => {return response.json();})
.then((data) => {
  document.getElementById("message").innerHTML= data.message;
})
.catch((error) => {
  console.error('Error:', error);
});
}

  function toJSONString(form) {
	let obj = {};
	let elements = form.querySelectorAll( "input" );
	for( let i = 0; i < elements.length; i++ ) {
		let element = elements[i];
		let name = element.name;
		let value = element.value;

		if(name) {
			obj[name] = value;
		}
	}
	return JSON.stringify(obj);
}
 
