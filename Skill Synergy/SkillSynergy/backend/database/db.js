// database/db.js
const { Pool } = require('pg');

const pool = new Pool({
  user: 'postgres',
  host: 'localhost',
  database: 'skill_synergy',
  password: 'password',
  port: 5432,
});

module.exports = pool;
