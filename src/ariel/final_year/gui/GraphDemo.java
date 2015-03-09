package ariel.final_year.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ScrollPaneConstants;

import java.awt.Rectangle;

import javax.swing.JSpinner;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GraphDemo extends JFrame  implements	ActionListener, ChangeListener,
ListSelectionListener{

	private final String DEFULT_CONdITIOM = "x + y + z - 10";
	private final int DEFULT_VERTEX_SIZE =1;

	private FileCondition fc;

	private JPanel contentPane;
	private JLabel lblCondition;

	@SuppressWarnings("unused")
	private GraphApplication graphApp;
	private int vertexSize;
	private String condition;
	private JButton btnDemo;

	// List staff
	private JList list ;
	private JPanel panel;
	private Vector<String> matrixContaion;
	private JScrollPane scroolPaneMatrix;


	//Graph Style
	private JComboBox<String> cbGraphStyle;
	private  String[] graphStyle = {"Complite Graph","modGraph3 s","randomGraph"};
	private String[] temp;
	private boolean[][] adjacencyMat;

	//number of vertex
	private String[]  numbers;
	JSpinner spinnerVertex ;

	// Condition
	private String[] equationCondition;
	private JComboBox cbCondition;
	private 	JButton btnConditionSave,btnConditionLoad;
	private boolean isNewFormola = false;
	JLabel labelUserLoadCondition;


	//private JFileChooser chooser;
	private JTextField tfUserCondition;
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



		initilaize();

		setLook();


	}




	private void initilaize() {


		vertexSize =DEFULT_VERTEX_SIZE;
		numbers = StaticData.numberOfVertex();
		fc = new FileCondition();
		equationCondition = fc.getConditionName();
		condition = DEFULT_CONdITIOM ;
		adjacencyMat = GraphStyle.compliteGraph(vertexSize);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setLook() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {

		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNumberOfVertex = new JLabel("Number of Vertex");
		lblNumberOfVertex.setBounds(10, 24, 100, 14);
		contentPane.add(lblNumberOfVertex);

		lblCondition = new JLabel("Condition");
		lblCondition.setBounds(166, 24, 66, 14);
		contentPane.add(lblCondition);

		btnDemo = new JButton("Demo");
		btnDemo.setBounds(185, 171, 89, 23);
		btnDemo.addActionListener(this);
		contentPane.add(btnDemo);

		panel = new JPanel();
		panel.setBounds(new Rectangle(30, 60, 200, 200));
		panel.setBounds(40, 92, 100, 97);
		contentPane.add( panel );

		matrixContaion = new Vector<String>();
		panel.setLayout(null);
		//panel.add(list, BorderLayout.CENTER);

		/*	list = new JList(matrixContaion);
		list.setBounds(10, 0, 250, 150);
		//	panel.add(list);
		//	list.setBounds(216,24,208,185);
		list.addListSelectionListener( this );

		scroolPaneMatrix = new JScrollPane();
		scroolPaneMatrix.setBounds(new Rectangle(10, 0, 250, 150));
		scroolPaneMatrix.setViewportView(list);
		panel.add(scroolPaneMatrix,BorderLayout.CENTER);
		 */





		cbGraphStyle = new JComboBox(graphStyle);
		cbGraphStyle.setBounds(260, 132, 123, 20);
		contentPane.add(cbGraphStyle);
		cbGraphStyle.addActionListener(this);

		cbCondition = new JComboBox(equationCondition);
		cbCondition.setBounds(241, 22, 142, 19);
		contentPane.add(cbCondition);
		cbCondition.addActionListener(this);

		spinnerVertex = new JSpinner();
		spinnerVertex.setFont(new Font("David", Font.BOLD, 13));
		spinnerVertex.setBounds(112, 15, 44, 33);
		contentPane.add(spinnerVertex);
		spinnerVertex.addChangeListener(this);

		btnConditionSave = new JButton("Save");
		btnConditionSave.setBounds(241, 87, 68, 23);
		contentPane.add(btnConditionSave);
		btnConditionSave.addActionListener(this);


		btnConditionLoad = new JButton("Load");
		btnConditionLoad.setBounds(319, 88, 64, 21);
		contentPane.add(btnConditionLoad);
		btnConditionLoad.addActionListener(this);

		tfUserCondition = new JTextField();
		tfUserCondition.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {



				if ( tfUserCondition.getText().equals("")) {
					isNewFormola = false;
					condition  =fc.conditionList.get( cbCondition.getSelectedIndex()).formula;
				}
				else {
					isNewFormola = true;
				}


			}
		});
		tfUserCondition.setBounds(240, 59, 142, 20);
		contentPane.add(tfUserCondition);
		tfUserCondition.setColumns(10);

		labelUserLoadCondition = new JLabel("");
		labelUserLoadCondition.setBounds(166, 62, 46, 14);
		contentPane.add(labelUserLoadCondition);


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



		if( e.getSource() == btnDemo )//press to open VRML Graph
		{

			if (isNewFormola) {
				condition = tfUserCondition.getText();
			}
			System.out.println(condition);
			graphApp = new GraphApplication(vertexSize, condition,adjacencyMat);
		}


		if (e.getSource() == cbGraphStyle) {// check the graph style chotion
			ItemSelectable is = (ItemSelectable)e.getSource();
			String graph = selectedString(is);
			if (graph.equals(graphStyle[0])) {
				adjacencyMat = GraphStyle.compliteGraph(vertexSize);	 
			}
			if (graph.equalsIgnoreCase(graphStyle[1])){
				adjacencyMat = GraphStyle.modGraph3(vertexSize);
			}
			if (graph.equalsIgnoreCase(graphStyle[2])){
				adjacencyMat = GraphStyle.randomGraph(vertexSize);
			}
			System.out.println(graph);
			/*temp = GraphStyle.toString(adjacencyMat);
			matrixContaion = new Vector<String>();
			for (int i = 0; i < temp.length; i++) 
				matrixContaion.addElement(temp[i]);	
			list.setListData( matrixContaion );*/
		}



		if (e.getSource() == cbCondition) {//choose from Graph Condition combo box 

			condition =fc.conditionList.get( cbCondition.getSelectedIndex()).formula;

		}


		if (e.getSource() == btnConditionSave) {//Save new formula
			
			if (isNewFormola) {
				JFileChooser chooser = new JFileChooser();
				String formola = tfUserCondition.getText();
				fc.writeCondition(formola,chooser);
			}

		}

		if (e.getSource() == btnConditionLoad) {//Load new formula
			
			JFileChooser chooser = new JFileChooser();
			String[] userLoad = fc.ReadCondition(chooser);
			condition = userLoad[1];
			tfUserCondition.setText(condition);
			labelUserLoadCondition.setText(userLoad[0]);

		}

	}
	@Override
	public void stateChanged(ChangeEvent e) {

		if(e.getSource() == spinnerVertex){
			vertexSize = Integer.valueOf(spinnerVertex.getValue().toString());
			System.out.println(vertexSize);
		}

	}

	static private String selectedString(ItemSelectable is) {
		Object selected[] = is.getSelectedObjects();
		return ((selected.length == 0) ? "null" : (String)selected[0]);
	} 
}





