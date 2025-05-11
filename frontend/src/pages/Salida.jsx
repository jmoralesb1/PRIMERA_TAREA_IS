import React from 'react';
import axios from 'axios';
import SalidaVehiculo from '../components/SalidaVehiculo'; // Importamos el nuevo componente

const Salida = () => {
  const handleRetirarVehiculo = async (placa) => {
    try {
      const response = await axios.post('http://localhost:8080/api/vehiculos/salida', { placa });
      alert(response.data); // Mostrará el mensaje del backend al retirar el vehículo
    } catch (err) {
      alert('Error al retirar el vehículo. Verifica si la placa existe.');
      console.error(err);
    }
  };

  return (
    <div>
      <SalidaVehiculo onRetirar={handleRetirarVehiculo} />
    </div>
  );
};

export default Salida;