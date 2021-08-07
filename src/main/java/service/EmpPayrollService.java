/*******************************************************
 * Purpose : Read and write employee payroll data to a file
 * @author Ganesh Gavhd
 * @Version 1.0
 * @since 06-08-2021
 *
 ******************************************************/
package service;

import model.EmployeePayrollData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpPayrollService {
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();


    /**
     * Takes employee details i.e id,name and salary from console.
     * Stores the EmployeeData object in arraylist.
     * Catches exception if user enters details which do not match their type.
     * Use of do while loop to let user enter details again if there occurs any
     * exception in earlier entry.
     */
    public void readFromConsole(){
        boolean runcheck=true;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter Employee Id");
                int id = scanner.nextInt();
                System.out.println("Enter Employee Name");
                String name = scanner.next();
                System.out.println("Enter employee Salary");
                double salary = scanner.nextDouble();
                EmployeePayrollData employee = new EmployeePayrollData(id,name,salary);
                employeePayrollList.add(employee);
                runcheck = false;
            }
            catch (Exception e) {
                System.err.println("Invalid entry ,enter again");
            }
        }while(runcheck);
    }

    /**
     * Prints employee details on console.
     */
    public void writeToConsole() {
        System.out.println(employeePayrollList);
    }
}
