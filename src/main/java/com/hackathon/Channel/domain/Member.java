package com.hackathon.Channel.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Component
@Getter
@Setter
@DynamicUpdate
public class Member {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    public Member() {

    }
    public Member(String name) {
        this.name = name;
    }
}
