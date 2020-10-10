package Seminar_6.ConverterTemperature;

public interface Temp {
    void translate();
    default void print(double temp_fin, String to) {System.out.printf("%.3f %s", temp_fin, to);}
    default double kelvinToCelsius(double temp) {return temp + 273.15;}
    default double celsiusToKelvin(double temp) {return temp - 273.15;}
    default double fahrenheitToCelsius(double temp) {return (temp - 32) / 1.8;}
    default double celsiusToFahrenheit(double temp) {return temp * 1.8 + 32;}
    default double kelvinToFahrenheit(double temp) {return (temp - 273.15) * 1.8 + 32;}
    default double fahrenheitToKelvin(double temp) {return (temp + 459.67) * 1.8;}
}
