
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
public class SistemaAcademico extends Enum {

    static HashMap<Cursos, ArrayList> hm = new HashMap();
    static Scanner in = new Scanner(System.in);
    static Aluno a = new Aluno();
    static Endereco end;
    static Professor p = new Professor();
    static ArrayList vetDisciplinas = new ArrayList();
    static ArrayList<Aluno> alunos = new ArrayList();
    static ArrayList<Professor> professores = new ArrayList();
    SistemaAcademico s = new SistemaAcademico();

    public static void menuProfessor() {
        System.out.println("Menu de professor:\n1 - Cadastrar\n2 - Consultar\n"
                + "3 - Pesquisar por registro\n4 - Editar\n5 - Excluir\n6 - Voltar");
        try {
            int opcao, indice, n = 0;
            String resposta = "s";
            String disciplina;
            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    p = new Professor();
                    end = new Endereco();
                    String curso = "";
                    System.out.println("Cadastro de professor:\n");
                    System.out.print("Digite o nome: ");
                    p.setNome(in.next());
                    System.out.print("Digite o registro: ");
                    p.setRegistro(in.next());
                    while (resposta.equalsIgnoreCase("s")) {
                        System.out.println("Digite o curso:\n1 - ADS\n2 - AGRO");
                        n = in.nextInt();
                        switch (n) {
                            default:
                                System.err.println("Curso inválido, cancelando o cadastro todo.");
                                menuProfessor();
                                break;
                            case 1:
                                curso = Cursos.ADS.toString();
                                break;
                            case 2:
                                curso = Cursos.AGRO.toString();
                                break;
                        }
                        System.out.println("Digite as disciplinas do curso " + curso + ":\nDigite FIM quando terminar.");
                        do {
                            disciplina = in.next();
                            if (disciplina.equalsIgnoreCase("FIM")) {
                                break;
                            }
                            vetDisciplinas.add(disciplina);
                        } while (true);
                        if (curso.equals(Cursos.ADS.toString())) {
                            hm.put(Cursos.ADS, vetDisciplinas);
                            curso = "";
                            vetDisciplinas = new ArrayList();
                        }
                        if (curso.equals(Cursos.AGRO.toString())) {
                            hm.put(Cursos.AGRO, vetDisciplinas);
                            curso = "";
                            vetDisciplinas = new ArrayList();
                        }
                        System.out.println("Deseja cadastrar outro curso e disciplinas?\nS - SIM\nN - NÃO");
                        resposta = in.next();
                    }
                    System.out.println(hm.get(Cursos.ADS));
                    System.out.println(hm.get(Cursos.AGRO));
                    p.setHa(hm);
                    hm = new HashMap();
                    System.out.println("Endereço do professor: ");
                    System.out.print("Digite o UF: ");
                    end.setUf(in.next());
                    System.out.print("Digite a cidade: ");
                    end.setCidade(in.next());
                    System.out.print("Digite o bairro: ");
                    end.setBairro(in.next());
                    System.out.print("Digite a rua: ");
                    end.setRua(in.next());
                    System.out.print("Digite o número: ");
                    end.setNumero(in.next());
                    p.setEndereco(end);
                    System.out.print("Digite o telefone: ");
                    int telefone;
                    try {
                        telefone = in.nextInt();
//                        p.setTelefone(in.nextInt());
                        System.out.print("Digite o sexo: (F para FEMININO e M para MASCULINO)");
                        p.setSexo(in.next().toUpperCase());
                        cadastrar(p);
                        menuProfessor();
                    } catch (Exception e) {
                        System.err.println("Digite apenas números inteiros. ");
                    }

                    break;
                case 2:
                    //System.err.println(consultarProfessores(professores));
                    if (professores.isEmpty()) {
                        System.err.println("Não há registros de professores.");
                    } else {
                        p.exibir(professores);
                    }
                    menuProfessor();
                    break;
                case 3:
                    Professor pro = new Professor();
                    if (p.exibir(professores).length() > 0) {
                        System.err.println(p.exibir(professores));
                        menuProfessor();
                    } else {
                        System.out.println("Digite o registro do professor que deseja pesquisar: ");
                        pro.setRegistro(in.next());
                        pesquisar(pro);
                    }
                    break;
                case 4:
                    Professor professor;
                    if (p.exibir(professores).length() > 0) {
                        System.err.println(p.exibir(professores));
                        menuProfessor();
                    } else {
                        do {
                            System.out.println("Digite o ID do professor que deseja editar: ");
                            indice = in.nextInt();
                            professor = professores.get(indice - 1);
                        } while (professor == null);
                        System.out.println("Editando o professor de ID: " + (indice));
                        System.out.print("Digite o nome: ");
                        professor.setNome(in.next());
                        System.out.print("Digite o registro: ");
                        professor.setRegistro(in.next());
                        System.out.print("Digite a disciplina: ");
                        professor.setDisciplina(in.next());
                        System.out.println("Endere�o do professor: ");
                        System.out.print("Digite o UF: ");
                        end.setUf(in.next());
                        System.out.print("Digite a cidade: ");
                        end.setCidade(in.next());
                        System.out.print("Digite o bairro: ");
                        end.setBairro(in.next());
                        System.out.print("Digite a rua: ");
                        end.setRua(in.next());
                        System.out.print("Digite o n�mero: ");
                        end.setNumero(in.next());
                        professor.setEndereco(end);
                        System.out.print("Digite o telefone: ");
                        professor.setTelefone(in.nextInt());
                        System.out.print("Digite o sexo: (F para FEMININO e M para MASCULINO)");
                        professor.setSexo(in.next().toUpperCase());
                        editar(professor, indice);
                        System.out.println("Professor de ID " + indice + " editado com sucesso.");
                        professor = null;
                        menuProfessor();
                    }
                    break;
                case 5:
                    if (p.exibir(professores).length() > 0) {
                        System.err.println(p.exibir(professores));
                        menuProfessor();
                    } else {
                        System.out.println("Digite o ID do professor que deseja excluir: ");
                        indice = in.nextInt();
                        indice--;
                        Professor prof = professores.get(indice);
                        excluir(indice, prof);
                        menuProfessor();
                    }
                    break;
                case 6:
                    menuPrincipal();
                    break;
                default:
                    System.err.println("OPÇÃO INVÁLIDA.");
                    menuProfessor();
                    break;
            }
        } catch (Exception e) {
            System.err.println("Digite apenas números inteiros.");
        }
    }

    static void menuAluno() {
        int opcao, indice;
        Scanner in = new Scanner(System.in);
        System.out.println("Menu de aluno:\n1 - Cadastrar\n2 - Consultar\n"
                + "3 - Pesquisar por RA\n4 - Editar\n5 - Excluir\n6 - Voltar");
        try {
            opcao = in.nextInt();
            in.reset();
            switch (opcao) {
                case 1:
                    in.reset();
                    String teste;
                    a = new Aluno();
                    end = new Endereco();
                    System.out.println("Cadastro de aluno:");
                    System.out.println("Digite o nome: ");
                    a.setNome(in.nextLine());
                    System.out.println();
                    System.out.print("Digite o RA: ");
                    a.setRa(in.next());
                    System.out.print("Digite o curso: ");
                    a.setCurso(in.next());
                    System.out.println("Endereço do aluno: ");
                    System.out.print("Digite o UF: ");
                    end.setUf(in.next());
                    System.out.print("Digite a cidade: ");
                    end.setCidade(in.next());
                    System.out.print("Digite o bairro: ");
                    end.setBairro(in.next());
                    System.out.print("Digite a rua: ");
                    end.setRua(in.next());
                    System.out.print("Digite o número: ");
                    end.setNumero(in.next());
                    a.setEndereco(end);
                    System.out.print("Digite o telefone: ");
                    a.setTelefone(in.nextInt());
                    System.out.print("Digite o sexo: (F para FEMININO e M para MASCULINO)");
                    a.setSexo(in.next().toUpperCase());
                    cadastrar(a);
                    menuAluno();
                    break;
                case 2:
                    if (alunos.isEmpty()) {
                        System.err.println("Não há registros.");
                    } else {
                        a.exibir(alunos);
                    }
                    menuAluno();
                    break;
                case 3:
                    Aluno al = new Aluno();
                    if (a.exibir(alunos).length() > 1) {
                        System.err.println(a.exibir(alunos));
                        menuAluno();
                    } else {
                        System.out.println("Digite o RA do aluno que deseja pesquisar: ");
                        al.setRa(in.next());
                        pesquisar(al);
                    }
                    break;
                case 4:
                    Aluno aluno;
                    if (a.exibir(alunos).length() > 1) {
                        System.err.println(a.exibir(alunos));
                        menuAluno();
                    } else {
                        do {
                            System.out.println("Digite o ID do aluno que deseja editar: ");
                            indice = in.nextInt();
                            aluno = alunos.get(indice - 1);
                        } while (aluno == null);
                        System.out.println("Editando o aluno de ID: " + (indice));
                        System.out.print("Digite o nome: ");
                        aluno.setNome(in.nextLine());
                        System.out.print("Digite o RA: ");
                        aluno.setRa(in.next());
                        System.out.print("Digite o curso: ");
                        aluno.setCurso(in.next());
                        System.out.println("Endereço do aluno: ");
                        System.out.print("Digite o UF: ");
                        end.setUf(in.next());
                        System.out.print("Digite a cidade: ");
                        end.setCidade(in.next());
                        System.out.print("Digite o bairro: ");
                        end.setBairro(in.next());
                        System.out.print("Digite a rua: ");
                        end.setRua(in.next());
                        System.out.print("Digite o número: ");
                        end.setNumero(in.next());
                        aluno.setEndereco(end);
                        System.out.print("Digite o telefone: ");
                        aluno.setTelefone(in.nextInt());
                        System.out.print("Digite o sexo: (F para FEMININO e M para MASCULINO)");
                        aluno.setSexo(in.next().toUpperCase());
                        editar(aluno, indice);
                        System.out.println("Aluno de ID " + indice + " editado com sucesso.");
                        aluno = null;
                        menuAluno();
                    }
                    break;
                case 5:
                    if (a.exibir(alunos).length() > 1) {
                        System.err.println(a.exibir(alunos));
                        menuAluno();
                    } else {
                        System.out.println("Digite o ID do aluno que deseja excluir: ");
                        indice = in.nextInt();
                        indice--;
                        Aluno alo = alunos.get(indice);
                        excluir(indice, alo);
                        menuAluno();
                    }
                    break;
                case 6:
                    menuPrincipal();
                    break;
                default:
                    System.err.println("OPÇÃO INVÁLIDA.");
                    menuAluno();
                    break;
            }
        } catch (Exception e) {
            System.err.println("Digite apenas números inteiros.");
            menuAluno();
        }
    }

    public static void menuPrincipal() {
        int opcao;
        Scanner in = new Scanner(System.in);
        System.out.println("SISTEMA ACADÊMICO\nMenu principal:\n1 - Aluno\n2 - Professor\n3 - Exibir todos\n4 - Sair");
        try {
            opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    menuAluno();
                    in.reset();
                    break;
                case 2:
                    menuProfessor();
                    in.reset();
                    break;
                case 3:
                    p.exibirTodos(professores);
                    a.exibirTodos(alunos);
                    menuPrincipal();
                    break;
                case 4:
                    System.out.println("Fechando o sistema...");
                    System.exit(0);
                    break;
                default:
                    System.err.println("OPÇÃO INVÁLIDA.");
                    menuPrincipal();
                    break;
            }
        } catch (Exception e) {
            System.err.println("Digite apenas números inteiros.");
            menuPrincipal();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new TelaPrincipal();
        menuPrincipal();

    }

    // operações de cadastro
    public static void cadastrar(Professor p) {
        professores.add(p);
        System.out.println("PROFESSOR " + p.getNome() + " DE REGISTRO "
                + "" + p.getRegistro() + " CADASTRADO COM SUCESSO.");
    }

    public static void cadastrar(Aluno a) {
        alunos.add(a);
        System.out.println("ALUNO " + a.getNome() + " DE RA " + a.getRa() + " CADASTRADO COM SUCESSO.");
    }

    public static void editar(Professor p, int indice) {
        professores.add(indice, p);
    }

    public static void editar(Aluno a, int indice) {
        alunos.add(indice, a);
    }

    public static String consultar() {
        if (professores.isEmpty()) {
            return "Não há registros de professores.";
        }
        for (Professor p : professores) {
            System.out.println("Professor ID " + (professores.indexOf(p) + 1));
            System.out.println("Nome: " + p.getNome());
            System.out.println("Registro: " + p.getRegistro());
            System.out.println("Disciplina: " + p.getDisciplina());
            System.out.println("Endereço do professor:\nUF: " + p.getEndereco().getUf()
                    + "           Cidade: " + p.getEndereco().getCidade()
                    + "           Bairro: " + p.getEndereco().getBairro());
            System.out.println("Rua: " + p.getEndereco().getRua()
                    + "           Número: " + p.getEndereco().getNumero());
            System.out.println("Telefone: " + p.getTelefone());
            System.out.println("Sexo: " + p.getSexo());
            System.out.println("————————————————————————————");
        }
        return "";
    }

    public static String consultar(ArrayList<Aluno> alunos) {
        if (alunos.isEmpty()) {
            return "Não há registros de alunos.";
        }
        for (Aluno a : alunos) {
            System.out.println("Aluno ID " + (alunos.indexOf(a) + 1));
            System.out.println("Nome: " + a.getNome());
            System.out.println("RA: " + a.getRa());
            System.out.println("Curso: " + a.getCurso());
            System.out.println("Endere�o do aluno:\nUF: " + a.getEndereco().getUf()
                    + "           Cidade: " + a.getEndereco().getCidade()
                    + "           Bairro: " + a.getEndereco().getBairro());
            System.out.println("Rua: " + a.getEndereco().getRua()
                    + "           N�mero: " + a.getEndereco().getNumero());
            System.out.println("Telefone: " + a.getTelefone());
            System.out.println("Sexo: " + a.getSexo());
            System.out.println("————————————————————————————");
        }
        return "";
    }

    public static void pesquisar(Aluno a) {
        for (Aluno al : alunos) {
            if (al.getRa().equals(a.getRa())) {
                System.out.println("Resultado: ");
                System.out.println("Aluno ID " + (alunos.indexOf(al) + 1));
                System.out.println("Nome: " + al.getNome());
                System.out.println("RA: " + al.getRa());
                System.out.println("Curso: " + al.getCurso());
                System.out.println("Endere�o do aluno:\nUF: " + al.getEndereco().getUf()
                        + "           Cidade: " + al.getEndereco().getCidade()
                        + "           Bairro: " + al.getEndereco().getBairro());
                System.out.println("Rua: " + al.getEndereco().getRua()
                        + "           N�mero: " + al.getEndereco().getNumero());
                System.out.println("Telefone: " + al.getTelefone());
                System.out.println("Sexo: " + al.getSexo());
                System.out.println("————————————————————————————");
                menuAluno();
            } else {
                System.err.println("Nenhum aluno encontrado com o RA digitado. ");
                menuAluno();
            }
        }
    }

    public static void pesquisar(Professor p) {
        for (Professor pro : professores) {
            if (pro.getRegistro().equals(p.getRegistro())) {
                System.out.println("Resultado: ");
                System.out.println("Professor ID " + (alunos.indexOf(pro) + 1));
                System.out.println("Nome: " + pro.getNome());
                System.out.println("Registro: " + pro.getRegistro());
                System.out.println("Disciplina: " + pro.getDisciplina());
                System.out.println("Endere�o do professor:\nUF: " + pro.getEndereco().getUf()
                        + "           Cidade: " + pro.getEndereco().getCidade()
                        + "           Bairro: " + pro.getEndereco().getBairro());
                System.out.println("Rua: " + pro.getEndereco().getRua()
                        + "           N�mero: " + pro.getEndereco().getNumero());
                System.out.println("Telefone: " + pro.getTelefone());
                System.out.println("Sexo: " + pro.getSexo());
                System.out.println("————————————————————————————");
                menuProfessor();
            } else {
                System.err.println("Nenhum professor encontrado com o registro digitado. ");
                menuProfessor();
            }
        }
    }

    public static void excluir(int indice, Professor p) {
        Scanner in = new Scanner(System.in);
        System.out.println("Excluir o professor de nome: " + p.getNome() + ""
                + " de registro: " + p.getRegistro() + "?\nS - SIM\nN - NÃO");
        String opcao = in.next();
        if (opcao.equalsIgnoreCase("s")) {
            professores.remove(indice);
            System.out.println("Excluído com sucesso.");
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    public static void excluir(int indice, Aluno a) {
        Scanner in = new Scanner(System.in);
        System.out.println("Excluir o aluno de nome: " + alunos.get(indice).getNome() + ""
                + " de RA: " + alunos.get(indice).getRa() + "?\nS - SIM\nN - N�O");
        String opcao = in.next();
        if (opcao.equalsIgnoreCase("s")) {
            alunos.remove(indice);
            System.out.println("Exclu�do com sucesso.");
        } else {
            System.out.println("Opera��o cancelada.");
        }
    }
}
