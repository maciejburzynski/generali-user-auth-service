package com.generali.userauthservice.user.xml;

import jakarta.annotation.PostConstruct;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class UserXmlService {



    void testXmlCreation() throws JAXBException {

        ArrayList<UserXml> userXmlList = new ArrayList<>();
        UserXml userXml = new UserXml("user", "password", "user@gmail.com");
        UserXml userXml1 = new UserXml("admin", "password", "user@gmail.com");
        UserXml userXml2 = new UserXml("superadmin", "password", "user@gmail.com");

        log.info(userXml.toString());

        userXmlList.add(userXml);
        userXmlList.add(userXml1);
        userXmlList.add(userXml2);

        UserXmlList list = new UserXmlList();
        list.setUserXmlArrayList(userXmlList);



        JAXBContext context = JAXBContext.newInstance(UserXmlList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(list, new File("./user-list.xml"));
        log.info("Marshalled!");


    }

    UserXmlList testXmlConsuming() throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(UserXmlList.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (UserXmlList) unmarshaller.unmarshal(new FileReader("./user-list.xml"));
    }

    @PostConstruct
    void logUserXml() throws JAXBException, IOException {
        log.info("Users' list: {}", testXmlConsuming().toString());
    }
}
