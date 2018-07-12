package com.example.demo;

import javax.persistence.*;

@Entity
public class Customers {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String FullName;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="company_id")
    //@JoinColumn(name ="companyid")
    private Company company;



    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
