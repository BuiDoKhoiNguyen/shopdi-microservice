package com.shopdi.webhook.repository;

import com.shopdi.webhook.model.WebhookEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebhookEventRepository extends JpaRepository<WebhookEvent, Long> {

    void deleteByWebhookId(Long webhookId);
}
