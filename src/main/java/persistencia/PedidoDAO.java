package persistencia;

import java.io.Serializable;
import java.util.List;
import org.hibernate.*;
import beans.Pedido;

public class PedidoDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void inserir(Pedido pedido) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(pedido);
		t.commit();
		sessao.close();
	}

	public static void alterar(Pedido pedido) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(pedido);
		t.commit();
		sessao.close();
	}

	public static void excluir(Pedido pedido) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(pedido);
		t.commit();
		sessao.close();
	}

	public static List<Pedido> listagem(String filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if (filtro.trim().length() == 0) {
			consulta = sessao.createQuery("from Pedido order by pedido_id");
		} 
		
		else {
			consulta = sessao.createQuery("from Pedido " + "where pessoa_id = :parametro order by pedido_id");
			consulta.setString("parametro", "%" + filtro + "%");
		}

		List lista = consulta.list();
		sessao.close();
		return lista;
	}

}