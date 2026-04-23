package br.edu.ifsc.fln.model.dao;

import br.edu.ifsc.fln.model.domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Modelo modelo) {
        String sql = "INSERT INTO modelo(descricao, marca_id, categoria, potencia, tipo_combustivel) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, modelo.getDescricao());
            stmt.setInt(2, modelo.getMarca().getId());
            stmt.setString(3,modelo.getCategoria().name());
            stmt.setInt(4,modelo.getMotor().getPotencia());
            stmt.setString(5,modelo.getMotor().getTipoCombustivel().name());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Modelo modelo) {
        String sql = "UPDATE modelo SET " +
                "descricao=?, marca_id=?, categoria=?, potencia=?, tipo_combustivel=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, modelo.getDescricao());
            stmt.setInt(2, modelo.getMarca().getId());
            stmt.setString(3,modelo.getCategoria().name());
            stmt.setInt(4,modelo.getMotor().getPotencia());
            stmt.setString(5,modelo.getMotor().getTipoCombustivel().name());
            stmt.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Modelo modelo) {
        String sql = "DELETE FROM modelo WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, modelo.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Modelo> listar() {
        String sql = """
        SELECT
        mrc.id AS id_marca,
        mrc.nome AS nome_marca,
        mdl.id AS id_modelo,
        mdl.descricao AS descricao_modelo,
        mdl.categoria AS categoria_modelo,
        mdl.potencia AS potencia_motor,
        mdl.tipo_combustivel AS combustivel_motor
        FROM modelo mdl INNER JOIN marca mrc ON mdl.marca_id = mrc.id ORDER BY mdl.id
        """;

        List<Modelo> modelos = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Modelo modelo = populateVO(resultado);
                modelos.add(modelo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelos;
    }

    public Modelo buscar(Modelo modelo) {
        Modelo retorno = buscar(modelo.getId());
        return retorno;
    }

    public Modelo buscar(int id) {
        String sql = """
        SELECT
        mrc.id AS id_marca,
        mrc.nome AS nome_marca,
        mdl.id AS id_modelo,
        mdl.descricao AS descricao_modelo,
        mdl.categoria AS categoria_modelo,
        mdl.potencia AS potencia_motor,
        mdl.tipo_combustivel AS combustivel_motor
        FROM modelo mdl INNER JOIN marca mrc ON mdl.marca_id = mrc.id WHERE mdl.id=? ORDER BY mdl.id  
        """;

        Modelo modelo = new Modelo();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                modelo = populateVO(resultado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

    private Modelo populateVO(ResultSet rs) throws SQLException {
        Modelo modelo = new Modelo();
        Marca marca = new Marca();
        modelo.setMarca(marca);

        marca.setId(rs.getInt("id_marca"));
        marca.setNome(rs.getString("nome_marca"));
        modelo.setId(rs.getInt("id_modelo"));
        modelo.setDescricao(rs.getString("descricao_modelo"));
        modelo.setCategoria(Enum.valueOf(ECategoria.class, rs.getString("categoria_modelo")));
        modelo.getMotor().setPotencia(rs.getInt("potencia_motor"));
        modelo.getMotor().setTipoCombustivel(Enum.valueOf(ETipoCombustivel.class, rs.getString("combustivel_motor")));

        return modelo;
    }
}

