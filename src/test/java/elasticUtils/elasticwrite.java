package elasticUtils;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

public class elasticwrite {
	
	private String path;
    private ClientConfig config = new ClientConfig().register(JacksonFeature.class);
    private Client client = ClientBuilder.newClient(config);
    private WebTarget target;
    private SecureRandom random = new SecureRandom();
	public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	private static Logger logger = Logger.getLogger(elasticwrite.class.getName());
	public List<String> steps = new ArrayList<String>();
	public String failedDeviceId=null;
	public String failureDevice;
	
	public elasticwrite() {
		
	}
	public elasticwrite(String url, String path) {
		super();
		this.path = path;
		target = client.target(url);
	}
	

	
	/**
	 * Closes the connection to the ElasticSearch server.
	 */
	public void close(){
		client.close();
	}
	
	public static String getCurrentTime() {
		return SIMPLE_DATE_FORMAT.format(new Date());
	}
	
    
    public static void main(String[] args) {
    	elasticwrite obj = new elasticwrite();
    }
	
}
