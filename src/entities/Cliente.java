package entities;

import java.util.ArrayList;


public class Cliente extends Persona {
    private ArrayList<Cuenta> cuentas=new ArrayList<>();



    public Cliente() {
    }

    public Cliente(String nombre, String dni) {
        super(nombre, dni);
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        return "Cliente{" + super.toString() +
                " sus datos de sus Cuentas son = " + cuentas +
                '}';
    }
}



