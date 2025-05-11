import { useState } from 'react';
import axios from 'axios';

const EntradaVehiculo = () => {
  const [vehiculo, setVehiculo] = useState({ placa: '', tipo: '', color: '', idU: '' });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setVehiculo({ ...vehiculo, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/api/vehiculo/entrada', vehiculo);
      alert('Vehículo registrado correctamente');
    } catch (error) {
      console.error('Error al registrar vehículo:', error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="placa" placeholder="Placa" onChange={handleChange} required />
      <input name="tipo" placeholder="Tipo" onChange={handleChange} required />
      <input name="color" placeholder="Color" onChange={handleChange} required />
      <input name="idU" placeholder="ID Usuario" onChange={handleChange} required />
      <button type="submit">Registrar Entrada</button>
    </form>
  );
};

export default EntradaVehiculo;
