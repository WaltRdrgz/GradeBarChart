package gradebarchart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class BarGraph extends Application
{
    HBox mainPane = new HBox(10);
    Scene scene = new Scene(mainPane);

    @Override
    public void start(Stage primaryStage)
    {
        setup();
        
        primaryStage.setTitle("Bars");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setup()
    {
        String[][] allData = readData();
        
        int i = 0;
        
        while(i < allData.length){
            String name = allData[i][0] + " " + allData[i][1];
            i++;
            
            double[] values = new double[allData[i].length];
     
            for(int j = 0; j < allData[i].length; j++){
                String number = allData[i][j];            
                double percent = Double.parseDouble(number);
                values[j] = percent;
            }           
            i++; 
            
            String[] labels = allData[i];

            i++;

            CustomPane CP = new CustomPane(name, values, labels);
            CP.setAlignment(Pos.BOTTOM_CENTER);
            VBox vbox = new VBox(CP.getSubPane());
            mainPane.getChildren().add(vbox);           
        }
        mainPane.setPadding(new Insets(30,30,30,30));
        mainPane.setStyle("-fx-background-color: grey");
        mainPane.setSpacing(30);
        mainPane.setAlignment(Pos.BOTTOM_CENTER);
    }


    public String[][] readData()
    {
        
        String[][] string = null;
        try{
            File file = new File("src/gradebarchart/data.txt");
            Scanner rowcounter = new Scanner(file);
            int row = 0;
 
            while (rowcounter.hasNextLine()) {
                rowcounter.nextLine();
                row++;
            }           
        
            Scanner data = new Scanner(file);           
            string = new String[row][];
            row = 0;

                while(data.hasNextLine()) {
                    String line = data.nextLine();                   
                    String[] values = line.split(" ");
                    string[row] = values;
                    row++;
            }                     
       }
       catch (FileNotFoundException ex) {
           System.out.println("file not found");
       }
        return(string);
    }
    
    public static void main(String[] args)
    {
        Application.launch(args);
    }
    
}

