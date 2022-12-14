package totalflix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import totalflix.classes.Artista;

public class ArtistaTest {
    @Test
    public void testConstructor() {
        final Artista artista = new Artista(1, "João da Silva", "Biografia de João da Silva", "01/01/1900",
                "01/01/2000");
        assertEquals(1, artista.getIdArtista());
        assertEquals("João da Silva", artista.getNomeArtista());
        assertEquals("Biografia de João da Silva", artista.getBiografia());
        assertEquals("01/01/1900", artista.getDataNascArtista());
        assertEquals("01/01/2000", artista.getDataFalecimento());
    }

    @Test
    public void testSetters() {
        final Artista artista = new Artista(1, "João da Silva", "Biografia de João da Silva", "01/01/1900",
                "01/01/2000");
        artista.setNome("Maria da Silva");
        artista.setBiografia("Biografia de Maria da Silva");
        artista.setDataFalecimento("02/02/2000");
        assertEquals("Maria da Silva", artista.getNomeArtista());
        assertEquals("Biografia de Maria da Silva", artista.getBiografia());
        assertEquals("02/02/2000", artista.getDataFalecimento());
    }

    @Test
    public void testBiografiaVazia() {
        final Artista artista = new Artista(1, "João da Silva", "", "01/01/1900", "01/01/2000");
        assertEquals("", artista.getBiografia());
    }

    @Test
    public void testDataNascimentoVazia() {
        final Artista artista = new Artista(1, "João da Silva", "Biografia de João da Silva", "", "01/01/2000");
        assertEquals("", artista.getDataNascArtista());
    }

    @Test
    public void testDataFalecimentoInvalida() {
        final Artista artista = new Artista(1, "João da Silva", "Biografia de João da Silva", "01/01/1900",
                "data inválida");
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        assertThrows(java.time.format.DateTimeParseException.class,
                () -> LocalDate.parse(artista.getDataFalecimento(), formatter));
    }
}
