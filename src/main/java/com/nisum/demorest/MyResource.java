package com.nisum.demorest;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("myresource")
public class MyResource {

    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    public String getIt() {
        return "Got it!";
    }
    
    @Path("/put")
    @PUT
    @Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    public String put(Employee employee) {
    	System.out.println(employee);
    	if(employee == null) {
    		return "error";
    	}
    	return "success";
    }
    
    @Path("/post")
    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    public String post(Employee employee) {
    	System.out.println(employee);
    	if(employee == null) {
    		return "error";
    	}
    	return "success  " + employee.getId() + "  " + employee.getName();
    }
    
    @Path("/find")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    public String getWithId(@QueryParam("id")int id) {
    	java.util.Map<Integer,String> students= new HashMap<Integer,String>();
    	students.put(1, "AAAAA");
    	students.put(2, "BBBBB");
    	students.put(3, "CCCCC");
    	students.put(4, "DDDDD");
    	students.put(5, "EEEEE");
    	
    	if(students.containsKey(id)) {
    		return students.get(id);
    	}
    	return null;
    }
    
    @Path("/print")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    public String getWithIdName(@MatrixParam("id")int id,@MatrixParam("name")String name) {
    	return " Hello  " + id + "  " +" name "+ name;
    }
    
    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    public Employee getWithIdPathParam(@PathParam("id")int id) {
    	
    	java.util.Map<Integer,Employee> employees= new HashMap<Integer,Employee>();
    	employees.put(1, new Employee(1,"AAA"));
    	employees.put(2, new Employee(2,"AAA"));
    	employees.put(3, new Employee(3,"AAA"));
    	employees.put(4, new Employee(4,"AAA"));
    	employees.put(5, new Employee(5,"AAA"));
    	
    	if(employees.containsKey(id)) {
    		return employees.get(id);
    	}
    	return null;
    }
    
    @Path("/delete")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public String delete(@QueryParam("id")int id) {
    	System.out.println("DELETED __ID=  " + id);
    	return "success";
    }
}
