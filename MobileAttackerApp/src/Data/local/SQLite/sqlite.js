import * as SQLite from 'expo-sqlite';

const db = SQLite.openDatabase('MainDB');

export const setupDatabase = async () => {
  db.transaction(tx => {
    tx.executeSql(
      'CREATE TABLE IF NOT EXISTS Location (id INTEGER PRIMARY KEY AUTOINCREMENT, latitude REAL, longitude REAL);'
    );
  });
};

export const saveLocation = async (latitude, longitude) => {
  db.transaction(tx => {
    tx.executeSql('INSERT INTO Location (latitude, longitude) VALUES (?, ?);', [latitude, longitude]);
  });
};

export const getLocations = async () => {
  return new Promise((resolve, reject) => {
    db.transaction(tx => {
      tx.executeSql('SELECT * FROM Location;', [], (_, { rows }) => resolve(rows._array));
    });
  });
};

export const deleteLocations = async () => {
  db.transaction(tx => {
    tx.executeSql('DELETE FROM Location;');
  });
};