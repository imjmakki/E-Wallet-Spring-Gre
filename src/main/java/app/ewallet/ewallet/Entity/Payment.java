package app.ewallet.ewallet.Entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name = "payment")
@Data
@Where(clause = "status = 'ACTIVE'")
public class Payment extends Persistence{

private static final long serialVersionUID = -4692510340887664687L;

    private BigInteger creditWallet;

    private BigInteger debitWallet;

}
