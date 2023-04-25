package entities;


import java.util.ArrayList;

public abstract class Persona {
        private String nombre;
        private String dni;




        public Persona() {
        }

        public Persona(String nombre, String dni) {
            this.nombre = nombre;
            this.dni = dni;
        }

        public String getNombre() {
            return nombre;
        }

        public String getDni() {
            return dni;
        }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}


