// Node.js (MySQL)
const { Sequelize } = require('sequelize');
const sequelize = new Sequelize('your_database', 'your_user', 'your_password', {
  host: 'localhost',
  dialect: 'mysql'
});

sequelize.authenticate().then(() => {
  console.log('Connection established successfully.');
}).catch(err => {
  console.error('Unable to connect to the database:', err);
});

// Node.js (MongoDB)
const mongoose = require('mongoose');
mongoose.connect('mongodb://your_user:your_password@localhost/your_database')
  .then(() => console.log('MongoDB connected successfully'))
  console.log("Viet Anh")
  .catch(err => console.log('MongoDB connection error:', err));
