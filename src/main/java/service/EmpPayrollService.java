/*******************************************************
 * Purpose : Read and write employee payroll data to a file
 * @author Ganesh Gavhd
 * @Version 1.0
 * @since 06-08-2021
 *
 ******************************************************/
package service;

import exception.EmpPayrollValidation;
import model.EmployeePayrollData;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmpPayrollService {
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();


    /**
     * Takes employee details i.e id,name and salary from console.
     * Stores the EmployeeData object in arraylist.
     * Catches exception if user enters details which do not match their type.
     * Use of do while loop to let user enter details again if there occurs any
     * exception in earlier entry.
     */
    public void readFromConsole() {
        boolean runcheck = true;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter Employee Id");
                int id = scanner.nextInt();
                System.out.println("Enter Employee Name");
                String name = scanner.next();
                System.out.println("Enter employee Salary");
                double salary = scanner.nextDouble();
                EmployeePayrollData employee = new EmployeePayrollData(id, name, salary);
                employeePayrollList.add(employee);
                runcheck = false;
            } catch (Exception e) {
                System.err.println("Invalid entry ,enter again");
            }
        } while (runcheck);
    }

    /**
     * Prints employee details on console.
     */
    public void writeToConsole() {
        System.out.println(employeePayrollList);
    }

    /**
     * Method for deleting file form directory.
     *
     * @param contentToDelete :
     * @return : tru or false
     */
    public boolean deleteFile(File contentToDelete) {
        File[] allContent = contentToDelete.listFiles();
        if (allContent != null)
            for (File file : allContent) {
                deleteFile(file);
            }
        return contentToDelete.delete();
    }

    /**
     * Method for delete files recursively  from a directory.
     *
     * @param address : directory path
     * @return : true or false
     */
    public boolean deleteFilesRecursively(String address) {
        Path playPath = Paths.get(address);
        if (Files.exists(playPath))
            deleteFile(playPath.toFile());
        return Files.notExists(playPath);
    }

    /**
     * Method for checking if file of directory and file is exists or not.
     *
     * @return : true or false
     */
    public boolean isExists(String address) {
        Path homePath = Paths.get(address);
        if (Files.exists(homePath)) {
            System.out.println(homePath + " Path is Exists");
        }
        return Files.exists(homePath);
    }

    /**
     * Method for creating directory.
     *
     * @param address : path wtth directory name
     * @return : true or false
     * @throws IOException
     */
    public boolean createDirectory(String address) throws IOException {
        Path playPath = Paths.get(address);
        //create directory
        Files.createDirectory(playPath);
        if (Files.exists(playPath))
            System.out.println(playPath + "Is Created");
        return Files.exists(playPath);
    }

    /**
     * Method for creating file in a particular directory.
     *
     * @param address  : path of directory
     * @param fileName : file name
     * @return : true or false
     * @throws EmpPayrollValidation
     */
    public boolean createFile(String address, String fileName) throws EmpPayrollValidation {
        Path tempFile = Paths.get(address + "/" + fileName);
        try {
            Files.createFile(tempFile);
            System.out.println(tempFile);
        } catch (IOException e) {
            throw new EmpPayrollValidation(e.getMessage());
        }
        return Files.exists(tempFile);
    }

    /**
     * Method for find out the total files and folder at a particular directory.
     *
     * @param path : path for a directory
     * @return : count of file and folders exists.
     * @throws EmpPayrollValidation
     */
    public int listFileAndDirectories(String path) throws EmpPayrollValidation {
        Path playPath = Paths.get(path);
        try {
            List<Path> elementsList = Files.list(playPath).filter(Files::isRegularFile).collect(Collectors.toList());
            elementsList.stream().forEach(e -> System.out.println(e));
            return elementsList.size();
        } catch (Exception e) {
            throw new EmpPayrollValidation(e.getMessage());
        }
    }

    /**
     * Purpose : Writes Arraylist employeePayrollList to file output.txt
     */
    public void writeToFile() {
        try {
            FileOutputStream writeData = new FileOutputStream("Output.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(employeePayrollList);
            writeStream.flush();
            writeStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try {
            FileInputStream readData = new FileInputStream("Input.txt");
            ObjectInputStream ObjectStream = new ObjectInputStream(readData);
            ArrayList<EmployeePayrollData> newList = (ArrayList<EmployeePayrollData>) ObjectStream.readObject();
            ObjectStream.close();
            System.out.println(newList);
            System.out.println("Number Of entries :" + newList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


