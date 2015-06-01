package com.lhs.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import com.lhs.game.*;

import java.util.*;

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
		grid.setPadding(new Insets(25,25,25,25)); //comment
		
        Button playBtn = new Button();
        playBtn.setText("Play!");
        playBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("TODO: Launch game"); //TODO: launch game
                playGame(primaryStage);
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
        //scene.getStylesheets().add(com.lhs.ui.TTUI.class.getResource("start.css").toExternalForm());
        primaryStage.show();
        
		
	}
	
	public void playGame(Stage primaryStage) {
		
		Group root = new Group();
		Scene scene = new Scene(root,500,500,Color.WHITE);
		
		World game = new World(8,8);
		for (int i = 0; i<500; i++) {
			game.tick();
			//try {Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); }
		}
		
		//draw
		ArrayList<Wall> walls = game.walls;
		for (int i = 0; i<walls.size(); i++) {
			Wall w = walls.get(i);
			Rectangle r = new Rectangle();
			r.setX(w.x*15);
			r.setY(w.y*15);
			r.setHeight(w.h*15);
			r.setWidth(w.w*15);
			r.setFill(Color.BLUE);
			root.getChildren().addAll(r);
		}
		primaryStage.setScene(scene);
		primaryStage.show();
		//primaryStage.addEventHandler(arg0, arg1);
		
		
	}

}
