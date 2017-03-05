package teste;

import beans.Produto;
import negocio.ProdutoCtrl;
import persistencia.ProdutoDAO;

public class Teste {
	
	
	
public static void main (){

	Produto produto = new Produto();
	produto.setNome("Rosca"); 
	produto.setPreco(20);
	ProdutoCtrl p = new ProdutoCtrl();
	ProdutoDAO.inserir(produto);	
}
}
