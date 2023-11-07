package oms.UD22EJ2;

import oms.controllers.Controlador;
import oms.models.Modelo;
import oms.views.Vista;
import oms.conectorDB.ConectorDB;

import javax.swing.table.DefaultTableModel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DefaultTableModel modelo_tabla = new DefaultTableModel();
    	ConectorDB conector = new ConectorDB();
    	Modelo modelo = new Modelo(conector);
		Vista vista = new Vista(modelo_tabla);
		Controlador controlador = new Controlador(modelo, vista);
		controlador.iniciarVista();
    }
}
