package app.ewallet.ewallet.Entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name = "wallet")
@Data
@Where(clause = "status = 'ACTIVE")
public class Wallet extends Persistence{

private static final long serialVersionUID = -9018130641242873583L;

    @Column
    @NotNull
    private BigInteger balance;

    @JoinColumn(name = "user_id")
    @OneToOne(targetEntity = UserAccount.class, fetch = FetchType.LAZY)
    private UserAccount userAccount;

}
