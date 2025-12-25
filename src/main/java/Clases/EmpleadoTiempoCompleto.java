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
    public double calcularSalarioAnual() {
        return (salarioBase  + bonoAnual);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + "\n Bono Anual: " + bonoAnual + "\n Salario Anual: " + calcularSalarioAnual();
    }
}
