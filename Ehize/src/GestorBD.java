

import java.sql.*;

import javax.swing.*;



/**
 * Contiene tres atributos est�ticos que hace referencia a la conexi�n MYSQL, a la conexi�n a la base de datos y a la conexi�n a preparar con la base de datos.
 * 
 * @author EA
 * @since Mayo 12, 2014
 * @version 1.0.0
 * @see	VentanaEntrada
 */

public class GestorBD {
	
	//Atributos de la clase
	private static Connection conexionMYSQL=null;
	private static Statement stmt = null;
	private static PreparedStatement ps=null;
	
	/**
     * Para conectarse al Driver y poder usar MySQL.
     * 
     * @throws SQLException Contiene informaci�n sobre un error de acceso a la base de datos.
     */
	public static void conectar() throws SQLException {
        try {
        	Class.forName("org.gjt.mm.mysql.Driver"); //El driver
        	conexionMYSQL= DriverManager.getConnection("jdbc:mysql://localhost/ehize","root", "mysql"); //Conexi�n con la mysql de la bases de datos Parking.
        	//conexionMYSQL= DriverManager.getConnection("jdbc:mysql://localhost/colonias_verano","root", "borja");
 
        } catch (Exception e) {
        	
        	//Aviso por JOptionPane cuando la conexi�n no es posible realizarla.
        	JOptionPane.showMessageDialog(null, "Imposible realizar la conexion a BD.","Error ",JOptionPane.ERROR_MESSAGE);
        }
    }  //cierre del m�todo conexi�n con la mysql

	
	 /**
     * Establece la conexi�n con la base de datos.
     *
     * @return Statement Devuelve la conexi�n con la base de datos
     */
	public static Statement conexion() {
		
        try {
        	
        	 stmt = conexionMYSQL.createStatement();
        	
        } catch (SQLException e) {
        	
        	//Aviso por JOptionPane cuando la conexi�n es incorrecta.
        	JOptionPane.showMessageDialog(null, "Conexi�n incorrecta.","Error ",JOptionPane.ERROR_MESSAGE);
        }
        
        return stmt;
       
    }  //cierre del m�todo establecer la conexi�n
	
	 /**
     * Cierra la consulta.
     *
     * @param rs Es el resultado de la consulta.
     * @throws SQLException Contiene informaci�n sobre un error de ResultSet
     */
	public static void cerrarConsulta(ResultSet rs) throws SQLException {
		 
		 if (rs!= null){ //Si no hay datos
			 
            try{
            	
                rs.close(); //cierre de la consulta
                
            }catch (Exception e){
            	
            	//Aviso por JOptionPane cuando no se ha podido cerrar la consulta.
            	JOptionPane.showMessageDialog(null, "No es posible cerrar la consulta.","Error ",JOptionPane.ERROR_MESSAGE);
            }
            
	     }
	} //cierre del m�todo cerrar resultSet
		
	 /**
     * Cierra la conexi�n con la MySQL.
     *
     * @throws SQLException Contiene informaci�n sobre un error del cierre de conexi�n.
     */
	 public static void cerrar() throws SQLException {

        try{
        	
        	 conexionMYSQL.close(); //cerrar la conexi�n MySQL.
        	 
        }catch(Exception e){

        	//Aviso por JOptionPane cuando no se ha podido cerrar la conexi�n con la MySQL.
    		JOptionPane.showMessageDialog(null, "Mal al cerrar la conexion","Error ",JOptionPane.ERROR_MESSAGE);
        }
	 } //cierre del m�todo cerrar mysql
	 
	 /**
	   * Sirve para realizar consultas del tipo: SELECT * FROM tabla WHERE..."
	   *
	   * @param stmt Sirve para la conexi�n con la base de datos
	   * @param cadena La consulta en concreto.
	   * @throws SQLException Contiene informaci�n sobre un error con la sentencia SQL.
	   * @return ResultSet Devuelve el resultado de la consulta realizada.
	   */
	 public static ResultSet consulta(Statement stmt,String cadena) throws SQLException {
		 
		 ResultSet rs = null; //Se define el atributo ResultSet como null
		 
		 try {
			 
	 		stmt = conexionMYSQL.prepareStatement(cadena); //Se establece la conexi�n con la MySQL pasando como par�metro una sentencia de sql.
            rs = stmt.executeQuery(cadena); //Establece el valor del ResultSet ejecutando la consulta dependiendo de la sql. 
            
		 }catch (SQLException sql) {
			 
			//Aviso por JOptionPane cuando la cadena no est� escrita adecuadamente.
			JOptionPane.showMessageDialog(null, "Error con: " + cadena,"Error ",JOptionPane.ERROR_MESSAGE);
			
			//Aviso por JOptionPane cuando se he producido un error de SQL.
           	JOptionPane.showMessageDialog(null, "SQLException: " + sql.getMessage(),"SQL ",JOptionPane.ERROR_MESSAGE);
		 }
		 
		 return rs; //devuelve el valor del ResultSet
		 
	 }//cierre del m�todo consulta
	 
	 /**
     * Realiza las consultas de actualizaci�n o inserci�n. No retorna nada pero si la cadena no es adecuada el resultado es -1.
     *
     * @param cadena La consulta en concreto
     */
	public static void consultaActualiza(String cadena){
		 
			@SuppressWarnings("unused")
			int rs=-1; //Definir el ResultSet como -1 por defecto si la cadena sql no es adecuada.
			
	        try {
	        	
	            rs = stmt.executeUpdate(cadena); //Actualiza los datos en la base de datos pasando los datos de la cadena sql.
	            
	        }catch (SQLException sql) {
	        	
	        	//Aviso por JOptionPane cuando la cadena no est� escrita adecuadamente.
	        	JOptionPane.showMessageDialog(null, "Error con: " + cadena,"Error ",JOptionPane.ERROR_MESSAGE);
	        	
	        	//Aviso por JOptionPane cuando se he producido un error de SQL.
	            JOptionPane.showMessageDialog(null, "SQLException: " + sql.getMessage(),"SQL ",JOptionPane.ERROR_MESSAGE);
	        }
	      
	 } //cierre del m�todo actualizaci�n
	 
	/**
     * Elimina los datos de la base de datos.
     *
     * @param cadena La consulta en concreto
     * @param campo El campo para eliminar la fila.
     */
	 public static void eliminarRegistro(String cadena,String campo){
		 
		 try {
		 	
			ps=conexionMYSQL.prepareStatement(cadena); //Prepara la conexi�n con la base de datos pasando como par�metro la cadena sql.
			ps.setString(1, campo); //establecemos el n�mero de del campo de la tabla matriculas o monitores y el par�metro de dato.
		 	ps.executeUpdate(); //Actualiza la ejecuci�n
		 		
		 } catch (SQLException sql) {
			 
			//Aviso por JOptionPane cuando la cadena no est� escrita adecuadamente.
			JOptionPane.showMessageDialog(null, "Error con: " + cadena,"Error ",JOptionPane.ERROR_MESSAGE);
			 
			//Aviso por JOptionPane cuando se he producido un error de SQL.
	        JOptionPane.showMessageDialog(null, "SQLException: " + sql.getMessage(),"SQL ",JOptionPane.ERROR_MESSAGE);
	           	
	     }
	 } //cierre del m�todo eliminar
	 
	/**
     * Elimina los datos de la base de datos.
     *
     * @param cadena La consulta en concreto
     * @param id El id para eliminar la fila correspondiente
     */
	 public static void eliminarRegistro(String cadena,int id){
		 
		 try {
		 	
			ps=conexionMYSQL.prepareStatement(cadena); //Prepara la conexi�n con la base de datos pasando como par�metro la cadena sql.
			ps.setInt(1, id); //establecemos el n�mero de del campo de la tabla juegos y el par�metro de dato.
		 	ps.executeUpdate(); //Actualiza la ejecuci�n
		 		
		 } catch (SQLException sql) {
			 
			//Aviso por JOptionPane cuando la cadena no est� escrita adecuadamente.
			JOptionPane.showMessageDialog(null, "Error con: " + cadena,"Error ",JOptionPane.ERROR_MESSAGE);
			 
			//Aviso por JOptionPane cuando se he producido un error de SQL.
	        JOptionPane.showMessageDialog(null, "SQLException: " + sql.getMessage(),"SQL ",JOptionPane.ERROR_MESSAGE);
	           	
	     }
	 } //cierre del m�todo eliminar
	 
	 /**
     * Elimina los datos de la base de datos.
     *
     * @param cadena La consulta en concreto
     */
	 public static void eliminarDatos(String cadena){
		 
		 try {
		 	
			ps=conexionMYSQL.prepareStatement(cadena); //Prepara la conexi�n con la base de datos pasando como par�metro la cadena sql.
		 	ps.executeUpdate(); //Actualiza la ejecuci�n
		 		
		 } catch (SQLException sql) {
			 
			//Aviso por JOptionPane cuando la cadena no est� escrita adecuadamente.
			JOptionPane.showMessageDialog(null, "Error con: " + cadena,"Error ",JOptionPane.ERROR_MESSAGE);
			 
			//Aviso por JOptionPane cuando se he producido un error de SQL.
	        JOptionPane.showMessageDialog(null, "SQLException: " + sql.getMessage(),"SQL ",JOptionPane.ERROR_MESSAGE);
	           	
	     }
	 } //cierre del m�todo eliminar

} //cierre de la clase