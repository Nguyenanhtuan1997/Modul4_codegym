package com.de_thi_modul4.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Tuors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  title;
    private int price;
    private String description;
}
