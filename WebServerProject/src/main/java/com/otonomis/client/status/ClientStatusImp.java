package com.otonomis.client.status;

import com.otonomis.client.beans.ClientDetails;
import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ClientStatusImp implements ClientStatus {
	
	  Logger logger = Logger.getLogger(ClientStatusImp.class);


	public int saveClientInformation(ClientDetails detail) {
		// TODO Auto-generated method stub
	    String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);
        ///logger.debug("this is a debug log message");
        logger.info(detail.getIp());
        logger.info(detail.getDatetime());
        logger.info(detail.getMessage());
       /// logger.warn("this is a warning log message");
        return 1;
	}

}
