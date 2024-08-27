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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import internal.GlobalVariable as GlobalVariable
import java.time.LocalTime as LocalTime
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import org.openqa.selenium.Keys as Keys

if (first == 'true') {
    WebUI.callTestCase(findTestCase('Requirements/TR-003 Navigate to specific chat channel'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
    WebUI.refresh()

    WebUI.click(findTestObject('MTC_03/Page_MentorUS Dashboard/Page_MentorUS Dashboard/generalChat'))

    WebUI.click(findTestObject('Object Repository/MTC_03/Page_MentorUS Dashboard/svg'))
}

WebUI.setText(findTestObject('Object Repository/MTC_03/Page_MentorUS Dashboard/Page_MentorUS Dashboard/inputTitle'), title)

WebUI.setText(findTestObject('Object Repository/MTC_03/Page_MentorUS Dashboard/Page_MentorUS Dashboard/textareaDescription'), 
    description)
DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern('h:mm a')

if(start !== "empty") {
	LocalTime startTime = LocalTime.now().plusMinutes(Integer.parseInt(start))
	
	String formattedStartTime = startTime.format(timeFormatter)
	
	String[] startparts = formattedStartTime.split('[: ]')
	
	TestObject start_input = findTestObject('MTC_03/Page_MentorUS Dashboard/Page_MentorUS Dashboard/Page_MentorUS Dashboard/Page_MentorUS Dashboard/inputTimeStart')
	
	for(int i = 0; i < 3;i++) {
		if(startparts[i].length() == 1) {
			startparts[i] = '0' + startparts[i];
		}
	}
	WebUI.click(start_input)
	
	WebUI.sendKeys(start_input, startparts[0])
	
	WebUI.sendKeys(start_input, startparts[1])
	
	WebUI.sendKeys(start_input, startparts[2])
}

if(end !== "empty") {
	LocalTime endTime = LocalTime.now().plusMinutes(Integer.parseInt(end))
	
	String formattedEndTime = endTime.format(timeFormatter)
	
	String[] endparts = formattedEndTime.split('[: ]')
	
	for(int i = 0; i < 3;i++) {
		if(endparts[i].length() == 1) {
			endparts[i] = '0' + endparts[i];
		}
	}
	
	TestObject end_input = findTestObject('MTC_03/Page_MentorUS Dashboard/Page_MentorUS Dashboard/Page_MentorUS Dashboard/Page_MentorUS Dashboard/inputTimeEnd')
	
	WebUI.click(end_input)
	
	WebUI.sendKeys(end_input, endparts[0])
	
	WebUI.sendKeys(end_input, endparts[1])
	
	WebUI.sendKeys(end_input, endparts[2])
}

LocalDate currentDate
if (date !== "empty") {
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern('dd/MM/yyyy')

	
	if (date.equals('expired') || date.equals('expiredOne')) {
		String originalWindow = WebUI.getWindowIndex()
	
		// Open a new tab
		WebUI.executeJavaScript('window.open(\'http://localhost:3000/admin/groups\', \'_blank\');', null)
	
		WebUI.switchToWindowIndex(1)
	
		WebUI.click(findTestObject('Object Repository/Page_MentorUS Dashboard/span_MTC3'))
	
		String expiredDate = WebUI.getText(findTestObject('Object Repository/Page_MentorUS Dashboard/strong_31082024'))
	
		WebUI.switchToWindowIndex(originalWindow)
	
		currentDate = LocalDate.parse(expiredDate, dateFormatter)
	
		if (date.equals('expiredOne')) {
			LocalDate tmp = currentDate.plusDays(1)
	
			currentDate = tmp
		}
	} else {
		currentDate = LocalDate.now().plusDays(Integer.parseInt(date))
	}
	
	String formattedDate = currentDate.format(dateFormatter)
	
	String[] date_pattern = formattedDate.split('/')
	
	TestObject date = findTestObject('MTC_03/Page_MentorUS Dashboard/Page_MentorUS Dashboard/Page_MentorUS Dashboard/Page_MentorUS Dashboard/inputDate')
	
	WebUI.click(date)
	
	WebUI.sendKeys(date, date_pattern[0])
	
	WebUI.sendKeys(date, date_pattern[1])
	
	WebUI.sendKeys(date, date_pattern[2])
	
}

WebUI.setText(findTestObject('Object Repository/MTC_03/Page_MentorUS Dashboard/Page_MentorUS Dashboard/inputPlace'), place)

WebUI.click(findTestObject('Object Repository/MTC_03/Page_MentorUS Dashboard/Page_MentorUS Dashboard/divAttendee'))

// JavaScript code as a String
String jsCode = '\r\n// Lựa chọn div root\r\nconst rootDiv = document.querySelector(\'.MuiInputBase-root.MuiOutlinedInput-root.MuiInputBase-colorPrimary.MuiInputBase-fullWidth.MuiInputBase-formControl.MuiInputBase-adornedStart.MuiInputBase-adornedEnd.MuiAutocomplete-inputRoot.css-1di4za5-MuiInputBase-root-MuiOutlinedInput-root\');\r\n\r\n// Đếm số lượng div con bên trong div root với class đã cho\r\nconst count = rootDiv.querySelectorAll(\'.MuiButtonBase-root.MuiChip-root.MuiChip-filled.MuiChip-sizeMedium.MuiChip-colorDefault.MuiChip-deletable.MuiChip-deletableColorDefault.MuiChip-filledDefault.MuiAutocomplete-tag.MuiAutocomplete-tagSizeMedium.css-1pjwiaj-MuiButtonBase-root-MuiChip-root\').length;\r\n\r\nconsole.log(\'Số lượng thẻ div con:\', count);\r\nreturn count;\r\n'

// Execute the JavaScript code in the browser
Integer count = WebUI.executeJavaScript(jsCode, null)

WebUI.click(findTestObject('MTC_03/Page_MentorUS Dashboard/Page_MentorUS Dashboard/inputAttendee'))

WebUI.click(findTestObject('Object Repository/MTC_03/Page_MentorUS Dashboard/Page_MentorUS Dashboard/svgDeleteAll'))

if (mode == 'half') {
    count = (count / 2)
} else if (mode == 'zero') {
    count = 0
} else if (mode == 'one') {
    count = 1
}

for (int i = 0; i < count; i++) {
    if (i != 0) {
        WebUI.sendKeys(findTestObject('Object Repository/MTC_03/Page_MentorUS Dashboard/Page_MentorUS Dashboard/inputAttendee'), 
            Keys.chord(Keys.DOWN))
    }
    
    WebUI.sendKeys(findTestObject('Object Repository/MTC_03/Page_MentorUS Dashboard/Page_MentorUS Dashboard/inputAttendee'), 
        Keys.chord(Keys.DOWN))

    WebUI.sendKeys(findTestObject('Object Repository/MTC_03/Page_MentorUS Dashboard/Page_MentorUS Dashboard/inputAttendee'), 
        Keys.chord(Keys.ENTER))
}

WebUI.delay(1)

WebUI.doubleClick(findTestObject('Page_MentorUS Dashboard/button_To lch hn'), FailureHandling.STOP_ON_FAILURE)
if(mode == "all") {
	WebUI.doubleClick(findTestObject('Page_MentorUS Dashboard/button_To lch hn'), FailureHandling.STOP_ON_FAILURE)
}

if (type == 'fail') {
	
	
    if (((((title == '') || (mode == 'zero')) || (Integer.parseInt(start) < 0)) || (Integer.parseInt(end) < 0)) || (Integer.parseInt(
        start) >= Integer.parseInt(end)) || title.length() >= 100 || description.length() >= 250 || place.length() >= 150) {
        if (title == '') {
            WebUI.verifyTextPresent('Vui lòng nhập tiêu đề', false)
        }
		if(title.length() >= 100) {
			WebUI.verifyTextPresent('Tiêu đề không được vượt quá 100 ký tự', false)
		}
		
		if(description.length() >= 250) {
			WebUI.verifyTextPresent('Mô tả không được vượt quá 250 ký tự', false)
		}
		
		if(place.length() >= 150) {
			WebUI.verifyTextPresent('Địa điểm không được vượt quá 150 ký tự', false)
		}
		if(title.length() >= 100) {
			WebUI.verifyTextPresent('Tiêu đề không được vượt quá 100 ký tự', false)
		}
		
		if(description.length() > 250) {
			WebUI.verifyTextPresent('Mô tả không được vượt quá 250 ký tự', false)
		}
		
		if(place.length() >= 150) {
			WebUI.verifyTextPresent('Địa điểm không được vượt quá 150 ký tự', false)
		}
        
        if (currentDate == LocalDate.now()) {
            if (start !=="empty" && end!=="" && LocalTime.now().plusMinutes(Integer.parseInt(start)) >= LocalTime.now().plusMinutes(Integer.parseInt(end))) {
                WebUI.verifyTextPresent('Giờ kết thúc phải luôn lớn hơn giờ bắt đầu', false)
            }
            
            if (mode == 'zero') {
                WebUI.verifyTextPresent('Vui lòng chọn người tham gia lịch hẹn', false)
            }
            
            if (end !== "empty" && LocalTime.now().plusMinutes(Integer.parseInt(end)) <= LocalTime.now() && LocalTime.now().plusMinutes(Integer.parseInt(start)) < LocalTime.now().plusMinutes(Integer.parseInt(end))) {
                WebUI.verifyTextPresent('Giờ kết thúc phải lớn hơn giờ hiện tại', false)
            }
            
            if (start !== "empty" && LocalTime.now().plusMinutes(Integer.parseInt(start)) <= LocalTime.now() && LocalTime.now().plusMinutes(Integer.parseInt(start)) < LocalTime.now().plusMinutes(Integer.parseInt(end))) {
                WebUI.verifyTextPresent('Giờ bắt đầu phải lớn hơn giờ hiện tại', false)
            }
        } else if (date !=="empty" && currentDate < LocalDate.now()) {
            WebUI.verifyTextPresent('Ngày hẹn phải lớn hơn hoặc bằng ngày hiện tại', false)
        }
    } else {
        WebUI.verifyTextPresent('Tạo lịch hẹn thất bại', false)
    }
} else {
    WebUI.verifyTextPresent('Tạo lịch hẹn thành công', false)
}

WebUI.delay(2)

if (end == 'true') {
    WebUI.closeBrowser()
}

