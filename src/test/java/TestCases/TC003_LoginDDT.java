package TestCases;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Accountloginpage;
import PageObjects.HomePage;
import PageObjects.MyAccountPage;
import Testbase.BaseClass;
import Utilites.DataProviders;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TC003_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "datadriven")
    public void Verify_loginDDT(String email, String pswd, String exp) {
        String actualResult = null;

        try {
            // HomePage
            HomePage hp = new HomePage(driver);
            hp.MyAccount();
            hp.login();

            // Loginpage
            Accountloginpage lp = new Accountloginpage(driver);
            lp.Enteremail(email);
            lp.Enterpassword(pswd);
            lp.clicksubmit();

            // MyAccountPage
            MyAccountPage mc = new MyAccountPage(driver);
            boolean targetPage = mc.isAccountpageExits();

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage == true) {
                    mc.clickLogout();
                    actualResult = "Login Successful";
                    Assert.assertTrue(true);
                } else {
                    actualResult = "Login Failed";
                    Assert.assertTrue(false);
                }
            }

            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage == true) {
                    mc.clickLogout();
                    actualResult = "Login Failed - Shouldn't allow";
                    Assert.assertTrue(false);
                } else {
                    actualResult = "Login Unsuccessful - As Expected";
                    Assert.assertTrue(true);
                }
            }

        } catch (Exception e) {
            actualResult = "Test Execution Error";
            Assert.fail();
        } finally {
            // Save the result to Excel
            try {
                writeResultToExcel(email, pswd, exp, actualResult);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeResultToExcel(String email, String pswd, String exp, String actualResult) throws IOException {
        String filePath = System.getProperty("user.dir") + "/TestData/LoginResults.xlsx";
        File file = new File(filePath);

        Workbook workbook;
        Sheet sheet;

        // Check if file already exists, if not create a new one
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("Results");

            if (sheet == null) {
                sheet = workbook.createSheet("Results");
                createHeaderRow(sheet);
            }

            fis.close();
        } else {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Results");
            createHeaderRow(sheet);
        }

        // Find the next empty row
        int rowCount = sheet.getLastRowNum();

        Row row = sheet.createRow(rowCount + 1);
        row.createCell(0).setCellValue(email);
        row.createCell(1).setCellValue(pswd);
        row.createCell(2).setCellValue(exp);
        row.createCell(3).setCellValue(actualResult);

        // Write to file
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        workbook.close();
        fos.close();
    }

    private void createHeaderRow(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Email");
        headerRow.createCell(1).setCellValue("Password");
        headerRow.createCell(2).setCellValue("Expected Result");
        headerRow.createCell(3).setCellValue("Actual Result");
    }
}
