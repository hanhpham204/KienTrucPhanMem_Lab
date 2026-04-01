# Base Image
FROM node:18

# Tạo thư mục làm việc
WORKDIR /app

# Copy package.json trước
COPY package.json .

# Cài dependencies
RUN npm install

# Copy toàn bộ source code
COPY . .

# Mở cổng 3000
EXPOSE 3000

# Chạy ứng dụng
CMD ["npm", "start"]