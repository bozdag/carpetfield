package com.carpetfield.server.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.StringJoiner;

/**
 * Created by selcukb on 08.03.2017.
 */
public class Organization implements Serializable
{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    public Organization()
    {
    }

    public  Organization(String orgName)
    {
        name = orgName;
    }

    public Organization(String orgName, String orgDescription)
    {
        name = orgName;
        description = orgDescription;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        StringJoiner sj = new StringJoiner(":");
        sj.add(name);
        sj.add(description);
        return sj.toString();
    }
}
