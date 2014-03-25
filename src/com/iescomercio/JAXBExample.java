/*
Si os fijáis en el código del método, que será común para todos, realizar el Marshal es tan sencillo como:

    Obtener un JAXBContext sobre la clase a representar en xml (en nuestro caso).
    A partir de este contexto crear un ‘Marshaller’
    Configurar el formato de salida.
    Invocar al método para escribir la clase a xml.

En mi ejemplo uso un FileWriter en lugar de un File (cuya declaración he dejado en el ejemplo aunque no se usa) porque así podría ir volcando todas las representaciones a un único fichero, donde se iría añadiendo el xml de cada clase en cada invocación.

Si usáramos el File, estaríamos machacando el contenido si usamos el mismo nombre de fichero, o generando un nuevo fichero por cada invocación usando nombres distintos.

Ahora, para ejecutarlo:
 */
package com.iescomercio;

import java.util.ArrayList;
import java.util.Date;

public class JAXBExample {

    public static void main(String[] args) {
        marshallingExample();
    }

    /**
     * Crea una empresa y 10.000 empleados.
     */
    private static void marshallingExample() {

        long time = System.currentTimeMillis();
        System.out.println("Inicio: " + new Date(time));
        
        // Nos creamos un objeto empresa para serializar
        Empresa cc = new Empresa();
        cc.setIdEmpresa(1);
        cc.setDireccion("En la nube");
        cc.setNombreEmpresa("Art4Software");
        cc.setNumEmpleados(25000);
        
        // Nos creamos una lista de Empleados de esa empresa
        ArrayList<Empleado> alCU = new ArrayList<Empleado>();
        int init = 20000;
        for (int i = 1; i < 10000; i++) {
            Empleado cu = new Empleado();
            cu.setId(i);
            cu.setActivo(true);
            cu.setNumeroEmpl(new Integer(init++));
            cu.setNombre("Empleado " + i);
            cu.setTitulo("SW Architect");
            cu.setFechaAlta(new Date(System.currentTimeMillis()));

            alCU.add(cu);
        }

        cc.setEmpleados(alCU);
        long time2 = System.currentTimeMillis();
        System.out.println("Generacion: " + (time2 - time) + " milisegundoss - Marshaling: " + new Date(time2));
        cc.generateXML("Art4Software-Datos.xml");
        long time3 = System.currentTimeMillis();
        System.out.println("Fin: " + new Date(System.currentTimeMillis()) + " - Tiempo Total: " + (time3 - time) + " milisegundos");

    }
}
