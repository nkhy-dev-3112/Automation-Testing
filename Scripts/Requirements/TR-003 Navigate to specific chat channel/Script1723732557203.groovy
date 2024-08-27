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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Requirements/TR-000 Login'), [('url') : 'http://localhost:3000/', ('email') : 'nkhy21@clc.fitus.edu.vn'
        , ('password') : '0Zi2+YbOTLoxGi/gcRld1BlRWMdBgcoa'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/MTC_03/Page_MentorUS Dashboard/span_chat'))

WebUI.click(findTestObject('Object Repository/MTC_03/Page_MentorUS Dashboard/div_d'))

WebUI.click(findTestObject('MTC_03/Page_MentorUS Dashboard/Page_MentorUS Dashboard/generalChat'))

WebUI.click(findTestObject('Object Repository/MTC_03/Page_MentorUS Dashboard/svg'))
