package pl.matrasbartosz.springhardwarestore.scraper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class ScraperScheduling {

    private final WrapperNarzedzia wrapperNarzedzia;
    private final WrapperDomitech wrapperDomitech;

    @Autowired
    public ScraperScheduling(WrapperNarzedzia wrapperNarzedzia, WrapperDomitech wrapperDomitech){
        this.wrapperNarzedzia = wrapperNarzedzia;
        this.wrapperDomitech = wrapperDomitech;
    }


    @Async
    @Scheduled(cron = "0 0 8 * * MON")
//    @Scheduled(fixedDelay = 1000000)
    public void scrappPageOne() {
        wrapperNarzedzia.startWrap();
    }



    @Async
    @Scheduled(cron = "0 0 8 * * MON")
//    @Scheduled(fixedDelay = 1000000)
    public void scrappPageTwo() {
        wrapperDomitech.startWrap();
    }

}
