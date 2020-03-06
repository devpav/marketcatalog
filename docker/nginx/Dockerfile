FROM alpine/git as clone

ARG TOKEN_GIT
ARG USERNAME_GIT
ARG REPOSITORY_UI

WORKDIR /app

RUN git clone https://${TOKEN_GIT}@github.com/${USERNAME_GIT}/${REPOSITORY_UI}.git

FROM node:13.8.0 as angular

RUN mkdir /usr/src/app
WORKDIR /usr/src/app

ARG REPOSITORY_UI

RUN npm install -g @angular/cli@8.3.25

COPY --from=clone /app/${REPOSITORY_UI} /usr/src/app

RUN cd /usr/src/app && npm i && ng build --prod

# Build a small nginx image with static website
FROM nginx:alpine

COPY nginx.conf /etc/nginx/nginx.conf

RUN mkdir -p /etc/ssl/
RUN mkdir -p /home/html/

ARG REPOSITORY_UI

COPY --from=angular /usr/src/app/dist/${REPOSITORY_UI} /usr/share/nginx/html/

RUN cd /usr/share/nginx/html/ && ls -a

COPY ./certificate.crt /etc/ssl/
COPY ./private.key /etc/ssl/

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
