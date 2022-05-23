$('.tablink').click(function(){


var name = this.id


fetch(`/nutrients/postnutrient/${name}`)
    .then(response => response.json())
    .then(data => {
	  document.getElementById("title").innerHTML = data.title;
	  document.getElementById("tabcontent").innerHTML = data.description;
});

});

