package beans;

import javax.persistence.*;


	@Entity
	@Table(name = "produto")
	public class Produto {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "pro_id")
		private int id;
		@Column(name = "pro_nome", length = 60, nullable = true)
		private String nome;
		@Column(name = "pro_preco", nullable = true)
		
		private float preco;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public float getPreco() {
			return preco;
		}

		public void setPreco(float preco) {
			this.preco = preco;
		}
		
	    @ManyToOne
	    @JoinColumn(name = "produto_id")
	    private PedidoItens pedidoItens;

	    public PedidoItens getPedidoItens() {
	        return pedidoItens;
	    }

	    public void setPedidoItens(PedidoItens pedidoItens) {
	        this.pedidoItens = pedidoItens;

	    }
	}


