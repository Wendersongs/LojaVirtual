package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "pedido_itens")

public class PedidoItens implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ped_itens_id")
    private int id;
    @Column(name = "quantidade", length = 20, nullable = true)
    private int quantidade;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;

    }
    
    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;

    }
    
    @OneToMany (mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Produto> produtos = new ArrayList<Produto>();

    public List<Produto> getProduto() {
        return produtos;
    }

    public void setProduto(List<Produto> produtos) {
        this.produtos = produtos;
    }  
    
}
