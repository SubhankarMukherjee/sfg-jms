package guru.springframework.sfgjms.sender;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.sfgjms.config.JmsConfigConvert;
import guru.springframework.sfgjms.model.HelloWorld;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloSender {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;
    @Scheduled(fixedRate = 3000)
    public void sendMessage()
    {
        System.out.println("Sending Message");
        HelloWorld world= HelloWorld.builder().message("Hi").uuid(UUID.randomUUID()).build();
        jmsTemplate.convertAndSend(JmsConfigConvert.MY_QUEUE,world);
        System.out.println("Message Sent!");
    }

    /*@Scheduled(fixedRate = 2000)
    public void sendandReceiveMessage() throws JMSException {

        HelloWorld message = HelloWorld
                .builder()
                .uuid(UUID.randomUUID())
                .message("Hello")
                .build();

        Message receviedMsg = jmsTemplate.sendAndReceive(JmsConfigConvert.MY_SEND_RCV_QUEUE, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message helloMessage = null;

                try {
                    helloMessage = session.createTextMessage(objectMapper.writeValueAsString(message));
                    helloMessage.setStringProperty("_type", "guru.springframework.sfgjms.model.HelloWorld");

                    System.out.println("Sending Hello");

                    return helloMessage;

                } catch (JsonProcessingException e) {
                    throw new JMSException("boom");
                }
            }
        });

        System.out.println(receviedMsg.getBody(String.class));

    }*/
}
