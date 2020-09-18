package application;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        xAxis.setLabel("Year");
        yAxis.setLabel("Party");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support for the parties");

        ArrayList<String> lines = lines("partiesdata.tsv");
        String years = lines.get(0);
        String[] yearPieces = years.split("\t");
        lines.remove(0);

        lines.stream().forEach((line) -> {
            String[] linePieces = line.split("\t");

            XYChart.Series data = new XYChart.Series();
            data.setName(linePieces[0]);

            for (int i = 1; i < yearPieces.length; i++) {

                if (!linePieces[i].equals("-")) {

                    data.getData().add(new XYChart.Data(Integer.valueOf(yearPieces[i]), Double.valueOf(linePieces[i])));
                }
            }

            lineChart.getData().add(data);

        });

        Scene scene = new Scene(lineChart, 640, 480);
        stage.setScene(scene);
        stage.show();

    }

    public static ArrayList<String> lines(String fileName) throws IOException {
        ArrayList<String> lines = new ArrayList<>();

        Scanner scanner = new Scanner(Paths.get(fileName));

        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }

        return lines;
    }
}
