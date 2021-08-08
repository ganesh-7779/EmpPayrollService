/***************************************************************
 * Purpose : POJO for EmployeeData object. Contains employee Id,
 *           employee name and employee salary.
 * @author Ganesh Gavhad
 * @Version 1.0
 * @since 06-08-2021
 *
 ***************************************************************/
package model;

import java.io.Serializable;

public class EmployeePayrollData implements Serializable {
    public int id;
    public String name;
    public double salary;

    public EmployeePayrollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
