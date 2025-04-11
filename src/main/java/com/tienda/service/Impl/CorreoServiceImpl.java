package com.tienda.service.impl;

import com.tienda.service.CorreoService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class CorreoServiceImpl implements CorreoService {

    @Autowired
    private JavaMailSender mailSender; //helper (envio del correo)

    @Override
      public void enviarCorreoHtml(
              String para, 
              String asunto, 
              String contenidoHtml) 
              throws MessagingException {
          
        MimeMessage message = mailSender.createMimeMessage(); //es parte del codigo de la libreria
        MimeMessageHelper helper = new MimeMessageHelper(message,true); //cree un nuevo mensaje(correo)
        helper.setTo(para);
        helper.setSubject(asunto);
        helper.setText(contenidoHtml,true);
        mailSender.send(message);
    }
}