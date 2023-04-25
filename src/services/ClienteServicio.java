package services;


import entities.Cliente;
import entities.Cuenta;

import java.util.ArrayList;
import java.util.Scanner;

public class ClienteServicio {

    Scanner leer = new Scanner(System.in);
    // Crea un ArrayList vacío de clientes


    public void crearCliente(ArrayList<Cliente> arrayClientes2) {
        boolean valido = false;
        Cliente cliente = new Cliente();

        do {

        System.out.println(" ingrese el nombre del cliente : ");
        String nombre = (leer.nextLine());
            if (nombre.matches("[a-zA-Z]+") ){
                cliente.setNombre(nombre);
                valido = true;

            } else {
                System.out.println("El nombre ingresado no es válido. Por favor ingrese solo letras.");
                valido = false;
            }
        } while (!valido);


        do {
        System.out.print("Ingrese su DNI: ");
        String dniString = leer.nextLine();

            if (dniString.matches("[0-9]+")) {
                int dni = Integer.parseInt(dniString);
                cliente.setDni(dniString);
                valido = true;

            } else {
                System.out.println("El DNI ingresado no es válido. Por favor ingrese solo números.");
                valido = false;
            }
        } while (!valido);
        // aca creo el número de la cuenta automáticamente y verifico que no sea el mismo
        Cuenta cuenta = new Cuenta(generarNumeroAleatorio(arrayClientes2), 0.0);
        cliente.getCuentas().add(cuenta);//agrego la cuenta al ARRAYList de CLIENTE
        arrayClientes2.add(cliente);
        System.out.println("Se ha creado con exito. Sus datos de cliente son : " );
        System.out.println(cliente);


    }


    public String generarNumeroAleatorio(ArrayList<Cliente> clientes2) {

        String numeroAleatorioString;
        int numeroAleatorio;
        boolean numeroExistente = false;

        // recorre el array list y si existe el numero aleatorio entonces vuelve a generar otra hasta que lo retorne

        do {
            // Generar un número aleatorio entre 0 y 99999
            numeroAleatorio = (int) (Math.random() * 100000);

            // Convierte el número a un string
            numeroAleatorioString = Integer.toString(numeroAleatorio);

            // Verificar si el número ya existe en la lista de clientes

            for (Cliente cliente : clientes2) {
                ArrayList<Cuenta> cuentas = cliente.getCuentas();// la lista de cuentas del cliente actual.

                for (Cuenta cuenta : cuentas) {
                    if (cuenta.getNumeroCuenta().equals(numeroAleatorioString)) {
                        numeroExistente = true;
                        break;
                    }
                }

            }
        } while (numeroExistente);

        // Retornar el número aleatorio como string
        return numeroAleatorioString;
    }


    public Cliente buscarClientePorNumeroCuenta(String numeroCuenta, ArrayList<Cliente> clientes2) {
        if (numeroCuenta == null || numeroCuenta.isEmpty()) {
            throw new IllegalArgumentException("El número de cuenta no puede estar vacío");
        }
        for (Cliente cliente : clientes2) {
            ArrayList<Cuenta> cuentas = cliente.getCuentas();// la lista de cuentas del cliente actual.

            for (Cuenta cuenta : cuentas) {
                if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                    return cliente;
                }
            }
        }
        return null;
    }


    public void agregarClienteLista(Cliente cliente, ArrayList<Cliente> clientes2) {
        clientes2.add(cliente);
    }

    public void mostrarListaClientes(ArrayList<Cliente> clientes2) {
        for (Cliente client : clientes2) {
            System.out.println(client);
        }
    }


}



