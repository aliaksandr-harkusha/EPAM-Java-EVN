//пакет logic - не должен располагаться внутри модели
//вынеси его рядышком с моделью расположи
package com.epam.task1.model.logic;

import com.epam.task1.exception.InputLogicException;
import com.epam.task1.model.entity.Aerodrome;
import com.epam.task1.model.entity.Airliner;
import com.epam.task1.model.entity.CargoPlane;
import com.epam.task1.model.entity.Plane;

import java.util.Collections;
import java.util.Comparator;

public class AerodromeLogic {
    //синглтоны пока использовать не будем
    private static AerodromeLogic instance = new AerodromeLogic();

    public static AerodromeLogic getInstance() {
        return instance;
    }

    public int countTotalCarryingCapacity(Aerodrome aerodrome) {
        int totalCapacity = 0;
        for (int i = 0; i < aerodrome.size(); i++) {
            //здесь лучше 1 раз перед циклом вызвать aerodrome.getPlanes()  
            //а потом пройтись по коллекции циклом forEach вместо цикла for
            Plane currentPlane = aerodrome.getPlanes().get(i);
            totalCapacity += currentPlane.getCarryingCapacity();
        }
        return totalCapacity;
    }

    public int countTotalSeatingCapacityIncludingCrew(Aerodrome aerodrome) {
        int totalCapacity = 0;
        for (int i = 0; i < aerodrome.size(); i++) {
            Plane currentPlane = aerodrome.getPlanes().get(i);
            if (currentPlane instanceof Airliner) {
                totalCapacity += ((Airliner) currentPlane).getSeatingCapacity() + currentPlane.getCrewCount();
            } else {
                totalCapacity += currentPlane.getCrewCount();
            }
        }
        return totalCapacity;
    }

    public int countTotalSeatingCapacityWithoutCrew(Aerodrome aerodrome) {
        int totalCapacity = 0;
        for (int i = 0; i < aerodrome.size(); i++) {
            Plane currentPlane = aerodrome.getPlanes().get(i);
            if (currentPlane instanceof Airliner) {
                totalCapacity += ((Airliner) currentPlane).getSeatingCapacity();
            }
        }
        return totalCapacity;
    }

    public float countTotalCargoVolume(Aerodrome aerodrome) {
        float totalVolume = 0;
        for (int i = 0; i < aerodrome.size(); i++) {
            Plane currentPlane = aerodrome.getPlanes().get(i);
            if (currentPlane instanceof CargoPlane) {
                totalVolume += ((CargoPlane) currentPlane).getCargoVolume();
            }
        }
        return totalVolume;
    }


    public void sortOnFlightRange(Aerodrome aerodrome) {
       //лучше раелизуй компаратор внутри класса Plane
        // так при компиляции не будет создаваться дополнительный анонимный класс
        Collections.sort(aerodrome.getPlanes(), new Comparator<Plane>() {
            @Override
            public int compare(Plane o1, Plane o2) {
                return (int) (o1.getFlightRange() - o2.getFlightRange());
            }
        });
    }


    public Plane findPlaneWithFuelConsumption(Aerodrome aerodrome, float from, float towards) throws InputLogicException {
        if (from < 0.0f || towards < 0.0f) {
            throw new InputLogicException("fuel limits can't be negative");
        }
        for (int i = 0; i < aerodrome.size(); i++) {
            Plane currentPlane = aerodrome.getPlanes().get(i);
            if (currentPlane.getFuelConsumption() > from && currentPlane.getFuelConsumption() < towards) {
                return currentPlane;
            }
        }
        //перестрой метод так чтобы null не возвращать
        return null;
    }

}
