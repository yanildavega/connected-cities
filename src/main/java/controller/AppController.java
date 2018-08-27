package controller;


import domain.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.ConnectedComponent;

@RestController
public class AppController {
    private static final Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    ConnectedComponent conn;


    @RequestMapping(value = "/connected", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean connected(Request request) {

       logger.info("Request",request);
       return conn.isConnected(request.getCity1(),request.getCity2());


    }


}
