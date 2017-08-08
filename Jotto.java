import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Enumeration;
import java.awt.Dimension;
import java.awt.GridLayout;	
import javax.swing.JFrame;
//import view.*;
public class Jotto {

	public static void main(String[] args){
		JottoModel model = new JottoModel();
		model.print(); //test purpose print the target word.	

		TextView vText = new TextView(model);   //View to input guess words
		TableView vtable = new TableView(model);//View of table
		TextView2 vText2 = new TextView2(model);// View to set target words
		TableView2 vtable2 = new TableView2(model); // View of hint
 		//	model.addView(vText);	
		model.addView(vText);	
		model.addView(vtable2);	
		model.addView(vtable);

		/*
		widgets
		*/
		JFrame frame = new JFrame("Jotto");
		frame.getContentPane().setLayout(new GridLayout(2, 1));
		frame.getContentPane().add(vText);
		frame.getContentPane().add(vText2);
		frame.getContentPane().add(vtable);
		frame.getContentPane().add(vtable2);


		frame.setPreferredSize(new Dimension(1000,700));

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	} 
}
