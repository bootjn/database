package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    private String companyID;

    private String Company;


    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Customers> customerses;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public String getCompanyID() {
//        return companyID;
//    }
//
//    public void setCompanyID(String companyID) {
//        this.companyID = companyID;
//    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public Set<Customers> getCustomerses() {
        return customerses;
    }

    public void setCustomerses(Set<Customers> customerses) {
        this.customerses = customerses;
    }
}
