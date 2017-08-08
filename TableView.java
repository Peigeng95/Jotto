// HelloMVC: a simple MVC example
// the model is just a counter 
// inspired by code by Joseph Mack, http://www.austintek.com/mvc/
import javax.swing.table.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.String;

class TableView extends JPanel implements IView{
	private int i = 0;
	private JottoModel model;	

		String [] names = {"guessed word","exact","partial"};
		Object [][] data = new Object[0][3];
     	 	//JTable table = new JTable(data,names);
		DefaultTableModel dtm = new DefaultTableModel(data, names);
		JTable table = new JTable(dtm);
     	 	JScrollPane scrollpane = new JScrollPane(table);

	public TableView(JottoModel model) {
		this.model = model;
		this.add(scrollpane);
/*
		TableModel dataModel = new AbstractTableModel() {
          		public int getColumnCount() { return 10; }
          		public int getRowCount() { return 10;}
          		public Object getValueAt(int row, int col) { return new String("a"); }
     	 	};*/

	}


	
	public void updateView() {
		if((model.lives >= 1)&&(!model.win)){
			if(i != 0){dtm.addRow(new Object[]{model.guessword,model.exact,model.partial});}
			i++;
			model.lives--;
		}
		else if((model.lives == 0)&&(!model.win)) {
			if(i != 0){dtm.addRow(new Object[]{model.guessword,model.exact,model.partial});}
			i++;
			model.lives--;
			dtm.addRow(new Object[]{"You loose :(", "answer IS ->", model.targetword});
		}
		else if((model.lives > 0) && (model.win)) {
			if(i != 0){dtm.addRow(new Object[]{model.guessword,model.exact,model.partial});}
			i++;
			model.lives = -1;
			dtm.addRow(new Object[]{"Good Job! You Win :)", "answer IS ->", model.targetword});
		}			
	}
}
