var playertable = document.getElementById('player-hand'); //returns a HTML DOM Object

playertable.addEventListener("click", function(event){
//TODO for loop do celar highlighted-card from cells already selected
  console.log(playertable);
     //iterate through rows
  event.target.classList.add("highlighted-card");
  console.log(event.target);
});
