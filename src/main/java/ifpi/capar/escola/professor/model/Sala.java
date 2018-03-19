package ifpi.capar.escola.professor.model;

/**
 *
 * @author Usuario
 */
public class Sala extends Entidade {

    private int escola, professor;
    
    public Sala(int id, int escola, int professor){
        this.id = id;
        this.escola = escola;
        this.professor = professor;
    }
    
    public int getEscola(){
        return escola;
    }
    
    public int getProfessor(){
        return professor;
    }
    
}
