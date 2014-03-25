// http://blog.art4software.com/2013/06/un-pequeno-ejemplo-con-jaxb/
// Como podemos ver nuestra Empresa tiene Empleados:

package com.iescomercio;
 
import java.util.Date; 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 

 
@XmlRootElement(name="Empl")
public class Empleado extends MarshalClass{
 
    private int id;
    private String nombre;
    private String titulo;
    private boolean activo=false;
    private Integer numeroEmpl;
    private Date fechaAlta;
 
    public int getId() {
        return id;
    }
 
    @XmlElement
    public void setId(int id) {
        this.id = id;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    @XmlElement
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getTitulo() {
        return titulo;
    }
 
    @XmlElement
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
 
    public boolean isActivo() {
        return activo;
    }
 
    @XmlElement
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
 
    public Integer getNumeroEmpl() {
        return numeroEmpl;
    }
 
    @XmlElement
    public void setNumeroEmpl(Integer numeroEmpl) {
        this.numeroEmpl = numeroEmpl;
    }
 
    public Date getFechaAlta() {
        return fechaAlta;
    }
 
    @XmlElement
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
 
}