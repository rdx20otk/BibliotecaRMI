package BRMIBD;

import Entidad.subCategoria;
import Entidad.ListarPrestamo;
import Entidad.Prestamo;
import Entidad.Procedencia;
import Entidad.Libro;
import Entidad.Editorial;
import Entidad.Categoria;
import Entidad.Autor;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RMIBD extends Remote {

    public ArrayList<Libro> mostrar() throws RemoteException;

    public ArrayList<Libro> buscar_Libro(int codigo) throws RemoteException;

    public boolean eliminar(int codigo) throws RemoteException;

    public boolean modificar(int cod, String nom, String tit, String subt, String edi, String autor, String cat, String subcat, String proc, String serie, String fec, String cant) throws RemoteException;

    public boolean Ingresar(int cod, String nom, String tit, String subt, String edi, String autor, String cat, String subcat, String proc, String serie, String fec, String cant) throws RemoteException;

    //**********************************************************
    //************************************************************
    //METODOS DEL CASO DE USO PRESTAMO DE LIBROS
     public ArrayList<ListarPrestamo> mostrarPrestamos() throws RemoteException;  
      public boolean IngresarPrestamo(int codigoL, int idUsuario,String Fecha, String FechaDevolucion) throws RemoteException;
      public boolean eliminarPrestamo(int idPrestamo) throws RemoteException;
     public boolean ModificarPrestamo(int idPrestamo,int codigoL, int idUsuario,String Fecha, String FechaDevolucion) throws RemoteException;
    public ArrayList<Prestamo> BuscarPrestamo(int idPrestamo) throws RemoteException;
     
    //********************************************************************************* 
    
    
    /*Metodo remoto Validar Usuario*/
    public boolean ValidarUsuario(String user, String password) throws RemoteException;

    /*Metodo remoto cargar combos*/
    public ArrayList<Categoria> CargarCategorias() throws RemoteException;

    public ArrayList<Autor> CargarAutor() throws RemoteException;

    public ArrayList<Editorial> CargarEditorial() throws RemoteException;

    public ArrayList<Procedencia> CargarProcedencia() throws RemoteException;

    public ArrayList<subCategoria> CargarsubCategoria() throws RemoteException;

    public ArrayList<Categoria> CargarCodCategoria() throws RemoteException;

    /*METODOS REMOTO DE CATEGORIA*/
    public ArrayList<Categoria> mostrarCategoria() throws RemoteException;

    public ArrayList<Categoria> buscarCategoria(int codigo) throws RemoteException;

    public boolean eliminarCategoria(int codigo) throws RemoteException;

    public boolean modificarCategoria(int cod, String nom) throws RemoteException;

    public boolean IngresarCategoria(int cod, String nom) throws RemoteException;

    /*METODOS REMOTO DE AUTOR*/
    public ArrayList<Autor> mostrarAutor() throws RemoteException;

    public ArrayList<Autor> buscarAutor(int codigo) throws RemoteException;

    public boolean eliminarAutor(int codigo) throws RemoteException;

    public boolean modificarAutor(int cod, String nom) throws RemoteException;

    public boolean IngresarAutor(int cod, String nom) throws RemoteException;

    /*METODOS REMOTO DE EDITORIAL*/
    public ArrayList<Editorial> mostrarEditorial() throws RemoteException;

    public ArrayList<Editorial> buscarEditorial(int codigo) throws RemoteException;

    public boolean eliminarEditorial(int codigo) throws RemoteException;

    public boolean modificarEditorial(int cod, String nom) throws RemoteException;

    public boolean IngresarEditorial(int cod, String nom) throws RemoteException;

    /*METODOS REMOTO DE PROCEDENCIA*/
    public ArrayList<Procedencia> mostrarProcedencia() throws RemoteException;

    public ArrayList<Procedencia> buscarProcedencia(int codigo) throws RemoteException;

    public boolean eliminarProcedencia(int codigo) throws RemoteException;

    public boolean modificarProcedencia(int cod, String nom, String desc) throws RemoteException;

    public boolean IngresarProcedencia(int cod, String nom, String desc) throws RemoteException;

    /*METODOS REMOTO DE SUBCATEGORIA*/
    public ArrayList<subCategoria> mostrarsubCategoria() throws RemoteException;

    public ArrayList<subCategoria> buscarsubCategoria(int codigo) throws RemoteException;

    public boolean eliminarsubCategoria(int codigo) throws RemoteException;

    public boolean modificarsubCategoria(int cod, String nom, String cat) throws RemoteException;

    public boolean IngresarsubCategoria(int cod, String nom, String cat) throws RemoteException;

}
