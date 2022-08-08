import  javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;


public class AbstractDao {
     static EntityManagerFactory  emFactory;
     static EntityManager em;

    public AbstractDao(EntityManagerFactory emFactory, EntityManager em){
        AbstractDao.emFactory = emFactory;
        AbstractDao.em = em;
    }

   public static void addNewClient(Scanner scanner) {
       System.out.println("Press name");
        String name = scanner.nextLine();
        Client client = new Client(name);

        System.out.println("Do you want top up your account?");
        System.out.println("Press '1' Yes");
        System.out.println("Press '2' No");
        String question = scanner.nextLine();
        Currency currency = new Currency(0,0,0);
        switch (question){
            case "1" :
                System.out.println("Select an currency");
                System.out.println("Press 1 USD");
                System.out.println("Press 2 EUR");
                System.out.println("Press 3 UAN");
                String question2 = scanner.nextLine();
                switch (question2) {
                    case "1" :
                        System.out.println("Enter amount");
                        String amount = scanner.nextLine();
                        Integer setAmount = Integer.parseInt(amount);
                        currency.setUsd(setAmount);
                        break;

                    case "2" :
                        System.out.println("Enter amount");
                        String amount2 = scanner.nextLine();
                        Integer setAmount2 = Integer.parseInt(amount2);
                        currency.setEur(setAmount2);
                        break;

                    case "3" :
                        System.out.println("Enter amount");
                        String amount3 = scanner.nextLine();
                        Integer setAmount3 = Integer.parseInt(amount3);
                        currency.setUan(setAmount3);
                    break;
                }
                break;
            case "2" :
                System.out.println("Нищеброд");
                break;
        }

         em.getTransaction().begin();
        try {

            client.setCurrencys(currency);
            em.persist(client);
            em.getTransaction().commit();

        } catch (RuntimeException ex) {
            em.getTransaction().rollback();
            throw new RuntimeException(ex);
        }
    }
    public static void transactions(Scanner scanner) {
        System.out.println("Press ID Client");
        String string = scanner.nextLine();
        int setID = Integer.parseInt(string);
        Client client = em.find(Client.class, setID);
        Currency currencys = client.getCurrencys();
        Transaction transaction = new Transaction();
        ExchangeRates er = new ExchangeRates();
        System.out.println("Введите счет с которого снять средсва");
        System.out.println("1 USD");
        System.out.println("2 EUR");
        String switc = scanner.nextLine();
        switch (switc) {
            case "1":
                System.out.println("Ведите суму перевода");
                int withdrawalUsd = scanner.nextInt();
                if (currencys.getUsd() > 0) {
                    transaction.setFromCurrency(currencys.getUsd() - withdrawalUsd);
                    transaction.setToCurrency(currencys.getUan() + (withdrawalUsd * er.getRatesUSD()));
                    currencys.setUsd(transaction.getFromCurrency());
                    currencys.setUan(transaction.getToCurrency());
                } else {
                    System.out.println("Недостаточно средств");
                }
                break;
            case "2":
                System.out.println("Ведите суму перевода");
                int withdrawalEur = scanner.nextInt();
                if (currencys.getUsd() > 0) {
                    transaction.setFromCurrency(currencys.getUsd() - withdrawalEur);
                    transaction.setToCurrency(currencys.getUan() + (withdrawalEur * er.getRatesEUR()));

                } else {
                    System.out.println("Недостаточно средств");

                }
                break;
        }
        em.getTransaction().begin();
       try {

           client.addTransactions(transaction);
           em.merge(currencys);
           em.persist(transaction);
           em.getTransaction().commit();

       } catch (RuntimeException ex) {
           em.getTransaction().rollback();
           throw new RuntimeException(ex);
       }
    }
}

