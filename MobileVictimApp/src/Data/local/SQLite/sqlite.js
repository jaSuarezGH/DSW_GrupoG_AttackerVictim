import * as SQLite from 'expo-sqlite';

const db = SQLite.openDatabase('MainDB');

export const setupDatabase = async () => {
  db.transaction(tx => {
    tx.executeSql(
      'CREATE TABLE IF NOT EXISTS Location (id INTEGER PRIMARY KEY AUTOINCREMENT, latitude REAL, longitude REAL, fecha INTEGER);'
    );
  });
};

export const saveLocation = (coordenadas) => {
  return new Promise((resolve, reject) => {
    db.transaction(tx => {
      tx.executeSql(
        'INSERT INTO Location (latitude, longitude, fecha) VALUES (?, ?, ?);',
        [coordenadas._latitude, coordenadas._longitude, coordenadas._full_date],
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

export const eliminarBaseDeDatos = async () => {
  db.transaction(tx => {
    tx.executeSql('DROP TABLE IF EXISTS Location;',[],
    
    () => console.log('Tabla eliminada'),
    (_, error) => console.log(error)
    );
  });
};