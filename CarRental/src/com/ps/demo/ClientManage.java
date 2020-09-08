package com.ps.demo;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.ps.models.Client;
import com.ps.models.ClientDAO;
import com.ps.models.Rental;




@Path("/clientmanage")
public class ClientManage {
	@POST
	@Path("/register")  
	@Produces(MediaType.APPLICATION_JSON) 
	   public String doRegister(@QueryParam("clientname") String clientname,
			   @QueryParam("clientsurname") String clientsurname, @QueryParam("clientdrivinglicence") String clientdrivinglicence,
			   @QueryParam("clientaddress") String clientaddress, @QueryParam("clientemail") String clientemail,
			   @QueryParam("clienttelephonenumber") String clienttelephonenumber){
		String response = null;
	      if (isNotNull(clienttelephonenumber)) {
	    	  ClientDAO dao=new ClientDAO();
	    	  dao.addClient(new Client(clientname, clientsurname, clientdrivinglicence, clientaddress, clientemail, clienttelephonenumber));
	    	  response= constructJSON("Register", true, "Client '" + clientname +" "+ clientsurname +"' has been registered");
	      }
	      else {
	    	  response= constructJSON("Register", false, "You must enter the Name and Phone Number of the Client");
	      }
		return response;
	       

	   }
	
	   
	   
    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
       public String deleteClient(@QueryParam("clientid") String clientid){
       String response;
       if (isNotNull(clientid)) {
    	   ClientDAO dao = new ClientDAO();
	       int count=dao.deleteClient(clientid);
	       if (count==0)
	     	  response=constructJSON("Delete", false, "Client '" + clientid+"' is not registered");
	       else
	    	   response=constructJSON("Delete", true, "Client '" + clientid+"' has been deleted");
	       }
       else {
    	   response=constructJSON("Delete", false, "You must enter the ID of the client");  
       }
	return response;
    }
    
    
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON) 
    public String updateClient(@QueryParam("clientid") int clientid, @QueryParam("clientname") String clientname, 
    		@QueryParam("clientsurname") String clientsurname, @QueryParam("clientdrivinglicence") String clientdrivinglicence, 
    		@QueryParam("clientaddress") String clientaddress, @QueryParam("clientemail") String clientemail,
    		@QueryParam("clienttelephonenumber") String clienttelephonenumber) {
        ClientDAO dao = new ClientDAO();
        String response;
        int count=dao.updateClient(clientid,clientname, clientsurname, clientdrivinglicence, clientaddress, clientemail, clienttelephonenumber);
        if (count==0)
      	  response=constructJSON("Update", false, "Client with ID '" + clientid+"' does not exist");
        else
     	   return response=constructJSON("Update", true, "Client with ID '" + clientid+"' has been updated");
        return response;        
     }

	@GET
	@Path("/retrieve")
	@Produces(MediaType.APPLICATION_JSON) 
	   public String getClients(){
	       ClientDAO dao = new ClientDAO();
	       String response;
	       List<Client> clientlist = dao.getClients();
	       if (clientlist.size()==0)
	    	   response=constructJSON("Retrieve", false, "No Clients Registered");
	       else 
	    	   response=constructJSON(clientlist);
	       return response;
	   }

	   @GET
	   @Path("/getclientdetails")
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String clientDetails(@QueryParam("clientname") String clientname, @QueryParam("clienttelephonenumber") String clienttelephonenumber){
		     ClientDAO dao=new ClientDAO();
		      String response;   
		      List<Client> client=dao.getClientDetails(clientname, clienttelephonenumber);
		      if (client.size()==0)
		    	  response=constructJSON("Client", false, "No such client registered");
		      else
		      	  response = constructJSON(client);
		      return response;        
		   }
   
  

	
	
	   public String constructJSON(String tag, boolean status,String err_msg) {
	       JSONObject obj = new JSONObject();
	       try {
	           obj.put("tag", tag);
	           obj.put("status", new Boolean(status));
	           obj.put("msg", err_msg);
	       } catch (JSONException e) {
	           // TODO Auto-generated catch block
	       }
	       return obj.toString();
	   }
	
	
  
	   
	   public String constructJSON(List<Client> clients) {
	       JSONObject obj = new JSONObject();
	       JSONArray clientJSONArray=new JSONArray();
	       String response="";
	       try {
	    	   Iterator itr = clients.iterator();
	    	   while(itr.hasNext()) {
	    		   Object[] client = (Object[]) itr.next();
	    		   JSONObject clientobj=new JSONObject();
	    		   clientobj.put("Client ID", String.valueOf(client[0]));
	    		   clientobj.put("Client Name", String.valueOf(client[1]));
	    		   clientobj.put("Client Surname", String.valueOf(client[2]));
	    		   clientobj.put("Client Driving Licence", String.valueOf(client[3]));
	    		   clientobj.put("Client Address", String.valueOf(client[4]));
	    		   clientobj.put("Client E-mail", String.valueOf(client[5]));
	    		   clientobj.put("Client Telephone Number", String.valueOf(client[6]));
	    		   clientJSONArray.put(clientobj);
	    		}
	    	   obj.put("ClientList", clientJSONArray);
			   response=obj.toString();
	       } catch (JSONException e) {
	    	   //TODO Auto-generated catch block
	       }
	       return response;
	   }

	     
	   public boolean isNotNull(String txt) {
	       // System.out.println("Inside isNotNull");
	       return txt != null && txt.trim().length() >= 0 ? true : false;
	   }

}
