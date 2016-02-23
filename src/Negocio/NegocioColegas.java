package Negocio;

import java.sql.SQLException;
import java.util.Collection;

import com.Modelo.Colega.Colega;

import dao.ColegaDAO;

public class NegocioColegas implements NegocioColegasInterfaz {

	private ColegaDAO colegaDAO;

	public NegocioColegas(ColegaDAO colegaDao, ColegaDAO colegaDAO) {
		super();
		this.colegaDAO = colegaDAO;
	}

	public void darDeAltaNuevoColega(Colega colega) throws SQLException {
		colegaDAO.insertarNuevoColega(colega);

	}

	public void darDeBajaColegaPorId(int id) throws SQLException {
		colegaDAO.eliminarColegaPorId(id);

	}

	public void modificarUnColega(Colega colega) throws SQLException {

		colegaDAO.actualizarColega(colega);

	}

	public Colega verColega(int id) throws SQLException {
		return colegaDAO.consultarColegaPorId(id);

	}

	public Collection<Colega> verTodosLosColegas() throws SQLException {
		return colegaDAO.consultarTodosLosColegas();

	}

}
