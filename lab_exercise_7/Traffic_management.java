package lab_exercise_7;

import java.util.*;

class TrafficSignal {
    private String signalId;
    private String currentState;

    public TrafficSignal(String signalId) {
        this.signalId = signalId;
        this.currentState = "RED"; 
    }

    public void changeState(String newState) {
        this.currentState = newState;
        System.out.println("Signal " + signalId + " changed to " + newState);
    }

    public String getStatus() {
        return "Signal " + signalId + ": " + currentState;
    }
}

class Junction {
    private String junctionName;
    private List<TrafficSignal> signals;

    public Junction(String junctionName) {
        this.junctionName = junctionName;
        this.signals = new ArrayList<>();
        
        signals.add(new TrafficSignal(junctionName + "-1"));
        signals.add(new TrafficSignal(junctionName + "-2"));
        signals.add(new TrafficSignal(junctionName + "-3"));
    }

    public void addSignal(TrafficSignal signal) {
        signals.add(signal);
    }

    public void displaySignalStatus() {
        System.out.println("\nJunction: " + junctionName);
        for (TrafficSignal signal : signals) {
            System.out.println("  " + signal.getStatus());
        }
    }

    public void changeAllSignals(String state) {
        for (TrafficSignal signal : signals) {
            signal.changeState(state);
        }
    }
}


class City {
    private String cityName;
    private List<Junction> junctions;

    public City(String cityName) {
        this.cityName = cityName;
        this.junctions = new ArrayList<>();
    }

    public void addJunction(Junction junction) {
        junctions.add(junction);
    }

    public void displayAllJunctions() {
        System.out.println("\nCity: " + cityName + " Traffic Status");
        for (Junction junction : junctions) {
            junction.displaySignalStatus();
        }
    }
}

public class Traffic_management {
    public static void main(String[] args) {
        
        City smartCity = new City("Future City");
        
        Junction mainJunction = new Junction("Main Square");
        Junction schoolJunction = new Junction("School Crossing");
        Junction marketJunction = new Junction("Market Area");
        
        TrafficSignal specialSignal = new TrafficSignal("Special-1");
        marketJunction.addSignal(specialSignal);
        
        smartCity.addJunction(mainJunction);
        smartCity.addJunction(schoolJunction);
        smartCity.addJunction(marketJunction);
        
        smartCity.displayAllJunctions();
        
        mainJunction.changeAllSignals("GREEN");
        specialSignal.changeState("YELLOW");
        
        
        smartCity.displayAllJunctions();
    }
}