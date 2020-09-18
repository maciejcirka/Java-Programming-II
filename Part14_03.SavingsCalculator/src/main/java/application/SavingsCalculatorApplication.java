package application;

import java.util.HashMap;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    private XYChart.Series<Number, Number> savingsChart;
    private XYChart.Series<Number, Number> interestChart;
    private double savingsValue;
    private double interestValue;
    private LineChart<Number, Number> bigChart;

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane layout = new BorderPane();

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        bigChart = new LineChart<>(xAxis, yAxis);
        bigChart.setTitle("Savings calculator");
        bigChart.setLegendVisible(false);

        savingsChart = new XYChart.Series();
        interestChart = new XYChart.Series();
        savingsValue = 25.0;
        interestValue = 0.0;
        createSavingsData();
        createInterestData();
        update();

        //Sliders
        VBox top = new VBox();
        BorderPane s1 = new BorderPane();
        BorderPane s2 = new BorderPane();

        //Top Slider
        Label labelTop1 = new Label("Monthly savings");
        Label labelTop2 = new Label("25");
        Slider slider1 = new Slider(25, 250, 25);

        slider1.setShowTickLabels(true);
        slider1.setShowTickMarks(true);
        slider1.setBlockIncrement(50);
        slider1.setBlockIncrement(50);

        slider1.valueProperty().addListener((change, oldValue, newValue) -> {
            labelTop2.setText("" + newValue);
            slider1.setValue(Math.round(newValue.doubleValue() * 100.0) / 100.0);
            savingsValue = slider1.getValue();

            update();
        });

        s1.setLeft(labelTop1);
        s1.setCenter(slider1);
        s1.setRight(labelTop2);

        //Down Slider
        Label labelDown1 = new Label("Yearly interest rate");
        Label labelDown2 = new Label(String.valueOf(0));
        Slider slider2 = new Slider(0, 10, 0);

        slider2.setShowTickLabels(true);

        slider2.setBlockIncrement(50);
        slider2.setMinorTickCount(50);

        slider2.valueProperty().addListener((change, oldValue, newValue) -> {
            labelDown2.setText("" + newValue.doubleValue());
            slider2.setValue(Math.round(newValue.doubleValue() * 100.0) / 100.0);
            interestValue = slider2.getValue();

            update();
        });

        s2.setLeft(labelDown1);
        s2.setCenter(slider2);
        s2.setRight(labelDown2);

        top.getChildren().addAll(s1, s2);
        top.setSpacing(10);

        layout.setTop(top);
        layout.setCenter(bigChart);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(layout, 640, 480);
        stage.setScene(scene);
        stage.show();

    }

    private void update() {
        getSavingsMap().forEach((k, v)
                -> savingsChart.getData().get(k).setYValue(v));
        getInterestMap().forEach((k, v)
                -> interestChart.getData().get(k).setYValue(v));
    }

    private HashMap<Integer, Double> getSavingsMap() {
        HashMap<Integer, Double> data = new HashMap<>();
        for (int i = 0; i <= 30; i++) {
            double val = i * 12 * savingsValue;
            data.put(i, val);
        }
        return data;
    }

    private HashMap<Integer, Double> getInterestMap() {
        HashMap<Integer, Double> data = new HashMap<>();
        data.put(0, 0.0);
        for (int i = 1; i <= 30; ++i) {
            double val = 12 * savingsValue;
            double previous = data.get(i - 1);
            double interest = (val + previous) * (interestValue/100);
            data.put(i, val + previous + interest);
        }
        return data;
    }
    
    

    private void createSavingsData() {
        getSavingsMap().forEach((k, v)
                -> savingsChart.getData().add(new XYChart.Data<>(k, v)));

        bigChart.getData().add(savingsChart);
    }

    private void createInterestData() {
        getInterestMap().forEach((k, v)
                -> interestChart.getData().add(new XYChart.Data<>(k, v)));

        bigChart.getData().add(interestChart);
    }
}
