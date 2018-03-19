package ifpi.capar.escola.professor.controller.dao;

import ifpi.capar.escola.professor.controller.db.Banco;
import ifpi.capar.escola.professor.model.Aluno;
import ifpi.capar.escola.professor.model.Entidade;

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
public class AlunoDAO implements DAO {

    @Override
    public Entidade retornar(int id) {
        Entidade aluno = null;
		
		try {
			Connection conexao = Banco.getConexao();
			String sql = "SELECT * FROM aluno WHERE id_aluno=?";
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			declaracao.setInt(1, id);
			ResultSet retorno = declaracao.executeQuery();
			
			for(;retorno.next();) {
				aluno = new Aluno(id, retorno.getString(2), retorno.getInt(3));
			}
			
			return aluno;
			
		}
		catch(SQLException e) {
			System.out.println("Erro de SQL.");
		}

		
		return null;
    }

    @Override
    public List<Entidade> consultarTodos() {
        List<Entidade> alunos = new ArrayList<Entidade>();
		
		try {
			Connection conexao = Banco.getConexao();
			String sql = "SELECT * FROM aluno";
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			ResultSet retorno = declaracao.executeQuery();
			
			for(;retorno.next();) {
				alunos.add(new Aluno(
						retorno.getInt(1),
						retorno.getString(2),
						retorno.getInt(3)
						));
			}
			
			return alunos;
			
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
			if(entidade.getId() == 0) sql = "INSERT INTO aluno VALUES(default,?,?)";
			else sql = "INSERT INTO aluno VALUES(?,?,?)";
			
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			
			if(entidade.getId() != 0) {
				declaracao.setInt(1, entidade.getId());
				declaracao.setString(2, ((Aluno) entidade).getNome());
				declaracao.setInt(3, ((Aluno) entidade).getSala());
			}
			else {
				declaracao.setString(1, ((Aluno) entidade).getNome());
				declaracao.setInt(2, ((Aluno) entidade).getSala());	
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
			String sql = "DELETE FROM aluno WHERE id_aluno=?";
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			
			declaracao.setInt(1, entidade.getId());
			
			declaracao.execute();
			
		}
		catch(SQLException e) {
			System.out.println("Erro de SQL.");
		}
    }
    
    @Override
    public void excluir(int id){
        try {
			Connection conexao = Banco.getConexao();
			String sql = "DELETE FROM aluno WHERE id_aluno=?";
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			
			declaracao.setInt(1, id);
			
			declaracao.execute();
			
		}
		catch(SQLException e) {
			System.out.println("Erro de SQL.");
		}
    }
    
}
