package taa.poc.springbootsoapservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;

import java.util.List;

@EnableWs
@Configuration
public class SoapServerConfig extends WsConfigurerAdapter {
    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(new ServerEndpointInterceptor());
        super.addInterceptors(interceptors);
    }
}
