package it.polito.tdp.spellChecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import has.spellChecker.model.Dictionary;
import has.spellChecker.model.EnglishDic;
import has.spellChecker.model.ItalianDic;
import has.spellChecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class SpellCheckerController {
	
	private Dictionary dic;
	private int i=0;
	private int e=0;
	private List<Text> childrens=new ArrayList<>();
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> btnMenu;

    @FXML
    private TextArea txtIn;

    @FXML
    private TextFlow txtOut;

    @FXML
    private Label lblErr;

    @FXML
    private Label lblTime;

    @FXML
    void doCheck(ActionEvent event) {
    	lblErr.setText("");
    	String selected="";
        childrens.clear();
        txtOut.getChildren().clear();
        boolean eror=false;
    	
    	long start=System.currentTimeMillis();
    	
    	if(btnMenu.getValue()!=null)
    	{
    		selected=btnMenu.getValue();
    	}
    	else
    	{
    		lblErr.setText("please select a language");
    	}
    	
    	if((e==0) &&  selected.equals("english"))
    	{
    		dic=new EnglishDic();
    		dic.loadDictionary();e++;
    	}
    	if(i==0 && selected.equals("italian"))
    	{
    		dic=new ItalianDic();
    		dic.loadDictionary();i++;
    	}
    	
    	String in=txtIn.getText();
    	
    	String [] arr=in.split(" ");
    	List<String> listo=new LinkedList<>();
    	
    	for(String s : arr)
    	{
    		listo.add(s.toLowerCase());
    	}
    	in=null;
    	
    	for (RichWord r : dic.spellCheckText(listo))
    	{
    		if(!r.getCorrect())
    		{	//in+=r.getWord()+" ";
    			
    			Text txt=new Text(r.getWord()+" ");
    			txt.setFill(Color.RED);
    			childrens.add(txt);
    			eror=true;
    		}
    		else
    		{
    			Text txt=new Text(r.getWord()+" ");
    			childrens.add(txt);
    		}
    		
    	}
    	

    	
    	txtOut.getChildren().addAll(childrens);
    	if(eror){
    	lblErr.setText("your text has some spell error");
    	lblErr.setTextFill(Color.RED);
    	}
    	long end =System.currentTimeMillis();
    	
    	lblTime.setText((end-start)*0.001+" s" );

    	

    }

    @FXML
    void doClear(ActionEvent event) {
    	i=0;e=0;
    	
    	txtIn.setText("");
    	txtOut.getChildren().clear();
    	
    	lblErr.setText("");lblTime.setText("");
    	

    }

    @FXML
    void initialize() {
        assert btnMenu != null : "fx:id=\"btnMenu\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtIn != null : "fx:id=\"txtIn\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtOut != null : "fx:id=\"txtOut\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblErr != null : "fx:id=\"lblErr\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        btnMenu.getItems().addAll("english","italian");
        lblTime.setText("");
        lblErr.setText("");
        

    }
}
