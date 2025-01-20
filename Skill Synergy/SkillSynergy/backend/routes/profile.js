// routes/profile.js
const express = require('express');
const router = express.Router();
const pool = require('../database/db');

// Save user profile
router.post('/', async (req, res) => {
  const { name, skills } = req.body;
  try {
    const result = await pool.query('INSERT INTO users (name, skills) VALUES ($1, $2) RETURNING *', [name, skills]);
    res.json(result.rows[0]);
  } catch (err) {
    res.status(500).send(err.message);
  }
});

module.exports = router;
