/*
 EVENT HANDLER gave me trouble when finishing up. Couldnt get the total to appear.
 */
package workshopdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author SRonan
 */
public class WorkshopDemo extends Application {
    RadioButton genRadio;
    RadioButton studRadio;
    CheckBox openingCheckBox;
    Label totalLabel;
    ListView listView;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    @Override
    public void start(Stage primaryStage) {
        
        
        
        RadioButton genRadio = new RadioButton("General Registration");
        RadioButton studRadio = new RadioButton("Student Registration");
        
        genRadio.setSelected(true);
        
        ToggleGroup radioGroup = new ToggleGroup();
        genRadio.setToggleGroup(radioGroup);
        studRadio.setToggleGroup(radioGroup);
        
        openingCheckBox = new CheckBox("Opening Night Dinner.");
        Button totalButton = new Button("Get Total");
        totalButton.setOnAction(new TotalButtonHandler());
        
        
        Label selectedNameLabel = new Label("Select an Option WorkShop");
        
        ListView<String> listView = new ListView<>();
        listView.setPrefSize(300, 275);
        listView.getItems().addAll("Introduction to E-Commerce", "The Future of the Web", "Advanced Java Programming", "Network Security");
       
        Label totalLabel = new Label("$0.00");
       
        
      /*  totalButton.setOnAction(event ->
        {
           String selected = listView.getSelectionModel().getSelectedItem(); 
           totalLabel.setText(selected);
        });
        */
        VBox vbox = new VBox(20, genRadio, studRadio, openingCheckBox, selectedNameLabel, listView, totalLabel, totalButton);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        class TotalButtonHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {
         double result = 0;
         
         if (genRadio.isSelected())
            result += 895;        
         if (studRadio.isSelected())
            result += 495;
         if (openingCheckBox.isSelected())
             result += 30;             
        totalLabel.setText(String.format("$%, .2f", result));
      /*   ObservableList<String> workshops = workshopListView.getSelectedModel().getSelectedItems();
         for(String str : workshops)
         {
             if( workshop == "Introduction to E-Commerce" || """The Future of the Web")
               result += 295;
             else()
               result += 395;
             
         } */
       //  totalLabel.setText(String.format("$%, .2f", result));
    }
   }   
  }



      
