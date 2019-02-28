package workingholl;

	import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

	import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

	public class workingday {
		public static void main(String[] args) throws InterruptedException {
			String Mail="";
			String password="!";
			
			WebDriver driver = new FirefoxDriver();
			WebDriver driver2 = new FirefoxDriver();
			driver2.get("https://accounts.google.com/ServiceLogin?hl=ko&continue=https://www.google.co.kr/");
			
			driver2.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(Mail);
			driver2.findElement(By.xpath("//*[@id=\"Passwd\"]")).sendKeys("r02164642");
			driver2.findElement(By.xpath("//*[@id=\"Passwd\"]")).submit();
			driver2.get("https://mail.google.com/mail/?tab=wm#inbox");
						
			try{
				Thread.sleep(5000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			driver.get("http://kompass-iec-eic.international.gc.ca/registration-inscription?regionCode=DE");
			
			for(int k=0;;k++){
				WebElement text1=driver.findElement(By.xpath("//*[@id=\"wb-con\"]/div/h1"));
				if(text1.getText().equals("Create Your “IEC Kompass” Account")){
					break;
				}else{
					Thread.sleep(1000);
					driver.get("http://kompass-iec-eic.international.gc.ca/registration-inscription?regionCode=DE");
				}
			}
			
			WebElement full_option=driver.findElement(By.xpath("//*[@id=\"rdoServiceIn_0\"]"));
			full_option.click();
			
			driver.findElement(By.id("txtLastName")).sendKeys("SEON");
			
			driver.findElement(By.xpath("//*[@id=\"txtFirstName\"]")).sendKeys("JUNHO");
			
			driver.findElement(By.xpath("//*[@id=\"txtDob\"]")).sendKeys("1990-09-09");
			
			WebElement citizenship=driver.findElement(By.xpath("//*[@id=\"ddlCitizenship\"]"));
			citizenship.click();
			citizenship.click();
		//	for(int k=0;k<5;k++){처음 할때 안함
	//			citizenship.sendKeys("k");
	//			Thread.sleep(100);
		//	}
			for(int k=0;k<0;k++){
				citizenship.sendKeys("g");
				Thread.sleep(100);
			}
			
			
			driver.findElement(By.xpath("//*[@id=\"txtEmailAddress\"]")).sendKeys(Mail);
			
			//confirm_personal_email_address
			driver.findElement(By.xpath("//*[@id=\"txtEmailAddressConfirm\"]")).sendKeys(Mail);

//			Enter_password			
			driver.findElement(By.xpath("//*[@id=\"txtPassword1\"]")).sendKeys(password);

//			confirm_password
			driver.findElement(By.xpath("//*[@id=\"txtPassword2\"]")).sendKeys(password);
			
//			continue_to_create_security_questions	
			driver.findElement(By.xpath("//*[@id=\"bttn_Next\"]")).click();
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
//2페지이 질문
			
//Secret_Question_1
			WebElement Secret_Question_1=driver.findElement(By.xpath("//*[@id=\"ddlSecretQuestion\"]"));
			Secret_Question_1.click();
			Secret_Question_1.click();
			Secret_Question_1.sendKeys(Keys.END);
			Secret_Question_1.sendKeys(Keys.ENTER);
			
			//Secret_Question_2
			WebElement Secret_Question_2=driver.findElement(By.xpath("//*[@id=\"ddlSecretQuestion2\"]"));
			Secret_Question_2.click();
			Secret_Question_2.click();
			Secret_Question_2.sendKeys(Keys.END);
			Secret_Question_1.sendKeys(Keys.ENTER);
			
			//Secret_Question_3
			WebElement Secret_Question_3=driver.findElement(By.xpath("//*[@id=\"ddlSecretQuestion3\"]"));
			Secret_Question_3.click();
			Secret_Question_3.click();
			Secret_Question_3.sendKeys(Keys.END);
			Secret_Question_1.sendKeys(Keys.ENTER);
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			//Secret_Question_1=1specify your question			
			driver.findElement(By.xpath("//*[@id=\"txtSpecifyQuestion\"]")).sendKeys("What is your last name?");
			
			//Secret_Question_1=1your answer			
			driver.findElement(By.xpath("//*[@id=\"txtYourAnswer\"]")).sendKeys("Seon");
			
			//Secret_Question_1=1confirm your answer
			driver.findElement(By.xpath("//*[@id=\"txtConfirmAnswer1\"]")).sendKeys("Seon");
			
			
			//Secret_Question_2=2specify your question			
			driver.findElement(By.xpath("//*[@id=\"txtSpecifyQuestion2\"]")).sendKeys("How many sisters you have?");
			
			//Secret_Question_2=2your answer			
			driver.findElement(By.xpath("//*[@id=\"txtYourAnswer2\"]")).sendKeys("one sister");
			
			//Secret_Question_2=2confirm your answer
			driver.findElement(By.xpath("//*[@id=\"txtConfirmAnswer2\"]")).sendKeys("one sister");
			

			//Secret_Question_3=3specify your question			
			driver.findElement(By.xpath("//*[@id=\"txtSpecifyQuestion3\"]")).sendKeys("How many brothers do you have?");
			
			//Secret_Question_3=3your answer			
			driver.findElement(By.xpath("//*[@id=\"txtYourAnswer3\"]")).sendKeys("One brother");
			
			//Secret_Question_3=3confirm your answer
			driver.findElement(By.xpath("//*[@id=\"txtConfirmAnswer3\"]")).sendKeys("One brother");
			
			//I certify that I have read and agree to the IEC Terms of Use and Privacy Statement
			driver.findElement(By.xpath("//*[@id=\"chkPrivacy\"]")).click();
			
			//3페이지로 넘어가기
			driver.findElement(By.xpath("//*[@id=\"bttn_NextTwo\"]")).click();
			
			
			//3페이지 추적
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			String Gmail="";			
			for(int k=0;;k++){
				driver2.get("https://mail.google.com/mail/?tab=wm#inbox");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				String GmailCheck="";
				for(int k1=0;;k++){
					try{
						WebElement gmailcheck=driver2.findElement(By.xpath("//div[@class = 'y6']/span[contains(., 'Confirmation Email – IEC Kompass Application Account')]"));
						GmailCheck=gmailcheck.getText();
						System.out.println("2222="+GmailCheck);
						if(GmailCheck.equals("Confirmation Email – IEC Kompass Application Account")){
							gmailcheck.click();
							Thread.sleep(1000);
							
						}else{
							System.out.println("기다리는중");
							Thread.sleep(1000);
						}
						//ArrayList<WebElement> gmail=driver2.findElements(By.partialLinkText(linkText))
						
						WebElement gmail=driver2.findElement(By.partialLinkText("https://kompass-iec-eic.international"));
						Gmail=gmail.getAttribute("href");
						System.out.println(gmail.getText());
						break;
					}catch(Exception e1){
						System.out.println("다시 접속");
					}
				}
				if(Gmail.contains("https://kompass-iec-eic.international")){
					driver.get(Gmail);
					break;
				}	
			}
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			//구글 접속 후 4페이지 진입
			driver.findElement(By.xpath("//*[@id=\"emailAddress\"]")).sendKeys(Mail);
			
			driver2.quit();
			
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Cdjduedhoi1!");
			
			driver.findElement(By.xpath("//*[@id=\"chkPrivacy\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"bttn_save\"]")).click();
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			//5페이지 접속 질문 5개 페이지
			
			driver.findElement(By.xpath("//*[@id=\"PersonalInfo\"]/td[2]/a")).click();
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			//5페이지 1번째 질문
			
			driver.findElement(By.xpath("//*[@id=\"chkA\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"chkB\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"chkC\"]")).click();
			
			//Have you used any other names=no
			driver.findElement(By.xpath("//*[@id=\"rdoOtherNames_1\"]")).click();
			
			
			WebElement sex=driver.findElement(By.xpath("//*[@id=\"ddlSex\"]"));
			sex.click();
			sex.click();
			sex.sendKeys("m");
			
			driver.findElement(By.xpath("//*[@id=\"txtCity\"]")).sendKeys("Gwangju");
			
			WebElement country=driver.findElement(By.xpath("//*[@id=\"ddlCountry\"]"));
			country.click();
			country.click();
			for(int k=0;k<5;k++){//한국
				country.sendKeys("k");
			}
		//	for(int k=0;k<0;k++){//독일
		//		country.sendKeys("g");
		//	}
			
			WebElement Marital_statue=driver.findElement(By.xpath("//*[@id=\"ddlMaritalStatus\"]"));
			Marital_statue.click();
			Marital_statue.click();
			Marital_statue.sendKeys("s");
			
			//passport number
			driver.findElement(By.xpath("//*[@id=\"txtPassportNumber\"]")).sendKeys("M06673580");
			
			//expiry date
			driver.findElement(By.xpath("//*[@id=\"txtExpiryDate\"]")).sendKeys("2015-03-17");
			
			//1번째 질문 완료
			driver.findElement(By.xpath("//*[@id=\"bttn_validate_next\"]")).click();
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			
			//2번째 질문 
			driver.findElement(By.xpath("//*[@id=\"ContactInfo\"]/td[2]/a")).click();
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			//2번째 질문 접속
			//Street name/House name
			driver.findElement(By.xpath("//*[@id=\"txtMailingStreet\"]")).sendKeys("Songdoro/Songjung-dong Gwangsangu");
			
			//City town
			driver.findElement(By.xpath("//*[@id=\"txtMailingCity\"]")).sendKeys("Gwangju");
			
			//Country/region
			WebElement Country_region=driver.findElement(By.xpath("//*[@id=\"ddlMailingCountry\"]"));
			Country_region.click();
			Country_region.click();
			
			for(int k=0;k<5;k++){//한국
				Country_region.sendKeys("k");	
			}
		//	for(int k=0;k<0;k++){//독일
		//		Country_region.sendKeys("g");	
		//	}
			
			//Personal current address(address of your current physical residence)=yes
			driver.findElement(By.xpath("//*[@id=\"rdoCurrentAddress_0\"]")).click();
			
			//personal permanent address(address in country of your citizenship)=same as mailing address
			driver.findElement(By.xpath("//*[@id=\"rdoPermanent_0\"]")).click();
			
			//type
			WebElement type=driver.findElement(By.xpath("//*[@id=\"ddlTeleType\"]"));
			type.click();
			type.click();
			type.sendKeys("c");
			
			//Country code=82
			driver.findElement(By.xpath("//*[@id=\"txtTeleCountry\"]")).sendKeys("82");
			
			//Number=1068981623
			driver.findElement(By.xpath("//*[@id=\"txtTeleNumber\"]")).sendKeys("1068981623");
			
			driver.findElement(By.xpath("//*[@id=\"bttn_validate_next\"]")).click();
			//2번째 완료

			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			//3번째 클릭
			
			driver.findElement(By.xpath("//*[@id=\"IECParticipat\"]/td[2]/a")).click();
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			driver.findElement(By.xpath("//*[@id=\"rdoGroupIECinitiative_1\"]")).click();
			
			WebElement participation=driver.findElement(By.xpath("//*[@id=\"ddlhowMany\"]"));
			participation.click();
			participation.click();
			participation.sendKeys("n");
			
			driver.findElement(By.xpath("//*[@id=\"bttn_validate_next\"]")).click();
			//3번째 질문 완료
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			//4번째 질문
			driver.findElement(By.xpath("//*[@id=\"IECCat\"]/td[2]/a")).click();
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//*[@id=\"WHPchk_A\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"bttn_validate_next\"]")).click();
			//4번째 질문 완료
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			//5번째 질문 
			driver.findElement(By.xpath("//*[@id=\"AppDeclaration\"]/td[2]/a")).click();
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			driver.findElement(By.xpath("//*[@id=\"chk1\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"chk2\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"chk3\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"chk4\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"chk5\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"chk6\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"chk7\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"chk8\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"chk9\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"chk10\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"bttn_validate_next\"]")).click();
			//5번째 질문 완료
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			
			//6번쩨 질문
			driver.findElement(By.xpath("//*[@id=\"StayinTounch\"]/td[2]/a")).click();
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			driver.findElement(By.xpath("//*[@id=\"rdoContacted_0\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"rdoParticipate_0\"]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"bttn_validate_next\"]")).click();
			//6번째 질문 완료
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			//보내기
			
			//driver.findElement(By.xpath("//*[@id=\"bttn_save\"]")).click();
			
			
				//	driver.quit();
		}
	}

