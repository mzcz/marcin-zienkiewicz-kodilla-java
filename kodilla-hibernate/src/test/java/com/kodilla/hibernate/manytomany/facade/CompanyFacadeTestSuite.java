package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyFacadeTestSuite {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    CompanyFacade companyFacade;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testQueriesSearchEmployeesByLastName() {
        //Given
        CompanyDto softwareMachine = new CompanyDto("Software Machine");
        CompanyDto dataMaesters = new CompanyDto("Data Maesters");
        CompanyDto greyMatter = new CompanyDto("Grey Matter");
        CompanyDto dataCenter = new CompanyDto("DATACENTER");
        CompanyDto datenBank = new CompanyDto("DatenBank");

        companyDao.save(companyFacade.mapToCompany(softwareMachine));
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(companyFacade.mapToCompany(dataMaesters));
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(companyFacade.mapToCompany(greyMatter));
        int greyMatterId = greyMatter.getId();
        companyDao.save(companyFacade.mapToCompany(dataCenter));
        int dataCenterId = dataCenter.getId();
        companyDao.save(companyFacade.mapToCompany(datenBank));
        int datenBankId = datenBank.getId();

        //When
        List<CompanyDto> companyByName = companyFacade.getCompanies("DATA");

        //Then
        try {
            //Assert.assertEquals(3, companyByName.size());
            System.out.println(companyByName.size());
        } finally {
            //CleanUp
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
            companyDao.delete(dataCenterId);
            companyDao.delete(datenBankId);
        }
    }
}
