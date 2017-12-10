/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team05ga;

import java.util.ArrayList;

/**
 *
 * @author Avee Arora
 */
public class Route {

    ArrayList<City> routeList;
    private double fittness;
    private int distance;

    public Route() {
        routeList = new ArrayList<>();
    }

    public Route(int number) {
        routeList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            routeList.add(null);
        }
    }

    public void setCity(int routePosition, City city, Route route) {
        route.getRouteList().set(routePosition, city);
        fittness = 0;
        distance = 0;
    }
//Method to calculate the Distance 

    public int Distance(Route route) {
        if (route.getDistance() == 0) {
            int tourDistance = 0;
            for (int cityIndex = 0; cityIndex < route.getRouteList().size(); cityIndex++) {
                City fromCity = route.getRouteList().get(cityIndex);
                City destinationCity;
                if (cityIndex + 1 < route.getRouteList().size()) {
                    destinationCity = route.getRouteList().get(cityIndex + 1);
                } else {
                    destinationCity = route.getRouteList().get(0);
                }
                tourDistance += fromCity.distanceTo(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    //Method to get the Fitness Value 
    public double Fitness(Route route) {
        if (route.getFittness() == 0) {
            route.setFittness(1 / (double) Distance(route));
        }
        return route.getFittness();
    }

    public double getFittness() {
        return fittness;
    }

    public void setFittness(double fittness) {
        this.fittness = fittness;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public ArrayList<City> getRouteList() {
        return routeList;
    }

    public void setRouteList(ArrayList<City> routeList) {
        this.routeList = routeList;
    }
//To string to print the route 

    @Override
    public String toString() {
        String x = "";
        for (City c : routeList) {
            x += c.getName() + "-->";
        }
        return x;

    }

}
