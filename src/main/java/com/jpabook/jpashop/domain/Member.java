package com.jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity     // JPA가 관리할 객체를 의미
@Getter @Setter
public class Member {
    @Id                 //Id : JPA가 관리할 객체를 의미
    @GeneratedValue     // GeneratedValue : 값을 자동으로 생성해주는 애노테이션
    @Column(name = "member_id") // PK : primary key     <-> FK : 관계 형성을 위한 컬럼
    private Long id;

    private String username;

    @Embedded   //내장타입을 포함했다는 어노테이션, Embedded나 Embeddable 둘 중 하나만 써도 되지만, 가독성을 위해 둘 다 써줌
    private Address address;

    @OneToMany(mappedBy = "member")     //연관관계의 주인이 아닐 땐 mappedBy, 매핑된 거울이라는 의미
                                        //여기에 값을 넣는다고 FK가 변경되지 X
    private List<Order> orders = new ArrayList<>();
}