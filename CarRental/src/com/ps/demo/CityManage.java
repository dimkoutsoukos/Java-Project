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
import com.ps.models.CityDAO;
import com.ps.models.Store;



@Path("/citymanage")
public class CityManage {
	@POST
	@Path("/register")  
	@Produces(MediaType.APPLICATION_JSON) 
	   public String doRegister(@QueryParam("cityname") String cityname){
		String response = null;
	      if (isNotNull(cityname)) {
	    	  CityDAO dao=new CityDAO();
	    	  dao.addCity(new City(cityname));
	    	  response= constructJSON("Register", true, "City '" + cityname+"' has been registered");
	      }
	      else {
	    	  response= constructJSON("Register", false, "You must enter the Name of the City");
	      }
		return response;
	       

	   }
	
	   
	   
    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
       public String deleteCity(@QueryParam("cityname") String cityname){
       String response;
       if (isNotNull(cityname)) {
    	   CityDAO dao = new CityDAO();
	       int deleteCity=dao.deleteCity(cityname);
	       if (deleteCity==0)
	     	  response=constructJSON("Delete", false, "City '" + cityname+"' is not registered");
	       else
	    	   response=constructJSON("Delete", true, "City '" + cityname+"' has been deleted");
	       }
       else {
    	   response=constructJSON("Delete", false, "You must enter the name of the city");  
       }
	return response;
    }
    
    
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON) 
    public String updateCity(@QueryParam("cityid") String cityid, @QueryParam("cityname") String cityname){
        CityDAO dao = new CityDAO();
        String response;
        int updateCity=dao.updateCity(cityid,cityname);
        if (updateCity==0)
      	  response=constructJSON("Update", false, "City with ID '" + cityid+"' does not exist");
        else
     	   return response=constructJSON("Update", true, "City with ID '" + cityid+"' has been updated");
        return response;        
     }

	@GET
	@Path("/retrieve")
	@Produces(MediaType.APPLICATION_JSON) 
	   public String getCities(){
	       CityDAO dao = new CityDAO();
	       String response;
	       
	       List<City> cities = dao.getCities();
	       if (cities.size()==0)
	    	   response=constructJSON("Retrieve", false, "No Cities Registered");
	       else 
	    	   response=constructJSON(cities);
	       return response;
	   }

	   @GET
	   @Path("/getcitydetails")
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String cityDetails(@QueryParam("cityname") String cityname){
		     CityDAO dao=new CityDAO();
		      String response;   
		      List<City> registeredCity=dao.getCityDetails(cityname);
		      if (registeredCity.size()==0)
		    	  response=constructJSON("City", false, "No such city registered");
		      else
		      	  response = constructJSON(registeredCity);
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
	
	
  
	   
	   public String constructJSON(List<City> cities) {
	       JSONObject obj = new JSONObject();
	       JSONArray cityJSONArray=new JSONArray();
	       String response="";
	       try {
	    	   Iterator itr = cities.iterator();
	    	   while(itr.hasNext()) {
	    		   Object[] city = (Object[]) itr.next();
	    		   JSONObject cityobj=new JSONObject();
	    		   cityobj.put("City ID", String.valueOf(city[0]));
	    		   cityobj.put("City Name", String.valueOf(city[1]));
	    		   cityJSONArray.put(cityobj);
	    		}
	    	   obj.put("CityList", cityJSONArray);
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
