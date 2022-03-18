package fr.inseelab.hive;

import java.util.HashMap;
import java.util.Map;

import org.apache.hive.service.auth.PasswdAuthenticationProvider;
import javax.security.sasl.AuthenticationException;


public class SimpleAuthenticationProviderImpl implements PasswdAuthenticationProvider {

    private Map<String, String> userMap = new HashMap<String, String>();

    public SimpleAuthenticationProviderImpl() {
      init();
    }

    private void init(){
      userMap.put("hiveuser","hive");
    }

    @Override
    public void Authenticate(String user, String password) throws AuthenticationException {

      if(!userMap.containsKey(user)){
        throw new AuthenticationException("Invalid user : "+user);
      }
      if(!userMap.get(user).equals(password)){
        throw new AuthenticationException("Invalid passwd : "+password);
      }
    }
  }