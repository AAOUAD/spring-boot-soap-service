//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.02.18 à 05:01:00 PM CET 
//


package com.howtodoinjava.xml.school;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.howtodoinjava.xml.school package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.howtodoinjava.xml.school
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StudentDetailsResponse }
     * 
     */
    public StudentDetailsResponse createStudentDetailsResponse() {
        return new StudentDetailsResponse();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link StudentDetailsRequest }
     * 
     */
    public StudentDetailsRequest createStudentDetailsRequest() {
        return new StudentDetailsRequest();
    }

}
