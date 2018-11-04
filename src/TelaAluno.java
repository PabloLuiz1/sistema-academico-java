
import java.awt.Font;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author FATEC
 */
public class TelaAluno extends JFrame implements ActionListener {
    JLabel lblTitulo, lblNome, lblTelefone, lblSexo, lblEndereco, lblRa, lblCurso
            , lblRua, lblNumero, lblBairro, lblCidade, lblUf;
    JComboBox cbSexo, cbCurso, cbUf;
    JTextField txtNome, txtTelefone, txtEndereco, txtRa, txtRua, txtNumero, txtBairro, txtCidade;
    JButton btnCadastrar, btnEditar, btnExcluir, btnCancelar, btnVoltar;
    JPanel pnlEndereco;
    JTable tbAlunos;
    JScrollPane barraRolagem;
    AlunoTableModel modelo;
    Font fonteLbl, fonteTxt;
    TelaAluno(){
        fonteLbl = new Font("Verdana", Font.BOLD, 12);
        fonteTxt = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 12);
        this.setSize(700, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Gerenciamento de alunos");
        lblTitulo = new JLabel();
        lblTitulo.setSize(200, 22);
        lblTitulo.setLocation(230, 30);
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
        lblTitulo.setText("CADASTRO DE ALUNOS");
        lblTitulo.setVisible(true);
        this.add(lblTitulo);
        lblNome = new JLabel();
        lblNome.setSize(50, 22);
        lblNome.setLocation(50, 80);
        lblNome.setFont(fonteLbl);
        lblNome.setText("Nome: ");
        lblNome.setVisible(true);
        this.add(lblNome);
        txtNome = new JTextField();
        txtNome.setSize(150, lblNome.getSize().height);
        txtNome.setLocation(lblNome.getLocation().x + lblNome.getSize().width, lblNome.getLocation().y);
        txtNome.setFont(fonteTxt);
        txtNome.setVisible(true);
        this.add(txtNome);
        lblRa = new JLabel();
        lblRa.setSize(lblNome.getSize().width, lblNome.getSize().height);
        lblRa.setLocation(lblNome.getLocation().x, lblNome.getLocation().y + 30);
        lblRa.setFont(fonteLbl);
        lblRa.setText("RA: ");
        lblRa.setVisible(true);
        this.add(lblRa);
        txtRa = new JTextField();
        txtRa.setSize(txtNome.getSize().width, lblNome.getSize().height);
        txtRa.setLocation(lblRa.getLocation().x + lblNome.getSize().width, lblRa.getLocation().y);
        txtRa.setFont(fonteTxt);
        txtRa.setVisible(true);
        this.add(txtRa);
        lblSexo = new JLabel();
        lblSexo.setSize(lblRa.getSize().width, lblRa.getSize().height);
        lblSexo.setLocation(lblRa.getLocation().x, lblRa.getLocation().y + 30);
        lblSexo.setFont(fonteLbl);
        lblSexo.setText("Sexo: ");
        lblSexo.setVisible(true);
        this.add(lblSexo);
        cbSexo = new JComboBox();
        cbSexo.setSize(txtRa.getSize().width, txtRa.getSize().height);
        cbSexo.setLocation(lblSexo.getLocation().x + lblSexo.getSize().width, lblSexo.getLocation().y);
        cbSexo.setFont(fonteTxt);
        cbSexo.addItem("Selecione");
        cbSexo.addItem("Masculino");
        cbSexo.addItem("Feminino");
        cbSexo.setSelectedIndex(0);
        cbSexo.setVisible(true);
        this.add(cbSexo);
        lblCurso = new JLabel();
        lblCurso.setSize(lblRa.getSize().width, lblRa.getSize().height);
        lblCurso.setLocation(lblSexo.getLocation().x, lblSexo.getLocation().y + 30);
        lblCurso.setFont(fonteLbl);
        lblCurso.setText("Curso: ");
        this.add(lblCurso);
        cbCurso = new JComboBox();
        cbCurso.setSize(txtRa.getSize().width, txtRa.getSize().height);
        cbCurso.setLocation(lblCurso.getLocation().x + lblCurso.getSize().width, lblCurso.getLocation().y);
        cbCurso.setFont(fonteTxt);
        cbCurso.addItem("Selecione");
        cbCurso.addItem(Enum.Cursos.ADS.toString());
        cbCurso.addItem(Enum.Cursos.AGRO.toString());
        cbCurso.setSelectedIndex(0);
        cbCurso.setVisible(true);
        this.add(cbCurso);
        pnlEndereco = new JPanel();
        pnlEndereco.setLayout(null);
        pnlEndereco.setSize(this.getSize().width / 2, 150);
        pnlEndereco.setLocation(txtNome.getLocation().x + txtNome.getSize().width + 20, txtNome.getLocation().y - 10);
        pnlEndereco.setFont(fonteLbl);
        pnlEndereco.setBorder(BorderFactory.createTitledBorder("Endereço"));
        this.add(pnlEndereco);
        lblRua = new JLabel();
        lblRua.setSize(lblCurso.getSize().width, lblCurso.getSize().height);
        lblRua.setLocation(15, 20);
        lblRua.setFont(fonteLbl);
        lblRua.setText("Rua: ");
        lblRua.setVisible(true);
        pnlEndereco.add(lblRua);
        txtRua = new JTextField();
        txtRua.setSize(txtNome.getSize().width, txtNome.getSize().height);
        txtRua.setLocation(lblRua.getLocation().x + lblRua.getSize().width, lblRua.getLocation().y);
        txtRua.setFont(fonteTxt);
        pnlEndereco.add(txtRua);
        lblNumero = new JLabel();
        lblNumero.setSize(65, lblRua.getSize().height);
        lblNumero.setLocation(txtRua.getLocation().x + txtRua.getSize().width + 10, txtRua.getLocation().y);
        lblNumero.setFont(fonteLbl);
        lblNumero.setText("Número: ");
        lblNumero.setVisible(true);
        pnlEndereco.add(lblNumero);
        txtNumero = new JTextField();
        txtNumero.setSize(40, lblNumero.getSize().height);
        txtNumero.setLocation(lblNumero.getLocation().x + lblNumero.getSize().width, lblNumero.getLocation().y);
        txtNumero.setFont(fonteTxt);
        txtNumero.setVisible(true);
        pnlEndereco.add(txtNumero);
        lblBairro = new JLabel();
        lblBairro.setSize(lblRua.getSize().width + 5, lblRua.getSize().height);
        lblBairro.setLocation(lblRua.getLocation().x, lblRua.getLocation().y + 30);
        lblBairro.setFont(fonteLbl);
        lblBairro.setText("Bairro: ");
        lblBairro.setVisible(true);
        pnlEndereco.add(lblBairro);
        txtBairro = new JTextField();
        txtBairro.setSize(txtRua.getSize().width, txtRua.getSize().height);
        txtBairro.setLocation(lblBairro.getLocation().x + lblBairro.getSize().width, lblBairro.getLocation().y);
        txtBairro.setFont(fonteTxt);
        txtBairro.setVisible(true);
        pnlEndereco.add(txtBairro);
        lblCidade = new JLabel();
        lblCidade.setSize(lblBairro.getSize().width + 10, lblBairro.getSize().height);
        lblCidade.setLocation(lblBairro.getLocation().x, lblBairro.getLocation().y + 30);
        lblCidade.setFont(fonteLbl);
        lblCidade.setText("Cidade: ");
        lblCidade.setVisible(true);
        pnlEndereco.add(lblCidade);
        txtCidade = new JTextField();
        txtCidade.setSize(txtBairro.getSize().width, txtBairro.getSize().height);
        txtCidade.setLocation(lblCidade.getLocation().x + lblCidade.getSize().width, lblCidade.getLocation().y);
        txtCidade.setFont(fonteTxt);
        txtCidade.setVisible(true);
        pnlEndereco.add(txtCidade);
        lblUf = new JLabel();
        lblUf.setSize(lblCidade.getSize().width, lblCidade.getSize().height);
        lblUf.setLocation(lblCidade.getLocation().x, lblCidade.getLocation().y + 30);
        lblUf.setFont(fonteLbl);
        lblUf.setText("UF: ");
        lblUf.setVisible(true);
        pnlEndereco.add(lblUf);
        cbUf = new JComboBox();
        cbUf.setSize(cbCurso.getSize().width, cbCurso.getSize().height);
        cbUf.setLocation(lblUf.getLocation().x + lblUf.getSize().width, lblUf.getLocation().y);
        cbUf.setFont(fonteTxt);
        cbUf.addItem("Selecione");
        cbUf.addItem("SP");
        cbUf.addItem("RJ");
        cbUf.addItem("PR");
        cbUf.addItem("SC");
        cbUf.addItem("ES");
        cbUf.setSelectedIndex(0);
        cbUf.setVisible(true);
        pnlEndereco.add(cbUf);
        modelo = new AlunoTableModel();
        tbAlunos = new JTable();
        tbAlunos.setBounds(lblNome.getLocation().x, pnlEndereco.getLocation().y + 180, this.getSize().width - 110, 150);
        tbAlunos.setModel(modelo);
        tbAlunos.setVisible(true);
        this.add(tbAlunos);
        pnlEndereco.setVisible(true);
        this.setVisible(true);
    }
    
    TelaAluno(ArrayList<Aluno> alunos){
        this.setSize(500, 400);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Gerenciamento de alunos");
        lblTitulo = new JLabel();
        lblTitulo.setSize(200, 30);
        lblTitulo.setLocation(200, 30);
        lblTitulo.setText("CADASTRO DE ALUNOS");
        lblTitulo.setVisible(true);
        this.add(lblTitulo);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
    }

}
