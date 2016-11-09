/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;
import java.io.Serializable;
/**
 *
 * @author Carlos-Aqln
 */
public class Prestamo implements Serializable{
      
    private int idPrestamo;
    private int codigoL;
    private int idUsuario;

    private String Fecha;
    private String FechaDevolucion;
    
     public Prestamo(int idPrestamo, int codigoL, int idUsuario, String Fecha, String FechaDevolucion) {
         this.idPrestamo=idPrestamo;
         this.codigoL=codigoL;
         this.idUsuario=idUsuario;
         this.Fecha=Fecha;
         this.FechaDevolucion = FechaDevolucion;
         
     }

    public String getFechaDevolucion() {
        return FechaDevolucion;
    }

    public void setFechaDevolucion(String FechaDevolucion) {
        this.FechaDevolucion = FechaDevolucion;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getCodigoL() {
        return codigoL;
    }

    public void setCodigoL(int codigoL) {
        this.codigoL = codigoL;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
       
        
    
}
