package Negocio;

import java.sql.SQLException;
import java.util.Collection;

import com.Modelo.Colega.Colega;

public interface NegocioColegasInterfaz {

	void darDeAltaNuevoColega(Colega colega) throws SQLException;

	void darDeBajaColegaPorId(int id) throws SQLException;

	void modificarUnColega(Colega colega) throws SQLException;

	Colega verColega(int id) throws SQLException;

	Collection<Colega> verTodosLosColegas() throws SQLException;

}
