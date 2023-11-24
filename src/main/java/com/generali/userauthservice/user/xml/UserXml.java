package com.generali.userauthservice.user.xml;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDateTime;


@XmlRootElement(name = "user")
@XmlType(propOrder = {"sentAt", "username", "mail"})
@XmlSeeAlso(UserXmlList.class)
public class UserXml {
//    NO ARGS CONSTRUCTOR REQUIRED

    private String username;
    private String password;
    private String mail;
    private LocalDateTime sentAt;

    public String getUsername() {
        return username;
    }

    @XmlElement(name = "username")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    @XmlElement(name = "mail")
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    @XmlTransient
    public void setPassword(String password) {
        this.password = password;
    }
    public UserXml(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.sentAt = LocalDateTime.now();
    }

    public UserXml() {
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    @XmlElement(name = "sentAt")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setSentAt(LocalDateTime date) {
        this.sentAt = date;
    }

    @Override
    public String toString() {
        return "UserXml{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", sentAt=" + sentAt +
                '}';
    }
}
