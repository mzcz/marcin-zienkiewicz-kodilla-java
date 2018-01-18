package com.kodilla.hibernate.manytomany.facade;


import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyFacade {

    @Autowired
    CompanyDtoDao companyDao;


    public Company mapToCompany(final CompanyDto companyDto){
        return new Company(
                companyDto.getName());
    }


    public List<CompanyDto> mapToCompanyDtoList (List<Company> companyList){
        return companyList.stream()
                .map(t -> new CompanyDto(t.getName()))
                .collect(Collectors.toList());
    }

    public List<CompanyDto> getCompanies(String name){
        return companyDao.retrieveCompanyByString(name);
    }
}
