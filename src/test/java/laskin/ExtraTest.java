package laskin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExtraTest extends AbstractParent {

    private static Laskin laskin = new Laskin();

    @ParameterizedTest(name = "Luvun {0} neliö on {1}")
    @CsvSource({ "2, 4", "4, 16", "5, 25" })
    public void testNelioParametrized(int luku, int odotettu) {
        laskin.nelio(luku);
        assertEquals(odotettu, laskin.annaTulos(), "Neliöön korotus väärin");
    }

    @ParameterizedTest(name = "Luvun {0} neliö on {1}")
    @CsvSource({ "0, 0", "1, 1", "2, 4", "4, 16", "5, 25", "6, 36" })  // Corrected 6^2 = 36
    public void testNelio(int luku, int tulos) {
        laskin.nelio(luku);
        assertEquals(tulos, laskin.annaTulos(), "Neliöön korotus ei nyt kyllä skulaa");
    }


    @ParameterizedTest(name = "Luvun {0} neliöjuuri on {1}")
    @CsvSource({ "4, 2", "9, 3", "16, 4" })
    public void testNeliojuuriParametrized(int luku, double odotettu) {
        laskin.neliojuuri(luku);
        assertEquals(odotettu, laskin.annaTulos(), 0.001, "Neliöjuuri väärin");
    }
    private final double DELTA = 0.001;

    @BeforeAll
    public static void testVirtaON() {
        System.out.println("@BeforeAll Virta ON (ennen ensimmäistä testiä)");
        laskin.virtaON();
    }

    @AfterAll
    public static void testVirtaOFF() {
        System.out.println("@AfterAll Virta OFF (kaikki testit ajettu).");
        laskin.virtaOFF();
        laskin = null;
    }

    @BeforeEach
    public void testNollaa() {
        System.out.println("  Nollaa laskin.");
        laskin.nollaa();
        assertEquals(0, laskin.annaTulos(), "Nollaus ei onnistunut");
    }

    @Test
    public void testNelio2() {
        laskin.nelio(2);
        assertEquals(4, laskin.annaTulos(), "Luvun 2 Neliöön korotus väärin");
    }

    @Test
    public void testNelio4() {
        laskin.nelio(4);
        assertEquals(16, laskin.annaTulos(),"Luvun 4 neliöön korotus väärin");
    }

    @Test
    public void testNelio5() {
        laskin.nelio(5);
        assertEquals(25, laskin.annaTulos(), DELTA,"Luvun 5 neliöön korotus väärin");
    }
    @Test
    public void testNeliojuuri2() {
        laskin.neliojuuri(2);
        // Tähän assertXXX(), odotetun tuloksen tulee olla (int)Math.sqrt(2)
    }

    @Test
    @DisplayName("Testaa negatiivinen neliöjuuri")
    public void testNeliojuuriNegat() {
        assertThrows(IllegalArgumentException.class, () -> laskin.neliojuuri(-4), "Negatiivinen neliöjuuri pitäisi heittää poikkeuksen");
    }
}
