
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fatec
 */
public abstract class Pessoa implements iPessoa{
    private String nome;
    private int telefone;
    private String sexo;
    private Endereco endereco;

    /**
     * @return the nome
     */
    protected String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    protected void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    protected int getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    protected void setTelefone(int telefone){
        this.telefone = telefone;
    }

    /**
     * @return the sexo
     */
    protected String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    protected void setSexo(String sexo) {
        if (sexo.equalsIgnoreCase("F")) {
            this.sexo = "FEMININO";
        }
        if (sexo.equalsIgnoreCase("M")) {
            this.sexo = "MASCULINO";
        }
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public abstract String exibir(ArrayList pessoas);

//    public String exibir(ArrayList pessoas) {
//        if (pessoas.isEmpty()) {
//            return "Não há registros.";
//        } else {
//            for (int i = 0; i < pessoas.size(); i++) {
//                Pessoa p = (Pessoa) pessoas.get(i);
//                System.out.println("ID: " + pessoas.indexOf(p) + 1);
//                System.out.println("Nome: " + p.getNome());
//                System.out.println("Telefone: " + p.getTelefone());
//                System.out.println("Sexo: " + p.getSexo());
//                System.out.println("Endereço:\nRua: " + p.getEndereco().getRua()
//                        + "          Número: " + p.getEndereco().getNumero()
//                        + "\nBairro: " + p.getEndereco().getBairro()
//                        + "          Cidade: " + p.getEndereco().getCidade()
//                        + "          UF: " + p.getEndereco().getUf());
//            }
//        }
//        return "";
//    }

    @Override
    public ArrayList exibirTodos(ArrayList todos) {
        if (todos.isEmpty()){
            return todos;
        }
        else{
            for (int i = 0; i < todos.size(); i++){
                Pessoa pessoa = (Pessoa) todos.get(i);
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("Telefone: " + pessoa.getTelefone());
                System.out.println("————————————————————————————————");
            }
        }
        return todos;
    }

}
