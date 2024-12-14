package bbdd;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import bbdd.model.Pasajero;
import bbdd.model.Entretenimiento;
import bbdd.model.Gasto;


public class Main 
{
    public static void main( String[] args )
    {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        // @TODO Crear un nuevo pasajero llamado "Din Djarin" y un nuevo entretenimiento
        // llamado "Bounty Hunting" y guardarlos en la base de datos. Añade un gasto de
        // 100 a "Din Djarin" para "Bounty Hunting".

        Pasajero pasajero1 = new Pasajero("Din Djarin");
        Entretenimiento entretenimiento1 = new Entretenimiento("Bounty Hunting");
        Gasto gasto1 = new Gasto(pasajero1, entretenimiento1, 100);
        pasajero1.getGastos().add(gasto1);
        entretenimiento1.getGastos().add(gasto1);

        session.beginTransaction();
        session.save(pasajero1);
        session.save(entretenimiento1);
        session.save(gasto1);
        session.getTransaction().commit();

        // @TODO Leer el fichero CSV gastos.csv que se encuentra en el directorio "resources" y 
        // recorrerlo usando CSVParser para crear los pasajeros, entretenimientos y gastos que
        // en él se encuentran. Dichos gastos deberán ser asignados al pasajero/a y al entretenimiento 
        // correspondientes. Se deben guardar todos estos datos en la base de datos.

        //Si el reader da problemas en encontrar el .csv usar una ruta absoluta
        try (Reader reader = Files.newBufferedReader(Paths.get("resources/gastos.csv"));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            session.beginTransaction();

            for (CSVRecord record : csvParser) {
                String pasajeroNombre = record.get("pasajero");
                String entretenimientoNombre = record.get("entretenimiento");
                int cantidad = Integer.parseInt(record.get("cantidad"));

                // Crear directamente pasajero y entretenimiento
                Pasajero pasajero = new Pasajero(pasajeroNombre);
                Entretenimiento entretenimiento = new Entretenimiento(entretenimientoNombre);

                // Crea el gasto
                Gasto gasto = new Gasto(pasajero, entretenimiento, cantidad);

                // Asocia el gasto
                pasajero.getGastos().add(gasto);
                entretenimiento.getGastos().add(gasto);

                // Guardar en BBDD
                session.save(pasajero);
                session.save(entretenimiento);
                session.save(gasto);
            }

            session.getTransaction().commit();
        //Para atrapar los problemas con el fichero(busqueda, lectura...)
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        }


        session.close();

    }
}





