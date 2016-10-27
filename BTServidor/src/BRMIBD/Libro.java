
package BRMIBD;

/**
 *
 * @author Carlos-Aqln
 */
import java.io.Serializable;
/**
 *
 * @author Carlos-Aqln
 */
public class Libro implements Serializable{
    private int codigo;
    private String nombre;
    private String titulo;
    private String subtitulo;
    private String editorial;
    private String autor;
    private String serie;
    private String fecharegistro;
    private String cantidad;

    public Libro(int codigo, String nombre, String titulo, String subtitulo, String editorial, String autor, String serie, String fecharegistro, String cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.editorial = editorial;
        this.autor = autor;
        this.serie = serie;
        this.fecharegistro = fecharegistro;
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
}