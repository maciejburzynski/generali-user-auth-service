package com.generali.userauthservice.user.xml;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@XmlRootElement(name = "userList")
@XmlSeeAlso(UserXml.class)
@Slf4j
public class UserXmlList {

    private ArrayList<UserXml> userXmlArrayList;

    @XmlElement(name = "user")
    public ArrayList<UserXml> getUserXmlArrayList() {
        return userXmlArrayList;
    }

    public void setUserXmlArrayList(ArrayList<UserXml> userXmlArrayList) {
        this.userXmlArrayList = userXmlArrayList;
    }

    @Override
    public String toString() {
        return "UserXmlList{" +
                "userXmlArrayList=" + userXmlArrayList +
                '}';
    }
}
