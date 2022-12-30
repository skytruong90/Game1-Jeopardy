package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {

	 Button btnCat1_100 = new Button();
	 Button btnCat1_200 = new Button();
	 Button btnCat1_300 = new Button();
	 Button btnCat1_400 = new Button();
	 Button btnCat1_500 = new Button();
	
	 Button btnCat2_100 = new Button();
	 Button btnCat2_200 = new Button();
	 Button btnCat2_300 = new Button();
	 Button btnCat2_400 = new Button();
	 Button btnCat2_500 = new Button();
	
	 Button btnCat3_100 = new Button();
	 Button btnCat3_200 = new Button();
	 Button btnCat3_300 = new Button();
	 Button btnCat3_400 = new Button();
	 Button btnCat3_500 = new Button();
	
	 Button btnCat4_100 = new Button();
	 Button btnCat4_200 = new Button();
	 Button btnCat4_300 = new Button();
	 Button btnCat4_400 = new Button();
	 Button btnCat4_500 = new Button();
	
	 Button btnCat5_100 = new Button();
	 Button btnCat5_200 = new Button();
	 Button btnCat5_300 = new Button();
	 Button btnCat5_400 = new Button();
	 Button btnCat5_500 = new Button();
	
	 Button btnClose = new Button("Close");
	 Button btnAnswer = new Button("Answer");
	 Button btnTeam1 = new Button("Team 1");
	 Button btnTeam2 = new Button("Team 2");
	 Button btnNextRnd = new Button("Next Round");
	 
	 ListView<Integer> team1Pts = new ListView<>();
	 ListView<Integer> team2Pts = new ListView<>();
	 
	 HBox total1 = new HBox();
	 HBox total2 = new HBox();
	 
	
	 ReadQA readQuestions = new ReadQA("src/application/round1.txt");
	 qa questions = readQuestions.createQA();
	
	 TextArea txaTeam1 = new TextArea();
	 TextArea txaTeam2 = new TextArea();
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane grdRootPane = buildGUI();
			Scene scene = new Scene(grdRootPane, 1200, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Trivia");
			primaryStage.show();
			
			btnNextRnd.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					Round2 round2 = new Round2();
					round2.start(primaryStage);
					
				}
				
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	
	private  Pane buildGUI() throws FileNotFoundException {
		GridPane root = new GridPane();
		root.setId("pane");
		root.getStyleClass().add("h_or_v_box");
		root.add(buildCategoryColumn(), 0, 0);
		root.add(btnNextRnd, 0, 1);
		root.add(buildTeamDisplay(), 1, 0);

		return root;
	}
	
	// Create team display
	private Pane buildTeamDisplay() throws FileNotFoundException {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(25));
		
		Label lblT1 = new Label("\tTeam 1");
		
		Label lblT2 = new Label("\tTeam 2");
		
		VBox vBoxT1 = new VBox();
		
		
		VBox vBoxT2 = new VBox();
		
		
		team1Pts.maxHeight(300);
		team1Pts.maxWidth(100);
		
		total1.setStyle("-fx-spacing:10px;");	
		total2.setStyle("-fx-spacing:10px;");
		
		txaTeam1.getStyleClass().add("text-area");
		txaTeam2.getStyleClass().add("text-area");
		
		total2.getChildren().add(txaTeam2);
		total1.getChildren().add(txaTeam1);
		
		vBoxT1.getChildren().addAll(lblT1, total1);
		grid.add(vBoxT1, 0, 0);
		
		team2Pts.maxHeight(300);
		team2Pts.maxWidth(100);
		
		vBoxT2.getChildren().addAll(lblT2, total2);
		grid.add(vBoxT2, 0, 1);
		
		grid.setVgap(25);
	
		return grid;
		
	}
	
	// Create topics to choose from
	private  Pane buildCategoryColumn() {
		HBox hBox = new HBox();
		VBox vBox_cat1 = createCategory1();
		VBox vBox_cat2 = createCategory2();
		VBox vBox_cat3 = createCategory3();
		VBox vBox_cat4 = createCategory4();
		VBox vBox_cat5 = createCategory5();
		
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(vBox_cat1, vBox_cat2, vBox_cat3, vBox_cat4, vBox_cat5);
		
		return hBox;

	}
	// **************//
	
	// Creates the column of buttons for Category 1
	private  VBox createCategory1() {
		VBox vBox_cat1 = new VBox();
		Label lblCat1 = new Label(qa.getCategory(1));
		
		btnCat1_100.setText("100");
		btnCat1_100.getStyleClass().add("rich-blue-2");
		btnCat1_100.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(1, 1);
                btnCat1_100.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		btnCat1_200.setText("200");
		btnCat1_200.getStyleClass().add("rich-blue-2");
		btnCat1_200.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(2, 1);
                btnCat1_200.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		btnCat1_300.setText("300");
		btnCat1_300.getStyleClass().add("rich-blue-2");
		btnCat1_300.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(3, 1);
                btnCat1_300.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		
		btnCat1_400.setText("400");
		btnCat1_400.getStyleClass().add("rich-blue-2");
		btnCat1_400.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(4, 1);
                btnCat1_400.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		btnCat1_500.setText("500");
		btnCat1_500.getStyleClass().add("rich-blue-2");
		btnCat1_500.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(5, 1);
                btnCat1_500.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });

		lblCat1.setAlignment(Pos.CENTER);
		vBox_cat1.getChildren().addAll(lblCat1, btnCat1_100, btnCat1_200, btnCat1_300, btnCat1_400, btnCat1_500);
		vBox_cat1.getStyleClass().add("h_or_v_box");
		
		return vBox_cat1;
	}
	
	// Creates the column of buttons for Category 2
	private  VBox createCategory2() {
		VBox vBox_cat2 = new VBox();
		Label lblCat2 = new Label(qa.getCategory(2));
		
		btnCat2_100.setText("100");
		btnCat2_100.getStyleClass().add("rich-blue-2");
		btnCat2_100.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(1, 2);
                btnCat2_100.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		btnCat2_200.setText("200");
		btnCat2_200.getStyleClass().add("rich-blue-2");
		btnCat2_200.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(2, 2);
                btnCat2_200.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		btnCat2_300.setText("300");
		btnCat2_300.getStyleClass().add("rich-blue-2");
		btnCat2_300.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(3, 2);
                btnCat2_300.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		
		btnCat2_400.setText("400");
		btnCat2_400.getStyleClass().add("rich-blue-2");
		btnCat2_400.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(4, 2);
                btnCat2_400.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		btnCat2_500.setText("500");
		btnCat2_500.getStyleClass().add("rich-blue-2");
		btnCat2_500.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(5, 2);
                btnCat2_500.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		
		lblCat2.setAlignment(Pos.CENTER);
		vBox_cat2.getChildren().addAll(lblCat2, btnCat2_100, btnCat2_200, btnCat2_300, btnCat2_400, btnCat2_500);
		vBox_cat2.getStyleClass().add("h_or_v_box");
		
		return vBox_cat2;
	}
	
	// Creates the column of buttons for Category 3
	private  VBox createCategory3() {
		VBox vBox_cat3 = new VBox();
		Label lblCat3 = new Label(qa.getCategory(3));
		
		btnCat3_100.setText("100");
		btnCat3_100.getStyleClass().add("rich-blue-2");
		btnCat3_100.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(1, 3);
                btnCat3_100.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		btnCat3_200.setText("200");
		btnCat3_200.getStyleClass().add("rich-blue-2");
		btnCat3_200.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(2, 3);
                btnCat3_200.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		btnCat3_300.setText("300");
		btnCat3_300.getStyleClass().add("rich-blue-2");
		btnCat3_300.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(3, 3);
                btnCat3_300.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		
		btnCat3_400.setText("400");
		btnCat3_400.getStyleClass().add("rich-blue-2");
		btnCat3_400.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(4, 3);
                btnCat3_400.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		btnCat3_500.setText("500");
		btnCat3_500.getStyleClass().add("rich-blue-2");
		btnCat3_500.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(5, 3);
                btnCat3_500.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		
		lblCat3.setAlignment(Pos.CENTER);
		vBox_cat3.getChildren().addAll(lblCat3, btnCat3_100, btnCat3_200, btnCat3_300, btnCat3_400, btnCat3_500);
		vBox_cat3.getStyleClass().add("h_or_v_box");
		
		return vBox_cat3;
	}
	
	// Creates the column of buttons for Category 4
	private  VBox createCategory4() {
		VBox vBox_cat4 = new VBox();
		Label lblCat4 = new Label(qa.getCategory(4));
		
		btnCat4_100.setText("100");
		btnCat4_100.getStyleClass().add("rich-blue-2");
		btnCat4_100.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(1, 4);
                btnCat4_100.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		btnCat4_200.setText("200");
		btnCat4_200.getStyleClass().add("rich-blue-2");
		btnCat4_200.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(2, 4);
                btnCat4_200.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		btnCat4_300.setText("300");
		btnCat4_300.getStyleClass().add("rich-blue-2");
		btnCat4_300.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(3, 4);
                btnCat4_300.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		
		btnCat4_400.setText("400");
		btnCat4_400.getStyleClass().add("rich-blue-2");
		btnCat4_400.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(4, 4);
                btnCat4_400.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		btnCat4_500.setText("500");
		btnCat4_500.getStyleClass().add("rich-blue-2");
		btnCat4_500.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(5, 4);
                btnCat4_500.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		
		lblCat4.setAlignment(Pos.CENTER);
		vBox_cat4.getChildren().addAll(lblCat4, btnCat4_100, btnCat4_200, btnCat4_300, btnCat4_400, btnCat4_500);
		vBox_cat4.getStyleClass().add("h_or_v_box");
		
		return vBox_cat4;
	}
	
	// Creates the column of buttons for Category 5
	private  VBox createCategory5() {
		VBox vBox_cat5 = new VBox();
		Label lblCat5 = new Label(qa.getCategory(5));
		
		btnCat5_100.setText("100");
		btnCat5_100.getStyleClass().add("rich-blue-2");
		btnCat5_100.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(1, 5);
                btnCat5_100.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		btnCat5_200.setText("200");
		btnCat5_200.getStyleClass().add("rich-blue-2");
		btnCat5_200.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(2, 5);
                btnCat5_200.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		btnCat5_300.setText("300");
		btnCat5_300.getStyleClass().add("rich-blue-2");
		btnCat5_300.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(3, 5);
                btnCat5_300.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		
		btnCat5_400.setText("400");
		btnCat5_400.getStyleClass().add("rich-blue-2");
		btnCat5_400.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(4, 5);
                btnCat5_400.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		btnCat5_500.setText("500");
		btnCat5_500.getStyleClass().add("rich-blue-2");
		btnCat5_500.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showQuestionScreen(5,5);
                btnCat5_500.setStyle(" -fx-background-color: #c2d1f0; -fx-text-fill: #e8dab0;");
            }
        });
		
		
		lblCat5.setAlignment(Pos.CENTER);
		vBox_cat5.getChildren().addAll(lblCat5, btnCat5_100, btnCat5_200, btnCat5_300, btnCat5_400, btnCat5_500);
		vBox_cat5.getStyleClass().add("h_or_v_box");
		
		return vBox_cat5;
	}
	
	// Creates the window to display the question 
	// when a button is pressed,
	// this will display the question in the qa
	// at the given row and column

    public void showQuestionScreen(int column, int row) {
    	
    			try {
    				Stage primaryStage = new Stage();
    			    Pane grdRootPane = buildQuestionDisplay(row, column);
    			    
    			    btnClose.setOnAction(new EventHandler<ActionEvent>() {
    		            @Override
    		            public void handle(ActionEvent event) {
    		                primaryStage.close();
    		            }
    		        });
    			    
    			    btnTeam1.setOnAction(new EventHandler<ActionEvent>() {
    		            @Override
    		            public void handle(ActionEvent event) {
    		            	int pts = column * 100;
    		            	team1Pts.getItems().add(pts);
    		            	
    		            	int total = 0;
    		                int size = team1Pts.getItems().size();
    		                for(int i = 0; i < size; i++) {
    		                	total += team1Pts.getItems().get(i);
    		                }
    		                
    		                txaTeam1.setText(""+total);
    		            }
    		        });
    			    
    			    
    			    btnTeam2.setOnAction(new EventHandler<ActionEvent>() {
    		            @Override
    		            public void handle(ActionEvent event) {
    		                int pts = column * 100;
    		                team2Pts.getItems().add(pts);
    		                int total = 0;
    		                int size = team2Pts.getItems().size();
    		                for(int i = 0; i < size; i++) {
    		                	total += team2Pts.getItems().get(i);
    		                }
    		                
    		                txaTeam2.setText(""+total);
    		            }
    		        });
    			    
    			    Scene scene = new Scene(grdRootPane, 600, 400);
    				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    				primaryStage.setScene(scene);
    				primaryStage.setTitle("Trivia");
    				primaryStage.show();
    			} catch(Exception e) {
    				e.printStackTrace();
    			}
    }
    
    private  Pane buildQuestionDisplay(int row, int column) {
    	GridPane root = new GridPane();
    	root.setId("pane");
		root.getStyleClass().add("h_or_v_box");
		root.setAlignment(Pos.CENTER);
		root.getChildren().add(createDisplay(row, column));

		return root;
    }
    
    private  VBox createDisplay(int row, int column) {
        
        VBox box = new VBox();
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();
        
 
        String q = qa.getQuestion(row, column);
        String a = qa.getAnswer(row, column);
        
        Label question = new Label(q);
        question.setAlignment(Pos.CENTER);
        question.setWrapText(true);
        question.setMaxWidth(500);
        question.setMaxHeight(200);
        question.setTextAlignment(TextAlignment.CENTER);
        
        Label answer = new Label(a);
        answer.setAlignment(Pos.CENTER);
        answer.setWrapText(true);
        answer.setMaxWidth(500);
        answer.setMaxHeight(100);
        answer.setTextAlignment(TextAlignment.CENTER);
        
        btnAnswer.setAlignment(Pos.CENTER);
        btnAnswer.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		box.getChildren().add(answer);
        	}
        });
        
        btnClose.setAlignment(Pos.CENTER);
        btnTeam1.setAlignment(Pos.CENTER);
        btnTeam2.setAlignment(Pos.CENTER);
        
        hBox.setStyle("-fx-spacing:30px;");
        
        hBox.getChildren().addAll(btnAnswer, btnTeam1, btnTeam2,  btnClose);
        box.getChildren().addAll(question, hBox);
        hBox.setAlignment(Pos.CENTER);
        
        return box;
	}
	
}


