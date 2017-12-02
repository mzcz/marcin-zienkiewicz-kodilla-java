package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import com.kodilla.hibernate.manytomany.dao.InvoiceDao;
import com.kodilla.hibernate.manytomany.dao.ItemDao;
import com.kodilla.hibernate.manytomany.dao.ProductDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave(){
        //Given
        Invoice invoice = new Invoice("FV 02/12/17");

        Product product1 = new Product("milk");
        Product product2 = new Product("cheese");
        Product product3 = new Product("water");
        Product product4 = new Product("butter");


        Item item1 = new Item (new BigDecimal(6.50), 2);
        Item item2 = new Item (new BigDecimal(5.50), 1);
        Item item3 = new Item (new BigDecimal(1.50), 3);
        Item item4 = new Item (new BigDecimal(5.50), 4);
        Item item5 = new Item (new BigDecimal(1.50), 1);

        //product.getItems().add(item1);
        //product.getItems().add(item2);

        //invoice.getItems().add(item1);
        //invoice.getItems().add(item2);
        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product3);
        item4.setProduct(product4);
        item5.setProduct(product3);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);
        item5.setInvoice(invoice);


        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        productDao.save(product1);
        int idProduct1 = product1.getId();
        productDao.save(product2);
        int idProduct2 = product2.getId();
        productDao.save(product3);
        int idProduct3 = product3.getId();
        productDao.save(product4);
        int idProduct4 = product4.getId();

        itemDao.save(item1);
        itemDao.save(item2);
        itemDao.save(item3);
        itemDao.save(item4);
        itemDao.save(item5);

        //Then
        Assert.assertNotEquals(0, invoiceId);

        //CleanUp
        try {
            invoiceDao.delete(invoiceId);

            productDao.delete(idProduct1);
            productDao.delete(idProduct2);
            productDao.delete(idProduct3);
            productDao.delete(idProduct4);

        } catch (Exception e) {
            //do nothing
        }


    }
}
