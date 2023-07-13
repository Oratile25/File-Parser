package com.eviro.assessment.grad001.oratilemasipa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class AccountProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountHolderName;
    private String accountHolderSurname;
    private String httpImageLink;

    public AccountProfile() {

    }

    public AccountProfile(String accountHolderName, String accountHolderSurname, String httpImageLink) {
        this.accountHolderName = accountHolderName;
        this.accountHolderSurname = accountHolderSurname;
        this.httpImageLink = httpImageLink;
    }

    //Getters and Setters methods
    public Long getId(){
        return id;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountHolderSurname() {
        return accountHolderSurname;
    }
    public void setAccountHolderSurname(String accountHolderSurname) {
        this.accountHolderSurname = accountHolderSurname;
    }

    public String getHttpImageLink() {
        return httpImageLink;
    }
    public void setHttpImageLink(String httpImageLink) {
        this.httpImageLink = httpImageLink;
    }
}
