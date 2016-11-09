package btservidor;

import Entidad.Autor;
import Entidad.Categoria;
import Entidad.Editorial;
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
import Entidad.Libro;
import Entidad.Prestamo;
import Entidad.ListarPrestamo;
import Entidad.Procedencia;
import BRMIBD.RMIBD;
import Entidad.subCategoria;

public class Servidor extends UnicastRemoteObject implements RMIBD {

    public Servidor() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {

            Registry registro = LocateRegistry.createRegistry(4567);
            registro.rebind("rmi://localhost:4567/BRMIBD", new Servidor());
            System.out.println("Servidor Activo");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public ArrayList<Libro> buscar_Libro(int codigo) throws RemoteException {
        int cod;
        String nom, tit, subt, edi, autor, cat, subcat, proc, serie, fec, cant;

        ArrayList<Libro> lisempleado = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "select * from libro where codigo='" + codigo + "'";
            Statement stm = (Statement) cn.createStatement();
            ResultSet rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                cod = rs.getInt(1);
                nom = rs.getString(2);
                tit = rs.getString(3);
                subt = rs.getString(4);
                edi = rs.getString(5);
                autor = rs.getString(6);
                cat = rs.getString(7);
                subcat = rs.getString(8);
                proc = rs.getString(9);
                serie = rs.getString(10);
                fec = rs.getString(11);
                cant = rs.getString(12);

                Libro oempleado = new Libro(cod, nom, tit, subt, edi, autor, cat, subcat, proc, serie, fec, cant);
                lisempleado.add(oempleado);
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lisempleado;

    }
    /*
    *********************************************************************************************************
    ****************************METODOS DE PRESTAR LIBROS**********************************
    */
    @Override
    public ArrayList<Prestamo> BuscarPrestamo(int idPrestamo) throws RemoteException {
        int cdp, cdl,cdu;
        String fecha,fechadv;

        ArrayList<Prestamo> lisPrestamo = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "select * from prestamo where idPrestamo='" + idPrestamo + "'";
            Statement stm = (Statement) cn.createStatement();
            ResultSet rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                cdp = rs.getInt(1);
                cdl = rs.getInt(2);
                cdu = rs.getInt(3);
                fecha = rs.getString(4);
                fechadv = rs.getString(5);
                Prestamo oprestamo = new Prestamo(cdp,cdl,cdu,fecha,fechadv);
                lisPrestamo.add(oprestamo);
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lisPrestamo;

    }
    @Override
    public ArrayList<ListarPrestamo> mostrarPrestamos() throws RemoteException {

        int codp, codl, codu;
        String fech,fechd,nomL, titulo, autor, nomu,apllu, diru;

        ArrayList<ListarPrestamo> listaPrestamo = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "SELECT prestamo.idPrestamo, prestamo.Fecha,prestamo.FechaDevolucion, libro.codigo, libro.nombre, libro.titulo, libro.autor, usuario.idUsuario, usuario.nombre, usuario.apellido, usuario.direccion\n" +
                               "FROM libro INNER JOIN usuario INNER JOIN prestamo\n" +
                               "ON prestamo.codigo=libro.codigo AND prestamo.idUsuario=usuario.idUsuario";
            Statement stm = (Statement) cn.createStatement();
            ResultSet rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                codp = rs.getInt(1);
                fech = rs.getString(2);
                fechd = rs.getString(3);
                codl = rs.getInt(4);
                nomL = rs.getString(5);
                titulo = rs.getString(6);
                autor = rs.getString(7);
                codu = rs.getInt(8);
                nomu = rs.getString(9);
                apllu = rs.getString(10);
                diru = rs.getString(11);
        

                ListarPrestamo oprestamo = new ListarPrestamo(codp, fech, fechd, codl, nomL, titulo, autor, codu, nomu, apllu, diru);
                listaPrestamo.add(oprestamo);
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return listaPrestamo;
    }
    
    
    
    @Override
    public boolean IngresarPrestamo(int codigoL, int idUsuario,String Fecha, String FechaDevolucion) throws RemoteException {

        boolean exito;
        exito = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
            String sentencia = "insert into prestamo(codigo,idUsuario,Fecha,FechaDevolucion) values (?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sentencia);
           // ps.setInt(1, idPrestamo);
            ps.setInt(1, codigoL);
            ps.setInt(2, idUsuario);
            ps.setString(3, Fecha);
            ps.setString(4, FechaDevolucion);
            
            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exito;

    }
    @Override
    public boolean ModificarPrestamo(int idPrestamo,int codigoL, int idUsuario,String Fecha, String FechaDevolucion) throws RemoteException {

        boolean exito;
        exito = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "update prestamo set codigo=?, idUsuario=?, Fecha=?, FechaDevolucion=? where idPrestamo=?";
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setInt(1, codigoL);
            ps.setInt(2, idUsuario);
            ps.setString(3, Fecha);
            ps.setString(4, FechaDevolucion);
            
            ps.setInt(5, idPrestamo);

            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return exito;

    }
     @Override
    public boolean eliminarPrestamo(int idPrestamo) throws RemoteException {

        boolean exito;
        exito = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "delete from prestamo where idPrestamo=?";
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, idPrestamo);
            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return exito;

    }
    //********************************************************************************************

    @Override
    public ArrayList<Libro> mostrar() throws RemoteException {

        int cod;
        String nom, tit, subt, edi, autor, cat, subcat, proc, serie, fec, cant;

        ArrayList<Libro> lisempleado = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "select * from libro";
            Statement stm = (Statement) cn.createStatement();
            ResultSet rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                cod = rs.getInt(1);
                nom = rs.getString(2);
                tit = rs.getString(3);
                subt = rs.getString(4);
                edi = rs.getString(5);
                autor = rs.getString(6);
                cat = rs.getString(7);
                subcat = rs.getString(8);
                proc = rs.getString(9);
                serie = rs.getString(10);
                fec = rs.getString(11);
                cant = rs.getString(12);

                Libro oempleado = new Libro(cod, nom, tit, subt, edi, autor, cat, subcat, proc, serie, fec, cant);
                lisempleado.add(oempleado);
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lisempleado;
    }

    @Override
    public boolean eliminar(int codigo) throws RemoteException {

        boolean exito;
        exito = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "delete from libro where codigo=?";
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return exito;

    }

    @Override
    public boolean modificar(int cod, String nom, String tit, String subt, String edi, String autor, String cat, String subcat, String proc, String serie, String fec, String cant) throws RemoteException {

        boolean exito;
        exito = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "update libro set nombre=?, titulo=?,"
                    + " subtitulo=?, editorial=?, autor=?, categoria=?, subcategoria=?,"
                    + " procedencia=?, serie=?, fecha=?, cantidad=? where codigo=?";
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setString(1, nom);
            ps.setString(2, tit);
            ps.setString(3, subt);
            ps.setString(4, edi);
            ps.setString(5, autor);
            ps.setString(6, cat);
            ps.setString(7, subcat);
            ps.setString(8, proc);
            ps.setString(9, serie);
            ps.setString(10, fec);
            ps.setString(11, cant);
            ps.setInt(12, cod);

            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return exito;

    }

    @Override
    public boolean Ingresar(int cod, String nom, String tit, String subt, String edi, String autor, String cat, String subcat, String proc, String serie, String fec, String cant) throws RemoteException {

        boolean exito;
        exito = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "insert into libro(codigo,nombre,titulo,subtitulo,editorial,autor,categoria,subcategoria,procedencia,serie,fecha,cantidad) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, cod);
            ps.setString(2, nom);
            ps.setString(3, tit);
            ps.setString(4, subt);
            ps.setString(5, edi);
            ps.setString(6, autor);
            ps.setString(7, cat);
            ps.setString(8, subcat);
            ps.setString(9, proc);
            ps.setString(10, serie);
            ps.setString(11, fec);
            ps.setString(12, cant);

            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exito;

    }

    /*IMPLEMENTACION DEL MÉTODO VALIDAR USUARIO*/
    @Override
    public boolean ValidarUsuario(String user, String password) throws RemoteException {
        boolean exito;
        exito = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");

            String sql = "select * from administrador where user = '"
                    + user + "' and password = '" + password + "' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {

            System.out.println(ex);
        }
        return exito;
    }

    /*IMPLEMENTACION DEL MÉTODO CARGAR CATEGORIA*/
    @Override
    public ArrayList<Categoria> CargarCategorias() throws RemoteException {

        ArrayList<Categoria> lisCategoria = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");

            String sql = "select * from categoria";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int codigo;
            String nombre;

            while (rs.next()) {
                codigo = rs.getInt(1);
                nombre = rs.getString(2);

                Categoria ocat = new Categoria(codigo, nombre);
                lisCategoria.add(ocat);
            }
            cn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return lisCategoria;
    }

    @Override
    public ArrayList<Categoria> mostrarCategoria() throws RemoteException {
        int cod;
        String nom;

        ArrayList<Categoria> liscategoria = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "select * from categoria";
            Statement stm = (Statement) cn.createStatement();
            ResultSet rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                cod = rs.getInt(1);
                nom = rs.getString(2);

                Categoria cate = new Categoria(cod, nom);
                liscategoria.add(cate);
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return liscategoria;
    }

    @Override
    public ArrayList<Categoria> buscarCategoria(int codigo) throws RemoteException {
        int cod;
        String nom;

        ArrayList<Categoria> liscategoria = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "select * from categoria where codigo='" + codigo + "'";
            Statement stm = (Statement) cn.createStatement();
            ResultSet rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                cod = rs.getInt(1);
                nom = rs.getString(2);

                Categoria ocat = new Categoria(cod, nom);
                liscategoria.add(ocat);
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return liscategoria;
    }

    @Override
    public boolean eliminarCategoria(int codigo) throws RemoteException {
        boolean exito;
        exito = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "delete from categoria where codigo=?";
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return exito;
    }

    @Override
    public boolean modificarCategoria(int cod, String nom) throws RemoteException {
        boolean exito;
        exito = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "update categoria set nombre=? where codigo=?";
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setString(1, nom);

            ps.setInt(2, cod);

            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return exito;
    }

    @Override
    public boolean IngresarCategoria(int cod, String nom) throws RemoteException {
        boolean exito;
        exito = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "insert into categoria(codigo,nombre) values (?,?)";
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, cod);
            ps.setString(2, nom);

            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exito;
    }

    /*IMPLEMENTACION DEL LOS MÉTODODOS DEL OBJETO AUTOR*/
    @Override
    public ArrayList<Autor> mostrarAutor() throws RemoteException {
        int cod;
        String nom;

        ArrayList<Autor> lisautor = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "select * from autor";
            Statement stm = (Statement) cn.createStatement();
            ResultSet rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                cod = rs.getInt(1);
                nom = rs.getString(2);

                Autor aut = new Autor(cod, nom);
                lisautor.add(aut);
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lisautor;
    }

    @Override
    public ArrayList<Autor> buscarAutor(int codigo) throws RemoteException {
        int cod;
        String nom;

        ArrayList<Autor> lisautor = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "select * from autor where codigo='" + codigo + "'";
            Statement stm = (Statement) cn.createStatement();
            ResultSet rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                cod = rs.getInt(1);
                nom = rs.getString(2);

                Autor aut = new Autor(cod, nom);
                lisautor.add(aut);
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lisautor;
    }

    @Override
    public boolean eliminarAutor(int codigo) throws RemoteException {
        boolean exito;
        exito = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "delete from autor where codigo=?";
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return exito;
    }

    @Override
    public boolean modificarAutor(int cod, String nom) throws RemoteException {
        boolean exito;
        exito = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "update autor set nombre=? where codigo=?";
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setString(1, nom);

            ps.setInt(2, cod);

            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return exito;
    }

    @Override
    public boolean IngresarAutor(int cod, String nom) throws RemoteException {
        boolean exito;
        exito = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "insert into autor(codigo,nombre) values (?,?)";
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, cod);
            ps.setString(2, nom);

            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exito;
    }

    /*IMPLEMENTACION DEL LOS MÉTODODOS DEL OBJETO EDITORIAL*/
    @Override
    public ArrayList<Editorial> mostrarEditorial() throws RemoteException {
        int cod;
        String nom;

        ArrayList<Editorial> liseditorial = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "select * from editorial";
            Statement stm = (Statement) cn.createStatement();
            ResultSet rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                cod = rs.getInt(1);
                nom = rs.getString(2);

                Editorial edi = new Editorial(cod, nom);
                liseditorial.add(edi);
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return liseditorial;
    }

    @Override
    public ArrayList<Editorial> buscarEditorial(int codigo) throws RemoteException {
        int cod;
        String nom;

        ArrayList<Editorial> liseditorial = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "select * from editorial where codigo='" + codigo + "'";
            Statement stm = (Statement) cn.createStatement();
            ResultSet rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                cod = rs.getInt(1);
                nom = rs.getString(2);

                Editorial edi = new Editorial(cod, nom);
                liseditorial.add(edi);
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return liseditorial;
    }

    @Override
    public boolean eliminarEditorial(int codigo) throws RemoteException {
        boolean exito;
        exito = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "delete from editorial where codigo=?";
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return exito;
    }

    @Override
    public boolean modificarEditorial(int cod, String nom) throws RemoteException {
        boolean exito;
        exito = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "update editorial set nombre=? where codigo=?";
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setString(1, nom);

            ps.setInt(2, cod);

            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return exito;
    }

    @Override
    public boolean IngresarEditorial(int cod, String nom) throws RemoteException {
        boolean exito;
        exito = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "insert into editorial(codigo,nombre) values (?,?)";
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, cod);
            ps.setString(2, nom);

            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exito;
    }

    /*IMPLEMENTACION DEL LOS MÉTODODOS DEL OBJETO PROCEDENCIA*/
    @Override
    public ArrayList<Procedencia> mostrarProcedencia() throws RemoteException {
        int cod;
        String nom, desc;

        ArrayList<Procedencia> lisprocedencia = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "select * from procedencia";
            Statement stm = (Statement) cn.createStatement();
            ResultSet rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                cod = rs.getInt(1);
                nom = rs.getString(2);
                desc = rs.getString(3);

                Procedencia proc = new Procedencia(cod, nom, desc);
                lisprocedencia.add(proc);
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lisprocedencia;
    }

    @Override
    public ArrayList<Procedencia> buscarProcedencia(int codigo) throws RemoteException {
        int cod;
        String nom, desc;

        ArrayList<Procedencia> lisprocedencia = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "select * from procedencia where codigo='" + codigo + "'";
            Statement stm = (Statement) cn.createStatement();
            ResultSet rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                cod = rs.getInt(1);
                nom = rs.getString(2);
                desc = rs.getString(3);

                Procedencia proc = new Procedencia(cod, nom, desc);
                lisprocedencia.add(proc);
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lisprocedencia;
    }

    @Override
    public boolean eliminarProcedencia(int codigo) throws RemoteException {
        boolean exito;
        exito = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "delete from procedencia where codigo=?";
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return exito;
    }

    @Override
    public boolean modificarProcedencia(int cod, String nom, String desc) throws RemoteException {
        boolean exito;
        exito = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "update procedencia set procedencia=?,descripcion=? where codigo=?";
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setString(1, nom);
            ps.setString(2, desc);
            ps.setInt(3, cod);

            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return exito;
    }

    @Override
    public boolean IngresarProcedencia(int cod, String nom, String desc) throws RemoteException {
        boolean exito;
        exito = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "insert into procedencia(codigo,procedencia,descripcion) values (?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, cod);
            ps.setString(2, nom);
            ps.setString(3, desc);
            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exito;
    }

    /*IMPLEMENTACION DEL LOS MÉTODODOS DEL OBJETO SUBCATEGORIA*/
    @Override
    public ArrayList<subCategoria> mostrarsubCategoria() throws RemoteException {
        int cod;
        String nom,cat;

        ArrayList<subCategoria> lissubcategoria = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "select * from subcategoria";
            Statement stm = (Statement) cn.createStatement();
            ResultSet rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                cod = rs.getInt(1);
                nom = rs.getString(2);
                cat = rs.getString(3);

                subCategoria subc = new subCategoria(cod, nom,cat) ;
                lissubcategoria.add(subc);
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lissubcategoria;
    }

    @Override
    public ArrayList<subCategoria> buscarsubCategoria(int codigo) throws RemoteException {
        int cod;
        String nom, cat;

        ArrayList<subCategoria> lissubcategoria = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "select * from subcategoria where codigo='" + codigo + "'";
            Statement stm = (Statement) cn.createStatement();
            ResultSet rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                cod = rs.getInt(1);
                nom = rs.getString(2);
                cat = rs.getString(3);

                subCategoria subc = new subCategoria(cod, nom, cat);
                lissubcategoria.add(subc);
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lissubcategoria;
    }

    @Override
    public boolean eliminarsubCategoria(int codigo) throws RemoteException {
        boolean exito;
        exito = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "delete from subcategoria where codigo=?";
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return exito;
    }

    @Override
    public boolean modificarsubCategoria(int cod, String nom, String cat) throws RemoteException {
        boolean exito;
        exito = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "update subcategoria set subcategoria=?,categoria=? where codigo=?";
            PreparedStatement ps = cn.prepareStatement(sentencia);

            ps.setString(1, nom);
            ps.setString(2, cat);
            ps.setInt(3, cod);

            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return exito;
    }

    @Override
    public boolean IngresarsubCategoria(int cod, String nom, String cat) throws RemoteException {
        boolean exito;
        exito = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            String sentencia = "insert into subcategoria(codigo,subcategoria,categoria) values (?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sentencia);
            ps.setInt(1, cod);
            ps.setString(2, nom);
            ps.setString(3, cat);
            ps.executeUpdate();
            exito = true;
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exito;
    }

    /*IMPLEMENTACION DE LOS METODOS CARGAR COMBOS*/
    @Override
    public ArrayList<Autor> CargarAutor() throws RemoteException {
        ArrayList<Autor> lisAutor = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");

            String sql = "select * from autor";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int codigo;
            String nombre;

            while (rs.next()) {
                codigo = rs.getInt(1);
                nombre = rs.getString(2);

                Autor aut = new Autor(codigo, nombre);
                lisAutor.add(aut);
            }
            cn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return lisAutor;
    }

    @Override
    public ArrayList<Editorial> CargarEditorial() throws RemoteException {
        ArrayList<Editorial> lisEditorial = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");

            String sql = "select * from editorial";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int codigo;
            String nombre;

            while (rs.next()) {
                codigo = rs.getInt(1);
                nombre = rs.getString(2);

                Editorial edi = new Editorial(codigo, nombre);
                lisEditorial.add(edi);
            }
            cn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return lisEditorial;
    }

    @Override
    public ArrayList<Procedencia> CargarProcedencia() throws RemoteException {
        ArrayList<Procedencia> lisProcedencia = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");

            String sql = "select * from procedencia";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int codigo;
            String nombre, desc;

            while (rs.next()) {
                codigo = rs.getInt(1);
                nombre = rs.getString(2);
                desc = rs.getString(3);

                Procedencia proc = new Procedencia(codigo, nombre, desc);
                lisProcedencia.add(proc);
            }
            cn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return lisProcedencia;
    }

    @Override
    public ArrayList<subCategoria> CargarsubCategoria() throws RemoteException {
        ArrayList<subCategoria> lissubCategoria = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");

            String sql = "select * from subcategoria";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int codigo;
            String nombre, cat;

            while (rs.next()) {
                codigo = rs.getInt(1);
                nombre = rs.getString(2);
                cat = rs.getString(3);

                subCategoria sub = new subCategoria(codigo, nombre, cat);
                lissubCategoria.add(sub);
            }
            cn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return lissubCategoria;
    }

    @Override
    public ArrayList<Categoria> CargarCodCategoria() throws RemoteException {
        ArrayList<Categoria> lisCategoria = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");

            String sql = "select * from categoria";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int codigo;

            while (rs.next()) {
                codigo = rs.getInt(1);

                Categoria cat = new Categoria(codigo);
                lisCategoria.add(cat);
            }
            cn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return lisCategoria;
    }

}
