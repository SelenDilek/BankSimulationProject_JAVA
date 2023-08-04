import java.util.*;

public class BankSimulation {
    /**
     * NOT //////////////////////////////////////////////////////////////////////////////////////////////
     * Aşağıdaki üç field'ın (customers,accounts,scanner) final olması ilk bakışta
     * "bu listeler değiştirilemez olursa, bunlara nasıl müşteri veya hesap ekleriz?"
     * gibi bir soru akla getirebilir.
     * Ancak burada değiştirilemeyecek olan, değerlerin içi değil, referansıdır...
     * `BankSimulation` sınıfı içindeki `accounts` ve `customers` dizi-değişkenlerinin
     * `final` olmasının nedeni, bu değişkenlere atanan referansların sonradan değiştirilmesini engellemek
     * ve programın daha güvenli ve kontrol edilebilir olmasını sağlamaktır.
     * `final` anahtar kelimesiyle tanımlanan bir değişkenin değeri sadece bir kez atanabilir
     * ve sonradan değiştirilemez.
     * Bu tanımlama, `customers` değişkeninin referansının değiştirilemeyeceği anlamına gelir.
     * Ancak, `customers` değişkenine atanan `HashMap` nesnesinin içeriği yine de değiştirilebilir.
     * Yani, `customers` değişkeninin referansı aynı kalacak şekilde müşteri bilgileri eklenebilir,
     * güncellenebilir veya silinebilir.
     * ////////////////////////////////////////////////////////////////////////////////////////////////
     */
    // FIELDS ///////////////////////////////////////////////////////////////////////////////////////

    /** AÇIKLAMADA BELİRTİLEN FIELD LARI OLUŞTURUN...  */
    ////////////////////////////////////////////////////////////////////////////////////////////////

    // CONSTRUCTORS     ////////////////////////////////////////////////////////////////////////////
    // public BankSimulation() metodu bir constructor'dır.
    // Constructor, bir sınıfın nesnesi oluşturulduğunda otomatik olarak çağrılan bir metottur
    // ve nesnenin başlatılması için kullanılır.
    // BankSimulation sınıfındaki bu constructor,
    // sınıfın nesnesi oluşturulduğunda müşteri ve hesapları saklamak için
    // customers ve accounts değişkenlerini uygun şekilde başlatır.
    // Aynı zamanda kullanıcıdan girdiler almak için scanner değişkenini de başlatır.
    // Bu constructor sayesinde, BankSimulation sınıfından bir nesne oluşturduğunuzda,
    // müşteri ve hesap verilerini saklamak ve kullanıcıdan girdiler almak için gerekli olan
    // başlangıç durumu hazırlanmış olur.

    /**
     * AÇIKLAMADA BELİRTİLEN CONSTRUCTORLARI OLUŞTURUN...
     */

    ///////////////////////////////////////////////////////////////////////////////////////////

    //customers (Map<Integer, Customer>),
    private final static Map<Integer, Customer> customers = new LinkedHashMap<>();
    //accounts (List<Account>),
    private final static List<Account> accounts = new ArrayList<>();
    //scanner (Scanner)
    private final static Scanner scannerStr = new Scanner(System.in);
    private final static Scanner scannerInt = new Scanner(System.in);

    public BankSimulation() {

    }


    public static void main(String[] args) {

        BankSimulation bankSimulation = new BankSimulation();
        bankSimulation.run();

        /** BANKSIMULATION SINIFININ NESNESİNİ OLUŞTURUNUZ;*/
        /** RUN METODUNU ÇAĞIRINIZ */

    }

    // public void run() METODU, ÇIKIŞ YAPILANA KADAR ÇALIŞACAK OLAN ANA METOD ////////////////
    public void run() {
        int choice;

        do {
            System.out.print("\n----- BANKA İŞLEMLERİ -----" +
                    "\n1. Müşteri Listele" +
                    "\n2. Yeni Müşteri Ekle" +
                    "\n3. Müşteri İşlemleri" +
                    "\n0. Çıkış" +
                    "\nSeçiminizi yapın: ");

            choice = scannerInt.nextInt();

            switch (choice) {

                case 1:
                    listCustomers();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    customerOperationsMenu();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Tekrar deneyin.");
            }

        } while (choice != 0);

        /** ANA MENÜYÜ OLUŞTURUN VE MÜŞTERİYE YAPTIRDIĞINIZ SEÇİMLERLE, İLGİLİ METODLARA YÖNLENDİRİN...*/
        /**
         * "\n----- BANKA İŞLEMLERİ -----"
         * "1. Müşteri Listele"
         * "2. Yeni Müşteri Ekle"
         * "3. Müşteri İşlemleri"
         * "0. Çıkış"
         * "Seçiminizi yapın: "
         * */
        //1//   listCustomers();
        //2//   addCustomer();
        //3//   customerOperationsMenu();
        //0//   System.out.println("Çıkış yapılıyor...");
        // //   System.out.println("Geçersiz seçim! Tekrar deneyin.");

        /** MÜŞTERİ ÇIKIŞ YAPMADIĞI SÜRECE MENÜDE KALMAYA DEVAM ETSİN...*/

    }
    ///////////////////////////////////////////////////////////////////////////////////////////


    // MÜŞTERİLERİ LİSTELEYECEK OLAN METHOD ///////////////////////////////////////////////////
    public void listCustomers() {
        System.out.println("\n----- MÜŞTERİLER -----");
        for (Map.Entry<Integer, Customer> each : customers.entrySet()) {
            System.out.println(each.getKey() + ":" + each.getValue());

        }

        /** MÜŞTERİLERİ LİSTELEYECEK ŞEKİLDE METODU DOLDURUNUZ... */
    }
    ////////////////////////////////////////////////////////////////////////////////////////////


    // MÜŞTERİLER LİSTELENİRKEN HESAP BİLGİSİ DE LİSTELENMESİ İÇİN GEREKLİ METOD.////////////////
    public void listCustomerAccounts(Customer customer) {
        System.out.println("----- " + customer.getCustomerId() +
                " " + customer.getFirstName() +
                " " + customer.getLastName() +
                " HESAPLARI -----");


        int Id=customer.getCustomerId();
       for (Account each :accounts){
           if (each.getCustomerId()==Id){
               System.out.println(each);
           }
       }

        /** MÜŞTERİ HESAPLARINI LİSTELEYECEK ŞEKİLDE METODU DOLDURUNUZ... */
    }
    //////////////////////////////////////////////////////////////////////////////////////////////


    // KONSOLDAN İSİM, SOYİSİM VE ŞEHİR BİLGİSİ ALARAK MÜŞTERİ EKLEME METODU. /////////////////////
    public void addCustomer() {
        System.out.println("\n----- YENİ MÜŞTERİ EKLE -----");
        System.out.print("İsim giriniz: ");
        String isim = scannerStr.nextLine();

        System.out.print("Soyisim giriniz: ");
        String soyIsim = scannerStr.nextLine();

        System.out.print("Şehir giriniz: ");
        String sehir = scannerStr.nextLine();

        /** KONSOLDAN İSİM, SOYİSİM VE ŞEHİR BİLGİSİ İSTEYİNİZ  */
        /** UNIQUE (TEKİL BİR MÜŞTERİ ID Sİ OLUŞTURUNUZ */
        /** ELDE ETTİĞİNİZ BU BİLGİLERLE YENİ MÜŞTERİ OLUŞTURUNUZ   */
        /** OLUŞTURDUĞUNUZ BİLGİLERİ BU SINIFIN FIELD ALANINDA TANIMLANAN MAP'E EKLEYİNİZ   */

        Customer customer = new Customer(isim, soyIsim, sehir);
        customers.put(customer.getCustomerId(), customer);

        System.out.println("Müşteri başarıyla eklendi. Müşteri ID: " + customer.getCustomerId());
    }
    /////////////////////////////////////////////////////////////////////////////////////////////


    // ANA MENÜDEN MÜŞTERİ İŞLEMLERİNİ SEÇİNCE KARŞIMIZA ÇIKACAK OLAN METOD /////////////////////
    // HANGİ MÜŞTERİ DEMEK, HANGİ MÜŞTERİ ID'Sİ DEMEK, BU KONTROLÜ YAPMAMIZ GEREK...
    // KONSOLDAN MÜŞTERİ ID Sİ YANLIŞ GİRİLİRSE, GEÇERSİZ MÜŞTERİ MESAJI VE TEKRAR ID İSTEMESİ GEREKECEK...
    public void customerOperationsMenu() {
        int customerId;
        do {
            System.out.println("\n----- MÜŞTERİ İŞLEMLERİ -----");
            System.out.println("0. Ana Menüye Dön");
            System.out.print("Müşteri ID girin (0 çıkış yapar): ");

            System.out.print("Müşteri ID si giriniz: ");
            customerId = scannerInt.nextInt();
            if (customerId == 0) {
                break;
            }
            int uyeVar = 0;
            for (Map.Entry<Integer, Customer> each : customers.entrySet()) {
                if (each.getKey() == customerId) {
                    uyeVar = customerId;
                    break;
                }
            }
            if (uyeVar != 0) {
                customerOperations(customers.get(customerId));
                break;
            } else {
                System.out.println("Geçersiz Müşteri ID. Tekrar deneyin.");
            }


            /** KULLANICIDAN (BANKA GİŞE MEMURU) İŞLEM YAPACAĞI MÜŞTERİ ID Sİ İSTEYİN... */
            /** BU ID'NİN MÜŞTERİ LİSTESİNDE OLUP OLMADIĞINI KONTROL EDİN...    */
            /** ID MAP TE YOKSA, "Geçersiz Müşteri ID. Tekrar deneyin." MESAJI VERİN... */
        } while (true); /** BU BLOK KULLANICI ÇIKMAK İSTEMEDİĞİ SÜRECE DEVAM ETSİN... */
    }
    ///////////////////////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////////////////////
    // customerOperationsMenu() METODUNDA MÜŞTERİ ID'Sİ DOĞRULANIRSA, BANKA MEMURUNUN (KULLANICI)
    // KARŞISINA MÜŞTERİ İŞLEMLERİ GERÇEKLEŞTİREBİLECEĞİ AŞAĞIDAKİ GİBİ BİR MENÜ ÇIKACAK.
    // --- İSİM SOYİSİM 'İN --- İŞLEMLERİ ---
    // 1.Yeni Hesap Aç,
    // 2. Hesapları Listele
    // 3. Para Yatır
    // 4. Para Çek
    // 5. Bakiye Sorgula
    // 0. Ana Menüye Dön
    // Seçiminizi yapın:
    public static void customerOperationsMenu2() {
        System.out.print("1. Yeni Hesap Aç\n" +
                "2. Hesapları Listele\n" +
                "3. Para Yatır\n" +
                "4. Para Çek\n" +
                "5. Bakiye Sorgula\n" +
                "0. Ana Menüye Dön\n" +
                "Seçiminizi yapın:");
    }

    public void customerOperations(Customer customer) {
        int choice;
        do {
            System.out.println("\n----- " + customer.getFirstName() +
                    " " + customer.getLastName() +
                    " İŞLEMLERİ -----"
            );
            customerOperationsMenu2();

            choice = scannerInt.nextInt();

            switch (choice) {

                case 1:
                    openNewAccount(customer);
                    break;
                case 2:
                    listCustomerAccounts(customer);
                    break;
                case 3:
                    depositToAccount(customer);
                    break;
                case 4:
                    withdrawToAccount(customer);
                    break;
                case 5:
                    checkBalance(customer);
                    break;
                case 0:
                    System.out.println("Ana menüye dönülüyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Tekrar deneyin.");


            }

            /** MÜŞTERİ İŞLEMLERİ MENÜSÜNÜ EKRANA BASIN VE KULLANICIDAN TERCİH İSTEYİN... */
            /** SEÇİME GÖRE KULLANICIYI AŞAĞIDAKİNE BENZER METODLARLA SEÇTİĞİ OPERASYONA YÖNLENDİRİN... *
             openNewAccount(customer);
             listCustomerAccounts(customer);
             depositToAccount(customer);
             withdrawToAccount(customer);
             checkBalance(customer);
             System.out.println("Ana menüye dönülüyor...");
             System.out.println("Geçersiz seçim! Tekrar deneyin.");
             */

        } while (choice != 0);/** BU BLOK KULLANICI ÇIKMAK İSTEYENE KADAR DEVAM ETSİN... */
    }
    //////////////////////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////////////////////
    // HESAP AÇARKEN, AÇILACAK HESAP TÜRÜNÜ SEÇMEK İÇİN BİR MENÜ OLACAK...
    // HESAP TÜRÜNÜ SEÇTİKTEN SONRA DA, ID ATAYARAK accounts LIST İNE YENİ HESABI EKLEYEN METOD
    public void openNewAccount(Customer customer) {
        int choice;
        AccountType hesapTuru;

        System.out.println("\n----- YENİ HESAP AÇ -----");
        System.out.println("1. Vadesiz Hesap");
        System.out.println("2. Tasarruf Hesabı");
        System.out.println("3. Kredi Hesabı");
        System.out.print("Hesap Türü Seçin:");

        choice=scannerInt.nextInt();
        Account yeniHesap=null;

        switch (choice){
            case 1:
                hesapTuru=AccountType.CHECKING;
                yeniHesap = new Account(customer.getCustomerId(),hesapTuru);
                break;
            case 2:
                hesapTuru=AccountType.SAVINGS;
                yeniHesap = new Account(customer.getCustomerId(),hesapTuru);
                break;
            case 3:
                hesapTuru=AccountType.CREDIT;
                yeniHesap = new Account(customer.getCustomerId(),hesapTuru);
                break;
            default:
                System.out.println("Geçersiz seçim! Yeni hesap açma işlemi iptal edildi.");
        }
        try {
            System.out.println("Hesap başarıyla açıldı. Hesap Numarası: " + yeniHesap.getAccountId());
            accounts.add(yeniHesap);
        }catch (Exception e ){
            System.out.println("Geçersiz seçim");
        }




        /** SEÇİM YAPMASI İÇİN KULLANICIYA HESAP TÜRLERİNİ (ENUM) LİSTELEYİN... */
        /** KULLANICIYA KONSOLDAN SEÇİM YAPTIRIN... */
        /** SEÇİLEN DEĞERE GÖRE HESAP TÜRÜNÜ ATAYIN >> accountType (CHECKING-VADESİZ HES,
         * SAVINGS-TASARRUF HES, CREDIT-KREDİ HES) GİBİ...*/

        /** TEKİL BİR HESAP ID'Sİ ATAYIN... HESAP LİSTESİNİN SİZE'INI KULLANARAK SAYAÇ ŞEKLİNDE ID ATANABİLİR...*/

        /** ELDE ETTİĞİNİZ DEĞERLERE GÖRE HESAP LİSTESİNE (accounts) YENİ HESABI EKLEYİNİZ... */

        /** NETİCE OLARAK HESAP EKLEME DURUMUNA GÖRE KULLANICIYA AŞAĞIDAKİ MESAJLARDAN BİRİNİ GÖSTERİN... */



    }
    ///////////////////////////////////////////////////////////////////////////////////////////


    // PARA EKLE ( deposit() ) METODU  ///////////////////////////////////////////////////////
    public void depositToAccount(Customer customer) {
        System.out.println("\n----- PARA YATIR -----");
        System.out.print("Hesap Numarasını Girin: ");

        int hesapNo=scannerInt.nextInt();
        System.out.print("Tutar Giriniz :");
        int tutar=scannerInt.nextInt();
        if (tutar<=0){
            System.out.println("Geçersiz tutar işlem iptal edildi.");
        }else {
            boolean kontrol=true;
            for (Account each :accounts){
                if (each.getAccountId()==hesapNo){
                    each.setBalance(each.getBalance()+tutar);
                    kontrol=false;
                }
            }
            if (kontrol==true){
                System.out.println("Geçersiz Hesap Numarası veya hesap sizin değil! İşlem iptal edildi.");
            }else
                System.out.println("Paranız Yatırıldı...");
        }
        /** KULLANICIDAN HESAP NUMARASINI ALARAK GEREKLİ KONTROLLERİ GERÇEKLEŞTİRİN
         * YATIRILMAK İSTENEN TUTAR NEGETİF Mİ? POZİTİF Mİ?
         * BU KONTROLÜ, Accounts SINIFINDAN OLUŞTURDUĞUNUZ NESNENİN İÇİNDE depositToAmount(amount) GİBİ
         * BİR METOD TANIMLAYARAK ORADA DA GERÇEKLEŞTİREBİLİRSİNİZ...
         */

        /** accountId VASITASIYLA İSTENEN HESABA ULAŞILABİLİR... */
        /** KULLANICININ GİRDİĞİ HESAP NUMARASI İLGİLİ MÜŞTERİYE AİT Mİ DİYE KONTROL EDİLMELİDİR...*/
        /** KONTROL SONUCUNDA HESAP SINIFI NESNESİNDEN ULAŞTIĞINIZ MÜŞTERİ ID Sİ İLE MÜŞTERİ SINIFININ
         * NESNESİNDEN ULAŞACAĞINIZ MÜŞTERİ ID Sİ AYNI İSE, YATIRILACAK TUTARI KONSOLDA KULLANICIDAN ALIN,
         * VE HESAP SINIFINDAKİ depositToAmount(amount) VASITASIYLA PARAYI YATIRIN...*/

        /** AKSİ HALDE: KULLANICIYA "Geçersiz Hesap Numarası veya hesap sizin değil! İşlem iptal edildi."
         * MESAJI VERİN...
         */
    }
    ////////////////////////////////////////////////////////////////////////////////////////////


    // PARA ÇEK ( withdraw() ) METODU  /////////////////////////////////////////////////////////
    public void withdrawToAccount(Customer customer) {
        System.out.println("\n----- PARA ÇEK -----");
        System.out.print("Hesap Numarasını Girin: ");

        int hesapNo=scannerInt.nextInt();
        System.out.print("Tutar Giriniz :");
        int tutar=scannerInt.nextInt();
        if (tutar<=0){
            System.out.println("Geçersiz tutar işlem iptal edildi.");
        }else {
            boolean kontrol=true;
            for (Account each :accounts){
                if (each.getAccountId()==hesapNo){

                    if (each.getBalance()<tutar){
                        System.out.println("Yetersiz bakiye.");
                        kontrol=true;
                    }else {
                        each.setBalance(each.getBalance()-tutar);
                        kontrol=false;
                    }
                }
            }
            if (kontrol){
                System.out.println("Geçersiz Hesap Numarası veya hesap sizin değil! İşlem iptal edildi.");
            }else
                System.out.println("Paranız Çekildi...");
        }

        /** KULLANICIDAN HESAP NUMARASINI İSTEYEREK PARA ÇEKME İŞLEMİNİ GERÇEKLEŞTİRİN... */
        /** İLGİLİ HESAPTAN PARA ÇEKERKEN, Accounts SINIFINDAKİ withdrawToAmount() METODUNU KULLANIN */
        /** BU METOD VASITASIYLA TUTARIN NEGATİF OLMA DURUMU KONTROL EDİLEBİLİR... */
        /** YİNE BU METOD VASITASIYLA ÇEKİLMEK İSTENEN TUTAR BAKİYEDEN BÜYÜK MÜ DİYE KONTROL EDİLEBİLİR...*/

        /** accountId VASITASIYLA İSTENEN HESABA ULAŞILABİLİR... */
        /** KULLANICININ GİRDİĞİ HESAP NUMARASI İLGİLİ MÜŞTERİYE AİT Mİ DİYE KONTROL EDİLMELİDİR...*/
        /** KONTROL SONUCUNDA HESAP SINIFI NESNESİNDEN ULAŞTIĞINIZ MÜŞTERİ ID Sİ İLE MÜŞTERİ SINIFININ
         * NESNESİNDEN ULAŞACAĞINIZ MÜŞTERİ ID Sİ AYNI İSE, ÇEKİLECEK TUTARI KONSOLDA KULLANICIDAN ALIN,
         * VE HESAP SINIFINDAKİ withDrawToAmount(amount) VASITASIYLA PARAYI ÇEKİN...*/

        /** AKSİ HALDE: KULLANICIYA "Geçersiz Hesap Numarası veya hesap sizin değil! İşlem iptal edildi."
         * MESAJI VERİN...
         */
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////


    //  BAKİYE SORGULAMA İPUCU METODU ///////////////////////////////////////////////////////////////////
    public void checkBalance(Customer customer) {
        System.out.println("\n----- BAKİYE SORGULA -----");
        System.out.print("Hesap Numarasını Girin: ");
        int accountId = scannerInt.nextInt();
        scannerInt.nextLine();

        Account account = getAccountById(accountId);
        if (account != null && account.getCustomerId() == customer.getCustomerId()) {
            System.out.println("Güncel bakiye: " + account.getBalance() + " TL");
        } else {
            System.out.println("Geçersiz Hesap Numarası veya hesap sizin değil! İşlem iptal edildi.");
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////


    // İPUCU METODU ///////////////////////////////////////////////////////////////////////////////////
    // Bu metot, accounts listesinde belirli bir hesabı aramak için kullanılır.
    // Bu sayede, hesap işlemleri sırasında müşteriye ait doğru hesabın bulunması sağlanır.
    // Örneğin, para çekme ve yatırma işlemlerinde, belirli bir müşteriye ait olan hesap bilgilerine
    // doğru bir şekilde ulaşmak için bu metot kullanılır. Girilen accountId (hesap ID) 'sine
    // sahip bir hesap bulunmazsa, metot null değerini döndürür (return null)
    public Account getAccountById(int accountId) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        return null;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
}
