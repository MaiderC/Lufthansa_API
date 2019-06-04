package COMUN;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import APIs.itfCargaVuelosLufthansa;


public class Lufthansa extends UnicastRemoteObject implements itfCargaVuelosLufthansa
{
	private ArrayList<String>  ListaVuelos= new ArrayList<String>();
	
	public ArrayList<String> getListaVuelos() {
		return ListaVuelos;
	}

	public void setListaVuelos(ArrayList<String> listaVuelos) {
		ListaVuelos = listaVuelos;
	}

	public Lufthansa() throws RemoteException 
	{
		super();
		//En el constructor, creamos todos los vuelos:
				
				//( AMSTERDAM - LONDRES )
				ListaVuelos.add("LUF0001;Amsterdam;Londres;28/05/2019;180.90;120");
				ListaVuelos.add("LUF0002;Amsterdam;Londres;23/05/2019;230.15;120");
				ListaVuelos.add("LUF0003;Amsterdam;Londres;01/06/2019;79.89;120");
				
				//( BARCELONA - MADRID)
				ListaVuelos.add("LUF0004;Barcelona;Madrid;13/06/2019;180.90;120");
				ListaVuelos.add("LUF0005;Barcelona;Madrid;02/05/2019;230.15;120");
				ListaVuelos.add("LUF0006;Barcelona;Madrid;10/05/2019;79.89;120");

				//( BILBAO - DUBLIN )
				ListaVuelos.add("LUF0007;Bilbao;Dublin;23/05/2019;180.90;120");
				ListaVuelos.add("LUF0008;Bilbao;Dublin;30/05/2019;230.15;120");
				ListaVuelos.add("LUF0009;Bilbao;Dublin;13/05/2019;79.89;120");

				//( GLASGOW - REIKIAVIK )
				ListaVuelos.add("LUF0010;Glasgow;Reikiavik;13/06/2019;180.90;120");
				ListaVuelos.add("LUF0011;Glasgow;Reikiavik;27/06/2019;230.15;120");
				ListaVuelos.add("LUF0012;Glasgow;Reikiavik;17/06/2019;79.89;120");

				//( ROMA - MOSCU )
				ListaVuelos.add("LUF0013;Roma;Moscu;09/06/2019;180.90;120");
				ListaVuelos.add("LUF0014;Roma;Moscu;02/06/2019;230.15;120");
				ListaVuelos.add("LUF0015;Roma;Moscu;13/06/2019;79.89;120");
	}			

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ArrayList<String> cargarIda(String ciudadOrigen, String ciudadDestino, String fecha)  throws RemoteException
	{
		ArrayList<String> retorno = new ArrayList<String>();
		String[] vueloToken;
		
		for(String aux: ListaVuelos)
		{
			vueloToken = aux.split(";");
			
			if(vueloToken[1].equals(ciudadOrigen) && vueloToken[2].equals(ciudadDestino) && vueloToken[3].equals(fecha))
			{
				retorno.add(aux);
			}
		}
		
		return retorno;
	}

	@Override
	public ArrayList<String> cargarIdaVuelta(String ciudadOrigen, String ciudadDestino, String fechaIda, String fechaVuelta)  throws RemoteException
	{
		ArrayList<String> retorno = new ArrayList<String>();
		String[] vueloToken;
		
		for(String aux: ListaVuelos)
		{
			vueloToken = aux.split(";");
			
			if(vueloToken[1].equals(ciudadOrigen) && vueloToken[2].equals(ciudadDestino) && vueloToken[3].equals(fechaIda))
			{
				retorno.add(aux);
			}
			
			if(vueloToken[1].equals(ciudadDestino) && vueloToken[2].equals(ciudadOrigen) && vueloToken[3].equals(fechaVuelta))
			{
				retorno.add(aux);
			}
		}
		
		return retorno;
	}

	@Override
	public ArrayList<String> cargarCualquierMomento(String ciudadOrigen, String ciudadDestino) throws RemoteException 
	{
		ArrayList<String> retorno = new ArrayList<String>();
		String[] vueloToken;
		
		for(String aux: ListaVuelos)
		{
			vueloToken = aux.split(";");
			
			if(vueloToken[1].equals(ciudadOrigen) && vueloToken[2].equals(ciudadDestino))
			{
				retorno.add(aux);
			}
		}
		
		return retorno;
	}

	@Override
	public ArrayList<String> cargarTodos()  throws RemoteException
	{
		return ListaVuelos;
	}
}
