package com.finalprojectridingshotgun.FinalProjectRidingShotgun.mapentity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonWrapper {
	@JsonProperty("status")
	private String status;

	@JsonProperty("routes")
	private ArrayList<Routes> routes;

	public JsonWrapper() {

	}

	public ArrayList<Routes> getRoutes() {
		return routes;
	}

	public void setRoutes(ArrayList<Routes> routes) {
		this.routes = routes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "JsonWrapper [status=" + status + ", routes=" + routes + "]";
	}

//	@Override
//	public String toString() {
//		return "JsonWrapper [routes=" + routes + "]";
//	}


}
