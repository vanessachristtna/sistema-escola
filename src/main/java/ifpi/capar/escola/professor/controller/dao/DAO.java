package ifpi.capar.escola.professor.controller.dao;

import ifpi.capar.escola.professor.model.Entidade;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface DAO {
    
    public Entidade retornar(int id);
	
    public List<Entidade> consultarTodos();
	
    public void cadastrar(Entidade entidade);
	
    public void excluir(Entidade entidade);
    
    public void excluir(int id);
    
}
