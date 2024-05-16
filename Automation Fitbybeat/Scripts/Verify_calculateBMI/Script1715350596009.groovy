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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.openBrowser('https://fitbybeat.com/')

def height = "188"

def weight = "76"

def age = "24"

def weightStatValue

def weightStat

WebUI.setText(findTestObject('input_height'), height)

WebUI.setText(findTestObject('input_weight'), weight)

WebUI.setText(findTestObject('input_age'), age)

WebUI.click(findTestObject('input_sex'))

WebUI.click(findTestObject('select_male'))

WebUI.click(findTestObject('input_activity'))

WebUI.click(findTestObject('select_lilttleOrno'))

WebUI.click(findTestObject('btn_calculate'))

def weightInt = weight as Integer 

def heightInt = height as Integer


weightStatValue = weightInt / ((heightInt * heightInt)/10000)
//KeywordUtil.logInfo(weightStatValue)

if (weightStatValue < 18.5) {
    weightStat = 'YOU ARE UNDERWEIGHT!'
} else if ((weightStatValue >= 18.5) && (weightStatValue < 25)) {
    weightStat = 'YOU ARE HEALTHY! '
} else if ((weightStatValue >= 25) && (weightStatValue < 30)) {
    weightStat = 'YOU ARE OVERWEIGHT!'
} else if (weightStatValue >= 30) {
    weightStat = 'YOU ARE OBESE!'
}

def result = WebUI.getText(findTestObject('text_result'))
KeywordUtil.logInfo(weightStat)

if (weightStat != result){
	KeywordUtil.markFailed("Didn't match value Weigh Status")
} else {
	KeywordUtil.markPassed("Success")
}


