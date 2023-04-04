from appium import webdriver
from appium.webdriver.common.appiumby import AppiumBy
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
import time


class CheckHW:
    MAIN_ACTIVITY = '.MainActivity'
    EXECUTOR = 'http://127.0.0.1:4723/wd/hub'
    ANDROID_BASE_CAPS = {
        'app': 'app-debug.apk',  # path to the app package
        'automationName': 'UIAutomator2',
        'platformName': 'Android',
        'platformVersion': '13.0',  # platform version of emulator or device where app will be tested
        'deviceName': 'Android Emulator',
        'allowTestPackages': 'true',  # add -t flags to adb command when install the app package
        'enforceAppInstall': 'true',
        'uiautomator2ServerInstallTimeout': 20000,
        'adbExecTimeout': 20000,
        'clearDeviceLogsOnStart': 'true'
    }

    def __init__(self, appLocation, platformVersion='12.0'):
        self.ANDROID_BASE_CAPS['app'] = appLocation
        self.ANDROID_BASE_CAPS['platformVersion'] = platformVersion
        self.driver = webdriver.Remote(
            command_executor=self.EXECUTOR,
            desired_capabilities=self.ANDROID_BASE_CAPS
        )
        self.driver.implicitly_wait(10)

    def press_home(self):
        self.driver.press_keycode(3)  # keycode HOME

    def test(self, sleep_time):
        # logtypes = self.driver.log_types
        # print(' ,'.join(logtypes)) #
        try:
            wait = WebDriverWait(self.driver, 10)
            button = wait.until(EC.element_to_be_clickable((By.ID, 'button')))
            # button = self.driver.find_element(AppiumBy.ID, 'button')
            button.click()

            time.sleep(sleep_time)  # wait a second for log

            click_msg = 'Like clicked!'
            logs = self.driver.get_log('logcat')
            log_messages = [log['message'] for log in logs[-9:] if log['message'].find(click_msg) >= 0]
            print(log_messages)
            if len(log_messages) > 0:
                return 'OK'
            else:
                return f'Failed - logcat에 {click_msg} 없음'
        except:
            return '버튼 ID button 오류'

    def scroll_capture(self, id=""):
        self.driver.save_screenshot(f'{id}-scroll1.png')
        # swipe(startX, startY, endX, endY, duration)
        self.driver.swipe(150, 600, 150, 100, 100)
        self.driver.swipe(150, 600, 150, 100, 100)
        return self.driver.save_screenshot(f'{id}-scroll2.png')


if __name__ == '__main__':
    # 테스트할 APK 파일의 위치
    DEF_APP_LOCATION = r'C:\git\study\android\2023-android-lecture\week5\task\app\build\outputs\apk\debug\app-debug.apk'
    ANDROID_VERSION = '13.0'

    chw = CheckHW(DEF_APP_LOCATION, ANDROID_VERSION)
    r = chw.test(0.1)  # 버튼 누르고 0.1초 대기 후 로그를 확인
    print(r)
    chw.scroll_capture("학번")
