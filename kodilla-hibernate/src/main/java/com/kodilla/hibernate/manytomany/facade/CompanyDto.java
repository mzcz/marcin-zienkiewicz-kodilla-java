package com.kodilla.hibernate.manytomany.facade;

import javax.persistence.NamedNativeQuery;

@NamedNativeQuery(
        name = "CompanyDto.retrieveCompanyByString",
        query = "SELECT COMPANY_NAME FROM COMPANIES" +
                "WHERE COMPANY_NAME LIKE UPPER(%:NAME%)",
        resultClass = CompanyDto.class
)
public class CompanyDto {

    private int id;
    private String name;

    public CompanyDto(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
