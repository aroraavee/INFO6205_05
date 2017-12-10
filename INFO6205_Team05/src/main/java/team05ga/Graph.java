/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team05ga;

/**
 *
 * @author Avee Arora
 */
import java.awt.Color;
import java.awt.BasicStroke;
import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class Graph extends JFrame {
    //Methof to generate the Graph of the route

    public Graph(String applicationTitle, String chartTitle, Route route) {
        super(applicationTitle);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle,
                "X-Coordinates",
                "Y-Coordinates",
                createDataset(route),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        final XYPlot plot = xylineChart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.YELLOW);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        plot.setRenderer(renderer);
        setContentPane(chartPanel);
    }
    //Add the data to the graph 

    private XYDataset createDataset(Route route) {
        final XYSeries routePoints = new XYSeries("Route", false, true);

        for (City city : route.getRouteList()) {
            routePoints.add(city.getX(), city.getY());

        }
        routePoints.add(route.getRouteList().get(0).getX(), route.getRouteList().get(0).getY());

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(routePoints);

        return dataset;
    }

}
