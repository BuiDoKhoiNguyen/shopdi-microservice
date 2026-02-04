#!/bin/bash

# Script to commit changes gradually with dates from Jan 2025 to Feb 2026

# Function to commit with a specific date
commit_with_date() {
    local date="$1"
    local message="$2"
    local files="$3"
    
    # Add files
    git add $files
    
    # Commit with specific date
    GIT_AUTHOR_DATE="$date" GIT_COMMITTER_DATE="$date" git commit -m "$message"
    
    echo "✓ Committed: $message (Date: $date)"
}

echo "Bắt đầu commit từng phần với timestamps từ tháng 1/2025..."
echo ""

# Tháng 1/2025 - Khởi tạo dự án
commit_with_date "2025-01-05 10:00:00" "Initial project setup" ".gitignore .gitattributes LICENSE"
commit_with_date "2025-01-10 14:30:00" "Add docker compose configuration" "docker-compose.yml docker-compose.*.yml"
commit_with_date "2025-01-15 09:15:00" "Add checkstyle configuration" "checkstyle/ gitleaks.toml"

# Tháng 2/2025 - Core modules
commit_with_date "2025-02-01 11:00:00" "Add common library module" "common-library/"
commit_with_date "2025-02-05 15:20:00" "Add parent pom configuration" "pom.xml"
commit_with_date "2025-02-10 10:45:00" "Add customer service" "customer/"
commit_with_date "2025-02-15 16:30:00" "Add product service" "product/"
commit_with_date "2025-02-20 13:00:00" "Add inventory service" "inventory/"

# Tháng 3/2025 - More services
commit_with_date "2025-03-01 09:30:00" "Add cart service" "cart/"
commit_with_date "2025-03-05 14:00:00" "Add order service" "order/"
commit_with_date "2025-03-10 11:15:00" "Add payment services" "payment/ payment-paypal/"
commit_with_date "2025-03-15 15:45:00" "Add media service" "media/"
commit_with_date "2025-03-20 10:30:00" "Add location service" "location/"

# Tháng 4/2025 - Additional services
commit_with_date "2025-04-01 13:20:00" "Add promotion service" "promotion/"
commit_with_date "2025-04-05 09:00:00" "Add rating service" "rating/"
commit_with_date "2025-04-10 16:15:00" "Add recommendation service" "recommendation/"
commit_with_date "2025-04-15 11:30:00" "Add tax service" "tax/"
commit_with_date "2025-04-20 14:45:00" "Add delivery service" "delivery/"

# Tháng 5/2025 - Support services
commit_with_date "2025-05-01 10:00:00" "Add webhook service" "webhook/"
commit_with_date "2025-05-05 15:30:00" "Add search service" "search/"
commit_with_date "2025-05-10 09:45:00" "Add sample data service" "sampledata/"

# Tháng 6/2025 - Frontend
commit_with_date "2025-06-01 13:00:00" "Add backoffice frontend" "backoffice/"
commit_with_date "2025-06-10 11:15:00" "Add storefront frontend" "storefront/"
commit_with_date "2025-06-15 16:00:00" "Add backoffice BFF" "backoffice-bff/"
commit_with_date "2025-06-20 10:30:00" "Add storefront BFF" "storefront-bff/"

# Tháng 7/2025 - Infrastructure
commit_with_date "2025-07-01 14:20:00" "Add identity configuration" "identity/"
commit_with_date "2025-07-05 09:30:00" "Add nginx configuration" "nginx/"
commit_with_date "2025-07-10 15:45:00" "Add docker configurations" "docker/"
commit_with_date "2025-07-15 11:00:00" "Add Kafka configurations" "kafka/"

# Tháng 8/2025 - Observability
commit_with_date "2025-08-01 10:15:00" "Add observability stack" "docker-compose.o11y.yml"
commit_with_date "2025-08-05 13:30:00" "Add tempo data" "tempo-data/"

# Tháng 9/2025 - K8s
commit_with_date "2025-09-01 09:00:00" "Add Kubernetes configurations" "k8s/"

# Tháng 10/2025 - Deployment
commit_with_date "2025-10-01 14:45:00" "Add deployment configurations" "deployment/"
commit_with_date "2025-10-10 11:20:00" "Add initialization scripts" "postgres_init.sql"

# Tháng 11/2025 - Scripts and automation
commit_with_date "2025-11-01 10:00:00" "Add startup scripts" "start-shopdi.sh start-source-connectors.sh"
commit_with_date "2025-11-10 15:30:00" "Add workflow scripts" "workflows.sh create-service-commits.sh"
commit_with_date "2025-11-15 13:15:00" "Add automation UI" "automation-ui/"

# Tháng 12/2025 - Documentation and configs
commit_with_date "2025-12-01 09:30:00" "Add shopdilocal configuration" "shopdilocal.yaml"
commit_with_date "2025-12-10 14:00:00" "Add architecture diagram" "shopdi-architecture-local.png"
commit_with_date "2025-12-15 11:45:00" "Add scripts folder" "scripts/"

# Tháng 1/2026 - CI/CD
commit_with_date "2026-01-05 10:20:00" "Add GitHub Actions workflows" ".github/"
commit_with_date "2026-01-15 15:00:00" "Add quickstart documentation" "QUICKSTART.md"

# Tháng 2/2026 - Final touches
commit_with_date "2026-02-01 09:00:00" "Add environment configuration" ".env"
commit_with_date "2026-02-04 14:30:00" "Remove old README" "."

echo ""
echo "✅ Hoàn thành! Đã tạo tất cả commits với timestamps từ 01/2025 đến 02/2026"
echo ""
echo "Để xem lịch sử commits, chạy: git log --oneline --date=short --pretty=format:'%ad %s'"
