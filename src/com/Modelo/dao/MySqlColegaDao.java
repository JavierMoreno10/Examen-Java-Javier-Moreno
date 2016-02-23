package com.Modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import javax.sql.DataSource;

import com.Modelo.Colega.Colega;

import dao.ColegaDAO;

public class MySqlColegaDao implements ColegaDAO {

	private static final String INSERT_COLEGA = "INSERT INTO colega (id, nombre, ciudad, fecha) VALUES (?,?,?,?)";
	private static final String DELETE_COLEGA = "DELETE FROM colega WHERE id=?";
	private static final String UPDATE_COLEGA = "UPDATE colega SET nombre=?, ciudad=?, fecha=? WHERE id=?";
	private static final String SELECT_COLEGA_BY_ID = " SELECT * FROM colega WHERE id=?";
	private static final String SELECT_COLEGAS = "SELECT * FROM colega";

	private DataSource ds;

	public MySqlColegaDao(DataSource ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void insertarNuevoColega(Colega colega) throws SQLException {
		Connection connection = null;

		try {

			connection = ds.getConnection();

			PreparedStatement ps = connection.prepareStatement(INSERT_COLEGA);
			ps.setInt(1, colega.getId());
			ps.setString(2, colega.getNombre());
			ps.setString(3, colega.getCiudad());
			ps.setDate(4, new java.sql.Date(colega.getFecha().getTime()));

			ps.executeUpdate();

		} finally {
			if (connection != null) {
				connection.close();
			}
		}

	}

	@Override
	public void actualizarColega(Colega colega) throws SQLException {
		Connection connection = null;

		try {

			connection = ds.getConnection();

			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(UPDATE_COLEGA);

			ps.setString(2, colega.getNombre());
			ps.setString(3, colega.getCiudad());
			ps.setDate(4, new java.sql.Date(colega.getFecha().getTime()));
			ps.setInt(1, colega.getId());
			ps.executeUpdate();

		} finally {

			if (connection != null) {
				connection.close();
			}
		}

	}

	@Override
	public void eliminarColegaPorId(int id) throws SQLException {

		Connection connection = null;

		try {

			connection = ds.getConnection();

			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(DELETE_COLEGA);
			ps.setInt(1, id);

			ps.executeUpdate();

		} finally {

			if (connection != null) {
				connection.close();
			}
		}

	}

	@Override
	public Colega consultarColegaPorId(int id) throws SQLException {
		Connection connection = null;

		try {

			connection = ds.getConnection();

			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(SELECT_COLEGA_BY_ID);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {

				return new Colega(id, rs.getString("nombre"), rs.getString("ciudad"), rs.getDate("fecha"));

			}
			return null;

		} finally {

			if (connection != null) {
				connection.close();
			}
		}

	}

	@Override
	public Collection<Colega> consultarTodosLosColegas() throws SQLException {

		Collection<Colega> resultado = new HashSet<>();

		Connection connection = null;

		try {

			connection = ds.getConnection();

			java.sql.PreparedStatement ps = connection.prepareStatement(SELECT_COLEGAS);

			ResultSet rs = ps.executeQuery();

			if (rs.first()) {

				do {

					Colega colega = new Colega(rs.getInt("id"), rs.getString("nombre"), rs.getString("ciudad"),
							rs.getDate("Edad"));
					resultado.add(colega);
				} while (rs.next());
			}
			return resultado;
		} finally {

			if (connection != null) {
				connection.close();
			}
		}

	}

}

