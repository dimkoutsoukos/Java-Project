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

import com.ps.models.City;
import com.ps.models.Client;
import com.ps.models.Store;
import com.ps.models.StoreDAO;




@Path("/storemanage")

public class StoreManage {
	@POST
	@Path("/register")  
	@Produces(MediaType.APPLICATION_JSON) 
	   public String doRegister(@QueryParam("cityid") int cityid, @QueryParam("storename") String storename){
		String response;
	      if (isNotNull(storename)) {
	    	  StoreDAO dao=new StoreDAO();
	    	  City id=new City (cityid);
	    	  Store store1=new Store(storename,id);
	    	  dao.addStore(store1);
	    	  response= constructJSON("Register", true, "Store '" + storename +"' has been registered");}
	      else {
	    	  response= constructJSON("Register", false, "You must enter the Name of the Store and the City it is located");
	      }
		return response;
	       

	   }
	
	   
	   
    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
       public String deleteStore(@QueryParam("storeid") String storeid){
       String response;
       if (isNotNull(storeid)) {
    	   StoreDAO dao = new StoreDAO();
	       int count=dao.deleteStore(storeid);
	       if (count==0)
	     	  response=constructJSON("Delete", false, "Store '" + storeid+"' is not registered");
	       else
	    	   response=constructJSON("Delete", true, "Store '" + storeid+"' has been deleted");
	       }
       else {
    	   response=constructJSON("Delete", false, "You must enter the ID of the store");  
       }
	return response;
    }
    
    
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON) 
    public String updateStore(@QueryParam("storeid") int storeid, @QueryParam("storename") String storename) {
    	String response;
    	if (storeid!= 0 &&isNotNull(storename)) {
    		StoreDAO dao = new StoreDAO();
    		int count=dao.updateStore(storeid, storename);
    		if (count==0)
    			response=constructJSON("Update", false, "Store with ID '" + storeid+"' does not exist");
    		else
    			return response=constructJSON("Update", true, "Store with ID '" + storeid+"' has been updated");}
    	else {
    		response=constructJSON("Update", false, "You must enter the ID of the store and it's new Name");  
    	}
        return response;        
     }

	@GET
	@Path("/retrieve")
	@Produces(MediaType.APPLICATION_JSON) 
	   public String getStores(){
	       StoreDAO dao = new StoreDAO();
	       String response;
	       List<Store> storelist = dao.getStores();
	       if (storelist.size()==0)
	    	   response=constructJSON("Retrieve", false, "No Stores Registered");
	       else 
	    	   response=constructJSON(storelist);
	       return response;
	   }

	   @GET
	   @Path("/getstoredetails")
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String storeDetails(@QueryParam("storename") String storename){
		    StoreDAO dao=new StoreDAO();
		      String response;   
		      List<Store> store=dao.getStoreDetails(storename);
		      if (store.size()==0)
		    	  response=constructJSON("Store", false, "No such store registered");
		      else
		      	  response = constructJSON(store);
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
	
	
  
	   
	   public String constructJSON(List<Store> stores) {
	       JSONObject obj = new JSONObject();
	       JSONArray storeJSONArray=new JSONArray();
	       String response="";
	       try {
	    	   Iterator itr = stores.iterator();
	    	   while(itr.hasNext()) {
	    		   Object[] store = (Object[]) itr.next();
	    		   JSONObject storeobj=new JSONObject();
	    		   storeobj.put("Store ID", String.valueOf(store[0]));
	    		   storeobj.put("City ID", String.valueOf(store[1]));
	    		   storeobj.put("Store Name", String.valueOf(store[2]));
	    		   storeJSONArray.put(storeobj);
	    		}
	    	   obj.put("StoreList", storeJSONArray);
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
