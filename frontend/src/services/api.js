import axios from 'axios';

const API = axios.create({
  baseURL: 'http://localhost:8080/api',
});

export const registrarEntrada = (vehiculo) => API.post('/vehiculo/create', vehiculo);
export const obtenerUsuarios = () => API.get('/usuario/all');
export const obtenerRegistrosActivos = () => API.get('/registro/activos');
export const registrarSalida = (idRegistro) => API.post(`/registro/salida/${idRegistro}`);
