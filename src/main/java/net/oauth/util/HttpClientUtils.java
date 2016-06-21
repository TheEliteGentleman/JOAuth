/**
 * 
 */
package net.oauth.util;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import net.oauth.http.HttpClient;
import net.oauth.http.impl.ApacheHttpClient;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;


/**
 * @author Buhake Sindi
 * @since 11 October 2011
 *
 */
public class HttpClientUtils {

	private HttpClientUtils() {}
	
	public static HttpClient bypassAllSSL(org.apache.http.client.HttpClient base) throws KeyManagementException, NoSuchAlgorithmException {
		SSLContext context = SSLContext.getInstance("TLS");
		X509TrustManager trustManager = new X509TrustManager() {
			
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				// TODO Auto-generated method stub
				
			}
		};
		
		context.init(null, new TrustManager[] {trustManager}, null);
		
		HttpClientBuilder builder = HttpClientBuilder.create();
//		SSLConnectionSocketFactory sslConnectionFactory = new SSLConnectionSocketFactory(context, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		SSLConnectionSocketFactory sslConnectionFactory = new SSLConnectionSocketFactory(context, new DefaultHostnameVerifier());
		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create().register("https", sslConnectionFactory).build();
		HttpClientConnectionManager clientConnectionManager = new BasicHttpClientConnectionManager(registry);
		builder.setConnectionManager(clientConnectionManager);
		builder.setSSLSocketFactory(sslConnectionFactory);
		return new ApacheHttpClient(builder.build());
		
//		SSLSocketFactory sslSocketFactory = new SSLSocketFactory(context, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//		ClientConnectionManager clientConnectionManager = base.getConnectionManager();
//		SchemeRegistry schemeRegistry = clientConnectionManager.getSchemeRegistry();
//		schemeRegistry.register(new Scheme("https", 443, sslSocketFactory));
//		return new ApacheHttpClient(new DefaultHttpClient(clientConnectionManager, base.getParams()));
	}
}
