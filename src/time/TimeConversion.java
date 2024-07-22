package time;


import java.util.HashMap;
import java.util.Map;

public class TimeConversion {
//    YEAR("Year"),
//    WEEK("Week"),
//    DAY("Day"),
//    HOUR("Hour"),
//    MINUTE("Minute"),
//    SECOND("Second");

    public Double getTimeConversion(double inputTime, String unit1, String unit2) {
        
        Map<String, HashMap<String, Double>> timeConversion = new HashMap<>();

        timeConversion.put(Time.YEAR.getName(), new HashMap<>());

        timeConversion.get(Time.YEAR.getName()).put(Time.YEAR.getName(), inputTime);
        timeConversion.get(Time.YEAR.getName()).put(Time.WEEK.getName(), inputTime * 52.143);
        timeConversion.get(Time.YEAR.getName()).put(Time.DAY.getName(), inputTime * 365);
        timeConversion.get(Time.YEAR.getName()).put(Time.HOUR.getName(), inputTime * 8760);
        timeConversion.get(Time.YEAR.getName()).put(Time.MINUTE.getName(), inputTime * 525600);
        timeConversion.get(Time.YEAR.getName()).put(Time.SECOND.getName(), inputTime * 3.154e7); //falta 3.154e+7

        timeConversion.put(Time.WEEK.getName(), new HashMap<>());

        timeConversion.get(Time.WEEK.getName()).put(Time.YEAR.getName(), inputTime / 52.143);
        timeConversion.get(Time.WEEK.getName()).put(Time.WEEK.getName(), inputTime);
        timeConversion.get(Time.WEEK.getName()).put(Time.DAY.getName(), inputTime * 7);
        timeConversion.get(Time.WEEK.getName()).put(Time.HOUR.getName(), inputTime * 168);
        timeConversion.get(Time.WEEK.getName()).put(Time.MINUTE.getName(), inputTime * 10080);
        timeConversion.get(Time.WEEK.getName()).put(Time.SECOND.getName(), inputTime * 604800);

        timeConversion.put(Time.DAY.getName(), new HashMap<>());

        timeConversion.get(Time.DAY.getName()).put(Time.YEAR.getName(), inputTime / 365);
        timeConversion.get(Time.DAY.getName()).put(Time.WEEK.getName(), inputTime / 7);
        timeConversion.get(Time.DAY.getName()).put(Time.DAY.getName(), inputTime);
        timeConversion.get(Time.DAY.getName()).put(Time.HOUR.getName(), inputTime * 24);
        timeConversion.get(Time.DAY.getName()).put(Time.MINUTE.getName(), inputTime * 1440);
        timeConversion.get(Time.DAY.getName()).put(Time.SECOND.getName(), inputTime * 86400);

        timeConversion.put(Time.HOUR.getName(), new HashMap<>());

        timeConversion.get(Time.HOUR.getName()).put(Time.YEAR.getName(), inputTime / 8760);
        timeConversion.get(Time.HOUR.getName()).put(Time.WEEK.getName(), inputTime / 168);
        timeConversion.get(Time.HOUR.getName()).put(Time.DAY.getName(), inputTime / 24);
        timeConversion.get(Time.HOUR.getName()).put(Time.HOUR.getName(), inputTime);
        timeConversion.get(Time.HOUR.getName()).put(Time.MINUTE.getName(), inputTime * 60);
        timeConversion.get(Time.HOUR.getName()).put(Time.SECOND.getName(), inputTime * 3600);


        timeConversion.put(Time.MINUTE.getName(), new HashMap<>());

        timeConversion.get(Time.MINUTE.getName()).put(Time.YEAR.getName(), inputTime / 525600);
        timeConversion.get(Time.MINUTE.getName()).put(Time.WEEK.getName(), inputTime / 10080);
        timeConversion.get(Time.MINUTE.getName()).put(Time.DAY.getName(), inputTime / 1440);
        timeConversion.get(Time.MINUTE.getName()).put(Time.HOUR.getName(), inputTime / 60);
        timeConversion.get(Time.MINUTE.getName()).put(Time.MINUTE.getName(), inputTime);
        timeConversion.get(Time.MINUTE.getName()).put(Time.SECOND.getName(), inputTime * 60);

        timeConversion.put(Time.SECOND.getName(), new HashMap<>());

        timeConversion.get(Time.SECOND.getName()).put(Time.YEAR.getName(), inputTime / 3.154e7);
        timeConversion.get(Time.SECOND.getName()).put(Time.WEEK.getName(), inputTime / 604800);
        timeConversion.get(Time.SECOND.getName()).put(Time.DAY.getName(), inputTime / 86400);
        timeConversion.get(Time.SECOND.getName()).put(Time.HOUR.getName(), inputTime / 3600);
        timeConversion.get(Time.SECOND.getName()).put(Time.MINUTE.getName(), inputTime / 60);
        timeConversion.get(Time.SECOND.getName()).put(Time.SECOND.getName(), inputTime);
        
        Double val = timeConversion.get(Time.valueOf(unit1.toUpperCase()).getName())
                .get(Time.valueOf(unit2.toUpperCase()).getName());

        return val;

    }
}
