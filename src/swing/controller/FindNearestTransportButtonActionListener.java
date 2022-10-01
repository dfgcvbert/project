package swing.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import swing.model.MyTime;
import swing.view.Window;

public class FindNearestTransportButtonActionListener implements ActionListener {

	private Window window;

	public FindNearestTransportButtonActionListener(Window window) {
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (window.getComboBox1().getSelectedItem().equals(window.getComboBox2().getSelectedItem())) {
			JOptionPane.showMessageDialog(null, "Начальная и конечная остановки совпадают");
			return;
		}
		if ((window.getTextField1().getText().isEmpty()) || (window.getTextField2().getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Введите время");
			return;
		}
		String startPoint = (String) window.getComboBox1().getSelectedItem();
		String finishPoint = (String) window.getComboBox2().getSelectedItem();
		MyTime departureTime = new MyTime(Integer.parseInt(window.getTextField1().getText()),
				Integer.parseInt(window.getTextField2().getText()));
		window.getTextArea().setText("");
		for (String nearestTransport : window.getController().findNearestTransport(departureTime, startPoint,
				finishPoint)) {
			window.getTextArea().append(nearestTransport + "\n");
		}

	}

}
