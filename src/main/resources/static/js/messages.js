$('.tablink').click(function(){


var messageId = this.id


fetch(`/discussionform/getmessage/${messageId}`)

    .then(response => response.json())
    .then(data => {
	 
	  document.getElementById("tabcontent").innerHTML = data.messageContent;
});

});

