package temperature;

import java.util.HashMap;
import java.util.Map;

public class TemperatureConversion {


    public  Double getTempConversion(double fromTemp, String unit1, String unit2) {

        Map<String, HashMap<String, Double>> tempConversion = new HashMap<>();

        tempConversion.put(Temperature.CELSIUS.getName(), new HashMap<>());

        tempConversion.get(Temperature.CELSIUS.getName()).put(Temperature.KELVIN.getName(), fromTemp + 273.15);
        tempConversion.get(Temperature.CELSIUS.getName()).put(Temperature.CELSIUS.getName(), fromTemp);
        tempConversion.get(Temperature.CELSIUS.getName()).put(Temperature.FAHRENHEIT.getName(), (fromTemp*9/5) + 32D);
        tempConversion.get(Temperature.CELSIUS.getName()).put(Temperature.RANKINE.getName(), (fromTemp*9/5) + 491.67);


        tempConversion.put(Temperature.FAHRENHEIT.getName(), new HashMap<>());

        tempConversion.get(Temperature.FAHRENHEIT.getName()).put(Temperature.KELVIN.getName(), (fromTemp-32)* 5/9 + 273.15);
        tempConversion.get(Temperature.FAHRENHEIT.getName()).put(Temperature.CELSIUS.getName(), (fromTemp-32) * 5/9);
        tempConversion.get(Temperature.FAHRENHEIT.getName()).put(Temperature.FAHRENHEIT.getName(), fromTemp);
        tempConversion.get(Temperature.FAHRENHEIT.getName()).put(Temperature.RANKINE.getName(), fromTemp + 459.67);


        tempConversion.put(Temperature.KELVIN.getName(), new HashMap<>());

        tempConversion.get(Temperature.KELVIN.getName()).put(Temperature.KELVIN.getName(), fromTemp);
        tempConversion.get(Temperature.KELVIN.getName()).put(Temperature.CELSIUS.getName(), fromTemp - 273.15);
        tempConversion.get(Temperature.KELVIN.getName()).put(Temperature.FAHRENHEIT.getName(), (fromTemp-273.15) * 9/5 + 32);
        tempConversion.get(Temperature.KELVIN.getName()).put(Temperature.RANKINE.getName(), fromTemp * 1.8);


        tempConversion.put(Temperature.RANKINE.getName(), new HashMap<>());

        tempConversion.get(Temperature.RANKINE.getName()).put(Temperature.KELVIN.getName(), fromTemp * 5/9);
        tempConversion.get(Temperature.RANKINE.getName()).put(Temperature.CELSIUS.getName(), (fromTemp-491.67) * 5/9);
        tempConversion.get(Temperature.RANKINE.getName()).put(Temperature.FAHRENHEIT.getName(), fromTemp-459.67);
        tempConversion.get(Temperature.RANKINE.getName()).put(Temperature.RANKINE.getName(), fromTemp);

        Double val = tempConversion.get(Temperature.valueOf(unit1.toUpperCase()).getName())
                .get(Temperature.valueOf(unit2.toUpperCase()).getName());

        return val;

    }





}
