import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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

WebUI.comment("Open browser and navigate to url")
	
	WebUI.openBrowser(GlobalVariable.baseUrl)
	WebUI.maximizeWindow()
	
	def url  = WebUI.getUrl()
	
WebUI.comment("Check if user is located in the desired url")
	
	if(WebUI.verifyNotEqual(url, GlobalVariable.baseUrl, FailureHandling.OPTIONAL))
	{
			KeywordUtil.markError("User is not on the desired url")
	}
	
WebUI.comment("Login and filter data, check if the showing data is corespondent to the filtered data")
		def filteredElement= "test3" 
		//Call login method and set data
		Login(GlobalVariable.UserEmail, GlobalVariable.UserPassword)
		WebUI.click(findTestObject('Page_REALCUBE/Filtering/i_FilterList'))
		//The object here is parametized so we can create preset data for the filter that we want to make and just pass it to the object
		WebUI.click(findTestObject('Page_REALCUBE/Filtering/div_filteredElement',[element:filteredElement]))
		WebUI.click(findTestObject('Page_REALCUBE/Filtering/i_FilterList'))
		WebUI.verifyTextPresent("test3", false)
	
	
	
	
	
	
	
	
	
	
	
	def Login(String email, String password){
		WebUI.comment("Login into the platform using a valid email and password")
		WebUI.setText(findTestObject('Page_REALCUBE/LandingPage/input_E-Mail'), email)
		WebUI.setText(findTestObject('Page_REALCUBE/LandingPage/input_Password'),password)
		WebUI.click(findTestObject('Page_REALCUBE/LandingPage/button_LogIn'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Page_REALCUBE/LandingPage/img_Account'))
		if(WebUI.verifyTextPresent("John Doe", false,FailureHandling.OPTIONAL))
		{
			KeywordUtil.markPassed("User is logged in")
			
		}
			if(WebUI.verifyTextNotPresent("John Doe", false,FailureHandling.OPTIONAL)){
				KeywordUtil.markFailed("Username does not match user is not logged in")
			}
	}