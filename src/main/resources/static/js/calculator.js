var selectedCrop
var yieldGoal


$('#submit').click(function() {

	selectedCrop = $('#crops :selected').val();
	console.log(selectedCrop);

	yieldGoal = $('#yieldGoal').val();
	console.log(yieldGoal);


	fetch(`/calculate/${selectedCrop}/${yieldGoal}`)
		.then(response => response.json())
		.then(data => {
			document.getElementById("title").innerHTML = data.cropName.en;
			document.getElementById("goal").innerHTML = data.yieldGoal;
			document.getElementById("yieldUnit").innerHTML = data.yieldUnit;
			document.getElementById("nutrientString").innerHTML = "Nutrient";
			document.getElementById("removal").innerHTML = "Removal, kg/ha";

			document.getElementById("nnutrientvalue").innerHTML = data.nutrient.k;
			document.getElementById("n").innerHTML = "N";
			document.getElementById("p2nutrientvalue").innerHTML = data.nutrient.p2o5;
			document.getElementById("p2").innerHTML = "P2O5";
			document.getElementById("k2nutrientvalue").innerHTML = data.nutrient.k2o;
			document.getElementById("k2").innerHTML = "K2O";
			document.getElementById("snutrientvalue").innerHTML = data.nutrient.s;
			document.getElementById("s").innerHTML = "S";
			document.getElementById("pnutrientvalue").innerHTML = data.nutrient.p;
			document.getElementById("p").innerHTML = "P";
			document.getElementById("knutrientvalue").innerHTML = data.nutrient.k;
			document.getElementById("k").innerHTML = "K";
		});

});
