package it.unibo.encapsulation.interfaces;

public class TestSimpleBankAccount {

    private TestSimpleBankAccount() {
        /*
         * Prevents object creation from the outside.
         */
    }

    public static void main(final String[] args) {

        // 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1

        AccountHolder ah1 = new AccountHolder("Andrea", "Rossi", 1);
        // 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2

        AccountHolder ah2 = new AccountHolder("Alex", "Bianchi", 12);
        // 3) Creare i due SimpleBankAccount corrispondenti
        
        SimpleBankAccount sb1 = new SimpleBankAccount(1, 0);
        SimpleBankAccount sb2 = new SimpleBankAccount(2, 0);

        // 4) Effettuare una serie di depositi e prelievi

        sb1.deposit(1, 100);
        sb2.deposit(1, 100);
        sb2.withdrawFromATM(2, 200);
        sb2.deposit(2, 1500);
        sb1.withdraw(1, 500);
        sb1.depositFromATM(1, 200);

        /*
         * 5) Stampare a video l'ammontare dei due conti e verificare la
         * correttezza del risultato
         */

        System.out.println(sb1.getBalance());
        System.out.println(sb2.getBalance());

        // 6) Provare a prelevare fornendo un id utente sbagliato

        sb1.withdraw(0, 500);

        // 7) Controllare nuovamente l'ammontare
        
        System.out.println(sb1.getBalance());

    }
}
