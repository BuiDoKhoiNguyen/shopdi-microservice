
set -x

# Auto restart when change configmap or secret
helm repo add stakater https://stakater.github.io/stakater-charts
helm repo update

helm dependency build ../charts/shopdi-configuration
helm upgrade --install shopdi-configuration ../charts/shopdi-configuration \
--namespace shopdi --create-namespace

