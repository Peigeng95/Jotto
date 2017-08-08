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
public class TextView2 extends JPanel implements IView{
	private JottoModel model;
	private JTextField targetTF = new JTextField(10);

	public TextView2(JottoModel aModel) {
		super();
		this.model = aModel;
		this.layoutView();
		this.registerControllers();
	}

	private void layoutView() {
		//this.setLayout(new FormLayout());
		this.add(new JLabel("Set Target word:"));
		this.add(this.targetTF);
	}

	private void registerControllers() {
		this.targetTF.addActionListener(new BaseController());
	}

	private class BaseController implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			String word = targetTF.getText();
			if(word.length() == 5){
				model.settword(word);
				targetTF.setEditable(false);
			}
			else{
				System.out.println("The word '" + word + "' has an invalid length(length must equal 5)");			
			}
		}
	}

	public void updateView() {		
	}
}
