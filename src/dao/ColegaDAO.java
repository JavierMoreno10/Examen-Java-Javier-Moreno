package dao;

import java.sql.SQLException;
import java.util.Collection;

import com.Modelo.Colega.Colega;

public interface ColegaDAO {
	void insertarNuevoColega(Colega colega) throws SQLException;

	void eliminarColegaPorId(int id) throws SQLException;

	void actualizarColega(Colega colega) throws SQLException;

	Colega consultarColegaPorId(int id) throws SQLException;

	Collection<Colega> consultarTodosLosColegas() throws SQLException;

}


