package com.shopdi.webhook.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.shopdi.webhook.model.Event;
import com.shopdi.webhook.model.Webhook;
import com.shopdi.webhook.model.WebhookEvent;
import com.shopdi.webhook.model.WebhookEventNotification;
import com.shopdi.webhook.model.dto.WebhookEventNotificationDto;
import com.shopdi.webhook.model.enums.EventName;
import com.shopdi.webhook.repository.EventRepository;
import com.shopdi.webhook.repository.WebhookEventNotificationRepository;
import com.shopdi.webhook.service.ProductEventService;
import com.shopdi.webhook.service.WebhookService;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductEventServiceTest {

    @Mock
    EventRepository eventRepository;
    @Mock
    WebhookEventNotificationRepository webhookEventNotificationRepository;
    @Mock
    WebhookService webhookService;
    @InjectMocks
    ProductEventService productEventService;

    @Test
    void test_onProductEvent_shouldNotException() {
        ObjectMapper objectMapper = new ObjectMapper();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("op", "u");
        objectNode.set("after", objectMapper.createObjectNode());

        Event event = new Event();
        WebhookEvent webhookEvent = new WebhookEvent();
        Webhook webhook = new Webhook();
        List<WebhookEvent> webhookEvents = List.of(webhookEvent);

        event.setWebhookEvents(webhookEvents);
        webhookEvent.setWebhook(webhook);

        WebhookEventNotification notification = new WebhookEventNotification();
        notification.setWebhookEventId(1L);

        when(eventRepository.findByName(EventName.ON_PRODUCT_UPDATED)).thenReturn(Optional.of(event));
        when(webhookEventNotificationRepository.save(any(WebhookEventNotification.class))).thenReturn(notification);

        productEventService.onProductEvent(objectNode);

        verify(webhookEventNotificationRepository).save(any(WebhookEventNotification.class));
        verify(webhookService).notifyToWebhook(any(WebhookEventNotificationDto.class));
    }

    @Test
    void test_onProductEvent_shouldNotDoAnythingWhenOpUnknown() {
        ObjectMapper objectMapper = new ObjectMapper();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("op", "k");

        productEventService.onProductEvent(objectNode);

        verify(webhookEventNotificationRepository, times(0)).save(any(WebhookEventNotification.class));
        verify(webhookService, times(0)).notifyToWebhook(any(WebhookEventNotificationDto.class));
    }
}
