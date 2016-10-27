
package brmibd;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 *
 * @author Carlos-Aqln
 */
public interface BRMIBD extends Remote {
    public ArrayList<Libro>buscar_Libro(int codigo)throws RemoteException; 
 
 public ArrayList<Libro> mostrar() throws RemoteException;
 
  public boolean eliminar (int codigo) throws RemoteException;
  
public boolean modificar (int codigo, String nombre, String titulo,
         String subtitulo,String editorial, String autor, String serie, String fecha, String cantidad) throws RemoteException;
  
public boolean Ingresar (int codigo, String nombre, String titulo,
         String subtitulo,String editorial, String autor, String serie, String fecha, String cantidad) throws RemoteException;
    
    
}
