package nl.thijs.hendriks.jeejumeskaraoke;

import com.intuit.karate.junit5.Karate;

class JeejUnEsTest {
    
    @Karate.Test
    Karate testJMS() {
        return Karate.run().relativeTo(getClass());
    }    

}
