package com.csm.Repository;



import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.springframework.stereotype.Repository;

import com.csm.Bean.CouchBean;



@Repository
public class CouchDBRepository {
	
	HttpClient httpClient = new StdHttpClient.Builder().host("localhost").port(5984).username("admin").password("csmpl@123").build();
	CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
	
	//- - - - - - - - Creating database - - - - - - - - - - - - - - //
	public CouchDbConnector db = new StdCouchDbConnector("farmer_bean", dbInstance);
	
	
	public static CouchDBRepository createDbConnection() {
        //--------------- Creating Connection--------------------------//
		CouchDBRepository cn = new CouchDBRepository();
        cn.db.createDatabaseIfNotExists();
        //--------------- Creating Document----------------------------//
        return cn;
    }
	public static void saveData(CouchBean dataList) {
    	CouchDBRepository cn = createDbConnection();
        cn.db.create(dataList);
    }
}
	


