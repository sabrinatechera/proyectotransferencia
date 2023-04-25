package services;
import entities.Cliente;
import entities.Cuenta;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuService {

    ClienteServicio clienteserv = new ClienteServicio();
    CuentaServicio cuentaServicio = new CuentaServicio();
    ServicioTransferencia transerv = new ServicioTransferencia();
    ArrayList<Cliente> arrayClientes2 = new ArrayList<Cliente>();// creo una array de clientes por si luego lo uso en sucursal.
    ArrayList<Cuenta> arrayCuentas = new ArrayList<Cuenta>();

    public void cargarClientesIniciales() {
        Cliente cliente1 = new Cliente("Juan", "1234567890");
        Cuenta cuenta1 = new Cuenta("1234", 1000.0);
        cliente1.getCuentas().add(cuenta1);// añado cuenta a lista de cuentas de cliente
        arrayClientes2.add(cliente1);// y al cliente lo agrego al arraylist de clientes
        arrayCuentas.add(cuenta1);
        Cliente cliente2 = new Cliente("pedro", "987654321");
        Cuenta cuenta2 = new Cuenta("5678", 2000.0);
        cliente2.getCuentas().add(cuenta2);
        arrayClientes2.add(cliente2);
        arrayCuentas.add(cuenta2);
    }


    public void realizarMenuprincipal() {

        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Bienvenido al sistema de transferencias bancarias");
            System.out.println("1. Realizar una transferencia");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Crear un nueva CUENTA ");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción:");
            opcion = leer.nextInt();

            leer.nextLine();

            switch (opcion) {

                case 1:
                    try {
                        transerv.realizarTransferencia(arrayCuentas);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    realizarMenuprincipal();
                    break;

                case 2:
                    System.out.println("Ingrese cuenta de donde desea retirar dinero");
                    String numcuenta = leer.nextLine();
                    Cuenta cuentaClienteOrigen = cuentaServicio.buscarCuenta(numcuenta, arrayCuentas);
                    System.out.println("ingrese monto a retirar");
                    double monto = leer.nextDouble();
                    transerv.retirarDinero(cuentaClienteOrigen, monto);
                    realizarMenuprincipal();
                    break;

                case 3:
                    System.out.println("Ingrese cuenta donde desea depositar dinero");
                    String numcuenta2 = leer.nextLine();
                    Cuenta cuentaClienteDestino = cuentaServicio.buscarCuenta(numcuenta2, arrayCuentas);
                    System.out.println("ingrese monto a depositar");
                    double monto2 = leer.nextDouble();
                    transerv.depositarDinero(cuentaClienteDestino, monto2);

                    realizarMenuprincipal();
                    break;

                case 4:
                    System.out.println(" Siga los siguientes pasos : ");
                    clienteserv.crearCliente(arrayClientes2);
                    System.out.println(" ");
                    System.out.println("este sout es para corroborar que ingresa el usuario nuevo a la lista de usuario");
                    clienteserv.mostrarListaClientes(arrayClientes2);
                    realizarMenuprincipal();
                    System.out.println(" ");
                    break;

                case 5:
                    System.out.println("Saliendo del sistema.Muchas gracias por su visita");
                    realizarMenuprincipal();
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
        while (opcion != 4);

        leer.close();
    }
}



