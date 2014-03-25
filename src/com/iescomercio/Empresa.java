/*
JAXB, acrónimo de ‘Java Architecture for Xml Binding‘, es un API para convertir objetos Java en xml y leer esos mismos xml para obtener objetos Java, que desde la versión 7 tenemos disponible en nuestros JDKs.

Recientemente nos surgió la necesidad, en uno de los proyectos en los que trabajo, de poder guardar ‘evidencias’ de objetos durante la ejecución de una serie de programas a modo de registro para poder analizar el comportamiento y evolución de una serie de datos calculados.

La primera idea para hacer esto sería el escribir un método ‘toString’ que nos devuelva los valores del objeto de tal forma que los podamos ir volcando a uno o varios ficheros, para luego poder analizarlos.

Pero fue esa misma necesidad de poder analizarlos posteriormente la que me hizo pensar en hacer algo más elaborado, de forma que no solo pudiésemos obtener una representación de cada objeto en un momento dado, si no también poder luego explotar esa información desde nuestro aplicación de análisis.

Así fue como decidí tirar de JAXB, ahora que se ha incorporado a Java 7, pensando en obtener una representación que no dependiese de formatos propios y fuese fácilmente explotable.

La ventaja de JAXB reside en su capacidad de realizar ‘marshal’ y ‘unmarshal’ de objetos Java de forma directa, mediante el uso de anotaciones para indicar qué campos son los que queremos incluir en el xml, de una forma rápida, sencilla y no dependiente de un esquema.

El no depender de un esquema nos aporta además la ventaja añadida de poder realizar cambios sobre los objetos sin necesitar de realizar cambios en el parser que usáramos para convertir a xml y viceversa.

Para ver lo sencillo que es, planteemos un ejemplo.
Supongamos que tenemos una Clase Empresa:
 */

package com.iescomercio;


import java.util.ArrayList;
 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
 

 
@XmlRootElement
@XmlType (propOrder = { "nombreEmpresa", "idEmpresa", "direccion", "numEmpleados", "empleados" })
public class Empresa extends MarshalClass {
 
    private int idEmpresa;
    private String nombreEmpresa;
    private String direccion;
    private int numEmpleados;
    private ArrayList<Empleado> empleados;
 
    public int getIdEmpresa() {
        return idEmpresa;
    }
 
    @XmlElement
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
 
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
 
    @XmlElement
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
 
    public String getDireccion() {
        return direccion;
    }
 
    @XmlElement
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
 
    public int getNumEmpleados() {
        return numEmpleados;
    }
 
    @XmlElement
    public void setNumEmpleados(int numEmpleados) {
        this.numEmpleados = numEmpleados;
    }
 
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
 
    @XmlElement
    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
}