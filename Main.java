import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner tara = new Scanner(System.in);
        Random rasgele = new Random();
        int mesafe = 100;
        int atSayisi;
        do {
            System.out.print("Kaç at yarışacak? (2-10): ");
            atSayisi = tara.nextInt();
        } while (atSayisi < 2 || atSayisi > 10);
        String[] atIsimleri = {"Yıldırım", "Şahbatur", "Şahin", "Kızılkanat", "Kırlangıç", "Alperen", "Ceylan", "SarıKız", "Kamikaze", "Hız"};
        int[] atHizlari = new int[atSayisi];
        int[] atMesafeleri = new int[atSayisi];
        System.out.println("Atlar yarışıyor...");
        boolean kazananBelirlendi = false;
        int kazananIndex = 0;
        while (!kazananBelirlendi) {
            for (int i = 0; i < atSayisi; i++) {
                atHizlari[i] = rasgele.nextInt(11) + 10;
                atMesafeleri[i] += atHizlari[i];
                if (atMesafeleri[i] >= mesafe) {
                    kazananIndex = i;
                    kazananBelirlendi = true;
                    break;
                }
            }
            for (int i = 0; i < atSayisi; i++) {
                System.out.print(atIsimleri[i] + ": ");
                for (int j = 0; j < atMesafeleri[i]; j++) {
                    System.out.print(" ");
                }
                System.out.print("->\n");
            }
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Yarışı " + atIsimleri[kazananIndex] + " kazandı! (" + atMesafeleri[kazananIndex] + " km)");
        for (int i = 0; i < atSayisi; i++) {
            if (i != kazananIndex) {
                System.out.println(atIsimleri[i] + ": " + atMesafeleri[i] + " km");
            }
        }
    }
}
