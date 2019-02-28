package workingholl;

import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class workingauto {
	public static void keyvoid(int number){
		InputStreamReader br =new InputStreamReader(System.in);
		int c=0;
		 try {
			 while((c=br.read()) ==number) {
				 System.out.println("c= "+c);
			 }
		 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	}
	public static void connect(String before,String after){
		
	}

	public static void main(String[] args) throws InterruptedException {
		String Mail="";
		String Mail2="";
		String password="";
		
		WebDriver driver = new FirefoxDriver();
		WebDriver driver2 = new FirefoxDriver();
		driver2.get("https://accounts.google.com/ServiceLogin?hl=ko&continue=https://www.google.co.kr/");
		
		driver2.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(Mail);
		driver2.findElement(By.xpath("//*[@id=\"Passwd\"]")).sendKeys("dlraudzmffotm");
		driver2.findElement(By.xpath("//*[@id=\"Passwd\"]")).submit();
		driver2.get("https://mail.google.com/mail/?tab=wm#inbox");
					
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		driver.get("https://kompass-iec-eic.international.gc.ca/IECindex.aspx?regioncode=KR&Lang=eng");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		for(int k=0;;k++){//처음 대기 페이지 계속 접속 시도
			Thread.sleep(100);
			try{
				WebElement text1=driver.findElement(By.xpath("//*[@id=\"wb-con\"]/div/div/ul[1]/li[1]/a"));
				if(text1.getText().contains("register")){
					text1.click();
					break;
				}else{
					Thread.sleep(1000);
					driver.get("https://kompass-iec-eic.international.gc.ca/IECindex.aspx?regioncode=KR&Lang=eng");
				}	
			}catch(Exception e){
				System.out.println("첫페이지 다 시 접속");
			}
		}
		
		try{
			Thread.sleep(500);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		WebElement full_option=driver.findElement(By.xpath("//*[@id=\"rdoServiceIn_0\"]"));
		full_option.click();
		
		driver.findElement(By.id("txtLastName")).sendKeys("SEON");
		
		driver.findElement(By.xpath("//*[@id=\"txtFirstName\"]")).sendKeys("JUNHO");
		
		driver.findElement(By.xpath("//*[@id=\"txtDob\"]")).sendKeys("1990-09-09");
		/*
		WebElement citizenship=driver.findElement(By.xpath("//*[@id=\"ddlCitizenship\"]"));
		citizenship.click();
		citizenship.click();
			for(int k=0;k<5;k++){
			citizenship.sendKeys("k");
			Thread.sleep(100);
		}*/
	/*	for(int k=0;k<0;k++){
			citizenship.sendKeys("g");
			Thread.sleep(100);
		}*/
		
		
		driver.findElement(By.xpath("//*[@id=\"txtEmailAddress\"]")).sendKeys(Mail);
		
		//confirm_personal_email_address
		driver.findElement(By.xpath("//*[@id=\"txtEmailAddressConfirm\"]")).sendKeys(Mail);

//		Enter_password			
		driver.findElement(By.xpath("//*[@id=\"txtPassword1\"]")).sendKeys(password);

//		confirm_password
		driver.findElement(By.xpath("//*[@id=\"txtPassword2\"]")).sendKeys(password);
		
//		continue_to_create_security_questions	
		driver.findElement(By.xpath("//*[@id=\"bttn_Next\"]")).click();
		//2페지이 질문
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		try{
			//Secret_Question_1_test
			WebElement Secret_Question_1=driver.findElement(By.xpath("//*[@id=\"ddlSecretQuestion\"]"));
			
		}catch(Exception e){//보통 메일 문제 이거나 비밀번호 문제
			Mail=Mail2;
			driver.findElement(By.xpath("//*[@id=\"txtEmailAddress\"]")).sendKeys(Mail);
			
			//confirm_personal_email_address
			driver.findElement(By.xpath("//*[@id=\"txtEmailAddressConfirm\"]")).sendKeys(Mail);

//			Enter_password			
			driver.findElement(By.xpath("//*[@id=\"txtPassword1\"]")).sendKeys(password);

//			confirm_password
			driver.findElement(By.xpath("//*[@id=\"txtPassword2\"]")).sendKeys(password);
			
//			continue_to_create_security_questions	
			driver.findElement(By.xpath("//*[@id=\"bttn_Next\"]")).click();
			Thread.sleep(1000);
		}
		
		try{
			//Secret_Question_1_test
			WebElement Secret_Question_1=driver.findElement(By.xpath("//*[@id=\"ddlSecretQuestion\"]"));
			
		}catch(Exception e){//보통 메일 문제 이거나 비밀번호 문제
			System.out.println("2번째 이메일 및 비밀번호 오류-알아서 처리할 것");
			System.out.println(Mail);
			System.out.println(password);
			keyvoid(96);
		}
		
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
		Secret_Question_2.sendKeys(Keys.ENTER);
		
		//Secret_Question_3
		WebElement Secret_Question_3=driver.findElement(By.xpath("//*[@id=\"ddlSecretQuestion3\"]"));
		Secret_Question_3.click();
		Secret_Question_3.click();
		Secret_Question_3.sendKeys(Keys.END);
		Secret_Question_3.sendKeys(Keys.ENTER);
		
		try{
			Thread.sleep(300);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		//Secret_Question_1=1specify your question			
		try{
			driver.findElement(By.xpath("//*[@id=\"txtSpecifyQuestion\"]")).sendKeys("What is your last name?");
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtSpecifyQuestion\"]")).sendKeys("What is your last name?");
	
		}
		
		//Secret_Question_1=1your answer					
		try{
			driver.findElement(By.xpath("//*[@id=\"txtYourAnswer\"]")).sendKeys("Seon");
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtYourAnswer\"]")).sendKeys("Seon");
		}
		
		//Secret_Question_1=1confirm your answer		
		try{
			driver.findElement(By.xpath("//*[@id=\"txtConfirmAnswer1\"]")).sendKeys("Seon");
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtConfirmAnswer1\"]")).sendKeys("Seon");
		}
		
		
		//Secret_Question_2=2specify your question			
		try{
			driver.findElement(By.xpath("//*[@id=\"txtSpecifyQuestion2\"]")).sendKeys("How many sisters you have?");
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtSpecifyQuestion2\"]")).sendKeys("How many sisters you have?");
		}
		
		//Secret_Question_2=2your answer 
		try{
			driver.findElement(By.xpath("//*[@id=\"txtYourAnswer2\"]")).sendKeys("one sister");
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtYourAnswer2\"]")).sendKeys("one sister");
		}
		
		//Secret_Question_2=2confirm your answer
		try{
			driver.findElement(By.xpath("//*[@id=\"txtConfirmAnswer2\"]")).sendKeys("one sister");			
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtConfirmAnswer2\"]")).sendKeys("one sister");
			
		}

		//Secret_Question_3=3specify your question			
		try{
			driver.findElement(By.xpath("//*[@id=\"txtSpecifyQuestion3\"]")).sendKeys("How many brothers do you have?");
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtSpecifyQuestion3\"]")).sendKeys("How many brothers do you have?");
		}
		
		//Secret_Question_3=3your answer			
		try{
			driver.findElement(By.xpath("//*[@id=\"txtYourAnswer3\"]")).sendKeys("One brother");
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtYourAnswer3\"]")).sendKeys("One brother");
		}
		
		//Secret_Question_3=3confirm your answer
		try{
			driver.findElement(By.xpath("//*[@id=\"txtConfirmAnswer3\"]")).sendKeys("One brother");
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtConfirmAnswer3\"]")).sendKeys("One brother");
		}
	
		//I certify that I have read and agree to the IEC Terms of Use and Privacy Statement
		try{
			driver.findElement(By.xpath("//*[@id=\"chkPrivacy\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"chkPrivacy\"]")).click();
		}

		//3페이지로 넘어가기
		try{
			driver.findElement(By.xpath("//*[@id=\"bttn_NextTwo\"]")).click();			
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"bttn_NextTwo\"]")).click();
		}
		
		//3페이지 추적
		System.out.println("g 메일 확인 시작");
		try{
			Thread.sleep(300);	
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
							WebElement firstmailname=driver2.findElement(By.className("hP"));//xpath("//*[@id=\":5k\"]"));
							System.out.println("메일 제목= "+firstmailname.getText());
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
		System.out.println("메일 접속 완료 끝남");
		WebElement firstmailso=driver2.findElement(By.xpath("//*[@class=\"a3s\"]/a"));
		System.out.println("링크= "+firstmailso.getText());
		//////////////////////지메일 확인 완료
		
		//구글 접속 후 4페이지 진입
		driver.get(firstmailso.getText());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			WebElement checking41=driver.findElement(By.xpath("//*[@id=\"emailAddress\"]"));
		} catch (Exception e) {
			try {
				Thread.sleep(1000);
				WebElement checking41=driver.findElement(By.xpath("//*[@id=\"emailAddress\"]"));
			} catch (Exception e1) {
				try {
					driver.get(firstmailso.getText());
					Thread.sleep(1000);
					WebElement checking41=driver.findElement(By.xpath("//*[@id=\"emailAddress\"]"));
				} catch (Exception e2) {
					System.out.println("오류 링크 접속 확인");
					System.out.println("접속 주소= "+firstmailso.getText());
					keyvoid(96);
				}
			}
		}
		
		driver.findElement(By.xpath("//*[@id=\"emailAddress\"]")).sendKeys(Mail);
		driver2.quit();
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		
		driver.findElement(By.xpath("//*[@id=\"chkPrivacy\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"bttn_save\"]")).click();
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//5페이지 접속 질문 5개 페이지
		try{
			driver.findElement(By.xpath("//*[@id=\"PersonalInfo\"]/td[2]/a")).click();
		}catch(Exception e){
			try{
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"PersonalInfo\"]/td[2]/a")).click();
			}catch(Exception e1){
				try{
					driver.findElement(By.xpath("//*[@id=\"bttn_save\"]")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id=\"PersonalInfo\"]/td[2]/a")).click();
				}catch(Exception e2){
					System.out.println("5페이지 질문 5개 페이지 접속 오류");
					keyvoid(96);		
				}
			}
		}
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//5페이지 1번째 접속 확인
		try{
			WebElement checking51=driver.findElement(By.xpath("//*[@id=\"chkA\"]"));
		}catch(Exception e){
			try{
				Thread.sleep(1000);
				WebElement checking51=driver.findElement(By.xpath("//*[@id=\"chkA\"]"));
			}catch(Exception e1){
				try{
					driver.findElement(By.xpath("//*[@id=\"PersonalInfo\"]/td[2]/a")).click();
					Thread.sleep(1000);
					WebElement checking51=driver.findElement(By.xpath("//*[@id=\"chkA\"]"));
				}catch(Exception e2){
					System.out.println("5페이지 질문 5개 페이지 -1페이지- 접속 오류");
					keyvoid(96);	
				}
				
			}
		}
		
		//5페이지 1번째 질문
		try{
			driver.findElement(By.xpath("//*[@id=\"chkA\"]")).click();
		}catch(Exception e){
			try{
				driver.findElement(By.xpath("//*[@id=\"chkA\"]")).click();
			}catch(Exception e1){
				System.out.println("오류!!!");
				keyvoid(96);
			}
		}
		try{
			driver.findElement(By.xpath("//*[@id=\"chkB\"]")).click();
		}catch(Exception e){
			try{
				driver.findElement(By.xpath("//*[@id=\"chkB\"]")).click();
			}catch(Exception e1){
				System.out.println("오류!!!");
				keyvoid(96);
			}
		}
		try{
			driver.findElement(By.xpath("//*[@id=\"chkC\"]")).click();
		}catch(Exception e){
			try{
				driver.findElement(By.xpath("//*[@id=\"chkC\"]")).click();
			}catch(Exception e1){
				System.out.println("오류!!!");
				keyvoid(96);
			}
		}
		
		
		//Have you used any other names=no
		try{
			driver.findElement(By.xpath("//*[@id=\"rdoOtherNames_1\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"rdoOtherNames_1\"]")).click();
		}
		
		try{
			WebElement sex=driver.findElement(By.xpath("//*[@id=\"ddlSex\"]"));
			sex.click();
			sex.click();
			sex.sendKeys("m");
		}catch(Exception e){
			System.out.println("성별 표시 오류!!");
			keyvoid(96);
		}
		
		try{
			driver.findElement(By.xpath("//*[@id=\"txtCity\"]")).sendKeys("Gwangju");
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtCity\"]")).sendKeys("Gwangju");
		}
		
		try{
			WebElement country=driver.findElement(By.xpath("//*[@id=\"ddlCountry\"]"));
			country.click();
			country.click();
			for(int g=0;g<5;g++){//한국
				country.sendKeys("k");
			}
		}catch(Exception e){
			System.out.println("나라 설정 오류!!");
			keyvoid(96);
		}
		
	//	for(int k=0;k<0;k++){//독일
	//		country.sendKeys("g");
	//	}
		
		try{
			WebElement Marital_statue=driver.findElement(By.xpath("//*[@id=\"ddlMaritalStatus\"]"));
			Marital_statue.click();
			Marital_statue.click();
			Marital_statue.sendKeys("s");
		}catch(Exception e){
			System.out.println("싱글로 표시 오류!!");
			keyvoid(96);
		}
		
		
		//passport number
		try{
			driver.findElement(By.xpath("//*[@id=\"txtPassportNumber\"]")).sendKeys("M02727141");	
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtPassportNumber\"]")).sendKeys("M02727141");
		}
		
		//expiry date
		try{
			driver.findElement(By.xpath("//*[@id=\"txtExpiryDate\"]")).sendKeys("2024-05-15");
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtExpiryDate\"]")).sendKeys("2024-05-15");
		}
		
		keyvoid(96);
		//1번째 질문 완료
		
		driver.findElement(By.xpath("//*[@id=\"bttn_validate_next\"]")).click();
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		try {
			WebElement checking52=driver.findElement(By.xpath("//*[@id=\"ContactInfo\"]/td[2]/a"));
		} catch (Exception e) {
			try {
				Thread.sleep(1000);
				WebElement checking52=driver.findElement(By.xpath("//*[@id=\"ContactInfo\"]/td[2]/a"));
			} catch (Exception e1) {
				try {
					driver.findElement(By.xpath("//*[@id=\"bttn_validate_next\"]")).click();
					Thread.sleep(1000);
					WebElement checking52=driver.findElement(By.xpath("//*[@id=\"ContactInfo\"]/td[2]/a"));
				} catch (Exception e2) {
					System.out.println("5개 질문 -1페이지에서 2페이지로 넘어 가는 과정");
					keyvoid(96);
				}
			}
		}
		
		//2번째 질문 
		driver.findElement(By.xpath("//*[@id=\"ContactInfo\"]/td[2]/a")).click();
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		try {
			WebElement checking521=driver.findElement(By.xpath("//*[@id=\"txtMailingStreet\"]"));
		} catch (Exception e) {
			try {
				Thread.sleep(1000);
				WebElement checking521=driver.findElement(By.xpath("//*[@id=\"txtMailingStreet\"]"));
			} catch (Exception e1) {
				try {
					driver.findElement(By.xpath("//*[@id=\"ContactInfo\"]/td[2]/a")).click();
					Thread.sleep(1000);
					WebElement checking521=driver.findElement(By.xpath("//*[@id=\"txtMailingStreet\"]"));
				} catch (Exception e2) {
					System.out.println("5개 질문 -1페이지에서 2페이지로 넘어 가는 과정");
					keyvoid(96);
				}
			}
		}
		
		
		//2번째 질문 접속
		//Street name/House name
		try{
			driver.findElement(By.xpath("//*[@id=\"txtMailingStreet\"]")).sendKeys("Songdoro/Songjung-dong Gwangsangu");
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtMailingStreet\"]")).sendKeys("Songdoro/Songjung-dong Gwangsangu");		
		}
		
		//City town
		try{
			driver.findElement(By.xpath("//*[@id=\"txtMailingCity\"]")).sendKeys("Gwangju");
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtMailingCity\"]")).sendKeys("Gwangju");
		}
		
		/*//Country/region
		try{
			WebElement Country_region=driver.findElement(By.xpath("//*[@id=\"ddlMailingCountry\"]"));
			Country_region.click();
			Country_region.click();
			
			for(int g=0;g<5;g++){//한국
				Country_region.sendKeys("k");	
			}
		}catch(Exception e){
			keyvoid(96);
		}
		*/
	//	for(int k=0;k<0;k++){//독일
	//		Country_region.sendKeys("g");	
	//	}
		
		//Personal current address(address of your current physical residence)=yes
		try{
			driver.findElement(By.xpath("//*[@id=\"rdoCurrentAddress_0\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"rdoCurrentAddress_0\"]")).click();
		}
		
		//personal permanent address(address in country of your citizenship)=same as mailing address
		try{
			driver.findElement(By.xpath("//*[@id=\"rdoPermanent_0\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"rdoPermanent_0\"]")).click();
		}
		
		//type
		try{
			WebElement type=driver.findElement(By.xpath("//*[@id=\"ddlTeleType\"]"));
			type.click();
			type.click();
			type.sendKeys("c");
		}catch(Exception e){
			keyvoid(96);
		}
		
		
		//Country code=82
		try{
			driver.findElement(By.xpath("//*[@id=\"txtTeleCountry\"]")).sendKeys("82");
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtTeleCountry\"]")).sendKeys("82");
		}
		
		//Number=1068981623
		try{
			driver.findElement(By.xpath("//*[@id=\"txtTeleNumber\"]")).sendKeys("1068981623");
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"txtTeleNumber\"]")).sendKeys("1068981623");
		}
		
		keyvoid(96);
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
		
		try{
			driver.findElement(By.xpath("//*[@id=\"rdoGroupIECinitiative_1\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"rdoGroupIECinitiative_1\"]")).click();
		}
		
		try{
			WebElement participation=driver.findElement(By.xpath("//*[@id=\"ddlhowMany\"]"));
			participation.click();
			participation.click();
			participation.sendKeys("n");	
		}catch(Exception e){
			keyvoid(96);
		}
		
		driver.findElement(By.xpath("//*[@id=\"bttn_validate_next\"]")).click();
		//3번째 질문 완료
		
		try {
			WebElement checking52=driver.findElement(By.xpath("//*[@id=\"IECCat\"]/td[2]/a"));
		} catch (Exception e) {
			try {
				Thread.sleep(1000);
				WebElement checking52=driver.findElement(By.xpath("//*[@id=\"IECCat\"]/td[2]/a"));
			} catch (Exception e1) {
				try {
					driver.findElement(By.xpath("//*[@id=\"bttn_validate_next\"]")).click();
					Thread.sleep(1000);
					WebElement checking52=driver.findElement(By.xpath("//*[@id=\"IECCat\"]/td[2]/a"));
				} catch (Exception e2) {
					System.out.println("5개 질문 -3페이지에서 4페이지로 넘어 가는 과정");
					keyvoid(96);
				}
			}
		}
		//4번째 질문
		
		driver.findElement(By.xpath("//*[@id=\"IECCat\"]/td[2]/a")).click();
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		 
		try {
			WebElement checking521=driver.findElement(By.xpath("//*[@id=\"WHPchk_A\"]"));
		} catch (Exception e) {
			try {
				Thread.sleep(1000);
				WebElement checking521=driver.findElement(By.xpath("//*[@id=\"WHPchk_A\"]"));
			} catch (Exception e1) {
				try {
					driver.findElement(By.xpath("//*[@id=\"IECCat\"]/td[2]/a")).click();
					Thread.sleep(1000);
					WebElement checking521=driver.findElement(By.xpath("//*[@id=\"WHPchk_A\"]"));
				} catch (Exception e2) {
					System.out.println("5개 질문 -3페이지에서 4페이지로 넘어 가는 과정");
					keyvoid(96);
				}
			}
		}
		
		///////////////////////////////////////////
		try{
			driver.findElement(By.xpath("//*[@id=\"WHPchk_A\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"WHPchk_A\"]")).click();
		}
		
		driver.findElement(By.xpath("//*[@id=\"bttn_validate_next\"]")).click();
		//4번째 질문 완료
		////////////////////////////////////
		try {
			WebElement checking52=driver.findElement(By.xpath("//*[@id=\"AppDeclaration\"]/td[2]/a"));
		} catch (Exception e) {
			try {
				Thread.sleep(1000);
				WebElement checking52=driver.findElement(By.xpath("//*[@id=\"AppDeclaration\"]/td[2]/a"));
			} catch (Exception e1) {
				try {
					driver.findElement(By.xpath("//*[@id=\"bttn_validate_next\"]")).click();
					Thread.sleep(1000);
					WebElement checking52=driver.findElement(By.xpath("//*[@id=\"AppDeclaration\"]/td[2]/a"));
				} catch (Exception e2) {
					System.out.println("5개 질문 -4페이지에서 5페이지로 넘어 가는 과정");
					keyvoid(96);
				}
			}
		}
		//5번째 질문
		
		driver.findElement(By.xpath("//*[@id=\"AppDeclaration\"]/td[2]/a")).click();
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		try {
			WebElement checking521=driver.findElement(By.xpath("//*[@id=\"chk1\"]"));
		} catch (Exception e) {
			try {
				Thread.sleep(1000);
				WebElement checking521=driver.findElement(By.xpath("//*[@id=\"chk1\"]"));
			} catch (Exception e1) {
				try {
					driver.findElement(By.xpath("//*[@id=\"AppDeclaration\"]/td[2]/a")).click();
					Thread.sleep(1000);
					WebElement checking521=driver.findElement(By.xpath("//*[@id=\"chk1\"]"));
				} catch (Exception e2) {
					System.out.println("5개 질문 -4페이지에서 5페이지로 넘어 가는 과정");
					keyvoid(96);
				}
			}
		}
		
		///////////////////////////////////////////
		
		try{
			driver.findElement(By.xpath("//*[@id=\"chk1\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"chk1\"]")).click();
		}
		
		try{
			driver.findElement(By.xpath("//*[@id=\"chk2\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"chk2\"]")).click();
		}
		
		try{
			driver.findElement(By.xpath("//*[@id=\"chk3\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"chk3\"]")).click();
		}
		
		try{
			driver.findElement(By.xpath("//*[@id=\"chk4\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"chk4\"]")).click();
		}
		
		try{
			driver.findElement(By.xpath("//*[@id=\"chk5\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"chk5\"]")).click();
		}
		
		try{
			driver.findElement(By.xpath("//*[@id=\"chk6\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"chk6\"]")).click();
		}
		
		try{
			driver.findElement(By.xpath("//*[@id=\"chk7\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"chk7\"]")).click();
		}
		
		try{
			driver.findElement(By.xpath("//*[@id=\"chk8\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"chk8\"]")).click();
		}
		
		try{
			driver.findElement(By.xpath("//*[@id=\"chk9\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"chk9\"]")).click();
		}
		
		try{
			driver.findElement(By.xpath("//*[@id=\"chk10\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"chk10\"]")).click();
		}
		
		
		driver.findElement(By.xpath("//*[@id=\"bttn_validate_next\"]")).click();
		//5번째 질문 완료
		////////////////////////////////////
		try {
			WebElement checking52=driver.findElement(By.xpath("//*[@id=\"StayinTounch\"]/td[2]/a"));
		} catch (Exception e) {
			try {
				Thread.sleep(1000);
				WebElement checking52=driver.findElement(By.xpath("//*[@id=\"StayinTounch\"]/td[2]/a"));
			} catch (Exception e1) {
				try {
					driver.findElement(By.xpath("//*[@id=\"bttn_validate_next\"]")).click();
					Thread.sleep(1000);
					WebElement checking52=driver.findElement(By.xpath("//*[@id=\"StayinTounch\"]/td[2]/a"));
				} catch (Exception e2) {
					System.out.println("5개 질문 -5페이지에서 6페이지로 넘어 가는 과정");
					keyvoid(96);
				}
			}
		}
		//6번째 질문
		driver.findElement(By.xpath("//*[@id=\"StayinTounch\"]/td[2]/a")).click();
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}

		try {
			WebElement checking521=driver.findElement(By.xpath("//*[@id=\"rdoContacted_0\"]"));
		} catch (Exception e) {
			try {
				Thread.sleep(1000);
				WebElement checking521=driver.findElement(By.xpath("//*[@id=\"rdoContacted_0\"]"));
			} catch (Exception e1) {
				try {
					driver.findElement(By.xpath("//*[@id=\"StayinTounch\"]/td[2]/a")).click();
					Thread.sleep(1000);
					WebElement checking521=driver.findElement(By.xpath("//*[@id=\"rdoContacted_0\"]"));
				} catch (Exception e2) {
					System.out.println("5개 질문 -5페이지에서 6페이지로 넘어 가는 과정");
					keyvoid(96);
				}
			}
		}

		///////////////////////////////////////////

		try{
			driver.findElement(By.xpath("//*[@id=\"rdoContacted_0\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"rdoContacted_0\"]")).click();
		}
		
		try{
			driver.findElement(By.xpath("//*[@id=\"rdoParticipate_0\"]")).click();
		}catch(Exception e){
			driver.findElement(By.xpath("//*[@id=\"rdoParticipate_0\"]")).click();
		}
		
		keyvoid(96);
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
