#!/bin/bash

# Script to rename all 'yas' packages to 'shopdi'
# Created: February 2026

set -e

PROJECT_ROOT="/Users/buidokhoinguyen/Desktop/shopdi-microservice"
cd "$PROJECT_ROOT"

echo "🔄 Starting package rename: com.yas → com.shopdi"
echo "================================================"

# Step 1: Clean target directories first (avoid renaming compiled files)
echo ""
echo "📦 Step 1: Cleaning target directories..."
find . -type d -name "target" -exec rm -rf {} + 2>/dev/null || true
echo "✅ Target directories cleaned"

# Step 2: Rename directories from com/yas to com/shopdi
echo ""
echo "📁 Step 2: Renaming directories..."
find . -path "*/src/*" -type d -name "yas" | while read dir; do
    parent_dir=$(dirname "$dir")
    if [ "$(basename "$parent_dir")" = "com" ]; then
        new_dir="$parent_dir/shopdi"
        if [ -d "$dir" ] && [ ! -d "$new_dir" ]; then
            echo "  Renaming: $dir → $new_dir"
            mv "$dir" "$new_dir"
        fi
    fi
done
echo "✅ Directories renamed"

# Step 3: Update package declarations in Java files
echo ""
echo "📝 Step 3: Updating package declarations..."
find . -path "*/src/*" -name "*.java" -exec sed -i '' 's/package com\.yas/package com.shopdi/g' {} +
echo "✅ Package declarations updated"

# Step 4: Update import statements in Java files  
echo ""
echo "📝 Step 4: Updating import statements..."
find . -path "*/src/*" -name "*.java" -exec sed -i '' 's/import com\.yas/import com.shopdi/g' {} +
echo "✅ Import statements updated"

# Step 5: Update pom.xml files
echo ""
echo "📝 Step 5: Updating pom.xml files..."
find . -name "pom.xml" -exec sed -i '' 's/<groupId>com\.yas/<groupId>com.shopdi/g' {} +
find . -name "pom.xml" -exec sed -i '' 's/<artifactId>yas-/<artifactId>shopdi-/g' {} +
echo "✅ pom.xml files updated"

# Step 6: Update application.properties/yml files
echo ""
echo "📝 Step 6: Updating application properties..."
find . -path "*/src/*" -name "*.properties" -exec sed -i '' 's/com\.yas/com.shopdi/g' {} + 2>/dev/null || true
find . -path "*/src/*" -name "*.yml" -exec sed -i '' 's/com\.yas/com.shopdi/g' {} + 2>/dev/null || true
find . -path "*/src/*" -name "*.yaml" -exec sed -i '' 's/com\.yas/com.shopdi/g' {} + 2>/dev/null || true
echo "✅ Application properties updated"

# Step 7: Rename identity themes directories if exist
echo ""
echo "📝 Step 7: Checking identity themes..."
if [ -d "./identity/themes/yas" ]; then
    mv "./identity/themes/yas" "./identity/themes/shopdi" 2>/dev/null || true
    echo "  Renamed identity/themes/yas → identity/themes/shopdi"
fi
if [ -d "./identity/themes/shopdi/theme/yas" ]; then
    mv "./identity/themes/shopdi/theme/yas" "./identity/themes/shopdi/theme/shopdi" 2>/dev/null || true
    echo "  Renamed theme/yas → theme/shopdi"
fi
echo "✅ Identity themes updated"

echo ""
echo "================================================"
echo "✅ Package rename completed!"
echo ""
echo "📊 Summary:"
echo "  - Directories: com/yas → com/shopdi"
echo "  - Packages: com.yas.* → com.shopdi.*"
echo "  - Imports: com.yas.* → com.shopdi.*"
echo "  - Maven groupId: com.yas → com.shopdi"
echo ""
echo "⚠️  Next steps:"
echo "  1. Run 'mvn clean install' to verify build"
echo "  2. Check for any remaining 'yas' references"
echo "  3. Update Docker images if needed"
