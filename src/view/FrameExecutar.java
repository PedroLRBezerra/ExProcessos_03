package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.SoController;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class FrameExecutar extends JFrame {

	private JPanel contentPane;
	private JTextField txtProcurar;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					FrameExecutar frame = new FrameExecutar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the frame.
	 */
	public FrameExecutar() {
		SoController controller = new SoController();
		setTitle("Executar - "+controller.getOs());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProcurar = new JLabel("Abrir :");
		lblProcurar.setBounds(10, 96, 48, 14);
		contentPane.add(lblProcurar);
		
		txtProcurar = new JTextField();
		txtProcurar.setBounds(68, 93, 310, 20);
		contentPane.add(txtProcurar);
		txtProcurar.setColumns(10);
		
		JLabel lblMensagem = new JLabel("Digite o caminho do Execut\u00E1vel ou clique em Procurar");
		lblMensagem.setBounds(83, 44, 318, 14);
		contentPane.add(lblMensagem);
		
		JButton btnProcurarCaminho = new JButton("OK");
		btnProcurarCaminho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean executado= controller.chamaProcesso(txtProcurar.getText());
				if(executado==true) {
					dispose();
				}
			}
		});
		btnProcurarCaminho.setBounds(68, 129, 89, 23);
		contentPane.add(btnProcurarCaminho);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(181, 129, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnProcurarArqv = new JButton("Procurar");
		btnProcurarArqv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filto = new FileNameExtensionFilter("Arquivos Executáveis (.exe)", "exe");
				
				String diretorioBase = System.getProperty("user.home")+"/Desktop";
				File dir = new File(diretorioBase);
				
				JFileChooser choose = new JFileChooser();
				choose.setCurrentDirectory(dir);
				choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
				choose.setAcceptAllFileFilterUsed(false);
				choose.addChoosableFileFilter(filto);
				
				String caminhoArquivo = "";
				
				int retorno = choose.showOpenDialog(null);
				if(retorno == JFileChooser.APPROVE_OPTION) {
					caminhoArquivo=choose.getSelectedFile().getAbsolutePath();
					txtProcurar.setText(caminhoArquivo);
				}
				
			}
		});
		
		
		btnProcurarArqv.setBounds(289, 129, 89, 23);
		contentPane.add(btnProcurarArqv);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(10, 25, 48, 48);
		lblIcon.setIcon(new ImageIcon(FrameExecutar.class.getResource("/imgs/javaIcon1.png")));
		contentPane.add(lblIcon);
	}
}
