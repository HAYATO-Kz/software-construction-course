package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class ForecastDisplay implements Observer {

    private JFrame frame;
    private JTextArea area;
    private double hu = 0;
    private double datapoint = 0;

    public ForecastDisplay() {
        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Forecast");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(150, 150);
        frame.add(area);
        area.setBackground(Color.WHITE);
        area.setText("fore:\n\n");
    }

    @Override
    public void update(double temp, double humid, double pressure) {
        area.setBackground(Color.WHITE);
        hu += temp;
        datapoint++;
        double avg = (hu) / datapoint;
        area.setText("fore:\n\n");
        area.append("AVG = " + avg);
        ;
    }
}
