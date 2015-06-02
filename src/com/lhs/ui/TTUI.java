package com.lhs.ui;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

import com.lhs.game.Tank;
import com.lhs.game.Wall;
import com.lhs.game.World;

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
		
		final World game = new World(8,8);
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
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
            	Tank t1 = (Tank)game.actors.get(0);
            	Tank t2 = (Tank)game.actors.get(2);
                switch (event.getCode()) {
                    case UP:	t1.move(2);	game.actors.add(0,t1); break;
                    case DOWN:   t1.move(-2);	game.actors.add(0,t1); break;
                    case LEFT:   t1.direction-=3;	game.actors.add(0,t1); break;
                    case RIGHT:  t1.direction+=3;	game.actors.add(0,t1); break;
                    case E: t2.move(2);	    game.actors.add(1,t2); break;
                    case D: t2.move(-2);	game.actors.add(1,t2); break;
                    case S: t2.direction-=3;	game.actors.add(1,t2); break;
                    case F: t2.direction+=3;	game.actors.add(1,t2); break;
                    default: break;
                }
            }
		});
	}
}
