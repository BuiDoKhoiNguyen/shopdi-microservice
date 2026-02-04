package com.shopdi.webhook.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.shopdi.webhook.integration.api.WebhookApi;
import com.shopdi.webhook.model.WebhookEventNotification;
import com.shopdi.webhook.model.dto.WebhookEventNotificationDto;
import com.shopdi.webhook.repository.WebhookEventNotificationRepository;
import com.shopdi.webhook.service.WebhookService;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WebhookServiceTest {

    @Mock
    WebhookEventNotificationRepository webhookEventNotificationRepository;
    @Mock
    WebhookApi webHookApi;

    @InjectMocks
    WebhookService webhookService;

    @Test
    void test_notifyToWebhook_ShouldNotException() {

        WebhookEventNotificationDto notificationDto = WebhookEventNotificationDto
                .builder()
                .notificationId(1L)
                .url("")
                .secret("")
                .build();

        WebhookEventNotification notification = new WebhookEventNotification();
        when(webhookEventNotificationRepository.findById(notificationDto.getNotificationId()))
                .thenReturn(Optional.of(notification));

        webhookService.notifyToWebhook(notificationDto);

        verify(webhookEventNotificationRepository).save(notification);
        verify(webHookApi).notify(notificationDto.getUrl(), notificationDto.getSecret(), notificationDto.getPayload());
    }
}
