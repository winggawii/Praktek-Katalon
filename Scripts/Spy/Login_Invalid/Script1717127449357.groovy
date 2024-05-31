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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Login Valid

'Membuka Web Browser'
WebUI.openBrowser('')
//WebUI.openBrowser(GlobalVariable.URL)
WebUI.maximizeWindow()

'Menampilkan halaman Web - CURA Healthcare'
WebUI.navigateToUrl(GlobalVariable.URL)
WebUI.takeScreenshot()

'Klik menu toggle'
WebUI.click(findTestObject('Object Repository/Spy/a_CURA Healthcare_menu-toggle'))

'Pilih dan klik menu Login'
WebUI.focus(findTestObject('Object Repository/Spy/a_Login'))
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/Spy/a_Login'))

'Input Username dan Password'
//menggunakan variable - value dengan diisi manual
//WebUI.setText(findTestObject('Object Repository/Spy/input_Username_username'), Username)
//WebUI.setText(findTestObject('Object Repository/Spy/input_Password_password'), Password)

//menggunakan variable - value dengan data excel
WebUI.setText(findTestObject('Object Repository/Spy/input_Username_username'), DataUserNameInvalid)
WebUI.setText(findTestObject('Object Repository/Spy/input_Password_password'), DataPasswordInvalid)

WebUI.takeScreenshot()

'Klik button Login'
WebUI.click(findTestObject('Object Repository/Spy/button_Login'))

//verifikasi berhasil tidak login
if(WebUI.verifyElementVisible(findTestObject('Object Repository/Spy/p_Login failed Please ensure the username and password are valid')))
{
	println('Tidak Login Berhasil')
	'Tampilan Tidak Login Berhasil'
}
WebUI.takeScreenshot()

WebUI.delay(GlobalVariable.Waiting)
WebUI.closeBrowser()