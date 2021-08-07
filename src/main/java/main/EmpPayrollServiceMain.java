/*******************************************************
 * Purpose : To run employee payroll service
 * @author Ganesh Gavhad
 * @Version 1.0
 * @since 6-08-2021
 *
 ******************************************************/
package main;

import service.EmpPayrollService;
import java.io.IOException;
import java.util.Scanner;

public class EmpPayrollServiceMain {
    public static void main( String[] args ) throws IOException
    {
        EmpPayrollService empservice = new EmpPayrollService();
        Scanner sc = new Scanner(System.in);
        boolean isExit = false;
        while(!isExit) {
            System.out.print("Enter options\n1.ReadFromConsole\n2.PrintOnConsole\n3.Exit");
            int choice =sc.nextInt();
            switch(choice) {
                case 1:
                    empservice.readFromConsole();
                    break;
                case 2:
                    empservice.writeToConsole();
                    break;
                case 3:
                    isExit = true;
                    break;
                default :
                    System.err.println("Invalid input");
            }
        }
    }
}
