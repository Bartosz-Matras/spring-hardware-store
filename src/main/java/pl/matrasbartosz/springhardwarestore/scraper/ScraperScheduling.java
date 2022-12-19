package pl.matrasbartosz.springhardwarestore.scraper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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

    @PostConstruct
    public void onStartup() {
        new Thread(wrapperNarzedzia::startWrap).start();
        new Thread(wrapperDomitech::startWrap).start();
    }

    @Async
    @Scheduled(cron = "0 0 8 * * MON")
    public void scrappPageOne() {
        wrapperNarzedzia.startWrap();
    }

    @Async
    @Scheduled(cron = "0 0 8 * * MON")
    public void scrappPageTwo() {
        wrapperDomitech.startWrap();
    }

}
