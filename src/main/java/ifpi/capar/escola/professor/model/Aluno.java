/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpi.capar.escola.professor.model;

/**
 *
 * @author Usuario
 */
public class Aluno extends Entidade {
    
    private String nome;
    private int sala;
    
    public Aluno(int id, String nome, int sala){
        
        this.id = id;
        this.nome = nome;
        this.sala = sala;
        
    }
    
    public String getNome(){
        return nome;
    }
    public int getSala(){
        return sala;
    }
    
}
