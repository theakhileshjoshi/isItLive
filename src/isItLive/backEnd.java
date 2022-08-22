package isItLive;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.*;
import java.io.*;

public class backEnd {
	
	public int tryConnection(URL u) {
		int response = 0;
		
		HttpURLConnection connection = null;
		try {

	       // u = new URL("https://www.saritaindustries.in");

	        connection = (HttpURLConnection) u.openConnection();

	        connection.setRequestMethod("HEAD");

	        int code = connection.getResponseCode();

	        response = code;

	        // You can determine on HTTP return code received. 200 is success.

	    } catch (MalformedURLException e) {

	        // TODO Auto-generated catch block

	        

	    } catch (IOException e) {

	        // TODO Auto-generated catch block

	    } finally {

	        if (connection != null) {

	            connection.disconnect();

	        }

	    }
		return response;
	}
}
