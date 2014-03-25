/*
Si os fijáis usamos 3 anotaciones: XmlRootElement, XmlType y XmlElement.

La primera marca el elemento raíz de nuestra clase (en nuestro caso el nombre de la clase). Con XmlType y la propiedad ‘propOrder’ cambiamos el orden en que se escribirán los atributos en el xml resultante.

Finalmente usando XmlElement en el setter de los atributos que nos interesa que se incluyan en el xml, marcamos los campos de nuestro interés.

Si os fijáis, ambas clases heredan de una tercera clase: MarshalClass.

¿Y para qué?

En mi caso, dado que la acción de guardar ‘evidencias’ se realizará sobre clases distintas, con esta herencia puedo limitar a un tipo común el manejo de las clases a guardar, haciendo que hereden de dicha clase el método de guardado:
 */

package com.iescomercio;

 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
 
public class MarshalClass {
 
    public void generateXML (String nameFile) {
 
        try {
            File file = new File (nameFile);
            JAXBContext jc = JAXBContext.newInstance(this.getClass());
            Marshaller jaxbMarshaller = jc.createMarshaller();
 
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
            jaxbMarshaller.marshal(this, new FileWriter(nameFile, true));
 
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
Para realizar la conversión de todos los objetos, tan solo necesitamos invocar al método sobre el objeto ‘Empresa’, sin tener que hacerlo por cada objeto del tipo ‘Empleado’ que pueda contener en el ArrayList.

Como podéis ver, hemos metido unas trazas para ver cuánto tiempo tarda en realizar la creación de los objetos y el volcado a xml, obteniendo los siguientes tiempos (con JDK 1.7u21, eclipse Indigo, en un PhenomII x6 1090T con 8GB RAM):

    Inicio: Fri Jun 07 22:38:56 CEST 2013
    Generacion: 29 milisegundoss – Marshaling: Fri Jun 07 22:38:56 CEST 2013
    Fin: Fri Jun 07 22:38:57 CEST 2013 – Tiempo Total: 312 milisegundos

Menos de medio segundo es un tiempo realmente bueno para lo que necesitamos realizar.

Ahora, a partir de aquí podríamos crearnos una aplicación que cargase un xml, o los xml contenidos en un directorio para una fecha concreta, y obtuviese todos los objetos grabados de nuevo para analizar los resultados.

Por último, importante tener en cuenta la siguiente tabla con la equivalencia de tipos de datos: (ver ejemplo)

*/