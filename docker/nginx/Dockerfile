# Build a small nginx image with static website
FROM nginx:alpine

COPY nginx.conf /etc/nginx/nginx.conf

RUN mkdir -p /etc/ssl/

COPY devpav.ru.crt /etc/ssl/
COPY devpav.ru.key /etc/ssl/

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]