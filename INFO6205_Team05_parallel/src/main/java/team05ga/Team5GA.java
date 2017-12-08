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
        logger.info("The run is for "+numOfCities+" number of cities and generating "+numOfPopulation+" number of population with "+numOfEvolution+" number of evolution");
        Population initalPopulation = new Population(numOfPopulation, true, numOfCities);
        logger.info("Initial Population");
        logger.info(initalPopulation.getPopulation());
        Route initialFittest = initalPopulation.getFittest(initalPopulation);
          System.out.println("Initial Fitness: " + initialFittest.Fitness(initialFittest));
  System.out.println("Initial Distance: " + initialFittest.Distance(initialFittest));
      
      Population newPopulation = new Population();
        
         GA.evolvePopulation(initalPopulation,newPopulation , Configuration.numberOfPopulation);
        
        //Multiple time evolution 
        for (int i = 0; i < Configuration.numberOfEvolution; i++) {
            Population newTempPopulation = new Population();
           GA.evolvePopulation(newPopulation,newTempPopulation,0);
           newPopulation = newTempPopulation;
           
        }
         print(newPopulation);

//        Route fittestRoute = newPopulation.getFittest(newPopulation);
//        if (print) {
//            
//            System.out.println("Initial Fitness: " + initialFittest.Fitness(initialFittest));
//            System.out.println("Initial Distance: " + initialFittest.Distance(initialFittest));
//            System.out.println("Fittest Route" + fittestRoute);
//            System.out.println("Fittnes Value:" + fittestRoute.Fitness(fittestRoute));
//            System.out.println("Distance:" + fittestRoute.Distance(fittestRoute));
//            logger.info("Final Results");
//            logger.info("Initial Fitness: " + initialFittest.Fitness(initialFittest));
//            logger.info("Initial Distance: " + initialFittest.Distance(initialFittest));
//            logger.info("Fittest Route: " + fittestRoute);
//            logger.info("Fittnes Value:" + fittestRoute.Fitness(fittestRoute));
//            logger.info("Distance:" + fittestRoute.Distance(fittestRoute));
//        }

        return newPopulation;

    }
    public static void print(Population newPopulation)
    {
         Route fittestRoute = newPopulation.getFittest(newPopulation);
     
            System.out.println("Fittest Route" + fittestRoute);
            System.out.println("Fittnes Value:" + fittestRoute.Fitness(fittestRoute));
            System.out.println("Distance:" + fittestRoute.Distance(fittestRoute));
            
    }

}
