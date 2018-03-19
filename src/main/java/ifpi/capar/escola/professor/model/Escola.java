package ifpi.capar.escola.professor.model;

/**
 *
 * @author Usuario
 */
public class Escola extends Entidade {

    private String nome, diretor;

    public Escola(int id, String nome, String diretor){
        this.id = id;
        this.nome = nome;
        this.diretor = diretor;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getDiretor(){
        return diretor;
    }
    
}
