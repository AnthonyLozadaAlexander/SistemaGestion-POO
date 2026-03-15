package Clases;

public class EmpleadoMedioTiempo extends Empleado{
    private int horasTrabajadas;
    private double tarifaPorHora;

    public EmpleadoMedioTiempo(String nombre, int edad, double salarioBase, int horasTrabajadas, double tarifaPorHora){
        super(nombre, edad, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    // sobreescribiendo metodo de la clase padre Empleado
    @Override
    public double calcularSalario(){
     return super.calcularSalario() + (horasTrabajadas * tarifaPorHora);
    }

    @Override
    public String mostrarInfo(){
        return super.mostrarInfo() + "\n" +
                "Horas Trabajadas: " + horasTrabajadas + "\n" +
                "Tarifa por Hora: " + tarifaPorHora + "\n" +
                "Salario Total: " + calcularSalario();
    }
}


