package com.endava.util;

import org.openqa.selenium.WebDriver;

public class Switch {
	static WebDriver driver;
	public static String switchToChildWindow() {
		String parentWindow = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			System.out.println(winHandle);
			if (!parentWindow.equals(winHandle)) {
				driver.switchTo().window(winHandle);
			}
		}
		return parentWindow;
	}

	public static void switchBackToParentWindow(String parentWindow) {
		driver.close();
		driver.switchTo().window(parentWindow);
	}

}
