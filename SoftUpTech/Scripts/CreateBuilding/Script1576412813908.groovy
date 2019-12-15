import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.google.common.collect.FilteredEntryMultimap.Keys
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import softup.OtherUtilities
import org.openqa.selenium.Keys as Keys

WebUI.comment("Open browser and navigate to url")

WebUI.openBrowser(GlobalVariable.baseUrl)
WebUI.maximizeWindow()

def url  = WebUI.getUrl()
def randomText = CustomKeywords.'softup.OtherUtilities.randomStringGenerator'(5, OtherUtilities.RANDOM_ALPHANUM)

WebUI.comment("Check if user is located in the desired url")

if(WebUI.verifyNotEqual(url, GlobalVariable.baseUrl, FailureHandling.OPTIONAL))
{
		KeywordUtil.markPassed("User is not on the desired url")
}


WebUI.comment('Click on create buliding and search for a location')
		def country = "Kosovo"
		//Call login method and set data
		Login(GlobalVariable.UserEmail, GlobalVariable.UserPassword)
		WebUI.click( findTestObject('Page_REALCUBE/CreateBuilding/nav_CreateNewBuilding'))
		WebUI.setText(findTestObject('Page_REALCUBE/CreateBuilding/input_SearchBar'), country)
		WebUI.sendKeys( findTestObject('Page_REALCUBE/CreateBuilding/input_SearchBar'), Keys.chord(Keys.ENTER))
		
		
WebUI.comment("Click on add buliding and fill the data for the new building")
		WebUI.click(findTestObject('Page_REALCUBE/CreateBuilding/button_AddBuilding'))
		WebUI.setText(findTestObject('Page_REALCUBE/CreateBuilding/input_BuildingName'),randomText)
		WebUI.setText(findTestObject('Page_REALCUBE/CreateBuilding/input_City'),randomText)
		WebUI.setText(findTestObject('Page_REALCUBE/CreateBuilding/input_Street'),randomText)
		WebUI.setText(findTestObject('Page_REALCUBE/CreateBuilding/input_Country'),randomText)
		WebUI.setText(findTestObject('Page_REALCUBE/CreateBuilding/input_ZipCode'),randomText)
		WebUI.setText(findTestObject('Page_REALCUBE/CreateBuilding/input_StreetNumber'),randomText)
		WebUI.setText(findTestObject('Page_REALCUBE/CreateBuilding/input_Province'),randomText)
		WebUI.click(findTestObject('Page_REALCUBE/CreateBuilding/div_Property'))
		WebUI.click(findTestObject('Page_REALCUBE/CreateBuilding/li_FRANKFURT PROPERTY'))
		WebUI.click(findTestObject('Page_REALCUBE/CreateBuilding/div_BuildingType'))
		WebUI.click(findTestObject('Page_REALCUBE/CreateBuilding/li_Wohngebude'))
		WebUI.click(findTestObject('Page_REALCUBE/CreateBuilding/button_Save'))
		WebUI.delay(1)
		WebUI.verifyTextPresent("Success", false)
		WebUI.verifyTextPresent("Building created", false)
		WebUI.takeScreenshot()



def Login(String email, String password){
	WebUI.comment("Login into the platform using a valid email and password")
	WebUI.setText(findTestObject('Page_REALCUBE/LandingPage/input_E-Mail'), email)
	WebUI.setText(findTestObject('Page_REALCUBE/LandingPage/input_Password'),password)
	WebUI.click(findTestObject('Page_REALCUBE/LandingPage/button_LogIn'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Page_REALCUBE/LandingPage/img_Account'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Page_REALCUBE/LandingPage/p_languageEN'))
	if(WebUI.verifyTextPresent("John Doe", false,FailureHandling.OPTIONAL))
	{
		KeywordUtil.markPassed("User is logged in")
		
	}
		if(WebUI.verifyTextNotPresent("John Doe", false,FailureHandling.OPTIONAL)){
			KeywordUtil.markFailed("Username does not match user is not logged in")
		}
}