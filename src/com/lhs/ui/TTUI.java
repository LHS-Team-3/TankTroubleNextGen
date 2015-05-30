package com.lhs.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TTUI extends Application {
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Tank Trouble");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
		
        Button playBtn = new Button();
        playBtn.setText("Play!");
        playBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("TODO: Launch game"); //TODO: launch game
            }
        });
        grid.add(playBtn,0,0);
        
        Button quitBtn = new Button();
        quitBtn.setText("Quit");
        quitBtn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		System.exit(0);
        	}
        });
        grid.add(quitBtn,0,1);
        
        Scene scene = new Scene(grid,300,275);
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}

}
