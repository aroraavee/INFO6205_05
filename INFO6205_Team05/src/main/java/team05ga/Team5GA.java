/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team05ga;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Avee Arora
 */
public class Team5GA {

    /**
     * @param args the command line arguments
     */

    final static Logger logger = Logger.getLogger(Team5GA.class);
    //Method to create Random Cities with differnt coordinates
    public static Route citites(int numofCities) {
        Route initialRoute = new Route();
        Route temp = new Route();
        Random random = new Random();

        for (int i = 0; i < numofCities; i++) {
            boolean flag = true;
            while (flag) {
                int xCoordinate = random.nextInt(1000);
                int yCoordinate = random.nextInt(1000);
                City tempCity = new City(xCoordinate, yCoordinate, null);
                if (!temp.getRouteList().contains(tempCity)) {
                    flag = false;
                    City city = new City(xCoordinate, yCoordinate, "City" + i);
                    initialRoute.getRouteList().add(city);
                }
            }

        }

        return initialRoute;
    }

    //Travelling Salesperson Problem method
    public static Population TSP(int numOfCities, int numOfPopulation, int numOfEvolution, boolean print, boolean graph) {
        logger.info("The run is for " + numOfCities + " number of cities and generating " + numOfPopulation + " number of population with " + numOfEvolution + " number of evolution");
        Population initalPopulation = new Population(numOfPopulation, true, numOfCities);
        logger.info("Initial Population");
        logger.info(initalPopulation.getPopulation());
        Route initialFittest = initalPopulation.getFittest(initalPopulation);
        if (graph) {
            Graph chart = new Graph("Genetic Algorith to solve Travelling Salesperson Problem",
                    "Initial Route", initialFittest);
            chart.pack();
            RefineryUtilities.centerFrameOnScreen(chart);
            chart.setVisible(true);

        }

        Population evolvedPopulation = GA.evolvePopulation(initalPopulation);
        //Multiple time evolution 
        for (int i = 0; i < numOfEvolution; i++) {

            evolvedPopulation = GA.evolvePopulation(evolvedPopulation);

        }

        Route fittestRoute = evolvedPopulation.getFittest(evolvedPopulation);
        if (print) {
            System.out.println("The run is for " + numOfCities + " number of cities and generating " + numOfPopulation + " number of population with " + numOfEvolution + " number of evolution");
            System.out.println("Initial Fitness: " + initialFittest.Fitness(initialFittest));
            System.out.println("Initial Distance: " + initialFittest.Distance(initialFittest));
            System.out.println("Fittest Route" + fittestRoute);
            System.out.println("Fittnes Value:" + fittestRoute.Fitness(fittestRoute));
            System.out.println("Distance:" + fittestRoute.Distance(fittestRoute));
            logger.info("Final Results");
            logger.info("Initial Fitness: " + initialFittest.Fitness(initialFittest));
            logger.info("Initial Distance: " + initialFittest.Distance(initialFittest));
            logger.info("Fittest Route: " + fittestRoute);
            logger.info("Fittnes Value:" + fittestRoute.Fitness(fittestRoute));
            logger.info("Distance:" + fittestRoute.Distance(fittestRoute));
        }

        return evolvedPopulation;

    }

    //Main method to generate the Graph 
    public static void main(String args[]) {
        Population evlovedPopulation = team05ga.Team5GA.TSP(Configuration.numberOfCities, Configuration.numberOfPopulation, Configuration.numberOfEvolution, true, true);

        Graph chart = new Graph("Genetic Algorith to solve Travelling Salesperson Problem",
                "Fittest Route", evlovedPopulation.getFittest(evlovedPopulation));
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);

    }

}
