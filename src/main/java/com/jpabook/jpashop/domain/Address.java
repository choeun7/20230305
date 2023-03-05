package com.jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable     //어딘가에 내장될 수 있다는 의미
@Getter // 값 타입은 변경 불가능해야하기 때문에 Setter 제거
public class Address {

    private String city;
    private String street;
    private String zipcode;

    //JPA 스펙상 엔티티나 임베디드 타입은 자바 기본 생성자를 public이나 protected로 설정해야 한다.
    protected Address() {
    }

    //생성자에서 값을 모두 초기화해서 변경 불가능한 클래스를 만들자
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
