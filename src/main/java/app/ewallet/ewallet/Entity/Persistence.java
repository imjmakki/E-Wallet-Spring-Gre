package app.ewallet.ewallet.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@MappedSuperclass
@Data
public class Persistence implements Serializable {
private static final long serialVersionUID = 6237626800965600662L;

    public enum Status {
        ACTIVE, NOT_ACTIVE
    }

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private String id;

    @Column(length = 50)
    @CreatedBy
    private String createdBy;

    @Column
    @LastModifiedBy
    private String updateBy;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdTime;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateTIme;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private Status status;

    @PrePersist
    public void prePersist() {
        setCreatedTime(new Date());
        setUpdateTIme(new Date());
        setStatus(Status.ACTIVE);
        setCreatedBy("system");
    }

    @PreUpdate
    public void preUpdate() {
        setUpdateTIme(new Date());
        setUpdateBy("system");
    }
}
