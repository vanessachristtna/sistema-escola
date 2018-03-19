package ifpi.capar.escola.professor.controller.dao;

import ifpi.capar.escola.professor.controller.db.Banco;
import ifpi.capar.escola.professor.model.Entidade;
import ifpi.capar.escola.professor.model.Escola;

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
public class EscolaDAO implements DAO {

    @Override
    public Entidade retornar(int id) {
        Entidade escolas = null;
		
		try {
			Connection conexao = Banco.getConexao();
			String sql = "SELECT * FROM escolas WHERE id_escola=?";
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			declaracao.setInt(1, id);
			ResultSet retorno = declaracao.executeQuery();
			
			for(;retorno.next();) {
				escolas = new Escola(id, retorno.getString(2), retorno.getString(3));
			}
			
			return escolas;
			
		}
		catch(SQLException e) {
			System.out.println("Erro de SQL.");
		}

		
		return null;
    }

    @Override
    public List<Entidade> consultarTodos() {
        List<Entidade> escolas = new ArrayList<Entidade>();
		
		try {
			Connection conexao = Banco.getConexao();
			String sql = "SELECT * FROM escola";
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			ResultSet retorno = declaracao.executeQuery();
			
			for(;retorno.next();) {
				escolas.add(new Escola(
						retorno.getInt(1),
						retorno.getString(2),
						retorno.getString(3)
						));
			}
			
			return escolas;
			
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
			if(entidade.getId() == 0) sql = "INSERT INTO escola VALUES(default,?,?)";
			else sql = "INSERT INTO escola VALUES(?,?,?)";
			
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			
			if(entidade.getId() != 0) {
				declaracao.setInt(1, entidade.getId());
				declaracao.setString(2, ((Escola) entidade).getNome());
				declaracao.setString(3, ((Escola) entidade).getDiretor());
			}
			else {
				declaracao.setString(1, ((Escola) entidade).getNome());
				declaracao.setString(2, ((Escola) entidade).getDiretor());	
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
			String sql = "DELETE FROM aluno WHERE id_escola=?";
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
			String sql = "DELETE FROM escola WHERE id_escola=?";
			PreparedStatement declaracao = conexao.prepareStatement(sql);
			
			declaracao.setInt(1, id);
			
			declaracao.execute();
			
		}
		catch(SQLException e) {
			System.out.println("Erro de SQL.");
		}
    }
    
}
