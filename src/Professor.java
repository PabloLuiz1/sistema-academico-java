
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fatec
 */
public class Professor extends Pessoa {

    /**
     * @return the ha
     */
    public HashMap<Enum.Cursos, ArrayList> getHa() {
        return ha;
    }

    /**
     * @param ha the ha to set
     */
    public void setHa(HashMap<Enum.Cursos, ArrayList> ha) {
        this.ha = ha;
    }
    private String registro;
    private String disciplina;
    private HashMap<Enum.Cursos, ArrayList> ha;

    /**
     * @return the registro
     */
    public String getRegistro() {
        return registro;
    }

    /**
     * @param registro the registro to set
     */
    public void setRegistro(String registro) {
        this.registro = registro;
    }

    /**
     * @return the nome
     */
    /**
     * @return the disciplina
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String exibir(ArrayList pessoas) {
        if (pessoas.isEmpty()) {
            return "Não há registros de professores.";
        } else {
            for (int i = 0; i < pessoas.size(); i++) {
                Professor p = (Professor) pessoas.get(i);
                System.out.println("Registro: " + p.getRegistro());
                System.out.println("ID: " + pessoas.indexOf(p) + 1);
                System.out.println("Nome: " + p.getNome());
                System.out.println("Telefone: " + p.getTelefone());
                System.out.println("Sexo: " + p.getSexo());
                System.out.println("Endereço:\nRua: " + p.getEndereco().getRua()
                        + "          Número: " + p.getEndereco().getNumero()
                        + "\nBairro: " + p.getEndereco().getBairro()
                        + "          Cidade: " + p.getEndereco().getCidade()
                        + "          UF: " + p.getEndereco().getUf());
                if (ha.get(Enum.Cursos.AGRO) == null) {
                    System.out.println("Curso: " + Enum.Cursos.ADS.toString());
                    System.out.println("Disciplinas: " + ha.get(Enum.Cursos.ADS));
                } else if (ha.get(Enum.Cursos.ADS) == null) {
                    System.out.println("Curso: " + Enum.Cursos.AGRO.toString());
                    System.out.println("Disciplinas: " + ha.get(Enum.Cursos.AGRO));
                } else {
                    System.out.println("Curso: " + Enum.Cursos.ADS.toString());
                    System.out.println("Disciplinas: " + ha.get(Enum.Cursos.ADS));
                    System.out.println("Curso: " + Enum.Cursos.AGRO.toString());
                    System.out.println("Disciplinas: " + ha.get(Enum.Cursos.AGRO));
                }
                System.out.println("————————————————————————————————");
            }
            return "";
        }
    }
}
