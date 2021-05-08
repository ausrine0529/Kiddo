package com.example.edukacine2;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }
    @Test
    public void testLaunch(){
        View view = mActivity.findViewById(R.id.editText);
        View view2 = mActivity.findViewById(R.id.editText2);
        View view3 = mActivity.findViewById(R.id.exit);
        View view4 = mActivity.findViewById(R.id.textView);
        View view5 = mActivity.findViewById(R.id.registryTitle);
        View view6 = mActivity.findViewById(R.id.button);

        assertNotNull(view);
        assertNotNull(view2);
        assertNotNull(view3);
        assertNotNull(view4);
        assertNotNull(view5);
        assertNotNull(view6);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}
