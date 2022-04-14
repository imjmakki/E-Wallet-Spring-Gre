package app.ewallet.ewallet.Entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name = "topup")
@Data
@Where(clause = "status = 'ACTIVE'")
public class TopUp extends Persistence{/**
 *
 */
private static final long serialVersionUID = -7068175314777745920L;

    @Column
    @NotNull
    private BigInteger creditWallet;
}
