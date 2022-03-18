# Hive-authentication
Add possibility of custom authentication on jdbc engine compatible with hive.

Add this jar to the hive lib classpath and then in the engine add:

```

       </property>
           <property>
          <name>metastore.authentication</name>
          <value>CUSTOM</value>
        </property>
           <property>
          <name>metastore.custom.authentication.class</name>
          <value>fr.insee.lab.hive.SimpleAuthenticationProviderImpl</value>
        </property>

```

### Features

- [x] Just give an example based on an inmemory username hiveuser password hive

### Possible features 

- [ ] Can add username password base on bcrypt file content available on the host or in a conf property 
- [ ] Can add username password with password being a jwt token 
- [ ] Can add username password with password being a jwt tojken with expiration to refresh ( not sur if possible and how)

### Authentication

Users can next authenticate throught jdbc url via beeline or jdbc client.

### Authorization

In hive the authorization mechanism is handle by another process of the authentication one. Authorization is describe here:

https://cwiki.apache.org/confluence/display/Hive/LanguageManual+Authorization

Majors alternatives are:

handle by hivemetastore:
- Storage Based Authorization protection rules based on HDFS permission of the user on the location of the hive table. But be aware that it seems that this mechanism is coupled to kerberos not sur how to use or reimplement if cloud storage is s3.
However, with some work this mechanism is made by a pre.event.listener on the metastore where we could also inject our custom logic.

handle by the engine:
- SQL Standard base but then authorization is handle by the engine.
- Ranger plugin that continously pull policy from a central management of user policy for the hive service.

### Limits

This point to hive2.x for the moment and need java8.

### Contributing

launch init.sh in visualStudio code of onyxia.


