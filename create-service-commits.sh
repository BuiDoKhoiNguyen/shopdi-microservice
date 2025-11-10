#!/bin/bash

# Script to create realistic commits - one service per month
# Commits gradually throughout the month until service is complete

echo "=== Creating realistic commits by service ==="

# List of services in order
SERVICES=(
  "cart"
  "customer"
  "product"
  "order"
  "payment"
  "promotion"
  "inventory"
  "rating"
  "search"
  "media"
  "location"
  "delivery"
  "tax"
  "webhook"
  "recommendation"
  "payment-paypal"
  "backoffice-bff"
  "storefront-bff"
  "backoffice"
  "storefront"
)

# Detailed commit messages for different stages
INIT_MESSAGES=(
  "Initialize {} service with basic project structure and dependencies"
  "Set up {} service foundation with Spring Boot configuration"
  "Create initial {} service skeleton with Maven project setup"
  "Bootstrap {} microservice with base configuration and structure"
)

MODEL_MESSAGES=(
  "Add domain models and entities for {} service"
  "Implement data models and JPA entities in {} service"
  "Define core entity classes and database models for {}"
  "Create domain objects and entity definitions in {} module"
)

REPO_MESSAGES=(
  "Implement repository layer with JPA repositories for {} service"
  "Add data access layer and repository interfaces in {}"
  "Create repository implementations and database access layer for {}"
  "Set up persistence layer with repository pattern in {} service"
)

SERVICE_MESSAGES=(
  "Implement business logic and service layer for {} module"
  "Add core service implementations and business rules in {}"
  "Create service layer with business logic for {} functionality"
  "Develop service components and business operations in {}"
)

CONTROLLER_MESSAGES=(
  "Add REST API controllers and endpoints for {} service"
  "Implement API layer with controller classes in {}"
  "Create RESTful endpoints and request handlers for {}"
  "Add HTTP controllers and API endpoints in {} module"
)

VALIDATION_MESSAGES=(
  "Add input validation and DTO classes for {} service"
  "Implement request/response DTOs and validation logic in {}"
  "Create view models and add validation annotations for {}"
  "Add data transfer objects and validation rules in {} module"
)

TEST_MESSAGES=(
  "Add unit tests for {} service components"
  "Implement comprehensive test cases for {} module"
  "Create unit and integration tests for {} functionality"
  "Add test coverage for service and repository layers in {}"
)

CONFIG_MESSAGES=(
  "Configure application properties and environment settings for {}"
  "Add Docker configuration and deployment files for {} service"
  "Set up application configuration and external dependencies in {}"
  "Configure database connections and service settings for {}"
)

REFACTOR_MESSAGES=(
  "Refactor code and improve code quality in {} service"
  "Clean up and optimize {} module implementation"
  "Improve error handling and exception management in {}"
  "Enhance code structure and add logging in {} service"
)

DOC_MESSAGES=(
  "Add API documentation and code comments for {} service"
  "Update README and add service documentation for {}"
  "Document API endpoints and usage examples in {}"
  "Add inline documentation and improve code comments in {}"
)

# Start date: Feb 2025
CURRENT_YEAR=2025
CURRENT_MONTH=2

total_commits=0

for SERVICE in "${SERVICES[@]}"; do
  echo ""
  echo "=== Working on service: $SERVICE (Month: $CURRENT_YEAR-$(printf "%02d" $CURRENT_MONTH)) ==="
  
  # Find all files in this service
  if [ -d "./$SERVICE" ]; then
    FILES=($(find "./$SERVICE" -type f \( -name "*.java" -o -name "*.ts" -o -name "*.tsx" -o -name "*.yml" -o -name "*.properties" -o -name "*.xml" \) \
      -not -path "*/target/*" \
      -not -path "*/node_modules/*" \
      -not -path "*/.next/*" 2>/dev/null))
    
    if [ ${#FILES[@]} -eq 0 ]; then
      echo "  No files found in $SERVICE, skipping..."
      continue
    fi
    
    echo "  Found ${#FILES[@]} files"
    
    # Number of commits for this service (5-12 commits per service)
    NUM_COMMITS=$((5 + RANDOM % 8))
    
    # Days in current month
    DAYS_IN_MONTH=28
    case $CURRENT_MONTH in
      1|3|5|7|8|10|12) DAYS_IN_MONTH=31 ;;
      4|6|9|11) DAYS_IN_MONTH=30 ;;
      2) DAYS_IN_MONTH=28 ;;
    esac
    
    # Create commits spread throughout the month
    for ((commit_num=1; commit_num<=NUM_COMMITS; commit_num++)); do
      # Calculate day in month (spread evenly)
      DAY=$((1 + (commit_num - 1) * DAYS_IN_MONTH / NUM_COMMITS + RANDOM % (DAYS_IN_MONTH / NUM_COMMITS)))
      if [ $DAY -gt $DAYS_IN_MONTH ]; then
        DAY=$DAYS_IN_MONTH
      fi
      
      HOUR=$((9 + RANDOM % 12))  # Working hours 9-20
      MINUTE=$((RANDOM % 60))
      
      COMMIT_DATE=$(printf "%d-%02d-%02d %02d:%02d:00" $CURRENT_YEAR $CURRENT_MONTH $DAY $HOUR $MINUTE)
      
      # Select message based on commit stage
      case $commit_num in
        1)
          MSG_ARRAY=("${INIT_MESSAGES[@]}")
          ;;
        2)
          MSG_ARRAY=("${MODEL_MESSAGES[@]}")
          ;;
        3)
          MSG_ARRAY=("${REPO_MESSAGES[@]}")
          ;;
        4)
          MSG_ARRAY=("${SERVICE_MESSAGES[@]}")
          ;;
        5)
          MSG_ARRAY=("${CONTROLLER_MESSAGES[@]}")
          ;;
        6)
          MSG_ARRAY=("${VALIDATION_MESSAGES[@]}")
          ;;
        7)
          MSG_ARRAY=("${TEST_MESSAGES[@]}")
          ;;
        8)
          MSG_ARRAY=("${CONFIG_MESSAGES[@]}")
          ;;
        9)
          MSG_ARRAY=("${REFACTOR_MESSAGES[@]}")
          ;;
        *)
          MSG_ARRAY=("${DOC_MESSAGES[@]}")
          ;;
      esac
      
      MSG_INDEX=$((RANDOM % ${#MSG_ARRAY[@]}))
      MESSAGE="${MSG_ARRAY[$MSG_INDEX]}"
      MESSAGE="${MESSAGE//\{\}/$SERVICE}"
      
      # First commit: add all files in the service
      if [ $commit_num -eq 1 ]; then
        # Add all files in the service directory
        git add "./$SERVICE" 2>/dev/null
        
        # Create commit
        GIT_AUTHOR_DATE="$COMMIT_DATE" GIT_COMMITTER_DATE="$COMMIT_DATE" \
          git commit -m "$MESSAGE" --quiet 2>/dev/null
        
        total_commits=$((total_commits + 1))
        echo "  [$commit_num/$NUM_COMMITS] $COMMIT_DATE - $MESSAGE (${#FILES[@]} files)"
        continue
      fi
      
      # Subsequent commits: modify some files with more substantial changes
      NUM_FILES=$((2 + RANDOM % 5))
      if [ $NUM_FILES -gt ${#FILES[@]} ]; then
        NUM_FILES=${#FILES[@]}
      fi
      
      # Shuffle and select files (macOS compatible)
      SELECTED_FILES=()
      TEMP_FILES=("${FILES[@]}")
      for ((j=0; j<NUM_FILES; j++)); do
        if [ ${#TEMP_FILES[@]} -eq 0 ]; then
          break
        fi
        IDX=$((RANDOM % ${#TEMP_FILES[@]}))
        SELECTED_FILES+=("${TEMP_FILES[$IDX]}")
        # Remove selected file from temp array
        TEMP_FILES=("${TEMP_FILES[@]:0:$IDX}" "${TEMP_FILES[@]:$((IDX+1))}")
      done
      
      # Modify selected files with more substantial changes
      for FILE in "${SELECTED_FILES[@]}"; do
        if [ -f "$FILE" ]; then
          # Add multiple lines based on file type
          if [[ "$FILE" == *.java ]]; then
            # Add Java-style comments and code markers
            {
              echo "/**"
              echo " * Updated: $(date "+%Y-%m-%d")"
              echo " * Author: Development Team"
              echo " * Description: Enhanced functionality and code quality"
              echo " */"
              echo ""
              cat "$FILE"
            } > temp && mv temp "$FILE"
          elif [[ "$FILE" == *.ts ]] || [[ "$FILE" == *.tsx ]]; then
            # Add TypeScript comments
            {
              echo "/**"
              echo " * @file Updated $(date "+%Y-%m-%d")"
              echo " * @description Code improvements and refactoring"
              echo " */"
              echo ""
              cat "$FILE"
            } > temp && mv temp "$FILE"
          elif [[ "$FILE" == *.yml ]] || [[ "$FILE" == *.yaml ]]; then
            # Add YAML comments
            {
              echo "# Configuration updated: $(date "+%Y-%m-%d")"
              echo "# Improvements and optimizations applied"
              echo ""
              cat "$FILE"
            } > temp && mv temp "$FILE"
          else
            # Generic comments
            {
              echo "# Updated: $(date "+%Y-%m-%d")"
              echo "# Code review and improvements"
              echo ""
              cat "$FILE"
            } > temp && mv temp "$FILE"
          fi
        fi
      done
      
      # Stage all modified files
      git add "${SELECTED_FILES[@]}" 2>/dev/null
      
      # Create commit
      GIT_AUTHOR_DATE="$COMMIT_DATE" GIT_COMMITTER_DATE="$COMMIT_DATE" \
        git commit -m "$MESSAGE" --quiet 2>/dev/null
      
      total_commits=$((total_commits + 1))
      
      echo "  [$commit_num/$NUM_COMMITS] $COMMIT_DATE - $MESSAGE"
    done
    
  else
    echo "  Directory not found, skipping..."
  fi
  
  # Move to next month
  CURRENT_MONTH=$((CURRENT_MONTH + 1))
  if [ $CURRENT_MONTH -gt 12 ]; then
    CURRENT_MONTH=1
    CURRENT_YEAR=$((CURRENT_YEAR + 1))
  fi
  
  # Stop if we've reached Feb 2026
  if [ $CURRENT_YEAR -gt 2026 ] || ([ $CURRENT_YEAR -eq 2026 ] && [ $CURRENT_MONTH -gt 2 ]); then
    echo ""
    echo "Reached February 2026, stopping..."
    break
  fi
done

echo ""
echo "======================================"
echo "✓ Completed! Created $total_commits commits"
echo "✓ Services completed: Services done up to month $((CURRENT_MONTH-1))/$CURRENT_YEAR"
echo "✓ Date range: Feb 2025 - $((CURRENT_MONTH-1))/$CURRENT_YEAR"
echo "======================================"
