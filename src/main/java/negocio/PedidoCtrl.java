package negocio;

import beans.Fone;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.*;
import persistencia.PedidoDAO;
import beans.Pedido;
import beans.PedidoItens;
import beans.Produto;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped

public class PedidoCtrl implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getListagem() {
        return PedidoDAO.listagem("");
    }

    public String actionGravar() {
        if (pedido.getId() == 0) {
            PedidoDAO.inserir(pedido);
            return actionInserir();
        } else {
            PedidoDAO.alterar(pedido);
            return "lista_pedido";
        }
    }

    public String actionInserir() {
        pedido = new Pedido();
        return "form_pedido";
    }

    public String actionExcluir(Pedido p) {
        PedidoDAO.excluir(p);
        addMessage("Sucesso", "Pedido removido com sucesso!");
        return "lista_pedido";
    }

    public String actionAlterar(Pedido p) {
        pedido = p;
        return "form_pedido";
    }

/*    public String actionInserirItens(produto) {
        PedidoItens itens = new PedidoItens();
        itens.setPedido(pedido);
        itens.getProduto().add(produto)
        return "form_pedido";
    }*/

    
    
        public String carrinho(Produto p) {
        	PedidoItens itens = new PedidoItens();
        	List<Produto> produtos = new ArrayList<Produto>(); 
        	produtos.add(p);
            addMessage("Sucesso", "Produto Incluído no carrinho");
            return "index.xhtml";
        }
    
    public String actionExcluirFone(Fone f) {
        
        return "form_pedido";
        
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
