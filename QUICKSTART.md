# 🚀 Quick Start Guide - YAS E-commerce Platform

## 📋 Prerequisites
- Docker & Docker Compose
- 8GB+ RAM available
- Ports available: 80, 5432, 8080-8102, 3000-3001, 9200

---

## 🎯 Option 1: Core Only (Minimal Setup)
**RAM Required:** ~4-6GB  
**Services:** Infrastructure + Essential Backend (Product, Customer, Location, Inventory, Media)

```bash
# Start core services
docker-compose -f docker-compose.core.yml up -d

# Check status
docker-compose -f docker-compose.core.yml ps

# View logs
docker-compose -f docker-compose.core.yml logs -f

# Stop
docker-compose -f docker-compose.core.yml down
```

**Access:**
- Keycloak (Identity): http://localhost:8080 (admin/admin)
- PgAdmin (Database): http://localhost:5050 (admin@yas.com/admin)
- Product Service: http://localhost:8087
- Customer Service: http://localhost:8088
- Location Service: http://localhost:8084
- Inventory Service: http://localhost:8091
- Media Service: http://localhost:8085
- Backoffice BFF: http://localhost:8086
- Storefront BFF: http://localhost:8090

---

## 🛒 Option 2: Core + Business Services
**RAM Required:** ~8-12GB  
**Services:** Core + Cart, Order, Payment, Promotion, Tax, Delivery, Rating, Webhook

```bash
# Step 1: Start core
docker-compose -f docker-compose.core.yml up -d

# Step 2: Wait for core to be ready (2-3 minutes)
docker-compose -f docker-compose.core.yml ps

# Step 3: Start business services
docker-compose -f docker-compose.business.yml up -d

# Check all services
docker-compose -f docker-compose.core.yml ps
docker-compose -f docker-compose.business.yml ps

# Stop all
docker-compose -f docker-compose.business.yml down
docker-compose -f docker-compose.core.yml down
```

**Additional Access:**
- Cart Service: http://localhost:8089
- Order Service: http://localhost:8092
- Payment Service: http://localhost:8093
- PayPal Payment: http://localhost:8094
- Promotion Service: http://localhost:8095
- Tax Service: http://localhost:8096
- Delivery Service: http://localhost:8097
- Rating Service: http://localhost:8098
- Webhook Service: http://localhost:8099

---

## 🔍 Option 3: Core + Support Services
**RAM Required:** ~10-14GB  
**Services:** Core + Search, Kafka, Redis, Recommendation, Elasticsearch

```bash
# Step 1: Start core
docker-compose -f docker-compose.core.yml up -d

# Step 2: Wait for core to be ready
sleep 120

# Step 3: Start support services
docker-compose -f docker-compose.support.yml up -d

# Check status
docker-compose -f docker-compose.core.yml ps
docker-compose -f docker-compose.support.yml ps

# Stop all
docker-compose -f docker-compose.support.yml down
docker-compose -f docker-compose.core.yml down
```

**Additional Access:**
- Elasticsearch: http://localhost:9200
- Search Service: http://localhost:8100
- Kafka UI: http://localhost:8089
- Redis: localhost:6379
- Recommendation Service: http://localhost:8101
- Sample Data Loader: http://localhost:8102

---

## 🌐 Option 4: Full Stack (All Services)
**RAM Required:** ~16-24GB  
**Services:** Everything including Frontend

```bash
# Start in order
docker-compose -f docker-compose.core.yml up -d
sleep 120  # Wait for core

docker-compose -f docker-compose.business.yml up -d
sleep 60   # Wait for business

docker-compose -f docker-compose.support.yml up -d
sleep 60   # Wait for support

docker-compose -f docker-compose.frontend.yml up -d

# Check all
docker ps

# Stop all (reverse order)
docker-compose -f docker-compose.frontend.yml down
docker-compose -f docker-compose.support.yml down
docker-compose -f docker-compose.business.yml down
docker-compose -f docker-compose.core.yml down
```

**Additional Access:**
- Nginx Reverse Proxy: http://localhost
- Backoffice UI: http://localhost:3000
- Storefront UI: http://localhost:3001
- Swagger UI: http://localhost:8888

---

## 🛠️ Useful Commands

### Check Service Health
```bash
# All services
docker ps

# Specific compose file
docker-compose -f docker-compose.core.yml ps

# Check logs
docker-compose -f docker-compose.core.yml logs -f [service-name]
```

### Clean Up
```bash
# Remove containers only
docker-compose -f docker-compose.core.yml down

# Remove containers + volumes (clean database)
docker-compose -f docker-compose.core.yml down -v

# Remove all (including images)
docker-compose -f docker-compose.core.yml down -v --rmi all
```

### Rebuild Services
```bash
# Rebuild and restart
docker-compose -f docker-compose.core.yml up -d --build

# Rebuild specific service
docker-compose -f docker-compose.core.yml up -d --build product
```

### Database Access
```bash
# Via PgAdmin (GUI)
# http://localhost:5050

# Via psql (CLI)
docker exec -it $(docker ps -qf "name=postgres") psql -U admin -d product

# List all databases
docker exec -it $(docker ps -qf "name=postgres") psql -U admin -c "\l"
```

---

## 🔐 Default Credentials

### Keycloak (Identity Service)
- URL: http://localhost:8080
- Admin Console: http://localhost:8080/admin
- Username: `admin`
- Password: `admin`
- Realm: `yas`

### PgAdmin (Database Management)
- URL: http://localhost:5050
- Email: `admin@yas.com`
- Password: `admin`

### PostgreSQL
- Host: `localhost:5432`
- Username: `admin`
- Password: `admin`
- Databases: `product`, `customer`, `order`, `cart`, etc.

---

## 🐛 Troubleshooting

### Services won't start
```bash
# Check logs
docker-compose -f docker-compose.core.yml logs

# Check if ports are available
lsof -i :5432  # PostgreSQL
lsof -i :8080  # Keycloak

# Restart specific service
docker-compose -f docker-compose.core.yml restart product
```

### Out of Memory
```bash
# Check Docker resource limits
docker info | grep -i memory

# Increase Docker memory in Docker Desktop settings
# Minimum: 8GB for core, 16GB for full stack
```

### Database connection errors
```bash
# Wait for PostgreSQL to be ready
docker-compose -f docker-compose.core.yml logs postgres

# Manually check connection
docker exec -it $(docker ps -qf "name=postgres") pg_isready -U admin
```

### Port conflicts
```bash
# Check what's using the port
lsof -i :8080

# Kill the process
kill -9 <PID>

# Or change port in docker-compose file
```

---

## 📊 Resource Requirements Summary

| Setup | Services | RAM | Disk | CPU |
|-------|----------|-----|------|-----|
| Core | 9 | 4-6GB | 5GB | 2-4 cores |
| Core + Business | 18 | 8-12GB | 10GB | 4-6 cores |
| Core + Support | 14 | 10-14GB | 15GB | 4-6 cores |
| Full Stack | 24+ | 16-24GB | 20GB | 6-8 cores |

---

## 🎓 Development Workflow

### For Local Development (without Docker)
```bash
# 1. Start only infrastructure
docker-compose -f docker-compose.core.yml up -d postgres identity

# 2. Run services with Maven
cd product && mvn spring-boot:run
cd customer && mvn spring-boot:run
# etc...

# 3. Run frontend with npm
cd backoffice && npm run dev
cd storefront && npm run dev
```

### Building Services
```bash
# Build all services (from root)
mvn clean install -DskipTests

# Build specific service
cd product && mvn clean package -DskipTests

# Build Docker image
cd product && docker build -t yas-product:latest .
```

---

## 📝 Next Steps

1. ✅ Start with **Core** setup to test basic functionality
2. 🛒 Add **Business** services when ready to test e-commerce flows
3. 🔍 Add **Support** services for search and recommendations
4. 🌐 Add **Frontend** for full user experience
5. 📚 Check [README.md](README.md) for detailed documentation

---

## 🆘 Getting Help

- Documentation: Check service-specific README files
- Logs: Use `docker-compose logs -f [service-name]`
- Issues: Check GitHub issues
- Swagger API: http://localhost:8888 (after starting services)
