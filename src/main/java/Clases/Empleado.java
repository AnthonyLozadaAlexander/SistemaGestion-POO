package Clases;

public class Empleado {
    protected String nombre;
    protected int edad;
    protected double salarioBase;

    public Empleado(String nombre, int edad, double salarioBase) {
        this.nombre = nombre;
        this.edad = edad;
        this.salarioBase = salarioBase;
    }

    public String getNombre(){
        return nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double calcularSalario(){
        return salarioBase;
    }

    public String mostrarInfo() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Salario Base: " + salarioBase;
    }
}
