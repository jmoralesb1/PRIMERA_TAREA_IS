import axios from 'axios';

const API = axios.create({
  baseURL: 'http://localhost:8080/api',
});

export const registrarEntrada = (vehiculo) => API.post('/vehiculo/create', vehiculo);
export const obtenerRegistrosActivos = () => API.get('/vehiculos/all');
// Registrar la salida de un vehículo
export const registrarSalida = (data) => API.post('/registro/salida', data);