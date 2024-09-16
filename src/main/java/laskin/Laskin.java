package laskin;

public class Laskin {

    private double tulos;  	// Muuttuja tulokselle, muutettu double-tyyppiseksi tarkempia laskuja varten

    // Nollaa tulosmuuttuja
    public void nollaa() {
        tulos = 0;
    }

    // Palauta tulos
    public double annaTulos() {
        return tulos;
    }

    // Lisää n tulokseen
    public void lisaa(double n) {
        tulos = tulos + n;
    }

    // Vähennä n tuloksesta
    public void vahenna(double n) {
        tulos = tulos - n;  // Korjattu virheellinen vähennys (-1 -> -n)
    }

    // Kerro tulos luvulla n
    public void kerro(double n) {
        tulos = tulos * n;  // Toteutetaan kertolasku
    }

    // Jaa tulos luvulla n
    public void jaa(double n) {
        if (n == 0) {
            throw new ArithmeticException("Nollalla ei voi jakaa");
        }
        tulos = tulos / n;
    }

    // Korota luku n neliöön
    public void nelio(double n) {
        tulos = n * n;  // Muutettu laskukaava korjaamaan virhe
    }

    // Laske neliöjuuri luvusta n
    public void neliojuuri(double n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negatiivisen luvun neliöjuuri ei ole määritelty");
        }
        tulos = Math.sqrt(n);  // Toteutettu neliöjuuri
    }

    // Kerro kahdella luvulla (lisätty product)
    public void product(double a, double b) {
        tulos = a * b;
    }

    // Simuloi virran kytkemistä päälle
    public void virtaON() {
        tulos = 0;  // Alustetaan tulos
    }

    // Simuloi virran katkaisemista
    public void virtaOFF() {
        // Mahdolliset lopputoimet (ei vielä toteutettu)
    }
}
