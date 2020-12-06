
import PageList.BottomPanel;
import PageList.BugsList;
import infrastructure.TestServer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class Tests extends TestBase {

    @Test
    public void firstBugCheck(){
        BugsList bugsList = new BugsList(driver);
        bugsList.openPage(TestServer.getUrl());
        bugsList.findFirstBug();

        assertThat(bugsList.getFirstBugName(), equalTo("First Bug"));
    }

    @Test
    public void addBug(){
        BugsList bugsList = new BugsList(driver);
        bugsList.openPage(TestServer.getUrl());

        BottomPanel panel = new BottomPanel(driver);
        panel.clickOnAddButton();

        BugsList bug = new BugsList(driver);
        bug.populateBugName("OhrimBug");

        assertThat(bugsList.getNewBugName(), equalTo("OhrimBug"));
    }

}
