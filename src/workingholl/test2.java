package workingholl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Mail="";
		WebDriver driver2 = new FirefoxDriver();
		driver2.get("https://accounts.google.com/ServiceLogin?hl=ko&continue=https://www.google.co.kr/");
		
		driver2.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(Mail);
		driver2.findElement(By.xpath("//*[@id=\"Passwd\"]")).sendKeys("r02164642");
		driver2.findElement(By.xpath("//*[@id=\"Passwd\"]")).submit();
		driver2.get("https://mail.google.com/mail/?tab=wm#inbox");
					
		try{
			Thread.sleep(1000);	
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		int k=0;
		for(;;k++){
			try{
				WebElement firstmail=driver2.findElement(By.xpath("//*[@id=\":3j\"]"));
				System.out.println(firstmail.getText());					
				if(firstmail.getText().contains("Confirmation Email – IEC Kompass Application Account")){
					System.out.println("메일 찾음! 접속");
					for(int k1=0;;k1++){
						firstmail.click();
						Thread.sleep(1000);
						try{
							WebElement firstmailname=driver2.findElement(By.xpath("//*[@id=\":5q\"]"));
							if(firstmailname.getText().contains("Confirmation Email – IEC Kompass Application Account")){
								System.out.println("메일 접속 성공");
								break;
							}
						}catch(Exception e12){
							System.out.println("메일 접속 실패 재 접속");
						}
					}
					break;	
				}
				
			}catch(Exception e){
				System.out.println("메일 체크중 기다리는중");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(k>8){
					k=0;
					System.out.println("메일 새로고침");
					try {
						driver2.get("https://mail.google.com/mail/?tab=wm#inbox");
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
			}
			
		}
		
	}
}
