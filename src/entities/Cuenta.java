 package entities;


import java.util.ArrayList;

public class Cuenta  {
        private String numeroCuenta;
        private Double saldo;
      private ArrayList<Transferencia> transferencias= new ArrayList<>();


        public Cuenta() {
        }

    public Cuenta(String numeroCuenta, Double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public Cuenta(String numeroCuenta, Double saldo, ArrayList<Transferencia> transferencias) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.transferencias = transferencias;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Transferencia> getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(ArrayList<Transferencia> transferencias) {
        this.transferencias = transferencias;
    }

    @Override
    public String toString() {
        return  "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                //", transferencias="
                '}';
    }
}



