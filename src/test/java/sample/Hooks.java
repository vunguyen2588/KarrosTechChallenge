package sample;

import cucumber.api.java.After;

public class Hooks extends Driver{
	@After
    public void afterScenario(){
        obj.quit();
    }
}
