/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map_project;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.geometry.HPos;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Map_project extends Application {
    TextField technique = new TextField();
    TextField sourceCity = new TextField();
    TextField destinationCity = new TextField();
    Button search = new Button("Search");
    Graph g = new Graph();                        //make object of Graph class
    Stack path = new Stack();                                  
    TextField result = new TextField();              
    Image image = new Image("peta-jakarta-lengkap.png");
    Canvas layer1 = new Canvas(image.getWidth(),image.getHeight());
    GraphicsContext gc1 = layer1.getGraphicsContext2D();
    Node[] Graph = new Node[10];
    String s_technique;                              
    int x=0;
    int y=0;   
    @Override
    public void start(Stage primaryStage) {
        	    GridPane gridpane = new GridPane();
		    gridpane.setHgap(5);
		    gridpane.setVgap(5);
		    gridpane.add(new Label("Search Technique"), 0,0);
		    gridpane.add(technique, 1, 0);
		    gridpane.add(new Label("from"),0, 1);
		    gridpane.add(sourceCity, 1, 1);
		    gridpane.add(new Label("To"),0, 2);
		    gridpane.add(destinationCity, 1, 2);
		    gridpane.add(search, 1, 3);
		    gridpane.setAlignment(Pos.CENTER);
		    GridPane.setHalignment(search, HPos.RIGHT);
		    technique.setAlignment(Pos.CENTER);
		    Scene scene = new Scene(gridpane,300,200);
		    primaryStage.setScene(scene);		    
		    Pane pane = new Pane();
		    pane.getChildren().add(new ImageView(image));
		    Group root = new Group();
		    root.getChildren().add(pane);
		    pane.getChildren().add(layer1);
	    	    Scene scene1 = new Scene(root);
	    	    Stage stage = new Stage();
	    	    stage.setScene(scene1);		    		    
		    gc1.setFill(Color.BLACK);
		    gc1.fillOval(435,55,10,10);
		    gc1.fillOval(560,120,10,10);
		    gc1.fillOval(400,150,10,10);
		    gc1.fillOval(480,200,10,10);
		    gc1.fillOval(600,215,10,10);
		    gc1.fillOval(419,285,10,10);
		    gc1.fillOval(450,304,10,10);
		    gc1.fillOval(509,327,10,10);
		    gc1.fillOval(460,457,10,10);
		    gc1.fillOval(62,405,10,10);
		    gc1.setStroke(Color.BLUE);
		    gc1.strokeText("1", 435, 55);
		    gc1.strokeText("2",560,120);
		    gc1.strokeText("3", 400,150);
		    gc1.strokeText("4", 480,200);
		    gc1.strokeText("5", 600,215);
		    gc1.strokeText("6", 419,285);
		    gc1.strokeText("7",450,304);
                    gc1.strokeText("8", 509, 327);
		    gc1.strokeText("9", 460,457);
		    gc1.strokeText("10", 62,405);		    
		    stage.show();
                    primaryStage.show();
		    search.setOnAction(e->draw());

    }
	public void draw() {               
		        String s_technique = (technique.getText());
		        int source_City = Integer.parseInt(sourceCity.getText());
		        int destination_City = Integer.parseInt(destinationCity.getText());	        	        	
		        path=g.createGraph(s_technique,source_City,destination_City);		        	
 	                int n,k=0;
	                while(!path.isempty())
	                    {
	                        n=path.pop();
	     	                for(int i=0;i<10;i++)
	     	                   {
	     		                if(n==g.graph[i].value)
	     			             {Graph[k] = g.graph[i]; 	k++; 	}
	                           }
	     
	                    }  
	                for(int i=0;i<k-1;i++)
	                    { 
	     	                gc1.setStroke(Color.GREEN);
			        gc1.setLineWidth(2);
			        gc1.strokeLine(Graph[i].pixelX,Graph[i].pixelY,Graph[i+1].pixelX,Graph[i+1].pixelY);
	                    }
			    
		    
		 }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
