package com.mariela.store.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseEntity implements Serializable {

    protected static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    protected Date createAt;

    @Column(name = "update_at")
    @Temporal(TemporalType.DATE)
    protected Date updateAt;

    @Column(name = "is_enabled")
    protected boolean isEnabled;

    public BaseEntity(Long id){
        this.id = id;
    }

    @PrePersist
    public void defaultValues(){
        this.isEnabled = true;
        this.createAt = new Date();
        this.updateAt = new Date();
    }
}
