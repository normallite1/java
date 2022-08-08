import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "currency")
public class Currency extends BaseEntity{

    private Integer usd;

    private Integer eur;

    private Integer uan;

    @OneToOne (mappedBy = "currencys")
    private Client client;


    public Currency(){}
    public Currency(Integer usd, Integer eur, Integer uan){
        this.usd = usd;
        this.eur = eur;
        this.uan = uan;
    }

}
