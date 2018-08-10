package com.nisum.demorest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class ClientApp {
	
	private static String rootPath= "http://localhost:8080/";
	private static String basePath= "demorest/myresource/";

	public static void main(String[] args) {
	//	get();
	//	put();
	//	post();
		delete();
		
		//getEmployee();
	}

	private static void getEmployee() {
		ClientConfig config= new ClientConfig();
		Client client= ClientBuilder.newClient(config);
		
		Response response= client.target(rootPath).path(basePath+"1").request().accept(MediaType.APPLICATION_JSON).get();
		Employee name= response.readEntity(Employee.class);
		System.out.println(name);
	}
	
	
	private static void delete() {
		
		ClientConfig config= new ClientConfig();
		Client client= ClientBuilder.newClient(config);
		
		//System.out.println(rootPath + "" + basePath+"find?id=1");
		
		Response response= client.target(rootPath).path(basePath+"delete").queryParam("id", 1).request().accept(MediaType.TEXT_PLAIN).delete();
		String name= response.readEntity(String.class);
		System.out.println(name);
		
		
	}

	private static void post() {
		ClientConfig config= new ClientConfig();
		Client client= ClientBuilder.newClient(config);
		
		Employee e= new Employee(1, "ABCD");
		
		System.out.println(rootPath + "" + basePath+"post");
		
		Response response= client.target(rootPath).path(basePath+"post")
													.request()
													.accept(MediaType.TEXT_PLAIN)
													.post(Entity.entity(e, MediaType.APPLICATION_JSON));
		String s=response.readEntity(String.class);
		System.out.println(s);
		
	}

	private static void put() {
		ClientConfig config= new ClientConfig();
		Client client= ClientBuilder.newClient(config);
		
		Employee e= new Employee(1, "ABCD");
		
		System.out.println(rootPath + "" + basePath+"put");
		Response response= client.target(rootPath).path(basePath+"put")
													.request()
													.accept(MediaType.TEXT_PLAIN)
													.put(Entity.entity(e, MediaType.APPLICATION_JSON));
		String s=response.readEntity(String.class);
		System.out.println(s);
	}

	private static void get() {
		ClientConfig config= new ClientConfig();
		Client client= ClientBuilder.newClient(config);
		
		//System.out.println(rootPath + "" + basePath+"find?id=1");
		
		Response response= client.target(rootPath).path(basePath+"find").queryParam("id", 1).request().accept(MediaType.TEXT_PLAIN).get();
		String name= response.readEntity(String.class);
		System.out.println(name);
		
	}

}
