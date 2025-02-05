package com.schemefinder.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SchemeFinder {
	
	public static void main(String[] args) {

	 System.setProperty("webdriver.edge.driver", "C:\\Users\\micha\\OneDrive\\Desktop\\Project\\CITIZEN-SERVICES-PORTAL\\edgedriver_win64\\msedgedriver.exe");
     WebDriver driver = new EdgeDriver();

     try {
         // Open the website
         driver.get("https://www.myscheme.gov.in/find-scheme");
         
         // Wait for page to load (Add proper waits in real implementation)
         Thread.sleep(3000);
         
         // Find dropdowns and interact with them
         WebElement maleRadio = driver.findElement(By.id("answerMale"));
         maleRadio.click();
     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         driver.quit();
     }
 }
	
}
