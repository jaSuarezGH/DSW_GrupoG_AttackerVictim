package com.ucab.cmcapp.logic.utilities;

import java.util.Properties;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;

public class LdapUserManager {
    private DirContext connection;

    public LdapUserManager() {
        newConnection();
    }

    /* create connection during object creation */
    public void newConnection() {
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
        env.put(Context.SECURITY_PRINCIPAL, "uid=admin, ou=system");
        env.put(Context.SECURITY_CREDENTIALS, "secret");
        try {
            connection = new InitialDirContext(env);
            System.out.println("LDAP connection successful");
        } catch (AuthenticationException ex) {
            System.out.println("LDAP connection could not be made");
            System.out.println(ex.getMessage());
        } catch (NamingException e) {
            System.out.println("LDAP connection could not be made");
            e.printStackTrace();
        }
    }

    public void getAllUsers() throws NamingException {
        String searchFilter = "(objectClass=inetOrgPerson)";
        String[] reqAtt = {"cn", "sn"};
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(reqAtt);

        NamingEnumeration users = connection.search("ou=users,ou=system", searchFilter, controls);

        SearchResult result = null;
        while (users.hasMore()) {
            result = (SearchResult) users.next();
            Attributes attr = result.getAttributes();
            System.out.println(attr.get("cn"));
            System.out.println(attr.get("sn"));
        }

    }

    public void addUser(String username, String password) {
        Attributes attributes = new BasicAttributes();
        Attribute attribute = new BasicAttribute("objectClass");
        attribute.add("inetOrgPerson");

        attributes.put(attribute);
        // user details
        attributes.put("sn", username);
        attributes.put("userPassword", password);
        try {
            connection.createSubcontext("cn=" + username + ",ou=users,ou=system", attributes);
            System.out.println("Successfully added user: " + username);
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }

    }

    public void deleteUser(String username) {
        try {
            connection.destroySubcontext("cn=" + username + ",ou=users,ou=system");
            System.out.println("Successfully deleted the user: " + username);
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            // System.out.println("failed: " + e.getMessage());
        }
    }

    public static boolean authUser(String username, String password) {
        try {
            Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://localhost:10389");
            env.put(Context.SECURITY_PRINCIPAL, "cn=" + username + ",ou=users,ou=system"); // check the DN correctly
            env.put(Context.SECURITY_CREDENTIALS, password);
            DirContext con = new InitialDirContext(env);
            System.out.println("Successfully authenticated the user: " + username);
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Exception at authUser: " + e.getMessage());
            return false;
        }
    }

    public void updateUserPassword(String username, String password) {
        try {
            String dnBase = ",ou=users,ou=system";
            ModificationItem[] mods = new ModificationItem[1];
            // if you want, then you can delete the old password and after that you can replace with new password
            mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute("userPassword", password));
            connection.modifyAttributes("cn=" + username + dnBase, mods); //try to form DN dynamically
            System.out.println("Successfully changed user " + username + " password");
        } catch (Exception e) {
            System.out.println("Exception at updateUserPassword: " + e.getMessage());
        }
    }
}
