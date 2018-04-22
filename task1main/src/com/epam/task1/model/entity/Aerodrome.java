package com.epam.task1.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Aerodrome {

    private List<Plane> planes;

    public Aerodrome() {
        planes = new ArrayList<>();
    }

    public Aerodrome(Aerodrome aerodrome) {
        this.planes = aerodrome.planes;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public void addPlane(Plane plane) {
        planes.add(plane);
    }

    public void removePlane(int index) {
        planes.remove(index);
    }

    public void removePlane(Plane plane) {
        planes.remove(plane);
    }

    //методы это обычно глаголы
    //назови его как-нибудь getSize()
    public int size() {
        return planes.size();
    }

    //вместо слова Aerodrome, здесь лучше использовать что-то типа getClass().getClassName() - что-бы при изменении имени класса - не пришлось менять toString метод
    @Override
    public String toString() {
        return "Aerodrome: " +
                "planes:" + planes;
    }
}
