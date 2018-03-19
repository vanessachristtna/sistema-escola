package ifpi.capar.escola.professor.controller.dao;

import ifpi.capar.escola.professor.controller.db.Banco;
import ifpi.capar.escola.professor.model.Entidade;
import ifpi.capar.escola.professor.model.Escola;
import ifpi.capar.escola.professor.model.Professor;
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
public class ProfessorDAO implements DAO {

    @Override
    public Entidade retornar(int id) {
        Entidade professor = null;
		
		try {
			Connection conexao = Banco.getConexao();
			String sql = "SELECT * FROM professor WHERE cod_prof=?";
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			declaracao.setInt(1, id);
			ResultSet retorno = declaracao.executeQuery();
			
			for(;retorno.next();) {
				professor = new Professor(id, retorno.getInt(2), retorno.getString(3));
			}
			
			return professor;
			
		}
		catch(SQLException e) {
			System.out.println("Erro de SQL.");
		}

		
		return null;
    }

    @Override
    public List<Entidade> consultarTodos() {
        List<Entidade> professores = new ArrayList<Entidade>();
		
		try {
			Connection conexao = Banco.getConexao();
			String sql = "SELECT * FROM professor";
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			ResultSet retorno = declaracao.executeQuery();
			
			for(;retorno.next();) {
				professores.add(new Professor(
						retorno.getInt(1),
						retorno.getInt(2),
						retorno.getString(3)
						));
			}
			
			return professores;
			
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
			if(entidade.getId() == 0) sql = "INSERT INTO professor VALUES(default,?,?)";
			else sql = "INSERT INTO professor VALUES(?,?,?)";
			
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			
			if(entidade.getId() != 0) {
				declaracao.setInt(1, entidade.getId());
				declaracao.setInt(2, ((Professor) entidade).getEscola());
				declaracao.setString(3, ((Professor) entidade).getHorario());
			}
			else {
				declaracao.setInt(1, ((Professor) entidade).getEscola());
				declaracao.setString(2, ((Professor) entidade).getHorario());	
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
			String sql = "DELETE FROM professor WHERE cod_prof=?";
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
			String sql = "DELETE FROM professor WHERE cod_prof=?";
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			
			declaracao.setInt(1, id);
			
			declaracao.execute();
			
		}
		catch(SQLException e) {
			System.out.println("Erro de SQL.");
		}
    }
    
}
