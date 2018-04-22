//папки типа idea и скомпилированные классы - не коммитаем  
package com.epam.task1.controller;

import com.epam.task1.exception.TaskOneException;
import com.epam.task1.model.entity.Aerodrome;
import com.epam.task1.model.logic.AerodromeLogic;
import com.epam.task1.util.AerodromeGenerator;
import com.epam.task1.view.Printer;

//Названия классов - с большой буквы 
public class main {
    public static void main(String[] args) {
        AerodromeGenerator generator = AerodromeGenerator.getInstance();
        Aerodrome aerodrome = generator.generateAerodrome();
        Printer printer = new Printer();
        printer.print(aerodrome.toString());
        try {
            printer.print("Cargo volume is: " + AerodromeLogic.getInstance().countTotalCargoVolume(aerodrome));
            printer.print("Carrying capacity is: " + AerodromeLogic.getInstance().countTotalCarryingCapacity(aerodrome));
            printer.print("Seat capacity: " + AerodromeLogic.getInstance().countTotalSeatingCapacityIncludingCrew(aerodrome));
            printer.print(AerodromeLogic.getInstance().findPlaneWithFuelConsumption(aerodrome, 400, 700));
            AerodromeLogic.getInstance().sortOnFlightRange(aerodrome);
            printer.print(aerodrome.toString());
        } catch (TaskOneException e) {
            e.printStackTrace();
        }
    }
}
