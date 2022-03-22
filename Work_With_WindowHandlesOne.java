package com.selenium.org;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Work_With_WindowHandlesOne {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", 
				"C:\\\\ChromeWebDriverforSelenuim\\\\chromedriver_win32\\\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Window.html");

		// Task 1 click the parent window and switch to child window and close.

		String oldwindow = driver.getWindowHandle();

		WebElement buttonOne = driver.findElement(By.id("home"));
		buttonOne.click();

		Set<String> newHandles = driver.getWindowHandles();

		for (String newWindow : newHandles) {

			driver.switchTo().window(newWindow);
		}

		Thread.sleep(4000);
		
		WebElement alert = driver.findElement
				(By.xpath("//h5[text()='Alert']"));
		alert.click();

		Thread.sleep(4000);
		
		driver.close();

		driver.switchTo().window(oldwindow);


		// Task 2 : Find the Number of windows


		WebElement buttonTwo = driver.findElement
				(By.xpath("//button[@onclick='openWindows()']"));
		buttonTwo.click();

		int sizeOfWindow = driver.getWindowHandles().size();
		System.out.println("Size of an Window is : " + sizeOfWindow);
		
		driver.close();
		
		driver.switchTo().window(oldwindow);

		// Task 3 : Close the Child Windows , Don't Close the Parent Windows. 

		WebElement dontClose = driver.findElement(By.id("color"));
		dontClose.click();

		Set<String> lotofWindow	= driver.getWindowHandles();

		for (String allWindow : lotofWindow) {

			if(!allWindow.equals(oldwindow))
				driver.switchTo().window(allWindow);
			driver.close();
		}

		// driver.quit(); // close the all parent and child window

	}


		
	}

