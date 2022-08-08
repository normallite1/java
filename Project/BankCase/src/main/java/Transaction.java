import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "transaction1")
public class Transaction extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private Integer fromCurrency;

    private Integer toCurrency;
    private Integer transfer;


    public Transaction(){}
    public Transaction(Integer transfer){
        this.transfer = transfer;
    }

}
