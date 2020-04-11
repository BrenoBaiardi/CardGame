function montaTr(size,row_number){
  var arenaTr = document.createElement("tr")
  arenaTr.classList.add("paciente");

    for (var col_number = 1; col_number < size+1; col_number++) {
        arenaTr.appendChild(montaTd(String(row_number).concat("x",col_number),"ArenaCell"));
    }
  return arenaTr;
}

function montaTd(dado, classe){
  var td = document.createElement("td");
  td.textContent = dado;
  td.classList.add(classe);
  td.classList.add("card");
  //console.log(td);
  return td;
}

var tabela = document.querySelector("#arena-table");

for (var i = 1; i <= 5; i++) {
  var arenaTr = montaTr(5,i);
  tabela.appendChild(arenaTr);
}
