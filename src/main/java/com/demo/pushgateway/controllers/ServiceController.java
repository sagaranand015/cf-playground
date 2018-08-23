package com.demo.pushgateway.controllers;

import com.demo.pushgateway.responses.ServiceResponse;
import io.prometheus.client.Histogram;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
public class ServiceController {

    public static  final Histogram requestLatency = Histogram.build().name("requests_latency_seconds")
            .help("Request latency in seconds").register();

    @RequestMapping(value = {"metrics"}, method = RequestMethod.GET)
    public Response getMetrics() {
        try {

//            PushGateway pg = new PushGateway();
//            pg.pushAdd();

            System.out.println("Hello world!!");
            return Response.status(HttpStatus.OK.value()).
                    entity(new ServiceResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase())).
                    build();

        } catch (Exception e) {
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).
                    entity(new ServiceResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())).
                    build();
        }
    }

}
