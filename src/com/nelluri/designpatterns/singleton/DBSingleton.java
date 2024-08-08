package com.nelluri.designpatterns.singleton;

/*
Article discussed here:
https://medium.com/@abhishek.talakeriv/java-singleton-design-pattern-commonly-asked-interview-questions-e0fb5e899578
 */

public class DBSingleton {

    private static DBSingleton instance;

    private DBSingleton(){
        // Make the constructor as private so that object cannot be initialized from outside.
    }

    // not thread safe
    public static DBSingleton getInstance() {
        if(instance == null) {
            instance = new DBSingleton();
        }
        return instance;
    }

    /*


    //make method as synchronized to make it thread safe.
    //But this is not performant.
    public static synchronized DBSingleton getInstance() {
        if(instance == null) {
            instance = new DBSingleton();
        }
        return instance;
    }


    // To make it performant. Double Lock checking.
    public static DBSingleton getInstance() {
        if(instance == null) {
            synchronized(DBSingleton.class) {
                if(instance == null) {
                    instance = new DBSingleton();
                }
            }
        }
        return instance;
    }


     */

    /*
    Singleton can still fail in following scenarios:
    1. Reflection. ( Using reflection, we can make constructor as accessible and create object).
    2. Serialization and deserialization.
    3. Cloning the object.
     */

    /* Prevent reflection from breaking singleton.
        private DBSingleton() {
            if(DBSingleton.instance != null) {
            throw Exception("Object already exists for singleton");
        }


     */


    /*
    if we clone an instance of our Singleton class, a new instance will be created, consequently violating the Singleton pattern.

    To prevent cloning from breaking this:

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // returns existing clone instance only.
    }

     */

}
