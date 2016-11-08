package Entidad;

import java.io.Serializable;

public class Categoria implements Serializable{
    
    private int codigo;
    private String nombre;

    public Categoria(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public Categoria(int codigo) {
        this.codigo = codigo;
    }

   

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
