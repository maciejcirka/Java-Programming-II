package application;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        NumberAxis xAxis = new NumberAxis(2007, 2017,1);
        NumberAxis yAxis = new NumberAxis(1, 100, 4);
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Rank");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("The University of Helsinki ranks in the years 2007-2017");
        
        XYChart.Series rankData = new XYChart.Series();
        rankData.setName("Rank");
        
        rankData.getData().add(new XYChart.Data(2007, 73));
        rankData.getData().add(new XYChart.Data(2008, 68));
        rankData.getData().add(new XYChart.Data(2009, 72));
        rankData.getData().add(new XYChart.Data(2010, 72));
        rankData.getData().add(new XYChart.Data(2011, 74));
        rankData.getData().add(new XYChart.Data(2012, 73));
        rankData.getData().add(new XYChart.Data(2013, 76));
        rankData.getData().add(new XYChart.Data(2014, 73));
        rankData.getData().add(new XYChart.Data(2015, 67));
        rankData.getData().add(new XYChart.Data(2016, 56));
        rankData.getData().add(new XYChart.Data(2017, 56));
     
        lineChart.getData().add(rankData);
        
        Scene scene = new Scene(lineChart, 640, 480);
        stage.setScene(scene);
        stage.show();
         
        
    }

    
}
