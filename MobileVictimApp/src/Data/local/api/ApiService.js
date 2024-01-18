
import axios from 'axios';

export const apiClient = axios.create({
  baseURL: 'https://attackervictim.ngrok.app/cmcapp-backend-1.0/api',
  headers: {
    'Content-Type': 'application/json',
  },
});


