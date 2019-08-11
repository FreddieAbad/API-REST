/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.media.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author USUARIO
 */
@Path("testcontroller")
public class testController {
    @GET
    @Path("/getData")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList <testModel> getDataInJson() throws SQLException, ClassNotFoundException{
        ArrayList<testModel> tmm = new ArrayList<>();
        Connection con=null;
        String username="test";
        String password="test";
        String query="select * from test";
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con=DriverManager.getConnection("jdbc:derby://localhost:1527/bdRest",username, password);
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        while(rs.next()){
            testModel tm=new testModel();
            tm.setId(rs.getInt("id"));
            tm.setName(rs.getString("name"));
            tm.setEmail(rs.getString("email"));
            tmm.add(tm);
        }
        return tmm;
    }
}
