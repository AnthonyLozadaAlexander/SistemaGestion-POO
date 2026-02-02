package Clases;

public class EmpleadoMedioTiempo extends Empleado{
    private int horasTrabajadas;
    private double tarifaPorHora;

    public EmpleadoMedioTiempo(String nombre, int edad, double salarioBase, int horasTrabajadas, double tarifaPorHora){
        super(nombre, edad, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }
}
