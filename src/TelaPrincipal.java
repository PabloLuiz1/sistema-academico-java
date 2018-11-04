
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FATEC
 */
public class TelaPrincipal extends JFrame implements ActionListener{
    JLabel lblTitulo;
    JButton btnAluno, btnProfessor, btnSair;
    TelaPrincipal(){
        this.setSize(500,300);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setTitle("Menu principal");
        lblTitulo = new JLabel();
        lblTitulo.setSize(200, 30);
        lblTitulo.setLocation(this.getSize().width / 3, 20);
        lblTitulo.setText("SISTEMA ACADÊMICO");
        lblTitulo.setVisible(true);
        this.add(lblTitulo);
        btnAluno = new JButton();
        btnAluno.setLocation(this.getSize().width / 4, 90);
        btnAluno.setSize(200, 30);
        btnAluno.setText("GERENCIAR ALUNOS");
        btnAluno.addActionListener(this);
        btnAluno.setVisible(true);
        this.add(btnAluno);
        btnProfessor = new JButton();
        btnProfessor.setLocation(btnAluno.getLocation().x, btnAluno.getLocation().y + 50);
        btnProfessor.setSize(btnAluno.getSize().width, 30);
        btnProfessor.setText("GERENCIAR PROFESSORES");
        btnProfessor.setVisible(true);
        this.add(btnProfessor);
        btnSair = new JButton();
        btnSair.setSize(100, 25);
        btnSair.setLocation(this.getSize().width - 150, this.getSize().height - 100);
        btnSair.setText("SAIR");
        btnSair.addActionListener(this);
        btnSair.setVisible(true);
        this.add(btnSair);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnSair)){
            this.dispose();
            System.exit(0);
        }
        if (e.getSource().equals(btnAluno)){
            this.dispose();
            new TelaAluno();
        }
        if (e.getSource().equals(btnProfessor)){
            
        }
    }
}
