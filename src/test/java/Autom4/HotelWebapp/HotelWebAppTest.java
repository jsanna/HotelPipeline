package Autom4.HotelWebapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Hello world!
 *
 */
public class HotelWebAppTest{
	
	private WebDriver driver;
	private String result;
	private String hotel;
	private String star;
	@Test
    public void Test () {
    driver = new FirefoxDriver();
    driver.get("http://192.168.102.138:9999/HotelWebapp/");
    driver.findElement(By.xpath("//select[contains(@name,'ville')]")).click();
    driver.findElement(By.xpath("//select/option[contains(@value,'Tokyo')]")).click();
    driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
    result = driver.findElement(By.xpath("//h3[2]")).getText();
    assertEquals("Hôtels disponibles à Tokyo",result);
    System.out.println("Les recherches sont bien celles de Tokyo");
    hotel = driver.findElement(By.xpath("//tr/td[1]")).getText();
    assertEquals("Hotel Global Hotel",hotel);
    System.out.println("Le premier Hotel est le Global Hotel");
    star = driver.findElement(By.xpath("//tr/td[4]")).getText();
    assertEquals("2 étoiles",star);
    System.out.println("C'est un Hotel " + star);    
}
}