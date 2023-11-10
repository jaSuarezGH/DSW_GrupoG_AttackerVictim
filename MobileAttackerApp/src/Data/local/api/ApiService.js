
import axios from 'axios';

export const apiClient = axios.create({
  baseURL: 'https://cad8e4dd-1879-4c34-9159-658c70d741a8.mock.pstmn.io',
  headers: {
    'Content-Type': 'application/json',
  },
});


