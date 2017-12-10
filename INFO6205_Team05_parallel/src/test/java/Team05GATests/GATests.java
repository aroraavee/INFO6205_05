/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Team05GATests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;
import team05ga.City;
import team05ga.Configuration;
import team05ga.Population;
import team05ga.Route;


/**
 *
 * @author Avee Arora
 */
public class GATests {
    
    @Test
    public void TSP() {
        Population evlovedPopulation = team05ga.Team5GA.TSP(Configuration.numberOfCities, Configuration.numberOfPopulation, Configuration.numberOfEvolution, true);
        //check the population size after evolution
        assertEquals(evlovedPopulation.getPopulation().size(), Configuration.numberOfPopulation);
        //check the size of cities of fitest route
        assertEquals(evlovedPopulation.getFittest(evlovedPopulation).getRouteList().size(), Configuration.numberOfCities);
        //checking for Null in the fitest route
        HashMap<City, String> checkCities = new HashMap<City, String>();
        Route fittest = evlovedPopulation.getFittest(evlovedPopulation);
        boolean nullFlag = false;
        for (City city : fittest.getRouteList()) {
            checkCities.put(city, null);
        }
         nullFlag = fittest.getRouteList().contains(null);
        //check for number of city in fitest route
        assertEquals(checkCities.size(), Configuration.numberOfCities);
        //check for null
        assertEquals(nullFlag, false);

    }
    //Test to check the distance method
    @Test
    public void distanceTest() {
        Route route = new Route();
        City c1 = new City(100, 0, "city1");
        City c2 = new City(200, 0, "City2");
        City c3 = new City(0, 0, "City3");
        route.getRouteList().add(c3);
        route.getRouteList().add(c1);
        route.getRouteList().add(c2);
        assertEquals(route.Distance(route), 400);
    }
    //Test to check the fitness Method
    @Test
    public void fitnessTest() {
        Route route = new Route();
        City c1 = new City(100, 0, "city1");
        City c2 = new City(200, 0, "City2");
        City c3 = new City(0, 0, "City3");
        route.getRouteList().add(c3);
        route.getRouteList().add(c1);
        route.getRouteList().add(c2);
        assertEquals(route.Fitness(route), 0.0025, 0);
    }
    //Test to check the fites route
    @Test
    public void fitnessFunction() {
        Population population = new Population();
        Route route = new Route();
        City c1 = new City(100, 0, "city1");
        City c2 = new City(200, 0, "City2");
        City c3 = new City(0, 0, "City3");
        route.getRouteList().add(c3);
        route.getRouteList().add(c1);
        route.getRouteList().add(c2);
        population.getPopulation().add(route);
        Route route1 = new Route();
        route1.getRouteList().add(c1);
        route1.getRouteList().add(c2);
        route1.getRouteList().add(c3);
        population.getPopulation().add(route1);
        Route route2 = new Route();
        route2.getRouteList().add(c2);
        route2.getRouteList().add(c1);
        route2.getRouteList().add(c3);
        population.getPopulation().add(route2);
        Route fittest = population.getFittest(population);
        assertEquals(fittest.Fitness(fittest), 0.0025, 0);
        assertEquals(fittest.Distance(fittest), 400);
    }
 
}
