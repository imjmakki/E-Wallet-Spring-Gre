package app.ewallet.ewallet.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name = "transaction")
@Data
@Where(clause = "status = 'ACTIVE'")
public class Transaction extends Persistence{

private static final long serialVersionUID = 6294283999475848390L;

    public enum Type {
        TOPUP, PAYMENT
    }

    @Column(length = 255)
    private String referenceId;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccount.class)
    private UserAccount userAccount;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(length = 255)
    private String description;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Type type;

    @JoinColumn(name = "topup_id")
    @OneToOne(targetEntity = TopUp.class)
    private TopUp topUp;

    @JoinColumn(name = "payment_id")
    @OneToOne(targetEntity = Payment.class)
    private Payment payment;

}
