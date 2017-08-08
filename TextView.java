import javax.swing.*;
import java.awt.event.*;
import java.text.NumberFormat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * View a triangle as text:  numbers for the base, height, and hypotenuse.
 * 
 * @author Byron Weber Becker
 */
public class TextView extends JPanel implements IView{
	private JottoModel model;
	private JTextField baseTF = new JTextField(10);
	private JTextField liveTF = new JTextField(5);

	public TextView(JottoModel aModel) {
		super();
		this.model = aModel;
		this.layoutView();
		this.registerControllers();
	}

	private void layoutView() {
		//this.setLayout(new FormLayout());
		this.add(new JLabel("Guess:"));
		this.add(this.baseTF);
		this.add(new JLabel("Lives:"));
		this.add(this.liveTF);
		this.liveTF.setEditable(false);
	}

	private void registerControllers() {
		this.baseTF.addActionListener(new BaseController());
	}

	private class BaseController implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			String word = baseTF.getText();
			if(word.length() == 5){
				model.setgword(word);
				model.comparewords();
			}
			else{
				System.out.println("The word '" + word + "' has an invalid length(length must equal 5)");			
			}
		}
	}

	public void updateView() {
		baseTF.setText("");
		liveTF.setText(model.live);
		
	}
}
