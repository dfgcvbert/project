package swing.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import swing.controller.Controller;
import swing.controller.FindNearestTransportButtonActionListener;

public class Window extends JFrame {

	private static final long serialVersionUID = -3018646238479150068L;

	private Controller controller;

	private JComboBox<String> comboBox1;
	private JComboBox<String> comboBox2;
	private JTextField textField1 = new JTextField(3);
	private JTextField textField2 = new JTextField(3);
	private JTextArea textArea = new JTextArea(5, 60);

	public Window(Controller controller) throws HeadlessException {
		this.controller = controller;
		createWindow();
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public JComboBox<String> getComboBox1() {
		return comboBox1;
	}

	public void setComboBox1(JComboBox<String> comboBox1) {
		this.comboBox1 = comboBox1;
	}

	public JComboBox<String> getComboBox2() {
		return comboBox2;
	}

	public void setComboBox2(JComboBox<String> comboBox2) {
		this.comboBox2 = comboBox2;
	}

	public JTextField getTextField1() {
		return textField1;
	}

	public void setTextField1(JTextField textField1) {
		this.textField1 = textField1;
	}

	public JTextField getTextField2() {
		return textField2;
	}

	public void setTextField2(JTextField textField2) {
		this.textField2 = textField2;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	private void createWindow() {
		setTitle("Транспорт");
		setSize(700, 380);
		setLocationRelativeTo(null);
		setResizable(false);

		Container contentPane = getContentPane();
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);

		JLabel label1 = new JLabel("Начальная остановка");
		layout.putConstraint(SpringLayout.WEST, label1, 30, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, label1, 30, SpringLayout.NORTH, contentPane);
		contentPane.add(label1);
		comboBox1 = new JComboBox<String>(controller.getAllStopTitles().toArray(new String[0]));
		layout.putConstraint(SpringLayout.WEST, comboBox1, 10, SpringLayout.EAST, label1);
		layout.putConstraint(SpringLayout.NORTH, comboBox1, -5, SpringLayout.NORTH, label1);
		contentPane.add(comboBox1);

		JLabel label2 = new JLabel("Конечная остановка");
		layout.putConstraint(SpringLayout.WEST, label2, 50, SpringLayout.EAST, comboBox1);
		layout.putConstraint(SpringLayout.NORTH, label2, 0, SpringLayout.NORTH, label1);
		contentPane.add(label2);
		comboBox2 = new JComboBox<String>(controller.getAllStopTitles().toArray(new String[0]));
		layout.putConstraint(SpringLayout.WEST, comboBox2, 10, SpringLayout.EAST, label2);
		layout.putConstraint(SpringLayout.NORTH, comboBox2, 0, SpringLayout.NORTH, comboBox1);
		contentPane.add(comboBox2);

		JLabel label3 = new JLabel("Время отправления");
		layout.putConstraint(SpringLayout.WEST, label3, 0, SpringLayout.WEST, label1);
		layout.putConstraint(SpringLayout.NORTH, label3, 50, SpringLayout.SOUTH, label1);
		contentPane.add(label3);
		layout.putConstraint(SpringLayout.WEST, textField1, 10, SpringLayout.EAST, label3);
		layout.putConstraint(SpringLayout.NORTH, textField1, 0, SpringLayout.NORTH, label3);
		contentPane.add(textField1);
		JLabel label4 = new JLabel("час");
		layout.putConstraint(SpringLayout.WEST, label4, 10, SpringLayout.EAST, textField1);
		layout.putConstraint(SpringLayout.NORTH, label4, 0, SpringLayout.NORTH, label3);
		contentPane.add(label4);
		layout.putConstraint(SpringLayout.WEST, textField2, 30, SpringLayout.EAST, label4);
		layout.putConstraint(SpringLayout.NORTH, textField2, 0, SpringLayout.NORTH, label3);
		contentPane.add(textField2);
		JLabel label5 = new JLabel("мин");
		layout.putConstraint(SpringLayout.WEST, label5, 10, SpringLayout.EAST, textField2);
		layout.putConstraint(SpringLayout.NORTH, label5, 0, SpringLayout.NORTH, label3);
		contentPane.add(label5);

		JButton findNearestTransportButton = new JButton("Найти ближайший транспорт");
		findNearestTransportButton.setPreferredSize(new Dimension(600, 60));
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, findNearestTransportButton, 0,
				SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, findNearestTransportButton, 100, SpringLayout.SOUTH, comboBox2);
		findNearestTransportButton.addActionListener(new FindNearestTransportButtonActionListener(this));
		contentPane.add(findNearestTransportButton);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textArea, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
		layout.putConstraint(SpringLayout.NORTH, textArea, 30, SpringLayout.SOUTH, findNearestTransportButton);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		contentPane.add(textArea);

	}

}
