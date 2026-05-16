require('dotenv').config();
const express = require('express');
const cors = require('cors');
const morgan = require('morgan');

const app = express();
const PORT = process.env.PORT || 8083;
const HOST = process.env.HOST || '0.0.0.0';

app.use(cors());
app.use(morgan('combined'));
app.use(express.json());

// ===================== IN-MEMORY STORE =====================
const bookings = [
  {
    id: 'bk0001',
    userId: 'u001',
    tourId: 't001',
    tourName: 'Khám Phá Hạ Long Bay 3N2Đ',
    participants: 2,
    totalPrice: 7000000,
    status: 'confirmed',
    paymentStatus: 'paid',
    bookingDate: '2024-05-10T08:00:00Z',
    notes: 'Booking mẫu - seed data',
  },
];

let bookingCounter = 2;

// ===================== ROUTES =====================

// Health check
app.get('/health', (req, res) => {
  res.json({ service: 'booking-service', status: 'UP', port: PORT });
});

// POST /bookings - Tạo booking mới (chỉ nhận từ Orchestrator)
app.post('/bookings', (req, res) => {
  const { userId, tourId, tourName, participants, unitPrice, notes } = req.body;

  if (!userId || !tourId || !participants) {
    return res.status(400).json({
      success: false,
      message: 'Thiếu thông tin bắt buộc: userId, tourId, participants',
    });
  }

  const totalPrice = (unitPrice || 0) * participants;

  const booking = {
    id: 'bk' + String(bookingCounter++).padStart(4, '0'),
    userId,
    tourId,
    tourName: tourName || 'N/A',
    participants: Number(participants),
    unitPrice: unitPrice || 0,
    totalPrice,
    status: 'pending',
    paymentStatus: 'unpaid',
    bookingDate: new Date().toISOString(),
    notes: notes || '',
  };

  bookings.push(booking);
  console.log(`[CREATE BOOKING] id=${booking.id} user=${userId} tour=${tourId} total=${totalPrice}`);
  res.status(201).json({ success: true, message: 'Tạo booking thành công', data: booking });
});

// PATCH /bookings/:id/status - Cập nhật trạng thái booking (dùng bởi Orchestrator sau thanh toán)
app.patch('/bookings/:id/status', (req, res) => {
  const booking = bookings.find((b) => b.id === req.params.id);
  if (!booking) {
    return res.status(404).json({ success: false, message: 'Không tìm thấy booking' });
  }

  const { status, paymentStatus } = req.body;
  if (status) booking.status = status;
  if (paymentStatus) booking.paymentStatus = paymentStatus;

  console.log(`[UPDATE BOOKING STATUS] id=${booking.id} status=${booking.status} paymentStatus=${booking.paymentStatus}`);
  res.json({ success: true, message: 'Cập nhật trạng thái booking thành công', data: booking });
});

// GET /bookings - Lấy danh sách bookings
app.get('/bookings', (req, res) => {
  const { userId } = req.query;
  const result = userId ? bookings.filter((b) => b.userId === userId) : bookings;
  res.json({ success: true, total: result.length, data: result });
});

// GET /bookings/:id - Lấy chi tiết booking
app.get('/bookings/:id', (req, res) => {
  const booking = bookings.find((b) => b.id === req.params.id);
  if (!booking) {
    return res.status(404).json({ success: false, message: 'Không tìm thấy booking' });
  }
  res.json({ success: true, data: booking });
});

// ===================== START =====================
app.listen(PORT, HOST, () => {
  console.log(`✅ Booking Service running on http://${HOST}:${PORT}`);
  console.log(`   Initial bookings: ${bookings.length}`);
});
