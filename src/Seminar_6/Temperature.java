package Seminar_6;

import java.util.InputMismatchException;

public class Temperature implements Temp {
    double temp, temp_fin;
    String from, to;

    public Temperature(double temp, String from, String to){
        this.temp = temp;
        this.from = from.toLowerCase();
        this.to = to.toLowerCase();
    }

    @Override
    public void translate() {
        try {
            if (from.equals("kelvin") & to.equals("celsius")) temp_fin = kelvinToCelsius(temp);
            else if (from.equals("celsius") & to.equals("kelvin")) temp_fin = celsiusToKelvin(temp);
            else if (from.equals("fahrenheit") & to.equals("celsius")) temp_fin = fahrenheitToCelsius(temp);
            else if (from.equals("celsius") & to.equals("fahrenheit")) temp_fin = celsiusToFahrenheit(temp);
            else if (from.equals("fahrenheit") & to.equals("kelvin")) temp_fin = fahrenheitToKelvin(temp);
            else if (from.equals("kelvin") & to.equals("fahrenheit")) temp_fin = kelvinToFahrenheit(temp);
            else throw new InputMismatchException();
        }
        catch (InputMismatchException e) {
            System.out.println("Incorrect type of temperature!");
        }
        print(temp_fin, to);
    }


}
