package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;
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
public class FacadeTestSuite {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    Facade facade;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testQueriesSearchCompanyByPartialNameWithResults() {
        //Given
        CompanyDto softwareMachine = new CompanyDto("Software Machine");
        CompanyDto dataMaesters = new CompanyDto("Data Maesters");
        CompanyDto greyMatter = new CompanyDto("Grey Matter");
        CompanyDto dataCenter = new CompanyDto("DATACENTER");
        CompanyDto datenBank = new CompanyDto("DatenBank");

        companyDao.save(facade.mapToCompany(softwareMachine));
        //int softwareMachineId = companyFacade.mapToCompany(softwareMachine).getId(); tu nie chciał pobrac id
        companyDao.save(facade.mapToCompany(dataMaesters));
        //int dataMaestersId = dataMaesters.getId();
        companyDao.save(facade.mapToCompany(greyMatter));
        //int greyMatterId = greyMatter.getId();
        companyDao.save(facade.mapToCompany(dataCenter));
        //int dataCenterId = dataCenter.getId();
        companyDao.save(facade.mapToCompany(datenBank));
        //int datenBankId = datenBank.getId();

        //When
        int companySize = 0;
        try {
            companySize = facade.getCompanies("DAT");
        } catch (OrderProcessingException e) {
            //bussines exception - should be handled in real application
        } finally {

            //Then
            try {
                Assert.assertEquals(3, companySize);
            } finally {
                //CleanUp
                companyDao.deleteAll();
            }
        }
    }

    @Test
    public void testQueriesSearchCompanyByPartialNameWithNoResults() {
        //Given
        CompanyDto softwareMachine = new CompanyDto("Software Machine");
        CompanyDto dataMaesters = new CompanyDto("Data Maesters");
        CompanyDto greyMatter = new CompanyDto("Grey Matter");
        CompanyDto dataCenter = new CompanyDto("DATACENTER");
        CompanyDto datenBank = new CompanyDto("DatenBank");

        companyDao.save(facade.mapToCompany(softwareMachine));
        companyDao.save(facade.mapToCompany(dataMaesters));
        companyDao.save(facade.mapToCompany(greyMatter));
        companyDao.save(facade.mapToCompany(dataCenter));
        companyDao.save(facade.mapToCompany(datenBank));

        //When
        int companySize = 0;
        try {
            companySize = facade.getCompanies("smart");
        } catch (OrderProcessingException e) {
            //bussines exception - should be handled in real application
        } finally {

            //Then
            try {
                Assert.assertEquals(0, companySize);
            } finally {
                //CleanUp
                companyDao.deleteAll();
            }
        }
    }

    @Test
    public void testQueriesSearchEmployeesByPartialLastNameWithResult() {
        //Given
        EmployeeDto johnSmith = new EmployeeDto("John", "Smith");
        EmployeeDto stephanieClarckson = new EmployeeDto("Stephanie", "Clarckson");
        EmployeeDto lindaSmith = new EmployeeDto("Linda", "Schmith");

        employeeDao.save(facade.mapToEmployee(johnSmith));
        //int id1 = johnSmith.getId();
        employeeDao.save(facade.mapToEmployee(stephanieClarckson));
        //int id2 = stephanieClarckson.getId();
        employeeDao.save(facade.mapToEmployee(lindaSmith));
        //int id3 = lindaSmith.getId();

        //When
        int employeeByLastNameSize = 0;
        try {
            employeeByLastNameSize = facade.getEmployees("mit");
        } catch (OrderProcessingException e) {
            //bussines exception - should be handled in real application
        }

        //Then
        try {
            Assert.assertEquals(2, employeeByLastNameSize);
        } finally {
            //CleanUp
            employeeDao.deleteAll();
        }

    }

    @Test
    public void testQueriesSearchEmployeesByPartialLastNameWithNoResult() {
        //Given
        EmployeeDto johnSmith = new EmployeeDto("John", "Smith");
        EmployeeDto stephanieClarckson = new EmployeeDto("Stephanie", "Clarckson");
        EmployeeDto lindaSmith = new EmployeeDto("Linda", "Schmith");

        employeeDao.save(facade.mapToEmployee(johnSmith));
        //int id1 = johnSmith.getId();
        employeeDao.save(facade.mapToEmployee(stephanieClarckson));
        //int id2 = stephanieClarckson.getId();
        employeeDao.save(facade.mapToEmployee(lindaSmith));
        //int id3 = lindaSmith.getId();

        //When
        int employeeByLastNameSize = 0;
        try {
            employeeByLastNameSize = facade.getEmployees("kowal");
        } catch (OrderProcessingException e) {
            //bussines exception - should be handled in real application
        }

        //Then
        try {
            Assert.assertEquals(0, employeeByLastNameSize);
        } finally {
            //CleanUp
            employeeDao.deleteAll();
        }

    }
}
