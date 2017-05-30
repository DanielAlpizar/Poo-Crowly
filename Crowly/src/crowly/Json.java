package crowly;

import crowly.connectors.Archivo;
import crowly.library.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Hashtable;

public class Json {
	
	private ArrayList<Cuerpo> bodies;
	
	private JSONArray fragments;
	private JSONObject time;
	private JSONArray events;
	private JSONArray locations;
	private JSONObject posX;
	private JSONObject posY;
	private JSONObject width;
	private JSONObject height;
	
	public VideoResponse videoResponse;

	 
	public  void generateBodys(){
		JSONParser parser = new JSONParser();
		try {
			JSONObject obj = (JSONObject)parser.parse(videoResponse);
			
			fragments = (JSONArray) obj.get("fragments");
			for (int i= 0; i<fragments.size(); i++){
				time = (JSONObject) obj.get("duration");
				events = (JSONArray)obj.get("events");
				locations = (JSONArray)obj.get("locations");
				posX = (JSONObject)obj.get("x");
				posY = (JSONObject)obj.get("y");
				int x = convertInt(posX);
				int y = convertInt(posY);
				int date = convertInt(time);
				Cuerpo body = new Cuerpo(x,y,date);
				bodies.add(body);
			}
	
		} catch (ParseException e) {
			Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public int convertInt(JSONObject number){
		String num= number.toString();
		int res = Integer.parseInt(num);
		return res;
	}
	
	public ArrayList <Cuerpo> getCuerpos(){
		return bodies;
	}

}
