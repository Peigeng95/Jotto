 
import java.util.ArrayList;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEdit;


public class JottoModel 
{
	private ArrayList<IView> views = new ArrayList<IView>();
	public static int lives = 10;
	public static boolean win =  false;
	public static String live = "10";
	public static int exact = 0;
	public static int partial = 0;
	public static int NUM_LETTERS = 5;
	public static String exactchar = "";
	public static String partialchar = "";
	public static final String[] LEVELS = {
      "Easy", "Medium", "Hard", "Any Difficulty"};
	public String guessword;
	public WordList wordlist = new WordList("dictionary.txt");
	/// ........................	
	public String targetword = wordlist.randomWord().getWord();

	public void print(){	
		System.out.println(targetword);
	}
	public JottoModel() {
	}
	
	public void settword(String word) {
		this.targetword = word;
	}

	public void setgword(String word) {
		this.guessword = word;
		//notifyObservers();
		//System.out.println(guessword);
	}
	
	public void comparewords() {
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				if(targetword.charAt(i) == guessword.charAt(j)){
					partialchar = partialchar + targetword.charAt(i)+" ";
					partial++;
					break;
				}
			}
			if(targetword.charAt(i) == guessword.charAt(i)){
				exactchar = exactchar + targetword.charAt(i)+ " ";
				exact++;
			}
		}
		if(exact == 5){win = true;}
		partial = partial - exact;
		live = Integer.toString(lives);
		notifyObservers();
		this.exact = 0;
		this.partial = 0;
		this.exactchar = "";
		this.partialchar = "";
	}
	
	public void addView(IView view) {
		this.views.add(view);
		view.updateView();
	}
	private void notifyObservers() {
		for (IView view : this.views) {
			view.updateView();
		}
	}
	///........................
}

