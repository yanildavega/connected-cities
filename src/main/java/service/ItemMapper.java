package service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import util.ProcessFile;

/**
 * Created by yanildamartinez
 */
@Service
public class ItemMapper {


    @PostConstruct
    public void init(){


        ProcessFile.populateGraph();
        ConnectedComponent.loadGraph();

    }

}
