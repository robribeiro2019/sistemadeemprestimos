function init(nCliente, nColetor) {
	
	$("#clienteId").val(nCliente);
	$("#coletorId").val(nColetor);
};

//Funcção para coletar o path atual para os serviços
function getContextPath() {
	return window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/";
}

$(function() {
 
 	//Ao digitar o valor do emprestimo, preenche o valor do emprestimo devido
	$("#montanteEmprestimo").on('focusout', function(){
  		$("input[name='montanteDoEmprestimoDevido']").attr('value', $("#montanteEmprestimo").val());
 	})
 	
 	//Ao escolher o banco, coleta a taxa de juros
	$("#coletorId").on('change', function(){

		$.ajax({
		     url : getContextPath() + "coletor/consultarColetor/" + $("#coletorId").val(),
		     cache: false,
		     type : 'GET'
		})
		.done(function(data){
		     $("#txJuros").val(data.taxaDeJuros);
		});

 	})
});

function goToHome(){
	location.href="/sisemprestimos/";
}

function goToNew(){
	location.href="/sisemprestimos/novo"
}

function formatDate(date){

	if(date == '' 
		|| date == 'undefined') {
		document.write('');
		return;
	}
	
	document.write($.format.date(date + ' 00:00:00.000', 'dd/MM/yyyy'));
}