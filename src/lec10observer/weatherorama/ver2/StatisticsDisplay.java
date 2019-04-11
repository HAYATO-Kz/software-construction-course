package lec10observer.weatherorama.ver2;

import javax.swing.*;
import java.awt.*;

public class StatisticsDisplay implements Observer {

    private double prevTemp;
    private double prevWave;

    private int datapoint = 0;

    private JFrame frame;
    private JTextArea area,area2,area3;

    public StatisticsDisplay() {

        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Average Condition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(200, 200);
        area.setBackground(Color.ORANGE);
        area.setText("Average Condition:\n");

        area2 = new JTextArea(200, 200);
        area2.setBackground(Color.YELLOW);
        area2.setText("Average Wave Heigh Condition:\n");

        area3 = new JTextArea(100, 200);
        area3.setBackground(Color.GREEN);
        area3.setText("Pollution:\n\n");

        frame.setLayout(new GridLayout(3, 1));
        frame.add(area);
        frame.add(area2);
        frame.add(area3);
    }

    @Override
    public void update(Subject data) {
        if (data instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) data;

            if (prevTemp == 0)
                prevTemp = weatherData.getTemperature();
            double avg = (prevTemp + weatherData.getTemperature()) / 2;
            prevTemp = avg;

            area.setBackground(Color.ORANGE);
            area.setText("Average Condition:\n");
            area.append("Temperature = " + avg);
        }

        if (data instanceof OceanData) {
            OceanData oceanData = (OceanData) data;
            double avg;
            datapoint++;
            if (prevWave == 0) {
                avg = oceanData.getWaveHeight();
            }
            else{
                avg = (prevWave + oceanData.getWaveHeight() ) / datapoint;
            }

            prevWave += oceanData.getWaveHeight();
            System.out.println(prevWave);

            area2.setBackground(Color.YELLOW);
            area2.setText("Average Wave Heigh Condition:\n");
            area2.append("Wave Heigh =  " + avg);
        }

        if (data instanceof  PollutionData) {
            PollutionData pollutionData = (PollutionData) data;
            area3.setBackground(Color.CYAN);
            area3.setText("Pollution:\n\n");
            area3.append("Pollution = " + pollutionData.getPollution()+ "\n");
        }
    }
}
