package com.bridgelabz;

import org.junit.Before;
import service.EmpPayrollService;

public class EmpPayrollServiceTest {
    EmpPayrollService employeePayrollService;

    @Before
    public void setup(){
        employeePayrollService = new EmpPayrollService();
    }

}
