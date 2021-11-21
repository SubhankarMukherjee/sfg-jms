package guru.springframework.sfgjms.listener;

import guru.springframework.sfgjms.config.JmsConfigConvert;
import guru.springframework.sfgjms.model.HelloWorld;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


import javax.jms.Destination;
import javax.jms.JMSException;
import java.util.UUID;


@RequiredArgsConstructor
//@Component
public class HelloMessageListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfigConvert.MY_QUEUE)
    public void listen(@Payload HelloWorld helloWorldMessage,
                       @Headers MessageHeaders headers, Message message){

        System.out.println("I Got a Message!!!!!");

         System.out.println(helloWorldMessage);





    }

   /* @JmsListener(destination = JmsConfigConvert.MY_SEND_RCV_QUEUE)
    public void listenForHello(@Payload HelloWorld helloWorldMessage,
                               @Headers MessageHeaders headers, javax.jms.Message message) throws JMSException {

        HelloWorld payloadMsg = HelloWorld
                .builder()
                .uuid(UUID.randomUUID())
                .message("World!!")
                .build();

jmsTemplate.convertAndSend((Destination) message.getHeaders().get("jmsReplyTo");// Spring implementaton
        jmsTemplate.convertAndSend((Destination) message.getJMSReplyTo(),payloadMsg); // JMS implemnetaion

    }*/
}
