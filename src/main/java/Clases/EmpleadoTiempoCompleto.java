package Clases;

public class EmpleadoTiempoCompleto extends Empleado {
    private double bonoAnual;

    public EmpleadoTiempoCompleto(String nombre, int edad, double salarioBase, double bonoAnual) {
        super(nombre, edad, salarioBase);
        this.bonoAnual = bonoAnual;
    }

    public double getBonoAnual(){
        return bonoAnual;
    }

    @Override
    public double calcularSalario() {
        return (salarioBase  + bonoAnual);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + "\n Bono Anual: " + getBonoAnual() + "\n Salario Anual: " + calcularSalario();
    }
}
