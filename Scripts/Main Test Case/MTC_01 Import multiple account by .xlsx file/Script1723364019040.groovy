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

if (first == 'true') {
    WebUI.callTestCase(findTestCase('Requirements/TR-001 Navigate to account management'), [:], FailureHandling.CONTINUE_ON_FAILURE)
} else {
    WebUI.back()

    WebUI.click(findTestObject('Page_MentorUS Dashboard/spanManageAccount'))

    WebUI.click(findTestObject('Object Repository/Page_MentorUS Dashboard/iconImportMember'))
}

if (type == 'empty') {
    WebUI.click(findTestObject('MTC_01/Page_MentorUS Dashboard/button_checkXc nhn'))

    WebUI.verifyElementVisible(findTestObject('MTC_01/Page_MentorUS Dashboard/emptyAlert'), FailureHandling.CONTINUE_ON_FAILURE)
} else if (type == 'drag') {
    WebUI.uploadFileWithDragAndDrop(findTestObject('Object Repository/MTC_01/inputAccountFile'), ((fileList[0]) + '\n') + 
        (fileList[1]))
} else {
    WebUI.uploadFile(findTestObject('Object Repository/MTC_01/inputAccountFile'), filePath)

    if (isNotClick == 'false') {
        WebUI.click(findTestObject('MTC_01/Nút Xác nhận/btnConfirm'))

        WebUI.waitForElementNotPresent(findTestObject('MTC_01/loader'), 0)
    }
    
    WebUI.verifyElementText(findTestObject('MTC_01/Page_MentorUS Dashboard/divUploadFileMessage'), expectedResult, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.waitForElementNotPresent(findTestObject('MTC_01/Page_MentorUS Dashboard/divUploadFileMessage'), 0)
}

if (end == 'true') {
    WebUI.closeBrowser()
}

