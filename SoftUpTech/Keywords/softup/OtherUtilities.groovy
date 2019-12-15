package softup

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class OtherUtilities {
	static String RANDOM_ALPHANUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
	static String RANDOM_ALPHANUM_SPECIAL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#\$%^&*()"
	static String RANDOM_ALPHA_SPACES = "ABCDEFG HIJKLMNOP QRS TUV WXYZ"
	static String RANDOM_ALPHA_HARDRETURNS = "ABCDEFG\nHIJKLMNOP\nQRS\nTUV\nWXYZ"
	static String RANDOM_ALPHA_ONLY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	static String RANDOM_ALPHA_LOWER = "abcdefghijklmnopqrstuvwxyz"
	static String RANDOM_ALPHA_UPPER_AND_LOWER = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
	static String RANDOM_NUM = "0123456789"
	static String RANDOM_SPECIAL = "!@#\$%^&*()"

	@Keyword
	def String randomStringGenerator(Integer stringLength, String type) {

		//string 'type' passed in determines which type of chars are generated
		def CHARS = type

		StringBuilder string = new StringBuilder();
		Random rnd = new Random();
		while (string.length() < stringLength) { // length of the random string, uses an int passed in by test
			int index = (int) (rnd.nextFloat() * CHARS.length())
			string.append(CHARS.charAt(index))
		}
		String randomString = string.toString()
		return randomString
	}
}
