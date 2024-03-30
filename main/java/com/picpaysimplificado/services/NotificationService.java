package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);
        //MINUTO  50 O LINK
        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("", notificationRequest, String.class)

        if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
            throw new Exception("ta sem funcionar");
            System.out.println("deu erro ao enviar notificação");
        }
    }
}
