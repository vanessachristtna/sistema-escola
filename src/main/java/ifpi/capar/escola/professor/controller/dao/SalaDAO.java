package ifpi.capar.escola.professor.controller.dao;

import ifpi.capar.escola.professor.controller.db.Banco;
import ifpi.capar.escola.professor.model.Entidade;
import ifpi.capar.escola.professor.model.Escola;
import ifpi.capar.escola.professor.model.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class SalaDAO implements DAO {

    @Override
    public Entidade retornar(int id) {
        Entidade sala = null;
		
		try {
			Connection conexao = Banco.getConexao();
			String sql = "SELECT * FROM sala WHERE id_sala=?";
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			declaracao.setInt(1, id);
			ResultSet retorno = declaracao.executeQuery();
			
			for(;retorno.next();) {
				sala = new Sala(id, retorno.getInt(2), retorno.getInt(3));
			}
			
			return sala;
			
		}
		catch(SQLException e) {
			System.out.println("Erro de SQL.");
		}

		return null;
    }

    @Override
    public List<Entidade> consultarTodos() {
        List<Entidade> salas = new ArrayList<Entidade>();
		
		try {
			Connection conexao = Banco.getConexao();
			String sql = "SELECT * FROM sala";
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			ResultSet retorno = declaracao.executeQuery();
			
			for(;retorno.next();) {
				salas.add(new Sala(
						retorno.getInt(1),
						retorno.getInt(2),
						retorno.getInt(3)
						));
			}
			
			return salas;
			
		}
		catch(SQLException e) {
			System.out.println("Erro de SQL.");
		}
		
		return null;        
    }

    @Override
    public void cadastrar(Entidade entidade) {
                try {
			Connection conexao = Banco.getConexao();

			String sql;
			if(entidade.getId() == 0) sql = "INSERT INTO sala VALUES(default,?,?)";
			else sql = "INSERT INTO sala VALUES(?,?,?)";
			
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			
			if(entidade.getId() != 0) {
				declaracao.setInt(1, entidade.getId());
				declaracao.setInt(2, ((Sala) entidade).getEscola());
				declaracao.setInt(3, ((Sala) entidade).getProfessor());
			}
			else {
				declaracao.setInt(1, ((Sala) entidade).getEscola());
				declaracao.setInt(2, ((Sala) entidade).getProfessor());	
			}
			
			declaracao.execute();
			
		}
		catch(SQLException e) {
			System.out.println("Erro de SQL.");
			e.printStackTrace();
		}
    }

    @Override
    public void excluir(Entidade entidade) {
        try {
			Connection conexao = Banco.getConexao();
			String sql = "DELETE FROM sala WHERE id_sala=?";
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			
			declaracao.setInt(1, entidade.getId());
			
			declaracao.execute();
			
		}
		catch(SQLException e) {
			System.out.println("Erro de SQL.");
		}
    }

    @Override
    public void excluir(int id) {
        try {
			Connection conexao = Banco.getConexao();
			String sql = "DELETE FROM sala WHERE id_sala=?";
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			
			declaracao.setInt(1, id);
			
			declaracao.execute();
			
		}
		catch(SQLException e) {
			System.out.println("Erro de SQL.");
		}
    }
    
}
