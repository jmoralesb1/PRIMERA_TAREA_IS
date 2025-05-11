import React from 'react';
import axios from 'axios';
import IngresarVehiculo from '../components/IngresarVehiculo'; // Importa el componente estilizado

const Entrada = () => {
  const handleRegistrarEntrada = async (vehiculo) => {
    try {
      const response = await axios.post('http://localhost:8080/api/vehiculos/crear', vehiculo);
      alert(response.data); // mostrará: "Vehículo registrado. Celda asignada: A1"
    } catch (err) {
      alert('Error registrando el vehículo. Verifica si hay celdas disponibles.');
      console.error(err);
    }
  };

  const handleSalir = () => {
    alert('Regresando al menú principal...');
    // Aquí podrías redirigir al usuario al menú principal o realizar otra acción.
  };

  return (
    <div>
      <IngresarVehiculo
        onIngresar={handleRegistrarEntrada}
        onSalir={handleSalir}
      />
    </div>
  );
};

export default Entrada;

