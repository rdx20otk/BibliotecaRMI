package Entidad;

import java.io.Serializable;

public class Libro implements Serializable {

    private int codigo;
    private String nombre;
    private String titulo;
    private String subtitulo;
    private String editorial;
    private String autor;
    private String categoria;
    private String subcategoria;
    private String procedencia;
    private String serie;
    private String fecha;
    private String cantidad;

    public Libro(int codigo, String nombre, String titulo, String subtitulo, String editorial, String autor, String categoria, String subcategoria, String procedencia, String serie, String fecha, String cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.editorial = editorial;
        this.autor = autor;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.procedencia = procedencia;
        this.serie = serie;
        this.fecha = fecha;
        this.cantidad = cantidad;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

}
