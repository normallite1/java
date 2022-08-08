import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table (name = "client1")
public class Client extends BaseEntity {

    private String name;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id")
    private Currency currencys;

    @OneToMany (mappedBy = "client", cascade = CascadeType.ALL)
    private List<Transaction>  transactions = new ArrayList<>();

    public void addTransactions(Transaction transaction){
        if(!transactions.contains(transaction)){
            transactions.add(transaction);
            transaction.setClient(this);
        }
    }
    public Client(){}
    public Client(String name){
        this.name = name;
    }

    }

