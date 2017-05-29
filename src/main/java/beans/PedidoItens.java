package beans;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "fone")

public class PedidoItens implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fon_id")
    private int id;
    @Column(name = "fon_numero", length = 20, nullable = true)
    private String numero;
    @Column(name = "fon_descricao", length = 30, nullable = true)
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;

    }
}
