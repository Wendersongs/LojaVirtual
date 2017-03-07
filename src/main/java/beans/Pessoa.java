package beans;

import java.io.Serializable;
import javax.persistence.*;


	@Entity
	@Table(name = "pessoa")
	public class Pessoa implements Serializable {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "pessoa_id")
		private int id;
		@Column(name = "pessoa_nome", length = 60, nullable = true)
		private String nome;
		@Column(name = "pessoa_endereco", nullable = true)
		
		private String endereco;

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

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
	}


