import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "exchangeRates1")
public class ExchangeRates extends BaseEntity {

    private Integer ratesUSD = 35;
    private Integer ratesEUR = 38;
    private Integer ratesUAN = 1;



    public ExchangeRates(){

    }
    public ExchangeRates(Integer ratesUSD, Integer ratesEUR, Integer ratesUAN){
        this.ratesUSD = ratesUSD;
        this.ratesEUR = ratesEUR;
        this.ratesUAN = ratesUAN;
    }


}
