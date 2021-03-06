package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.Test;

public class AlquilerCuatrimestralTest {

    @Test
    public void quePuedaCrearElAlquilerDelHobbitPorUnCuatrimestre() {

        Libro hobbit = new Libro("El Hobbit", 20);
        Alquiler alquilerCuatri = new AlquilerCuatrimestral(hobbit, 1);

        Assert.assertEquals("Alquiler El Hobbit", alquilerCuatri.getNombre());
        Assert.assertEquals(1, alquilerCuatri.getPeriodo());
        Assert.assertTrue(hobbit.equals(alquilerCuatri.getLibro()));

    }

    @Test
    public void queElPrecioCuatrimestralConDescuentoSeCalculeCorrectamenteParaUnCuatrimestre() {

        Libro hobbit = new Libro("El Hobbit", 20);
        Alquiler alquilerCuatri = new AlquilerCuatrimestral(hobbit, 1);
        Assert.assertEquals(720.0, alquilerCuatri.getPrecio(), 0.0);

    }

    @Test
    public void queElPrecioCuatrimestralConDescuentoSeCalculeCorrectamenteParaDosCuatrimestres() {

        Libro hobbit = new Libro("El Hobbit", 20);
        Alquiler alquilerCuatri = new AlquilerCuatrimestral(hobbit, 2);
        Assert.assertEquals(1440, alquilerCuatri.getPrecio(), 0.0);

    }

    @Test(expected = PeriodoExcedidoException.class)
    public void queNoAlquilePor3Cuatrimestres() {

        Libro hobbit = new Libro("El Hobbit", 20);
        Alquiler alquilerCuatri = new AlquilerCuatrimestral(hobbit, 3);

    }

    @Test(expected = PeriodoExcedidoException.class)
    public void queNoAlquilePor0Cuatrimestres() {

        Libro hobbit = new Libro("El Hobbit", 20);
        Alquiler alquilerCuatri = new AlquilerCuatrimestral(hobbit, 0);

    }

    
}
