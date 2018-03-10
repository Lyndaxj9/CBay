package com.JUnit.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UserTest.class, ItemTest.class, MessageTest.class, OrderTest.class })

public class AllTests {

}
