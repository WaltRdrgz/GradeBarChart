package gradebarchart;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class CustomPane extends HBox
{
    private VBox subPane;
    private final Colors [] colors = Colors.values();
    
    public CustomPane(String name, double[] values, String[] labels)
    {
        subPane = new VBox(10);
        this.preparePane(name, values, labels);
    }
    
    public CustomPane(boolean ordered, String name, double[] values, String[] labels)
    {
        subPane = new VBox(10);
        this.preparePane(true, name, values, labels);
    }
    
    public void preparePane(String name, double[] values, String[] labels)
    {
        //name
        Text nameHolder = new Text(name);
        
        //HBox contains VBoxes from loop
        HBox fields = new HBox(3);
        
        for(int i =0; i < values.length; i++)
        {
            //bar
            Rectangle rectangle = new Rectangle( 25, values[i], Color.valueOf(this.colors[i] + ""));
            rectangle.setArcWidth(10);           
            rectangle.setArcHeight(10);
            
            //label
            Text label = new Text(labels[i]);
            label.setRotate(-90);
            
            //Stackpane; bar & label           
            StackPane sp = new StackPane(rectangle, label);
            
            //value
            Text value = new Text((Double.toString(values[i])) + "%");
            value.setRotate(-65);      
            
            //VBox; Value & Stackpane
            VBox field = new VBox(15, value, sp);
            field.setAlignment(Pos.BOTTOM_CENTER);
            fields.setAlignment(Pos.CENTER);
            fields.getChildren().add(field);
        }
        subPane.setAlignment(Pos.CENTER);
        subPane.getChildren().addAll(fields, nameHolder);     
    }
    
    public void preparePane(boolean ordered, String name, double[] values, String[] labels)
    {
        
 
        
    }

    public VBox getSubPane()
    {
        return subPane;
    }
}
