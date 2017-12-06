/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team5ga;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author Avee Arora
 */
public class Team5GA {

    /**
     * @param args the command line arguments
     */
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
    public static Population TSP(int numOfCities, int numOfPopulation, int numOfEvolution, boolean print) {
        Population initalPopulation = new Population(numOfPopulation, true, numOfCities);

        Route initialFittest = initalPopulation.getFittest(initalPopulation);

        Population evolvedPopulation = GA.evolvePopulation(initalPopulation);
        //Multiple time evolution 
        for (int i = 0; i < numOfEvolution; i++) {

            evolvedPopulation = GA.evolvePopulation(evolvedPopulation);

        }

        Route fittestRoute = evolvedPopulation.getFittest(evolvedPopulation);
        if (print) {
            System.out.println("Initial Fitness: " + initialFittest.Fitness(initialFittest));
            System.out.println("Initial Distance: " + initialFittest.Distance(initialFittest));
            System.out.println("Fittest Route" + fittestRoute);
            System.out.println("Fittnes Value:" + fittestRoute.Fitness(fittestRoute));
            System.out.println("Distance:" + fittestRoute.Distance(fittestRoute));
        }

        return evolvedPopulation;

    }

}
