package ru.bk.akadnikov.tests;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ru.bk.akadnikov.tests.MarketNotebook;
import ru.bk.akadnikov.tests.MarketTablet;
import ru.stqa.selenium.factory.WebDriverPool;

@RunWith(Suite.class)
@SuiteClasses({MarketNotebook.class, MarketTablet.class})
public class AllTestSuite {

    @Rule
    public TestRule webDriverPool = new TestWatcher() {
        @Override
        protected void finished(Description description) {
            super.finished(description);
            WebDriverPool.DEFAULT.dismissAll();

        };
    };
}
