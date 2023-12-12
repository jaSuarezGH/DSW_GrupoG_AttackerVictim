
import axios from 'axios';

export const apiClient = axios.create({
  baseURL: 'https://optimum-turkey-bold.ngrok-free.app/cmcapp-backend-1.0/api',
  headers: {
    'Content-Type': 'application/json',
  },
});


