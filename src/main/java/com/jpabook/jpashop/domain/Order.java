package com.jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")      //보통 테이블명_id로 해줌
    private Long id;

    @ManyToOne          //오더랑 멤버는 다대일 관계, 멤버의 입장에선 하나의 회원이 여러 주문을 하기 때문에 일대다 관계
    @JoinColumn(name = "member_id") //매핑은 member_id로 FK를 설정
                                    //FK를 가진 Order의 member를 연관관계의 주인으로 지정
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private Date date;

    private LocalDateTime orderDate;    //주문 시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문상태 [ORDER, CANCEL]
}
