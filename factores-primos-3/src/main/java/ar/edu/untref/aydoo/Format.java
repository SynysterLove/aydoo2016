package ar.edu.untref.aydoo;

import java.util.LinkedList;

public class Format extends Opcion {
	
	public Format() {
		
		this.parametros = new LinkedList<String>();
		this.opcion = "--format=";
		
	}

	@Override
	protected void solicitarEjecucionConParametro(String numero, String stringParcial, String parametro) {
		
		
		
	}


}