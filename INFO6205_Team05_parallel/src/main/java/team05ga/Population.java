/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team05ga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Avee Arora
 */
public class Population {

    ArrayList<Route> population;

    public ArrayList<Route> getPopulation() {
        return population;
    }

    public void setPopulation(ArrayList<Route> population) {
        this.population = population;
    }

    public Population() {
        population = new ArrayList<>();
    }

    //Constructor to generate initial population 
    public Population(int numberOfPopulation, boolean inital, int numberOfCities) {
        if (inital) {
            population = new ArrayList<>();
            Route route = Team5GA.citites(numberOfCities);
            for (int i = 0; i < numberOfPopulation; i++) { 
                Route tempRoute = new Route();
                for (City c : route.getRouteList()) {
                    tempRoute.getRouteList().add(c);
                }
                tempRoute.setDistance(0);
                tempRoute.setFittness(0);
                Collections.shuffle(tempRoute.getRouteList());
                int tempDistance = tempRoute.Distance(tempRoute);
                double tempFittness = tempRoute.Fitness(tempRoute);
                tempRoute.setDistance(tempDistance);
                tempRoute.setFittness(tempFittness);
                population.add(tempRoute);
            }
        } else {
            population = new ArrayList<>();
        }
    }
    //Method to get the fittest Route

    public Route getFittest(Population population) {
        Route fittest = population.getPopulation().get(0);
        for (int i = 1; i < population.getPopulation().size(); i++) {
            if (fittest.getFittness() <= population.getPopulation().get(i).getFittness()) {
                fittest = population.getPopulation().get(i);
            }
        }
        return fittest;
    }

}
