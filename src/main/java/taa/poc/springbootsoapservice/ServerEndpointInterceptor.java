package taa.poc.springbootsoapservice;

import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;
import org.springframework.ws.transport.http.HttpUrlConnection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
public class ServerEndpointInterceptor implements EndpointInterceptor {
    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
        logMessage("handleRequest", messageContext.getRequest());
        showHeaders();
        return true;
    }

    private void showHeaders() throws IOException {
        TransportContext context = TransportContextHolder.getTransportContext();
        HttpServletConnection httpServletConnection = (HttpServletConnection)context.getConnection();
        Iterator<String> requestHeaderNames = httpServletConnection.getRequestHeaderNames();
        Iterable<String> iterable = () -> requestHeaderNames;
        StreamSupport.stream(iterable.spliterator(), false).forEach(header -> {
            try {
                Iterator<String> requestHeaders = httpServletConnection.getRequestHeaders(header);
                Iterable<String> iterable2 = () -> requestHeaders;
                List<String> actualList = StreamSupport.stream(iterable2.spliterator(), false).collect(Collectors.toList());
                System.out.println(header + ":" + actualList);
            } catch (IOException e) {
                System.err.println(e);
            }

        });
    }

    public void logMessage(String id, WebServiceMessage webServiceMessage) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            webServiceMessage.writeTo(byteArrayOutputStream);

            String httpMessage = new String(byteArrayOutputStream.toByteArray());
            System.out.println(id + "----------------------------" + httpMessage );
        } catch (Exception e) {
            System.err.println("Unable to log HTTP message.");
        }
    }

    private HttpUrlConnection getHttpUrlConnection() {
        TransportContext context = TransportContextHolder.getTransportContext();
        return (HttpUrlConnection) context.getConnection();
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        logMessage("handleResponse", messageContext.getResponse());
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        System.out.println("handleFault");
        return false;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
        System.out.println("afterCompletion: " + messageContext.getRequest());
        System.out.println("afterCompletion: " + messageContext.getResponse());
    }
}
