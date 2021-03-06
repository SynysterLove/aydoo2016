package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class OrdenadorDeArgumentosTest {

	private OrdenadorDeArgumentos ordenador;
	private String[] string;

	@Before
	public void prepararArray() {

		ordenador = new OrdenadorDeArgumentos();
		this.string = new String[6];
		this.string[0] = "1";
		this.string[1] = "--format=pretty";
		this.string[2] = "blabla";
		this.string[3] = "blabla3";
		this.string[4] = "blabla4";
		this.string[5] = "blabla5";

	}

	@Test
	public void queObtengaElFormatoPretty() {

		Assert.assertEquals("--format=pretty", this.ordenador.obtenerFormato(this.string));

	}

	@Test(expected= NoEstaElFormatoException.class)
	public void queNoObtengaElFormatoPretty() {

		this.string[1] = "agagsa";
		this.ordenador.obtenerFormato(this.string);

	}

	@Test
	public void queEsteElFormato() {

		Assert.assertTrue(this.ordenador.estaElArgumentoFormat(this.string));

	}

	@Test
	public void queNoEsteElFormato() {

		this.string[2] = "sghñhñh";
		
		Assert.assertTrue(this.ordenador.estaElArgumentoFormat(this.string));

	}

	@Test
	public void queAgregueElFormatoPrettyYPongaCorrectamenteElFormatoEnLaPrimerPosicion() {

		this.string[1] = "blabla1";
		this.string[2] = "alagsdh";
		String esperado[] = new String[this.string.length+1];
		esperado[0] = "1";
		esperado[1] = "--format=pretty";
		esperado[2] = "blabla1";
		esperado[3] = "alagsdh";
		esperado[4] = "blabla3";
		esperado[5] = "blabla4";
		esperado[6] = "blabla5";
		
		Assert.assertArrayEquals(esperado, this.ordenador.ponerFormatEnPosicion1(this.string));

	}

	@Test
	public void quePongaCorrectamenteElFormatoEnLaPrimerPosicionConElFormatoYaIndicado() {

		this.string[1] = "blabla1";
		this.string[2] = "--format=pretty";
		String esperado[] = new String[this.string.length];
		esperado[0] = "1";
		esperado[1] = "--format=pretty";
		esperado[2] = "blabla1";
		esperado[3] = "blabla3";
		esperado[4] = "blabla4";
		esperado[5] = "blabla5";
		
		Assert.assertArrayEquals(esperado, this.ordenador.ponerFormatEnPosicion1(this.string));

	}

	@Test
	public void quePongaCorrectamenteElOutputEnLaUltimaPosicion() {

		String[] stringLargoConOutput = new String[6];
		stringLargoConOutput[0] = "25";
		stringLargoConOutput[1] = "--format=pretty";
		stringLargoConOutput[2] = "--output-file=gshshfsfh";
		stringLargoConOutput[3] = "dhgjd";
		stringLargoConOutput[4] = "fjhdjf";
		stringLargoConOutput[5] = "dfgjdgkjdgk";

		String esperado[] = new String[6];
		esperado[0] = "25";
		esperado[1] = "--format=pretty";
		esperado[2] = "dhgjd";
		esperado[3] = "fjhdjf";
		esperado[4] = "dfgjdgkjdgk";
		esperado[5] = "--output-file=gshshfsfh";
		
		Assert.assertArrayEquals(esperado, this.ordenador.ponerOutputEnPosicionFinal(stringLargoConOutput));;

	}

	@Test
	public void queElColocadorDeOutputDevuelvaElArrayComoEstaYConUnGuionEnUltimaPosicionSiNoHayOutput() {

		String esperado[] = new String[this.string.length+1];
		for (int i=0; i < this.string.length; i++) {
			
			esperado[i] = this.string[i];
			
		}
		esperado[this.string.length] = "--output-file=-";
		
		Assert.assertArrayEquals(esperado, this.ordenador.ponerOutputEnPosicionFinal(this.string));

	}
}
