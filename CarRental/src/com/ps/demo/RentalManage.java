package com.ps.demo;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.ps.models.Client;
import com.ps.models.Rental;
import com.ps.models.RentalDAO;
import com.ps.models.Vehicle;
import com.ps.models.VehicleDAO;

@Path("/rentalmanage")
public class RentalManage {
	@POST
	@Path("/register")  
	@Produces(MediaType.APPLICATION_JSON) 
	   public String doRegister(@QueryParam("vehiclelicenceno") String vehiclelicenceno,@QueryParam("clientid") int clientid,
			   @QueryParam("rentalpickuplocation") String rentalpickuplocation, @QueryParam("rentalpickupdatetime") String rentalpickupdatetime,
			   @QueryParam("rentalreturnloction") String rentalreturnloction, @QueryParam("rentalreturndatetime") String rentalreturndatetime){		
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");   
	    String firstInput = rentalpickupdatetime;
	    String secondInput = rentalreturndatetime;
	    LocalDate firstDate = LocalDate.parse(firstInput, formatter);
	    LocalDate secondDate = LocalDate.parse(secondInput, formatter);
	    long daysbetween = ChronoUnit.DAYS.between(firstDate, secondDate);
	    Integer days = (int) (long) daysbetween;
		String response = null;
	      if (isNotNull(vehiclelicenceno)&&clientid!=0) {	    	  
	    	  Date dt1 = new Date();
	    	  SimpleDateFormat sdf1 = new SimpleDateFormat(rentalpickupdatetime);
	    	  String picktime = sdf1.format(dt1);
	    	  Date dt2 = new Date();
	    	  SimpleDateFormat sdf2 = new SimpleDateFormat(rentalreturndatetime);
	    	  String droptime = sdf2.format(dt2);
	    	  RentalDAO dao=new RentalDAO();
	    	  Integer rentalcost= dao.getRentalCost(vehiclelicenceno);
	    	  Integer rentaltotalcost=(rentalcost)*(days);
	    	  Vehicle ln = new Vehicle(vehiclelicenceno);
	    	  Client id= new Client(clientid);
	    	  Rental rental1 = new Rental(ln, id, rentalpickuplocation, picktime, rentalreturnloction,
	    			  droptime, rentaltotalcost);
	    	  dao.addRental(rental1);
	    	  response= constructJSON("Rental", true, "Vehicle with Licence Number '" + vehiclelicenceno +"' has been rented to Client '"+clientid+"' "
	    	  		+ "from "+rentalpickupdatetime+" to " +rentalreturndatetime+"");
	    	  if(!rentalpickuplocation.equals(rentalreturnloction)) {
	    		  VehicleDAO lctn = new VehicleDAO();
	    		  int change = lctn.updateVehicleLocation(vehiclelicenceno, rentalreturnloction);
	    		  if (change!=0) 
	    			  response = constructJSON("Location", true, "Vehicle with Licence Number "+vehiclelicenceno+" will be returned to our local store in "+rentalreturnloction+"!");
	    		  else 
	    			  response= constructJSON("Location", false, "You must manually insert the new store id for the Veehicle with Licence Number"+vehiclelicenceno+"");
	    	  }
	      }
	      else {
	    	  response= constructJSON("Rental", false, "You must enter the Licence Number of the Vehicle");
	      }
		return response;
}
	
	   
	   
    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
       public String deleteRental(@QueryParam("rentalid") int rentalid){
       String response;
       if (rentalid!=0) {
    	   RentalDAO dao = new RentalDAO();
	       int count=dao.deleteRental(rentalid);
	       if (count==0)
	     	  response=constructJSON("Delete", false, "Rental '" + rentalid+"' is not registered");
	       else
	    	   response=constructJSON("Delete", true, "Rental '" + rentalid+"' has been deleted");
	       }
       else {
    	   response=constructJSON("Delete", false, "You must enter the ID of the client");  
       }
	return response;
    }
    
    
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON) 
    public String updateRental(@QueryParam("rentalid") int rentalid, @QueryParam("vehiclelicenceno") String vehiclelicenceno,@QueryParam("clientid") int clientid,
			   @QueryParam("rentalpickuplocation") String rentalpickuplocation, @QueryParam("rentalpickupdatetime") String rentalpickupdatetime,
			   @QueryParam("rentalreturnloction") String rentalreturnloction, @QueryParam("rentalreturndatetime") String rentalreturndatetime,
			   @QueryParam("rentaltotalcost") Integer rentaltotalcost) {
        RentalDAO dao = new RentalDAO();
        String response;
        int count=dao.updateRental(rentalid, vehiclelicenceno, clientid, rentalpickuplocation, rentalpickupdatetime, rentalreturnloction,
    			rentalreturndatetime, rentaltotalcost);
        if (count==0)
      	  response=constructJSON("Update", false, "Rental with ID '" + rentalid+"' does not exist");
        else
     	   return response=constructJSON("Update", true, "Rental with ID '" + rentalid+"' has been updated");
        return response;        
     }

	@GET
	@Path("/retrieve")
	@Produces(MediaType.APPLICATION_JSON) 
	   public String getRentals(){
	       RentalDAO dao = new RentalDAO();
	       String response;
	       List<Rental> rentallist = dao.getRentals();
	       if (rentallist.size()==0)
	    	   response=constructJSON("Retrieve", false, "No Rentals Registered");
	       else 
	    	   response=constructJSON(rentallist);
	       return response;
	   }

	   @GET
	   @Path("/getrentaldetails")
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String rentalDetails(@QueryParam("rentalid") int rentalid){
		     RentalDAO dao=new RentalDAO();
		      String response;   
		      List<Rental> rental=dao.getRentalDetails(rentalid);
		      if (rental.size()==0)
		    	  response=constructJSON("Rental", false, "No such Rental registered");
		      else
		      	  response = constructJSON(rental);
		      return response;        
		   }
	   @GET
	   @Path("/getavailability")
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String vehiceAvailability(@QueryParam("rentalpickuplocation") String rentalpickuplocation, @QueryParam("rentalpickupdatetime") String rentalpickupdatetime,
			   @QueryParam("rentalreturndatetime") String rentalreturndatetime, @QueryParam("vehiclecategory") String vehiclecategory){
		      String response; 
		      if("None".equals(vehiclecategory)) {
		    	  VehicleDAO dao=new VehicleDAO();  
			      List<Vehicle> vehiclesNA=dao.checkAvailability(rentalpickuplocation, rentalpickupdatetime, rentalreturndatetime);
			      List<Vehicle> vehiclesCity=dao.getCityVehicles(rentalpickuplocation);
			      List<Vehicle> vehiclesA = new ArrayList<Vehicle>(vehiclesCity);
			      vehiclesA.removeAll(vehiclesNA);
			      if (vehiclesA.size()==0)
			    	  response=constructJSON("Rental", false, "No Vehicles Available for the selected days!");
			      else
			      	  response = constructJSON1(vehiclesA);
		      }
			   else {
				   VehicleDAO dao=new VehicleDAO();  
				      List<Vehicle> vehiclesNA=dao.checkAvailabilityCategory(rentalpickuplocation, rentalpickupdatetime, rentalreturndatetime,vehiclecategory);
				      List<Vehicle> vehiclesCity=dao.getCityVehiclesCategory(rentalpickuplocation,vehiclecategory);
				      List<Vehicle> vehiclesA = new ArrayList<Vehicle>(vehiclesCity);
				      vehiclesA.removeAll(vehiclesNA);
				      if (vehiclesA.size()==0)
				    	  response=constructJSON("Rental", false, "No "+vehiclecategory+" Vehicle Available for the selected days!");
				      else
				      	  response = constructJSON1(vehiclesA);
			   	  
			   }
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
	
	
  
	   
	   public String constructJSON(List<Rental> rentals) {
	       JSONObject obj = new JSONObject();
	       JSONArray rentalJSONArray=new JSONArray();
	       String response="";
	       try {
	    	   Iterator itr = rentals.iterator();
	    	   while(itr.hasNext()) {
	    		   Object[] rental = (Object[]) itr.next();
	    		   JSONObject rentalObj=new JSONObject();
	    		   rentalObj.put("Rental ID", String.valueOf(rental[0]));
	    		   rentalObj.put("Licence Number of Vehicle", String.valueOf(rental[1]));
	    		   rentalObj.put("Cient ID", String.valueOf(rental[2]));
	    		   rentalObj.put("Pickup Location", String.valueOf(rental[3]));
	    		   rentalObj.put("Pickup Datetime", String.valueOf(rental[4]));
	    		   rentalObj.put("Return Location", String.valueOf(rental[5]));
	    		   rentalObj.put("Return Datetime", String.valueOf(rental[6]));
	    		   rentalObj.put("Rental Cost", String.valueOf(rental[7]));
	    		   rentalJSONArray.put(rentalObj);
	    		}
	    	   obj.put("RentalList", rentalJSONArray);
			   response=obj.toString();
	       } catch (JSONException e) {
	    	   //TODO Auto-generated catch block
	       }
	       return response;
	   }
	   public String constructJSON1(List<Vehicle> vehicles) {
	       JSONObject obj = new JSONObject();
	       JSONArray vehicleJSONArray=new JSONArray();
	       String response="";
	       try {
	    	   Iterator itr = vehicles.iterator();
	    	   while(itr.hasNext()) {
	    		   Object[] vehicle = (Object[]) itr.next();
	    		   JSONObject vehicleObj=new JSONObject();
	    		   vehicleObj.put("Vehicle Licence Number", String.valueOf(vehicle[0]));
	    		   vehicleObj.put("Store ID", String.valueOf(vehicle[1]));
	    		   vehicleObj.put("Vehicle Model", String.valueOf(vehicle[2]));
	    		   vehicleObj.put("Vehicle Fuel Type", String.valueOf(vehicle[3]));
	    		   vehicleObj.put("Vehicle Capacity", String.valueOf(vehicle[4]));
	    		   vehicleObj.put("Vehicle Rental Cost", String.valueOf(vehicle[5]));
	    		   vehicleObj.put("Vehicle Type", String.valueOf(vehicle[6]));
	    		   vehicleObj.put("Vehicle Category", String.valueOf(vehicle[7]));
	    		   vehicleObj.put("Bike Seat Hight", String.valueOf(vehicle[8]));
	    		   vehicleObj.put("Bike Luggage Support", String.valueOf(vehicle[9]));
	    		   vehicleObj.put("Car Number of Seats", String.valueOf(vehicle[10]));
	    		   vehicleObj.put("Car Number of Doors", String.valueOf(vehicle[11]));
	    		   vehicleJSONArray.put(vehicleObj);
	    		}
	    	   obj.put("VehicleList", vehicleJSONArray);
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
