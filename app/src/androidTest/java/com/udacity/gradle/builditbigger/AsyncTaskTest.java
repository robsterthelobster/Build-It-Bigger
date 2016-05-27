package com.udacity.gradle.builditbigger;

import android.test.ActivityInstrumentationTestCase2;
import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import com.udacity.gradle.builditbigger.gce.EndpointsAsyncTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class AsyncTaskTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;

    public AsyncTaskTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        activity = getActivity();
    }

    @MediumTest
    public void testEndpointsAsyncTaskResult(){
        EndpointsAsyncTask task = new EndpointsAsyncTask();
        task.execute(activity);

        String result = "";
        try {
            result = task.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        assertTrue(!result.equals(null));
        assertTrue(!result.equals(""));


    }
}