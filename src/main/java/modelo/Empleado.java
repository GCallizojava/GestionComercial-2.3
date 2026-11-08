/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Geovanny_Callizo
 */
public class Empleado extends Persona {
    
    private String codigo;
    private String puesto;
    private double salario;
    private String fechaIngreso;
    
    public Empleado(){
        
        super();
    }
public Empleado(int id, String identidad,
        String nombre, String apellido,
        String telefono, String correo,
        String fechaNacimiento, String codigo,
        String puesto, double salario,
        String fechaIngreso) {

    super(id, identidad, nombre, apellido,
          telefono, correo, fechaNacimiento);

    setCodigo(codigo);
    setPuesto(puesto);
    setSalario(salario);
    setFechaIngreso(fechaIngreso);
}
    public String getCodigo() {
        return codigo;
    }

   public void setCodigo(String codigo) {
    if (codigo == null || codigo.trim().isEmpty()) {
        throw new IllegalArgumentException(
            "El codigo del empleado es obligatorio"
        );
    }
    this.codigo = codigo;
}
    
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public double getSalario() {
    return salario;
}

public void setSalario(double salario) {
    if (salario <= 0) {
        throw new IllegalArgumentException(
            "El salario debe ser mayor que cero"
        );
    }
    this.salario = salario;
}
@Override
public String toString() {
    return "Empleado{" +
            "persona=" + super.toString() +
            ", codigo=" + codigo +
            ", puesto=" + puesto +
            ", salario=" + salario +
            ", fechaIngreso=" + fechaIngreso +
            '}';
}
}
