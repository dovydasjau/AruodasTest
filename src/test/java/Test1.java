import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Test1 {
    @Test
    public void test1() { // register test
        WebDriver driver = new ChromeDriver();
        driver.get("https://aruodas.lt"); // opening the page
        driver.manage().window().maximize(); // maximising the page

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[1]/div/div[2]/div/button[1]")).click(); // closing cookies
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div")).click(); // opening log in
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("/html/body/div[8]/div/div[10]/div/div/div/div[2]/div[2]/div[1]/a")).click(); // clicking register
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[2]/div/div/form/div[1]/div[2]/input")).sendKeys(generateRandomEmail()); // inputting a randomly generated email
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[2]/div/div/form/div[2]/div[2]/input")).sendKeys(generateRandomPassword()); // inputting a randomly generated password
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[2]/div/div/form/button")).click(); // clicking on 'register'

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ThreadLocalRandom.current().nextInt(2, 7))); //waiting for a random time from 2-6 seconds for captcha
        driver.findElement(By.xpath("/html/body/div[1]/form/button")).click(); // clicking on 'im not a robot' lol
        //doesn't work due to new anti robot implementation sadge
        WebElement resultText = driver.findElement(By.xpath(""));


        Assert.assertEquals(resultText.getText(), "Mano aruodas"); // checking if the registration is successful
        driver.close(); // closing the browser
    }

    @Test
    public void test2() { // creating a listing and checking if it was put up successfully (with some random elements)
        WebDriver driver = new ChromeDriver();
        driver.get("https://aruodas.lt"); // opening the page
        driver.manage().window().maximize(); // maximising the page

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[1]/div/div[2]/div/button[1]")).click(); // closing cookies
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div/div/a")).click(); // clicking create a listing
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/ul/li[1]")).click(); // clicking on apartment
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[3]/ul/li[1]")).click(); // clicking on selling
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/span")).click(); // clicking on county
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[2]")).click(); // selecting the first option
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[1]/span[2]")).click(); // selecting on micro districts
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[1]/ul[2]/li[2]")).click(); // selecting on the first option
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[6]/span[1]/span[2]")).click(); // selecting on the street name
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[6]/span[1]/ul[2]/li[2]")).click(); // selecting the first option
        int randomNum = (int) (Math.random() * 9);
        String intValue = Integer.toString(randomNum);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/input")).sendKeys(intValue); // entering a random house number
        randomNum = (int) (Math.random() * 25);
        intValue = Integer.toString(randomNum);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/span[1]/input")).sendKeys(intValue); // entering a random apartment number
        randomNum = (int) (1 + Math.random() * 100);
        intValue = Integer.toString(randomNum);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[14]/span[2]/input")).sendKeys(intValue); // entering a random apartment size
        randomNum = (int) (1 + Math.random() * 4);
        intValue = Integer.toString(randomNum);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[15]/div/span/input")).sendKeys(intValue); // entering a random apartment room number
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div[1]/span[2]/span")).click(); // clicking on the floor
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div[1]/span[2]/ul/li[2]")).click(); // clicking the second option
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div[2]/span[1]/span")).click(); // clicking the second option
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div[2]/span[1]/ul/li[6]")).click(); // selecting the sixth option
        randomNum = (int) (1900 + Math.random() * 100);
        intValue = Integer.toString(randomNum);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[17]/div[1]/span[1]/span/input")).sendKeys(intValue); // entering a random year
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[18]/div/div[2]")).click(); // clicking on the second building type
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[19]/div/div[1]")).click(); // clicking on the first equipment option
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[21]/div/div[1]/label/span")).click(); // clicking on the central heating option
        randomNum = (int) (100 + Math.random() * 10000);
        intValue = Integer.toString(randomNum);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[47]/span[2]/input")).sendKeys(intValue); // entering a price
        String phoneNumber = generateRandomPhoneNumber();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[48]/span[1]/input")).sendKeys(phoneNumber); // entering a random phone number
        String email = generateRandomEmail();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[49]/span[1]/input")).sendKeys(email); // entering a random email address
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[52]/span[1]/div/div/label/span")).click(); // clicking on i agree with the terms of service
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[53]/a")).click(); // clicking on put up listing
        driver.get("https://www.aruodas.lt/"); // go back to the main page
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/form/div/div[2]/div/div/ul/li[2]")).click(); // finding the listing
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[8]/div/div[10]/div/div/div/div[2]/div[1]")).click(); // closing the popup
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/form/div/div[2]/div/div/ul/li[2]")).click(); // finding the listing
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[2]/ul/li[1]")).click(); // clicking on my listings
        WebElement resultText = driver.findElement(By.xpath("//html/body/div[1]/div[3]/div[1]/table/tbody[2]/tr[2]/td/div[1]/button[1]"));
        Assert.assertEquals(resultText.getText(), "Redaguoti"); // checking if the listing is successfully put up
        driver.close(); // closing the browser
    }

    @Test
    public void test3() { // testing if the search works correctly
        WebDriver driver = new ChromeDriver();
        driver.get("https://aruodas.lt"); // opening the page
        driver.manage().window().maximize(); // maximising the page

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[1]/div/div[2]/div/button[1]")).click(); // closing cookies
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/form/div/div[1]/div/div[1]/div[1]/div[2]/div/div/div")).click(); // clicking on select the county
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/form/div/div[1]/div/div[1]/div[1]/div[2]/div/div/div/div/ul/li[2]/label")).click(); // clicking on the first option
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/form/div/div[1]/div/div[1]/div[2]/div[2]/div[1]/div[2]")).click(); // clicking on the '2' room count
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/form/div/div[1]/div/div[1]/div[2]/div[2]/div[1]/div[3]")).click(); // clicking on the '3' room count
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/form/div/div[1]/div/div[1]/div[2]/div[2]/div[1]/div[4]")).click(); // clicking on the '4' room count
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/div/form/div/div[1]/div/div[4]/div[3]/div[1]/input")).click(); // clicking search
        driver.close(); // closing the browser
    }


    public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};
        String[] characters = {"abcdefghijklmnopqrstuvwxyz", "0123456789"};

        Random random = new Random();

        StringBuilder email = new StringBuilder();

        // Generate username part
        int usernameLength = random.nextInt(10) + 5; // Random length between 5 to 14 characters
        for (int i = 0; i < usernameLength; i++) {
            String characterSet = characters[random.nextInt(2)]; // Selecting either alphabets or numbers
            char randomChar = characterSet.charAt(random.nextInt(characterSet.length()));
            email.append(randomChar);
        }

        // Adding '@' symbol
        email.append("@");

        // Selecting random domain
        String randomDomain = domains[random.nextInt(domains.length)];
        email.append(randomDomain);

        return email.toString();
    }

    public static String generateRandomPassword() {
        String[] characters = {"abcdefghijklmnopqrstuvwxyz", "0123456789"};
        Random random = new Random();

        StringBuilder password = new StringBuilder();

        int passwordLength = random.nextInt(15) + 10; // Random length between 6 to 14 characters
        for (int i = 0; i < passwordLength; i++) {
            String characterSet = characters[random.nextInt(2)]; // Selecting either alphabets or numbers
            char randomChar = characterSet.charAt(random.nextInt(characterSet.length()));
            password.append(randomChar);
        }
        return password.toString();
    }

    public static String generateRandomPhoneNumber() {
        String[] characters = {"0123456789"};
        Random random = new Random();

        StringBuilder phoneNumber = new StringBuilder("6");

        int phoneLength = 8;
        for (int i = 1; i < phoneLength; i++) {
            String characterSet = characters[random.nextInt(1)]; // Selecting either alphabets or numbers
            char randomChar = characterSet.charAt(random.nextInt(characterSet.length()));
            phoneNumber.append(randomChar);
        }

        return phoneNumber.toString();
    }

}

