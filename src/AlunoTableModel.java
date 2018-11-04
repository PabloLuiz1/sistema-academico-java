
import java.util.*;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FATEC
 */
public class AlunoTableModel extends AbstractTableModel{
    private List<Aluno> dados = new ArrayList<>();
    private String[] colunas = {"Nome", "RA", "Sexo", "Curso", "Rua", "Número", "Bairro", "Cidade", "UF"};

    @Override
    public String getColumnName(int column) {
        return colunas[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return dados.get(linha).getNome();
            case 1:
                return dados.get(linha).getRa();
            case 2:
                return dados.get(linha).getSexo();
            case 3:
                return dados.get(linha).getCurso();
            case 4:
                return dados.get(linha).getEndereco().getRua();
            case 5:
                return dados.get(linha).getEndereco().getNumero();
            case 6:
                return dados.get(linha).getEndereco().getBairro();
            case 7:
                return dados.get(linha).getEndereco().getCidade();
            case 8:
                return dados.get(linha).getEndereco().getUf();
        }
        return null;
    }
    
}
