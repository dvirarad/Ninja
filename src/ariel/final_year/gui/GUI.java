package ariel.final_year.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import ariel.final_year.expression.SyntaxException;
import ariel.final_year.logic.Condition;
import ariel.final_year.logic.ParserIn;
import ariel.final_year.logic.ParserOut;
import ariel.final_year.logic.VertexGenerator;
import ariel.final_year.utilities.StaticMethods;
import ariel.final_year.utilities.StaticVariables;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
ss


	private JLabel lblTitle;
	private JLabel lblLevit;
	private JLabel lblArad;
	private JLabel lblGabay;

	private JLabel lblCondition;
	private JTextField tfCondition;
	private JComboBox<ConditionType> cbConditionType;
	private JButton btnSaveEqn;
	private JButton btnLoadEqn;

	private JLabel lblGraph;
	private JSpinner spinVertices;
	private JLabel lblVertices;
	private JComboBox<GraphType> cbGraphType;
	private JButton btnLoadGraph;

	private JButton btnGenerate;

	private Condition condition;
	private int numOfVertices;
	private boolean[][] adjacencyMat;
	private int graphID;
	private boolean isUserGraph;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws SyntaxException 
	 */
	public GUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SyntaxException, IOException {
		initLogic();
		initGUI();
	}

	public void initLogic() {
		condition = null;
		numOfVertices = -1;
		adjacencyMat = null;
		graphID = -1;
		isUserGraph = false;
	}

	public void initGUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SyntaxException, IOException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 321);
		setTitle("Ninja Project");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		panel = new JPanel();

		lblCondition = new JLabel("Equation of the condition:");
		tfCondition = new JTextField();
		tfCondition.setColumns(10);
		tfCondition.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tfConditionEdited();
			}
		});
		cbConditionType = new JComboBox<ConditionType>();
		DefaultComboBoxModel<ConditionType> conditionModel = new DefaultComboBoxModel<ConditionType>(ConditionType.getAllConditions());
		cbConditionType.setModel(conditionModel);
		cbConditionType.setSelectedIndex(-1);
		cbConditionType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cbConditionTypeSelected();
			}
		});
		btnSaveEqn = new JButton("Save");
		btnSaveEqn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					saveEqnPressed();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLoadEqn = new JButton("Load");
		btnLoadEqn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadEqnPressed();
			}
		});

		lblGraph = new JLabel("Graph configuration:");
		spinVertices = new JSpinner();
		spinVertices.setModel(new SpinnerNumberModel(3.0, 3.0, 40.0, 1.0));
		lblVertices = new JLabel("vertices.");
		cbGraphType = new JComboBox<GraphType>();
		DefaultComboBoxModel<GraphType> model = new DefaultComboBoxModel<GraphType>(GraphType.getAllGraphs());
		cbGraphType.setModel(model);
		cbGraphType.setSelectedIndex(-1);
		cbGraphType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cbGraphTypeSelected();
			}
		});
		btnLoadGraph = new JButton("Load");
		btnLoadGraph.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					loadGraphPressed();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "File incorrectly formatted", "Loading error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});

		btnGenerate = new JButton("Generate STL");
		btnGenerate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					generatePressed();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (NullPointerException e3) {
					JOptionPane.showMessageDialog(null, "No graph selected", "Select or load a graph", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGenerate.setEnabled(true);

		lblTitle = new JLabel("STL Generator");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 16));

		lblLevit = new JLabel("Prof. Vadim E. Levit");
		lblLevit.setForeground(Color.DARK_GRAY);
		lblLevit.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		lblArad = new JLabel("Dvir Arad");
		lblArad.setForeground(Color.DARK_GRAY);
		lblArad.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		lblGabay = new JLabel("Jeremie Gabay");
		lblGabay.setForeground(Color.DARK_GRAY);
		lblGabay.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblArad)
												.addComponent(lblLevit))
												.addGap(23)
												.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
												.addGap(132))
												.addGroup(gl_panel.createSequentialGroup()
														.addComponent(lblGabay)
														.addContainerGap(301, Short.MAX_VALUE))
														.addGroup(gl_panel.createSequentialGroup()
																.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																						.addComponent(lblGraph)
																						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
																								.addGroup(gl_panel.createSequentialGroup()
																										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																										.addComponent(btnLoadGraph))
																										.addGroup(gl_panel.createSequentialGroup()
																												.addComponent(spinVertices, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																												.addPreferredGap(ComponentPlacement.RELATED)
																												.addComponent(lblVertices)
																												.addPreferredGap(ComponentPlacement.UNRELATED)
																												.addComponent(cbGraphType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																												.addComponent(tfCondition)
																												.addGroup(gl_panel.createSequentialGroup()
																														.addComponent(cbConditionType, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
																														.addPreferredGap(ComponentPlacement.RELATED)
																														.addComponent(btnSaveEqn)
																														.addPreferredGap(ComponentPlacement.RELATED)
																														.addComponent(btnLoadEqn))))
																														.addGroup(gl_panel.createSequentialGroup()
																																.addGap(127)
																																.addComponent(btnGenerate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																.addGap(114)))
																																.addGroup(gl_panel.createSequentialGroup()
																																		.addComponent(lblCondition)
																																		.addPreferredGap(ComponentPlacement.RELATED, 202, GroupLayout.PREFERRED_SIZE)))
																																		.addGap(5))))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitle)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblLevit)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblArad, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblGabay, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblCondition)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tfCondition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(cbConditionType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnSaveEqn)
												.addComponent(btnLoadEqn))
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblGraph)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
														.addComponent(spinVertices, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblVertices)
														.addComponent(cbGraphType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
																.addComponent(btnLoadGraph))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnGenerate)
																.addGap(117))
				);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(26, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
	}

	protected void tfConditionEdited() {
		if(tfCondition.getText().isEmpty()) {
			EventQueue.invokeLater(new Runnable() {

				public void run() {
					cbConditionType.setSelectedIndex(-1);
				}
			});
		}
	}

	protected void cbConditionTypeSelected() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				tfCondition.setText(((ConditionType) cbConditionType.getSelectedItem()).getCondition().toString());
			}
		});
	}

	protected void saveEqnPressed() throws IOException {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Equation files *.eqn", "eqn");
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(filter);
		chooser.setDialogTitle("Save equation");
		chooser.setCurrentDirectory(new File(StaticVariables.FOLDER_CONDITIONS));
		if(chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			FileWriter fw = new FileWriter(chooser.getSelectedFile() + ".eqn");
			fw.write(tfCondition.getText());
			fw.close();
		}
	}

	protected void loadEqnPressed() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Equation files *.eqn", "eqn");
		final JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(filter);
		chooser.setDialogTitle("Load equation");
		chooser.setCurrentDirectory(new File(StaticVariables.FOLDER_CONDITIONS));
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					try {
						tfCondition.setText(StaticMethods.getStringConditionFromFile(chooser.getSelectedFile()));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}

	protected void cbGraphTypeSelected() {
		try {
			graphID = ((GraphType) cbGraphType.getSelectedItem()).getID();
		} catch (NullPointerException e) {}

		isUserGraph = false;
		spinVertices.setEnabled(true);
	}

	protected void loadGraphPressed() throws IOException {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Matrix files *.mat", "mat");
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(filter);
		chooser.setDialogTitle("Load graph configuration");
		chooser.setCurrentDirectory(new File(StaticVariables.FOLDER_USER_GRAPHS));
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();

			ParserIn pi = new ParserIn(f);
			StaticMethods.printMat(pi.getAdjacencyMat());
			numOfVertices = pi.getNumOfVertices();
			adjacencyMat = StaticMethods.copyMat(pi.getAdjacencyMat());

			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					isUserGraph = true;

					cbGraphType.setSelectedIndex(-1);
					spinVertices.setEnabled(false);
				}
			});
		}
	}

	protected void generatePressed() throws ParseException, IOException {
		if (!isUserGraph) {
			spinVertices.commitEdit();
			numOfVertices = ((SpinnerNumberModel) spinVertices.getModel()).getNumber().intValue();
			adjacencyMat = StaticMethods.getGraph(numOfVertices, graphID);
		}
		try {
			condition = new Condition(tfCondition.getText());
			VertexGenerator g = new VertexGenerator(numOfVertices, condition);
			ParserOut po = new ParserOut(adjacencyMat, g.getVertices());
			String fileName = po.generateOutput();

			if(StaticMethods.isWindows()) {
				new ProcessBuilder(StaticVariables.WIN_EXEC, fileName).start();
			} else if(StaticMethods.isMac()) {
				new ProcessBuilder("open", StaticVariables.MAC_EXEC, fileName).start();
			}
		} catch (SyntaxException e) {
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					JOptionPane.showMessageDialog(null, "Invalid equation for condition", "Equation error", JOptionPane.ERROR_MESSAGE);
					tfCondition.setText("");
					cbConditionType.setSelectedIndex(-1);
				}
			});
			e.printStackTrace();
		}
		spinVertices.setEnabled(true);
	}
}

class GraphType {
	private String graphName;
	private int graphID;

	public GraphType(String newName, int newID) {
		graphName = newName;
		graphID = newID;
	}

	public GraphType(GraphType newGT) {
		graphName = newGT.graphName;
		graphID = newGT.graphID;
	}

	public static GraphType[] getAllGraphs() {
		ArrayList<GraphType> returnValue = new ArrayList<GraphType>();
		returnValue.add(new GraphType("Complete graph", StaticVariables.COMPLETE_ID));
		returnValue.add(new GraphType("Random graph", StaticVariables.RANDOM_ID));
		returnValue.add(new GraphType("Mod3 graph", StaticVariables.MOD3_ID));

		return returnValue.toArray(new GraphType[returnValue.size()]);
	}

	public String getName() { return graphName; }
	public int getID() { return graphID; }

	@Override
	public String toString() {
		return graphName;
	}
}

class ConditionType {
	private String name;
	private Condition condition;

	public ConditionType(String newName, String strExpr) throws SyntaxException {
		name = newName;
		condition = new Condition(strExpr);
	}

	public ConditionType(ConditionType newCT) throws SyntaxException {
		name = newCT.name;
		condition = new Condition(newCT.condition);
	}

	public static ConditionType[] getAllConditions() throws SyntaxException, IOException {
		ArrayList<ConditionType> returnValue = new ArrayList<ConditionType>();
		File conditionFolder = new File(StaticVariables.FOLDER_CONDITIONS);
		for (File f : conditionFolder.listFiles()) {
			String fileName = f.getName();
			if(f.getName().endsWith(".eqn")) {
				BufferedReader br = new BufferedReader(new FileReader(f));
				returnValue.add(new ConditionType(fileName.substring(0, fileName.indexOf(".eqn")), br.readLine()));
				br.close();
			}
		}
		return returnValue.toArray(new ConditionType[returnValue.size()]);
	}

	public String getName() { return name; }
	public Condition getCondition() { return condition; }

	@Override
	public String toString() {
		return name;
	}
}