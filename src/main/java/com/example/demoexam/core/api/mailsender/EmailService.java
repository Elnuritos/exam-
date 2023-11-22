package com.example.demoexam.core.api.mailsender;

import com.example.demoexam.core.model.Publisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmailService {

    String send(List<Publisher> publishers, String message);

}
