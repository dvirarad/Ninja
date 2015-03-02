package ariel.final_year.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GraphDemo extends JFrame {

	private JPanel contentPane;
	private JTextField tfnumVertex;
	private JLabel lblCondition;
	private JTextField tfCondition;
	private JButton btnShow;

	private GraphApplication graphApp;
	private int vertexSize;
	private String condition;
	private JButton btnDemo;
	private JList list ;
	private JPanel panel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphDemo frame = new GraphDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GraphDemo() {



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNumberOfVertex = new JLabel("Number of Vertex");
		lblNumberOfVertex.setBounds(10, 24, 100, 14);
		contentPane.add(lblNumberOfVertex);

		tfnumVertex = new JTextField();
		tfnumVertex.setBounds(120, 21, 86, 20);
		contentPane.add(tfnumVertex);
		tfnumVertex.setColumns(10);

		lblCondition = new JLabel("Condition");
		lblCondition.setBounds(10, 57, 46, 14);
		contentPane.add(lblCondition);

		tfCondition = new JTextField();
		tfCondition.setBounds(120, 54, 86, 20);
		contentPane.add(tfCondition);
		tfCondition.setColumns(10);


		btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				updateMatrix();
			}

		});
		btnShow.setBounds(117, 101, 89, 23);
		contentPane.add(btnShow);

		btnDemo = new JButton("Demo");
		btnDemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				condition = tfCondition.getText();
				vertexSize = Integer.valueOf(tfnumVertex.getText());
				graphApp = new GraphApplication(vertexSize, condition);
			}
		});
		btnDemo.setBounds(120, 144, 89, 23);
		contentPane.add(btnDemo);

		panel = new JPanel();
		panel.setBounds(216, 24, 185, 170);
		contentPane.add( panel );
		
		
	
	   
	    String[] data  = {"1","2","3","4"};
	    DefaultListModel model = new DefaultListModel();
	;
		model.addElement(data[1]);
		model.addElement(data[3]);
		model.addElement(data[2]);
		model.addElement(data[0]);
		list = new JList(model);
		panel.add(list, BorderLayout.CENTER);

	}


	private void updateMatrix() {
		String[] data  = {"1","2","3","4","5"};
		DefaultListModel<String> model = new DefaultListModel();
		model.addElement(data[2]);
		model.addElement(data[1]);
		model.addElement(data[3]);
		model.addElement(data[4]);
		model.addElement(data[0]);
	//	vertexSize = Integer.valueOf(tfnumVertex.getText());
	//	String[] temp = GraphStyle.toString(GraphStyle.compliteGraph(vertexSize));
		list = new JList(model);
	//	panel.add(list, BorderLayout.CENTER);
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
		


	}

}

