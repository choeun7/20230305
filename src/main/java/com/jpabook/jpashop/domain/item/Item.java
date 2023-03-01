package com.jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   //전략을 부모 클래스에 잡아주어야 함.
                                                        //지금은 한 테이블에 때려박는 싱글 테이블 전략
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {
    @Id                 //Id : JPA가 관리할 객체를 의미
    @GeneratedValue     // GeneratedValue : 값을 자동으로 생성해주는 애노테이션
    @Column(name = "item_id") // PK : primary key     <-> FK : 관계 형성을 위한 컬럼
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

}
