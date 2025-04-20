# Stage 1: build the Angular app
FROM node:20-alpine AS builder

WORKDIR /app

COPY package.json package-lock.json ./
RUN npm install

COPY . .
RUN npm run build

# Stage 2: development with hot reload (ng serve)
FROM node:20-alpine

WORKDIR /app

COPY package.json package-lock.json ./
RUN npm install -g @angular/cli && npm install

COPY . .

EXPOSE 4200
CMD ["ng", "serve", "--host", "0.0.0.0"]
