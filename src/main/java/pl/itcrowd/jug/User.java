package pl.itcrowd.jug;

import java.io.Serializable;
import java.util.logging.Logger;


public class User implements Serializable {



    private int id;
    private String name;
    private String surname;
    private int dateBirth;

    private static final Logger LOGGER = Logger.getLogger(User.class.getCanonicalName());

    public User()
    {
    }

    public User(Integer id, String name, String surname, int dateBirth)
    {
        this.id = id;
        this.name=name;
        this.surname=surname;
        this.dateBirth=dateBirth;
    }

    public String getName() {

        LOGGER.info("HelloBean->getName()");
        return name;
    }

    public void setName(String name) {

        LOGGER.info("HelloBean->setName()");
        this.name = name;
    }

    public String getSurname() {

        LOGGER.info("HelloBean->getSurname()");
        return surname;
    }

    public void setSurname(String surname) {

        LOGGER.info("HelloBean->setSurname()");
        this.surname = surname;
    }

    public int getDateBirth() {
        LOGGER.info("HelloBean->getDateBirth()");
        return dateBirth;
    }

    public void setDateBirth(int dateBirth) {
        LOGGER.info("HelloBean->setDateBirth()");
        this.dateBirth = dateBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

