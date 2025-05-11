import React, { useState } from 'react';
import axios from 'axios';

const Entrada = () => {
  const [vehiculo, setVehiculo] = useState({
    placa: '',
    tipo: '',
    color: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setVehiculo({ ...vehiculo, [name]: value });
  };

  const handleSubmit = async (e) => {
  e.preventDefault();
  try {
    const response = await axios.post('http://localhost:8080/api/vehiculos/crear', vehiculo);
    alert(response.data); // mostrará: "Vehículo registrado. Celda asignada: A1"
    setVehiculo({ placa: '', tipo: '', color: '' });
    
  } catch (err) {
    alert('Error registrando el vehículo. Verifica si hay celdas disponibles.');
    console.error(err);
  }
};


  return (
    <div>
      <h2>Registrar Entrada</h2>
      <form onSubmit={handleSubmit}>
        <input name="placa" value={vehiculo.placa} onChange={handleChange} placeholder="Placa" required />
        <input name="tipo" value={vehiculo.tipo} onChange={handleChange} placeholder="Tipo" required />
        <input name="color" value={vehiculo.color} onChange={handleChange} placeholder="Color" required />
        <button type="submit">Registrar Entrada</button>
      </form>
    </div>
  );
};

export default Entrada;


