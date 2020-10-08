package nl.thijs.hendriks.jeejumeskaraoke;

import com.intuit.karate.junit5.Karate;

class JeejUnEsRunner {
    
    @Karate.Test
    Karate testUsers() {
        return Karate.run("jms").relativeTo(getClass());
    }    

}
