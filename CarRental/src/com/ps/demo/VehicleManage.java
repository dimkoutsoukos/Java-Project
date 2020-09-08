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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.ps.models.Car;
import com.ps.models.CarDAO;
import com.ps.models.Store;
import com.ps.models.StoreDAO;
import com.ps.models.TwoWheeled;
import com.ps.models.TwoWheeledDAO;
import com.ps.models.Vehicle;
import com.ps.models.VehicleDAO;


@Path("/vehiclemanage")
public class VehicleManage {
	   @POST
	   @Path("/register")
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String carRegister(@QueryParam("vehiclelicenceno") String vehiclelicenceno, @QueryParam("storeid") int storeid, 
				@QueryParam("vehiclemodel") String vehiclemodel, @QueryParam("vehiclefuel") String vehiclefuel,
				@QueryParam("vehiclecapacity") String vehiclecapacity, @QueryParam("vehiclerentalcost") Integer vehiclerentalcost,
				@QueryParam("vehiclecategory") String vehiclecategory,
				@QueryParam("vehicleseatno") Integer vehicleseatno, @QueryParam("vehicledoornumber") Integer vehicledoornumber,
				@QueryParam("vehicleseatheight") Integer vehicleseatheight, @QueryParam("vehicleluggagesupport") String vehicleluggagesupport) {
		   String response = null;
		   String test=vehiclecategory.toString();
		   if(isNotNull(vehiclelicenceno)) {
		      VehicleDAO ln = new VehicleDAO();
		      List<Vehicle> check = ln.checkLicence(vehiclelicenceno);
		       if (check.size()==0) {
				   if(test.contentEquals("Compact") || test.contentEquals("Midrange") || test.contentEquals("Van")) {
					    CarDAO dao=new CarDAO();
					    Store id=new Store (storeid);
					    Car car1=new Car(vehiclelicenceno, id, vehiclemodel, vehiclefuel, vehiclecapacity, 
					    			  		   vehiclerentalcost, vehiclecategory, vehicleseatno, vehicledoornumber);
					    dao.addCar(car1);
						response=constructJSON("Vehicle", true, "Car with Licence Number "+vehiclelicenceno+" has been registered!");}
				   else if(test.contentEquals("Scooter") || test.contentEquals("Motorcycle")){
					    TwoWheeledDAO dao=new TwoWheeledDAO();
				    	Store id=new Store (storeid);
				    	TwoWheeled bike1=new TwoWheeled(vehiclelicenceno, id, vehiclemodel, vehiclefuel, vehiclecapacity, 
				    									vehiclerentalcost, vehiclecategory, vehicleseatheight, vehicleluggagesupport);
				    	dao.addBike(bike1); 
						response=constructJSON("Vehicle", true, "Motorcyce with Licence Number "+vehiclelicenceno+" has been registered!");
				   }
				   else 
					   response=constructJSON("Vehicle", false, "The supported Vehicle types are:'Compact Car','Midrange Car', 'Van', 'Scooter', 'Bike'.");
				   
		       }
		   
		       else 
		    	   response=constructJSON("Vehicle", false, "Vehicle with Licence Number "+vehiclelicenceno+" alreay exists!");
	   }
		   else {
				response=constructJSON("Vehicle", false, "You must enter the Licence Number of the Vehicle");
		   }
		   return response;
}
	

	   /*
	   @POST
	   @Path("/bikeregister")
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String bikeRegister(@QueryParam("vehiclelicenceno") String vehiclelicenceno, @QueryParam("storeid") int storeid, 
				@QueryParam("vehiclemodel") String vehiclemodel, @QueryParam("vehiclefuel") String vehiclefuel, @QueryParam("vehiclecapacity") String vehiclecapacity
				,@QueryParam("vehiclerentalcost") Integer vehiclerentalcost, @QueryParam("vehicletype") String vehicletype
				,@QueryParam("vehicleseatheight") Integer vehicleseatheight, @QueryParam("vehicleluggagesupport") String vehicleluggagesupport){
		   			TwoWheeledDAO dao=new TwoWheeledDAO();
			    	Store id=new Store (storeid);
			    	TwoWheeled bike1=new TwoWheeled(vehiclelicenceno, id, vehiclemodel, vehiclefuel, vehiclecapacity, 
			    									vehiclerentalcost, vehicleseatheight, vehicleluggagesupport);
			    	dao.addBike(bike1);
		    	  return Response.ok().build().toString();}*/

	
	   
	   
    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
       public String deleteVehicle(@QueryParam("vehiclelicenceno") String vehiclelicenceno){
       String response;
       if (isNotNull(vehiclelicenceno)) {
    	   VehicleDAO dao = new VehicleDAO();
	       int count=dao.deleteVehicle(vehiclelicenceno);
	       if (count==0)
	     	  response=constructJSON("Delete", false, "Vehicle '" + vehiclelicenceno+"' is not registered");
	       else
	    	   response=constructJSON("Delete", true, "Vehicle '" + vehiclelicenceno+"' has been deleted");
	       }
       else {
    	   response=constructJSON("Delete", false, "You must enter the Licence Number of the car");  
       }
	return response;
    }

    
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON) 
    public String updateStore(@QueryParam("vehiclelicenceno") String vehiclelicenceno, @QueryParam("storeid") int storeid, 
			@QueryParam("vehiclemodel") String vehiclemodel, @QueryParam("vehiclefuel") String vehiclefuel, 
			@QueryParam("vehiclecapacity") String vehiclecapacity,  @QueryParam("vehiclecategory") String vehiclecategory,
			@QueryParam("vehiclerentalcost") Integer vehiclerentalcost,
			@QueryParam("vehicleseatno") Integer vehicleseatno, @QueryParam("vehicledoornumber") Integer vehicledoornumber,
			@QueryParam("vehicleseatheight") Integer vehicleseatheight, @QueryParam("vehicleluggagesupport") String vehicleluggagesupport) {
		   String response = null;
		   String test=vehiclecategory.toString();
		   if(isNotNull(vehiclelicenceno)) {
		      VehicleDAO ln = new VehicleDAO();
		      List<Vehicle> check = ln.checkLicence(vehiclelicenceno);
		       if (check.size()!=0) {
				   if(test.contentEquals("Compact") || test.contentEquals("Midrange") || test.contentEquals("Van")) {
			    		CarDAO dao = new CarDAO();
			    		Store id=new Store (storeid);
			    		dao.updateCar(vehiclelicenceno, id, vehiclemodel, vehiclefuel, vehiclecapacity, 
				    			  vehiclerentalcost, vehiclecategory, vehicleseatno, vehicledoornumber);
			    			response=constructJSON("Update", true, "Car with Licence Number '" + vehiclelicenceno+"' has been updated");}
				   	else if(test.contentEquals("Scooter") || test.contentEquals("Motorcycle")){
					    TwoWheeledDAO dao=new TwoWheeledDAO();
				    	Store id=new Store (storeid);
			    		dao.updateBike(vehiclelicenceno, id, vehiclemodel, vehiclefuel, vehiclecapacity, 
				    			  vehiclerentalcost, vehiclecategory, vehicleseatheight, vehicleluggagesupport);
			    		response=constructJSON("Update", true, "Bike with Licence Number '" + vehiclelicenceno+"' has been updated");}
				   
				   else 
					   response=constructJSON("Vehicle", false, "The supported Vehicle types are:'Compact Car','Midrange Car', 'Van', 'Scooter', 'Bike'.");
		       
		       }
		       	else {
		       		response=constructJSON("Update", false, "The Licence Number '" +vehiclelicenceno+"' does not exist!");}
		   }
	       else {
	    	   response = constructJSON("Update", false, "You must enter the Licence Number of the Vehicle you want to update");}

		   return response;}

	@GET
	@Path("/retrieve/all")
	@Produces(MediaType.APPLICATION_JSON) 
	   public String getVehicles(){
	       VehicleDAO dao = new VehicleDAO();
	       String response;
	       List<Vehicle> vehiclelist = dao.getVehicles();
	       if (vehiclelist.size()==0)
	    	   response=constructJSON("Retrieve", false, "No Vehicles Registered");
	       else 
	    	   response=constructJSON1(vehiclelist);
	       return response;
	   }

	   @GET
	   @Path("/getvehicledetails")
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String vehicleDetails(@QueryParam("vehiclelicenceno") String vehiclelicenceno){
		    VehicleDAO dao=new VehicleDAO();
		      String response;   
		      List<Vehicle> vehicle=dao.getVehicleDetails(vehiclelicenceno);
		      if (vehicle.size()==0)
		    	  response=constructJSON("Vehicle", false, "No such vehicle registered");
		      else
		      	  response = constructJSON1(vehicle);
		      return response;        
		   }
	   
	   
	   @GET
	   @Path("/retrieve/allcars")
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getCars(){
	       CarDAO dao = new CarDAO();
	       String response;
	       List<Car> carlist = dao.getCars();
	       if (carlist.size()==0)
	    	   response=constructJSON("Retrieve", false, "No Cars Registered");
	       else 
	    	   response=constructJSON2(carlist);
	       return response;
	   }
	   
	   @GET
	   @Path("/retrieve/Compact")
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getCompacts(){
	       CarDAO dao = new CarDAO();
	       String response;
	       List<Car> carlist = dao.getCompacts();
	       if (carlist.size()==0)
	    	   response=constructJSON("Retrieve", false, "No Compact Cars Registered");
	       else 
	    	   response=constructJSON2(carlist);
	       return response;
	   }
	   
	   @GET
	   @Path("/retrieve/Midrange")
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getMidranged(){
	       CarDAO dao = new CarDAO();
	       String response;
	       List<Car> carlist = dao.getMidranged();
	       if (carlist.size()==0)
	    	   response=constructJSON("Retrieve", false, "No Midrange Cars Registered");
	       else 
	    	   response=constructJSON2(carlist);
	       return response;
	   }
	   
	   @GET
	   @Path("/retrieve/Van")
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getVans(){
	       CarDAO dao = new CarDAO();
	       String response;
	       List<Car> carlist = dao.getVans();
	       if (carlist.size()==0)
	    	   response=constructJSON("Retrieve", false, "No Vans Registered");
	       else 
	    	   response=constructJSON2(carlist);
	       return response;
	   }
   
	   @GET
	   @Path("/retrieve/allbikes")
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getBikes(){
		   TwoWheeledDAO dao = new TwoWheeledDAO();
	       String response;
	       List<TwoWheeled> bikelist = dao.getBikes();
	       if (bikelist.size()==0)
	    	   response=constructJSON("Retrieve", false, "No Bikes Registered");
	       else 
	    	   response=constructJSON3(bikelist);
	       return response;
	   }
	   
	   @GET
	   @Path("/retrieve/Scooter")
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getScooters(){
		   TwoWheeledDAO dao = new TwoWheeledDAO();
	       String response;
	       List<TwoWheeled> bikelist = dao.getScooters();
	       if (bikelist.size()==0)
	    	   response=constructJSON("Retrieve", false, "No Scooters Registered");
	       else 
	    	   response=constructJSON3(bikelist);
	       return response;
	   }
	   
	   @GET
	   @Path("/retrieve/Motorcycle")
	   @Produces(MediaType.APPLICATION_JSON) 
	   public String getMotorcycles(){
		   TwoWheeledDAO dao = new TwoWheeledDAO();
	       String response;
	       List<TwoWheeled> bikelist = dao.getMotorcycles();
	       if (bikelist.size()==0)
	    	   response=constructJSON("Retrieve", false, "No Motorcycles Registered");
	       else 
	    	   response=constructJSON3(bikelist);
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
	

	   public String constructJSON3(List<TwoWheeled> bikes) {
	       JSONObject obj = new JSONObject();
	       JSONArray vehicleJSONArray=new JSONArray();
	       String response="";
	       try {
	    	   Iterator itr = bikes.iterator();
	    	   while(itr.hasNext()) {
	    		   Object[] vehicle = (Object[]) itr.next();
	    		   JSONObject vehicleObj=new JSONObject();
	    		   vehicleObj.put("Bikes Licence Number", String.valueOf(vehicle[0]));
	    		   vehicleObj.put("Store ID", String.valueOf(vehicle[1]));
	    		   vehicleObj.put("Bike Model", String.valueOf(vehicle[2]));
	    		   vehicleObj.put("Bike Fuel Type", String.valueOf(vehicle[3]));
	    		   vehicleObj.put("Bike Capacity", String.valueOf(vehicle[4]));
	    		   vehicleObj.put("Bike Rental Cost", String.valueOf(vehicle[5]));
	    		   vehicleObj.put("Bike Category", String.valueOf(vehicle[6]));
	    		   vehicleObj.put("Bike Seat Hight", String.valueOf(vehicle[7]));
	    		   vehicleObj.put("Bike Luggage Support", String.valueOf(vehicle[8]));
	    		   vehicleJSONArray.put(vehicleObj);
	    		}
	    	   obj.put("BikeList", vehicleJSONArray);
			   response=obj.toString();
	       } catch (JSONException e) {
	    	   //TODO Auto-generated catch block
	       }
	       return response;
	   }
  
	   
	   public String constructJSON2(List<Car> cars) {
	       JSONObject obj = new JSONObject();
	       JSONArray vehicleJSONArray=new JSONArray();
	       String response="";
	       try {
	    	   Iterator itr = cars.iterator();
	    	   while(itr.hasNext()) {
	    		   Object[] vehicle = (Object[]) itr.next();
	    		   JSONObject vehicleObj=new JSONObject();
	    		   vehicleObj.put("Car Licence Number", String.valueOf(vehicle[0]));
	    		   vehicleObj.put("Store ID", String.valueOf(vehicle[1]));
	    		   vehicleObj.put("Car Model", String.valueOf(vehicle[2]));
	    		   vehicleObj.put("Car Fuel Type", String.valueOf(vehicle[3]));
	    		   vehicleObj.put("Car Capacity", String.valueOf(vehicle[4]));
	    		   vehicleObj.put("Car Rental Cost", String.valueOf(vehicle[5]));
	    		   vehicleObj.put("Car Category", String.valueOf(vehicle[6]));
	    		   vehicleObj.put("Car Number of Seats", String.valueOf(vehicle[7]));
	    		   vehicleObj.put("Car Number of Doors", String.valueOf(vehicle[8]));
	    		   vehicleJSONArray.put(vehicleObj);
	    		}
	    	   obj.put("CarList", vehicleJSONArray);
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
