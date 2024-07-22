package gui;


import temperature.TemperatureConversion;
import time.TimeConversion;

public class Units {
    private String tagFromConverter;


    public Units(String initTag){
        this.tagFromConverter = initTag;
    }

    public String getUnitsConversion(String inputText, String stringUnit1, String stringUnit2){
        if (this.tagFromConverter.equalsIgnoreCase("Temperature")){
            double fromTemp = Double.parseDouble(inputText);
            String unit1 = stringUnit1.substring(0, stringUnit1.length()-3);
            String unit2 = stringUnit2.substring(0,stringUnit2.length()-3);

            Double tempConversion = new TemperatureConversion().getTempConversion(fromTemp, unit1, unit2);

            //Transforma el double a float, reduciendo la cantidad de decimales
            float tempConversionFloat = tempConversion.floatValue();
            System.out.println("Temp: " + tempConversionFloat);
            return String.valueOf(tempConversionFloat);
        }

        if (this.tagFromConverter.equalsIgnoreCase("Time")){
            double inputTime = Double.parseDouble(inputText);
            Double timeConversion = new TimeConversion().getTimeConversion(inputTime, stringUnit1, stringUnit2);

            //Transforma el double a float, reduciendo la cantidad de decimales
            float timeConversionFloat = timeConversion.floatValue();
            System.out.println("Time: " + timeConversion.floatValue());

            return String.valueOf(timeConversionFloat);

        }

        return "0";
    }
}
