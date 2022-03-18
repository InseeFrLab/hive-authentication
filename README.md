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

- [x] Just five an example based on username hiveuser password hive

### Features possible 

- [ ] Can add username password base on bcrypt file content available on the host or in a conf property 
- [ ] Can add username password with password being a jwt token
- [ ] Can add username password with password being a jwt refreshtoken

### Authentication

Users can next authenticate throught jdbc url via beeline or jdbc client.

### Authorization

In hive the authorization mecanism is handle by another process of authentication describe here:

https://cwiki.apache.org/confluence/display/Hive/LanguageManual+Authorization

Majors alternatives are:
- Storage Based Authorization protection rules based on HDFS permission of the user on the location of the hive table. But be aware that it seems that this mecanism is coupled to kerberos not sur how to use or reimplement if cloud storage is s3.
- SQL Standard base but then authorization is handle by the engine.
- Ranger plugin that continously pull policy from a central management of user policy for the hive service.

### Limits

This point to hive2.x for the moment and need java8.

### Contributing

launch init.sh in visualStudio code of onyxia.


