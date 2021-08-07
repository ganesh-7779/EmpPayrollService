package com.bridgelabz;

import exception.EmpPayrollValidation;
import org.junit.Before;
import org.junit.Test;
import service.EmpPayrollService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmpPayrollServiceTest {
    EmpPayrollService employeePayrollService;

    @Before
    public void setup(){
        employeePayrollService = new EmpPayrollService();
    }

    @Test
    public void listFilesAndDirectories_shouldReturnFilesCount_whenPathIsProvided() throws EmpPayrollValidation {
        int result = employeePayrollService.listFileAndDirectories("D:\\BridgeLabs Training\\demo");
        assertEquals(3,result);
    }

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {

        //check file exists
        Path playPath = Paths.get("D:\\BridgeLabs Training\\demo2");
        assertTrue(Files.exists(playPath));

        //Delete file and check file not exists
        if (Files.exists(playPath))
            employeePayrollService.deleteFile(playPath.toFile());
        assertTrue(Files.notExists(playPath));

        // Create Directory
        Files.createDirectory (playPath);
        assertTrue (Files.exists(playPath));

        // Create File
        IntStream.range(1, 10).forEach(cntr -> {
            Path tempFile = Paths.get(playPath + "/temp" + cntr);
            assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) { }
            assertTrue(Files.exists(tempFile));
        });
    }
}
