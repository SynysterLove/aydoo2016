package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.List;

public abstract class Opcion {

	protected String opcion;
	protected List<String> parametros;
	
	public String getOpcion() {
		
		return this.opcion;
	}

	private String seleccionarParametro(String argumento) {
		
		Iterator<String> iteradorParametros = this.parametros.iterator();
		while (iteradorParametros.hasNext()) {
			
			String parametroActual = iteradorParametros.next();
			if (argumento.endsWith(parametroActual)) {
				
				return parametroActual;
				
			}
			
		}
		
		throw new ParametroInexistenteException();
		
	}

	public void solicitarEjecucion(String numero, String stringParcial, String argumento) {
		
		String parametro = this.seleccionarParametro(argumento);
		this.solicitarEjecucionConParametro(numero, stringParcial, parametro);
		
	}

	protected abstract void solicitarEjecucionConParametro(String numero, String stringParcial, String parametro);


	
}