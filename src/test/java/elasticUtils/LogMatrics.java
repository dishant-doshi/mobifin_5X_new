package elasticUtils;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;

import utils.ReadProperty;

public class LogMatrics {

	private static Logger logger = Logger.getLogger(LogMatrics.class.getName());

	private String indexName;
	private String indexType;
	public int waitSeconds = 0;

	public LogMatrics() {

	}

	public LogMatrics(int waitSeconds) {
		this.waitSeconds = waitSeconds;
	}

	private String elastiUrl = "http://10.10.180.82:9200/apiexecution/matrics";

	public LogMatrics(String indexName, String indexType) {
		this.indexName = indexName;
		this.indexType = indexType;
	}

	public void logToElasticsearch(Map<String, Object> elasticData) {
		try {
			if (elasticData != null && elasticData.size() > 0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
				sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

				elasticData.put("timeStamp", sdf.format(new Date()));

				Gson gson = new Gson();
				// ObjectMapper objectMapper = new ObjectMapper();
				// String json = objectMapper.writeValueAsString(elasticData);
				Client client = ClientBuilder.newClient();
				WebTarget webTarget = null;
				if (this.indexName != null && this.indexType != null) {
					webTarget = client.target("http://192.168.33.214:9200/" + this.indexName + "/" + this.indexType);
				} else {
					webTarget = client.target(elastiUrl);
				}

				DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd_MM_yyyy");
				LocalDateTime currentDate = LocalDateTime.now();
				String date = dateformatter.format(currentDate);
				elasticData.put("Task Name", ReadProperty.getPropertyValue("TASK_NAME") + "_" + date);
				String temp = gson.toJson(elasticData);
				Response response = webTarget.request().post(Entity.entity(temp, MediaType.APPLICATION_JSON),
						Response.class);
				logger.info("Response: " + response.toString());
			}
		} catch (

		Exception ex) {
			logger.log(Level.WARNING, "Exception in logToElasticsearch method", ex);
			ex.printStackTrace();
		}
	}

	public static void main(String[] args)
			throws InterruptedException, JsonParseException, JsonMappingException, IOException {

		LogMatrics logMatrics = new LogMatrics("testkibana", "docs");
		Map<String, Object> map = new HashMap<>();
		map.put("UserName", "Badal");
		map.put("value", 0);
		logMatrics.logToElasticsearch(map);
	}

}