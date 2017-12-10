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

/**
 *
 * @author Avee Arora
 */
public class Team5GA {

    /**
     * @param args the command line arguments
     */
    //Method to create Random Cities with differnt coordinates
    
    final static Logger logger = Logger.getLogger(Team5GA.class);
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
    public static Population TSP(int numOfCities, int numOfPopulation, int numOfEvolution, boolean print) {
        System.out.println("The run is for "+numOfCities+" number of cities and generating "+numOfPopulation+" number of population with "+numOfEvolution+" number of evolution");
        Population initalPopulation = new Population(numOfPopulation, true, numOfCities);
        Route initialFittest = initalPopulation.getFittest(initalPopulation);
          System.out.println("Initial Fitness: " + initialFittest.Fitness(initialFittest));
    System.out.println("Initial Distance: " + initialFittest.Distance(initialFittest));
 
      Population newPopulation = new Population();
         GA.evolvePopulation(initalPopulation,newPopulation);
        //Multiple time evolution 
        for (int i = 0; i < Configuration.numberOfEvolution; i++) {
            Population newTempPopulation = new Population();
           GA.evolvePopulation(newPopulation,newTempPopulation);
           newPopulation = newTempPopulation;
           
        }
         print(newPopulation);

        return newPopulation;

    }
    public static void print(Population newPopulation)
    {
         Route fittestRoute = newPopulation.getFittest(newPopulation);
     
            System.out.println("Fittest Route" + fittestRoute);
            System.out.println("Fittnes Value:" + fittestRoute.Fitness(fittestRoute));
            System.out.println("Distance:" + fittestRoute.Distance(fittestRoute));
            System.out.println("Number of futures created " +GA.count);
            System.out.println("Number of child created per future="+(Configuration.numberOfPopulation/Configuration.numberOfCities));
            System.out.println("Number of Evolutions = "+Configuration.numberOfEvolution);
            
    }

}
