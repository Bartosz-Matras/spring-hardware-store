package pl.matrasbartosz.springhardwarestore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.matrasbartosz.springhardwarestore.dao.ScrapperProductPageOneRepository;
import pl.matrasbartosz.springhardwarestore.dao.ScrapperProductPageTwoRepository;
import pl.matrasbartosz.springhardwarestore.entity.ScrapperProductPageOne;
import pl.matrasbartosz.springhardwarestore.entity.ScrapperProductPageTwo;

@Service
public class ScrapperProductServiceImpl implements ScrapperProductService{

    private final ScrapperProductPageOneRepository scrapperProductPageOneRepository;
    private final ScrapperProductPageTwoRepository scrapperProductPageTwoRepository;

    @Autowired
    public ScrapperProductServiceImpl(ScrapperProductPageOneRepository scrapperProductPageOneRepository,
                                    ScrapperProductPageTwoRepository scrapperProductPageTwoRepository){
        this.scrapperProductPageOneRepository = scrapperProductPageOneRepository;
        this.scrapperProductPageTwoRepository = scrapperProductPageTwoRepository;
    }

    @Override
    @Transactional
    public void saveScrapperProductOne(ScrapperProductPageOne scrapperProductPageOne){
        scrapperProductPageOneRepository.save(scrapperProductPageOne);
    }

    @Override
    @Transactional
    public ScrapperProductPageOne getScrapperProductOne(String sku){
        return scrapperProductPageOneRepository.getScrapperProductPageOneBySku(sku);
    }

    @Override
    @Transactional
    public void saveScrapperProductTwo(ScrapperProductPageTwo scrapperProductPageTwo){
        scrapperProductPageTwoRepository.save(scrapperProductPageTwo);
    }

    @Override
    @Transactional
    public ScrapperProductPageTwo getScrapperProductTwo(String sku){
        return scrapperProductPageTwoRepository.getScrapperProductPageTwoBySku(sku);
    }
}
