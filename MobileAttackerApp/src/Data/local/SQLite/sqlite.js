import * as SQLite from 'expo-sqlite';

const db = SQLite.openDatabase('MainDB');

export const setupDatabase = async () => {
  db.transaction(tx => {
    tx.executeSql(
      'CREATE TABLE IF NOT EXISTS Location (id INTEGER PRIMARY KEY AUTOINCREMENT, latitude REAL, longitude REAL, idUser INTEGER);'
    );
  });
};

export const saveLocation = (coordenadas) => {
  return new Promise((resolve, reject) => {
    db.transaction(tx => {
      tx.executeSql(
        'INSERT INTO Location (latitude, longitude, idUser) VALUES (?, ?, ?);',
        [coordenadas.latitude, coordenadas.longitude, coordenadas.idUser],
        (_, result) => {
          // Si la inserción fue exitosa, result.rowsAffected será mayor que 0
          if (result.rowsAffected > 0) {
            resolve(true);
          } else {
            resolve(false);
          }
        },
        (_, error) => {
          // Si hay un error, rechaza la promesa
          reject(error);
        }
      );
    });
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
  return new Promise((resolve, reject) => {
    db.transaction(tx => {
      tx.executeSql(
        'DELETE FROM Location;',
        [],
        (_, result) => {
          // Si la operación fue exitosa, result.rowsAffected debería ser mayor a 0
          if (result.rowsAffected > 0) {
            resolve(true);
          } else {
            resolve(false);
          }
        },
        (_, error) => {
          // En caso de error, rechazamos la promesa
          reject(error);
        }
      );
    });
  });
};