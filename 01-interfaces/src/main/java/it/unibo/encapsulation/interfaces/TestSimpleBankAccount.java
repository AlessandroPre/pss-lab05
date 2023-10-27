package it.unibo.encapsulation.interfaces;

public class TestSimpleBankAccount {

    private TestSimpleBankAccount() {
        /*
         * Prevents object creation from the outside.
         */
    }

    public static void main(final String[] args) {

        // 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1

        final AccountHolder aRossi = new AccountHolder("Andrea", "Rossi", 1);
        // 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2

        final AccountHolder aBianchi = new AccountHolder("Alex", "Bianchi", 2);
        // 3) Creare i due SimpleBankAccount corrispondenti
        
        final SimpleBankAccount rossisAccount = new SimpleBankAccount(aRossi.getUserID(), 0);
        final SimpleBankAccount bianchisAccount = new SimpleBankAccount(aBianchi.getUserID(), 0);

        // 4) Effettuare una serie di depositi e prelievi

        rossisAccount.deposit(1, 100);
        bianchisAccount.deposit(1, 100);
        bianchisAccount.withdrawFromATM(2, 200);
        bianchisAccount.deposit(2, 1500);
        rossisAccount.withdraw(1, 500);
        rossisAccount.depositFromATM(1, 200);

        /*
         * 5) Stampare a video l'ammontare dei due conti e verificare la
         * correttezza del risultato
         */

        System.out.println(rossisAccount.getBalance());
        System.out.println(bianchisAccount.getBalance());

        // 6) Provare a prelevare fornendo un id utente sbagliato

        rossisAccount.withdraw(0, 500);

        // 7) Controllare nuovamente l'ammontare
        
        System.out.println(rossisAccount.getBalance());

    }
}
