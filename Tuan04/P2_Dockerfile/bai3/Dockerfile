# Base image
FROM node:18-alpine

# Thư mục làm việc
WORKDIR /app

# Copy package.json
COPY package*.json ./

# Cài dependencies
RUN npm install

# Copy toàn bộ source code
COPY . .

# Build React app
RUN npm run build

# Cài serve để chạy build
RUN npm install -g serve

# Mở cổng
EXPOSE 3000

# Chạy ứng dụng React
CMD ["serve", "-s", "build", "-l", "3000"]