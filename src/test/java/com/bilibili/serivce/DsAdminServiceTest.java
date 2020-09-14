package com.bilibili.serivce;

import com.bilibili.datasource.entites.DsAdmin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DsAdminServiceTest {
    @Autowired
    private DsAdminService dsAdminService;

    @Test
    public void method1() {
        DsAdmin dsAdmin = new DsAdmin();
        dsAdmin.setAdmin_account("admin");
        dsAdmin = dsAdminService.getDsAdminByLogin(dsAdmin);
        System.out.println(dsAdmin);
    }
    @Test
    public void getEmployeeAllTest(){
        System.out.println(dsAdminService.getDsAdminAll(1-1,10));
    }
}