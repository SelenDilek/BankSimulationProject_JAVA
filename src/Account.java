public class Account {

    // FIELDS   /////////////////////////////////////////////////////////////
    private int accountId;
    private int customerId;
    private double balance;
    private AccountType accountType;

    private static int sayacAccount = 9000;

    public Account() {
    }

    public Account(int customerId, AccountType accountType) {
        setAccountId(sayacAccount++);
        setCustomerId(customerId);
        setAccountType(accountType);
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }


    public void depositToAmount(double amount) {

        /** BU METODU BankSimulation SINIFINDAKİ depositToAccount() METODUNDA DİREKT ÇAĞIRARAK KULLANIN*/
        /** YATIRILMAK İSTENEN TUTAR, SIFIRDAN BÜYÜK MÜ DEĞİL Mİ KONTROL EDİN*/
        /** BÜYÜKSE BAKİYEYE İLAVE EDİP KULLANICIYA MESAJ VERİN*/
        /** YATIRILMAK İSTENEN TUTAR SIFIRDAN KÜÇÜKSE KULLANICIYA MESAJ VERİN, YENİDEN DENEMESİNİ İSTEYİN...*/
    }

    public void withdrawToAmount(double amount) {

        /** BU METODU BankSimulation SINIFINDAKİ withdrawToAccount() METODUNDA DİREKT ÇAĞIRARAK KULLANIN*/
        /** ÇEKİLMEK İSTENEN TUTAR, NEGATİF Mİ, DEĞİL Mİ KONTROL EDİN*/
        /** ÇEKİLMEK İSTENEN TUTAR BAKİYEDEN BÜYÜK MÜ, DEĞİL Mİ KONTROL EDİN    */
        /** ÇEKİLMEK İSTENEN TUTAR (amount) POZİTİFSE VE BAKİYEDEN KÜÇÜKSE, BAKİYEDEN DÜŞÜP,
         * YENİ BAKİYEYİ KULLANICIYA BİLDİRİN... */
        /** YATIRILMAK İSTENEN TUTAR SIFIRDAN KÜÇÜKSE YA DA BAKİYEDEN BÜYÜKSE,
         * KULLANICIYA MESAJ VERİN, YENİDEN DENEMESİNİ İSTEYİN...*/
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", customerId=" + customerId +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }
}
