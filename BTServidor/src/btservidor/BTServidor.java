
package btservidor;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import BRMIBD.BRMIBD;
import BRMIBD.Libro;

/**
 *
 * @author Carlos-Aqln
 */
public class BTServidor extends UnicastRemoteObject implements BRMIBD{
public BTServidor() throws RemoteException{
    super();
}
    
    public static void main(String[] args) {
        try{
            
            Registry registro=LocateRegistry.createRegistry(4567);
            registro.rebind("rmi://localhost:5124/RMIBD",new BTServidor());
            System.out.println("Servidor Activo");
            
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
    }
 
    @Override
    public ArrayList<Libro> buscar_Libro (int codigo) throws RemoteException {
           int cod;  
        String nom,tit,subt,edi,autor,serie,freg,cant;
        
        ArrayList<Libro>lisempleado=new ArrayList<>();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/biblioteca","root","");
            String sentencia ="select * from libro where codigo='"+codigo+"'";
            Statement stm =(Statement)cn.createStatement();
            ResultSet rs=stm.executeQuery(sentencia);
            while(rs.next()){
                 cod=rs.getInt(1);
                nom=rs.getString(2); 
                tit=rs.getString(3);
                subt=rs.getString(4); 
                edi=rs.getString(5); 
                autor=rs.getString(6);
                serie=rs.getString(7);
                 freg=rs.getString(8);
                cant=rs.getString(9); 
                Libro oempleado=new Libro(cod,nom,tit,subt,edi,autor,serie,freg,cant);
                lisempleado.add(oempleado);
            }
            cn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
          return lisempleado;  

    }
    

    @Override
    public ArrayList<Libro> mostrar() throws RemoteException {
            
        int cod;
        String nom,tit,subt,edi,autor,serie,freg,cant;
        
        ArrayList<Libro>lisempleado=new ArrayList<>();
     
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/biblioteca","root","");
            String sentencia ="select * from libro";
            Statement stm =(Statement)cn.createStatement();
            ResultSet rs=stm.executeQuery(sentencia);
            while(rs.next()){
                     cod=rs.getInt(1);
                nom=rs.getString(2); 
                tit=rs.getString(3);
                subt=rs.getString(4); 
                edi=rs.getString(5); 
                autor=rs.getString(6);
                serie=rs.getString(7);
                 freg=rs.getString(8);
                cant=rs.getString(9); 
                Libro oempleado=new Libro(cod,nom,tit,subt,edi,autor,serie,freg,cant);
                lisempleado.add(oempleado);
            }
            cn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
          return lisempleado;  
    }

    @Override
    public boolean eliminar(int codigo) throws RemoteException {

            boolean exito;
            exito=false;
            
            try{
              Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/biblioteca","root","");
            String sentencia ="delete from libro where codigo=?";
           PreparedStatement ps=cn.prepareStatement(sentencia);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            exito=true;
            cn.close();
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            return exito;
            
    }

    @Override
    public boolean modificar(int cod, String nom,String tit,String subt,String edi,String autor,String serie,String freg,String cant) throws RemoteException {

    boolean exito;
            exito=false;
            
            try{
              Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/biblioteca","root","");
            String sentencia ="update libro set nombre=?, titulo=?, subtitulo=?, editorial=?, autor=?, serie=?, fecha=?, cantidad=? where codigo=?";
           PreparedStatement ps=cn.prepareStatement(sentencia);
           
                   ps.setString(1, nom);
                   ps.setString(2, tit);
                   ps.setString(3, subt);
                   ps.setString(4, edi);
                   ps.setString(5, autor);
                   ps.setString(6, serie);
                   ps.setString(7, freg);
                   ps.setString(8, cant);
                   ps.setInt(9, cod);
            
      

            ps.executeUpdate();
            exito=true;
            cn.close();
            }
            catch(Exception ex){
                System.out.println(ex);
            }
            return exito;
            
 
    }

    @Override
    public boolean Ingresar(int cod, String nom,String tit,String subt,String edi,String autor,String serie,String freg,String cant) throws RemoteException {
           
        boolean exito;
               exito=false;
               try{
                   Class.forName("com.mysql.jdbc.Driver"); //carga el driver
                   Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
                   String sentencia = "insert into libro(codigo,nombre,titulo,subtitulo,editorial,autor,serie,fecha,cantidad) values (?,?,?,?,?,?,?,?,?)";
                   PreparedStatement ps = cn.prepareStatement(sentencia);
                    ps.setInt(1, cod);
                    ps.setString(2, nom);
                   ps.setString(3, tit);
                   ps.setString(4, subt);
                   ps.setString(5, edi);
                   ps.setString(6, autor);
                   ps.setString(7, serie);
                   ps.setString(8, freg);
                   ps.setString(9, cant);
            
                   ps.executeUpdate();
                   exito=true;
                   cn.close();
               }catch (Exception e){
                   System.out.println(e);
               }
               return exito;  
    }


   
    
    
    
    
    
}//Fin del codigo
