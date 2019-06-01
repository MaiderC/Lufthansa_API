package APIs;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;


public interface itfCargaVuelosLufthansa extends Remote
{
	ArrayList<String> cargarIda(String ciudadOrigen, String ciudadDestino, String fecha) throws RemoteException;
	ArrayList<String> cargarIdaVuelta(String ciudadOrigen, String ciudadDestino, String fechaIda,String fechaVuelta) throws RemoteException;
	ArrayList<String> cargarCualquierMomento(String ciudadoOrigen, String ciudadDestino) throws RemoteException;
	ArrayList<String> cargarTodos() throws RemoteException;
}
