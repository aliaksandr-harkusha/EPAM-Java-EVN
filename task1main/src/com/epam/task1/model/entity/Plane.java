package com.epam.task1.model.entity;

import java.util.Objects;

public class Plane {
    private String model;
    private int crewCount;
    private int carryingCapacity;
    private float fuelConsumption;
    private int flightRange;

    public Plane() {
        this.model = "unknown";
    }

    public Plane(String model, int crewCount, int carryingCapacity, float fuelConsumption, int flightRange) {
        this.model = model;
        this.crewCount = crewCount;
        this.carryingCapacity = carryingCapacity;
        this.fuelConsumption = fuelConsumption;
        this.flightRange = flightRange;
    }

    //похоже на клонирование объекта 
    //в java за это отвечает метод clone - класса Object
    public Plane(Plane plane) {
        this.model = plane.model;
        this.crewCount = plane.crewCount;
        this.carryingCapacity = plane.carryingCapacity;
        this.fuelConsumption = plane.fuelConsumption;
        this.flightRange = plane.flightRange;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCrewCount() {
        return crewCount;
    }

    public void setCrewCount(int crewCount) {
        this.crewCount = crewCount;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public float getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return crewCount == plane.crewCount &&
                carryingCapacity == plane.carryingCapacity &&
                Float.compare(plane.fuelConsumption, fuelConsumption) == 0 &&
                Float.compare(plane.flightRange, flightRange) == 0 &&
                Objects.equals(model, plane.model);
    }

    @Override
    public int hashCode() {

        return Objects.hash(model, crewCount, carryingCapacity, fuelConsumption, flightRange);
    }

    @Override
    public String toString() {
        return "model='" + model + '\'' +
                ", crewCount=" + crewCount +
                ", carryingCapacity=" + carryingCapacity +
                ", fuelConsumption=" + fuelConsumption +
                ", flightRange=" + flightRange + " ";
    }
}
