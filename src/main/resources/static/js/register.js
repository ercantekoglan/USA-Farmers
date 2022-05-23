var usernameTextBox = document.querySelector('#username')
var token = document.getElementById("csrf.token").value;
usernameTextBox.addEventListener('blur', () => {
	var user = {
		'username': usernameTextBox.value
	}
	checkIfUserExists(user)
})

async function checkIfUserExists(user) {
	let responseEntity = await fetch('/users/exists', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
			"X-CSRF-TOKEN": token
		},
		body: JSON.stringify(user)
	})
	let userExists = await responseEntity.json()

	if (userExists === true) {
		
		console.log("username already exists")
		document.getElementById("warning").innerHTML = "This Username already exists!";
		usernameTextBox.focus()
		usernameTextBox.select()

	}
}


