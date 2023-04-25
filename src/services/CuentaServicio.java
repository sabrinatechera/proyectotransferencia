package services;


import entities.Cuenta;

import java.util.ArrayList;
import java.util.Scanner;

public class CuentaServicio {

Scanner leer = new Scanner(System.in);

    public Cuenta buscarCuenta( String numeroCuenta, ArrayList<Cuenta>cuentas) {


        for (Cuenta cuenta : cuentas) {

            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {

                return cuenta;
            }
        }
        return null;//
    }


    public void mostrarListCuenta(ArrayList<Cuenta>cuentas){

        System.out.println(cuentas);
    }

}