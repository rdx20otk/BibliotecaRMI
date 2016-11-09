/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Carlos-Aqln
 */
import java.io.Serializable;

public class ListarPrestamo implements Serializable {

    private int codigoP;

    private String Fecha;
    private String DevolucionFecha;
    private int codigoL;
    private String NombreL;
    private String Titulo;
    private String Autor;
    private int codigoU;
    private String NombreU;
    private String ApellidoU;
    private String DireccionU;
    

    public ListarPrestamo(int codigoP, String Fecha, String DevolucionFecha, int codigoL, String NombreL, String Titulo, String Autor, int codigoU, String NombreU, String ApellidoU, String DireccionU) {
       
        
        this.codigoP = codigoP;
   
        this.Fecha = Fecha;   
        this.DevolucionFecha=DevolucionFecha;
        this.codigoL = codigoL;
        this.NombreL = NombreL;
       this.Titulo = Titulo;
       this.Autor = Autor;
       this.codigoU = codigoU;
       this.NombreU = NombreU;
       this.ApellidoU = ApellidoU;
       this.DireccionU = DireccionU;      
       
    }

    public String getDevolucionFecha() {
        return DevolucionFecha;
    }

    public void setDevolucionFecha(String DevolucionFecha) {
        this.DevolucionFecha = DevolucionFecha;
    }

    public int getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(int codigoP) {
        this.codigoP = codigoP;
    }

   

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getCodigoL() {
        return codigoL;
    }

    public void setCodigoL(int codigoL) {
        this.codigoL = codigoL;
    }

    public String getNombreL() {
        return NombreL;
    }

    public void setNombreL(String NombreL) {
        this.NombreL = NombreL;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public int getCodigoU() {
        return codigoU;
    }

    public void setCodigoU(int codigoU) {
        this.codigoU = codigoU;
    }

    public String getNombreU() {
        return NombreU;
    }

    public void setNombreU(String NombreU) {
        this.NombreU = NombreU;
    }

    public String getApellidoU() {
        return ApellidoU;
    }

    public void setApellidoU(String ApellidoU) {
        this.ApellidoU = ApellidoU;
    }

    public String getDireccionU() {
        return DireccionU;
    }

    public void setDireccionU(String DireccionU) {
        this.DireccionU = DireccionU;
    }

}