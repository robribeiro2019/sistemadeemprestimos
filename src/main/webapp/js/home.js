function init(){
	$.get("/sisemprestimos/listaContratos", function(data, status){
    //console.log("Data: " + data + "\nStatus: " + status);
	console.log(data);
	var empresario = JSON.parse(data);
	console.log(empresario.numeroDoContrato);
	
  });
}