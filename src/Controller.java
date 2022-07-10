import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


/**
 * JavaFX controller class
 * @author Richmond
 *
 */
public class Controller {
	
	@FXML
	private ListView<String> resultView;
	
	/**
	 * Reacts to mouse click input<br>
	 * Uses the {@link TextAnalyzer#getList()} method and FXML ListView to display text analyzer results
	 * @throws IOException
	 */
	public void handleAnalyzeClick() throws IOException 
	{
		TextAnalyzer obj = new TextAnalyzer();
		resultView.getItems().addAll(obj.getList());
	}

	/**
	 * Reacts to mouse click input</br>
	 * Clears the designated FXML ListView
	 * @throws IOException
	 */
	public void clearResultView() throws IOException 
	{
		resultView.getItems().clear();
	}
	
}
