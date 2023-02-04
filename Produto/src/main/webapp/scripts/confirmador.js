/**
 * Confirmação de exclusão
 * @author Osvaldo Junior
 * 
 */
function confirmar(id){
	let resposta = confirm("Confirma a exclusao deste produto?")
	if(resposta === true){
		window.location.href = "delete?id="+id
	}
}