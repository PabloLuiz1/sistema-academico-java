/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author Fatec
 */
public class Aluno extends Pessoa {

    private String ra;
    private String curso;

    /**
     * @return the ra
     */
    public String getRa() {
        return ra;
    }

    /**
     * @param ra the ra to set
     */
    public void setRa(String ra) {
        this.ra = ra;
    }

    /**
     * @return the nome
     */
    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the endereco
     */
    public String exibir(ArrayList pessoas) {
        if (pessoas.isEmpty()) {
            return "Não há registros de alunos.";
        } else {
            for (int i = 0; i < pessoas.size(); i++) {
                Aluno a = (Aluno) pessoas.get(i);
                System.out.println("ID: " + pessoas.indexOf(a) + 1);
                System.out.println("Nome: " + a.getNome());
                System.out.println("Telefone: " + a.getTelefone());
                System.out.println("Sexo: " + a.getSexo());
                System.out.println("Endereço:\nRua: " + a.getEndereco().getRua()
                        + "          Número: " + a.getEndereco().getNumero()
                        + "\nBairro: " + a.getEndereco().getBairro()
                        + "          Cidade: " + a.getEndereco().getCidade()
                        + "          UF: " + a.getEndereco().getUf());
                System.out.println("RA: " + a.getRa());
                System.out.println("Curso: " + a.getCurso());
                System.out.println("————————————————————————————————");
            }
        }
        return "";
    }
}
