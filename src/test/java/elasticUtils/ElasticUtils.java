package elasticUtils;

//import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.json.JSONObject;

import bsh.This;
import elasticUtils.SearchDto.SearchPriority;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;



public class ElasticUtils {
	public static final String ELASTIC_SEARCH_CLOUD_BASE_URL = "http://127.0.0.1:9200";
	public static final int DEFAULT_MAX_TOTAL_CONNECTION_PER_ROUTE = 2;
	public static final int MAX_TOTAL_CONNECTION = 20;
	
	private static JestClientFactory jestClientFactory = null;
	private static JestClient jestClient = null;
	public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	
	private static Logger logger = Logger.getLogger(ElasticUtils.class.getName());
	
	/**
	 * @see This method will return JestClient of base of given elastic search cloud url
	 * @return JestClient
	 */
	public static JestClient getConnection() {
		if(jestClient == null) {
			jestClientFactory = new JestClientFactory();
			jestClientFactory.setHttpClientConfig(new HttpClientConfig.Builder(ELASTIC_SEARCH_CLOUD_BASE_URL).multiThreaded(true)
					// Per default this implementation will create no more than 2 concurrent
					// connections per given route
					.defaultMaxTotalConnectionPerRoute(DEFAULT_MAX_TOTAL_CONNECTION_PER_ROUTE)
					// and no more 20 connections in total
					.maxTotalConnection(MAX_TOTAL_CONNECTION)
					.build());
			jestClient = jestClientFactory.getObject();
		}
		return jestClient;
	}
	
	/**
	 * @param searchDtoList
	 * @see this method is used to create Boolean query SearchSouceBuider from given list of search dto
	 * @return SearchSourceBuilder
	 */
	public static SearchSourceBuilder getBoolSearchSourceBuilder(List<SearchDto> searchDtoList) {
	    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
	    searchSourceBuilder.from(0); 
        searchSourceBuilder.size(10000); 
	    try {
	        if(searchDtoList != null && !searchDtoList.isEmpty()) {
	            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
	            int length = searchDtoList.size();
	            for(int i = 0; i < length; i++) {
	                SearchDto searchDto = searchDtoList.get(i);
	                if(isValid(searchDto)) {
	                    if(searchDto.getFieldPriority().equals(SearchPriority.MUST)) {
	                        if(searchDto.getEquality() != null) {
	                            long value = 0;
	                            try {
	                                value = Long.valueOf(searchDto.getFieldValue());  
                                } catch (Exception e) {
                                    logger.info("Exception in Long value of : "+searchDto.getFieldValue());
                                }
	                        } else {
	                            boolQueryBuilder = boolQueryBuilder.must(QueryBuilders.matchQuery(searchDto.getFieldKey(), searchDto.getFieldValue()));              
	                        }
	                    } else if(searchDto.getFieldPriority().equals(SearchPriority.SHOULD)) {
	                        boolQueryBuilder = boolQueryBuilder.should(QueryBuilders.matchQuery(searchDto.getFieldKey(), searchDto.getFieldValue()));
	                    } 
	                }
	            }
	            searchSourceBuilder.query(boolQueryBuilder);
	        }
        } catch (Exception e) {
            logger.log(Level.WARNING, "Exception occured in getBoolSearchSourceBuilder", e);
        }
	    return searchSourceBuilder;  
	}
	
	/**
	 * @param searchDto
	 * @see this method is used to validate given SearchDto object
	 * @return boolean
	 */
	public static boolean isValid(SearchDto searchDto) {
        if(searchDto != null && searchDto.getFieldKey() != null && searchDto.getFieldValue() != null && searchDto.getFieldPriority() != null) {
            return true;
        }
        return false;
    }
	
	/**
	 * @param searchSourceBuilder
	 * @param elastcSearchClouldIndexName
	 * @param elastcSearchClouldIndexType
	 * @see this method is used to create Search from given SearchSourceBuilder, index name and index type
	 * @return Search
	 */
	public static Search getSearchObject(SearchSourceBuilder searchSourceBuilder, String elastcSearchClouldIndexName, String elastcSearchClouldIndexType) {
	    if(searchSourceBuilder != null && elastcSearchClouldIndexName != null && elastcSearchClouldIndexType != null) {
  	        return (Search) new Search.Builder(searchSourceBuilder.toString())
                .addIndex(elastcSearchClouldIndexName).addType(elastcSearchClouldIndexType)
                .build();  
	    }
	    return null;
	}
	
	/**
	 * @param search
	 * @see this method is used to execute given Search on elastic connection
	 * @return SearchResult
	 */
	public static SearchResult executeSearch(Search search) {
	    try {
	        JestClient client = ElasticUtils.getConnection();
            return client.execute(search);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Exception occured in executeSearch", e);
        }
	    return null;
	}
	
	/**
	 * @param source
	 * @param elastcSearchClouldIndexName
	 * @param elastcSearchClouldIndexType
	 * @see This method will update given object in elasticdb by its id
	 * @return JestResult
	 */
	public static JestResult updateObject(String updatedData, String elastcSearchClouldIndexName, String elastcSearchClouldIndexType) {
		JestResult result = null;
		try {
		    JSONObject updatedJsonObject = new JSONObject(updatedData);
		    String source = (updatedData.contains("_source")) ? updatedJsonObject.getJSONObject("_source").toString() :  updatedJsonObject.getJSONObject("source").toString() ;
			result = getConnection().execute(
		            new Index.Builder(source)
		                    .index(elastcSearchClouldIndexName)
		                    .type(elastcSearchClouldIndexType)
		                    .id(updatedData.contains("_id") ? updatedJsonObject.getString("_id") : updatedJsonObject.getString("id"))
		                    .build());
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception occured while update object to elasticdb", e);
		}
		return result;
	}
	

	/**
	 * @param source
	 * @param elastcSearchClouldIndexName
	 * @param elastcSearchClouldIndexType
	 * @see This method will update given object in elasticdb by its id
	 * @return JestResult
	 */
	public static JestResult logJsonString(String updatedData, String elastcSearchClouldIndexName, String elastcSearchClouldIndexType) {
		JestResult result = null;
		try {
		    JSONObject updatedJsonObject = new JSONObject(updatedData);
		    String source = (updatedData.contains("_source")) ? updatedJsonObject.getJSONObject("_source").toString() :  updatedJsonObject.getJSONObject("source").toString() ;
			result = getConnection().execute(
		            new Index.Builder(source)
		                    .index(elastcSearchClouldIndexName)
		                    .type(elastcSearchClouldIndexType)
		                    .id(updatedData.contains("_id") ? updatedJsonObject.getString("_id") : updatedJsonObject.getString("id"))
		                    .build());
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception occured while update object to elasticdb", e);
		}
		return result;
	}
}
