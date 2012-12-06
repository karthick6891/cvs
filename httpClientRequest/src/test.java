import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;


public class test {
	public static void main(String[] args) {
		
		
		String loginXml = "<tmssvc_request><login_request user_name=\"NANDI8-DAA-0127\" password=\"SCRAP5\" access_code=\"HOLT700399\" sds_date_time=\"2007-01-29T10:44:07\" sds_id=\"string\" cid=\"9836\" is_reopen=\"true\"/></tmssvc_request>";
		String saveXml1 = "<adssvc_request><save_testing_session_data user_name=\"\" password=\"\" access_code=\"\" sds_date_time=\"2007-01-29T10:44:07\" sds_id=\"string\" is_reopen=\"true\" /></adssvc_request>";
		String saveXml2 = "";
		String saveItemResponse1 = "";
		String saveItemResponse2 = "";
		HttpPost httppost = new HttpPost("http://santhanarajagopalan-java.appspot.com/TestDeliveryWeb/CTB/login.do");
		//HttpPost httppost = new HttpPost("http://127.0.0.1:9090/TestDeliveryWeb/CTB/save.do");
		HttpClient httpclient = new DefaultHttpClient();
		HttpParams myParams = new BasicHttpParams();
		try{
		HttpConnectionParams.setConnectionTimeout(myParams, 10000);
	        HttpConnectionParams.setSoTimeout(myParams, 10000);
	    	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("requestXML", loginXml));
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	       HttpResponse response = httpclient.execute(httppost);
	       Integer response_code = response.getStatusLine().getStatusCode();
	       System.out.println("Status Code" + response_code);
	       String temp = EntityUtils.toString(response.getEntity());
	       System.out.println(temp);
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}
}
