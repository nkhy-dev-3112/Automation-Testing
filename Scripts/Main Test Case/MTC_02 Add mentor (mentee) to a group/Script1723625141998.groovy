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
    WebUI.callTestCase(findTestCase('Requirements/TR-002 Navigate to a created group'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
    WebUI.refresh()

    WebUI.click(findTestObject('Object Repository/Page_MentorUS Dashboard/createdGroup'))
}

WebUI.click(findTestObject('MTC_02/Page_MentorUS Dashboard/btnThemMentor'))

if (type == 'file') {
    WebUI.click(findTestObject('MTC_02/Page_MentorUS Dashboard/uploadFileIcon'))

    if (status == 'empty') {
        WebUI.doubleClick(findTestObject('MTC_02/Page_MentorUS Dashboard/p_Xc nhn'))

        WebUI.verifyElementText(findTestObject('MTC_02/Page_MentorUS Dashboard/Page_MentorUS Dashboard/Page_MentorUS Dashboard/invalidMessage'), 
            message)
    } else if (status == 'drag') {
        WebUI.uploadFileWithDragAndDrop(findTestObject('MTC_02/Page_MentorUS Dashboard/input_file'), ((fileList[0]) + '\n') + 
            (fileList[1]))
    } else {
        WebUI.uploadFile(findTestObject('MTC_02/Page_MentorUS Dashboard/input_file'), data)

        if (otherFileType == 'true') {
            WebUI.verifyTextPresent(message, false)
        } else {
            WebUI.click(findTestObject('MTC_02/Page_MentorUS Dashboard/btnFileUploadConfirm'))

            if (status == 'fail') {
                WebUI.verifyElementText(findTestObject('MTC_02/Page_MentorUS Dashboard/Page_MentorUS Dashboard/Page_MentorUS Dashboard/invalidMessage'), 
                    message)
            } else if (status == 'existing') {
                WebUI.verifyElementText(findTestObject('MTC_02/emptyAlert'), message)
            } else {
                WebUI.verifyElementVisible(findTestObject('MTC_02/Page_MentorUS Dashboard/uploadFileIcon'), FailureHandling.STOP_ON_FAILURE)

                WebUI.click(findTestObject('MTC_02/Page_MentorUS Dashboard/btnXacNhan'))

                WebUI.waitForElementNotPresent(findTestObject('MTC_01/loader'), 0)

                WebUI.verifyElementText(findTestObject('MTC_02/Page_MentorUS Dashboard/Page_MentorUS Dashboard/Page_MentorUS Dashboard/invalidMessage'), 
                    message)

                WebUI.delay(2)
            }
        }
    }
} else {
    if (data !== 'empty') {
        WebUI.setText(findTestObject('MTC_02/Page_MentorUS Dashboard/inputMail'), data)

        WebUI.sendKeys(findTestObject('MTC_02/Page_MentorUS Dashboard/inputMail'), Keys.chord(Keys.ENTER))

        if (invalidEmail == 'true') {
            WebUI.verifyElementText(findTestObject('MTC_02/Page_MentorUS Dashboard/Page_MentorUS Dashboard/Page_MentorUS Dashboard/invalidMessage'), 
                message)

            return null
        }
    }
    
    WebUI.click(findTestObject('MTC_02/Page_MentorUS Dashboard/btnXacNhan'))
}

WebUI.waitForElementNotPresent(findTestObject('MTC_01/loader'), 0)

if (((type !== 'file') && (status == 'fail')) && (data !== '')) {
    WebUI.verifyElementText(findTestObject('MTC_02/Page_MentorUS Dashboard/Page_MentorUS Dashboard/Page_MentorUS Dashboard/invalidMessage'), 
        message)
}

if ((data == '') && (type !== 'file')) {
    WebUI.verifyElementText(findTestObject('MTC_02/emptyAlert'), message)
}

if (end == 'true') {
    WebUI.closeBrowser()
}

