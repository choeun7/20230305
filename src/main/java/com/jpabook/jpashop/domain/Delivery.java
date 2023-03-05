package com.jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)   //1대1 매핑
                //1대1일때는 보통 조회를 더 많이 하는 곳에 FK를 넣는다.
                //여기서는 Order에 놓는다. 둘 다 상관없긴함
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)      //Ordinal은 디폴트가 숫자이므로 status가 추가되면 밀리게 됨. 절대 사용 비추천. String 사용 추천
    private DeliveryStatus status;  //READY, COMP
}
