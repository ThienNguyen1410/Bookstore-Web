const sqlite3 = require('sqlite3').verbose();

let db = new sqlite3.Database('testDatabase',sqlite3.OPEN_READWRITE,(err) => {
 if(err){
  return console.error(err.message);
 }
 console.log('Connected to memory in SQLite Database');
});
db.serialize(() => {
 db.each(`Select * from book`,(err,row) => {
   if(err){
    console.error(err.message);
   }
   console.log(row);
 });
});
db.close((err) => {
 if(err){
  return console.error(error.message);
 }
 console.log('Close Connection');
 });

