package Exercise_1.Behavioural_Design_pattern;
//usecase-1: Observer Pattern [Behavioural]

import java.util.*;

// Observer interface
interface Observer {
    void update(double stockPrice);
}

// Concrete Observer 1
class Broker implements Observer {
    private String name;

    public Broker(String name) {
        this.name = name;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println("Broker " + name + " is notified. New Stock Price: $" + stockPrice);
    }
}

// Concrete Observer 2
class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println("Investor " + name + " is notified. New Stock Price: $" + stockPrice);
    }
}

// Subject (Observable)
class Stock {
    private List<Observer> observers = new ArrayList<>();
    private double stockPrice;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }
}

// Demo
public class ObserverPattern {
    public static void main(String[] args) {
        Stock stock = new Stock();

        Broker broker1 = new Broker("Alice");
        Investor investor1 = new Investor("Bob");

        stock.addObserver(broker1);
        stock.addObserver(investor1);

        // Simulate stock price change
        stock.setStockPrice(100.50);
        stock.setStockPrice(101.75);
    }
}
