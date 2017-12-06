package team5ga;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author Avee Arora
 */
public class GA {

    public static Population evolvePopulation(Population pop) {
        Population newPopulation = null;
        Route child = null; 
            newPopulation = new Population();
        for (int i = 0; i < pop.getPopulation().size(); i++) {

            Population p1 = tempPopulation(pop);             
            child = crossover(p1.getPopulation().get(0), p1.getPopulation().get(1));
            mutate(child);
       
            int distance = child.Distance(child);
            double fitness = child.Fitness(child);
            child.setFittness(fitness);
            child.setDistance(distance);
            newPopulation.getPopulation().add(child);
           
        }
 
        return newPopulation;
     
    }
    public static Population tempPopulation(Population pop) {

        Population tempPopulation = new Population();
        for (int i = 0; i < 5; i++) {
            int randomId = (int) (Math.random() * pop.getPopulation().size());
            tempPopulation.getPopulation().add(i, pop.getPopulation().get(randomId));
        }
        Collections.sort(tempPopulation.getPopulation(), new Comparator<Route>() {
            @Override
            public int compare(Route o1, Route o2) {
                return (int) (o1.getDistance() - o2.getDistance());
            }

        });
        return tempPopulation;
    }
    
    public static Route crossover(Route parent1, Route parent2) {
        Route child = new Route(parent1.getRouteList().size());
        
        int startPos = (int) (Math.random() * parent1.getRouteList().size());
        int endPos = (int) (Math.random() * parent1.getRouteList().size());

        for (int i = 0; i < parent1.getRouteList().size(); i++) {
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setCity(i, parent1.getRouteList().get(i), child);
            }
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setCity(i, parent1.getRouteList().get(i), child);
                }
            }
        }
        for (int i = 0; i < parent2.getRouteList().size(); i++) {
            if (!child.getRouteList().contains(parent2.getRouteList().get(i))) {
                for (int ii = 0; ii < child.getRouteList().size(); ii++) {
                    if (child.getRouteList().get(ii) == null) {
                        child.setCity(ii, parent2.getRouteList().get(i), child);
                        break;
                    }
                }
            }
        }
     
        return child;
    }

    private static void mutate(Route route) {
            if (Math.random() < Configuration.mutationRate) {
                 int tourPos1 = (int) (route.getRouteList().size() * Math.random());
                int tourPos2 = (int) (route.getRouteList().size() * Math.random());
                City city1 = route.getRouteList().get(tourPos1);
                City city2 = route.getRouteList().get(tourPos2);
                route.setCity(tourPos2, city1, route);
                route.setCity(tourPos1, city2, route);        
        }
    }
   
}
