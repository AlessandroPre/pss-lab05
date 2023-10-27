package it.unibo.encapsulation.interfaces;

public class StrictBankAccount implements BankAccount {

    private final int id;
    private double balance;
    private int transactions;
    private final static double ATM_TRANSACTION_FEE = 1;
    private final static int MANAGEMENT_FEE = 5;
    private final static float N_TRANSACTIONS_FEE = 0.1f;

    public StrictBankAccount(final int id, final double balance) {
        this.id = id;
        this.balance = balance;  
        this.transactions = 0;     
    }
    
    public void deposit(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e aggiunge amount al totale del
         * conto Nota: il deposito va a buon fine solo se l'id utente
         * corrisponde
         */
        if(id == this.id){
            this.transactions += 1;
            this.balance += amount;
        }
        else{
           System.out.println("Deposito non riuscito"); 
        }
    }

    public void withdraw(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e rimuove amount al totale del
         * conto. Note: - Il conto puo' andare in rosso (ammontare negativo) -
         * Il prelievo va a buon fine solo se l'id utente corrisponde
         */
        if(id == this.id && checkBalance(amount)){
            this.transactions += 1;
            this.balance -= amount;
        }
        else{
           System.out.println("Prelievo non riuscito"); 
        }
    }

    public void depositFromATM(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e aggiunge amount al totale del
         * conto detraendo le spese (costante ATM_TRANSACTION_FEE) relative
         * all'uso dell'ATM (bancomat) Nota: il deposito va a buon fine solo se
         * l'id utente corrisponde
         */
        if(id == this.id){
            this.transactions += 1;
            this.balance += amount - ATM_TRANSACTION_FEE;
        }
        else{
           System.out.println("Deposito non riuscito"); 
        }
    }

    public void withdrawFromATM(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e rimuove amount + le spese
         * (costante ATM_TRANSACTION_FEE) relative all'uso dell'ATM (bancomat)
         * al totale del conto. Note: - Il conto puo' andare in rosso (ammontare
         * negativo) - Il prelievo va a buon fine solo se l'id utente
         * corrisponde
         */
        if(id == this.id && checkBalance(amount)){
            this.transactions += 1;
            this.balance -= amount - ATM_TRANSACTION_FEE;
        }
        else{
           System.out.println("Prelievo non riuscito"); 
        }
    }

    public void chargeManagementFees(final int id) {
        /*
         * Riduce il bilancio del conto di un ammontare pari alle spese di gestione
         */
        this.balance 
    }

    /*
     * This method is used to charge the management fees on the account balance
     * (they are computed every few months). This method does not return the amount
     * computed, it directly collects the amount from the balance.
     */

    public double getBalance(){
        return this.balance;
    }

    public int getTransactionsCount(){
        return this.transactions;
    }

    private boolean checkBalance(final double amount){
        return this.balance >= amount;
    }
} 
