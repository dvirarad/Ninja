package ariel.final_year.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.border.BevelBorder;

public class GraphDemo extends JFrame  implements	ActionListener,
ListSelectionListener{

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
	private Vector<String> matrixContaion;
	private JScrollPane scroolPaneMatrix;

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
	public GraphDemo()  {



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
		lblCondition.setBounds(10, 57, 66, 14);
		contentPane.add(lblCondition);

		tfCondition = new JTextField();
		tfCondition.setBounds(120, 54, 86, 20);
		contentPane.add(tfCondition);
		tfCondition.setColumns(10);


		btnShow = new JButton("Show");
		btnShow.setBounds(117, 101, 89, 23);
		btnShow.addActionListener(this);
		contentPane.add(btnShow);

		btnDemo = new JButton("Demo");
		btnDemo.setBounds(120, 144, 89, 23);
		btnDemo.addActionListener(this);
		contentPane.add(btnDemo);

		panel = new JPanel();
		panel.setBounds(216, 24, 208, 185);
		contentPane.add( panel );

		matrixContaion = new Vector<String>();



		list = new JList(matrixContaion);
		list.setBounds(216,24,208,185);
		list.addListSelectionListener( this );
		//panel.add(list, BorderLayout.CENTER);

		scroolPaneMatrix = new JScrollPane(list);
		scroolPaneMatrix.setBounds(10, 10, 20, 50);
		panel.add(scroolPaneMatrix,BorderLayout.CENTER);
	

	}




	@Override
	public void valueChanged(ListSelectionEvent e) {
		// Handler for list selection changes

		// See if this is a listbox selection and the
		// event stream has settled
		if( e.getSource() == list
				&& !e.getValueIsAdjusting() )
		{
			System.out.println("hello");
		}


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == btnDemo )
		{
			
			condition = tfCondition.getText();
			vertexSize = Integer.valueOf(tfnumVertex.getText());
			graphApp = new GraphApplication(vertexSize, condition);
			
			
			
		}
		if (e.getSource() == btnShow) {
			matrixContaion = new Vector<String>();
			vertexSize = Integer.valueOf(tfnumVertex.getText());
			String[] temp = GraphStyle.toString(GraphStyle.compliteGraph(vertexSize));
			
			for (int i = 0; i < temp.length; i++) 
				matrixContaion.addElement(temp[i]);	
			
			list.setListData( matrixContaion );
			/*scroolPaneMatrix.revalidate();
			scroolPaneMatrix.repaint();*/
		}	

	}

}

