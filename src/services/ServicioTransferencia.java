package services;


import entities.Cuenta;
import entities.Transferencia;

import java.util.ArrayList;
import java.util.Scanner;


public class ServicioTransferencia {
    private Scanner leer = new Scanner(System.in);

    CuentaServicio cuentaServicio = new CuentaServicio();

    public void realizarTransferencia(ArrayList<Cuenta> cuentas) throws Exception {

        Cuenta cuentaOrigen;
        Cuenta cuentaDestino;

        do {
            System.out.print("Ingrese el número de cuenta del cliente origen: ");
            String numeroCuentaOrigen = leer.nextLine();
            cuentaOrigen = cuentaServicio.buscarCuenta(numeroCuentaOrigen, cuentas);
            if (cuentaOrigen == null) {
                System.out.println("La cuenta del cliente origen no existe");
                leer.nextLine();
            }
        } while (cuentaOrigen == null);


        do {
            System.out.print("Ingrese el número de cuenta del cliente destino: ");
            String numeroCuentaDestino = leer.nextLine();
            cuentaDestino = cuentaServicio.buscarCuenta(numeroCuentaDestino, cuentas);

            if (cuentaDestino == null) {
                System.out.println("El cliente destino no existe");
                leer.nextLine();
            }
        } while (cuentaDestino == null);


        System.out.print("Ingrese el monto de la transferencia: ");
        double monto = leer.nextDouble();


        if (cuentaOrigen.getSaldo() < monto) {
            System.out.println("El cliente origen no tiene suficiente saldo para realizar la transferencia");
        } else {

            try {
                System.out.println("--------------------------");
                retirarDinero(cuentaOrigen, monto);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {

                System.out.println("--------------------------");
                depositarDinero(cuentaDestino, monto);
                System.out.println("este sout lo coloque para verificar si el deposito fue correcto");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("--------------------------");
            System.out.println("Transferencia realizada con éxito. " + " Sus datos de transferencia son : ");
            Transferencia objtransferencia = new Transferencia();
            objtransferencia.setFecha(objtransferencia.getFecha());
            objtransferencia.setMonto(monto);
            objtransferencia.setCuentaOrigen(cuentaOrigen);
            objtransferencia.setCuentaDestino(cuentaDestino);
            cuentaOrigen.getTransferencias().add(objtransferencia);

            System.out.println(objtransferencia);

        }
    }

    public void depositarDinero(Cuenta cuentaClienteDestino, Double monto) {
        if (!(cuentaClienteDestino == null)) {
            if (monto > 0) {
                cuentaClienteDestino.setSaldo(cuentaClienteDestino.getSaldo() + monto);
                System.out.println("Deposito exitoso");
            } else {
                System.out.println("El monto a depositar debe ser mayor a cero");
            }

        }else{
            System.out.println("ingrese un numero de cuenta valido");
        }
    }


    public void retirarDinero(Cuenta cuentaClienteOrigen, Double monto) {

        if (!(cuentaClienteOrigen == null)) {
            if (monto > 0) {
                cuentaClienteOrigen.setSaldo(cuentaClienteOrigen.getSaldo() - monto);

                System.out.println("Retiro exitoso. Su  saldo actual es de : "+ cuentaClienteOrigen.getSaldo());
            } else {
                System.out.println("El monto a retirar debe ser mayor a cero");
            }

        }else{
            System.out.println("ingrese un numero de cuenta valido");
        }
    }


}

