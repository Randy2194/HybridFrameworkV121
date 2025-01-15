package testCases;

import org.apache.commons.lang3.RandomStringUtils;

public class Check {

	public static void main(String[] args) {
		Check check=new Check();
		System.out.println(check.randomString());
			
		}
	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

}
