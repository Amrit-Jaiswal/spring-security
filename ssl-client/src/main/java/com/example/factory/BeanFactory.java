package com.example.factory;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

@Configuration
public class BeanFactory {

    @Value("${trust.store}")
    private Resource trustStore;

    @Value("${trust.store.password}")
    private String trustStorePassword;

  /*  @Bean
    public RestTemplate restTemplate() throws IOException {
        SSLContext sslContext = new SSLContextBuilder()
                .loadTrustMaterial(trustStore.getURL(), trustStorePassword.toCharArray())
                .build();

        SSLConnectionSocketFactory socketFactory =
                new SSLConnectionSocketFactory(sslContext);

        HttpClient httpClient = HttpClients
                .custom()
                .setSSLSocketFactory(socketFactory).build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);

        return new RestTemplate(factory);
    }*/


    @Bean
    @Qualifier("resttemplate")
    public RestTemplate restTemplate2() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {
        KeyStore clientStore = KeyStore.getInstance("JKS");
        clientStore.load(new FileInputStream(this.getClass().getClassLoader().getResource("keystore/keystore.jks").getFile()), trustStorePassword.toCharArray());

        SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
        sslContextBuilder.useProtocol("TLS");
        sslContextBuilder.loadKeyMaterial(clientStore, trustStorePassword.toCharArray());
        sslContextBuilder.loadTrustMaterial(clientStore);

        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContextBuilder.build());
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslConnectionSocketFactory)
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        requestFactory.setConnectTimeout(10000); // 10 seconds
        requestFactory.setReadTimeout(10000); // 10 seconds
        return new RestTemplate(requestFactory);
    }
}
