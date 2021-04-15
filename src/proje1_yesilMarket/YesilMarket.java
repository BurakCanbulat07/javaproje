package proje1_yesilMarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YesilMarket {
	static List<Double> sepet = new ArrayList<>();
	static List<Double> fiyatListesi = new ArrayList<>();
	static List<String> urunListesi = new ArrayList<>();

	static int urun = 0;
	static double fiyat = 0;
	static double toplam = 0;
	static boolean flag=false; 
	static char devam=' ';
	public static void main(String[] args) {
		/* Yeşil Market alış-veriş programı.
         * 
         * 1. Adım: Ürünler ve fiyatları içeren listeleri oluşturunuz.
         *        |  No      Ürün         Fiyat
                  |====  =======        =========
                  |  00   Domates      	 2.10 TL 
                  |  01   Patates      	 3.20 TL
                  |  02   Biber       	 1.50 TL
                  |  03   Soğan       	 2.30 TL
                  |  04   Havuç          3.10 TL
                  |  05   Elma           1.20 TL
                  |  06   Muz          	 1.90 TL
                  |  07   Çilek          6.10 TL
                  |  08   Kavun          4.30 TL
                  |  09   Üzüm           2.70 TL
                  |  10   Limon        	 0.50 TL
                    
         * 2. Adım: Kullanıcının ürün nosuna göre listeden ürün seçmesini isteyiniz.
         * 3. Adım: Kaç kg satın almak istediğini sorunuz.
         * 4. Adım: Alınacak bu ürünü sepete ekleyiniz ve Sepeti yazdırınız.
         * 5. Başka bir ürün alıp almak istemediğini sorunuz.
         * 6. Eğer devam etmek istiyorsa yeniden ürün seçme kısmına yönlendiriniz.
         * 7. Eğer bitirmek istiyorsa ödeme kısmına geçiniz ve ödem sonrasında programı bitirinzi.
         */
		
		Scanner scan = new Scanner(System.in);
		
		urunListesi.add("Domates");
		urunListesi.add("Patates");
		urunListesi.add("Biber");
		urunListesi.add("Sogan");
		urunListesi.add("Havuç");
		urunListesi.add("Elma");
		urunListesi.add("Muz");
		urunListesi.add("Çilek");
		urunListesi.add("Kavun");
		urunListesi.add("Üzüm");
		urunListesi.add("Limon");

		fiyatListesi.add(2.10);
		fiyatListesi.add(3.20);
		fiyatListesi.add(1.50);
		fiyatListesi.add(2.30);
		fiyatListesi.add(3.10);
		fiyatListesi.add(1.20);
		fiyatListesi.add(1.90);
		fiyatListesi.add(6.10);
		fiyatListesi.add(4.30);
		fiyatListesi.add(2.70);
		fiyatListesi.add(0.50);


	do {
			System.out.println("		    No      Ürün         Fiyat\r\n"
					+ "                   ====  =======       =========\r\n"
					+ "                     0   Domates	2.10 TL \r\n"
					+ "                     1   Patates	3.20 TL\r\n"
					+ "                     2   Biber		1.50 TL\r\n"
					+ "                     3   Soğan		2.30 TL\r\n"
					+ "                     4   Havuç		3.10 TL\r\n"
					+ "                     5   Elma		1.20 TL\r\n"
					+ "                     6   Muz		1.90 TL\r\n"
					+ "                     7   Çilek		6.10 TL\r\n"
					+ "                     8   Kavun		4.30 TL\r\n"
					+ "                     9   Üzüm		2.70 TL\r\n"
					+ "                    10   Limon		0.50 TL");
			
			System.out.println("Almak istediginiz urunun urun no'sunu girin");
			urun = scan.nextInt();
			System.out.println("Istediginiz kilo miktarini giriniz");
			 fiyat = agirlik(scan.nextDouble());
			if (fiyat==0) {
				break;
			}else {

				sepeteEkle(fiyat);
					toplam=0;
				for (int i = 0; i < sepet.size(); i++) {
					toplam+=sepet.get(i);
				}
				System.out.println("Sepet toplami: "+toplam);
				
				
				do {System.out.println();
				System.out.println("Alisverise devam etmek ister misiniz? E/H");
				char devam = scan.next().toUpperCase().charAt(0);
				if (devam=='E') {
					break;
				}else if (devam=='H') {
					flag=true;
					break;
					}else {
						System.out.println("Gecersiz. Tekrar deneyin.");
					}
				} while(true);
				if (flag) {
					break;
				}
				if (devam=='H') {
					break;
			}
			}
		} while (true);
	
	odeme();

	scan.close();}

	public static void odeme() {
		System.out.println("Toplam odemeniz gereken miktar: "+toplam);
	}

	public static void sepeteEkle(double fiyat) {
		sepet.add(fiyat);
	}

	public static double agirlik(double kg) {
		
		try {
			return urunSecim(urun)*kg;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("gecersiz urun no");
			return 0;
		}}


	public static double urunSecim(int u) {
		return fiyatListesi.get(u);
	}
}

