package ifpi.capar.escola.professor.model;

/**
 *
 * @author Usuario
 */
public class Professor extends Entidade {

    int escola;
    String horario;
    
    public Professor(int id, int escola, String horario){
        this.id = id;
        this.escola = escola;
        this.horario = horario;
    }
    
    public int getEscola(){
        return escola;
    }
    
    public String getHorario(){
        return horario;
    }
    
}
