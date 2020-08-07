package tacos.messaging;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import tacos.Order;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Service
@RequiredArgsConstructor
public class JmsOrderMessagingService implements OrderMessagingService {

    private final JmsTemplate jms;

    @Override
    public void sendOrder(Order order) {

//        jms.send(new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                return session.createObjectMessage(order);
//            }
//        });

        // jms.send(session -> session.createObjectMessage(order));

        jms.convertAndSend("tacocloud.order.queue", order);
    }
}
