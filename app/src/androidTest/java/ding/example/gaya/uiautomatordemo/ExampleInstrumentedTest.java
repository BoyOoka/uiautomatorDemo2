package test.com.example.administrator.test;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private static final String BASIC_SAMPLE_PACKAGE
            = "com.bianla.app";
    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String STRING_TO_BE_TYPED = "UiAutomator";
    static UiDevice mDevice;

    @BeforeClass
    public static void open() {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();
        startAPP(BASIC_SAMPLE_PACKAGE);
        try {
            UiObject skip = mDevice.findObject(new UiSelector().resourceId("com.bianla.app:id/skip_tv"));
            skip.click();
        } catch (UiObjectNotFoundException e) {
            Log.e("open", e.getMessage());
        }

    }

    @AfterClass
    public static void colse() {
        closeAPP(mDevice, BASIC_SAMPLE_PACKAGE);
    }

    private static void startAPP(String sPackageName) {
        Context mContext = InstrumentationRegistry.getContext();
        Intent myIntent = mContext.getPackageManager().getLaunchIntentForPackage(sPackageName);  //通过Intent启动app
        mContext.startActivity(myIntent);
        try {
            Thread.sleep(7800);
        } catch (Exception e) {

        }
    }

    private static void closeAPP(UiDevice uiDevice, String sPackageName) {
        try {
            uiDevice.executeShellCommand("am force-stop " + sPackageName);//通过命令行关闭app
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void visitor_add() {
        // Context of the app under test.
        //添加访客女
        try {
            mDevice.waitForIdle(5000);
            UiObject iv_user = mDevice.findObject(new UiSelector().resourceId("com.bianla.app:id/iv_user"));
            iv_user.click();
            UiObject add_user = mDevice.findObject(new UiSelector().text("添加访客"));
            add_user.click();
            UiObject nick = mDevice.findObject(new UiSelector().resourceId("com.bianla.app:id/et_nick"));
            UiObject age = mDevice.findObject(new UiSelector().resourceId("com.bianla.app:id/age_tv"));
            UiObject height = mDevice.findObject(new UiSelector().resourceId("com.bianla.app:id/height"));
            UiObject phone = mDevice.findObject(new UiSelector().resourceId("com.bianla.app:id/phone"));
            UiObject submit = mDevice.findObject(new UiSelector().resourceId("com.bianla.app:id/signup_commit"));
            nick.setText("auto访客女");
            age.setText("25");
            height.click();
//            UiObject height_ruler = mDevice.findObject(new UiSelector().resourceId("com.bianla.app:id/ruler_height"));
            UiObject confirm = mDevice.findObject(new UiSelector().resourceId("com.bianla.app:id/confirm"));
            confirm.click();
            phone.setText("13281549858");
            submit.click();
            //访客男
            UiObject male_visitor = mDevice.findObject(new UiSelector().resourceId("com.bianla.app:id/male_icon"));
            add_user.click();
            male_visitor.click();
            nick.setText("auoro访客男");
            age.setText("34");
            height.click();
            confirm.click();
            phone.setText("13284858954");
            submit.click();

        } catch (UiObjectNotFoundException e) {
            Log.e("visitor", e.getMessage());
        }

    }

    @Test
    public void visitor_delete() {
        try {
            UiObject famle = mDevice.findObject(new UiSelector().text("auto访客女"));
            UiObject male = mDevice.findObject(new UiSelector().text("auto访客男"));
            UiObject manage = mDevice.findObject(new UiSelector().resourceId("com.bianla.app:id/text"));
            manage.click();
            UiObject dele = null;
//            UiObject dele = mDevice.findObject(new UiSelector().resourceId("com.bianla.app:id/delete").instance(0));
            try {
                do {

                    dele = mDevice.findObject(new UiSelector().resourceId("com.bianla.app:id/delete").instance(0));
                    dele.click();
                    UiObject dele_confirm = mDevice.findObject(new UiSelector().text("删除"));
                    dele_confirm.click();
                } while (dele.isEnabled());
            } catch (UiObjectNotFoundException e) {
                Log.e("dele_confirm", e.getMessage());
//                Log.i("dele_confirm", String.valueOf(dele.isEnabled()));
            }
            UiObject manage_close = mDevice.findObject(new UiSelector().text("确定"));
            manage_close.click();
            UiObject back_homepage = mDevice.findObject(new UiSelector().resourceId("com.bianla.app:id/title_left_bt"));
            back_homepage.click();
        } catch (UiObjectNotFoundException e) {
            Log.e("visitor_delete", e.getMessage());
        }
    }
    @Test
    public void share_one(){

    }

    @Test
    public void share_two(){

    }
    @Test
    public void share_three(){

    }
    @Test
    public void share_four(){

    }
}
