package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.event.MouseListener;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JPanel;
import java.awt.Canvas;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.Button;
import java.awt.List;
import java.awt.ScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import bd.daos.*;
import bd.dbo.*;
import javax.swing.JComboBox;
import project.template.*;

public class Tela {

	protected JFrame frame;
	protected JList list;
	protected JTextArea txtComplemento;
	protected JTextArea txtDescricao;
	protected JTextArea txtNome;
	protected JTextArea txtCEP;
	protected JTextArea txtNumero;
	private Bibliotecas biblio; 
	protected JTextArea txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela() {
		initialize();
		biblio = new Bibliotecas();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		frame.getContentPane().setBackground(new Color(189, 183, 107));
		frame.setBounds(100, 100, 660, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(102, 102, 0));
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 15));
		frame.getContentPane().add(lblNome);
		
		txtNome = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, txtNome, 6, SpringLayout.EAST, lblNome);
		txtNome.setBackground(new Color(204, 204, 102));
		txtNome.setForeground(new Color(102, 102, 0));
		txtNome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNome, -11, SpringLayout.NORTH, lblDescricao);
		springLayout.putConstraint(SpringLayout.EAST, lblNome, 0, SpringLayout.EAST, lblDescricao);
		springLayout.putConstraint(SpringLayout.NORTH, lblDescricao, 53, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblDescricao, -544, SpringLayout.EAST, frame.getContentPane());
		lblDescricao.setForeground(new Color(102, 102, 0));
		lblDescricao.setFont(new Font("Times New Roman", Font.BOLD, 15));
		frame.getContentPane().add(lblDescricao);
		
		JTextArea txtDescricao = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, txtDescricao, 6, SpringLayout.EAST, lblDescricao);
		txtDescricao.setLineWrap(true);
		springLayout.putConstraint(SpringLayout.SOUTH, txtNome, -8, SpringLayout.NORTH, txtDescricao);
		springLayout.putConstraint(SpringLayout.EAST, txtNome, 0, SpringLayout.EAST, txtDescricao);
		springLayout.putConstraint(SpringLayout.NORTH, txtDescricao, 0, SpringLayout.NORTH, lblDescricao);
		txtDescricao.setBackground(new Color(204, 204, 102));
		txtDescricao.setForeground(new Color(102, 102, 0));
		txtDescricao.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.getContentPane().add(txtDescricao);
		
		JLabel lblCEP = new JLabel("CEP:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblCEP, -236, SpringLayout.SOUTH, frame.getContentPane());
		lblCEP.setForeground(new Color(102, 102, 0));
		lblCEP.setFont(new Font("Times New Roman", Font.BOLD, 15));
		frame.getContentPane().add(lblCEP);
		
		txtCEP = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, txtCEP, 106, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtCEP, -358, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblCEP, -6, SpringLayout.WEST, txtCEP);
		springLayout.putConstraint(SpringLayout.SOUTH, txtDescricao, -6, SpringLayout.NORTH, txtCEP);
		springLayout.putConstraint(SpringLayout.NORTH, txtCEP, -3, SpringLayout.NORTH, lblCEP);
		txtCEP.setBackground(new Color(204, 204, 102));
		txtCEP.setForeground(new Color(102, 102, 0));
		txtCEP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.getContentPane().add(txtCEP);
		txtCEP.setColumns(10);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		springLayout.putConstraint(SpringLayout.NORTH, lblLogradouro, 6, SpringLayout.SOUTH, lblCEP);
		springLayout.putConstraint(SpringLayout.EAST, lblLogradouro, 0, SpringLayout.EAST, lblNome);
		lblLogradouro.setForeground(new Color(102, 102, 0));
		lblLogradouro.setFont(new Font("Times New Roman", Font.BOLD, 15));
		frame.getContentPane().add(lblLogradouro);
		
		JLabel lblLogradouroI = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblLogradouroI, 6, SpringLayout.SOUTH, txtCEP);
		springLayout.putConstraint(SpringLayout.WEST, lblLogradouroI, 0, SpringLayout.WEST, txtNome);
		springLayout.putConstraint(SpringLayout.EAST, lblLogradouroI, -280, SpringLayout.EAST, frame.getContentPane());
		lblLogradouroI.setForeground(new Color(102, 102, 0));
		lblLogradouroI.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLogradouroI.setBackground(Color.WHITE);
		frame.getContentPane().add(lblLogradouroI);
		
		JLabel lblBairro = new JLabel("Bairro:");
		springLayout.putConstraint(SpringLayout.EAST, lblBairro, 0, SpringLayout.EAST, lblNome);
		lblBairro.setForeground(new Color(102, 102, 0));
		lblBairro.setFont(new Font("Times New Roman", Font.BOLD, 15));
		frame.getContentPane().add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		springLayout.putConstraint(SpringLayout.NORTH, lblCidade, 6, SpringLayout.SOUTH, lblBairro);
		springLayout.putConstraint(SpringLayout.EAST, lblCidade, 0, SpringLayout.EAST, lblNome);
		lblCidade.setForeground(new Color(102, 102, 0));
		lblCidade.setFont(new Font("Times New Roman", Font.BOLD, 15));
		frame.getContentPane().add(lblCidade);
		
		JLabel lblCidadeI = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, lblCidadeI, 0, SpringLayout.WEST, txtNome);
		springLayout.putConstraint(SpringLayout.EAST, lblCidadeI, -280, SpringLayout.EAST, frame.getContentPane());
		lblCidadeI.setForeground(new Color(102, 102, 0));
		lblCidadeI.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.getContentPane().add(lblCidadeI);
		
		JLabel lblNumero = new JLabel("Nº:");
		springLayout.putConstraint(SpringLayout.WEST, lblNumero, 79, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNumero, -183, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblBairro, 6, SpringLayout.SOUTH, lblNumero);
		lblNumero.setForeground(new Color(102, 102, 0));
		lblNumero.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNumero.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(lblNumero);
		
		txtNumero = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, txtNumero, 106, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtNumero, -448, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblLogradouroI, -5, SpringLayout.NORTH, txtNumero);
		springLayout.putConstraint(SpringLayout.EAST, lblNumero, -6, SpringLayout.WEST, txtNumero);
		springLayout.putConstraint(SpringLayout.NORTH, txtNumero, -3, SpringLayout.NORTH, lblNumero);
		txtNumero.setForeground(new Color(102, 102, 0));
		txtNumero.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtNumero.setBackground(new Color(204, 204, 102));
		frame.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		springLayout.putConstraint(SpringLayout.NORTH, lblComplemento, 38, SpringLayout.SOUTH, lblCidade);
		springLayout.putConstraint(SpringLayout.EAST, lblComplemento, 0, SpringLayout.EAST, lblNome);
		lblComplemento.setForeground(new Color(102, 102, 0));
		lblComplemento.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(lblComplemento);
		
		 txtComplemento = new JTextArea();
		 springLayout.putConstraint(SpringLayout.SOUTH, lblCidadeI, -35, SpringLayout.NORTH, txtComplemento);
		 springLayout.putConstraint(SpringLayout.NORTH, txtComplemento, -3, SpringLayout.NORTH, lblComplemento);
		 springLayout.putConstraint(SpringLayout.WEST, txtComplemento, 107, SpringLayout.WEST, frame.getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, txtComplemento, 0, SpringLayout.EAST, txtNome);
		txtComplemento.setBackground(new Color(204, 204, 102));
		txtComplemento.setForeground(new Color(102, 102, 0));
		frame.getContentPane().add(txtComplemento);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int id, String nome, String descricao, int cep, String numero, String complemento
				Biblioteca newbiblio;
				try 
				{
					newbiblio = new Biblioteca(txtNome.getText(), txtDescricao.getText(), Integer.parseInt(txtCEP.getText().trim()), txtNumero.getText(), txtComplemento.getText());
					biblio.create(newbiblio);
					txtNome.setText("");
					txtDescricao.setText("");
					txtCEP.setText("");
					txtNumero.setText("");
					txtComplemento.setText("");
					txtId.setText("");
					
				} 
				catch (NumberFormatException e1) 
				{
					e1.printStackTrace();
				} 
				catch (Exception e1) 
				{
					e1.printStackTrace();
				}	
				
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnCadastrar, 9, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnCadastrar, 527, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCadastrar, -10, SpringLayout.EAST, frame.getContentPane());
		btnCadastrar.setForeground(new Color(215, 167, 0));
		btnCadastrar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCadastrar.setBackground(new Color(255, 255, 51));
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		springLayout.putConstraint(SpringLayout.EAST, txtDescricao, -40, SpringLayout.WEST, btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtId.getText().trim().length() > 0)
				{
					Biblioteca inserida;
					try {
						inserida = new Biblioteca(txtNome.getText(), txtDescricao.getText(), Integer.parseInt(txtCEP.getText().trim()), txtNumero.getText(), txtComplemento.getText());
						inserida.setId(Integer.parseInt(txtId.getText().trim()));
						biblio.update(inserida);
						txtNome.setText("");
						txtDescricao.setText("");
						txtCEP.setText("");
						txtNumero.setText("");
						txtComplemento.setText("");
						txtId.setText("");
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAtualizar, 6, SpringLayout.SOUTH, btnCadastrar);
		springLayout.putConstraint(SpringLayout.WEST, btnAtualizar, 0, SpringLayout.WEST, btnCadastrar);
		springLayout.putConstraint(SpringLayout.EAST, btnAtualizar, 0, SpringLayout.EAST, btnCadastrar);
		btnAtualizar.setForeground(new Color(51, 102, 0));
		btnAtualizar.setBackground(new Color(153, 204, 0));
		btnAtualizar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		frame.getContentPane().add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtId.getText().trim().length() > 0)
				{
					try {
						biblio.delete(Integer.parseInt(txtId.getText().trim()));
						txtNome.setText("");
						txtDescricao.setText("");
						txtCEP.setText("");
						txtNumero.setText("");
						txtComplemento.setText("");
						txtId.setText("");
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnDeletar, 6, SpringLayout.SOUTH, btnAtualizar);
		springLayout.putConstraint(SpringLayout.WEST, btnDeletar, 0, SpringLayout.WEST, btnCadastrar);
		springLayout.putConstraint(SpringLayout.EAST, btnDeletar, 0, SpringLayout.EAST, btnCadastrar);
		btnDeletar.setForeground(new Color(153, 0, 0));
		btnDeletar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnDeletar.setBackground(new Color(255, 153, 102));
		frame.getContentPane().add(btnDeletar);
		
		JLabel lblBairroI = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblCidadeI, 3, SpringLayout.SOUTH, lblBairroI);
		springLayout.putConstraint(SpringLayout.SOUTH, lblBairroI, -156, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblBairroI, 8, SpringLayout.SOUTH, txtNumero);
		springLayout.putConstraint(SpringLayout.WEST, lblBairroI, 6, SpringLayout.EAST, lblBairro);
		springLayout.putConstraint(SpringLayout.EAST, lblBairroI, -280, SpringLayout.EAST, frame.getContentPane());
		lblBairroI.setForeground(new Color(102, 102, 0));
		lblBairroI.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.getContentPane().add(lblBairroI);
		
		MouseListener mouseListener = new MouseAdapter() {
		     public void mouseClicked(MouseEvent e) {
		             int index = list.locationToIndex(e.getPoint());   
		       
		             ListModel model = list.getModel();
		            String texto = (String) model.getElementAt(index);
		            //System.out.println(texto);
		            String[] identificacao = texto.split("-");
		            String id = identificacao[0];
		            //System.out.println(id);
		            try {
						Biblioteca selecionar = biblio.consulta(Integer.parseInt(id));
						txtNome.setText(selecionar.getNome());
						txtDescricao.setText(selecionar.getDescricao());
						txtCEP.setText("" + selecionar.getCEP());
						txtNumero.setText(selecionar.getNumero());
						txtComplemento.setText(selecionar.getComplemento());
						txtId.setText("" + selecionar.getId());
						
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		     }
		 };
		
		Button btnBuscarTodos = new Button("Buscar Todos");
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Biblioteca> selectBiblio = biblio.read();
					Iterator i = selectBiblio.iterator();
					
					DefaultListModel novaLista = new DefaultListModel(); 
					
				while (i.hasNext()) {
					Biblioteca biblioNome = ((Biblioteca) i.next());
						novaLista.addElement(biblioNome.getId() + "- " + biblioNome.getNome());
					}
				
					list = new JList(novaLista);
					list.setForeground(new Color(102, 102, 0));
					list.setBackground(new Color(204, 204, 102));
					list.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					springLayout.putConstraint(SpringLayout.NORTH, list, 6, SpringLayout.SOUTH, txtComplemento);
					springLayout.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.WEST, frame.getContentPane());
					springLayout.putConstraint(SpringLayout.SOUTH, list, -10, SpringLayout.SOUTH, frame.getContentPane());
					springLayout.putConstraint(SpringLayout.EAST, list, 0, SpringLayout.EAST, btnCadastrar);
					frame.getContentPane().add(list);
					list.addMouseListener(mouseListener);
					frame.revalidate();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		 
		
		springLayout.putConstraint(SpringLayout.SOUTH, btnBuscarTodos, -101, SpringLayout.SOUTH, frame.getContentPane());
		btnBuscarTodos.setForeground(new Color(128, 0, 0));
		springLayout.putConstraint(SpringLayout.WEST, btnBuscarTodos, 0, SpringLayout.WEST, btnCadastrar);
		springLayout.putConstraint(SpringLayout.EAST, btnBuscarTodos, 0, SpringLayout.EAST, btnCadastrar);
		btnBuscarTodos.setFont(new Font("Times New Roman", Font.BOLD, 12));
		frame.getContentPane().add(btnBuscarTodos);
		
		txtId = new JTextArea();
		txtId.setBackground(new Color(204, 204, 102));
		springLayout.putConstraint(SpringLayout.NORTH, txtId, 15, SpringLayout.SOUTH, btnDeletar);
		springLayout.putConstraint(SpringLayout.WEST, txtId, -12, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtId, -10, SpringLayout.EAST, frame.getContentPane());
		txtId.setEnabled(false);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		springLayout.putConstraint(SpringLayout.NORTH, lblEstado, 6, SpringLayout.SOUTH, lblCidade);
		springLayout.putConstraint(SpringLayout.EAST, lblEstado, 0, SpringLayout.EAST, lblNome);
		lblEstado.setForeground(new Color(102, 102, 0));
		lblEstado.setFont(new Font("Times New Roman", Font.BOLD, 15));
		frame.getContentPane().add(lblEstado);
		
		JLabel lblEstadoI = new JLabel("");
		lblEstadoI.setForeground(new Color(102, 102, 0));
		lblEstadoI.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblEstadoI, 6, SpringLayout.SOUTH, lblCidadeI);
		springLayout.putConstraint(SpringLayout.WEST, lblEstadoI, 0, SpringLayout.WEST, txtNome);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEstadoI, 24, SpringLayout.SOUTH, lblCidadeI);
		springLayout.putConstraint(SpringLayout.EAST, lblEstadoI, 0, SpringLayout.EAST, lblLogradouroI);
		frame.getContentPane().add(lblEstadoI);
		
		JButton btnBuscarCEP = new JButton("Buscar CEP");
		btnBuscarCEP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String cep = txtCEP.getText();
					
					Logradouro logradouro = BuscaLogradouro.getLogradouroByCep(cep);
					
					if (logradouro == null) 
					{
						JOptionPane.showMessageDialog(txtCEP, "CEP inválido");
						return; 
					}
					else
					{
						lblLogradouroI.setText(logradouro.getLogradouro());
						lblBairroI.setText(logradouro.getBairro());
						lblCidadeI.setText(logradouro.getCidade());
						lblEstadoI.setText(logradouro.getEstado());
					}
					
				}
				catch(Exception err)
				{}
				
			}
		});
		btnBuscarCEP.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnBuscarCEP.setBackground(new Color(204, 102, 51));
		btnBuscarCEP.setForeground(new Color(255, 0, 0));
		springLayout.putConstraint(SpringLayout.NORTH, btnBuscarCEP, 4, SpringLayout.SOUTH, txtId);
		springLayout.putConstraint(SpringLayout.WEST, btnBuscarCEP, 0, SpringLayout.WEST, btnCadastrar);
		springLayout.putConstraint(SpringLayout.EAST, btnBuscarCEP, 0, SpringLayout.EAST, btnCadastrar);
		frame.getContentPane().add(btnBuscarCEP);
	}
}
