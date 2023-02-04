/**
 * Validação de formulário
 * @autor Osvaldo Junior
 */
function validar(){
	let nome = frmProduto.nome.value
	let preco = frmProduto.preco.value
	let quantity = frmProduto.quantidade.value
	if(nome === ""){
		alert("Preencha o nome!")
		frmProduto.nome.focus()
		return false
	}else if(preco === ""){
		alert("Insira o preco!")
		frmProduto.preco.focus()
		return false
	}else if(quantity < 0){
		alert("Quantidade inferior a zero não possivel")
		frmProduto.quantidade.focus()
		return false
	} else if(preco <= 0){
		alert("Não pode valor inferior a zero")
		frmProduto.preco.focus()
		return false	
	} else{
		document.forms["frmProduto"].submit()
	}
	
}


